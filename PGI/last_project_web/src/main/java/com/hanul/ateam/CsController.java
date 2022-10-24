package com.hanul.ateam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cs.CsPageVO;
import cs.CsServiceImpl;
import cs.CsVO;

@Controller
public class CsController {
	@Autowired private CsServiceImpl service;
	
	
	
	
	//질문글 수정저장처리 요청
	@RequestMapping("/update.cs")
	public String update(CsVO vo, String removed, Model model) {
		service.cs_update(vo);
		
		//redirect 할 페이지를 따로 만든 경우
		model.addAttribute("id", vo.getId());
		model.addAttribute("url", "detail.cs");		
		return "cs/cs_redirect";
	}
	  
	//질문글 수정화면 요청
	@RequestMapping("/modify.cs")
	public String modify(int id, Model model) {
		//해당 방명록 정보를 DB에서 조회해와 화면에 출력할 수 있도록 Model에 담는다
		model.addAttribute("vo", service.cs_detail(id) );
		//응답화면연결
		return "cs/cs_modify";
	}
	
	//질문글 상세화면 요청
	@RequestMapping("/detail_web.cs")
	public String detail( @ModelAttribute("id") int id, Model model) {
		service.cs_read(id);
		
		//해당 방명록 정보를 DB에서 조회해와 화면에 출력할 수 있도록 Model에 담는다
		model.addAttribute("vo", service.cs_detail(id));
		model.addAttribute("page", page);
		model.addAttribute("crlf", "\r\n");
		//응답화면 연결
		return "cs/cs_detail_web";
	}
	
	@Autowired private CsPageVO page;
	@RequestMapping("/helplist.cs")
	public String cs_helplist(HttpSession session, Model model
			, String search, String keyword
			, @RequestParam(defaultValue = "list") String viewType
			, @RequestParam(defaultValue = "10") int pageList
			, @RequestParam(defaultValue = "1") int curPage) {
		session.setAttribute("category", "cs");
		page.setCurPage(curPage);
		page.setSearch(search);
		page.setKeyword(keyword);
		page.setPageList(pageList);
		
		page = service.cs_list(page);

		//DB에서 고객센터 글목록정보를 조회해와 화면에 출력에 출력할 수 있도록 Model에 담는다
		model.addAttribute("page", page );
		//응답화면연결
		return "cs/cs_helplist";
	}
	
	
	@RequestMapping("/list_web.cs")
	public String cs_listWeb() {

		
		return "cs/cs_list_web";
	}
	
	
	@RequestMapping("/cs_new.cs")
	public String cs_newWeb() {
		                                            
		return "cs/cs_new_web";
	}
	
	//cs 신규 글 등록
	@RequestMapping("/insert.cs")
	public String insert(CsVO vo, HttpServletRequest request) {
		
		//화면에서 입력한 정보를 DB에 신규저장한 후 
		service.cs_insert(vo);
		//응답화면연결
//		System.out.println("저장한다아~~");
		return "redirect:list.cs";
	}
	
	
}
