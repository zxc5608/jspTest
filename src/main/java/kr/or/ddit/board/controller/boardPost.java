package kr.or.ddit.board.controller;

import java.io.IOException;
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
import kr.or.ddit.common.model.PageVo;

@WebServlet("/boardbost")
public class boardPost extends HttpServlet{
	BoardServiceI boardservice = new BoardService();
	private static final Logger logger = LoggerFactory.getLogger(boardPost.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pageParam = req.getParameter("page");
		String pageSizeParam = req.getParameter("pageSize");
		int bor_no = Integer.parseInt(req.getParameter("bor_no"));
		
		
		int page = pageParam ==null ? 1: Integer.parseInt(pageParam);
		int pageSize = pageSizeParam ==null ? 10: Integer.parseInt(pageSizeParam);
		
		PageVo pagevo= new PageVo(page,pageSize,bor_no);
		logger.debug("page{}"+page);
		
		List<KboardinfoVo> infoList= boardservice.SelectAllboard();
		List<KboardpostVo> boardList= boardservice.selectPost(pagevo);
		
		List<KboardinfoVo> boardList1= boardservice.selectBoard();
		
		
		req.setAttribute("boardList1", boardList1);
		logger.debug("infoList{}"+infoList);
		
		int postCnt = boardservice.selectPostCnt(bor_no);
		logger.debug("cnt{}"+postCnt);
		int pagination = (int)Math.ceil((double)postCnt/pageSize);
		
		for (KboardpostVo kboardpostVo : boardList) {
			logger.debug("aa{}"+kboardpostVo.getUser_id());
		}
	
		req.setAttribute("infoList", infoList);
		req.setAttribute("boardList", boardList);
		req.setAttribute("pagination",pagination);
		req.setAttribute("pageVo",pagevo);
		logger.debug("boardList{}"+boardList);
		
		req.getRequestDispatcher(req.getContextPath()+"/board/boardAllPost.jsp").forward(req, resp);
		
		
		
	}

}
