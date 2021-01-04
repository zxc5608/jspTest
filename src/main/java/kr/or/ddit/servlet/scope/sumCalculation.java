package kr.or.ddit.servlet.scope;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet{
	private static final Logger logger = LoggerFactory.getLogger(sumCalculation.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/sumCalculation.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession();
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		
		int sum=0;
		for(int i=num1;i<=num2;i++) {
			sum+=i;
		}
		logger.debug("합:"+sum);
		session.setAttribute("num1",num1);
		session.setAttribute("num2",num2);
		session.setAttribute("sumResult",sum);
		
		req.getRequestDispatcher("/jsp/sumResult.jsp").forward(req, resp);
	}

}
