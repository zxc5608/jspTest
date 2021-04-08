package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.KboardinfoVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/boardlist")
public class BoardAllList extends HttpServlet{
	
	BoardServiceI boardService = new BoardService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<KboardinfoVo> boardList = boardService.SelectAllboard();
		List<KboardinfoVo> boardList1= boardService.selectBoard();
		
		
		req.setAttribute("boardList1", boardList1);
		req.setAttribute("boardList", boardList);
		
		req.getRequestDispatcher("/board/main.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
