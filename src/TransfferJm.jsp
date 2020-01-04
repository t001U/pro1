<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>转账界面</title>
<script src = "js/jquery-1.12.4.js" type="text/javascript"></script>
<script src = "js/transffer.js" type="text/javascript"></script>
</head>
<body>
	<h2>当前操作：转账。请输入转入账号和金额后点“转账按钮”</h2>
	<div id = "transffer">
		转入账号：
		<input type = "text" id = "zrzh" />
		<br />
		转账金额：
		<input type = "text" id = "zzje" />
		<br />
		<br />
		<input type = "submit" value = "转账" id ="zz" />
	</div>
</body>
</html>