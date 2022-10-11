package board;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.ModelInfoVO;

@Repository
public class BoardDAO {
	@Autowired private SqlSession sql;
	//나의 글 리스트
	public List<BoardVO> board_my_list(String email) {
		return sql.selectList("board.my_list", email);
	}
	//나의 댓글 리스트	
	public List<BoardVO> board_my_reply_list(String email) {
		return sql.selectList("board.my_reply_list", email);
	}
	//제품 해당글 추가
	public int board_insert(BoardVO vo) {
		return sql.insert("board.insert", vo);
	}
	
	//제품 해당글 수정
	public int board_update(BoardVO vo) {
		return sql.update("board.update", vo);
	}
	//제품 해당글 	삭제
	public int board_delete(String board_id) {
		return sql.delete("board.delete",board_id);
	}
	
	//제품 해당글 리스트
	public List<BoardVO> board_list(HashMap<String, String> map) {
		return sql.selectList("board.list", map);
	}
	
	
	//제품 해당글 댓글 추가
	public int board_coment_insert(ReplyVO vo) {
		return sql.insert("board.coment_insert", vo);
	}
	
	//제품 해당글 댓글 수정
		public int board_coment_update(ReplyVO vo) {
			return sql.update("board.coment_update", vo);
		}
	
	//제품 해당글 댓글 리스트
	public List<ReplyVO> board_coment_list(String board_id) {
		return sql.selectList("board.coment_list", board_id);
	}
}
