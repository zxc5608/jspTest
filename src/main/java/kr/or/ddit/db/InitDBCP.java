package kr.or.ddit.db;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@WebServlet(value="/initDBCP",loadOnStartup = 1)
public class InitDBCP extends HttpServlet{
	private static final Logger logger = LoggerFactory.getLogger(InitDBCP.class);
	@Override
	public void init() throws ServletException {
		logger.debug("InitDBCP.init()");
		
		//컨넥션 풀 생성 
		//application scope에 컨넥션 풀 저장
		BasicDataSource bs = new BasicDataSource();
		bs.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bs.setUsername("yongyong");
		bs.setPassword("java");
		bs.setInitialSize(20);
				
		//dbcp.jsp에서는 application scope저장된 컨넥션풀을 사용하여 컨넥션 객체를
		//얻고 해제하는과정을 반복 시간체크
		
		//application객체 담는 메소드== ServletContext
		ServletContext sc = getServletContext();
		sc.setAttribute("bs", bs);
		
		
		
		
	}

}
