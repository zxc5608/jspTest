package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class DefaultParameterFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//인자로 들어온 request 객체를 이용하여 wrapper로 만들고
		//chain.doFilter메소드를 이용하여 다른 필터나 서블릿으로 요청을 전달할때
		//wrapper클래스 전달 
		
		DefaultParameterRequestWrapper wrapper= new DefaultParameterRequestWrapper((HttpServletRequest)request);
		
		chain.doFilter(wrapper, response);
		
	}

	@Override
	public void destroy() {
		
		
	}

}
