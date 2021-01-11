package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/pagingUser")
public class PagingUser extends HttpServlet{
	UserServiceI userservice = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//left.jsp: /pagingUser?page=1&pageSize=5
		//==> /paging User
		
		//doget메소드에서 page, pageSize 파라미터가 request객체에 존재하지 않을때
		//page는 1로 pagesize 5로 생각을 코드를 작성
		//파라미터가 존재하면 해당 파라미터를 이용 
		
		
		//refactoring : 코드를(깔끔하게) 바꾸는데 기존 동작방식을 유지한채로 변경하는 기법   alt + shift + l 
		String pageParam = req.getParameter("page");
		String pageSizeParam = req.getParameter("pageSize");
		
		/*
		 * request객체에서 제공하는 파라미터 관련메소드
		 * 
		 */
		
		int page= pageParam ==null ? 1 :Integer.parseInt(pageParam);
		int pageSize= pageSizeParam==null ? 5 : Integer.parseInt(pageSizeParam);
		
		PageVo vo = new PageVo(page,pageSize);
		
	/*
		if(req.getParameter("page")==null){
			page=1;
		}else {
			page = Integer.parseInt(req.getParameter("page"));
		}
		if(req.getParameter("pageSize")==null) {
			pageSize=1;
		}else {
			pageSize = Integer.parseInt(req.getParameter("pageSize"));
		}
	*/
		Map<String, Object>map= userservice.selectpagingUser(vo);
		
		List<UserVo> userList= (List<UserVo>)map.get("userList");
		int userCnt = (int)map.get("userCnt");		
		int pagination = (int)Math.ceil((double)userCnt/pageSize);
		
	
		req.setAttribute("userList", userList);
		req.setAttribute("pagination",pagination);
		
		req.getRequestDispatcher("/user/pagingUser.jsp").forward(req, resp);
		
	}
	
	
	

}
