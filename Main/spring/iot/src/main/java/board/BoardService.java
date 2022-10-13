package board;

import java.util.List;

public interface BoardService {
	//CRUD
	int board_insert(BoardVO vo); 	//방명록 신규저장
	BoardPageVO board_list(BoardPageVO page); //방명록 목록(페이징처리된)조회
	BoardVO board_detail(int id); 	//방명록 상세조회
	int board_read(int id); 		//방명록 조회수 증가처리
	int board_update(BoardVO vo); 	//방명록 변경저장
	int board_delete(int id); 		//방명록 글삭제
	
	BoardFileVO board_file_info(int id); //해당 첨부파일정보 조회 
	List<BoardFileVO> board_file_list(String removed);  //첨부파일목록 조회
	List<BoardFileVO> board_file_list(int board_id);  //첨부파일목록 조회
	int board_file_delete(String removed); //삭제대상 첨부파일정보 삭제
	
	int board_comment_insert(BoardCommentVO vo); 	//댓글신규저장처리
	List<BoardCommentVO> board_comment_list(int board_id); //댓글목록조회
	int board_comment_update(BoardCommentVO vo); 	//댓글변경저장처리
	int board_comment_delete(int id); 				//댓글삭제처리
	
}
