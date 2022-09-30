package com.hanul.ateam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import postlist.MyPostDAO;
import postlist.MyPostVO;
import postlist.MyReplyDAO;
import postlist.MyReplyVO;

@RestController
public class PostListController {
	@Autowired MyPostDAO dao;
	@Autowired MyReplyDAO replydao;
	
	/* 내가 쓴 글을 가져오는 메소드 */
	@RequestMapping(value="mypostlist",produces ="text/html;charset=utf-8")
	public String getMyPostShort(String email) {
		List<MyPostVO> list = dao.getMyPostShort(email);
		
		return new Gson().toJson(list);
	}
	/* 내가 쓴 댓글을 가져오는 메소드 */
	@RequestMapping(value="myreplylist",produces ="text/html;charset=utf-8")
	public String getMyReplyShort(String email) {
		List<MyReplyVO> list = dao.getMyReplyShort(email);
		
		return new Gson().toJson(list);
	}

}
