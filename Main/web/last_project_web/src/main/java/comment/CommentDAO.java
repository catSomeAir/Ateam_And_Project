package comment;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
public class CommentDAO {
	@Autowired @Qualifier("ateam") private SqlSession sql;
	//나의 글 리스트
	public List<CommentVO> board_my_list(String email) {
		return sql.selectList("board.my_list", email);
	}
	//나의 댓글 리스트	
	public List<CommentVO> board_my_reply_list(String email) {
		return sql.selectList("board.my_reply_list", email);
	}
	//제품 해당글 추가
	public int comment_insert(CommentVO vo) {
		return sql.insert("comment.comment_insert", vo);
	}
	
	//제품 해당글 수정
	public int coment_update(CommentVO vo) {
		return sql.update("comment.update", vo);
	}
	//제품 해당글 	삭제
	public int board_delete(String board_id) {
		return sql.delete("board.delete",board_id);
	}
	
	//제품 해당글 리스트
	public List<CommentVO> board_list(HashMap<String, String> map) {
		return sql.selectList("comment.list", map);
	}
	
	
	//제품 해당글 댓글 추가
	public int coment_insert(ReplyVO vo) {
		return sql.insert("comment.coment_insert", vo);
	}
	
	//제품 해당글 댓글 수정
	public int coment_reply_update(ReplyVO vo) {
		return sql.update("comment.comment_update", vo);
	}
	//제품 해당글 댓글 수정
	public int comment_reply_delete(String rep_no) {
		return sql.update("comment.comment_reply_delete", rep_no);
	}
	//제품 해당글 댓글 리스트
	public List<ReplyVO> coment_list(String board_id) {
		return sql.selectList("comment.coment_list", board_id);
	}
}
