package com.entor.springboot3.test;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.springboot3.entity.Student;
import com.entor.springboot3.service1.StudentService;

public class TestStudentMain {

	public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService dao=(StudentService)ac.getBean("studentService");
        
        Student s=new Student();
        s.setName("lijie");
        s.setUsername("李杰11111");
        s.setPassword("123");
        s.setAge(23);
        s.setSex(0);
        s.setBirthday(new Date());
        s.setCreateTime(new Timestamp(System.currentTimeMillis()));
        
        dao.add(s);
        System.out.println("添加成功");
        
        /*List<Student> list=new ArrayList<>();
        for(int i=0;i<100;i++) {
	        Student s=new Student();
	        s.setName("lijie"+i);
	        s.setUsername("李杰"+i);
	        s.setPassword("123"+i);
	        s.setAge(23);
	        s.setSex(i%2);
	        s.setBirthday(new Date());
	        s.setCreateTime(new Timestamp(System.currentTimeMillis()));
	        list.add(s);
        }
        
        dao.addMore(list);*/
        
        /*Student s=dao.queryById(10017);
        System.out.println(s);*/
        
        /*Student s=new Student();
        s.setId(10017);
        s.setName("lijie1");
        s.setUsername("李杰1");
        s.setPassword("1231");
        s.setAge(23);
        s.setSex(1);
        s.setBirthday(new Date());
        s.setCreateTime(new Timestamp(System.currentTimeMillis()));
        dao.update(s);*/
        
        /*dao.delete(10017);*/
        
        /*String s="10013,10014";
        dao.deleteMore(s);*/
        
        /*List<Student> s=dao.queryAll();
        for(Student s1:s) {
        	System.out.println(s1);
        }*/
        
        /*Map<String,Object> map=new HashMap<>();
        map.put("start", 10);
        map.put("pageSize", 5);
        List<Student> list=dao.queryByPage(map);
        for(Student s2:list) {
        	System.out.println(s2);
        }*/
        
        /*int s=dao.getTotals();
        System.out.println(s);*/
        
	}

}
