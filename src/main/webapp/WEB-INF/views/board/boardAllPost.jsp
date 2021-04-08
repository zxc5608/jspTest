<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<title>회원 리스트</title>

<!-- Font Awesome Icons -->
<link rel="stylesheet"
	href="${cp }/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${cp }/resources/bootstrap/dist/css/adminlte.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>


	//문서로딩이 완료되고 나서 실행되는 영역
	$(function() {
		$(".board").on("click", function() {
			//this: 클릭 이벤트가 발생한 element    
			//data-속성명 data-userid, 속성명은 대소문자 무식하고 소문자로 인식
			//data-userID==> data-userid
			var userid = $(this).data("userid");
			var post = $(this).data("post");
			var title = $(this).data("title");
			//var userid = ($(this).data("userid"));
			$("#borno").val(userid);
			$("#postno").val(post);
			
			if(title == "삭제된 게시글입니다"){
				return false
			}else{
				$("#frm").submit();
				
			}
				


		});
	});
</script>

</head>
<body class="hold-transition sidebar-mini">

	<form id="frm" action="${cp }/board/boardDetail">
	
		<input type="hidden" id="borno" name="bor_no" value="${pageVo.bor_no }" />
		<input type="hidden" id="postno" name="post_no" value="${KboardpostVo.post_no}" />
	</form>

	<div class="wrapper">

		<%@include file="/WEB-INF/views/common/header.jsp"%>
		<!-- /.navbar -->

		<%@include file="/WEB-INF/views/common/left.jsp"%>



		<div id="if_list_div"
			style="position: relative; padding: 0; overflow: hidden; height: 750px;">
			<div class="content-wrapper" style="min-height: 584px;">
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<div class="container-fluid">
						<div class="row md-2">
							<div class="col-sm-6">
								<h1>회원리스트</h1>
							</div>
							<div class="col-sm-6">
								<ol class="breadcrumb float-sm-right">
									<li class="breadcrumb-item">회원리스트</li>
									<li class="breadcrumb-item">목록</li>
								</ol>
							</div>
						</div>
					</div>
				</section>
				<!-- Main content -->
				<section class="content">
					<div class="card">
						<div class="card-header with-border">

							<form action="${cp }/board/RegistBoard" method="get"  >
							
								<input type="hidden" name="bor_no" value="${pageVo.bor_no }">
								<a class="col-md-8" href="#" class="d-block"><c:if test="${S_USER != null }"> ${S_USER.userid }[${S_USER.usernm }]</c:if></a>
								<input type="hidden" name="user_id" value="${S_USER.userid }">
								<input  type="submit" value="게시글등록" class="btn btn-primary">
							</form>


							<div id="keyword" class="card-tools" style="width: 550px;">
								<div class="input-group row">
									<!-- sort num -->

									<select class="form-control col-md-3" name="PageNum"
										id="PageNum">
										<option value="">정렬개수</option>
										<option value="3">3개씩</option>
										<option value="5">5개씩</option>
										<option value="7">7개씩</option>
									</select>



									<!-- search bar -->
									<select class="form-control col-md-3" name="searchType"
										id="searchType">
										<option value="">검색구분</option>
										<option value="i">아이디</option>
										<option value="n">이름</option>
										<option value="a">별명</option>
									</select> 
									<input class="form-control" id="keywords" type="text" name="keyword"
										placeholder="검색어를 입력하세요." value=""> <span
										class="input-group-append">
										<button class="btn btn-primary" type="button" id="searchBtn"
											data-card-widget="search">
											<i class="fa fa-fw fa-search"></i>
										</button>
									</span>
									<!-- end : search bar -->
								</div>
							</div>
						</div>
						<div class="card-body" style="text-align: center;">
							<div class="row">
								<div class="col-sm-12">
									<table class="table table-bordered">
										<tbody>
											<tr>
												<th>게시글번호</th>
												<th>제목</th>
												<th>작성자아이디</th>
												<th>작성일시</th>
												
												<!-- yyyy-MM-dd  -->
											</tr>
											
											<c:forEach items="${boardList}" var="board">
												
												<tr class="board" data-userid="${board.bor_no}" data-post="${board.post_no }" data-title="${board.title }">
													<td>${board.post_no }</td>
													<td>${board.title }</td>
													<td>${board.user_id }</td>
													<td><fmt:formatDate value = "${board.reg_dt }" pattern="yyyy.MM.dd" /></td>


												</tr>

											</c:forEach>


										</tbody>
									</table>
								</div>
								<!-- col-sm-12 -->
							</div>
							<!-- row -->
						</div>
						<!-- card-body -->
						<div class="card-footer">
							<nav aria-label="member list Navigation">
										<ul class="pagination justify-content-center m-0">
											<li class="page-item"><a class="page-link" 
													href="${cp }/board/boardPost?page=1&pageSize=${pageVo.pageSize}&bor_no=${pageVo.bor_no}"><i class="fas fa-angle-double-left"></i></a></li>
													
		
											<c:choose>
												<c:when test="${pageVo.page-1 <1}">
													<li class="page-item"><a class="page-link"
														href="${cp }/board/boardPost?page=${pageVo.page }&pageSize=${pageVo.pageSize}&bor_no=${pageVo.bor_no}">
														<i class="fas fa-angle-left"></i></a></li>
												</c:when>
												<c:otherwise>
													<li class="page-item"><a class="page-link"
														href="${cp }/board/boardPost?page=${pageVo.page-1 }&pageSize=${pageVo.pageSize}&bor_no=${pageVo.bor_no}">
														<i class="fas fa-angle-left"></i></a></li>
												</c:otherwise>
												
											</c:choose>
											
											
											<c:forEach begin="1" end="${pagination }" var="i">
												<c:choose>
													<c:when test="${pageVo.page ==i }">
														<li class="page-item active"><a class="page-link" href="#">${i }</a></li>
													</c:when>
													<c:otherwise>
														<li class="page-item"><a class="page-link"
															href="${cp }/board/boardPost?page=${i }&pageSize=${pageVo.pageSize}&bor_no=${pageVo.bor_no}">${i }</a></li>
													</c:otherwise>
												</c:choose>
											</c:forEach>
											
											
											<c:choose>
												<c:when test="${pageVo.page+1 > pagination}">
													<li class="page-item"><a class="page-link"
														href="${cp }/board/boardPost?page=${pageVo.page}&pageSize=${pageVo.pageSize}&bor_no=${pageVo.bor_no}"><i
															class="fas fa-angle-right"></i></a></li>
												</c:when>
												<c:otherwise>
													<li class="page-item"><a class="page-link"
														href="${cp }/board/boardPost?page=${pageVo.page+1 }&pageSize=${pageVo.pageSize}&bor_no=${pageVo.bor_no}"><i
															class="fas fa-angle-right"></i></a></li>
												</c:otherwise>
											</c:choose>
												<li class="page-item"><a class="page-link" href="${cp }/board/boardPost?page=${pagination }&pageSize=${pageVo.pageSize}&bor_no=${pageVo.bor_no}"><i class="fas fa-angle-double-right"></i></a></li>
										</ul>
									</nav>
							
						</div>
						<!-- card-footer -->
					</div>
					<!-- card  -->
				</section>
			</div>
		</div>
	</div>

	<!-- Main Footer -->
	<footer class="main-footer">
		<!-- To the right -->
		<div class="float-right d-none d-sm-inline">Anything you want</div>
		<!-- Default to the left -->
		<strong>Copyright &copy; 2014-2019 <a
			href="https://adminlte.io">AdminLTE.io</a>.
		</strong> All rights reserved.
	</footer>
	</div>
	<!-- ./wrapper -->

	<!-- REQUIRED SCRIPTS -->

	<!-- jQuery -->
	<script src="${cp }/resources/bootstrap/plugins/jquery/jquery.min.js"></script>

	<!-- Bootstrap 4 -->
	<script
		src="${cp }/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script src="${cp }/resources/bootstrap/dist/js/adminlte.min.js"></script>


</body>
</html>







