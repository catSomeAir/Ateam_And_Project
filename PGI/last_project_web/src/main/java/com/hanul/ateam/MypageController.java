package com.hanul.ateam;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import common.CommonService;
import member.MemberDAO;
import member.MemberServiceImpl;
import member.MemberVO;
import mypage.BoardVO;
import mypage.BookmarkedPostDAO;
import mypage.BookmarkedPostVO;
import mypage.DownloadVO;
import mypage.MyPostDAO;
import mypage.PointDAO;
import mypage.ProfileDAO;
import mypage.ReplyVO;

@Controller
public class MypageController {
	@Autowired PointDAO pointdao;
	@Autowired BookmarkedPostDAO bookmarkeddao;
	@Autowired ProfileDAO profiledao;
	@Autowired MemberDAO memberdao;
	@Autowired MyPostDAO postdao;
	@Autowired private MemberServiceImpl service;
	@Autowired private CommonService common;
	
	//회원정보수정
	@RequestMapping(value="/edit_myprofile"
			, produces="text/html; charset=utf-8")
	public String edit(String email,String pw,String name,String phone,Model model,HttpSession session,MultipartFile file,String attach,HttpServletRequest request) {
		System.out.println(email);
		System.out.println(pw);
		System.out.println(name);
		System.out.println(phone);
		
		MemberVO vo = new MemberVO();		
		MemberVO vo1 = (MemberVO) session.getAttribute("loginInfo");
		
		vo.setEmail(vo1.getEmail());
		vo.setPw(pw);
		vo.setName(name);
		vo.setPhone(phone);
		vo.setFilepath(vo1.getFilepath());
		
		String uuid = session.getServletContext().getRealPath("resources") + vo1.getFilepath();
		if(!file.isEmpty()) {
			vo.setFilename(file.getOriginalFilename());
			vo.setFilepath(fileUpload("profile", file, request));
			if( vo1.getFilename() != null ) {
				File f = new File(uuid);
				if ( f.exists() ) { f.delete(); }
			}
		} else {
			if(attach.isEmpty()) {
				//원래 있던 첨부 파일은 서버에서 삭제
				if( vo1.getFilename() != null ) {
					File f = new File(uuid);
					if ( f.exists() ) { f.delete(); }
				}
			} else {
				vo.setFilename(vo1.getFilename());
				vo.setFilepath(vo1.getFilepath());
			}
			
		}
		memberdao.edit(vo);
		vo =memberdao.getuserList(email);
		session.setAttribute("loginInfo", vo);
		return "redirect:login_web";
	}
	
	//첨부파일 업로드
		public String fileUpload(String category, MultipartFile file, HttpServletRequest request) {
			//업로드할 물리적 위치
			// D:\Study_Spring\Workspace\.metadata\.plugins\org...er.core\tmp1\wtpwebapps\iot\resources
			//String path = request.getSession().getServletContext().getRealPath("resources");
			// d://app/iot
			String path = "d://app" + request.getContextPath();
			
			// upload/profile/2022/08/23
			String upload = "/upload/" + category 
						+  new SimpleDateFormat("/yyyy/MM/dd").format(new Date());
			//D:\Study_Spring\Wo....\iot\resources/upload/profile/2022/08/23
			path += upload;
			
			//해당 경로 폴더가 없으면 만든다
			File folder = new File( path );
			if( ! folder.exists() )	folder.mkdirs();
			
			//파일 업로드
			//파일명에 고유id를 붙인다
			//dafqer32-g38fgfa_abc.png
			String uuid = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
			
			try {
				file.transferTo( new File(path, uuid) );
			}catch(Exception e) {}
			
			// /upload/profile/2022/08/23/dafqer32-g38fgfa_abc.png
			// --> http://localhost:8080/iot/upload/profile/2022/08/23/dafqer32-g38fgfa_abc.png
			return appName(request) + upload + "/" + uuid;
		}
		public String appName(HttpServletRequest r) {
			// RequestURL: http://localhost:8080/iot/naver_callback
			// ServletPath: /naver_callback
			// replace 후: http://localhost:8080/iot
			return r.getRequestURL().toString().replace(r.getServletPath(), "");
		}
	

	// 마이페이지 요청
	@RequestMapping("/list_web.my")
	public String list(HttpSession session, Model model) {
		session.setAttribute("category", "my");
//		MemberVO loginInfo = (MemberVO)session.getAttribute("loginInfo");
//		 System.out.println(loginInfo.getEmail()); 
//		  model.addAttribute("useremail",
//		  loginInfo.getEmail()); model.addAttribute("username",loginInfo.getName());
//		  model.addAttribute("userphone",loginInfo.getPhone()); 
			/*
			 * point_amount =pointdao.point(loginInfo.getEmail());
			 * model.addAttribute("point",point_amount);
			 */
//		  String profile = profiledao.profile(loginInfo.getEmail()); 
//		  model.addAttribute("profile", profile);
//		MemberVO vo = memberdao.getuserList(loginInfo.getEmail());
//		model.addAttribute("vo", vo);
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
	public String mypost_list(HttpSession session,Model model) {
		MemberVO loginInfo = (MemberVO)session.getAttribute("loginInfo");
		List<BoardVO> vo =postdao.mypost(loginInfo.getEmail());
		model.addAttribute("vo",vo);
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
	public String myreply_list(HttpSession session,Model model) {
		MemberVO loginInfo = (MemberVO)session.getAttribute("loginInfo");
		List<ReplyVO> vo= postdao.myreply(loginInfo.getEmail());
		model.addAttribute("vo",vo);
		return "mypage/myreply_list";
	}

	@RequestMapping("/edit")
	public String mypage_edit(MultipartFile file) {
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
	@RequestMapping("/broadcasting")
	public String chat() {
		return "mypage/broadcast";
	}
}
