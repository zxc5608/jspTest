package kr.or.ddit.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.board.model.ComVo;
import kr.or.ddit.board.model.FileVo;
import kr.or.ddit.board.model.KboardinfoVo;
import kr.or.ddit.board.model.KboardpostVo;
import kr.or.ddit.board.model.UserVo;
import kr.or.ddit.board.respository.boardDao;
import kr.or.ddit.board.respository.boardDaoI;
import kr.or.ddit.common.model.PageVo;
@Service("boardService")
public class BoardService implements BoardServiceI{

	@Resource(name="boardDao")
	private boardDaoI boardDao; 

	@Override
	public List<KboardinfoVo> SelectAllboard() {
		return boardDao.SelectAllboard();
	}
	@Override
	public UserVo selectUser(String userid) {
		
		return boardDao.selectUser(userid);
	}
	@Override
	public int registBoard(KboardinfoVo boardVo) {
		// TODO Auto-generated method stub
		return boardDao.registBoard(boardVo);
	}
	@Override
	public List<KboardinfoVo> selectBoard() {
		// TODO Auto-generated method stub
		return boardDao.selectBoard();
	}
	@Override
	public int modifyboard(KboardinfoVo boardVo) {
		// TODO Auto-generated method stub
		return boardDao.modifyboard(boardVo);
	}
	@Override
	public List<KboardpostVo> selectPost(PageVo pagevo) {
		// TODO Auto-generated method stub
		return boardDao.selectPost(pagevo);
	}
	@Override
	public int selectPostCnt(int bor_no) {
		// TODO Auto-generated method stub
		return boardDao.selectPostCnt(bor_no);
	}
	@Override
	public int RegistBoardPost(KboardpostVo boardVo) {
		// TODO Auto-generated method stub
		return boardDao.RegistBoardPost(boardVo);
	}
	@Override
	public KboardpostVo selectDetail(KboardpostVo boardVo) {
		
		return boardDao.selectDetail(boardVo);
	}
	@Override
	public List<ComVo> ComSelect(int post_no) {
		// TODO Auto-generated method stub
		return boardDao.ComSelect(post_no);
	}
	@Override
	public int cominsert(ComVo comvo) {
		// TODO Auto-generated method stub
		return boardDao.cominsert(comvo);
	}
	@Override
	public int UpdateBoardPost(KboardpostVo boardVo) {
		// TODO Auto-generated method stub
		return boardDao.UpdateBoardPost(boardVo);
	}
	@Override
	public int deleteBoardPost(int post_no) {
		// TODO Auto-generated method stub
		return boardDao.deleteBoardPost(post_no);
	}
	@Override
	public int repleinsert(KboardpostVo KboardpostVo) {
		// TODO Auto-generated method stub
		return boardDao.repleinsert(KboardpostVo);
	}
	@Override
	public int reviewDelete(int com_no) {
		// TODO Auto-generated method stub
		return boardDao.reviewDelete(com_no);
	}
	@Override
	public int reviewupdate(ComVo comvo) {
		// TODO Auto-generated method stub
		return boardDao.reviewupdate(comvo);
	}
	
	@Override
	public int selectMaxPostNo() {
		// TODO Auto-generated method stub
		return boardDao.selectMaxPostNo();
	}
	
	@Override
	public int insertFile(FileVo fileVo) {
		
		return boardDao.insertFile(fileVo);
	}
	@Override
	public List<FileVo> selectFileList(FileVo fileVo) {
		// TODO Auto-generated method stub
		return boardDao.selectFileList(fileVo);
	}
	@Override
	public FileVo selectFile(FileVo vo) {
		// TODO Auto-generated method stub
		return boardDao.selectFile(vo);
	}
	@Override
	public int deleteFile(int att_no) {
		return boardDao.deleteFile(att_no);
	}
}
