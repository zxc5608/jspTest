<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/sumCalculation" method="post">
<input type=text name="num1"/><br>
<input type=text name="num2"/><br>
<input type="submit" value="전송"><br>


</form>

</body>
</html>