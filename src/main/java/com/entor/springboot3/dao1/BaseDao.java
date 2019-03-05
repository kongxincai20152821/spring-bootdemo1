package com.entor.springboot3.dao1;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
	   public void add(T t);
	   public void addMore(List<T> t);
	   public void delete(Class<?> cls,Serializable id);
	   public void deleteMore(Class<?> cls,String ids);
	   public void update(Class<?> cls,T id);
	   public T queryById(Class<?> cls,Serializable id);
	   public List<T> queryAll(Class<?> cls);
	   public List<T> queryByPage(Class<?> cls,Map<String,Object> map);
	   public int getTotals(Class<?> cls);
}
