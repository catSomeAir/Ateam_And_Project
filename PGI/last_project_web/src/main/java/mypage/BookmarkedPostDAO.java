package mypage;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class BookmarkedPostDAO {
	
	@Autowired @Qualifier("ateam") private SqlSession sql;

	public List<BookmarkedPostVO> getPostList(String email) {
		
		return sql.selectList("mypage.bookmarked_post",email);
	}
	
	/* 다운로드한 설명서 불러오기 위한 것 */
	
	public List<DownloadVO> download(String email){
		return sql.selectList("mypage.download",email);
	}
}