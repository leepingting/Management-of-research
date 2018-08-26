<%@ page contentType="text/html; charset=gb2312" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>教师首页</title>
</head>
<body>
<%@include file="../header.jsp"%> 
<%@include file="teaheader.jsp"%> 
<table width="960" align="center" >
  <tr height="60">
	<td>&nbsp;</td>
  </tr>
  
  <tr height="80">
	<td>&nbsp;</td>
  </tr>
  <tr>
	<td><s:property value="#session.user"/>
	，欢迎您使用科研管理信息系统，您是教师</td>
  </tr>
  <tr height="60">
	<td>&nbsp;</td>
  </tr>
</table>
</body>
</html>
