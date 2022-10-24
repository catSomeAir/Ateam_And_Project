package com.hanul.ateam;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import common.CommonService;
import member.MemberDAO;
import member.MemberServiceImpl;
import member.MemberVO;

@Controller
public class MemberController {
	@Autowired private MemberServiceImpl service;
	@Autowired private CommonService common;
	@Autowired private MemberDAO dao;
//	

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
		
//		return service.member_join(vo);
	}
	
	//회원정보수정
	@RequestMapping(value="/edit_myprofile"
			, produces="text/html; charset=utf-8")
	public String edit(String email,String pw,String name,String phone,Model model) {
		System.out.println(email);
		System.out.println(pw);
		System.out.println(name);
		System.out.println(phone);
		MemberVO vo = new MemberVO();
		vo.setEmail(email);
		vo.setPw(pw);
		vo.setName(name);
		vo.setPhone(phone);
		dao.edit(vo);
		vo =dao.getuserList(email);
		model.addAttribute("vo",vo);
		return "mypage/newmypage";
	}
	
	//email 중복확인 요청
//	@ResponseBody @RequestMapping("/email_check")
//	public boolean email_check(String email) {
//		//입력한 아이디가 DB에 존재하는지의 여부를 확인
//		//존재하는 경우: 1(true), 아니면 0(false)
//		return service.member_email_check(email);
//		//HAI- member_id_check => member_email_check 로 변경
//	}
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
	
//	
	//회원가입화면 요청

//	
//	//비밀번호변경 처리 요청
//	@RequestMapping("/changePw")
//	public String change(HttpSession session, String userpw) {
//		
//		//화면에서 입력한 새비밀번호로 DB에 변경저장
//		MemberVO vo = (MemberVO)session.getAttribute("loginInfo");
//		//로그인 사용자의 salt 를 사용해 
//		//입력한 새비밀번호를 암호화
//		userpw = common.getEncrypt(vo.getSalt(), userpw);
//		vo.setUserpw(userpw);
//		service.member_reset_password(vo);
//		//세션의 로그인사용자 정보를 변경된 정보를 바꿔 담는다
//		session.setAttribute("loginInfo", vo);
//		//응답화면연결
//		return "redirect:/";
//	}
//	
//	
	
