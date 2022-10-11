package member;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO implements MemberService {
	@Autowired private SqlSession sql;
	
	
	
	
	//회원정보 수정
	
	public int userinfo_update(MemberVO vo) {
		
		return sql.update("member.userinfo_update",vo);
	}
	
	@Override
	public MemberVO login(HashMap<String, String> map) {
		return sql.selectOne("member.login",map);
	}


	public int g_list_save(MemberVO vo) {
		return sql.insert("member.insertgoogle", vo);
	}

	public int social_save(MemberVO vo) {
		return sql.insert("member.social_save", vo);
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
