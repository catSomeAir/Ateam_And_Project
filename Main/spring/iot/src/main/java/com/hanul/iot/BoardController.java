package com.hanul.iot;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import board.BoardCommentVO;
import board.BoardFileVO;
import board.BoardPageVO;
import board.BoardServiceImpl;
import board.BoardVO;
import common.CommonService;

@Controller
public class BoardController {
	@Autowired private BoardServiceImpl service;
	@Autowired private CommonService common;
	
	//방명록 댓글삭제처리 요청
	@ResponseBody @RequestMapping("/board/comment/delete/{id}")
	public void comment_delete(@PathVariable int id) {
		//해당 댓글을 DB에서 삭제한 후 돌아간다
		service.board_comment_delete(id);
	}
	
	
	//방명록 댓글저장처리 요청
	@ResponseBody @RequestMapping(value="/board/comment/update"
								, produces="text/plain; charset=utf-8")
	public String comment_update(@RequestBody BoardCommentVO vo) {
//	public String comment_update(BoardCommentVO vo) {
		//화면에서 변경입력한 댓글정보를 DB에 변경저장한 후 성공/실패 문자열을 반환
		return service.board_comment_update(vo)==1 ? "성공^^" : "실패ㅠㅠ";
	}
	
	
	//방명록 댓글목록조회 요청
	@RequestMapping("/board/comment/list/{board_id}")
	public String comment_list(@PathVariable int board_id, Model model) {
	//public String comment_list(int board_id, Model model) {
		//해당 글의 댓글목록을 DB에서 조회해와 화면에서 출력할 수 있도록 Model에 담는다
		model.addAttribute("list", service.board_comment_list(board_id));
		model.addAttribute("crlf", "\r\n");
		model.addAttribute("lf", "\n");
		return "board/comment/comment_list";
	}
	
	
	
	//방명록 댓글저장처리 요청
	@ResponseBody @RequestMapping("/board/comment/insert")
	public boolean comment_regist(BoardCommentVO vo) {
		//화면에서 입력한 정보를 DB에 신규저장한 후 ajax쪽으로 true/false 데이터를 가지고 돌아간다
		return service.board_comment_insert(vo)==1 ? true : false;
	}
	
	//방명록 수정저장처리 요청
	@RequestMapping("/update.bo")
	public String update(BoardVO vo, String removed, Model model
						//, RedirectAttributes redirect
						, MultipartFile[] file, HttpServletRequest request ) {
		//첨부파일처리
		attached_file(vo, file, request);
		
		//화면에서 입력한 정보를 DB에 변경저장한 후
		if( service.board_update(vo) == 1 ) {
			//삭제된 파일이 있으면 DB의 board_file에서도 삭제
			if( ! removed.isEmpty() ) { //3,5,4
				//DB에서  board_file 정보 삭제하기 전에 업로드된 파일정보를 조회해둔다
				List<BoardFileVO> list = service.board_file_list(removed);
				//DB에서 삭제대상 파일정보를 삭제한후
				if( service.board_file_delete(removed) > 0 ) {
					//물리적파일도 삭제한다
					removed_file( list, request );
				}
			}
		}
		
		//응답화면연결
		//주소창에 파라미터를 노출한 경우
		//return "redirect:detail.bo?id=" + vo.getId();

		//redirect 에 attribute를 담아 처리한 경우: 브라우저 refresh하면 attribute값은 사라진다 
		//redirect.addFlashAttribute("id", vo.getId());
		//return "redirect:detail.bo";
		
		//redirect 할 페이지를 따로 만든 경우
		model.addAttribute("id", vo.getId());
		model.addAttribute("url", "detail.bo");		
		return "board/redirect";
	}
	
	private void removed_file(List<BoardFileVO> list, HttpServletRequest request) {
		for( BoardFileVO vo : list ) {
			String filepath = vo.getFilepath();
			//http://localhost/iot/upload/board/2022/08/30/96e925f9-0d80-421a-9a4e-a6081ab5b5ce_마케팅의이해.mp3
			//--> d://app/iot/upload/.....
			filepath = filepath.replace( common.appName(request)
								, "d://app/" + request.getContextPath() );
			File file = new File( filepath );
			if( file.exists() ) file.delete();
		}
	}
	
