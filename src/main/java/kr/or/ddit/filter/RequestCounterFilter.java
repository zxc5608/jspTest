package kr.or.ddit.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestCounterFilter implements Filter{
	private static final Logger logger = LoggerFactory.getLogger(RequestCounterFilter.class);
	Map<String, Integer> requestCountMap= new HashMap<String, Integer>();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.debug("init()");
		ServletContext sc =  filterConfig.getServletContext();
		sc.setAttribute("requestCountMap", requestCountMap);
	}
	
	//filter.doFilter == servlet.service
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
	// request객체를 이용하여 요청된 URI 정보를 카운팅
		HttpServletRequest req = (HttpServletRequest)request;
		String uri = req.getRequestURI();
		logger.debug("request uri :{}",uri);
		
	//requestCountMap에 uri에 해당 키가 있을수도 있고 없을 수도 있음
		if(requestCountMap.get(uri)==null) {
			requestCountMap.put(uri,1);
		}
		//최초 요청이  아닌경우 - 과거에 이미 요청이 된 적이 있는 경우 
		else {
			int requestCount=requestCountMap.get(uri);
			requestCountMap.put(uri,requestCount+1);
		}
		
	//초기화 메소드로 해당 로직 이관 (init)
//		ServletContext sc =  req.getServletContext();    
//		sc.setAttribute("requestCountMap", requestCountMap);
		
		//다른 필터가 있을경우 필터로 ,필터가 없을 경우 해당요청을 처리하는 servlet,jsp로 요청위임
		chain.doFilter(request, response);
				
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
