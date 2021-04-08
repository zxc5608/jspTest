package kr.or.ddit.board.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.board.model.ComVo;
import kr.or.ddit.board.model.FileVo;
import kr.or.ddit.board.model.KboardinfoVo;
import kr.or.ddit.board.model.KboardpostVo;
import kr.or.ddit.board.model.UserVo;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.util.FileUtil;

@RequestMapping("board")
@Controller
public class boardController {
private static final Logger logger = LoggerFactory.getLogger(boardController.class);
	@Resource(name="boardService")
	private BoardServiceI boardService;
	
	@RequestMapping("boardlist")
	public String boardlist(Model model) {
		List<KboardinfoVo>boardList= boardService.SelectAllboard();
		List<KboardinfoVo> boardList1= boardService.selectBoard();
		
		model.addAttribute("boardList1",boardList1);
		model.addAttribute("boardList",boardList);
		return "main";
				
	}
	@RequestMapping("BoardinfoAdd")
	public String BoardinfoAdd(String bor_name,int bor_act) {
		KboardinfoVo boardVo = new KboardinfoVo(0,bor_act,bor_name);
		
		int insertCnt = 0;

		try {
			insertCnt = boardService.registBoard(boardVo);
		} catch (Exception e) {
			insertCnt = 0;
		}
 
		
		if (insertCnt == 1) {
			logger.debug("사용자 등록 성공 insertCnt 값:{}",insertCnt );
			return"redirect:/board/boardlist";

		}
		
		else {
			logger.debug("사용자 등록 실패 insertCnt 값:{}",insertCnt );
			
			return "redirect:board/BoardinfoAdd";
	}
	
}
	@RequestMapping("boardupdate")
	public String boardupdate(int bor_no, int bor_act) {
		KboardinfoVo boardVo= new KboardinfoVo(bor_no,bor_act,"as");
		int updateCnt = 0;
		
		try {
			updateCnt = boardService.modifyboard(boardVo);
			logger.debug(" updateCnt값 : {}", updateCnt);
		} catch (Exception e) {
			updateCnt =0;
		}
		if(updateCnt ==1 ) {
			return "redirect:/board/boardlist";
		}
		
		else {
			return "redirect:board/BoardinfoAdd";
			
		}
	}
	
	@RequestMapping("boardPost")
	public String boardPost(@RequestParam(defaultValue = "1") int page,
							@RequestParam(defaultValue = "10") int pageSize,
							int bor_no,
			 				Model model) {
		
		PageVo pagevo= new PageVo(page,pageSize,bor_no);
		
		List<KboardinfoVo> infoList= boardService.SelectAllboard();
		List<KboardpostVo> boardList= boardService.selectPost(pagevo);
		List<KboardinfoVo> boardList1= boardService.selectBoard();
		
		model.addAttribute("boardList1", boardList1);
		
		int postCnt = boardService.selectPostCnt(bor_no);
		logger.debug("cnt{}"+postCnt);
		int pagination = (int)Math.ceil((double)postCnt/pageSize);
		
		for (KboardpostVo kboardpostVo : boardList) {
			logger.debug("aa{}"+kboardpostVo.getUser_id());
		}
		
		model.addAttribute("infoList", infoList);
		model.addAttribute("boardList", boardList);
		model.addAttribute("pagination",pagination);
		model.addAttribute("pageVo",pagevo);
			
		return "board/boardAllPost";
	}
	
	@RequestMapping(path="RegistBoard",method=RequestMethod.GET)
	public String RegistBoard(int bor_no, Model model) {
		
		List<KboardinfoVo> boardList= boardService.selectBoard();
		List<KboardinfoVo> boardList1= boardService.selectBoard();
		
		model.addAttribute("boardList1", boardList1);
		model.addAttribute("boardList",boardList);
		model.addAttribute("bor_no",bor_no);
		
		return "board/registPost";
	}
	
