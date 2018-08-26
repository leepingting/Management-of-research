<%@ page contentType="text/html; charset=gb2312" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>登录系统</title>
<s:head/>
</head>
<body>
<%@include file="header.jsp"%>
<table width="960" align="center">
<tr>
<td>
请输入用户名和密码来登录<br />
<s:if test="actionMessages.size()>0">
<div class="error">
	<s:actionmessage/>
</div>
</s:if>
<s:actionerror cssClass="error"/>
<div align="center">
<s:form action="login">
	<s:textfield name="user.UID" label="用户名" />
	<s:textfield name="user.password" label="密码" />
	<s:radio name="user.role" label="角色" 
		list="#{'1':'审核员','2':'教师'}" listKey="key" listValue="value"/>
	<tr><td colspan="2">
	<s:submit value="登录" theme="simple"/><s:reset  theme="simple" value="重填"/>
	</td></tr>
</s:form>
</div>
</td>
</tr>
</table>
</body>
</html>
