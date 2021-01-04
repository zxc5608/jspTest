<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	num1: <%=session.getAttribute("num1") %><br>
	num2: <%=session.getAttribute("num2") %><br>
	sum: <%=session.getAttribute("sumResult") %>
	
</body>
</html>