	//방명록 수정화면 요청
	@RequestMapping("/modify.bo")
	public String modify(int id, Model model) {
		//해당 방명록 정보를 DB에서 조회해와 화면에 출력할 수 있도록 Model에 담는다
		model.addAttribute("vo", service.board_detail(id) );
		//응답화면연결
		return "board/modify";
	}
	
	
	
	//방명록 첨부파일 다운로드 요청
	@RequestMapping("/download.bo")
	public void download(int id, HttpServletRequest request, HttpServletResponse response) {
		//해당 첨부파일 정보를 DB에서 조회해와 클라이언트에 저장하는 다운로드처리
		BoardFileVO vo = service.board_file_info(id);
		common.fileDownload(vo.getFilename(), vo.getFilepath(), response, request);
	}
	
	
	//방명록 상세화면 요청
	@RequestMapping("/detail.bo")
	public String detail( @ModelAttribute("id") int id, Model model) {
		//해당 방명록 정보를 DB에서 조회해와 화면에 출력할 수 있도록 Model에 담는다
		model.addAttribute("vo", service.board_detail(id));
		model.addAttribute("page", page);
		model.addAttribute("crlf", "\r\n");
		//응답화면 연결
		return "board/detail";
	}
	
	
	private void attached_file(BoardVO vo, MultipartFile[] file, HttpServletRequest request) {
		List<BoardFileVO> list = null;
		for(MultipartFile f : file) {
			if( f.isEmpty() ) continue;
			if( list==null ) list = new ArrayList<BoardFileVO>();
			
			BoardFileVO filevo = new BoardFileVO();
			filevo.setFilename( f.getOriginalFilename() );
			filevo.setFilepath( common.fileUpload("board", f, request));
			list.add(filevo);
		}
		vo.setFileInfo(list);
	}
	
	//방명록 삭제처리 요청
	@RequestMapping("/delete.bo")
	public String delete(int id, HttpServletRequest request, Model model) {
		//물리적파일정보를 위해 첨부파일정보를 조회해둔다
		List<BoardFileVO> list = service.board_file_list(id);
		//해당 방명록을 삭제한 후
		if( service.board_delete(id)==1 ) {
			//첨부된 파일정보가 있으면 함께 삭제: 테이블생성시 지정됨
			//물리적파일 삭제
			removed_file(list, request);
		}
		//응답화면연결
		//return "redirect:list.bo";
		model.addAttribute("url", "list.bo");
		model.addAttribute("page", page);
		return "board/redirect";		
	}
	
	
	//방명록 신규저장처리 요청
	@RequestMapping("/insert.bo")
	public String insert(BoardVO vo, MultipartFile[] file, HttpServletRequest request) {

		//첨부파일 관련처리
		if( file.length > 1  ) {
			attached_file(vo, file, request);
		}
		
		//화면에서 입력한 정보를 DB에 신규저장한 후 
		service.board_insert(vo);
		//응답화면연결
		return "redirect:list.bo";
	}
	
	
	//방명록 글쓰기화면 요청
	@RequestMapping("/new.bo")
	public String board() {
		//응답화면연결
		return "board/new";
	}
	
	@Autowired private BoardPageVO page;
	
	//방명록 목록화면 요청
	@RequestMapping("/list.bo")
	public String list(HttpSession session, Model model
						, String search, String keyword
						, @RequestParam(defaultValue = "list") String viewType 
						, @RequestParam(defaultValue = "10") int pageList
						, @RequestParam(defaultValue = "1") int curPage) {
		session.setAttribute("category", "bo");
		page.setCurPage(curPage);
		page.setSearch(search);
		page.setKeyword(keyword);
		page.setPageList(pageList);
		page.setViewType(viewType);
		
		//DB에서 방명록 목록정보를 조회해와 화면에 출력에 출력할 수 있도록 Model에 담는다
		model.addAttribute("page", service.board_list(page) );
		//응답화면연결
		return "board/list";
	}
}
