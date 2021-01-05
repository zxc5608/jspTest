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
    
   

    <title>login</title>

    <!-- Bootstrap core CSS -->
  
    <%@include file="/common/common_lib.jsp" %>
    <%-- common_lib.jsp 의 내용을 지금 기술되는 부분에 코드를 복사해서 붙여넣기 --%>
    
    <!--signin.css  -->
    <link href="<%=request.getContextPath() %>/css/signin.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">

  </head>

  <body>

    <div class="container">

      <form class="form-signin" action="<%=request.getContextPath()%>/loginController" method="post">
        <h2 class="form-signin-heading">login</h2>
        
        <label for="userid" class="sr-only">userid</label>
        <input type="text" name="userid" id="userid" value="brown" class="form-control" placeholder="사용자 아이디" required autofocus>
        
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="pass" id="inputPassword" value="brownpass" class="form-control" placeholder="Password" required>
        
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->


   
  </body>
</html>
