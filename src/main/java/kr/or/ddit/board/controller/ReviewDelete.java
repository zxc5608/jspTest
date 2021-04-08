package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/reviewDelet")
public class ReviewDelete extends HttpServlet{
	private static final Logger logger = LoggerFactory.getLogger(ReviewDelete.class);
	BoardServiceI boardservice = new BoardService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int com_no = Integer.parseInt(req.getParameter("com_no"));
		int bor_no= Integer.parseInt(req.getParameter("bor_no"));
		int post_no =Integer.parseInt(req.getParameter("post_no"));
		
		int deleteCnt = boardservice.reviewDelete(com_no);
		

		
		if(deleteCnt==1) {
			req.setAttribute("com_no",com_no);
		
			resp.sendRedirect(req.getContextPath()+"/boardDetail?bor_no="+bor_no+"&post_no="+post_no);
		}else {
			doPost(req,resp);
		}
		
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}

}
