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
@WebServlet("/BoardDelete")
public class BoardDelete extends HttpServlet{
	
	private BoardServiceI boardservice= new BoardService();
	private static final Logger logger = LoggerFactory.getLogger(BoardDelete.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int post_no= Integer.parseInt(req.getParameter("post_no"));
		int bor_no = Integer.parseInt(req.getParameter("bor_no"));
		String title = req.getParameter("title");
		String cont = req.getParameter("cont");
		String user_id = req.getParameter("user_id");
		
		int updateCnt = 0;
		
		try {
		updateCnt = boardservice.deleteBoardPost(post_no);
			
		} catch (Exception e) {
			updateCnt =0;
		}
		if(updateCnt ==1 ) {
			//	 불가능 - get 방식으로 보낼 수 없음 req.getRequestDispatcher("/user/user.jsp").forward(req, resp);
			req.setAttribute("post_no", post_no);
			req.setAttribute("bor_no", bor_no);
			req.setAttribute("user_id", user_id);
			resp.sendRedirect(req.getContextPath() +"/boardPost?post_no="+post_no+"&bor_no="+bor_no+"&user_id="+user_id+"");
		}
		//사용자 수정이 비정상적으로 된 경우 ==> 해당 사용자의 정보수정 페이지로 이동
		else {
			doGet(req, resp);
		}
	}

}
