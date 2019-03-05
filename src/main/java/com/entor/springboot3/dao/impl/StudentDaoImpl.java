package com.entor.springboot3.dao.impl;

import org.springframework.stereotype.Repository;

import com.entor.springboot3.dao1.StudentDao;
import com.entor.springboot3.entity.Student;
@Repository("studentDao")
public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao{
}
