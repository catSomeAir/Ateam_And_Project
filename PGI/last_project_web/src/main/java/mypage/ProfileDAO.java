package mypage;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileDAO {
	@Autowired @Qualifier("ateam") private SqlSession sql;
	
	public String profile(String email) {
		return sql.selectOne("mypage.profile",email);
	}
}
