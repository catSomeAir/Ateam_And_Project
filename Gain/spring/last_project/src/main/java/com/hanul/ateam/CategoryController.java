package com.hanul.ateam;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import category.CategoryServiceImpl;
import category.CategoryVO;


@RestController
public class CategoryController {
	@Autowired private CategoryServiceImpl service;
	@RequestMapping(value = "/llist.ct", produces = "text/html;charset=utf-8")
	public String l_list() {
		
		List<CategoryVO> l_list = service.l_name_list();
		
		return  new Gson().toJson(l_list);
		
	}
	@RequestMapping(value = "/mlist.ct", produces = "text/html;charset=utf-8")
	public String m_list(String l_code) {
		
		int lcode = Integer.parseInt(l_code);
		List<CategoryVO> m_list = service.m_name_list(lcode);
		return  new Gson().toJson(m_list);
		
	}
	@RequestMapping(value = "/count.ct", produces = "text/html;charset=utf-8")
	public String count(String email) {
		
		HashMap<String, String> map = service.count(email);
		
		return  new Gson().toJson(map);
		
	}
	
	
	

}

