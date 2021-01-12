package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.respository.UserDao;
import kr.or.ddit.user.respository.UserDaoI;

public class UserServiceTest {

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
		
		//사용자 아이디가 존재하지 않을 때, 특정 사용자 조회
		@Test
		public void selectUserNotExsistTest() {
			/***Given***/
			UserDaoI userDao= new UserDao();
			String userid= "brownNotexsist";
			
			/***When***/
			UserVo user = userDao.selectUser(userid);
			
			/***Then***/
			assertNull(user);
			
		}

		//사용자 페이지 조회 테스트 
		@Test
		public void selectpagingUserTest() {
			/***Given***/
			UserServiceI userservice= new UserService();
			PageVo pvo= new PageVo(2,5);
			

			/***When***/
			Map<String,Object> map= userservice.selectpagingUser(pvo);
			List<UserVo> userList= (List<UserVo>)map.get("userList");
			int userCnt=(int)map.get("userCnt");
					
			/***Then***/
			assertEquals(5,userList.size());

		}
		

}
