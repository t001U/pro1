<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页查询记录</title>
<script src = "js/jquery-1.12.4.js" type="text/javascript"></script>
<script src = "js/show.js" type="text/javascript"></script>
</head>
<body>
	<h2>当前操作：查询交易记录。请选择时间范围后点“查询”按钮</h2>
	<div>
		查询日期范围：
		<input type = "text" id = "startDate" />
		到
		<input type = "text" id = "endDate" />
		<input type = "button" value = "查询" id = "cxbtn" />
	</div>
	<table border = "1px" cellspacing="0px" cellpadding = "0px" width = "700px">
		<tr>
			<th>交易日期</th>
			<th>支出</th>
			<th>存入</th>
			<th>账户余额</th>
			<th>交易类型</th>
			<th>备注</th>
		</tr>
	</table>
</body>
</html>