package com.hanul.ateam;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import category.CategoryServiceImpl;
import category.CategoryVO;
import market.GiftVO;
import member.MemberServiceImpl;
import member.MemberVO;


@RestController
public class MemberController {
	@Autowired private MemberServiceImpl service;
	Gson gson = new Gson();
	
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
		map.put("pw", pw);
		MemberVO vo = service.login(map);
		return  new Gson().toJson(vo);
	}
}

