package com.felix.learn.datasource.aop;

import com.felix.learn.datasource.datasource.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: felix.fan
 * @date: 2019/10/23 21:35
 */
@Aspect
@Component
public class DataSourceAspect {

    @Pointcut("!@annotation(com.felix.learn.datasource.annotation.Master) " +
            "&& (execution(* com.felix.learn.datasource.service..*.select*(..)) " +
            "|| execution(* com.felix.learn.datasource.service..*.get*(..)) " +
            "|| execution(* com.felix.learn.datasource.service..*.find*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.felix.learn.datasource.annotation.Master) " +
            "|| execution(* com.felix.learn.datasource.service..*.insert*(..)) " +
            "|| execution(* com.felix.learn.datasource.service..*.add*(..)) " +
            "|| execution(* com.felix.learn.datasource.service..*.update*(..)) " +
            "|| execution(* com.felix.learn.datasource.service..*.edit*(..)) " +
            "|| execution(* com.felix.learn.datasource.service..*.delete*(..)) " +
            "|| execution(* com.felix.learn.datasource.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.switchSlave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.switchMaster();
    }
}