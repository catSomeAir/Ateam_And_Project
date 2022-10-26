package com.hanul.ateam;

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
import qna.QnaAnswerVO;
import qna.QnaPageVO;
import qna.QnaServiceImpl;
import qna.QnaVO;

@Controller
public class QnaController {
	@Autowired private QnaServiceImpl service;
	@Autowired private QnaPageVO page;
	
	
	@RequestMapping("/delete_web.qa")
	public String qna_delete(int id, Model model, HttpServletRequest request) {
		QnaVO qna = service.qna_detail(id);
		
		
		model.addAttribute("page", page);
		model.addAttribute("url", "list_web.qa");
		return "qna/redirect_web";
	}

	@RequestMapping("/update_web.qa")
	public String qna_update(QnaVO vo, Model model, HttpServletRequest request) {
		QnaVO qna = service.qna_detail(vo.getId());

		service.qna_update(vo);
		model.addAttribute("page", page);
		model.addAttribute("url", "detail_web.qa");
		model.addAttribute("id", vo.getId());
		return "qna/redirect_web";
	}
	
	
	
	@RequestMapping("/modify_web.qa")
	public String qna_modify(int id, Model model, MultipartFile file, String filename) {
		int large_id = 6;
		model.addAttribute("fields", service.qna_filed_list(large_id));
		model.addAttribute("vo", service.qna_detail(id));
		model.addAttribute("page", page);
		return "qna/modify_web";
	}
	
	

	@RequestMapping("/detail_web.qa")
	public String qna_detail(int id, int read, Model model) {
		if( read==1 ) service.qna_read(id);	
		model.addAttribute("vo", service.qna_detail(id));
		model.addAttribute("page", page);
		model.addAttribute("crlf", "\r\n");
		return "qna/detail_web";
	}
	
	
	@RequestMapping("/insert_web.qa")
	public String qna_insert(QnaVO vo, HttpServletRequest request) {
	
		service.qna_insert(vo);
		return "redirect:list_web.qa";
	}

	@RequestMapping("/new_web.qa")
	public String qna(Model model) {
		int large_id = 6;
		model.addAttribute("fields", service.qna_filed_list(large_id));
		return "qna/new_web2";
	}
	@RequestMapping("/index.qa")
	public String qna() {
		return "index";
	}
	
	
	@Autowired private MemberServiceImpl member;
	@Autowired private CommonService common;
	@RequestMapping("/list_web.qa")
	public String list(HttpSession session, Model model
						, @RequestParam(defaultValue = "-1") int open
						, @RequestParam(defaultValue = "0") int field
						, String search, String keyword
						, @RequestParam(defaultValue = "1") int curPage) {
	session.setAttribute("category", "qa");
		
		page.setCurPage(curPage);
		page.setSearch(search);
		page.setKeyword(keyword);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("open", open);
		map.put("field", field);
//		model.addAttribute("page", service.qna_list(page));
		model.addAttribute("page", service.qna_list(map));
		model.addAttribute("open", open);
		model.addAttribute("field", field);
		
		int large_id = 6;//
		model.addAttribute("fields", service.qna_filed_list(large_id));
		
		return "qna/list_web";
//		return "index";
	}

	

	
}
