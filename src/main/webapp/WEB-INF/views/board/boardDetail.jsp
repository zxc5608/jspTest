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
		$("#frm").attr("action","${cp}/board/BoardModify");
		$("#frm").submit();
	});	
	$("#deleteBtn").on("click",function(){
		$("#frm").attr("method","post");
		$("#frm").attr("action","${cp}/board/BoardDelete");
		$("#frm").submit();
	});	
	$("#repleBtn").on("click",function(){
		$("#frm").attr("method","get");
		$("#frm").attr("action","${cp}/board/boardreple");
		$("#frm").submit();
	});	
	
	$('#replymodiBtn').on('click', function(){
		if($(this).data("content") == '삭제된 댓글입니다'){
			alert("삭제된 댓글입니다");
			return false;
		}else{
			//원래 내용 가져오기
			modifycont = $(this).parents('.rep').find('#cont').html();
			var comno = $(this).data('comno');
			//<br>를 \n으로 변경
			//modifycont = modifycont.replace(/<br>/g,"\n");
			//수정내용을 수정폼의 text에 출력
			$('#text').val(modifycont);
			$('#com_no').val(comno);
			
			$(this).parents('.rep').find('#cont').empty().append($('#modifyForm'))
			$('#modifyForm').show();
		}
	})
	
	
})
</script>


<!-- Font Awesome Icons -->
<link rel="stylesheet" href="${cp }/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="${cp }/resources/bootstrap/dist/css/adminlte.min.css">

</head>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">

	<%@include file="/WEB-INF/views/common/header.jsp" %>
		<%@include file="/WEB-INF/views/common/left.jsp" %>

	<div id="if_list_div" style="position: relative; padding: 0; overflow: hidden; min-height: 750px;">
				<div class="content-wrapper" style="min-height: 584px;">
					<!-- Content Header (Page header) -->
					<section class="content-header">
						<div class="container-fluid">
							<div class="row md-2">
								<div class="col-sm-6">
									<h1>게시글 상세조회</h1>
								</div>
								<div class="col-sm-6">
								<a class="col-md-8" href="#" class="d-block"><c:if test="${S_USER != null }"> ${S_USER.userid }[${S_USER.usernm }]</c:if> </a><br>
									<ol class="breadcrumb float-sm-right">
										<li class="breadcrumb-item">회원리스트</li>
										<li class="breadcrumb-item">목록</li>
										<%-- <li><a href="${cp }/logout">logout</a></li> --%>
									</ol>
								</div>
							</div>
						</div>
					</section>
		
						<!-- form start -->
						<div class="card">
							<div class="register-card-body">
							
								<form role="form" class="form-horizontal" id="frm" >
									<input type="hidden" name="user_id" value= "${board.user_id }"/>
									<input type="hidden" name="post_no" value="${board.post_no }">
									<input type="hidden" name="bor_no" value="${board.bor_no }">
									<input type="hidden" name="title" value="${board.title }">
									<input type="hidden" name="cont" value="${board.cont }">
									
									<div class="input-group mb-3">
									
										<br/>
									</div>
									<div class="form-group">
									<label for="userNm" class="col-sm-2 control-label">첨부파일</label>
										<div class="col-sm-10">
				                              	<c:forEach items="${fileList}" var="file">
				                              		<a href="${cp}/board/fileDownload?att_no=${file.att_no}&bor_no=${file.bor_no}&post_no=${file.post_no}&user_id=${file.user_id}">
													${file.file_nm}
												</a><br>
				                              	</c:forEach>
										</div>
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
												
										<c:forEach items="${comList}" var="com">
												
										<div class="rep">
													내용:<label class="control-label" id="cont">${com.com_con}</label>
													<label class="control-label">아이디 : ${com.com_user_id }</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<label class="control-label">날짜 : <fmt:formatDate value = "${com.com_date }" pattern="yyyy.MM.dd" /></label>
													<label class="control-label">댓글번호 : ${com.com_no } 내용:${com.com_con}</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													
													<c:if test="${user.userid == com.com_user_id && com.com_del==1}">
														<button class="btn btn-info" id="deletereply"onclick="location.href='${cp}/board/reviewDelete?com_no=${com.com_no }&bor_no=${board.bor_no}&post_no=${board.post_no }'">삭제</button>
														<button type="button" id="replymodiBtn" class="btn btn-default" data-comno="${com.com_no }" data-content="${com.com_con}">수정</button>
													</c:if>
									
										<hr>
										</div>
										</c:forEach>
										<form action="${cp }/board/reviewWrite" id="frmcom">
											
											
											<input type="hidden" name="bor_no" value="${board.bor_no  }">
											<input type="hidden" name="post_no" value="${board.post_no}">
											<input type="hidden" name="user_id1" value="${board.user_id}">
											<input type="hidden" name="user_id" value="${S_USER.userid}">
											<textarea rows="10" cols="10" style="width:70% ; height:80px;" name="cont"></textarea>
											<input type="submit" value="입력">										
										</form>
											
								<div id="modifyForm" style="display:none;">
									<form action="${cp}/board/reviewupdate" method="post">
										<textarea id="text" name="com_con" rows="2" cols="50"></textarea>
										
										<input type="hidden" name="bor_no" value="${board.bor_no }">
										<input type="hidden" name="post_no" value="${board.post_no}">
										<input type="text" id="com_no" name="com_no" value="">
										
										<input type="submit" class="btn btn-default" value="확인" id="btnok">
										<input type="button" class="btn btn-default" value="취소" id="btnreset">
									</form>
								</div>
																	
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







