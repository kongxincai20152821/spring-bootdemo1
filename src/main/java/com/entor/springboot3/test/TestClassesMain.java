package com.entor.springboot3.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.springboot3.entity.Classes;
import com.entor.springboot3.service1.ClassesService;
public class TestClassesMain {

	public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassesService dao=(ClassesService)ac.getBean("classesService");
        
        Classes s=new Classes();
        s.setName("UI前端");
        
        dao.add(s);
        System.out.println("添加成功");
        
        /*List<Classes> list=new ArrayList<>();
        for(int i=0;i<100;i++) {
	        Classes s=new Classes();
	        s.setName("java"+i);
	        list.add(s);
        }
        
        dao.addMore(list);*/
        
        /*Classes s=dao.queryById(10017);
        System.out.println(s);*/
        
        /*Classes s=new Classes();
        s.setId(10017);
        s.setName("c");
        dao.update(s);*/
        
        /*dao.delete(5);*/
        
        /*String s="6,7";
        dao.deleteMore(s);*/
        
        /*List<Classes> s=dao.queryAll();
        for(Classes s1:s) {
        	System.out.println(s1);
        }*/
        
        /*Map<String,Object> map=new HashMap<>();
        map.put("start", 10);
        map.put("pageSize", 5);
        List<Classes> list=dao.queryByPage(map);
        for(Classes s2:list) {
        	System.out.println(s2);
        }*/
        
        /*int s=dao.getTotals();
        System.out.println(s);*/
	}
}
