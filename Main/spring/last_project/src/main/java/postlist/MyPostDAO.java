package postlist;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyPostDAO {
	@Autowired private SqlSession sql;
	
	public List<MyPostVO> getMyPostShort(String email) {
		return sql.selectList("postlist.select",email);
	}

	public List<MyReplyVO> getMyReplyShort(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}
