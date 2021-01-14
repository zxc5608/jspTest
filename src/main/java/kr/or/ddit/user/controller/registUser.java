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

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;
@WebServlet("/registUser")
public class registUser extends HttpServlet{
	private UserServiceI userservice= new UserService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		
		int updateCnt=0;
		try {
		    updateCnt  = userservice.registUser(userVo);// 여기서 예외가 발생할수있다
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(updateCnt==1) {
			resp.sendRedirect(req.getContextPath()+"/pagingUser");
		}else {
			resp.sendRedirect(req.getContextPath()+"/registUser");

			
			
		}
	
	}
}
