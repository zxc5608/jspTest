
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<!-- <link href="https://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet"> -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.0/jquery.js"></script> 
<script src="https://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.js" defer></script>
<!-- Font Awesome Icons -->
<link rel="stylesheet" href="${cp}/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="${cp}/resources/bootstrap/dist/css/adminlte.min.css">

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%-- <% List<UserVo> userList = (List<UserVo>)request.getAttribute("userList"); %> --%>
<title>게시판 리스트</title>

 <script>
    $(function() {
        $('#summernote').summernote();	
        $(".user").on("click",function(){
			//this : 클릭 이벤트가 발생한 element
			//data- 속성명 data-userid, 속성명은 대소문자 무시하고 소문자로 인식
			
			//data-userId ==>data-userid
			var userid = $(this).data("userid");
			$("#userid").val(userid);
			$("#frm").submit();
		});
		$("#insertBtn").on("click",function(){
			var bor_act = $("#bor_act").val();
			alert(type);
			var bor_name = $("#bor_name").val();
			console.log(bor_name);
			location.href="${cp}/BoardInfoAdd?bor_act="+bor_act+"&bor_name="+bor_name+"";
		})
		$("#updateBtn").on("click",function(){
			var bor_act = $("#board.bor_act").val();
			alert(bor_act);
			var bor_no = $("#board.bor_no").val();
			alert(bor_no);
			location.href="${cp}/boardInfoUpdate?bor_act="+bor_act+"&bor_no="+bor_no+"";
		})
   });
</script>



