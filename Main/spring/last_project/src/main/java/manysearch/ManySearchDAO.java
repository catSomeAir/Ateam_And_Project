package manysearch;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import search.CategorySearchVO;

@Repository 
public class ManySearchDAO {
	@Autowired private SqlSession sql;
	
	public List<CategorySearchVO> many_search(){
		
		
		return sql.selectList("search.many_search");
	}
}
