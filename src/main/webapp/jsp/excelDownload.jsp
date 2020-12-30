<%@ page language="java" contentType="application/vnd.ms-excel; charset=UTF-8"
											
    pageEncoding="UTF-8"%>
<%
	//Content-Disposition header : 파일 다운로드 , 업로드시 사용하는 파일과 관련된헤더 
	response.setHeader("Content-Disposition", "attachement; filename=excel.xls");    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>userid</th>
			<th>이름</th>
		</tr>
		
		<tr>
			<td>brown</td>
			<td>브라운</td>
		</tr>
		
		<tr>
			<td>sally</td>
			<td>샐리</td>
		</tr>
		
		<tr>
			<td>cony</td>
			<td>코니</td>
		</tr>
	
	</table>
</body>
</html>