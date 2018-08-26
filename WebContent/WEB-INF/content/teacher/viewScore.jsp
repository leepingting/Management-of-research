<%@ page contentType="text/html; charset=gb2312" language="java" %>
<%@ page import="java.util.*" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	   <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	   <title>查看教师总分</title>
</head>
<body>
<%
  String TID=(String)session.getAttribute("TID");
  String TName=(String)session.getAttribute("TName");
  Double TScore=(Double)session.getAttribute("TScore");
%>
<%@include file="../header.jsp"%>
<%@include file="teaheader.jsp"%>
<table width="80%" border="0" align="center"
	cellspacing="1" bgcolor="#cccccc">
  <tr bgcolor="#e1e1e1"  class="pt11" height="45">
	<td><b>教师编号</b></td>
	<td><b>教师姓名</b></td>
	<td><b>教师分数</b></td>	
  </tr>
  
  <s:iterator value="teachers" status="index">  
 	<s:if test="#index.odd == true"> 
		 <tr style="background-color:#dddddd" class="pt11" height="25">
	</s:if> 
	<s:else> 
		 <tr class="pt11" height="25">
	</s:else>
	<tr>
	<td><s:property value="TID"/></td>
	<td><s:property value="TName"/></td>	
	<td><s:property value="TScore"/></td>	
	</tr>
 </s:iterator>
</table>
<br><br>
</body>
</html>