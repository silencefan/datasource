package com.felix.learn.datasource.service;

import com.felix.learn.datasource.entity.Student;

import java.util.List;

/**
 * @author: felix.fan
 * @date: 2019/10/23 21:19
 */
public interface StudentService {

    int insertStudent(Student student);

    int deleteStudent(Integer id);

    int updateStudent(Student student);

    Student findById(Integer id);

    List<Student> selectList();
}