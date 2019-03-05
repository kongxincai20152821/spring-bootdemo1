<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台主页</title>
<script type="text/javascript">
   $(function(){
	   $("#nav a").click(function(){
		   var url=$(this).attr("url");
		   var title=$(this).text();
		   if($("#tt").tabs("exists",title)){
			   $("#tt").tabs("select",title)
		   }else{
			   $("#tt").tabs('add',{    
				    title:title,    
				    content:"<iframe src=\""+url+"\" style='width:100%;height:100%' frameborder='0'><iframe>",    
				    closable:true    
				});
		   }
		   //$.messager.alert("提示消息",title,"info");
	   });
	   
   });
</script>
</head>
<body  class="easyui-layout">
    <div data-options="region:'north',split:false" style="height:100px;"></div>   
    <div data-options="region:'south',split:false" style="height:100px;"></div>   
    <div data-options="region:'west',title:'导航菜单',split:false" style="width:150px;" class="iconCls:icon-ok">
	   <div id="nav" class="easyui-accordion" fit="true">  
	        <div title="系统管理" data-options="iconCls:'icon-save'" style="">   
		             
		    </div>   
		    <div title="人员管理" data-options="iconCls:'icon-reload',selected:true">   
		             <ul class="easyui-tree" fit="true">
				           <li><a href="#" url="student.jsp">学生管理</a></li>
				           <li><a href="#" url="classes.jsp">班级管理</a></li>
				      </ul>
		    </div>   
		     
		    <div title="人事调动管理" data-options="iconCls:'icon-save'" style="">   
		        <ul class="easyui-tree" fit="true">
				 </ul>   
		    </div>  
		    
		    <div title="教育培训管理" data-options="iconCls:'icon-save'" style="">   
		        <ul class="easyui-tree" fit="true">
				 </ul>    
		    </div> 
		    
		    <div title="用户管理" data-options="iconCls:'icon-save',selected:true" style="">   
		        <ul class="easyui-tree" fit="true">
				 </ul>    
		    </div>
		</div>  
    </div>   
    <div data-options="region:'center'" style="background:#eee;" border="0">
         <div id="tt" class="easyui-tabs" data-options="plain:false" style="width:500px;height:250px;" fit="true" border="false">   
				    <div title="欢迎页" style="text-align:center;font-size: 20px;">   
				                人力资源系统欢迎你
				    </div>         
		 </div>      
    </div>   
</body>
</html>