package bookmarkedpost;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookmarkedPostDAO {
	
	@Autowired private SqlSession sql;

	public List<BookmarkedPostVO> getPostList(String email) {
		
		return sql.selectList("bookmarkedpost.select",email);
	}

}