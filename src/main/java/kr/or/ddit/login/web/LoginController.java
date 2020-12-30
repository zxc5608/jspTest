package kr.or.ddit.login.web;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 web.xml에 설정하는 servlet,servlet-mapping을 어노테이션을 통해 설정하는 방법
 */
@WebServlet("/loginController")
public class LoginController extends HttpServlet {
	//요청 메소드와 관련없이 서블릿을 동작하게 하려면
	//사용자가 get으로 보내든post로 보내든  = service로 보내면된다.
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		//사용자가 userid, pass 파라미터를 전송했다는 가정으로 개발
		
		//하나의 파라미터 확인
		logger.debug("하나의 파라미터 확인");
		logger.debug("req.getParameter(\"userid\"):{}",req.getParameter("userid"));
		logger.debug("req.getParameter(\"pass\"):{}",req.getParameter("pass"));
		
		//복수개의 값을 갖는 파라미터 확인
		logger.debug("복수개의 값을 갖는 파라미터 확인");
		logger.debug("req.getParameterValues(\"userid\"):");
		
		for(String userid: req.getParameterValues("userid")) {
			logger.debug(userid);
		}
		
		//요청에 담긴 파라미터 이름을 확인
		logger.debug("요청에 담긴 파라미터 이름 확인");
		logger.debug("req.getParameterNames():");
		
		Enumeration<String>enumeration = req.getParameterNames();
		while(enumeration.hasMoreElements()) {
			logger.debug(enumeration.nextElement());
		}
		
		//요청에 담긴 파라미터를 관리하는 맵객체 확인
		logger.debug("요청에 담긴 파라미터를 관리하는 맵 객체 확인");
		logger.debug("req.getParameterMap():{}",(Object)req.getParameterMap());
		Map<String, String[]>map= req.getParameterMap();
		Set<String>keys = map.keySet();
		Iterator<String>it =keys.iterator();
		
		while(it.hasNext()) {
			logger.debug("{}",map.get(it.next()));
			
		}
		
	}

}
