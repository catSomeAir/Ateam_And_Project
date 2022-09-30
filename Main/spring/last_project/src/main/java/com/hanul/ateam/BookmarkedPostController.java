package com.hanul.ateam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import bookmarkedpost.BookmarkedPostDAO;
import bookmarkedpost.BookmarkedPostVO;



@RestController
public class BookmarkedPostController {
	@Autowired BookmarkedPostDAO dao;
	
	@RequestMapping(value="/bookmarkedpost",produces ="text/html;charset=utf-8")
	public String getbookmarkedpost(String email) {
		Gson gson = new Gson();
		List<BookmarkedPostVO> list =dao.getPostList(email);
		
		return  gson.toJson(list);
	}
}
