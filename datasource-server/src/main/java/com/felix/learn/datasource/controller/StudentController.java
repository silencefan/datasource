package com.felix.learn.datasource.controller;

import com.alibaba.fastjson.JSON;
import com.felix.learn.datasource.datasource.DBContextHolder;
import com.felix.learn.datasource.entity.Student;
import com.felix.learn.datasource.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: felix.fan
 * @date: 2019/10/23 21:17
 */
@RestController
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/insert/{name}")
    public String insert(@PathVariable(value = "name") String name) {
        Student student = new Student();
        student.setName(name);
        return studentService.insertStudent(student) + "";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id") Integer id) {
        return studentService.deleteStudent(id) + "";
    }

    @GetMapping(value = "/update/{id}")
    public String update(@PathVariable(value = "id") Integer id) {
        Student student = new Student();
        student.setId(id);
        student.setName("test update");
        return studentService.updateStudent(student) + "";
    }

    @GetMapping(value = "/find/{id}")
    public String find(@PathVariable(value = "id") Integer id) {
        Student student = studentService.findById(id);
        return JSON.toJSONString(student);
    }

    @GetMapping(value = "/list")
    public String list() {
        List<Student> students = studentService.selectList();
        return JSON.toJSONString(students);
    }
}