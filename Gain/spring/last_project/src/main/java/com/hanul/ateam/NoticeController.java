package com.hanul.ateam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import notice.NoticeDAO;

@RestController
public class NoticeController {
	@Autowired private NoticeDAO dao;
	
	public void getList() {
		dao.getList();
	}

}
