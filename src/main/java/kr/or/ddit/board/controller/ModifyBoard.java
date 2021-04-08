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
@WebServlet("/boardupdate")
public class ModifyBoard extends HttpServlet {
	
	private BoardServiceI boardService= new BoardService();
	private static final Logger logger = LoggerFactory.getLogger(ModifyBoard.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		int bor_no = Integer.parseInt(req.getParameter("bor_no"));
		logger.debug("bor_no");
		int bor_act = Integer.parseInt(req.getParameter("bor_act"));
		logger.debug("bor_act");
		
		KboardinfoVo boardVo= new KboardinfoVo(bor_no,bor_act,"as");
		
	
		int updateCnt = 0;
		
		try {
			updateCnt = boardService.modifyboard(boardVo);
			logger.debug(" updateCnt값 : {}", updateCnt);
		} catch (Exception e) {
			updateCnt =0;
		}
		if(updateCnt ==1 ) {
			resp.sendRedirect(req.getContextPath() +"/boardlist");
		}
		
		else {
			doGet(req, resp);
		}
		
		
		
		
		
		
	}

}
