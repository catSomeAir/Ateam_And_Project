package com.hanul.ateam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import board.BoardVO;
import comment.CommentDAO;
import comment.CommentVO;
import comment.ReplyVO;
import manual.ManualDAO;
import manual.ManualVO;
import notice.NoticePageVO;
import notice.NoticeServiceImpl;
import search.CategorySearchVO;
import search.SearchDAO;

@Controller
public class SearchController {
	@Autowired
	private NoticeServiceImpl service;
	@Autowired
	private NoticePageVO page;
	@Autowired
	private SearchDAO dao;
	@Autowired
	private ManualDAO manualdao;
	@Autowired
	private CommentDAO commentdao;
	
	//AS센터 리스트
	
	@RequestMapping(value = "/as_list_web", produces = "text/html;charset=utf-8")
	public String as_list(String brand_name) {
		System.out.println("방구야"+brand_name);
		 return  "";
	}
	
	//해당 글 삽입
	@RequestMapping(value = "/comment_insert_web", produces = "text/html;charset=utf-8")
	public String comment_inser(String content, String cmt_code, String model_code, String email) {
		CommentVO commentvo = new CommentVO();
		commentvo.setEmail(email);
		commentvo.setContent(content);
		commentvo.setCmt_code(cmt_code);
		commentvo.setModel_code(model_code);
		commentdao.comment_insert(commentvo);
		System.out.println("글등록됨");
		 return  "redirect:detail_web.mo?model_code="+model_code;
	}
	//해당 글 수정
	@RequestMapping(value = "/board_update", produces = "text/html;charset=utf-8")
	public String board_update(String vo ) {
		CommentVO commentvo = new CommentVO();
		//내용채워야함
		 commentdao.coment_update(commentvo);
		 return  "";
	}
	
	//제품(코드) 해당글의 댓글 삭제
	@RequestMapping(value = "/comment_reply_delete_web", produces = "text/html;charset=utf-8")
	public String comment_reply_delete(String rep_no, String model_code) {
		commentdao.comment_reply_delete(rep_no);
		return "redirect:detail_web.mo?model_code="+model_code;
	}

	//제품(코드) 해당글의 댓글 수정
	@RequestMapping(value = "/comment_reply_update_web", produces = "text/html;charset=utf-8")
	public String board_coment_update(String content, String rep_no, String model_code) {
		ReplyVO replyvo = new ReplyVO();
		System.out.println(content + rep_no);
		replyvo.setContent(content);
		replyvo.setRep_no(rep_no);
		commentdao.coment_reply_update(replyvo);
		return   "redirect:detail_web.mo?model_code="+model_code;
	}
	
	// 상세화면 댓글삽입
	//제품(코드) 해당글의 댓글 삽입
	@RequestMapping(value = "/coment_insert_web.mo", produces = "text/html;charset=utf-8")
	public String board_coment_insert(String board_id, String content, String email, String model_code) {
		ReplyVO vo = new ReplyVO();
		vo.setEmail(email);
		vo.setBoard_id(board_id);
		vo.setContent(content);
		System.out.println("email" + vo.getEmail() +"boardid"+ vo.getBoard_id() + vo.getContent());
		commentdao.coment_insert(vo);
		System.out.println("된듯");
		
		return "redirect:detail_web.mo?model_code="+model_code;
	}
	
	// 검색목록 상세화면
	@RequestMapping(value = "/detail_web.mo", produces = "text/html;charset=utf-8")
	public String detail(String model_code, Model model) {
		CategorySearchVO vo = dao.model_code_list(model_code);
		if(vo != null) model.addAttribute("vo",vo);
		ManualVO manualvo = manualdao.manual_info(model_code);
		HashMap<String, String> map = new HashMap<>();
		map.put("model_code", model_code);
		map.put("cmt_code", "a");
		List<CommentVO> commentlist = commentdao.board_list(map);
		
		
		for(int i = 0 ; i < commentlist.size(); i++) {
			
		commentlist.get(i).setReplylist(commentdao.coment_list(commentlist.get(i).getBoard_id()));
		 	   
		}
		
		model.addAttribute("manualvo",manualvo);
		model.addAttribute("commentlist",commentlist);
		
		return "search/detail";
	}

	// 입력받은 검색어를 초,중,종성으로 뜯어논 search_div_text로 검색 - 전체검색
	@RequestMapping(value = "/search_web.mo", produces = "text/html;charset=utf-8")
	public String search_text(String search_text, Model model) {
		List<CategorySearchVO> list = dao.search_text(text_div(search_text));
		model.addAttribute("list", list);

		System.out.println(list.get(0).getModel_name());
		return "search_list";
	}

	public static String text_div(String text) {
		String[] CHO = { "ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ", "ㄹ", "ㅁ", "ㅂ", "ㅃ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ", "ㅋ", "ㅌ", "ㅍ",
				"ㅎ" };

		String[] JOONG = { "ㅏ", "ㅐ", "ㅑ", "ㅒ", "ㅓ", "ㅔ", "ㅕ", "ㅖ", "ㅗ", "ㅘ", "ㅙ", "ㅚ", "ㅛ", "ㅜ", "ㅝ", "ㅞ", "ㅟ", "ㅠ",
				"ㅡ", "ㅢ", "ㅣ" };

		String[] JONG = { "", "ㄱ", "ㄲ", "ㄳ", "ㄴ", "ㄵ", "ㄶ", "ㄷ", "ㄹ", "ㄺ", "ㄻ", "ㄼ", "ㄽ", "ㄾ", "ㄿ", "ㅀ", "ㅁ", "ㅂ", "ㅄ",
				"ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ" };
		String result = "";
		for (int i = 0; i < text.length(); i++) {
			char uniVal = text.charAt(i);

			// 한글일 경우만 시작해야 하기 때문에 0xAC00부터 아래의 로직을 실행한다
			if (uniVal >= 0xAC00) {
				System.out.print(uniVal + "=>");
				uniVal = (char) (uniVal - 0xAC00);

				char cho = (char) (uniVal / 28 / 21);
				char joong = (char) ((uniVal) / 28 % 21);
				char jong = (char) (uniVal % 28); // 종성의 첫번째는 채움이기 때문에

				result = (CHO[cho] + JOONG[joong] + JONG[jong]);
			} else {
				result = String.valueOf(uniVal);
			}
		}
		return result;
	}

	
}
