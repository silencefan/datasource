package com.felix.learn.datasource.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String name;
}