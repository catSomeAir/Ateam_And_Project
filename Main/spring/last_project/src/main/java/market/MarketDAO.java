package market;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MarketDAO {
	@Autowired private SqlSession sql;
	public List<GiftVO> gift_list(String email) {
		
		return sql.selectList("market.gift_list", email);
	}
	
	public int gift_insert(HashMap<String, String> map) {
		
		return sql.update("market.gift_insert", map);
	}
	
}