//	
//	
//	
//	
//	
//	//비밀번호변경 화면 요청
//	@RequestMapping("/password")
//	public String password() {
//		//응답화면연결
//		return "member/password";
//	}
//	
//	
//	//비밀번호재발급처리 요청
//	@ResponseBody @RequestMapping(value="/resetPw"
//						, produces="text/html; charset=utf-8")
//	public String reset(MemberVO vo) {
//		//화면에서 입력한 아이디와 이메일이 DB의 정보와 일치하는지 확인한 후
//		if( service.member_userid_email(vo)==0 ) {
//			StringBuffer msg = new StringBuffer("<script>");
//			msg.append("alert('")
//				.append(vo.getName()).append("님\\n아이디나 이메일이 맞지 않습니다\\n")
//				.append("확인하세요!")
//				.append("');");
//			msg.append("history.go(-1);");
//			msg.append("</script>");
//			return msg.toString();
//		}
//		
//		//화면에서 입력한 아이디 사용자에 대해 지정한 이메일로 임시비밀번호를 발급해서 보낸다.
//		//임시 비밀번호로 사용할 랜덤 문자열 생성
//		String pw = UUID.randomUUID().toString(); //dafh234-hklj234-fahlj43243lhaf
//		pw = pw.substring( pw.lastIndexOf("-")+1 ); //fahlj43243lhaf
//		
//		//임시 비번을 암호화하는데 사용할 salt 생성하기 
//		String salt = common.generateSalt();
//		//salt를 사용해 임시비번을 암호화하기
//		vo.setUserpw( common.getEncrypt(salt, pw) );
//		vo.setSalt(salt);
//		
//		//임시비번을 DB에 저장한 후 이메일로 임시비번을 전송한다
//		StringBuffer msg = new StringBuffer("<script>");
//		if( service.member_reset_password(vo) == 1 
//				&& common.sendPassword(vo.getEmail(), vo.getUserid(), vo.getName(), pw) ) {
//			msg.append("alert('임시 비밀번호가 발급되었습니다. \\n이메일을 확인하세요');");
//			msg.append("location='login';");
//		}else {
//			msg.append("alert('임시 비밀번호 발급 실패ㅠㅠ');");
//			msg.append("history.go(-1);");
//		}
//		msg.append("</script>");
//		return msg.toString();
//	}
//	
//	
//	//비밀번호찾기 화면 요청
//	@RequestMapping("/findPw")
//	public String find() {
//		//응답화면연결
//		return "default/member/find";
//	}
//	
//	
//	//카카오 로그인처리 요청
//	@RequestMapping("/kakaologin")
//	public String kakaologin(HttpServletRequest request) {
//		//인가 코드 받기
//		//https://kauth.kakao.com/oauth/authorize?response_type=code
//		//&client_id=${REST_API_KEY}
//		//&redirect_uri=${REDIRECT_URI}
//		StringBuffer url 
//		= new StringBuffer("https://kauth.kakao.com/oauth/authorize?response_type=code");
//		url.append("&client_id=").append(KAKAO_ID);
//		url.append("&redirect_uri=").append( appName(request) ).append("/kakao_callback");
//		return "redirect:" + url.toString();
//	}
//	
//	@RequestMapping("/kakao_callback")
//	public String kakao_callback(String code, String error, HttpSession session) {
//		if( error!=null ) return "redirect:/";
//		//토큰 받기
////		curl -v -X POST "https://kauth.kakao.com/oauth/token" \
////		 -d "grant_type=authorization_code" \
////		 -d "client_id=${REST_API_KEY}" \
////		 -d "code=${AUTHORIZE_CODE}"
//		StringBuffer url
//		= new StringBuffer(
//				"https://kauth.kakao.com/oauth/token?grant_type=authorization_code");
//		url.append("&client_id=").append(KAKAO_ID);
//		url.append("&code=").append(code);
//		JSONObject json = new JSONObject( common.requestAPI(url) );
//		String token_type = json.getString("token_type");
//		String access_token = json.getString("access_token");
//		
//		//사용자 정보 가져오기 - json
////		GET/POST /v2/user/me HTTP/1.1
////		Host: kapi.kakao.com
////		Authorization: Bearer ${ACCESS_TOKEN}
//		url = new StringBuffer("https://kapi.kakao.com/v2/user/me");
//		json = new JSONObject( common.requestAPI(url, token_type+ " "+access_token) );
//		
//		if( ! json.isEmpty() ) {
//			
//			//카카오 사용자정보를 회원정보로 담는다
//			MemberVO vo = new MemberVO();
//			vo.setSocial("K");
//			vo.setUserid( json.get("id").toString() ); //"id":123456789
//			
//			json = json.getJSONObject("kakao_account");
//			vo.setGender( json.has("gender") 
//							? (json.getString("gender").equals("female") ? "여" : "남") 
//							: "여"); //"female"
//			vo.setName( json.has("name") ? json.getString("name") : "");
//			vo.setEmail( json.getString("email") );
//			
//			json = json.getJSONObject("profile");
//			if( json.has("nickname") ) {
//				vo.setName( json.getString("nickname") );
//			}
//			
//			//카카오 아이디가 있는지 확인하여 
//			//카카오로그인이 처음이면  insert(false), 아니면 update(true)
//			if( service.member_id_check(vo.getUserid()) ) {
//				service.member_update(vo);
//			}else
//				service.member_join(vo);
//			
//			//카카오로그인정보를 세션에 담는다
//			session.setAttribute("loginInfo", vo);
//		}
//		
//		return "redirect:/";
//	}
//	
//	private String KAKAO_ID = "d62cd47e1dd0643a10f1cf0f987bda24";
//	
//	
//	//네이버 로그인처리 요청
//	@RequestMapping("/naverlogin")
//	public String naverlogin(HttpSession session, HttpServletRequest r) {
//		//로그인연동 url 생성하기
//		//https://nid.naver.com/oauth2.0/authorize?response_type=code
//		//&client_id=CLIENT_ID
//		//&state=STATE_STRING
//		//&redirect_uri=CALLBACK_URL
//		String state = UUID.randomUUID().toString();
//		session.setAttribute("state", state);
//		
//		StringBuffer url 
//		= new StringBuffer("https://nid.naver.com/oauth2.0/authorize?response_type=code");
//		url.append("&client_id=").append(NAVER_ID);
//		url.append("&state=").append(state);
//		url.append("&redirect_uri=").append( appName(r) ).append("/naver_callback");
//		//동의항목 재동의요청
//		url.append("&auth_type=reprompt");
//		return "redirect:" + url.toString();
//	}
//	
//	@RequestMapping("/naver_callback")
//	public String naver_callback(String state, HttpSession session
//								, String code, String error) {
////		Callback 응답 정보
////		API 요청 성공시 : http://콜백URL/redirect?code={code값}&state={state값}
////		API 요청 실패시 : http://콜백URL/redirect?state={state값}&error={에러코드값}&error_description={에러메시지}
//		if( error!=null || !state.equals((String)session.getAttribute("state")) ) return "redirect:/"; 
//		
//		//접근 토큰 발급 요청
//		//https://nid.naver.com/oauth2.0/token?grant_type=authorization_code
//		//&client_id=jyvqXeaVOVmV
//		//&client_secret=527300A0_COq1_XV33cf
//		//&code=EIc5bFrl4RibFls1
//		//&state=9kgsGTfH4j7IyAkg  
//		StringBuffer url 
//		= new StringBuffer("https://nid.naver.com/oauth2.0/token?grant_type=authorization_code");
//		url.append("&client_id=").append(NAVER_ID);
//		url.append("&client_secret=").append(NAVER_SECRET);
//		url.append("&code=").append(code);
//		url.append("&state=").append(state);
//		String result = common.requestAPI(url); //API요청
//		
//		JSONObject json = new JSONObject( result ); //API요청 응답결과가 json
//		String access_token = json.getString("access_token");
//		String token_type = json.getString("token_type");
//		
//		//접근 토큰을 이용하여 프로필 API 호출하기 - 응답결과 JSON
//		//https://openapi.naver.com/v1/nid/me
//		//Authorization: {토큰 타입] {접근 토큰]
//		
//		url = new StringBuffer("https://openapi.naver.com/v1/nid/me");
//		json = new JSONObject( common.requestAPI(url, token_type + " " + access_token) );
//
//		//프로필 API 호출결과코드가 정상("00")인 경우 프로필정보에 접근
//		if( json.getString("resultcode").equals("00") ) {
//			
//			//필요한 프로필정보는 response 에 있다 - json
//			json = json.getJSONObject("response");
//			
//			MemberVO vo = new MemberVO();
//			vo.setSocial("N");
//			vo.setUserid( json.getString("id") );
//			vo.setEmail( json.getString("email") );
//			vo.setName(  json.has("nickname") ? json.getString("nickname")
//											: json.getString("name") );
//			vo.setGender( json.getString("gender").equals("F") ? "여" : "남" ) ; //성별 - F: 여성 - M: 남성 - U: 확인불가
//			vo.setProfile( json.has("profile_image") 
//							? json.getString("profile_image") : "");
//			
//			//DB의 회원정보에 네이버 아이디 정보가 있다면 회원정보를 update(true), 
//			//							   없다면 회원정보를 insert(false)
//			if( service.member_id_check( vo.getUserid() ) ) {
//				//update
//				service.member_update(vo);
//			}else {
//				//insert
//				service.member_join(vo);
//			}
//			
//			//로그인정보를 세션에 담는다
//			session.setAttribute("loginInfo", vo);
//		}
//		
//		return "redirect:/";
//	}
//	
//	
//	private String appName(HttpServletRequest r) {
//		// RequestURL: http://localhost:8080/iot/naver_callback
//		// ServletPath: /naver_callback
//		// replace 후: http://localhost:8080/iot
//		return r.getRequestURL().toString().replace(r.getServletPath(), "");
//	}
//	
//	private String NAVER_ID = "LenJlOli7d6PeVHruyE6";
//	private String NAVER_SECRET = "cVJoKx0W5L";
	
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
