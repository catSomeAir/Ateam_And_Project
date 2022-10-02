package com.hanul.ateam;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import member.MemberDAO;
import member.MemberServiceImpl;
import member.MemberVO;


@RestController
public class MemberController {
	@Autowired private MemberServiceImpl service;
	@Autowired MemberDAO dao;
	
	@RequestMapping(value = "/email_check.me" , produces = "text/html;charset=utf-8")
	public String email_check(String email) {
		int test =service.email_check(email);
		
		return test+""; 
		
	}
	
	@RequestMapping(value =  "/join.me" , produces = "text/html;charset=utf-8")
	public String join(String vo) {
		System.out.println("여기까지 왔도??!!");
		MemberVO join_info = new Gson().fromJson(vo, MemberVO.class);
		int num = service.join(join_info);
		System.out.println("왔는감?"+join_info);
		
		return String.valueOf(num);
	}
	
	@RequestMapping(value = "/login.me", produces = "text/html;charset=utf-8")
	public String m_list(String email, String pw) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", email);
//		map.put("socail", "0");
		map.put("pw", pw);
		MemberVO vo = service.login(map);
		return  new Gson().toJson(vo);
	}
	
	//구글 로그인 정보 안드로이드에서 받아와서 DB에 저장
	
	  @RequestMapping(value="/socialinfo.me", produces ="text/html;charset=utf-8") 
	  public String g_list_save(String email,String social) {
		  int check = dao.email_check(email);
		  HashMap<String, String> map = new HashMap<String, String>();
		  if(check !=1 ) {
			  System.out.println("*");
			  System.out.println(email);
			  System.out.println(social);
				map.put("email", email);
				map.put("social", social);
				dao.g_list_save(map);
		  }
		  
		  map.put("email", email);
		  map.put("pw", null);
		  MemberVO vo = service.login(map);
		return new Gson().toJson(vo);
	  }
	  
	  //내 정보 수정
	  @RequestMapping(value="/update.me",produces ="text/html;charset=utf-8")
	  public void updateUserInfo(String vo) {
		  MemberVO updatevo = new Gson().fromJson(vo, MemberVO.class);
		  dao.updateUserInfo(updatevo);
	  }
}

