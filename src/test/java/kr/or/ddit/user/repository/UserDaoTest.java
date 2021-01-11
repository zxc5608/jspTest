package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.respository.UserDao;
import kr.or.ddit.user.respository.UserDaoI;

public class UserDaoTest {

	//전체 사용자 조회 테스트 
	@Test
	public void selectAllUsertest() {
		/***Given***/
		UserDaoI userDao = new UserDao();

		/***When***/
		List<UserVo> userList= userDao.selectAllUser();
		

		/***Then***/
		assertEquals(16, userList.size());

	}
	
	//사용자 아이디를 이용하여 특정사용자 정보 조회
	@Test
	public void selectUserTest() {
		/***Given***/
		String userid= "brown";
		UserDaoI userDao= new UserDao();
		
		/***When***/
		UserVo user = userDao.selectUser(userid);
		
		/***Then***/
		assertNotNull(user);
		assertEquals("브라운", user.getUsernm());
	}

	//사용자 페이지 조회 테스트 
	@Test
	public void selectpagingUserTest() {
		/***Given***/
		PageVo pvo= new PageVo(2,5);
		UserDaoI userDao= new UserDao();
		

		/***When***/
		List<UserVo> userList= userDao.selectpagingUser(pvo);
		/***Then***/
		assertEquals(5,userList.size());

	}
	@Test
	public void selectAlluserCntTest() {
		/***Given***/
		UserDaoI userDao= new UserDao();
		
		/***When***/
		int userCnt = userDao.selectAlluserCnt();
		
		/***Then***/
		
		assertEquals(16,userCnt);
		
	}
	
}
