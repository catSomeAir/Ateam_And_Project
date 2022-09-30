package requestedpost;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RequestedPostDAO {
	@Autowired private SqlSession sql;
	
	public List<RequestedPostVO> getRequestedManual() {
		return sql.selectList("requestedpost.select");
	}

}