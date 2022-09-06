package com.hanul.ateam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import test.TestServiceImpl;
import test.TestVO;

@RestController
public class TestController {
	@Autowired private TestServiceImpl service;
	@RequestMapping(value = "/test.te", produces = "text/html;charset=utf-8")
	public String test_list() {
		
		List<TestVO> list = service.test();
		
		return new Gson().toJson(list);
	}
}