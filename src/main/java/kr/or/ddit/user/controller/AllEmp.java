package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.empVo;
import kr.or.ddit.user.service.empService;
import kr.or.ddit.user.service.empServiceI;

@WebServlet("/EmpAll")
public class AllEmp extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		empServiceI empService= new empService();
		
		List<empVo>emplist= empService.selectAllEmp();
		
		req.setAttribute("emplist", emplist);
		req.getRequestDispatcher("/user/AllEmp.jsp").forward(req, resp);
		
	}



}
