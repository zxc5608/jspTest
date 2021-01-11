package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.model.empVo;
import kr.or.ddit.user.respository.empDao;
import kr.or.ddit.user.respository.empDaoI;

public class empService implements empServiceI{

	private empDaoI empDao = new empDao();
	
	@Override
	public List<empVo> selectAllEmp() {
		
		return empDao.selectAllEmp();
	}

}
