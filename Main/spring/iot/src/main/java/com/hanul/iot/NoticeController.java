package com.hanul.iot;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import common.CommonService;
import member.MemberServiceImpl;
import notice.NoticePageVO;
import notice.NoticeServiceImpl;
import notice.NoticeVO;

@Controller
public class NoticeController {
	@Autowired private NoticeServiceImpl service;
	@Autowired private NoticePageVO page;
	
	//공지글에 대한 답글저장처리 요청
	@RequestMapping("/reply_insert.no")
	public String reply(NoticeVO vo, MultipartFile file[], HttpServletRequest request) {
		//첨부파일이 있는 경우 업로드처리
		//첨부된 파일이 없는 경우
		if( file.length==1 && file[0].isEmpty() ) {
			
		}else {
		//첨부된 파일이 있는 경우
			attached_file(vo, file, request);
		}
		//화면에서 입력한 정보를  DB에 신규저장한 후
		service.notice_reply_insert(vo);
		//응답화면연결
		return "redirect:list.no";
	}
	
	//공지글에 대한 답글쓰기화면 요청
	@RequestMapping("/reply.no")
	public String reply(int id, Model model) {
		//해당글(원글)에 대한 정보를 DB에서 조회한 후 화면에 출력할 수 있도록 Model에 담는다
		model.addAttribute("vo", service.notice_detail(id) );
		
		//해당글(원글)에 대한 답글쓰기화면 연결
		//응답화면 연결
		return "notice/reply";
	}
	
	
	//공지사항 삭제처리 요청
	@RequestMapping("/delete.no")
	public String delete(int id, HttpServletRequest request) {
		//해당 공지글 정보를 DB에서 삭제한 후
		NoticeVO vo = service.notice_detail(id);
		if( service.notice_delete(id)==1 ) {
			//첨부파일이 있다면 물리적파일 삭제
			if( vo.getFilepath()!=null ) {
				original_delete(vo, request);
			}
		}
		//응답화면연결
		return "redirect:list.no";
	}
	
	private void original_delete(NoticeVO vo, HttpServletRequest request) {
		String filepath = vo.getFilepath();
		filepath = filepath.replace( common.appName(request)
						, "d://app/" + request.getContextPath() );
		if( vo.getFilepath() != null ) {
			String path[] = filepath.split(",");
			for( String real : path ) {
				File f = new File( real ); 
				if( f.exists() ) f.delete();
			}
		}
	}
	
	private void original_files(NoticeVO vo) {
		vo.setFilename( vo.getFilename() );
		vo.setFilepath( vo.getFilepath() );
	}
	
	private void attached_file(NoticeVO vo, MultipartFile[] attach, HttpServletRequest request){
		String filename = "", filepath = "";
		for(MultipartFile file : attach) {
			filename += (filename.equals("") ? "" : ",") 
							+ file.getOriginalFilename(); 
			filepath += (filepath.equals("") ? "" : ",") 
							+ common.fileUpload("notice", file, request)  ;
		}
		vo.setFilename( filename );
		vo.setFilepath( filepath );
	}
	
	//공지사항 변경저장처리 요청
	@RequestMapping("/update.no")
	public String update(NoticeVO vo, String filename, MultipartFile[] file, HttpServletRequest request) {
		
		//DB에 저장된 첨부파일 관련 정보를 조회해온다
		NoticeVO notice = service.notice_detail(vo.getId());
		String filepath = notice.getFilepath(); 
//		if( filepath != null ) { //삭제하기 위한 실제 파일
//			filepath = filepath.replace( common.appName(request)
//							, "d://app/" + request.getContextPath() );
//		}
		
		//원래:X -> 그대로 : file X  name X  : name/path 원래그대로
		//원래:O -> 그대로 : file X  name O  : name/path 원래그대로	
		//원래:O -> 삭제   : file X  name X :  원래 file 삭제, name/path null 
		
		//원래:X -> 첨부  : file O   name O : 새file 업로드, name/path 업로드정보 편집해서 
		//원래:O -> 변경첨부 : file O name O : 새file 업로드, name/path 업로드정보 편집해서,  원래 file 삭제
		
		//원래파일삭제는 따로, 데이터객체 filename, filepath만 편집
		//첨부파일 없는 경우
		if( file.length==1  && file[0].isEmpty() ) {
			if( filename.isEmpty() ) {
				//원래 첨부된 파일이 있으면 삭제
				if( filepath != null ) original_delete(notice, request);
				
			}else {
				//파일명이 있으면 원래파일 그대로
				original_files(notice);	
			}
		}else {
		//첨부파일 있는 경우
			attached_file(vo, file, request);
			//첨부된 파일이 있음
			if( filepath != null ) original_delete(notice, request);
		}
		
		//화면에서 변경입력한 정보를 DB에 변경저장한 후 
		service.notice_update(vo);
		//응답화면 연결
		return "redirect:detail.no?id="+vo.getId();
	}

	
	
