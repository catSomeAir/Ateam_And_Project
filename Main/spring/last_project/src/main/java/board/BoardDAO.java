package board;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.ModelInfoVO;

@Repository
public class BoardDAO {
	@Autowired private SqlSession sql;
	public int board_insert(BoardVO vo) {
		return sql.insert("board.insert", vo);
	}
	
}