	@RequestMapping(path="RegistBoard",method=RequestMethod.POST)
	public String RegistBoard(int bor_no,String user_id,String title, String cont,RedirectAttributes ra, MultipartHttpServletRequest fileName) {
		
		List<MultipartFile> files = fileName.getFiles("fileName");
		KboardpostVo boardVo = new KboardpostVo(bor_no, 1, user_id, title, cont, null, 1, 0, 0, null);
		
		int insertCnt = 0;

		try {
			insertCnt = boardService.RegistBoardPost(boardVo);
		} catch (Exception e) {
			insertCnt = 0;
		}
 
		// 사용자 등록 성공 ==> 페이징 리스트 화면으로 이동(1페이지)
		String filename = "";
		if (insertCnt == 1) {
				// 첨부파일
				int maxPostNo = boardService.selectMaxPostNo();
				logger.debug("maxPostNo: {}", maxPostNo);
				FileVo fileVo = new FileVo();
				fileVo.setBor_no(bor_no);
				fileVo.setPost_no(maxPostNo);
				fileVo.setUser_id(user_id);
				if (files != null) {
					for (MultipartFile profile : files) {
						if (!("".equals(profile.getOriginalFilename()))) {

							try {
								String uploadPath = " d:" + File.separator + "uploadFile";
								File uploadDir = new File(uploadPath);
								if (!uploadDir.exists()) {
									uploadDir.mkdirs();
								}
								String fileExtension = FileUtil.getFileExtension1(profile.getOriginalFilename());
								String realfilename = "d:/uploadFile/" + UUID.randomUUID().toString() + fileExtension;

								filename = profile.getOriginalFilename();
								logger.debug("filename: {}", filename);

								profile.transferTo(new File(realfilename));

								fileVo.setFile_nm(filename);
								fileVo.setRead_file_name(realfilename);

								boardService.insertFile(fileVo);

							} catch (IllegalStateException | IOException e) {
								e.printStackTrace();
							}
						}
					}
				}

				ra.addAttribute("bor_no", bor_no);
				ra.addAttribute("post_no", maxPostNo);
				ra.addAttribute("user_id", user_id);
				
			logger.debug("게시글 등록 성공 insertCnt 값:{}",insertCnt );
			return "redirect:/board/boardPost?bor_no="+bor_no;
		}
		// 사용자 등록 실패 ==> 사용자 등록 페이지로 이동
		else {
			logger.debug("게시글 등록 실패 insertCnt 값:{}",insertCnt );
//			
			return "redirect:/board/RegistBoard?bor_no="+bor_no;
		
		}
		
	}
	///
	@RequestMapping("boardDetail")
	public String boardDetail(int bor_no,int post_no,HttpSession session,KboardpostVo boardVo,Model model) {
		
		UserVo uservo= (UserVo)session.getAttribute("S_USER");
		model.addAttribute("user", uservo);
		
		boardVo.setBor_no(bor_no);
		boardVo.setPost_no(post_no);
		
		FileVo fileVo = new FileVo();
		fileVo.setBor_no(bor_no);
		fileVo.setPost_no(post_no);
		fileVo.setUser_id(uservo.getUserid());
		
		List<FileVo> fileList = boardService.selectFileList(fileVo);
		
		List<KboardinfoVo> boardList1= boardService.selectBoard();
		model.addAttribute("boardList1", boardList1);
		
		KboardpostVo kboardVo = boardService.selectDetail(boardVo);
		List<ComVo> comList = boardService.ComSelect(post_no);
		
		
		model.addAttribute("comList", comList);
		model.addAttribute("board",kboardVo);
		model.addAttribute("fileList",fileList);
		
		return "board/boardDetail";
	}
	//파일삭제
		@RequestMapping("deleteFile")
		public String deleteFile(int att_no, Model model) {
			
			int deleteCnt = boardService.deleteFile(att_no);
			
			model.addAttribute("cnt" ,deleteCnt);
			
			return "jsonView";
		}
	@RequestMapping("BoardDelete")
	public String BoardDelete(Model model,int post_no,int bor_no,String title,String cont, String user_id) {
		int updateCnt = 0;
		
		try {
		updateCnt = boardService.deleteBoardPost(post_no);
			
		} catch (Exception e) {
			updateCnt =0;
		}
		if(updateCnt ==1 ) {
	
			model.addAttribute("user_id",user_id);
			model.addAttribute("bor_no",bor_no);
			model.addAttribute("post_no",post_no);
		
			return "redirect:/board/boardPost?post_no="+post_no+"&bor_no="+bor_no+"&user_id"+user_id+"";
		}
		//사용자 수정이 비정상적으로 된 경우 ==> 해당 사용자의 정보수정 페이지로 이동
		else {
			return "board/boardDetail";
	
		}
		
	}
	@RequestMapping(path="BoardModify",method = RequestMethod.GET)
	public String BoardModify(Model model,int post_no,int bor_no,String title,String cont, String user_id) {
		
		model.addAttribute("user_id",user_id);
		model.addAttribute("bor_no",bor_no);
		model.addAttribute("post_no",post_no);
		model.addAttribute("title",title);
		model.addAttribute("cont",cont);
		
		return "board/ModityBoard";
	}
	@RequestMapping(path="BoardModify",method = RequestMethod.POST)
	public String BoardModifypost(KboardpostVo boardVo ,Model model,int post_no,int bor_no,String title,String cont, String user_id) {
		boardVo.setTitle(title);
		boardVo.setPost_no(post_no);
		boardVo.setCont(cont);
		boardVo.setBor_no(bor_no);
		boardVo.setUser_id(user_id);
		
		List<KboardinfoVo> boardList1= boardService.selectBoard();
		model.addAttribute("boardList1", boardList1);
		
		FileVo fileVo = new FileVo();
		fileVo.setBor_no(bor_no);
		fileVo.setPost_no(post_no);
		fileVo.setUser_id(user_id);
		
		List<FileVo> fileList = boardService.selectFileList(fileVo);
		
		int updateCnt = 0;
		
		try {
			updateCnt =  boardService.UpdateBoardPost(boardVo);
		} catch (Exception e) {
			updateCnt=0;
		}
		
		if(updateCnt ==1 ) {
			//	 불가능 - get 방식으로 보낼 수 없음 req.getRequestDispatcher("/user/user.jsp").forward(req, resp);
			logger.debug("수정 성공 {}",updateCnt);
				
			model.addAttribute("fileList",fileList);
			model.addAttribute("user_id", user_id);
			model.addAttribute("bor_no", bor_no);
			model.addAttribute("post_no", post_no);
			model.addAttribute("cont", cont);
			model.addAttribute("title", title);
			model.addAttribute("board_actList", boardService.selectBoard());
			return "redirect:/board/boardPost?post_no="+post_no+"&bor_no="+bor_no+"&user_id="+user_id+"";
			
		}
		//사용자 수정이 비정상적으로 된 경우 ==> 해당 사용자의 정보수정 페이지로 이동
		else {
			return "redirect:/board/BoardModify?post_no="+post_no+"&bor_no="+bor_no+"&user_id="+user_id+"";
		}
	}
	@RequestMapping(path="boardreple",method = RequestMethod.GET)
	public String boardreple(int bor_no,int post_no, Model model) {
		List<KboardinfoVo> boardList= boardService.selectBoard();
		model.addAttribute("boardList",boardList);
		model.addAttribute("bor_no",bor_no);
		model.addAttribute("post_no",post_no);
		
		return "board/repleWrite";
	}
	@RequestMapping(path="boardreple",method = RequestMethod.POST)
	public String boardreplepost(Model model, int bor_no,int post_no, String user_id,String title,String cont) {
		KboardpostVo boardVo = new KboardpostVo(bor_no, 1, user_id, title, cont, new Date(), 1, post_no, 0, "");
		int insertCnt = boardService.repleinsert(boardVo);
		// 사용자 등록 성공 ==> 페이징 리스트 화면으로 이동(1페이지)
		if (insertCnt == 1) {
			logger.debug("게시글 등록 성공 insertCnt 값:{}",insertCnt );
			//resp.sendRedirect(req.getContextPath() + "/boardlist");
			return "redirect:/board/boardlist";
			
		}
		// 사용자 등록 실패 ==> 사용자 등록 페이지로 이동
		else {
			logger.debug("게시글 등록 실패 insertCnt 값:{}",insertCnt );
//			
			return "redirect:/board/boardreple";
			
		}
	}
	
