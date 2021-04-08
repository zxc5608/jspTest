package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.ComVo;
import kr.or.ddit.board.model.KboardinfoVo;
import kr.or.ddit.board.model.KboardpostVo;
import kr.or.ddit.board.model.UserVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/boardDetail")
public class boardDetail extends HttpServlet{
	BoardServiceI boardService= new BoardService();
	private static final Logger logger = LoggerFactory.getLogger(boardDetail.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		int bor_no = Integer.parseInt(req.getParameter("bor_no"));
		int post_no = Integer.parseInt(req.getParameter("post_no"));
		
		
		HttpSession session = req.getSession();
		UserVo uservo= (UserVo)session.getAttribute("S_USER");
		req.setAttribute("user", uservo);
		
		KboardpostVo boardVo= new KboardpostVo();
		boardVo.setBor_no(bor_no);
		boardVo.setPost_no(post_no);
		
		List<KboardinfoVo> boardList1= boardService.selectBoard();
		
		
		req.setAttribute("boardList1", boardList1);
		
		KboardpostVo boardVo1 = boardService.selectDetail(boardVo);
		
		logger.debug("boardVo1:"+boardVo1);
		
		List<ComVo> comList = boardService.ComSelect(post_no);
		
		
		
		req.setAttribute("comList", comList);
		req.setAttribute("board", boardVo1);
		
		req.getRequestDispatcher("/board/boardDetail.jsp").forward(req, resp);
		
		

	}

} 
