<%@ page contentType="text/html; charset=gb2312" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	   <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	   <title>审核项目</title>
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
							<td><b>项目编号</b></td>
							<td><b>项目题目</b></td>
							<td><b>项目级别</b></td>
							<td><b>项目经费</b></td>
							<td><b>项目分数</b></td>
							<td><b>申报人编号</b></td>
							<td><b>教师编号&nbsp;&nbsp;教师角色&nbsp;&nbsp;教师分数</b></td>
							<td><b>审核</b></td>
						</tr>
						<s:iterator value="projects" status="index">	
						 	<s:if test="#index.odd == true"> 
								 <tr style="background-color:#cccccc" class="pt11" height="32">
							</s:if> 
							<s:else> 
								 <tr class="pt11" height="32">
							</s:else>
							<td><s:property value="prID"/></td>
							<td><s:property value="prName"/></td>
  							<td>
								<s:if test="prLevel==1">校级</s:if>
								<s:elseif test="prLevel==2">省级</s:elseif>
								<s:elseif test="prLevel==3">国家级</s:elseif>
							</td>
							<td><s:property value="prFunding"/></td>
							<td><s:property value="prScore"/></td>
							<td><s:property value="prApplicant"/></td>
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
								<a href='checkProject.action?result=pass&prID=<s:property value="prID"/>'>通过</a>&nbsp;&nbsp;
								<a href='checkProject.action?result=deny&prID=<s:property value="prID"/>'>拒绝</a>
							</td>
						  </tr>
						</s:iterator>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>