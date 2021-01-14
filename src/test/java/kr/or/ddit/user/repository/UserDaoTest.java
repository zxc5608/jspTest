package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import java.util.Date;
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
	@Test
	public void ModifyUserTest() {
		/***Given***/
		UserDaoI userDao = new UserDao();
		
		//userid usernm pass reg_gt alias addr1 addr2 zipcode 
		UserVo userVo = new UserVo("ddit","대덕인재","dditpass",new Date(),"개발원m","대전 중구 중앙로 76","4층 대덕인재개발원","34940");
		
		/***When***/
		int updateCnt =  userDao.modifyUser(userVo);
		
		/***Then***/
		
		assertEquals(1,updateCnt);
		
	}
	
	@Test
	public void insertUserTest() {
		/***Given***/
		UserDaoI userDao = new UserDao();
		
		//userid usernm pass reg_gt alias addr1 addr2 zipcode 
		UserVo userVo = new UserVo("dd2","대덕인재1","dditpas1s",new Date(),"개발원2m1","대전 중1구 중앙로 76","4층 대덕2인재개발원","34140");
		
		/***When***/
		int updateCnt =  userDao.registUser(userVo);
		
		/***Then***/
		
		assertEquals(1,updateCnt);
		
	}
	
}
