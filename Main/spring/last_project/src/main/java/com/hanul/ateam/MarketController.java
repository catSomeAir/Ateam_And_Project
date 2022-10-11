package com.hanul.ateam;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import market.GiftVO;
import market.MarketDAO;

@RestController
public class MarketController {
	@Autowired MarketDAO dao;
	Gson gson = new Gson();
	
//	@RequestMapping(value =  "/gift_insert.me" , produces = "text/html;charset=utf-8")
	
	@RequestMapping(value =  "/gift_insert" , produces = "text/html;charset=utf-8")
	public String gift_insert(String email, String point) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("point", point);
		
		
		
		return dao.gift_insert(map) + "";
	}
	
	
	@RequestMapping(value =  "/gift.me" , produces = "text/html;charset=utf-8")
	public String gift_list(String email) {
		List<GiftVO> list = dao.gift_list(email);		
		return gson.toJson(list);
	}
}