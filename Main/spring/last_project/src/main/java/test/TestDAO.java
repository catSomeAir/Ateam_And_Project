package test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
public class TestDAO implements TestService {
	@Autowired private SqlSession sql;
	@Override
	public List<TestVO> test() {
		
		return sql.selectList("test.list");
	}

	@Override
	public TestHotdogVO testhotdog(String email) {
		return sql.selectOne("test.hotdog",email);
	}

	@Override
	public List<ModelInfoVO> 안생겨요() {
		
		return sql.selectList("test.model_list");
	}

}
