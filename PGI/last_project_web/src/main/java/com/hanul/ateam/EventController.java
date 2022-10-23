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
import notice.NoticePageVO;
import notice.NoticeServiceImpl;
import notice.NoticeVO;

@Controller
public class EventController {
	@Autowired private NoticeServiceImpl service;
	@Autowired private NoticePageVO page;
	

	//이벤트 목록화면 요청
	@RequestMapping("/list_web.ev")
	public String list(HttpSession session, Model model
						, String search, String keyword
						, @RequestParam(defaultValue = "1") int curPage) {
		session.setAttribute("category", "ev");
	
		return "event/list";
	}
	
	
	//이벤트 목록화면 요청
	@RequestMapping("/detail_web.ev")
	public String test(HttpSession session, Model model
						, String search, String keyword
						, @RequestParam(defaultValue = "1") int curPage) {
		
		
		return "event/detail";
	}
}
