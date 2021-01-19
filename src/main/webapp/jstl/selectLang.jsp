<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/common/common_lib.jsp" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
/*전송버튼 안누르고 액션  */
$(function(){
	$("select").on("change",function(){
		$("form").submit();
	});
	
	$("select").val("${param.lang }")
});

</script>
</head>
<body>
param :[${param.lang }]
<form action="${pageContext.request.contextPath }/jstl/selectLang.jsp">
<select name="lang">              
	<option value="ko" selected >한국어</option>
	<option value="en" selected >english</option>
	<option value="ja" selected >日本語</option>
	<option value="etc" selected >기타</option>
</select>                         

</form>
<br><br>
<%-- select box로 설정한 언어로 GREETING,LANG값을 표현 
	select box는 사용자가 설정한 언어 값으로 선택이 되어있게 설정--%>

<fmt:setLocale value="${param.lang }"/>
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="LANG"/> <br>
	<fmt:message key="GREETING">
		<fmt:param value="brown"/>
	</fmt:message><br>
</fmt:bundle>
</body>
</html>