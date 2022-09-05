package category;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAO implements CategoryService {
	@Autowired private SqlSession sql;
	@Override
	public List<CategoryVO> l_name_list() {
		return sql.selectList("category.l_list");
	}
	@Override
	public List<CategoryVO> m_name_list(int lcode) {
		return sql.selectList("category.m_list", lcode);
	}
	@Override
	public HashMap<String, String> count(String email) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("board_count", sql.selectOne("category.board_count",email).toString());
		map.put("reply_count", sql.selectOne("category.reply_count",email).toString());
		return map;
	}

}
