package com.hanul.ateam;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import category.CategoryServiceImpl;
import category.CategoryVO;
import member.MemberServiceImpl;
import member.MemberVO;


@RestController
public class MemberController {
	@Autowired private MemberServiceImpl service;

	
	@RequestMapping(value = "/login.me", produces = "text/html;charset=utf-8")
	public String m_list(String email, String pw) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("pw", pw);
		MemberVO vo = service.login(map);
		return  new Gson().toJson(vo);
	}
}

