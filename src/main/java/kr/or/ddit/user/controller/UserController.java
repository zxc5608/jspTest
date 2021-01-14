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
	
		
		String userid = req.getParameter("userid");
		
		UserVo user = userservice.selectUser(userid);
		
		req.setAttribute("user", user);
		
		req.getRequestDispatcher("user/user.jsp").forward(req, resp);
		
	}
}
