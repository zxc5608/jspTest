<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% %>				<!-- 미리선언되어있는 내장 객체 -->
	request.getContentType(): <%=request.getContentType()%><br>
	request.getMethod(): <%=request.getMethod() %><br>
	request.getRequestURI(): <%=request.getRequestURI() %><br>
	request.getContextPath(): <%=request.getContextPath() %><br>
	request.getServerPort(): <%=request.getServerPort() %><br>

</body>
</html>