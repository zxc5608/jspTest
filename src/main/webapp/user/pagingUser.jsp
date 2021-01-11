<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">


<title>Jsp</title>

<%@include file="/common/common_lib.jsp" %>

<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/css/dashboard.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/blog.css" rel="stylesheet">

<%
List<UserVo>userlist=(List<UserVo>)request.getAttribute("userList");

		
%>
</head>

<body>

	
	<%@include file="/common/header.jsp" %>


<div class="container-fluid">
		<div class="row">
			
<div class="col-sm-3 col-md-2 sidebar">
	<%@include file="/common/left.jsp" %>
	
</div><div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				

<div class="row">

	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>사용자 아이디</th>
					<th>사용자 이름</th>
					<th>사용자 별명</th>
					<th>등록일시</th>
				</tr>
				
		<%	
		
		
		for(int i = 0;i<userlist.size();i++){
				UserVo uservo = userlist.get(i);
			
				out.write("<tr>");
				out.write("<td>"+uservo.getUserid()+"</td>");
				out.write("<td>"+uservo.getUsernm()+"</td>");
				out.write("<td>"+uservo.getAlias()+"</td>");
				out.write("<td> "+uservo.getReg_dt_fmt()+"</td>");
				
				
				out.write("</tr>");
							
				
			}
				
	
		%>
		
			</table>
		</div>


		<a class="btn btn-default pull-right">사용자 등록</a>

		<div class="text-center">
			<ul class="pagination">
				
				<li><a href="<%=request.getContextPath() %>pagingUser?page=1&pageSize=5">1</a></li>
				<li><a href="<%=request.getContextPath() %>pagingUser?page=2&pageSize=5">2</a></li>
				<li><a href="<%=request.getContextPath() %>pagingUser?page=3&pageSize=5">3</a></li>
				<li><a href="<%=request.getContextPath() %>pagingUser?page=4&pageSize=5">4</a></li>
				<li><a href="<%=request.getContextPath() %>pagingUser?page=5&pageSize=5">5</a></li>
			</ul>
		</div>
	</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>
