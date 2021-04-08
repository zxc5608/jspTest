package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.KboardinfoVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/BoardinfoAdd")
public class BoardinfoAdd extends HttpServlet{
	private static final Logger logger = LoggerFactory.getLogger(BoardinfoAdd.class);
	private BoardServiceI BoardService = new BoardService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String bor_name = req.getParameter("bor_name");
		
		int bor_act =Integer.parseInt(req.getParameter("bor_act"));
		KboardinfoVo boardVo = new KboardinfoVo(0,bor_act,bor_name);

		logger.debug("boardVo() 진입{}",boardVo);
		int insertCnt = 0;

		try {
			insertCnt = BoardService.registBoard(boardVo);
		} catch (Exception e) {
			insertCnt = 0;
		}
 
		// 사용자 등록 성공 ==> 페이징 리스트 화면으로 이동(1페이지)
		if (insertCnt == 1) {
			logger.debug("사용자 등록 성공 insertCnt 값:{}",insertCnt );
			resp.sendRedirect(req.getContextPath()+ "/boardlist");
//		req.getRequestDispatcher("/board/MainBoard.jsp").forward(req, resp);
		}
		// 사용자 등록 실패 ==> 사용자 등록 페이지로 이동
		else {
			logger.debug("사용자 등록 실패 insertCnt 값:{}",insertCnt );
	//		req.setAttribute("userVo", userVo);
			doPost(req, resp);
		}
	}
}
	

