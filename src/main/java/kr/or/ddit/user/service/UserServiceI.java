package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface UserServiceI {
	List<UserVo> selectAllUser();

	//userid에 해당하는 사용자 한명의 정보
	UserVo selectUser(String userid);

	
	Map<String, Object> selectpagingUser(PageVo vo);
}
