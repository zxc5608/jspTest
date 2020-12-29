<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%--jsp메소드, 변수 선언부 --%>
 <%!
 //메소드 선언
 private int calculate(int n) {
/* 		 
	int res = 1;
		 
	for (int i = 1; i <= n; i++) {
		res *= i; 
	} 
	return res; */
	
	if(n<=1)
		return 1;
	else
		return n *calculate(--n);
 }
 
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	1!:<%=calculate(1)%><br>
	2!:<%=calculate(2)%><br>
	3!:<%=calculate(3)%><br>
	4!:<%=calculate(4)%><br>
	5!:<%=calculate(5)%><br>

</body>
</html>