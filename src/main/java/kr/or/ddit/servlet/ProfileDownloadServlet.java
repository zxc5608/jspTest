package kr.or.ddit.servlet;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.UserVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/profileDownload")
public class ProfileDownloadServlet extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(ProfileDownloadServlet.class);
	
	private BoardServiceI boardservice= new BoardService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userid= req.getParameter("userid");		
		UserVo uservo =boardservice.selectUser(userid);
		
		resp.setContentType("image");
		String path ="";
		String filename="";
		
		if(uservo.getRealfilename() == null) {
			path = getServletContext().getRealPath("/image/unknown.png");
		}
		else {
			path= "d:\\upload\\"+uservo.getRealfilename();			
		}
		
		resp.setHeader("Content-Disposition", "attachment; filename="+uservo.getFilename());
		
		//userid 파라미터를 이용하여 
		//userService객체를 통해 사용자의 사진 파일 이름을 획득
		//파일 입출력을 통해 사진을 읽어들여 resp객체의 outputStream으로 응답생성
		
		path= "d:\\upload\\"+uservo.getRealfilename();
		logger.debug("path:{}",path);
		
		FileInputStream fis = new FileInputStream(path);
		ServletOutputStream sos = resp.getOutputStream();
		
		byte[]buff=new byte[512];
		while(fis.read(buff)!= -1) {
			sos.write(buff);
		}
		fis.close();
		sos.close();
		
	}

}
