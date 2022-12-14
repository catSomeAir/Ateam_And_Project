package member;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO implements MemberService {
	@Autowired private SqlSession sql;

	@Override
	public MemberVO login(HashMap<String, String> map) {
		return sql.selectOne("member.login",map);
	}

	@Override
	public int join(MemberVO joinVo) {
		
		return sql.insert("member.join", joinVo);
	}

	@Override
	public int email_check(String email) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		int test = sql.selectOne("member.email_check",map);
		System.out.println(test);
		return test;
	
	}




}
