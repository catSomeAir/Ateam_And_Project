package com.hanul.ateam;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import common.CommonService;
import member.MemberDAO;
import member.MemberServiceImpl;
import member.MemberVO;

@Controller
public class MemberController {
	@Autowired private MemberServiceImpl service;
	@Autowired private CommonService common;
	@Autowired private MemberDAO dao;

	//회원가입처리 요청
	@ResponseBody @RequestMapping(value="/join_web"
								, produces="text/html; charset=utf-8")
	public String join(MemberVO vo, HttpServletRequest request) {
		
//		String salt = common.generateSalt();
//		String pw = common.getEncrypt(salt, vo.getPw());
//		vo.setSalt(salt);
//		vo.setPw(pw);
		

		StringBuffer msg = new StringBuffer("<script>");
		if( service.member_join(vo) == 1 ) {
			
			msg.append("alert('회원가입을 축하합니다^^'); location='")
				.append( request.getContextPath() ).append("'; ");
		}else {
			msg.append("alert('회원가입 실패ㅠㅠ'); history.go(-1); ");
		}
		msg.append("</script>");
		return msg.toString();
		
	}
	

	//email 중복확인 요청
	@ResponseBody @RequestMapping("/email_check")
	public int email_check(@RequestParam("email") String email) {
		//입력한 아이디가 DB에 존재하는지의 여부를 확인
		//존재하는 경우: 1(true), 아니면 0(false)
		int cnt = service.member_email_check(email);
		return cnt;
		//HAI- member_id_check => member_email_check 로 변경
		//HAI- member_email_check 리턴타입 int 로 변경
	}
	
	//회원가입화면 요청
	@RequestMapping("/member_web")
	public String join(HttpSession session) {
		session.setAttribute("category", "join");
		//응답화면연결
		return "member/join_web";
	}
	

	
	//로그아웃처리 요청
		@RequestMapping("/logout_web")
		public String logout(HttpSession session, HttpServletRequest request) {
			String social = ((MemberVO)session.getAttribute("loginInfo")).getSocial_code();
			//세션의 로그인정보를 삭제
			session.removeAttribute("loginInfo");
			//일반로그인:null, K, N
//			if( social != null && social.equals("K") ) {
//			//카카오로그인 한 경우는 
//			//"https://kauth.kakao.com/oauth/logout?client_id=${YOUR_REST_API_KEY}
//				//&logout_redirect_uri=${YOUR_LOGOUT_REDIRECT_URI}"
//				StringBuffer url = new StringBuffer("https://kauth.kakao.com/oauth/logout?");
//				url.append("client_id=").append(KAKAO_ID);
//				url.append("&logout_redirect_uri=").append( appName(request) );
//				return "redirect:" + url.toString();
//				
//			}else {
//				return "redirect:/";
//			}
			return "redirect:/";
		}
	
	//자체회원 로그인처리 요청
	@ResponseBody @RequestMapping("/login_in_web")
	public boolean login(String email, String pw, HttpSession session) {
		
		
		
		
		HashMap<String, String> map = new HashMap<String, String>();
		//임시 자동로그인
//		
//		map.put("email", "1");
//		map.put("pw", "1");
		map.put("email", email);
		map.put("pw", pw);
		map.put("socail", "0");
		MemberVO vo = dao.login(map);
	System.out.println(email+ pw);	
		session.setAttribute("loginInfo", vo);
		
		return vo == null?false:true;
	}
	
	
	//로그인 화면 요청
	@RequestMapping("/login_web")
	public String login(HttpSession session) {
		session.setAttribute("category", "login");
		//응답화면연결:로그인화면
		return "default/member/login";
	}
}
