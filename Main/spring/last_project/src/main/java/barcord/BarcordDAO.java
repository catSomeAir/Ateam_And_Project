package barcord;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BarcordDAO implements BarcordService {
	@Autowired private SqlSession sql;
}
