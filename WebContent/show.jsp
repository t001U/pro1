<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/de.js"></script>
<script type="text/javascript" src="js/"></script>
<script type="text/javascript">
	function upd(id) {
		window.location.href="upinves.jsp?id="+id;
	}
</script>
</head>
<body>
	<form action="add?opr=2" method="post">
		勘查意见<input type="text"  name="chk_option" /> 
		<input type="submit" value="查找" id = "btnSe"/>
		<a href="Addsinevs.jsp">新增信息</a>
	</form>
	<table border="1px">
		<tr>
			<th>勘查标识</th>
			<th>勘查意见</th>
			<th>勘查员</th>
			<th>勘查日期</th>
			<th>有无违约用电行为</th>
			<th>违约用电行为描述</th>
			<th>勘查备注</th>
			<th>申请编号</th>
			<th>重要性等级</th>
			<th>重要用户档案描述</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list}" var="li">
			<tr>
				<td>${li.chk_id}</td>
				<td>${li.chk_option}</td>
				<td>${li.chk_name}</td>
				<td>${li.chk_date}</td>
				<td>${li.violat_flag}</td>
				<td>${li.violate_cesc}</td>
				<td>${li.chk_remark}</td>
				<td>${li.app_no}</td>
				<td>${li.prio_code}</td>
				<td>${li.keycons_file}</td>
				<td>
				<a href="javascript:del(${li.chk_id })">删除</a>
				<a href="javascript:upd(${li.chk_id })">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>