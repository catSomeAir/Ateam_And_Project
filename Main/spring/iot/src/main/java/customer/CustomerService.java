package customer;

import java.util.List;

public interface CustomerService {
	//CRUD(Create, Read, Update, Delete)
	void customer_insert(CustomerVO vo);	//신규고객정보저장
	List<CustomerVO> customer_list();		//고객정보목록조회
	CustomerVO customer_detail(int id);		//고객정보상세조회
	void customer_update(CustomerVO vo); 	//고객정보변경저장
	void customer_delete(int id);			//고객정보삭제
}
