package com.hanul.ateam;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import news.NewsDAO;


@RestController
public class NewsController {
	@Autowired private NewsDAO dao;
	
	//로그인한 유저가 쓴 글의 댓글수
	@ResponseBody @RequestMapping(value = "/reply_cnt", produces = "text/html;charset=utf-8")
	public String reply_cnt(String email) {
		
	   return dao.reply_cnt(email)+"";
	}
	
	//로그인한 유저가 쓴 글의 새로달린 댓글정보
	@ResponseBody @RequestMapping(value = "/reply_info", produces = "text/html;charset=utf-8")
	public String reply_info(String email) {
		
	   return new Gson().toJson(dao.reply_info(email));
	}
	
	
	
	

}

