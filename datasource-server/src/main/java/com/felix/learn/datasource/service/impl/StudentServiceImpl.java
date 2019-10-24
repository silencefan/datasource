package com.felix.learn.datasource.service.impl;

import com.felix.learn.datasource.annotation.Master;
import com.felix.learn.datasource.entity.Student;
import com.felix.learn.datasource.mapper.StudentMapper;
import com.felix.learn.datasource.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: felix.fan
 * @date: 2019/10/23 21:21
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public Student findById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertStudent(Student student) {
        studentMapper.insertSelective(student);
        return student.getId();
    }

    @Override
    public int deleteStudent(Integer id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public List<Student> selectList() {
        List<Student> students = studentMapper.selectAll();
        return students;
    }
}