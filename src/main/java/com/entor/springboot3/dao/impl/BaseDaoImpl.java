package com.entor.springboot3.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.entor.springboot3.dao1.BaseDao;
@Repository("baseDao1")
public class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T>{
	@Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    	super.setSqlSessionFactory(sqlSessionFactory);
    }

	@Override
	public void add(T t) {
		getSqlSession().insert(t.getClass().getSimpleName()+".add",t);
	}

	@Override
	public void addMore(List<T> t) {
		getSqlSession().insert(t.getClass().getSimpleName()+".addMore",t);
	}

	@Override
	public void delete(Class<?> cls, Serializable id) {
		getSqlSession().delete(cls.getSimpleName()+".delete",id);
	}

	@Override
	public void deleteMore(Class<?> cls, String ids) {
		getSqlSession().delete(cls.getSimpleName()+".deleteMore",ids.split(","));
	}

	@Override
	public void update(Class<?> cls, T id) {
		getSqlSession().update(cls.getSimpleName()+".update",id);
	}

	@Override
	public T queryById(Class<?> cls, Serializable id) {
		return getSqlSession().selectOne(cls.getSimpleName()+".queryById",id);
	}

	@Override
	public List<T> queryAll(Class<?> cls) {
		return getSqlSession().selectList(cls.getSimpleName()+".queryAll");
	}

	@Override
	public List<T> queryByPage(Class<?> cls, Map<String, Object> map) {
		return getSqlSession().selectList(cls.getSimpleName()+".queryByPage",map);
	}

	@Override
	public int getTotals(Class<?> cls) {
		return getSqlSession().selectOne(cls.getSimpleName()+".getTotals");
	}

}
