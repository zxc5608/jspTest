package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.User;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.respository.UserDao;
import kr.or.ddit.user.respository.UserDaoI;

public class UserService implements UserServiceI {
	
	private UserDaoI userDao = new UserDao();
	
	@Override
	public List<UserVo> selectAllUser() {
			
		return userDao.selectAllUser();
	}

	@Override
	public UserVo selectUser(String userid) {
	
		return userDao.selectUser(userid);
	}

	@Override
	public Map<String, Object> selectpagingUser(PageVo pvo) {
		Map<String,Object>map = new HashMap<String,Object>();
		
		List<UserVo>userList= userDao.selectpagingUser(pvo);
		int userCnt = userDao.selectAlluserCnt();
		
		map.put("userList", userList);
		map.put("userCnt", userCnt);
		
		return map;
	}

	@Override
	public int modifyUser(UserVo userVo) {
		return userDao.modifyUser(userVo);
	}

	@Override
	public int registUser(UserVo userVo) {
		return userDao.registUser(userVo);
	}
}
