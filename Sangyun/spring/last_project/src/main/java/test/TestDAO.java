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

}
