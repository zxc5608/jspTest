package kr.or.ddit.user.respository;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface UserDaoI {
	
	//전체 사용자 정보 조회
	
	/* SELECT *
	 * FROM users;
	 * 
	 */
	
	//반환타입 메소드명();
	
	List<UserVo> selectAllUser();

	//userid에 해당하는 사용자 한명의 정보
	UserVo selectUser(String userid);

	List<UserVo> selectpagingUser(PageVo vo);
	
	//사용자 전체수 조회 
	int selectAlluserCnt();
	
	//사용자 정보 수정
	int modifyUser(UserVo userVo);
	
	//사용자 정보입력
	int registUser(UserVo userVo);
}
