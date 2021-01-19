package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class encodingFilter implements Filter{
	private static final Logger logger = LoggerFactory.getLogger(encodingFilter.class);
	private String encoding;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.debug("init()");
	     encoding = filterConfig.getInitParameter("encoding");
         
         //인코딩을 따로 지정하지 않은 경우 기본값 세팅
         if(encoding == null) {
              encoding = "utf-8";
         }



		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		  
		request.setCharacterEncoding(encoding);
        chain.doFilter(request, response);

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
