<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="js/jQuery2.1.1.js"></script>

  </head>
  
  <body>
  	报表名称:<input type="text" name="rpt_name" id="rpt_name"><br/>
  	报告类型:<input type="text" name="rpt_type" id="rpt_type"><br/>
  	报告用途:<input type="text" name="rpt_usage" id="rpt_usage"><br/>
  	报告年月:<input type="text" name="rpt_ym" id="rpt_ym"><br/>
  	生成时间:<input type="date" name="make_time" id="make_time"><br/>
  	报告状态:<input type="text" name="status_code" id="status_code"><br/>
  	<input type="button" value="保存" id="btnAdd">
  </body> 
  
   <script type="text/javascript">
  	function load(){
  		$.ajax({
  			type:"post",
  			url:"SInvestigateServlet",//查询数据的servlet地址
  			data:{
  			  opr:4,
  			  id:$("#rpt_no").val() 
  			},
  			dataType:"json",
  			success:function(res){//将查询出的数据赋给文本框
  				$("#rpt_no").val(res.rpt_no);
  				$("#rpt_name").val(res.rpt_name);
  				$("#rpt_type").val(res.rpt_type);
  				$("#rpt_usage").val(res.rpt_usage);
  				$("#rpt_ym").val(res.rpt_ym);
  				$("#make_time").val(res.make_time);
  				$("#status_code").val(res.status_code);
  			},
  			error:function(){
  				alert("ajax错误");
  			}
  		});
  	}
  </script>
  
  
  
  
  <script type="text/javascript">
  	$("document").ready(function(){
  		$("#btnAdd").click(function(){
  			$.ajax({
  				type:"post",//数据提交方式 get post
  				url:"<%=basePath%>SInvestigateServlet",//数据提交的地址 servlet
  				data:{ //提交的数据
  					opr:1,//1 代表添加功能
  					rpt_name:$("#rpt_name").val(),
  					rpt_type:$("#rpt_type").val(),
  					rpt_usage:$("#rpt_usage").val(),
  					rpt_ym:$("#rpt_ym").val(),
  					make_time:$("#make_time").val(),
  					status_code:$("#status_code").val(),
  				},
  				dataType:"json", //提交数据的格式json,xml
  				success:function(res){
  					if(res>0){
  						alert("修改成功");
  					}else{
  						alert("修改失败");
  					}
  				},
  				error:function(){
  					alert("ajax执行错误！");
  				}
  			});
  		});
  	});
  </script>
</html>
