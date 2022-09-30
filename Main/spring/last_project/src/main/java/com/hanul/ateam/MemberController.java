package com.hanul.ateam;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import category.CategoryServiceImpl;
import category.CategoryVO;
import member.MemberDAO;
import member.MemberServiceImpl;
import member.MemberVO;


@RestController
public class MemberController {
	@Autowired private MemberServiceImpl service;
	@Autowired MemberDAO dao;

	
	@RequestMapping(value = "/login.me", produces = "text/html;charset=utf-8")
	public String m_list(String email, String pw) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("pw", pw);
		MemberVO vo = service.login(map);
		return  new Gson().toJson(vo);
	}
	
	//가인----
	//안드 연결할 때 소셜로그인도 같이 할지 생각중
	/*
	 * 이거 주석인데 무시해도 됩니다
	 * @RequestMapping(value = "/login.me", produces = "text/html;charset=utf-8")
	 * public String m_list(String email, String pw,String social) { HashMap<String,
	 * String> map = new HashMap<String, String>(); map.put("email", email);
	 * map.put("pw", pw); MemberVO vo = service.login(map); return new
	 * Gson().toJson(vo); }
	 */
	//구글 로그인 정보 안드로이드에서 받아와서 DB에 저장
	
	  @RequestMapping(value="/socialinfo.me", produces ="text/html;charset=utf-8") 
	  public void g_list_save(String email,String social) {
		  System.out.println("*");
		  System.out.println(email);
		  System.out.println(social);
		  HashMap<String, String> map = new HashMap<String, String>();
			map.put("email", email);
			map.put("social", social);
			
			/*
			 * EMAIL PW N"AME NICKNAME PHONE JOIN_DATE AMDIN SOCIAL_CODE FILENAME FILEPATH
			 * POINT
			 */
		  
		int result = dao.g_list_save(map);
	  }
	  
	
	 
}

