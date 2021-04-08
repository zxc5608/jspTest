<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>회원 리스트</title>

<!-- Font Awesome Icons -->
<link rel="stylesheet" href="${cp}/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="${cp}/resources/bootstrap/dist/css/adminlte.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	$('.user').on("click",function(){
		// this : 클릭이벤트가 발생한 element
		// data-속성명 data-userid, 속성명은 대소문자 무시하고 소문자로 인식
		// data-userId ==> data-userid
		var userid = $(this).data("userid");
		$('#userid').val(userid);
		$('#frm').submit();
	});
	
	$('#insBtn').on("click",function(){
		location.href= '${cp}/registUser';
	})
	
	$('#searchBtn').on('click', function(){
		//정렬 개수 select box
		li = $('#perPageNum').val();
		//구분 값
		type = $('#searchType').val();
		//검색 값
		keyword = $('#keywords').val();
		console.log(li + "," + type + "," + keyword)
		location.href='${cp}/searchPagingUser?page=1&pageSize='+li+'&type='+type+'&keyword='+keyword+'';
		
	})
	
})
</script>
</head>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">

		<!-- Navbar -->
		<nav class="main-header navbar navbar-expand navbar-white navbar-light">
			<!-- Left navbar links -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" data-widget="pushmenu" href="#"><i class="fas fa-bars"></i></a></li>
				<li class="nav-item d-none d-sm-inline-block"><a href="#" class="nav-link">HOME</a></li>
				<li class="nav-item d-none d-sm-inline-block"><a href="#;" class="nav-link">회원관리</a></li>
			</ul>

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
			<a href="/" class="brand-link"> <img src="${cp}/resources/images/line.png" class="brand-image img-circle elevation-3" style="opacity: .8"> <span
				class="brand-text font-weight-light">사용자관리</span>
			</a>

			<!-- Sidebar -->
			<div class="sidebar">
				<!-- Sidebar user panel (optional) -->
				<div class="user-panel mt-3 pb-3 mb-3 d-flex">
					<div class="image">
						<img src="${cp}/profile/sally.png" class="img-circle elevation-2" alt="User Image">
					</div>
					<div class="info">
						<div class="row">
							<a class="col-md-8" href="#" class="d-block">sally(병아리)</a>
						</div>
					</div>
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
						<form id="frm" action="${cp}/user">
							<input type="hidden" name="userid" id="userid" value=""/>
						</form>
							<button type="button" class="btn btn-primary" id="insBtn">회원등록</button>
							<div id="keyword" class="card-tools" style="width: 550px;">
								<div class="input-group row">
									<!-- sort num -->
									<select class="form-control col-md-3" name="perPageNum" id="perPageNum">
										<option value="">정렬개수</option>
										<option value="3">3개씩</option>
										<option value="5">5개씩</option>
										<option value="7">7개씩</option>
									</select>
									<!-- search bar -->
									<select class="form-control col-md-3" name="searchType" id="searchType">
										<option value="etc">검색구분</option>
										<option value="i">아이디</option>
										<option value="n">이름</option>
										<option value="a">별명</option>
									</select> 
									<input class="form-control" type="text" id="keywords" name="keyword" placeholder="검색어를 입력하세요." value=""> 
									<span class="input-group-append">
										<button class="btn btn-primary" type="button" id="searchBtn" data-card-widget="search">
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
												<th>아이디</th>
												<th>이름</th>
												<th>별명</th>
												<th>도로주소</th>
												<th>등록날짜</th>
												<!-- yyyy-MM-dd  -->
											</tr>
											<c:forEach items="${userList}" var="user">
												<tr class="user" data-userid="${user.userid}">
												<td>${user.userid}</td>
												<td>${user.usernm}</td>
												<td>${user.alias}</td>
												<td>${user.addr1}</td>
												<td><fmt:formatDate value="${user.reg_dt}" pattern="yyyy-MM-dd"/></td>
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
							<c:choose>
								<c:when test="${empty param.keyword}">
									<ul class="pagination justify-content-center m-0">
										<li class="page-item"><a class="page-link" href="${cp}/pagingUser?page=1&pageSize=${pageVo.pageSize}"><i class="fas fa-angle-double-left"></i></a></li>
										<li class="page-item"><a class="page-link" href="${cp}/pagingUser?page=${pageVo.page - 1 }&pageSize=${pageVo.pageSize}"><i class="fas fa-angle-left"></i></a></li>
	
										<c:forEach begin="1" end="${pagination}" var="i" varStatus="loop">
											<c:choose>
												<c:when test="${pageVo.page == i }">
													<li class="page-item active"><a class="page-link" href="${cp}/pagingUser?page=${i}&pageSize=${pageVo.pageSize}">${i}</a></li>
												</c:when>
												<c:otherwise>
													<li class="page-item"><a class="page-link" href="${cp}/pagingUser?page=${i}&pageSize=${pageVo.pageSize}">${i}</a></li>
												</c:otherwise>
											</c:choose>
										</c:forEach>
										<li class="page-item"><a class="page-link" href="${cp}/pagingUser?page=${pageVo.page + 1 }&pageSize=${pageVo.pageSize}"><i class="fas fa-angle-right"></i></a></li>
										<li class="page-item"><a class="page-link" href="${cp}/pagingUser?page=${pagination}&pageSize=${pageVo.pageSize}"><i class="fas fa-angle-double-right"></i></a></li>
									</ul>
								</c:when>
								<c:otherwise>
									<ul class="pagination justify-content-center m-0">
										<li class="page-item"><a class="page-link" href="${cp}/searchPagingUser?page=1&pageSize=${pageVo.pageSize}&type=${param.type}&keyword=${param.keyword}"><i class="fas fa-angle-double-left"></i></a></li>
										<li class="page-item"><a class="page-link" href="${cp}/searchPagingUser?page=${pageVo.page - 1 }&pageSize=${pageVo.pageSize}&type=${param.type}&keyword=${param.keyword}"><i class="fas fa-angle-left"></i></a></li>
	
										<c:forEach begin="1" end="${pagination}" var="i" varStatus="loop">
											<c:choose>
												<c:when test="${pageVo.page == i }">
													<li class="page-item active"><a class="page-link" href="${cp}/searchPagingUser?page=${i}&pageSize=${pageVo.pageSize}&type=${param.type}&keyword=${param.keyword}">${i}</a></li>
												</c:when>
												<c:otherwise>
													<li class="page-item"><a class="page-link" href="${cp}/searchPagingUser?page=${i}&pageSize=${pageVo.pageSize}&type=${param.type}&keyword=${param.keyword}">${i}</a></li>
												</c:otherwise>
											</c:choose>
										</c:forEach>
										<li class="page-item"><a class="page-link" href="${cp}/pagingUser?page=${pageVo.page + 1 }&pageSize=${pageVo.pageSize}&type=${param.type}&keyword=${param.keyword}"><i class="fas fa-angle-right"></i></a></li>
										<li class="page-item"><a class="page-link" href="${cp}/pagingUser?page=${pagination}&pageSize=${pageVo.pageSize}&type=${param.type}&keyword=${param.keyword}"><i class="fas fa-angle-double-right"></i></a></li>
									</ul>
									
								</c:otherwise>
							</c:choose>
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
	</div>
	<!-- ./wrapper -->

	<!-- REQUIRED SCRIPTS -->

	<!-- jQuery -->
	<script src="${cp}/resources/bootstrap/plugins/jquery/jquery.min.js"></script>

	<!-- Bootstrap 4 -->
	<script src="${cp}/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script src="${cp}/resources/bootstrap/dist/js/adminlte.min.js"></script>
	

</body>
</html>







