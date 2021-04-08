package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.KboardinfoVo;
import kr.or.ddit.board.model.KboardpostVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/boardreple")
public class Boardreple extends HttpServlet{
	private BoardServiceI boardService= new BoardService();
	private static final Logger logger = LoggerFactory.getLogger(Boardreple.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int bor_no =  Integer.parseInt(req.getParameter("bor_no"));
		int post_no =  Integer.parseInt(req.getParameter("post_no"));
		
		List<KboardinfoVo> boardList= boardService.selectBoard();
		
		req.setAttribute("boardList", boardList);
		
		req.setAttribute("bor_no", bor_no);
		req.setAttribute("post_no", post_no);
		
		req.getRequestDispatcher("/board/repleWrite.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int bor_no =  Integer.parseInt( req.getParameter("bor_no") );
		int post_no =  Integer.parseInt( req.getParameter("post_no") );
		
		String user_id =   req.getParameter("user_id");
		
		String title = req.getParameter("title");
		String cont = req.getParameter("cont");
		
		KboardpostVo boardVo = new KboardpostVo(bor_no, 1, user_id, title, cont, new Date(), 1, post_no, 0, "");
		logger.debug(" boardVo{}",boardVo);
	
		int insertCnt = boardService.repleinsert(boardVo);
		
 
		// 사용자 등록 성공 ==> 페이징 리스트 화면으로 이동(1페이지)
		if (insertCnt == 1) {
			logger.debug("게시글 등록 성공 insertCnt 값:{}",insertCnt );
			resp.sendRedirect(req.getContextPath() + "/boardlist");
		}
		// 사용자 등록 실패 ==> 사용자 등록 페이지로 이동
		else {
			logger.debug("게시글 등록 실패 insertCnt 값:{}",insertCnt );
//			
			doGet(req, resp);
		}

	}
}
