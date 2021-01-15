<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	Connection conn = null;
	Statement stmt =null;
	ResultSet rs= null;
	 
	try {
		//1 드라이버 로딩 
		long startTime = System.currentTimeMillis();	
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. DB연결 ==> Connection 객체생성
		for(int i= 0;i<30;i++){
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"yongyong",
					"java");  //db에 연결이되면 커넥션객체가 연결이됨
			conn.close();
		}
		long endTime= System.currentTimeMillis();
		out.print("duration:"+(endTime-startTime));
	
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		//6. 사용 했던 자원 반납 하기
		if(rs!=null)try {rs.close();}catch(SQLException e) {}
		if(stmt!=null)try {stmt.close();}catch(SQLException e) {}
		if(conn!=null)try {conn.close();}catch(SQLException e) {}
	}
	
	%>
</body>
</html>