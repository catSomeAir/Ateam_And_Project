package com.hanul.ateam;

import java.util.ArrayList;
import java.util.List;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import common.CommonService;
import manysearch.ManySearchDAO;
import search.CategorySearchVO;
import search.SearchDAO;

@RestController
public class SearchController {
	@Autowired private CommonService common;
	@Autowired private SearchDAO dao;
	@Autowired private	ManySearchDAO search_dao;
	//  실기기테스트하면서 변경해야함 !!!!!!!!!!!!!
		@RequestMapping(value = "/barcode.mo", produces = "text/html;charset=utf-8")
		public String barcode_search() {
//			List<CategorySearchVO> list = dao.m_list(m_name);
//			return new Gson().toJson(list);
			return null;
		}
	
	@RequestMapping("/download.mo")
	public void download(String id,  HttpServletRequest req, HttpServletResponse resp) {
		//해당 첨부파일 정보를 DB에서 조회해와 클라이언트에 저장하는 다운로드처리
		
		common.fileDownload("T873MEE111.png", "http://localhost/pj/upload/modelimg/gajeon/T873MEE111.png", req, resp );
	}
	@RequestMapping(value = "/list.mo", produces = "text/html;charset=utf-8")
	public String m_list(String m_name) {
		List<CategorySearchVO> list = dao.m_list(m_name);
		return new Gson().toJson(list);
	}
	
	@RequestMapping(value = "/search.re", produces = "text/html;charset=utf-8")
	public String relate_text(String search_text) {
		System.out.println(search_text);
		List<String> list = dao.relate_text(search_text); 
		String result = new Gson().toJson(list);
	System.out.println(result);
		return result;
	}
	
	//입력받은 검색어를 초,중,종성으로 뜯어논 search_div_text로 검색 - 전체검색
	@RequestMapping(value = "/search.mo", produces = "text/html;charset=utf-8")
	public String search_text(String search_div_text) {
		List<CategorySearchVO> list = dao.search_text(search_div_text);
		return new Gson().toJson(list);
	}
	
	
	//입력받은 검색어를 초,중,종성으로 뜯어논 search_div_text로 검색 - 모델명
	@RequestMapping(value = "/search_name.mo", produces = "text/html;charset=utf-8")
	public String search_text_name(String search_div_text) {
		List<CategorySearchVO> list = dao.search_text_name(search_div_text);
		return new Gson().toJson(list);
	}
	//입력받은 검색어를 초,중,종성으로 뜯어논 search_div_text로 검색 - 모델코드
	@RequestMapping(value = "/search_code.mo", produces = "text/html;charset=utf-8")
	public String search_text_code(String search_div_text) {
		List<CategorySearchVO> list = dao.search_text_code(search_div_text);
		return new Gson().toJson(list);
	}
	
	//메인에 표시되는 많이검색된 설명서리스트
	@RequestMapping(value = "/main_many_list", produces = "text/html;charset=utf-8")
	public String many_search() {
		
		return new Gson().toJson(search_dao.many_search());
	}
	
	//모델코드로 검색 -> 이미지 모델명, 모델코드, 브랜드 표시
	@RequestMapping(value = "/model_code_list", produces = "text/html;charset=utf-8")
	public String model_code_list(String model_code) {
		
		return new Gson().toJson(dao.model_code_list(model_code));
	}
	
	
	
}
