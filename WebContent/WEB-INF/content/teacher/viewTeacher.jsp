<%@ page contentType="text/html; charset=gb2312" language="java" %>
<%@ page import="java.util.*" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	   <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	   <title>查看个人科研信息</title>
</head>
<body>
<%@include file="../header.jsp"%>
<%@include file="teaheader.jsp"%>
<table width="80%" border="0" align="center"
	cellspacing="1" bgcolor="#cccccc">
  <tr bgcolor="#e1e1e1" >
	<td colspan="7" ><div class="mytitle" align="center">论文</div></td> 
  </tr>
  <tr class="pt11" height="45">
	<td><b>论文编号</b></td>
	<td><b>论文题目</b></td>
	<td><b>论文级别</b></td>
	<td><b>论文分数</b></td>
	<td><b>论文状态</b></td>
	<td><b>教师角色</b></td>
	<td><b>教师分数</b></td>
  </tr>
  <s:iterator value="papers" status="index">  
 	<s:if test="#index.odd == true"> 
		 <tr style="background-color:#dddddd" class="pt11" height="32">
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
	<td>
	<s:if test="paStatus==0">未提交</s:if>
	<s:elseif test="paStatus==1">待审核</s:elseif>
	<s:elseif test="paStatus==2">审核通过</s:elseif>
	<s:elseif test="paStatus==3">审核不通过</s:elseif>
	</td>
	<td>
    <s:if test="roleScore[0].TRole==0">负责人</s:if>
	<s:else>参与者</s:else>
	</td>
	<td><s:property value="roleScore[0].score"/></td>
	</tr>
</s:iterator>
</table>
<br><br>

<table width="80%" border="0" align="center"
	cellspacing="1" bgcolor="#cccccc">
  <tr bgcolor="#e1e1e1" >
	<td colspan="8" ><div class="mytitle" align="center">项目</div></td> 
  </tr>
  <tr class="pt11" height="45">
	<td><b>项目编号</b></td>
	<td><b>项目题目</b></td>
	<td><b>项目级别</b></td>
	<td><b>项目经费</b></td>
	<td><b>项目分数</b></td>
	<td><b>项目状态</b></td>
	<td><b>教师角色</b></td>
	<td><b>教师分数</b></td>
  </tr>
  <s:iterator value="projects" status="index">  
 	<s:if test="#index.odd == true"> 
		 <tr style="background-color:#dddddd" class="pt11" height="32">
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
	<td>
	<s:if test="prStatus==0">未提交</s:if>
	<s:elseif test="prStatus==1">待审核</s:elseif>
	<s:elseif test="prStatus==2">审核通过</s:elseif>
	<s:elseif test="prStatus==3">审核不通过</s:elseif>
	</td>
	<td>
	<s:if test="roleScore[0].TRole==0">负责人</s:if>
	<s:else>参与者</s:else>
	</td>
	<td><s:property value="roleScore[0].score"/></td>
	</tr>
</s:iterator>
</table>
</body>
</html>