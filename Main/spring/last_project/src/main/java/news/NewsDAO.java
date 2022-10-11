package news;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.ReplyVO;

@Repository
public class NewsDAO {
	@Autowired private SqlSession sql;

	public String reply_cnt(String email) {
	
		return sql.selectOne("news.reply_cnt",email);
	}
	
	public ReplyVO reply_info(String email) {
		
		return sql.selectOne("news.reply_info",email);
	}
	
}
