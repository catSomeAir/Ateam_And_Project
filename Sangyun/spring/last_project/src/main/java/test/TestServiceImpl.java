package test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
	@Autowired TestDAO dao;
	@Override
	public List<TestVO> test() {
		
		return dao.test();
				
	}

}
