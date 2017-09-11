<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	body{
		text-align:center;
		
	}
	table{
		margin:0 auto;
	}
</style>
</head>
<body>
	<h1>新闻管理</h1>
	<table border="1" cellpadding="0" cellspacing="0" width="80%">
		<s:iterator value="test" var="string">
			<tr>
				<td colspan="5"><s:property value="string"></s:property></td>
			</tr>
		</s:iterator>
		<s:iterator value="newslist" var="news">
			<tr>
				<td><s:property value="#news.Nid"></s:property></td>
				<td><s:property value="#news.Ntitle"></s:property></td>
				<td><s:property value="#news.Ncontent"></s:property></td>
				<td><s:date name="#news.Ntime" format="yyyy-MM-dd"></s:date></td>
				<td><s:property value="#news.Norder"></s:property></td>
			</tr>
		</s:iterator>		
	</table>
	<s:a href="admin/NewsEditor.jsp">编辑</s:a>
</body>
</html>