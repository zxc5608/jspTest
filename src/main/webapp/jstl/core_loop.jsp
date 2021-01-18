<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	for(1.초기화;2.조건체크;4.증감식){
		3.반복할 문장
	}
	1-2-3-4-2-3-4
	begin : 시작 인덱스 값
	end   : 종료 인덱스 값
	step  : 증감 값 (default 1)
	var   : 인덱스 변수 or 향상된 for문에서 사용될 경우 collection객체에서 꺼낸 값 설정 
	varStatus :루프변수 
		index - 현재 인덱스 값
		count - 루프 실행횟수
		begin, end - 루프의 begin,end 값
 --%>
 <h3>일반 for문 형태</h3>
	<c:forEach begin="0" end="10" var ="i" varStatus="loop">
		${i }:반복시킬 문장${loop.index }/${loop.count }<br>
	</c:forEach>
	
<hr>
 <h3>향상된 for 문 형태 </h3>
 <%
 	List<String> rangers = new ArrayList<String>();
	rangers.add("brown");
	rangers.add("cony");
	rangers.add("sally");
	rangers.add("moon");
	rangers.add("james");
	request.setAttribute("rangers",rangers);
	
	/*
	 for(String ranger :(List<String>request.getAttribute("rangers")) ){
		 
	 }
	
	<c:forEach items = "${rangers}" var ="ranger">
	</c:forEach>
	*/
 %>
 
 <c:forEach items="${rangers }" var ="ranger" varStatus="loop">
 	${ranger }/${loop.index }/${loop.count }/${loop.begin }<br>
 </c:forEach>
 -----------------------------오후-------------------------------
 <h3> map 타입 객체 루프를 통해 담겨진 값 확인하기</h3>
 <%
 	Map<String,String>map= new HashMap<String,String>();
 	map.put("userid","brown");
 	map.put("usernm","브라운");
 	map.put("useralias","곰");
 	request.setAttribute("ranger", map);
 
 //	map, list? 
 // map : 순차적으로 접근이 아닌, 특정 키에 의해 원하는 값을 확인하고 싶을때
 // list : 순차적으로 접근하고 싶을 때
 // for(String str: list)==> 리스트에 담겨있는 모든 값에 대해 처리
 // map에 담겨진 모든 값을 확인??
	
	for(String key : map.keySet()){
		map.get(key);
	}
 
 %>
 <c:forEach items="${ranger }" var= "entry">
 	${entry.key }/ ${entry.value }<br>
 </c:forEach>
 
 <h3>url 작성</h3>
 <a href="<c:url value="/registUser" />">사용자 등록</a>
 <a href="${pageContext.request.contextPath } }/registUser">사용자 등록</a>
 <a href="${cp } }/registUser">사용자 등록</a>
 
var 속성을 적용하지 않은경우: 태그를 작성한 곳에 출력 <c:url value="/registUser" var ="url"/><br>
var 속성을 적용한경우 :var속성으로 저장만 한다(el을 통해 활용)<c:url value="/registUser" var ="url"/>
 ${url }
 
	
</body>
</html>