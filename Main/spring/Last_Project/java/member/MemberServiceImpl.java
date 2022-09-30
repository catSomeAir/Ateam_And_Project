package member;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired private MemberDAO dao;

	
	
	@Override
	public MemberVO login(HashMap<String, String> map) {
		return dao.login(map);
	}

	@Override
	public int join(MemberVO joinVo) {
		return dao.join(joinVo);
	}

	@Override
	public int email_check(String email) {
		return dao.email_check(email);
	}


}
