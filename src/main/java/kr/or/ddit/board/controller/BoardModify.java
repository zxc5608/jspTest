package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.KboardpostVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/BoardModify")
public class BoardModify extends HttpServlet{
	private BoardServiceI boardservice= new BoardService();
	private static final Logger logger = LoggerFactory.getLogger(BoardModify.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_id= req.getParameter("user_id");
		String title = req.getParameter("title");
		int bor_no = Integer.parseInt(req.getParameter("bor_no"));
		int post_no = Integer.parseInt(req.getParameter("post_no"));
		String cont = req.getParameter("cont");
		

		//수정할 jsp로 전송
		
		req.setAttribute("user_id", user_id);
		req.setAttribute("post_no", post_no);
		req.setAttribute("title", title);
		req.setAttribute("cont", cont);
		req.setAttribute("bor_no", bor_no);
		
		req.getRequestDispatcher("/board/ModityBoard.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//게시글에서 수정한 데이터 가져오기
		req.setCharacterEncoding("utf-8");
		
		String user_id= req.getParameter("user_id");
		String title = req.getParameter("title");
		int bor_no = Integer.parseInt(req.getParameter("bor_no"));
		int post_no = Integer.parseInt(req.getParameter("post_no"));
		String cont = req.getParameter("cont");
		
		KboardpostVo boardVo= new KboardpostVo();
		
		boardVo.setTitle(title);
		boardVo.setPost_no(post_no);
		boardVo.setCont(cont);

		int updateCnt = 0;
		
		try {
			updateCnt =  boardservice.UpdateBoardPost(boardVo);
		} catch (Exception e) {
			updateCnt=0;
		}
		
		if(updateCnt ==1 ) {
			//	 불가능 - get 방식으로 보낼 수 없음 req.getRequestDispatcher("/user/user.jsp").forward(req, resp);
			logger.debug("수정 성공 {}",updateCnt );
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
