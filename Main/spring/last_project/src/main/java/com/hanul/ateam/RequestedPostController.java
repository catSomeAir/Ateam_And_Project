package com.hanul.ateam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import requestedpost.RequestedPostDAO;
import requestedpost.RequestedPostVO;

@RestController
public class RequestedPostController {
	@Autowired RequestedPostDAO dao;
	
	@RequestMapping(value="requestedpost", produces ="text/html;charset=utf-8")
	public String getRequestedManual() {
		Gson gson = new Gson();
		 List<RequestedPostVO> list = dao.getRequestedManual();
		 return gson.toJson(list);
	}

}
