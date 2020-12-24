package kr.or.ddit.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicServlet extends HttpServlet{

	//doXXX메소드의 인자: req, res 
	//GET, POST , DELETE ,PUSH , HEAD ... : HTTP 메소드
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//재정의 
		PrintWriter pw = resp.getWriter();
		pw.println("hello world");
		
		pw.flush();		//더이상 작성할 내용이 없으므로 작업을 마무리한다
		pw.close();		// 사용한 자원의 반납
		
	}
	
	 
	
	
	
	
	
}
