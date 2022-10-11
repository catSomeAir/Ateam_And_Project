package com.hanul.ateam;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import board.BoardDAO;
import board.BoardVO;
import board.ReplyVO;

@RestController
public class BoardController {
	@Autowired private BoardDAO dao;
	//내가쓴 글 리스트
	@ResponseBody @RequestMapping(value = "/board_my_list", produces = "text/html;charset=utf-8")
	public String board_my_list(String email) {
	
		return new Gson().toJson(dao.board_my_list(email));
	}
	
	//내가쓴 댓글 리스트
		@ResponseBody @RequestMapping(value = "/board_my_reply_list", produces = "text/html;charset=utf-8")
		public String board_my_reply_list(String email) {
		
			return new Gson().toJson(dao.board_my_reply_list(email));
		}
	@ResponseBody @RequestMapping(value = "/board_insert", produces = "text/html;charset=utf-8")
	public String board_insert(String vo ) {
		BoardVO boardvo = new Gson().fromJson(vo, BoardVO.class);
		return dao.board_insert(boardvo) + "";
	}
	@ResponseBody @RequestMapping(value = "/board_update", produces = "text/html;charset=utf-8")
	public String board_update(String vo ) {
		BoardVO boardvo = new Gson().fromJson(vo, BoardVO.class);
		return dao.board_update(boardvo) + "";
	}
	
	@ResponseBody @RequestMapping(value = "/board_delete", produces = "text/html;charset=utf-8")
	public String board_delete(String board_id) {
		
		return dao.board_delete(board_id) + "";
	}

	//제품(코드) 해당글 리스트
	@ResponseBody @RequestMapping(value = "/board_list_select", produces = "text/html;charset=utf-8")
	public String board_list(String model_code, String cmt_code ) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("model_code", model_code);
		map.put("cmt_code", cmt_code);
		
		return new Gson().toJson(dao.board_list(map));
	}
	
	//제품(코드) 해당글의 댓글 삽입
	@ResponseBody @RequestMapping(value = "/board_coment_insert", produces = "text/html;charset=utf-8")
	public String board_coment_insert(String vo) {
		ReplyVO replyvo = new Gson().fromJson(vo, ReplyVO.class);
		
		return dao.board_coment_insert(replyvo) + "";
	}
	
	//제품(코드) 해당글의 댓글 리스트
	@ResponseBody @RequestMapping(value = "/board_coment_list", produces = "text/html;charset=utf-8")
	public String board_coment_list(String board_id) {
		
		
		return new Gson().toJson(dao.board_coment_list(board_id));
	}
	
	//제품(코드) 해당글의 댓글 수정
	@ResponseBody @RequestMapping(value = "/board_coment_update", produces = "text/html;charset=utf-8")
	public String board_coment_update(String vo) {
		ReplyVO replyvo = new Gson().fromJson(vo, ReplyVO.class);
		
		return dao.board_coment_update(replyvo) + "";
	}
}
