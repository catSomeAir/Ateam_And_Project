package notice;

import java.util.List;

public interface NoticeService {
	//CRUD(Create,Read,Update,Delete)
	int notice_insert(NoticeVO vo);  	//공지글 신규등록
	int notice_reply_insert(NoticeVO vo);  	//공지글 신규답글등록
	List<NoticeVO> notice_list();		//공지글목록조회
	NoticePageVO notice_list(NoticePageVO vo);//공지글목록조회(페이징처리된)
	NoticeVO notice_detail(int id); 	//공지글안내(상세)
	int notice_update(NoticeVO vo); 	//공지사항 변경저장
	int notice_read(int id); 			//조회수변경
	int notice_delete(int id);			//공지사항 삭제
}
