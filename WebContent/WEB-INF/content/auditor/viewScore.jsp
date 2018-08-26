<%@ page contentType="text/html; charset=gb2312" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
		<title>教师分数汇总</title>
	</head>
	<body>
		<%@include file="../header.jsp"%>
		<%@include file="audheader.jsp"%>
		<table width="960" align="center">
			<tr>
				<td>
					<table border="1" align="center" bgcolor="#cccccc">
						<tr class="pt11" height="45">
							<td><b>教师编号</b></td>
							<td><b>教师姓名</b></td>
							<td><b>教师分数</b></td>
						</tr>
						<s:iterator value="teachers" status="index">  
							<s:if test="#index.odd == true"> 
								<tr style="background-color:#dddddd" class="pt11" height="32">
							</s:if> 
							<s:else> 
								<tr class="pt11" height="32">
							</s:else> 
							<td><s:property value="TID"/></td>
							<td><s:property value="TName"/></td>
   							<td><s:property value="TScore"/></td>
						</s:iterator>
					</table>
				</td>
			</tr>
		</table>			
	</body>
</html>