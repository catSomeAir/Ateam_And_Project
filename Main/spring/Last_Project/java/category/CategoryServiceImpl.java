package category;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired private CategoryDAO dao;
	@Override
	public List<CategoryVO> l_name_list() {
		return dao.l_name_list();
	}
	@Override
	public List<CategoryVO> m_name_list(int lcode) {
		return dao.m_name_list(lcode);
	}
	@Override
	public HashMap<String, String> count(String email) {
		return dao.count(email);
	}


}
