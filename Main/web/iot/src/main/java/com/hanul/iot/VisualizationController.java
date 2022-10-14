package com.hanul.iot;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import visual.VisualServiceImpl;

@Controller
public class VisualizationController {
	@Autowired private VisualServiceImpl service;
	
	//상위3위 부서에 대한 채용인원수(년도별) 조회 요청
	@ResponseBody @RequestMapping("/visual/hirement/top3/year")
	public List<HashMap<String, Object>> 
				hirement_top3_year(@RequestBody HashMap<String, Object> map) {
		return service.hirement_top3_year();
	}
	
	//상위3위 부서에 대한 채용인원수(월별) 조회 요청
	@ResponseBody @RequestMapping("/visual/hirement/top3/month")
	public List<HashMap<String, Object>> hirement_top3_month() {
		return service.hirement_top3_month();
	}
	
	//채용인원수(년도별) 조회 요청
	@ResponseBody @RequestMapping("/visual/hirement/year")
	public List<HashMap<String, Object>> hirement_year() {
		//DB에서 년도별 채용인원수를 조회해와 ajax 요청한 곳으로 데이터를 반환
		return service.hirement_year();
	}
	
	//채용인원수(월별) 조회 요청
	@ResponseBody @RequestMapping("/visual/hirement/month")
	public List<HashMap<String, Object>> hirement_month() {
		//DB에서 월별 채용인원수를 조회해와 ajax 요청한 곳으로 데이터를 반환
		return service.hirement_month();
	}
	
	//부서원수(부서별사원수) 조회 요청
	@ResponseBody @RequestMapping("/visual/department")
	public List<HashMap<String, Object>> department() {
		//DB에서 부서별사원수를 조회해와 ajax 요청한 곳으로 데이터를 반환
		return service.department();
	}
	
	
	//시각화화면 요청
	@RequestMapping("/list.vi")
	public String visual(HttpSession session) {
		session.setAttribute("category", "vi");
		return "visual/list";
	}
}
