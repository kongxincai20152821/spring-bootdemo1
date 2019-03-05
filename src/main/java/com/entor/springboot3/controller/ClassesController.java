package com.entor.springboot3.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.entor.springboot3.dao.impl.ClassesDaoImpl;
import com.entor.springboot3.dao1.ClassesDao;
import com.entor.springboot3.entity.Classes;
import com.entor.springboot3.service1.ClassesService;
import com.entor.springboot3.util.Pager;

@Controller
public class ClassesController {
	@Resource
	private ClassesService classesService;
	private HttpServletResponse response;
	private HttpServletRequest request;
	@ModelAttribute//调用任何方法前调用该方法
	  public void initDate(HttpServletRequest request,HttpServletResponse response) {
		  System.out.println("初始化参数");
		  this.response=response;
		  this.request=request;
	  } 
	
	@RequestMapping("/Classesadd")
	public void add(Classes s) throws IOException {
		classesService.add(s);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		JSONObject jo=new JSONObject();
		jo.put("state",0);
		jo.put("msg", "添加成功!");
		String s1=JSON.toJSONString(jo);
		pw.write(s1);
		pw.flush();
		pw.close();
	}

	@RequestMapping("/ClassesdeleteMore")
	public void deleteMore(String ids,String page,Map<String,Object> map) throws IOException {
		String qid=request.getParameter("qid");
		String qname=request.getParameter("qname");
		String qusername=request.getParameter("qusername");
		String qsex=request.getParameter("qsex");
		String qstartdate=request.getParameter("qstartdate");
		String qenddate=request.getParameter("qenddate");
		//ClassesDao dao=new ClassesDaoImpl();
		classesService.deleteMore(Classes.class,ids);
		map.put("qid", qid);
		map.put("qsex", qsex);
		map.put("qname", qname);
		map.put("qusername", qusername);
		map.put("qstartdate", qstartdate);
		map.put("qenddate", qenddate);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		JSONObject jo=new JSONObject();
		jo.put("state",0);
		jo.put("msg", "删除成功!");
		String s1=JSON.toJSONString(jo);
		pw.write(s1);
		pw.flush();
		pw.close();
	}

	@RequestMapping("/Classesupdate")
	public void update(Classes id,String page,Map<String,Object> map) throws IOException {
		String qid=request.getParameter("qid");
		String qname=request.getParameter("qname");
		String qusername=request.getParameter("qusername");
		String qsex=request.getParameter("qsex");
		String qstartdate=request.getParameter("qstartdate");
		String qenddate=request.getParameter("qenddate");
		//ClassesDao dao=new ClassesDaoImpl();
		classesService.update(Classes.class,id);
		map.put("qid", qid);
		map.put("qsex", qsex);
		map.put("qname", qname);
		map.put("qusername", qusername);
		map.put("qstartdate", qstartdate);
		map.put("qenddate", qenddate);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		JSONObject jo=new JSONObject();
		jo.put("state",0);
		jo.put("msg", "修改成功!");
		String s1=JSON.toJSONString(jo);
		pw.write(s1);
		pw.flush();
		pw.close();
	}

	@RequestMapping("/ClassesqueryById")
	public void queryById(String page,Map<String,Object> map,int id) {
		String qid=request.getParameter("qid");
		String qname=request.getParameter("qname");
		String qusername=request.getParameter("qusername");
		String qsex=request.getParameter("qsex");
		String qstartdate=request.getParameter("qstartdate");
		String qenddate=request.getParameter("qenddate");
		ClassesDao dao=new ClassesDaoImpl();
		Classes Classes=classesService.queryById(Classes.class,id);
		map.put("qid", qid);
		map.put("qsex", qsex);
		map.put("qname", qname);
		map.put("qusername", qusername);
		map.put("qstartdate", qstartdate);
		map.put("qenddate", qenddate);
		map.put("Classes", Classes);
	}
	
	@RequestMapping("/ClassesqueryByPage")
	public void queryByPage(String page,Map<String,Object> map) throws IOException {
		
		String qid=request.getParameter("qid");
		String qname=request.getParameter("qname");
		String qusername=request.getParameter("qusername");
		String qsex=request.getParameter("qsex");
		String qstartdate=request.getParameter("qstartdate");
		String qenddate=request.getParameter("qenddate");
		int rows=Integer.parseInt(request.getParameter("rows"));
		
		/*String condition = " ";
		if(qid!=null&&!qid.equals("")&&!qid.equalsIgnoreCase("null")){
			int qid1=Integer.parseInt(qid);
		}
		if(qname!=null&&!qname.equals("")&&!qname.equalsIgnoreCase("null")){
			condition += " and name like '%"+qname+"%'";
		}
		if(qusername!=null&&!qusername.equals("")&&!qname.equalsIgnoreCase("null")){
			condition += " and username like '%"+qusername+"%'";
		}
		if(qsex!=null&&!qsex.equals("")&&!qsex.equals("-1")&&!qname.equalsIgnoreCase("null")){
			condition += " and sex = "+qsex;
		}
		if(qstartdate!=null&&!qstartdate.equals("")) {
			condition += " and birthday >= '"+qstartdate+"'";
		}
		if(qenddate!=null&&!qenddate.equals("")) {
			condition += " and birthday <= '"+qenddate+"'";
		}*/
		
		Pager<Classes> pager=new Pager<Classes>(classesService.getTotals(Classes.class),page,rows);
		
		List<Classes> list=classesService.queryByPage(Classes.class,Integer.parseInt(page),pager.getPageSize(),qid,qname,qusername,qsex,qstartdate,qenddate);
		map.put("qid", qid);
		map.put("qname", qname);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		JSONObject jo=new JSONObject();
		jo.put("total", pager.totals);
		jo.put("rows", list);
		String s=JSON.toJSONString(jo);
		pw.write(s);
		pw.flush();
		pw.close();
	}
	@InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }
}
