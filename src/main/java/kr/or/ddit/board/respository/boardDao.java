package kr.or.ddit.board.respository;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.board.model.ComVo;
import kr.or.ddit.board.model.FileVo;
import kr.or.ddit.board.model.KboardinfoVo;
import kr.or.ddit.board.model.KboardpostVo;
import kr.or.ddit.board.model.UserVo;
import kr.or.ddit.common.model.PageVo;

@Repository("boardDao")
public class boardDao implements boardDaoI {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	
	@Override
	public List<KboardinfoVo> SelectAllboard() {
		
		return template.selectList("board.selectAllBoard");
	}

	@Override
	public UserVo selectUser(String userid) {
	
		return template.selectOne("board.selectUser",userid);
	}

	@Override
	public int registBoard(KboardinfoVo boardVo) {
			
		return template.insert("board.registBoard",boardVo);
	}

	@Override
	public List<KboardinfoVo> selectBoard() {
	
		return template.selectList("board.selectBoard");
	}

	@Override
	public int modifyboard(KboardinfoVo boardVo) {
				
		return template.update("board.modifyboard",boardVo);
	}

	@Override
	public List<KboardpostVo> selectPost(PageVo pagevo) {
		
		return template.selectList("board.selectPost",pagevo);
	}

	@Override
	public int selectPostCnt(int bor_no) {
		
		return template.selectOne("board.selectPostCnt",bor_no);
	}

	@Override
	public int RegistBoardPost(KboardpostVo boardVo) {
		
		return template.insert("board.RegistBoardPost",boardVo);
	}

	@Override
	public KboardpostVo selectDetail(KboardpostVo boardVo) {
	
		return template.selectOne("board.selectDetail",boardVo);
	}

	@Override
	public List<ComVo> ComSelect(int post_no) {
		
		return template.selectList("board.ComSelect",post_no);
	}

	@Override
	public int cominsert(ComVo comvo) {
		
		return template.insert("board.cominsert",comvo);
	}
	
	@Override
	public int repleinsert(KboardpostVo kboardpostVo) {
		
		return template.insert("board.repleinsert",kboardpostVo);
	}

	

	@Override
	public int UpdateBoardPost(KboardpostVo boardVo) {
		
		return template.update("board.UpdateBoardPost",boardVo);
	}

	@Override
	public int deleteBoardPost(int post_no) {

		return template.update("board.deleteBoardPost", post_no);
	}

	@Override
	public int reviewDelete(int com_no) {
	
		return template.delete("board.reviewDelete",com_no);
	}

	@Override
	public int reviewupdate(ComVo comvo) {
		// TODO Auto-generated method stub
		return template.update("board.reviewupdate",comvo);
	}

	//최근게시글번호
	@Override
	public int selectMaxPostNo() {
		// TODO Auto-generated method stub
		return template.selectOne("board.selectMaxPostNo");
	}
	

	@Override
	public int insertFile(FileVo fileVo) {
		return template.insert("file.insertFile", fileVo);
	}
	@Override
	public List<FileVo> selectFileList(FileVo fileVo) {
		
		return template.selectList("file.selectFileList", fileVo);
	}

	//파일 조회
	@Override
	public FileVo selectFile(FileVo fileVo) {
		return template.selectOne("file.selectFile", fileVo);
	}
	@Override
	public int deleteFile(int att_no) {
		return template.delete("file.deleteFile", att_no);
	}

	//게시판 활성여부에 따른 조회
	
}
