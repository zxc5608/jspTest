<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	webapp/index.jsp ==> localhost/index.jsp
	
	webapp/image/brown.png
	<img src="<%=request.getContextPath() %>/image/brown.png"/>
</body>
</html>