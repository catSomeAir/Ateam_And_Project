package board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO implements BoardService {
	@Autowired @Qualifier("hanul") private SqlSession sql;
	
	@Override
	public int board_insert(BoardVO vo) {
		//방명록 글을 저장한 후
		int dml = sql.insert("board.insert", vo);
		//첨부파일이 있는 경우 첨부파일 정보(board_file)로 저장한다
		if( vo.getFileInfo() != null ) sql.insert("board.file_insert", vo);
		return dml;
	}

	@Override
	public BoardPageVO board_list(BoardPageVO page) {
		//총글건수 조회
		page.setTotalList( sql.selectOne("board.totalList", page) );
		page.setList( sql.selectList("board.list", page) );
		//해당 페이지의 글목록 조회 
		return page;
	}

	@Override
	public BoardVO board_detail(int id) {
		BoardVO vo = sql.selectOne("board.detail", id);
		vo.setFileInfo( sql.selectList("board.file_list", id) );
		return vo;
	}

	@Override
	public int board_read(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int board_update(BoardVO vo) {
		int dml = sql.update("board.update", vo);
		if( vo.getFileInfo() != null ) sql.insert("board.file_insert", vo);
		return dml;
	}

	@Override
	public int board_delete(int id) {
		return sql.delete("board.delete", id);
	}

	@Override
	public BoardFileVO board_file_info(int id) {
		return sql.selectOne("board.file_info", id);
	}

	@Override
	public List<BoardFileVO> board_file_list(String removed) {
		return sql.selectList("board.file_list_in", removed);
	}

	@Override
	public int board_file_delete(String removed) {
		return sql.delete("board.file_delete", removed);
	}

	@Override
	public List<BoardFileVO> board_file_list(int board_id) {
		return sql.selectList("board.file_list", board_id);
	}

	@Override
	public int board_comment_insert(BoardCommentVO vo) {
		return sql.insert("board.comment_insert", vo);
	}

	@Override
	public List<BoardCommentVO> board_comment_list(int board_id) {
		return sql.selectList("board.comment_list", board_id);
	}

	@Override
	public int board_comment_update(BoardCommentVO vo) {
		return sql.update("board.comment_update", vo);
	}

	@Override
	public int board_comment_delete(int id) {
		return sql.delete("board.comment_delete", id);
	}

}
