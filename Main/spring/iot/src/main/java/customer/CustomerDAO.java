package customer;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO implements CustomerService {
	@Autowired @Qualifier("hanul") private SqlSession sql;

	@Override
	public void customer_insert(CustomerVO vo) {
		sql.insert("customer.insert", vo);
	}

	@Override
	public List<CustomerVO> customer_list() {
		return sql.selectList("customer.list");
	}

	@Override
	public CustomerVO customer_detail(int id) {
		return sql.selectOne("customer.detail", id);
	}

	@Override
	public void customer_update(CustomerVO vo) {
		sql.update("customer.update", vo);
	}

	@Override
	public void customer_delete(int id) {
		sql.delete("customer.delete", id);
	}

}
