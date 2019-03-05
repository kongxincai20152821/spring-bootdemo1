package com.entor.springboot3.service.impl;

import org.springframework.stereotype.Service;

import com.entor.springboot3.entity.Student;
import com.entor.springboot3.service1.StudentService;
@Service("studentService")
public class StudentServiceImpl extends BaseServiceImpl<Student> implements StudentService{
}
