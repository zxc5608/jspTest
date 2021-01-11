package kr.or.ddit.user.respository;

import java.util.List;

import kr.or.ddit.user.model.empVo;

public interface empDaoI {

	List<empVo> selectAllEmp();
}
