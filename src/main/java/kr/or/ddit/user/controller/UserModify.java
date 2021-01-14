package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
@WebServlet("/userModify")
public class UserModify extends HttpServlet{
	private static final Logger logger = LoggerFactory.getLogger(UserModify.class);
	private UserServiceI userservice= new UserService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userid = req.getParameter("userid");
		
		UserVo user= userservice.selectUser(userid);
		
		req.setAttribute("user", user);
		
		req.getRequestDispatcher("user/userModify.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//파라미터를 읽기전에 실행
		//servlet의 doPost메소드 마다 실행 필요 ==> Filter
		req.setCharacterEncoding("utf-8");
		
		String userid =req.getParameter("userid");
		String usernm =req.getParameter("usernm");
		String pass = req.getParameter("pass");
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy.MM.dd");
		Date reg_dt = null;
		try {
			reg_dt = sdf.parse(req.getParameter("reg_dt"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String alias= req.getParameter("alias");
		String addr1= req.getParameter("addr1");
		String addr2= req.getParameter("addr2");
		String zipcode= req.getParameter("zipcode");
		
		UserVo userVo = new UserVo(userid,usernm,pass,reg_dt,alias,addr1,addr2,zipcode);
		
		int updateCnt  = userservice.modifyUser(userVo);
		
		if(updateCnt==1) {
			
			resp.sendRedirect(req.getContextPath()+"/user?userid="+userid);
			
		}else {
			doGet(req, resp);
			
		}
		
	
				
	}
}
