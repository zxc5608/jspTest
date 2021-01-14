package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.respository.UserDao;
import kr.or.ddit.user.respository.UserDaoI;

public class UserServiceTest {
	private UserServiceI userService;
	@Before
	public void setup() {
		userService =new UserService();
		//테스트에서 사용할 신규 사용자 추가
		UserVo userVo = new UserVo("testUser","테스트 사용자","testUserPass",new Date(),"대덕","대전 중구 중앙","영민빌딩 4층","34940");
		
		userService.registUser(userVo);
		
		//신규 입력 테스트를 위해 테스트 과정에서 입력된 데이터를 삭제
		userService.deleteUser("testUser");
	}

	@After
	public void tearDown() {
		userService.deleteUser("ddit2");

	}
	
	//전체 사용자 조회 테스트 
		@Test
		public void selectAllUsertest() {
			/***Given***/
			

			/***When***/
			List<UserVo> userList= userService.selectAllUser();
			

			/***Then***/
			assertEquals(16, userList.size());

		}
		
		//사용자 아이디를 이용하여 특정사용자 정보 조회
		@Test
		public void selectUserTest() {
			/***Given***/
			String userid= "brown";
			
			
			/***When***/
			UserVo user = userService.selectUser(userid);
			
			/***Then***/
			assertNotNull(user);
			assertEquals("브라운", user.getUsernm());
		}
		
		//사용자 아이디가 존재하지 않을 때, 특정 사용자 조회
		@Test
		public void selectUserNotExsistTest() {
			/***Given***/
		
			String userid= "brownNotexsist";
			
			/***When***/
			UserVo user = userService.selectUser(userid);
			
			/***Then***/
			assertNull(user);
			
		}

		//사용자 페이지 조회 테스트 
		@Test
		public void selectpagingUserTest() {
			/***Given***/
			
			PageVo pvo= new PageVo(2,5);
			

			/***When***/
			Map<String,Object> map= userService.selectpagingUser(pvo);
			List<UserVo> userList= (List<UserVo>)map.get("userList");
			int userCnt=(int)map.get("userCnt");
					
			/***Then***/
			assertEquals(5,userList.size());

		}
		@Test
		public void ModifyUserTest() {
			/***Given***/
			
			
			//userid usernm pass reg_gt alias addr1 addr2 zipcode 
			UserVo userVo = new UserVo("ddit","대덕인재","dditpass",new Date(),"개발원m","대전 중구 중앙로 76","4층 대덕인재개발원","34940");
			
			/***When***/
			int updateCnt =userService.modifyUser(userVo);
			
			/***Then***/
			
			assertEquals(1,updateCnt);
			
		}
		

}
