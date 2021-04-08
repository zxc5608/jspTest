package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.ComVo;
import kr.or.ddit.board.model.UserVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/reviewWrite")
public class reviewWrite extends HttpServlet{
	BoardServiceI boardservice= new BoardService();
	private static final Logger logger = LoggerFactory.getLogger(reviewWrite.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		
		String user_id = req.getParameter("user_id");
		String user_id1= req.getParameter("user_id1");
		int bor_no= Integer.parseInt(req.getParameter("bor_no"));
		int post_no =Integer.parseInt(req.getParameter("post_no"));
		String cont= req.getParameter("cont");
		
		
		
		ComVo comvo = new ComVo();
		
		comvo.setBor_no(bor_no);
		comvo.setPost_no(post_no);
		comvo.setCom_con(cont);
		
		comvo.setUser_id(user_id1);
		comvo.setCom_user_id(user_id);
		
		logger.debug("Comvo"+comvo);
		
		int insertCnt= 0;
		try {
			insertCnt = boardservice.cominsert(comvo);
		} catch (Exception e) {
			insertCnt = 0;
		}
		
		
		// 사용자 등록 성공 ==> 페이징 리스트 화면으로 이동(1페이지)
		if (insertCnt == 1) {
			logger.debug("게시글 등록 성공 insertCnt 값:{}",insertCnt );
			resp.sendRedirect(req.getContextPath()+"/boardDetail?bor_no="+bor_no+"&post_no="+post_no+"");
			
		}
		// 사용자 등록 실패 ==> 사용자 등록 페이지로 이동
		else {
			logger.debug("게시글 등록 실패 insertCnt 값:{}",insertCnt );
//			
			doPost(req, resp);
		}

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
		
		
	}

}
