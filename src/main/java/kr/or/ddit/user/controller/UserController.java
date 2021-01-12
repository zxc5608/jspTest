package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;
@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private UserServiceI userservice= new UserService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		 
		//1)userid parameter확인 파라미터받고
		String userid = req.getParameter("userid");
		
		//2) userService객체를 이용하여 파라미터에 해당하는 사용자 정보 조회  조회하고
		UserVo user = userservice.selectUser(userid);
		
		// 3) request객체에 2)번에 조회된 값을 user라는 속성으로 저장 저장하고
		req.setAttribute("user", user);
		
		// 4) webapp/user/user.jsp로 화면 생성 위임
		req.getRequestDispatcher("user/user.jsp").forward(req, resp);
		
	}
}
