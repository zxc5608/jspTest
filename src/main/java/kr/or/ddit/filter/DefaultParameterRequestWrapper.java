package kr.or.ddit.filter;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class DefaultParameterRequestWrapper extends HttpServletRequestWrapper{

	private Map<String, String[]> customMap;
	public DefaultParameterRequestWrapper(HttpServletRequest request) {
		super(request);
		
		customMap = new HashMap<String, String[]>(request.getParameterMap());
		
		//사정에 의해서 모든 요청객체에 UNT_CD 파라미터로 DDIT문자열 값을 넣어줘야하는 상황
		customMap.put("UNT_CD", new String[]{"DDIT"});
	}

	@Override
	public String getParameter(String name) {
		//키에 해당하는값중에 첫번째 값을 반환
		//키에 해당하는 값이 없을때? ==> null
		String[] values= customMap.get(name);
		if(values==null || values.length == 0)
			return null;
		else
			return values[0];
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		// TODO Auto-generated method stub
		return customMap;
	}
	@Override
	public Enumeration<String> getParameterNames() {
		
		return Collections.enumeration(customMap.keySet());
	}
	@Override
	public String[] getParameterValues(String name) {
		// 
		return customMap.get(name);
	}
}
