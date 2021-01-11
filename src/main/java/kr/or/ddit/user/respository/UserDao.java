package kr.or.ddit.user.respository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.user.model.UserVo;

public class UserDao implements UserDaoI{

	@Override
	public List<UserVo> selectAllUser() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		//select: 리턴되는 값의 복수 유무를 판단
		//		1.단건 : 일반객체를 반환(UserVo) selectOne()
		//		2.여러건: List<UserVo> selectList()
		// insert, update, delete : insert, update, delete
		
		//메소드 이름과 실행할 sql id를 동일하게 맞추자(유지보수- 다른개발자의 가독성)
		
		List<UserVo> userList= sqlSession.selectList("users.selectAllUser");
		
		//사용한 자원 반환 
		sqlSession.close();
		
		return userList;
	}

	@Override
	public UserVo selectUser(String userid) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		/*
		 *   SELECT * 
		    FROM users
		    WHERE userid= #{value}		
		 */
																//1개를보낼거 문자열 parameterType은 String
		UserVo user = sqlSession.selectOne("users.selectUser",userid);
		sqlSession.close();

		return user;
	}

	@Override
	public List<UserVo> selectpagingUser(PageVo pvo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
																			//인자가있는 쿼리이기때문에 넘겨준다
		List<UserVo> userList = sqlSession.selectList("users.selectpagingUser", pvo);
		
		sqlSession.close();
		
		return userList;
	}

	@Override
	public int selectAlluserCnt() {
		SqlSession sqlsession=  MybatisUtil.getSqlSession();
		
		int usercnt = sqlsession.selectOne("users.selectAlluserCnt");
		
		sqlsession.close();
		
		return usercnt;
	}

}
