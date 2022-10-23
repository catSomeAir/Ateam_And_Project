package cs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CsServiceImpl implements CsService {
	@Autowired private CsDAO dao;
	
	@Override
	public int cs_insert(CsVO vo) {
//		System.out.println("sercice 왔도!!");
		return dao.cs_insert(vo);
	}

	@Override
	public CsPageVO cs_list(CsPageVO page) {
		return dao.cs_list(page);
	}

	@Override
	public CsVO cs_detail(int id) {
		return dao.cs_detail(id);
	}

	@Override
	public int cs_read(int id) {
		return dao.cs_read(id);
	}

	@Override
	public int cs_update(CsVO vo) {
		return dao.cs_update(vo);
	}


}
