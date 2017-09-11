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
	textarea{
		display:block;	
	}
</style>
<link rel="stylesheet" href="../kindeditor-4.1.7/themes/default/default.css" />
<script charset="utf-8" src="../kindeditor-4.1.7/kindeditor-min.js"></script>
<script charset="utf-8" src="../kindeditor-4.1.7/lang/zh-CN.js"></script>
		<script>
			KindEditor.ready(function(K) {
				K.create('textarea[name="content"]', {
					uploadJson : '/cdzj/kindeditor-4.1.7/jsp/upload_json.jsp',
	                fileManagerJson : '/cdzj/kindeditor-4.1.7/jsp/file_manager_json.jsp',
					autoHeightMode : true,
					allowFileManager : true
				});
			});
</script>
</head>
<body>
	<h1>新闻管理</h1>
	<table border="1" cellpadding="0" cellspacing="0" width="80%">
		<tr>
			<td>编号</td>
			<td>新闻标题</td>
			<td>新闻内容</td>
			<td>发布时间</td>
			<td>显示顺序</td>
			<td>操作</td>
		</tr>
		<s:iterator value="newslist" var="news">
				<tr>			
					<td colspan="5"><s:property value="#news.Nid"/></td>				
					<td>删除|编辑</td>
			  </tr>
		</s:iterator>
	</table>
	<form>
		<textarea name="content" style="width:800px;height:200px;">888</textarea>
	</form>
	
</body>
</html>