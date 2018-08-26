<%@ page contentType="text/html; charset=gb2312" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	   <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	   <title>审核论文</title>
	</head>
	<body>
	<s:if test="actionMessages.size()>0">
	<div class="error">
		<s:actionmessage/>
	</div>
	</s:if>
		<%@include file="../header.jsp"%>
		<%@include file="audheader.jsp"%>
		<table width="960" align="center">
			<tr>
				<td><br>
					<table width="80%" border="1" align="center" bgcolor="#cccccc">
						<tr class="pt11" height="45">
							<td><b>论文编号</b></td>
							<td><b>论文题目</b></td>
							<td><b>论文级别</b></td>
							<td><b>论文分数</b></td>
							<td><b>申报人编号</b></td>
							<td><b>教师编号&nbsp;&nbsp;教师角色&nbsp;&nbsp;教师分数</b></td>
							<td><b>审核</b></td>
						</tr>
						<s:iterator value="papers" status="index">	
						 	<s:if test="#index.odd == true"> 
								 <tr style="background-color:#cccccc" class="pt11" height="32">
							</s:if> 
							<s:else> 
								 <tr class="pt11" height="32">
							</s:else>
							<td><s:property value="paID"/></td>
							<td><s:property value="paName"/></td>
							<td>
								<s:if test="paLevel==1">普通</s:if>
								<s:elseif test="paLevel==2">核心</s:elseif>
								<s:elseif test="paLevel==3">EI</s:elseif>
								<s:elseif test="paLevel==4">SCI</s:elseif>
							</td>
							<td><s:property value="paScore"/></td>
							<td><s:property value="paApplicant"/></td>
							<td >
								<table align="center" bgcolor="#cccccc" align="center">
								<s:iterator value="roleScore" status="index">	
							 	<s:if test="#index.odd == true"> 
									 <tr style="background-color:#cccccc" class="pt11" height="32">
								</s:if> 
								<s:else> 
									 <tr class="pt11" height="32">
								</s:else>
								<td width="34%" align="center"><s:property value="teacher.TID"/></td>
								<td width="33%" align="center">
								<s:if test="TRole==0">负责人</s:if>
								<s:elseif test="TRole==1">参与者</s:elseif>
								</td>
								<td width="33%" align="center"><s:property value="score"/></td>
								</s:iterator>
								</table>
							</td>
							<td>
								<a href='checkPaper.action?result=pass&paID=<s:property value="paID"/>'>通过</a>&nbsp;&nbsp;
								<a href='checkPaper.action?result=deny&paID=<s:property value="paID"/>'>拒绝</a>
							</td>
						</s:iterator>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>