package com.hanul.ateam;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hr.DepartmentVO;
import hr.EmployeeVO;
import hr.HrServiceImpl;
import hr.JobVO;

@Controller
public class HrController {
	@Autowired private HrServiceImpl service;
	
	//신규사원등록처리 요청
	@RequestMapping("/insert.hr")
	public String insert(EmployeeVO vo) {
		//화면에서 입력한 정보를 DB에 신규저장한후
		service.employee_insert(vo);
		//응답화면연결
		return "redirect:list.hr";
	}
	
	//신규사원등록화면 요청
	@RequestMapping("/new.hr")
	public String employee(Model model) {
		//신규사원정보입력화면 연결
		//부서를 선택할 수 있도록 회사의 전체부서목록을 조회해와
		//전체업무목록을 조회해와
		//전체사원목록(매니저)를 조회해와
		List<DepartmentVO> departments = service.department_list();
		List<JobVO> jobs = service.job_list();
		List<EmployeeVO> managers = service.employee_name_list();
		//신규화면에 출력할 수 있도록 Model에 담는다
		model.addAttribute("departments", departments);
		model.addAttribute("jobs", jobs);
		model.addAttribute("managers", managers);
		return "employee/new";
	}
	
	//사원정보 변경저장처리 요청
	@RequestMapping("/update.hr")
	public String update(EmployeeVO vo) {
		//화면에서 변경입력한 정보를 DB에 변경저장한 후
		service.employee_update(vo);
		//응답화면연결
		return "redirect:detail.hr?id="+vo.getEmployee_id();
	}
	
	//사원정보 수정화면 요청
	@RequestMapping("/modify.hr")
	public String modify(int id, Model model) {
		//선택한 사원의 정보, 부서목록를 DB에서 조회해와
		EmployeeVO vo = service.employee_detail(id);
		List<DepartmentVO> departments = service.department_list();
		List<JobVO> jobs = service.job_list();
		//화면에 출력할 수 있도록 Model에 담는다
		model.addAttribute("vo", vo);
		model.addAttribute("departments", departments);
		model.addAttribute("jobs", jobs);
		//응답화면연결
		return "employee/modify";
	}
	
	//사원정보 삭제처리 요청
	@RequestMapping("/delete.hr")
	public String delete(int id) {
		//화면에서 선택한 사원의정보를 DB에서 삭제한 후: 비지니스로직
		service.employee_delete(id);
		//응답화면연결
		return "redirect:list.hr";
	}
	
	
	//사원상세화면 요청
	@RequestMapping("/detail.hr")
	public String detail(int id, Model model) {
		//선택한 사원의 정보를 DB에서 조회해와: 비지니스로직
		EmployeeVO vo = service.employee_detail(id);
		//화면에 출력할 수 있도록 Model에 담는다
		model.addAttribute("vo", vo);
		//응답화면연결
		return "employee/detail";
	}
	
	
	
	//사원목록화면 요청
	@RequestMapping("/list_web.my")
	public String list(HttpSession session
						, @RequestParam(defaultValue = "-1") int department_id
						, Model model) {
		session.setAttribute("category", "my");
//		//DB에서 사원목록, 부서목록을 조회해와 : 비지니스로직
//		List<EmployeeVO> list;
//		if( department_id==-1 ) //전체 사원조회
//			list = service.employee_list();
//		else 					//특정부서의 사원조회
//			list = service.employee_list(department_id);
//		
//		List<DepartmentVO> departments 
//					= service.employee_department_list();
//		//화면에서 출력할 수 있도록 Model에 담는다
//		model.addAttribute("list", list);
//		model.addAttribute("departments", departments);
//		model.addAttribute("department_id", department_id);
//		//응답화면연결
		return "mypage/mypage";
	}
	

	@RequestMapping("/point_list")
	public String point_list() {
		return "mypage/point_list";
	}
	@RequestMapping("/gifticon_list")
	public String gifticon_list() {
		return "mypage/gifticon_list";
	}
	@RequestMapping("/mypost_list")
	public String mypost_list() {
		return "mypage/mypost_list";
	}
	@RequestMapping("/bookmarked_list")
	public String bookmarked_list() {
		return "default/mypage/bookmarked_list";
	}
	@RequestMapping("/myreply_list")
	public String myreply_list() {
		return "mypage/myreply_list";
	}
	@RequestMapping("/edit")
	public String mypage_edit() {
		return "mypage/edit";
	}
	@RequestMapping("/downloaded")
	public String downloaded() {
		return "mypage/downloaded";
	}
	@RequestMapping("/list_web.ch")
	public String chat_service() {
		return "chat/chat";
	}
}
