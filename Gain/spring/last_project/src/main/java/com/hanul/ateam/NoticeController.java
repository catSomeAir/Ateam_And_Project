package com.hanul.ateam;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import notice.NoticeDAO;
import notice.NoticeVO;

@RestController
public class NoticeController {
	@Autowired private NoticeDAO dao;
	
	@RequestMapping(value="/notice",produces="text/html;charset=utf-8")
	public String getList(HttpServletResponse res) {
		
		List<NoticeVO> list = dao.getList();
		
		
		return new Gson().toJson(list);
	}
	


}
