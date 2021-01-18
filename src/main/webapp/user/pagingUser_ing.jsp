<%@page import="kr.or.ddit.common.model.PageVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/blog.css" rel="stylesheet">



<script>
//문서로딩이 완료되고 나서 실행되는 영역
$(function(){
	$(".user").on("click",function(){
		//this: 클릭 이벤트가 발생한 element
		//data-속성명 data-userid, 속성명은 대소문자 무식하고 소문자로 인식
		//data-userID==> data-userid
		var userid = $(this).data("userid");
		//var userid = ($(this).data("userid"));
		$("#userid").val(userid);
		$("#frm").submit();
		
		
	});
});
</script>
</head>

<body>
	<form id ="frm" action="${pageContext.request.contextPath}/user">
		<input type= "hidden" id= "userid" name= "userid" value=""/>
	</form>

	
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
				
<%-- 		<%	
		for(int i = 0;i<userlist.size();i++){
				UserVo uservo = userlist.get(i);
			
				out.write("<tr class='user' data-userid="+uservo.getUserid()+">");
				out.write("<td>"+uservo.getUserid()+"</td>");
				out.write("<td>"+uservo.getUsernm()+"</td>");
				out.write("<td>"+uservo.getAlias()+"</td>");
				out.write("<td> "+uservo.getReg_dt_fmt()+"</td>");
				
				
				out.write("</tr>");
							
				
			}
		%> --%>
			<c:forEach items="${userList }" var="user">
			<tr>
			<tr class='user' data-userid="${user.userid }">
				<td>${user.userid }</td>
				<td>${user.usernm }</td>
				<td>${user.alias }</td>
				<td>${user.getReg_dt_fmt() }</td>
			
			</tr>
		
		</c:forEach>

			</table>
		</div>


		<a class="btn btn-default pull-right" href="${pageContext.request.contextPath}/user/registUser.jsp">사용자 등록</a>

		<div class="text-center">
			<ul class="pagination">
			 <li class="prev">
				<a href="${pageContext.request.contextPath}pagingUser?page=1&pageSize=${pageVo.getPageSize()}">«</a>
			 </li>
			<c:forEach begin="1" end="${pagination }" var="i">
					<c:choose>
						<c:when test="${pageVo.getPage() ==i}">
						<li class= "active"><span>${i }</span></li>
						</c:when>
						<c:otherwise>
						<li><a href="${pageContext.request.contextPath}pagingUser?page=${i }&pageSize=${pageVo.getPageSize()}">${i }</a></li>
						</c:otherwise>
					</c:choose>	
				</c:forEach>	 				
				<li class="next">
					<a href="${pageContext.request.contextPath}pagingUser?page=${pagination}&pageSize=${pageVo.getPageSize() }">»</a>
				</li>
				
					<%-- 	 <%int pagination = (int)request.getAttribute("pagination");%>
			 
				<%for(int i=1; i<=pagination;i++){ %>
			
					<%if(pageVo.getPage() == i){%> <!-- 루프돌고있는페이지랑 같은지 확인  -->					
					<li class= "active"><span><%=i %></span></li>
					<% }
					else{%>
						<li><a href="${pageContext.request.contextPath}pagingUser?page=<%=i %>&pageSize=<%=pageVo.getPageSize()%>"><%=i %></a></li>
					
					<% }%>													
				<% }%>	 --%>
				
				
				
				
				
			</ul>
		</div>
	</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>
