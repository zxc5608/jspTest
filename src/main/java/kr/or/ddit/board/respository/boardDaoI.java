package kr.or.ddit.board.respository;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.ComVo;
import kr.or.ddit.board.model.FileVo;
import kr.or.ddit.board.model.KboardinfoVo;
import kr.or.ddit.board.model.KboardpostVo;
import kr.or.ddit.board.model.UserVo;
import kr.or.ddit.common.model.PageVo;

public interface boardDaoI {

	List<KboardinfoVo> SelectAllboard();
	
    UserVo selectUser(String userid);
    
    int registBoard(KboardinfoVo boardVo);
   
    //업데이트
    int modifyboard (KboardinfoVo boardVo);
    
    //사용구분
    List<KboardinfoVo> selectBoard();
    
   
    //post select
    List<KboardpostVo> selectPost(PageVo pagevo);
	
    //게시글 전체수 조회
	int selectPostCnt(int bor_no);
	
	//게시글 등록
	int RegistBoardPost(KboardpostVo boardVo);
	
	//상세보기
	KboardpostVo selectDetail(KboardpostVo boardVo);
	
	//답글 등록 
	int repleinsert(KboardpostVo KboardpostVo);
	//댓글 select
	List<ComVo> ComSelect(int post_no);
	//댓글 등록 
	int cominsert(ComVo comvo);
	//댓글 삭제
	int reviewDelete(int com_no);
	//댓글 수정
	int reviewupdate(ComVo comvo);
	
	//해당 게시글 수정
	int UpdateBoardPost(KboardpostVo boardVo);
	
	//게시글 삭제 
	int deleteBoardPost(int post_no);
	
	//가장 최근 게시글 번호
	int selectMaxPostNo ();
	//파일 등록
	int  insertFile(FileVo fileVo);
	
	//
	List<FileVo> selectFileList(FileVo fileVo); 
	//파일 다운로드 
	FileVo selectFile(FileVo vo);
	
	int deleteFile(int att_no);
}
