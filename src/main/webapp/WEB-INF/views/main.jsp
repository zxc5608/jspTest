
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
	$('#searchBtn').on('click', function(){
		//정렬 개수 select box
		li = $('#PageNum').val();
		//구분 값
		type = $('#searchType').val();
		//검색 값
		keyword = $('#keywords').val();
		console.log(li + "," + type + "," + keyword)
		location.href='${cp}/searchPagingUser?page=1&pageSize='+li+'&type='+type+'&keyword='+keyword+'';
		
	})

	//문서로딩이 완료되고 나서 실행되는 영역
	$(function() {
		$(".board").on("click", function() {
			//this: 클릭 이벤트가 발생한 element    
			//data-속성명 data-userid, 속성명은 대소문자 무식하고 소문자로 인식
			//data-userID==> data-userid
			var userid = $(this).data("userid");
			//var userid = ($(this).data("userid"));
			$("#userid").val(userid);
			$("#frm").submit();

		});
		$("#insertBtn").on("click",function(){
		var bor_act =$("#bor_act").val();
		alert(bor_act);
		var bor_name =$("#bor_name").val();
		location.href="${cp}/board/BoardinfoAdd?bor_act="+bor_act+"&bor_name="+bor_name+"";
		
		});
		
		
	
	});
</script>

</head>
<body class="hold-transition sidebar-mini">

	<form id="frm" action="${cp }/boardlist">
		<input type="hidden" id="userid" name="userid" value="" />
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
									<li class="breadcrumb-item">게시판</li>
									<li class="breadcrumb-item">목록</li>
								</ol>
							</div>
						</div>
					</div>
				</section>
				<!-- Main content -->
				<section class="content">
					<div class="card">
						<div class="card-header with-border" >

							


							<div id="keyword" class="card-tools" style="width: 550px;">
								<div class="input-group row" style="width: 200px;" >
									<!-- sort num -->

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
												<th>게시판 이름</th>
												<th>
												<input type="text" value="자유게시판" id="bor_name"/>
												</th>
												<th>
													<select class="form-control col-md-7" name="searchType" id="bor_act">
														<option value="1">사용</option>
														<option value="2">미사용</option>
													</select>
												</th>
												<th>
													<input type="button" value="생성" id="insertBtn"/> 
												</th>
											</tr>
											
											


										</tbody>
									</table>
								</div>
								<!-- col-sm-12 -->
							</div>
							<!-- row -->
								<div class="col-sm-12">
						
											
					<c:forEach items="${boardList }" var="board">
							 <form id="frm" action="${cp}/board/boardupdate" method="get"> 
									<input type="hidden" name="bor_no" value="${board.bor_no }"/>
								<div  class="col-sm-7" >
								<label> &nbsp;&nbsp;&nbsp;&nbsp;게시판 이름 &nbsp;&nbsp;&nbsp;  </label> &nbsp;&nbsp;&nbsp;<input value="${board.bor_name }" readonly>
									<c:choose>
										<c:when test="${board.bor_act ==1 }">
											
												<select class=" col-md-2" name="bor_act"  id="board.bor_act">
													<option value="1" selected="selected">사용</option>
													<option value="0">미사용</option>
												</select>
											
										</c:when>
										<c:otherwise>
											
												<select class=" col-md-2" name="bor_act" id="board.bor_act" >
													<option value="1">사용</option>
													<option value="0"  selected="selected">미사용</option>
												</select>
											
										</c:otherwise>
									</c:choose>
									<input type="submit" id="updateBtn" value="수정"/>
								</div>
							</form>
						</c:forEach> 
						
											</div>
						</div>
						<!-- card-body -->
						<div class="card-footer">
						

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







