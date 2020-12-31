<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	
<meta charset="UTF-8">
<title>timesTablesServlet</title>
</head>
<body>
	<table style='width:100%' border='1'>
		
<%-- 	<% for(int j=1;j<10;j++){ %>
			<tr>
		<% for(int i=2;i<=9;i++){ %>
			<td>
			<%= i%> * <%=j %> = <%=(i*j)%>
			</td>
			
		<% }%>
		</tr>
		<% }%> 
--%>
<% 

for(int j=1;j<10;j++){ 
			 out.write("<tr>"); 
		 for(int i=2;i<=9;i++){ 
			 out.write("<td>"); 
			 out.write(i +"*"+ j +"="+(i*j)); 
			 out.write("</td>"); 
		 }
			 out.write("<tr>"); 

		 } 
%>

			
			
		
	</table>
</body>
</html>