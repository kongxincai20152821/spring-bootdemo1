package com.entor.springboot3.service1;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {
	   public void add(T t);
	   public void addMore(List<T> t);
	   public void delete(Class<?> cls,Serializable id);
	   public void deleteMore(Class<?> cls,String ids);
	   public void update(Class<?> cls,T id);
	   public T queryById(Class<?> cls,Serializable id);
	   public List<T> queryAll(Class<?> cls);
	   public List<T> queryByPage(Class<?> cls,int currentPage,int pageSize,String qid,String qname,String qusername,String qsex,String qstartdate,String qenddate);
	   public int getTotals(Class<?> cls);
}
