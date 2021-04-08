package kr.or.ddit.listener;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.UserVo;

public class LoginUserListener implements HttpSessionAttributeListener{
	private static final Logger logger = LoggerFactory.getLogger(LoginUserListener.class);
	private Set<String> users= new HashSet<String>();
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		if(event.getName().equals("S_USER")) {
			UserVo user =(UserVo)event.getValue();
			logger.debug("added user : {}",user.getUsernm());
			users.add(user.getUsernm());
			
			event.getSession().getServletContext().setAttribute("USER_SET", users);
		}
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		UserVo user = (UserVo)event.getValue();
		logger.debug("removed user : {}",user.getUsernm());
		users.remove(user.getUsernm());
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {

		
	}

}
