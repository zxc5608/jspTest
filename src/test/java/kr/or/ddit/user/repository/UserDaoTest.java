package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.respository.UserDao;
import kr.or.ddit.user.respository.UserDaoI;

public class UserDaoTest {

	private UserDaoI userDao;
	@Before
	public void setup() {
		userDao =new UserDao();
		//테스트에서 사용할 신규 사용자 추가
		UserVo userVo = new UserVo("testUser","테스트 사용자","testUserPass",new Date(),"대덕","대전 중구 중앙","영민빌딩 4층","34940");
		
		userDao.registUser(userVo);
		
		//신규 입력 테스트를 위해 테스트 과정에서 입력된 데이터를 삭제
		userDao.deleteUser("testUser");
	}

	@After
	public void tearDown() {
		userDao.deleteUser("ddit2");
	}
	//전체 사용자 조회 테스트 
	@Test
	public void selectAllUsertest() {
		/***Given***/


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
		
		

		/***When***/
		List<UserVo> userList= userDao.selectpagingUser(pvo);
		/***Then***/
		assertEquals(5,userList.size());

	}
	@Test
	public void selectAlluserCntTest() {
		/***Given***/
		
		
		/***When***/
		int userCnt = userDao.selectAlluserCnt();
		
		/***Then***/
		
		assertEquals(16,userCnt);
		
	}
	@Test
	public void ModifyUserTest() {
		/***Given***/
		
		
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
		userDao.deleteUser("dd2");
		//userid usernm pass reg_gt alias addr1 addr2 zipcode 
		UserVo userVo = new UserVo("dd2","대덕인재1","dditpas1s",new Date(),"개발원2m1","대전 중1구 중앙로 76","4층 대덕2인재개발원","34140");
		
		/***When***/
		int updateCnt =  userDao.registUser(userVo);
		
		/***Then***/
		
		assertEquals(1,updateCnt);
		
	}

	
//삭제 테스트
	@Test
	public void deleteUserTest() {
		/***Given***/
		//해당 테스트가 실행될때는 testUser라는 사용자가 before메소드에 의해 등록이 된다
		String userid = "testUser";
		/***When***/
		int deleteCnt= userDao.deleteUser(userid);
		
		/***Then***/
		assertEquals(1, deleteCnt);
	}
}
