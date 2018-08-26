<%@ page contentType="text/html; charset=gb2312" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("gb2312");%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
   <title>提出论文申请</title>
</head>
<body>
<%@include file="../header.jsp"%>
<%@include file="teaheader.jsp"%>	
<br><br><br>
<form action="markPap.action" method="post">
<table align="center">
	<tr>
		<td colspan="2" align="center">请输入论文信息</td>
	</tr>
	<tr>
		<td>论文题目</td>
		<td><input type="text" name="paName"/></td>
	</tr>
	<tr>
		<td>论文级别</td>
		<td>
			<input type="radio" name="paLevel" value="1" checked/>普通
			<input type="radio" name="paLevel" value="2"/>核心
			<input type="radio" name="paLevel" value="3"/>EI
			<input type="radio" name="paLevel" value="4"/>SCI
		</td>
	</tr>
	<tr>
		<td>成员</td>
		<td><textarea name="member"></textarea></td>
	</tr>
	<tr>
		<td><input type="submit" value="计算分数"></td>
		<td><input type="reset" value="重填"/></td>
	</tr>
</table>
</form>
</body>
</html>