	@RequestMapping("reviewWrite")
	public String reviewWrite(ComVo comvo,String user_id,String user_id1,int bor_no,int post_no,String cont) {
		comvo.setBor_no(bor_no);
		comvo.setPost_no(post_no);
		comvo.setCom_con(cont);
		comvo.setUser_id(user_id1);
		comvo.setCom_user_id(user_id);
		
		int insertCnt= 0;
		try {
			insertCnt = boardService.cominsert(comvo);
		} catch (Exception e) {
			insertCnt = 0;
		}
		
		
		// 사용자 등록 성공 ==> 페이징 리스트 화면으로 이동(1페이지)
		if (insertCnt == 1) {
			logger.debug("게시글 삭제 성공 insertCnt 값:{}",insertCnt );
			return "redirect:/board/boardDetail?bor_no="+bor_no+"&post_no="+post_no+"";
			
			
		}
		// 사용자 등록 실패 ==> 사용자 등록 페이지로 이동
		else {
			logger.debug("게시글 등록 실패 insertCnt 값:{}",insertCnt );

			return"redirect:/board/boardDetail?bor_no="+bor_no+"&post_no="+post_no+"";
		}
		
	}
	@RequestMapping("reviewDelete")
	public String reviewDelete(Model model,int com_no,int bor_no,int post_no) {
	
		int deleteCnt = boardService.reviewDelete(com_no);
	
		if(deleteCnt==1) {
			model.addAttribute("com_no",com_no);
			return "redirect:/board/boardDetail?bor_no="+bor_no+"&post_no="+post_no+"";
		}else {
			return"";
			
		}
		
	}
	@RequestMapping("reviewupdate")
	public String reviewupdate(ComVo comvo) {
		int modifyCnt = boardService.reviewupdate(comvo);
		
		if(modifyCnt > 0) {
			return "redirect:/board/boardDetail?bor_no="+comvo.getBor_no()+"&post_no="+comvo.getPost_no();
		}else
			return "redirect:/board/boardDetail?bor_no="+comvo.getBor_no()+"&post_no="+comvo.getPost_no();
	}
		
	//파일 다운로드 
	@RequestMapping("fileDownload")
	public void fileDownload(int att_no, int bor_no, int post_no,String user_id, HttpServletResponse resp , Model model) throws IOException {
		
		FileVo vo = new FileVo();
		vo.setAtt_no(att_no);
		vo.setPost_no(post_no);
		vo.setBor_no(bor_no);
		vo.setUser_id(user_id);
		
		FileVo fileVo = boardService.selectFile(vo);
		String fileName= "";
		
		String path ="";
		
		path = fileVo.getRead_file_name();
		fileName = fileVo.getFile_nm();
		
		logger.debug("path : {}",path);
		logger.debug("fileName : {}",fileName);
		
		resp.setHeader("Content-Disposition","attachment; filename="+fileName);
		
		FileInputStream fis = new FileInputStream(path);
		ServletOutputStream sos = resp.getOutputStream();
		
		byte[] buff = new byte[512];
		while (fis.read(buff) != -1) {
			sos.write(buff);
		}
		
		fis.close();
		sos.flush();
		sos.close();
	}
}