</head>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">

		<!-- Navbar -->
		<nav class="main-header navbar navbar-expand navbar-white navbar-light">
			<!-- Left navbar links -->
			


			<!-- SEARCH FORM -->
			<form class="form-inline ml-3">
				<div class="input-group input-group-sm">
					<input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
					<div class="input-group-append">
						<button class="btn btn-navbar" type="submit">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</div>
			</form>

			<!-- Right navbar links -->
			<ul class="navbar-nav ml-auto">
				<!-- Messages Dropdown Menu -->
				<li class="nav-item dropdown"><a class="nav-link" data-toggle="dropdown" href="#"> <i class="far fa-comments"></i> <span class="badge badge-danger navbar-badge">3</span>
				</a>
					<div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
						<a href="#" class="dropdown-item"> <!-- Message Start -->
							<div class="media">
								<img src="./resources/bootstrap/dist/img/user1-128x128.jpg" alt="User Avatar" class="img-size-50 mr-3 img-circle">
								<div class="media-body">
									<h3 class="dropdown-item-title">
										Brad Diesel <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span>
									</h3>
									<p class="text-sm">Call me whenever you can...</p>
									<p class="text-sm text-muted">
										<i class="far fa-clock mr-1"></i> 4 Hours Ago
									</p>
								</div>
							</div> <!-- Message End -->
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item"> <!-- Message Start -->
							<div class="media">
								<img src="./resources/bootstrap/dist/img/user8-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
								<div class="media-body">
									<h3 class="dropdown-item-title">
										John Pierce <span class="float-right text-sm text-muted"><i class="fas fa-star"></i></span>
									</h3>
									<p class="text-sm">I got your message bro</p>
									<p class="text-sm text-muted">
										<i class="far fa-clock mr-1"></i> 4 Hours Ago
									</p>
								</div>
							</div> <!-- Message End -->
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item"> <!-- Message Start -->
							<div class="media">
								<img src="./resources/bootstrap/dist/img/user3-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
								<div class="media-body">
									<h3 class="dropdown-item-title">
										Nora Silvester <span class="float-right text-sm text-warning"><i class="fas fa-star"></i></span>
									</h3>
									<p class="text-sm">The subject goes here</p>
									<p class="text-sm text-muted">
										<i class="far fa-clock mr-1"></i> 4 Hours Ago
									</p>
								</div>
							</div> <!-- Message End -->
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item dropdown-footer">See All Messages</a>
					</div></li>
				<!-- Notifications Dropdown Menu -->
				<li class="nav-item dropdown"><a class="nav-link" data-toggle="dropdown" href="#"> <i class="far fa-bell"></i> <span class="badge badge-warning navbar-badge">15</span>
				</a>
					<div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
						<span class="dropdown-header">15 Notifications</span>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item"> <i class="fas fa-envelope mr-2"></i> 4 new messages <span class="float-right text-muted text-sm">3 mins</span>
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item"> <i class="fas fa-users mr-2"></i> 8 friend requests <span class="float-right text-muted text-sm">12 hours</span>
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item"> <i class="fas fa-file mr-2"></i> 3 new reports <span class="float-right text-muted text-sm">2 days</span>
						</a>
						<div class="dropdown-divider"></div>
						<a href="#" class="dropdown-item dropdown-footer">See All Notifications</a>
					</div></li>
				<li class="nav-item"><a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#"><i class="fas fa-th-large"></i></a></li>
			</ul>
		</nav>
		<!-- /.navbar -->


		<!-- Main Sidebar Container -->
		<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<!-- Brand Logo -->
			<a href="${cp }/boardlist" class="brand-link"> <img src="./resources/images/line.png" class="brand-image img-circle elevation-3" style="opacity: .8"> <span
				class="brand-text font-weight-light">게시판생성</span>
			</a>

			<!-- Sidebar -->
			<div class="sidebar">
				<!-- Sidebar user panel (optional) -->
				<div class="user-panel mt-3 pb-3 mb-3 d-flex">
					<%@ include file="/common/left.jsp"%>
				</div>

				
				<!-- Sidebar Menu -->
				<nav class="mt-2">
					<ul class="nav nav-pills nav-sidebar flex-column subMenuList" data-widget="treeview" data-accordion="false">

					</ul>
				</nav>
				<!-- /.sidebar-menu -->
			</div>

			<!-- /.sidebar -->
		</aside>


		<div id="if_list_div" style="position: relative; padding: 0; overflow: hidden; height: 750px;">
			<div class="content-wrapper" style="min-height: 584px;">
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<div class="container-fluid">
						<div class="row md-2">
							<div class="col-sm-6">
								<h1>게시판 리스트</h1>
							</div>
							<div class="col-sm-6">
								<ol class="breadcrumb float-sm-right">
									<li class="breadcrumb-item">회원리스트</li>
									<li class="breadcrumb-item">목록</li>
									<%-- <li><a href="${cp }/logout">logout</a></li> --%>
								</ol>
							</div>
						</div>
					</div>
				</section>
				<!-- Main content -->
				<section class="content">
					<div class="card">
						<div class="card-header with-border">
						</div> 
						
						<form action="${cp }/RegistBoard" method="post">
						<input type="hidden" name="bor_no" value="${bor_no}">
						<br><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;제목&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input  class="col-sm-6" type="text" name="title" value=""/>
						<div class="card-body" style="text-align: center;">
						<textarea id="summernote" name="cont" ></textarea>
						<input type="hidden" name="user_id" value="${S_USER.userid}">
								<div class="col-sm-12">
						<label>첨부파일</label> <!--   <input  class="col-sm-3" type="file" name="file" value=""/> -->
							<input type="submit" class="btn btn-primary" value="등록완료"  />
							<div class="row">
									
								</div>
								<!-- col-sm-12 -->
							</div>
							<!-- row -->
						</div>
						</form>
						
						<!-- card-body -->
						<div class="card-footer">
							<!-- 페이징 처리 -->
									<nav aria-label="member list Navigation">
										<ul class="pagination justify-content-center m-0">
											<li class="page-item"><a class="page-link" 
													href="${cp }/boardPost?page=1&pageSize=${pageVo.pageSize}&bor_no=${pageVo.bor_no}"><i class="fas fa-angle-double-left"></i></a></li>
													
		
											<c:choose>
												<c:when test="${pageVo.page-1 <1}">
													<li class="page-item"><a class="page-link"
														href="${cp }/boardPost?page=${pageVo.page }&pageSize=${pageVo.pageSize}&bor_no=${pageVo.bor_no}">
														<i class="fas fa-angle-left"></i></a></li>
												</c:when>
												<c:otherwise>
													<li class="page-item"><a class="page-link"
														href="${cp }/boardPost?page=${pageVo.page-1 }&pageSize=${pageVo.pageSize}&bor_no=${pageVo.bor_no}">
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
															href="${cp }/boardPost?page=${i }&pageSize=${pageVo.pageSize}&bor_no=${pageVo.bor_no}">${i }</a></li>
													</c:otherwise>
												</c:choose>
											</c:forEach>
											<c:choose>
												<c:when test="${pageVo.page+1 > pagination}">
													<li class="page-item"><a class="page-link"
														href="${cp }/boardPost?page=${pageVo.page}&pageSize=${pageVo.pageSize}&bor_no=${pageVo.bor_no}"><i
															class="fas fa-angle-right"></i></a></li>
												</c:when>
												<c:otherwise>
													<li class="page-item"><a class="page-link"
														href="${cp }/boardPost?page=${pageVo.page+1 }&pageSize=${pageVo.pageSize}&bor_no=${pageVo.bor_no}"><i
															class="fas fa-angle-right"></i></a></li>
												</c:otherwise>
											</c:choose>
												<li class="page-item"><a class="page-link" href="${cp }/boardlist?page=${pagination }&pageSize=${pageVo.pageSize}&bor_no=${pageVo.bor_no}"><i class="fas fa-angle-double-right"></i></a></li>
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
	

</body>
</html>



