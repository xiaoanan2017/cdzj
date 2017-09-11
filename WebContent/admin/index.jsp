<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理首页</title>
</head>
	<frameset rows="100,*" frameborder="yes" >
		<frame src="/cdzj/admin/head.jsp"  noresize/>
		<frameset cols="200,*">
			<frame src="/cdzj/admin/nav.jsp" noresize/>
			<frame src="/cdzj/admin/main.jsp" name="right"/>			
		</frameset>		
	</frameset>	
</html>