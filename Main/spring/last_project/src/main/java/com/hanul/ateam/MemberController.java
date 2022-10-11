package com.hanul.ateam;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.google.gson.Gson;

import category.CategoryServiceImpl;
import category.CategoryVO;
import common.CommonService;
import member.MemberDAO;
import member.MemberServiceImpl;
import member.MemberVO;


@RestController
public class MemberController {
	@Autowired private MemberServiceImpl service;
	@Autowired MemberDAO dao;
	@Autowired private CommonService common;
	
	//회원 정보 수정 업데이트
	@RequestMapping(value = "/edit_profile" , produces = "text/html;charset=utf-8")
	public String edit_profile(String vo,  HttpServletRequest req) {
		MemberVO membervo = new Gson().fromJson(vo, MemberVO.class);
		
		String imgpath = "";
		MultipartRequest mReq = (MultipartRequest) req;
		MultipartFile file = mReq.getFile("file");//안드에서 post한곳에서 vo, file 로 정해준 그 이름

		if(file != null) {
			//기존에 있던 이미지 파일을 지우는 처리를 한다.
			removed_file(membervo, req);
			membervo.setFilepath(common.fileUpload("pj", file, req));
		}
				

			
			//새로들어온 vo와 파일넣기
			dao.userinfo_update(membervo);
			
		
		return ""; 
		
	}
	
	private void removed_file(MemberVO vo, HttpServletRequest request) {
			String filepath = vo.getFilepath();
			//http://localhost/iot/upload/board/2022/08/30/96e925f9-0d80-421a-9a4e-a6081ab5b5ce_마케팅의이해.mp3
			//--> d://app/iot/upload/.....
			if(filepath != null) {
				
			filepath = filepath.replace("http://192.168.0.33"
								, "d://app/").replace("http://localhost", "d://app");
			File file = new File( filepath );
			if( file.exists() ) file.delete();
			}
	}
	
	
	
	@RequestMapping(value = "/email_check.me" , produces = "text/html;charset=utf-8")
	public String email_check(String email) {
		int test =service.email_check(email);
		
		return test+""; 
		
	}
	
	@RequestMapping(value =  "/join.me" , produces = "text/html;charset=utf-8")
	public String join(String vo) {
		System.out.println("여기까지 왔도??!!");
		MemberVO join_info = new Gson().fromJson(vo, MemberVO.class);
		int num = service.join(join_info);
		System.out.println("왔는감?"+join_info);
		
		return String.valueOf(num);
	}
	
	@RequestMapping(value = "/login.me", produces = "text/html;charset=utf-8")
	public String m_list(String email, String pw) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", email);
//		map.put("socail", "0");
		map.put("pw", pw);
		MemberVO vo = service.login(map);
		return  new Gson().toJson(vo);
	}
	
	//구글 로그인 정보 안드로이드에서 받아와서 DB에 저장
	
	  @RequestMapping(value="/socialinfo.me", produces ="text/html;charset=utf-8") 
	  public String g_list_save(String vo) {
		  MemberVO membervo = new Gson().fromJson(vo, MemberVO.class);
		  
		 
		  
		  int check = dao.email_check(membervo.getEmail());
		  if(check !=1 ) {
			  	if(membervo.getSocial_code().equals("G")) {
			  		dao.g_list_save(membervo);
			  	}else if(membervo.getSocial_code().equals("N") || membervo.getSocial_code().equals("K") ) {
			  		dao.social_save(membervo);
			  	}
		  }
		  String email = membervo.getEmail();
		  String social_code = membervo.getSocial_code();
		 
		  System.out.println(email);
		  System.out.println(social_code);
		  HashMap<String, String> map = new HashMap<String, String>();
		  map.put("email", email);
		  map.put("pw", null);
		  
		
		  String result1 = new Gson().toJson(service.login(map));
		  System.out.println(result1);
		return result1;
	  }
	  
	  
}

