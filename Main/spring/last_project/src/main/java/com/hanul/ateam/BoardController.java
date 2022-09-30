package com.hanul.ateam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import board.BoardDAO;
import board.BoardVO;

@RestController
public class BoardController {
	@Autowired private BoardDAO dao;
	
	@ResponseBody @RequestMapping(value = "/board_list", produces = "text/html;charset=utf-8")
	public String board_insert(String vo ) {
		BoardVO boardvo = new Gson().fromJson(vo, BoardVO.class);
		return dao.board_insert(boardvo) + "";
	}
}
