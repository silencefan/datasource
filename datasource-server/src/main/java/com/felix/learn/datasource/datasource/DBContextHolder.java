package com.felix.learn.datasource.datasource;

import com.felix.learn.datasource.enums.DBTypeEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: felix.fan
 * @date: 2019/10/23 20:47
 */
@Slf4j
public class DBContextHolder {

    private static final ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<>();

    private static final AtomicInteger counter = new AtomicInteger(-1);

    private static final int INCREMENT_MAX_COUNT = 9999;

    public static void set(DBTypeEnum dbType) {
        contextHolder.set(dbType);
    }

    public static DBTypeEnum get() {
        return contextHolder.get();
    }

    public static void switchMaster() {
        set(DBTypeEnum.MASTER);
        log.info("数据源切换到master");
    }

    /**
     * 两个slave轮询
     */
    public static void switchSlave() {
        int index = counter.getAndIncrement() % 2;
        if (counter.get() > INCREMENT_MAX_COUNT) {
            counter.set(-1);
        }
        if (index == 0) {
            set(DBTypeEnum.SLAVE1);
            log.info("数据源切换到slave1");
        } else {
            set(DBTypeEnum.SLAVE2);
            log.info("数据源切换到slave2");
        }
    }
}