	public String update(NoticeVO vo, String filename, MultipartFile file, HttpServletRequest request) {
		//DB에 저장된 첨부파일 관련 정보를 조회해온다
		NoticeVO notice = service.notice_detail(vo.getId());
		String filepath = notice.getFilepath(); 
		//실제파일 d://app/iot/upload/notice/2022/08/25/21d94db7-f9c5-4b1b-9229-f4799fe01716_kakao_login.zip,

		if( filepath != null ) {
			filepath = filepath.replace( common.appName(request)
							, "d://app/" + request.getContextPath() );
		}
		//vo 의 filename, filepath 는 null
		
		//파일첨부하지 않은 경우
		if( file.isEmpty() ) {
			//원래부터 첨부파일 없는경우
			//원래있던 첨부파일을 삭제한 경우-물리적인 파일도 삭제
			if( filename.isEmpty() ) {
				if( notice.getFilename() != null ) {
					File f = new File( filepath ); 
					if( f.exists() ) f.delete();
				}
				
			}else {
				//원래첨부파일을 그대로 쓰는 경우: filename 에 파일명이 있음
				vo.setFilename( notice.getFilename() );
				vo.setFilepath( notice.getFilepath() );
			}			
			
		}else {
		//파일첨부한 경우
			vo.setFilename( file.getOriginalFilename() );
			vo.setFilepath( common.fileUpload("notice", file, request) );
			
			//원래첨부파일이 있던 경우 물리적 파일도 삭제
			if( notice.getFilename() != null ) {
				File f = new File(filepath);
				if( f.exists() ) f.delete();
			}
		}
		
		
		//화면에서 변경입력한 정보를 DB에 변경저장한 후 
		service.notice_update(vo);
		//응답화면 연결
		return "redirect:detail.no?id="+vo.getId();
	}
	
	
	//공지사항 수정화면 요청
	@RequestMapping("/modify.no")
	public String modify(int id, Model model) {
		//해당 공지글정보를  DB에서 조회해와 수정화면에 출력할 수 있도록  Model에 담는다
		model.addAttribute("vo", service.notice_detail(id) );
		//응답화면연결
		return "notice/modify";
	}
	
	//첨부파일 다운로드 요청
	@RequestMapping("/download.no")
	public void download(int id, HttpServletResponse response
								, HttpServletRequest request) {
		//해당 첨부파일을 서버에서 찾아 클라이언트에 다운로드한다
		//해당 공지글 정보를 조회하여 저장된 파일정보를 파악
		NoticeVO vo = service.notice_detail(id);
		common.fileDownload(vo.getFilename(), vo.getFilepath(),  response, request);
	}
	
	//공지글 상세화면 요청
	@RequestMapping("/detail.no")
	public String detail(int id, Model model) {
		//조회수 증가시키기
		service.notice_read(id);
		
		//해당 공지글 정보를 DB에서 조회해와 화면에 출력할 수 있도록 Model에 담는다
		NoticeVO vo = service.notice_detail(id);
		model.addAttribute("vo", vo);
		model.addAttribute("crlf", "\r\n");
		
		//응답화면 연결
		return "notice/detail";
	}
	
	//신규 공지글저장처리 요청
	@RequestMapping("/insert.no")
	public String insert(NoticeVO vo, MultipartFile file, HttpServletRequest request) {
		//첨부파일이 있는 경우 파일을 업로드한다
		if( ! file.isEmpty() ) {
			vo.setFilename( file.getOriginalFilename() );
			vo.setFilepath( common.fileUpload("notice", file, request) );
		}
		
		//화면에서 입력한 정보를 DB에 신규저장한 후
		service.notice_insert(vo);
		//응답화면 연결
		return "redirect:list.no";
	}
	
	//신규 공지글쓰기 화면 요청
	@RequestMapping("/new.no")
	public String notice() {
		//응답화면연결
		return "notice/new";
	}
	
	@Autowired private MemberServiceImpl member;
	@Autowired private CommonService common;
	
	//공지글 목록화면 요청
	@RequestMapping("/list.no")
	public String list(HttpSession session, Model model
						, String search, String keyword
						, @RequestParam(defaultValue = "1") int curPage) {
		
		//테스트 중에 관리자로 로그인처리 한 후 테스트 끝나면 코드삭제하기 -----------------
		//admin의 salt 조회해서 비밀번호를 암호하기
//		String id = "admin", pw = "Manager";
//		String id = "park2022", pw = "Park2022";
//		String id = "sim2022", pw = "Sim2022";
//		String id = "test2022", pw = "Test2022";
//		String salt = member.member_salt(id);
//		pw = common.getEncrypt(salt, pw);
		
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("id", id);
//		map.put("pw", pw);
//		session.setAttribute("loginInfo",  member.member_login(map) );
		//-------------------------------------------------------------------
		
		session.setAttribute("category", "no");
		
		page.setCurPage(curPage);
		page.setSearch(search);
		page.setKeyword(keyword);
		
		//DB에서 공지글목록 정보를 조회해와
		page = service.notice_list(page);
		//목록화면에 출력할 수 있도록 Model에 담는다
		model.addAttribute("page", page);
		//응답화면연결
		return "notice/list";
	}
}
