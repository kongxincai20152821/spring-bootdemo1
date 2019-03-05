package com.entor.springboot3.service.impl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.springboot3.dao1.BaseDao;
import com.entor.springboot3.service1.BaseService;
@Service("baseService")
public class BaseServiceImpl<T> implements BaseService<T>{
    @Resource
    private BaseDao<T> baseDao1;
	@Override
	public void add(T t) {
		baseDao1.add(t);
	}

	@Override
	public void addMore(List<T> t) {
		baseDao1.addMore(t);
	}

	@Override
	public void delete(Class<?> cls, Serializable id) {
		baseDao1.delete(cls, id);
	}

	@Override
	public void deleteMore(Class<?> cls, String ids) {
		baseDao1.deleteMore(cls, ids);
	}

	@Override
	public void update(Class<?> cls, T id) {
		baseDao1.update(cls, id);
	}

	@Override
	public T queryById(Class<?> cls, Serializable id) {
		return baseDao1.queryById(cls, id);
	}

	@Override
	public List<T> queryAll(Class<?> cls) {
		return baseDao1.queryAll(cls);
	}

	@Override
	public List<T> queryByPage(Class<?> cls, int currentPage, int pageSize,String qid,String qname,String qusername,String qsex,String qstartdate,String qenddate) {
		Map<String,Object> map=new HashMap<>(); 
		map.put("start", (currentPage-1)*pageSize);
		map.put("pageSize", pageSize);
		if(!"".equals(qid)) {
		  map.put("qid", Integer.parseInt(qid));
		}
		if(!"".equals(qname)) {
			  map.put("qname", qname);
		}
		if(!"".equals(qusername)) {
			  map.put("qusername",qusername);
		}
		if(!"".equals(qsex)) {
			  map.put("qsex", Integer.parseInt(qsex));
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(!"".equals(qstartdate)) {
			  map.put("qstartdate",sdf.format(qstartdate) );
		}
		if(!"".equals(qenddate)) {
			  map.put("qenddate",sdf.format(qenddate) );
		}
		return baseDao1.queryByPage(cls, map);
	}

	@Override
	public int getTotals(Class<?> cls) {
		return baseDao1.getTotals(cls);
	}

	
}
