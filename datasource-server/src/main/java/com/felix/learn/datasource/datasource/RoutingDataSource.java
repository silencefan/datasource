package com.felix.learn.datasource.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

/**
 * @author: felix.fan
 * @date: 2019/10/23 20:46
 */
@Slf4j
public class RoutingDataSource extends AbstractRoutingDataSource {

    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        log.info("当前数据源key: {}", DBContextHolder.get());
        return DBContextHolder.get();
    }
}