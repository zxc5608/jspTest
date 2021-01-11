package kr.or.ddit.user.respository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.user.model.empVo;

public class empDao implements empDaoI {

	@Override
	public List<empVo> selectAllEmp() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<empVo> empList= sqlSession.selectList("emp.selectAllEmp");
		
		sqlSession.close();
		return empList;
	}

}
