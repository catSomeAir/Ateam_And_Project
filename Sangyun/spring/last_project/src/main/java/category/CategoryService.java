package category;

import java.util.List;

public interface CategoryService {
	public List<CategoryVO> l_name_list();
	public List<CategoryVO> m_name_list(int lcode);
}
