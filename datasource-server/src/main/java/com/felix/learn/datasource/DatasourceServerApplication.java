package com.felix.learn.datasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author: felix.fan
 * @date: 2019/10/23 16:30
 */
@SpringBootApplication
@MapperScan(value = "com.felix.learn.datasource.mapper")
public class DatasourceServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DatasourceServerApplication.class, args);
    }
}