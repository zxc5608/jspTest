<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="x-ua-compatible" content="ie=edge">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>상세보기</title>
<script>
//문서로딩이 완료되고 나서 실행되는 영역
$(function(){
	$(".user").on("click",function(){
		//this : 클릭 이벤트가 발생한 element
		//data- 속성명 data-userid, 속성명은 대소문자 무시하고 소문자로 인식
		//data-userId ==>data-userid
		var userid = $(this).data("userid");
		$("#userid").val(userid);
		$("#frm").submit();
	});
	$("#modifyBtn").on("click",function(){
		$("#frm").attr("method","get");
		$("#frm").attr("action","${cp}/BoardModify");
		$("#frm").submit();
	});	
	$("#deleteBtn").on("click",function(){
		$("#frm").attr("method","post");
		$("#frm").attr("action","${cp}/BoardDelete");
		$("#frm").submit();
	});	
	$("#repleBtn").on("click",function(){
		$("#frm").attr("method","get");
		$("#frm").attr("action","${cp}/repleBtn");
		$("#frm").submit();
	});	
	

	
})
</script>


<!-- Font Awesome Icons -->
<link rel="stylesheet" href="${cp }/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="${cp }/resources/bootstrap/dist/css/adminlte.min.css">

</head>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">

	<%@include file="/common/header.jsp" %>
		<%@include file="/common/left.jsp" %>


		<div id="if_list_div" style="position: relative; padding: 0; overflow: hidden;">
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">

				<!-- Main content -->
				<section class="content register-page" style="height:100%;">
					<div class="container-fluid">
						<div class="login-logo">
							<b>상세보기</b>
						</div>
						<!-- form start -->
						<div class="card">
							<div class="register-card-body">
							
								<form role="form" class="form-horizontal" id="frm" >
									
									<input type="text" name="user_id" value= "${board.user_id }"/>
									<input type="hidden" name="post_no" value="${board.post_no }">
									<input type="hidden" name="bor_no" value="${board.bor_no }">
									<input type="hidden" name="title" value="${board.title }">
									<input type="hidden" name="cont" value="${board.cont }">
									
									<div class="input-group mb-3">
									
										<br />
									</div>
									
									<div class="form-group row">
										<label for="id" class="col-sm-3" style="font-size: 0.9em;">
											<span style="color: red; font-weight: bold;">*</span>아이디
										</label>
										<div class="col-sm-9 input-group-sm">
											<label  class="form-control">${board.user_id }</label>
										</div>
									</div>
									
									
									
									<div class="form-group row">
										<label for="pwd" class="col-sm-3" style="font-size: 0.9em;">
											<span style="color: red; font-weight: bold;">*</span>제목</label>
										<div class="col-sm-9 input-group-sm">
											<label  class="form-control">${board.title }</label>
										</div>
									</div>
									
									<div class="form-group row">
										<label for="name" class="col-sm-3" style="font-size: 0.9em;">
											<span style="color: red; font-weight: bold;">*</span>내용
										</label>
										<div class="col-sm-9 input-group-sm">
											<label  class="form-control">${board.cont }</label>
										</div>

									</div>
									<div class="form-group row">
										<label for="alias" class="col-sm-3" style="font-size: 0.9em;">post</label>
										<div class="col-sm-9 input-group-sm">
											<label  class="form-control">${board.post_no }</label>
										</div>
									</div>
									
									<div class="form-group row">
										<label for=reg_dt class="col-sm-3" style="font-size: 0.9em;">날짜</label>
										<div class="col-sm-9 input-group-sm">
											<label  class="form-control"><fmt:formatDate value="${board.reg_dt }" pattern="yyyy.MM.dd"/> </label>
										</div>
									</div>
									
								
									
									<div class="card-footer">
										<div class="row">
											<div class="col-sm-6">
												<button type="button" id="modifyBtn" class="btn btn-info">수정</button>
												<button type="button" id="deleteBtn" class="btn btn-info">삭제</button>
												<button type="button" id="repleBtn" class="btn btn-info">답글</button>
											
											</div>

											

										</div>
									</div>
								</form>
								
												<input type="hidden" value=" ${com.com_no }" id="com_no" name="com_no"> 
												
										<div>댓글
										<c:forEach items="${comList}" var="com">
												<tr >
													<td>댓글번호 : ${com.com_no }</td>
												</tr>
													<td>아이디 : ${com.com_user_id }</td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<td>날짜 : <fmt:formatDate value = "${com.com_date }" pattern="yyyy.MM.dd" /></td>
													<td>
													
													<c:if test="${user.userid == com.com_user_id && com.com_del==1}">
														<button class="btn btn-info" id="deletereply"onclick="location.href='${cp}/reviewDelete?com_no=${com.com_no }&bor_no=${board.bor_no}&post_no=${board.post_no }'">삭제</button>
													</c:if>
													</td>
													
													
													<td>내용:${com.com_con}</td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

										<hr><br>

												

											</c:forEach>
										</div>
										<form action="${cp }/reviewWrite" id="frmcom">
											
											<input type="hidden" name="bor_no" value="${board.bor_no  }">
											<input type="hidden" name="post_no" value="${board.post_no}">
											<input type="hidden" name="user_id1" value="${board.user_id}">
											<input type="hidden" name="user_id" value="${S_USER.userid}">
											<textarea rows="10" cols="10" style="width:70% ; height:80px;" name="cont"></textarea>
											<input type="submit" value="입력">										
										</form>
											
											
										
							</div>
							<!-- register-card-body -->
						</div>
					</div>
				</section>
				<!-- /.content -->
			</div>
			<!-- /.content-wrapper -->
		</div>
	</div>

	<!-- Main Footer -->
	<footer class="main-footer">
		<!-- To the right -->
		<div class="float-right d-none d-sm-inline">Anything you want</div>
		<!-- Default to the left -->
		<strong>Copyright &copy; 2014-2019 <a href="https://adminlte.io">AdminLTE.io</a>.
		</strong> All rights reserved.
	</footer>
	
	<!-- ./wrapper -->

	<!-- REQUIRED SCRIPTS -->

	<!-- jQuery -->
	<script src="./resources/bootstrap/plugins/jquery/jquery.min.js"></script>

	<!-- Bootstrap 4 -->
	<script src="./resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script src="./resources/bootstrap/dist/js/adminlte.min.js"></script>
	<script>
		$(document).ready(function(){
			// picture input의 파일 변경시 이벤트 
			$("#picture").change(function(){
			   readURL(this);
			});
		});
		
		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();
			  
				reader.onload = function (e) {
					$('#pictureViewImg').attr('src', e.target.result);  
				}
				reader.readAsDataURL(input.files[0]);
			}
		}
			 
		
	</script>
</body>
</html>







