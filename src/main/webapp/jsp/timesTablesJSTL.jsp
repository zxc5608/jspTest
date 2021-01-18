<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	
<meta charset="UTF-8">
<title>timesTablesServlet</title>
</head>
<body>
	<table style='width:100%' border='1'>


	<c:forEach begin="1" end="10" var="j">
		<tr>
		  <c:forEach begin="1" end="9" var="i">
			<td>
				${i }*${j }= ${i*j }
			</td>		
		  </c:forEach>
	</c:forEach>
		
			
		
	</table>
</body>
</html>