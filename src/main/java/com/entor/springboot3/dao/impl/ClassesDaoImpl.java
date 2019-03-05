package com.entor.springboot3.dao.impl;

import org.springframework.stereotype.Repository;

import com.entor.springboot3.dao1.ClassesDao;
import com.entor.springboot3.entity.Classes;
@Repository("classesDao")
public class ClassesDaoImpl extends BaseDaoImpl<Classes> implements ClassesDao{

}
