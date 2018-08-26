<%@ page contentType="text/html; charset=gb2312" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("gb2312");%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	   <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	   <title>提出项目申请</title>
	</head>
	<body>
		<%@include file="../header.jsp"%>
		<%@include file="teaheader.jsp"%>	
		<br><br><br>
		<form action="markPro.action" method="post">
			<table align="center">
				<tr>
					<td colspan="2" align="center">请输入项目信息</td>
				</tr>
				<tr>
					<td>项目题目</td>
					<td><input type="text" name="prName"/></td>
				</tr>
				<tr>
					<td>项目级别</td>
					<td>
						<input type="radio" name="prLevel" value="1" checked/>校级
						<input type="radio" name="prLevel" value="2"/>省级
						<input type="radio" name="prLevel" value="3"/>国家级
					</td>
				</tr>
				<tr>
					<td>经费</td>
					<td><input type="text" name="prFunding"/></td>
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
