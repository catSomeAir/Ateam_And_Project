package notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {
	@Autowired private SqlSession sql;
	
	
	public List<NoticeVO> getList() {
		return sql.selectList("notice.select");
	}
	
}
