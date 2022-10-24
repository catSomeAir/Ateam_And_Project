package mypage;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class MyPostDAO {
	@Autowired @Qualifier("ateam") private SqlSession sql;
	
	public List<BoardVO> mypost(String email){
		return sql.selectList("mypage.mypost",email);
	}
}
