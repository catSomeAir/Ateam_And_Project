package com.hanul.ateam;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import member.MemberDAO;
import member.MemberVO;
import mypage.BookmarkedPostDAO;
import mypage.BookmarkedPostVO;
import mypage.DownloadVO;
import mypage.PointDAO;
import mypage.ProfileDAO;

@Controller
public class HrController {
	@Autowired
	PointDAO pointdao;
	@Autowired
	BookmarkedPostDAO bookmarkeddao;
	@Autowired
	ProfileDAO profiledao;
	@Autowired
	MemberDAO memberdao;
	

	// 마이페이지 요청
	@RequestMapping("/list_web.my")
	public String list(HttpSession session, Model model) {
		session.setAttribute("category", "my");
		MemberVO loginInfo = (MemberVO)session.getAttribute("loginInfo");
		 /* System.out.println(loginInfo.getEmail()); 
		  model.addAttribute("useremail",
		  loginInfo.getEmail()); model.addAttribute("username",loginInfo.getName());
		  model.addAttribute("userphone",loginInfo.getPhone()); 
		  point_amount =pointdao.point(loginInfo.getEmail());
		  model.addAttribute("point",point_amount); 
		  String profile =
		  profiledao.profile(loginInfo.getEmail()); model.addAttribute("profile",
		  profile);*/
		MemberVO vo = memberdao.getuserList(loginInfo.getEmail());
		model.addAttribute("vo", vo);
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
	public String point_list(HttpSession session, Model model) {
		MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
		int point_amount = pointdao.point(loginInfo.getEmail());
		model.addAttribute("point", point_amount);
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
	public String bookmarked_list(HttpSession session, Model model) {
		MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
		model.addAttribute("useremail", loginInfo.getEmail());
		List<BookmarkedPostVO> vo = bookmarkeddao.getPostList(loginInfo.getEmail());
		model.addAttribute("vo", vo);
		return "default/mypage/bookmarked_list";
	}

	@RequestMapping("/myreply_list")
	public String myreply_list() {
		return "mypage/myreply_list";
	}

	@RequestMapping("/edit")
	public String mypage_edit() {
		/* memberdao.edit() */
		return "default/mypage/edit";
	}

	@RequestMapping("/downloaded")
	public String downloaded(HttpSession session, Model model) {
		MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
		List<DownloadVO> downvo = bookmarkeddao.download(loginInfo.getEmail());
		model.addAttribute("downvo", downvo);
		return "default/mypage/downloaded";
	}

	@RequestMapping("/list_web.ch")
	public String chat_service(HttpSession session, Model model) {
		MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
		model.addAttribute("username", loginInfo.getName());
		/* model.addAttribute("email",userinfo.getEmail()); */
		return "chat/chat";
	}
}
