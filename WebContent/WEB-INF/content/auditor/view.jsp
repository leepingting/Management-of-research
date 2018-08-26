<%@ page contentType="text/html; charset=gb2312" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("gb2312");%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
   <title>查询科研信息</title>
   <script type="text/javascript">
   		function viewbytea()
		{
			targetForm=document.forms[0];
			targetForm.action="viewbytea";
		}

		function viewbypaname()
		{
			targetForm=document.forms[0];
			targetForm.action="viewbypaname";
		}
		function viewbyprname()
		{
			targetForm=document.forms[0];
			targetForm.action="viewbyprname";
		}
   </script>
</head>
<body>
<%@include file="../header.jsp"%>
<%@include file="audheader.jsp"%>
<br><br><br>
<form action="view.action" method="post">
<table align="center">
	<tr>
		<td>通过教师编号查询</td>
		<td><input type="text" name="TID"/></td>
		<td><input type="submit" value="查询" onclick="viewbytea()"></td>
	</tr>
	<tr>
		<td>通过论文题目查询</td>
		<td><input type="text" name="paName"/></td>
		<td><input type="submit" value="查询" onclick="viewbypaname()"></td>
	</tr>
	<tr>
		<td>通过项目题目查询</td>
		<td><input type="text" name="prName"/></td>
		<td><input type="submit" value="查询" onclick="viewbyprname()"></td>
	</tr>
</table>	
</body>
</html>