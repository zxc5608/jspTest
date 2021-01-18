<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/mulcalculation" method="post">
<input type=text name="param1"/><br>
<input type=text name="param2"/><br>
<input type="submit" value="전송"><br>
</body>
</html>