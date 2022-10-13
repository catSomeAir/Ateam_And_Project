package member;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO implements MemberService {
	@Autowired @Qualifier("hanul") private SqlSession sql;

	@Override
	public int member_join(MemberVO vo) {
		return sql.insert("member.join", vo);
	}

	@Override
	public MemberVO member_myinfo(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO member_login(HashMap<String, String> map) {
		return sql.selectOne("member.login", map);
	}

	@Override
	public boolean member_id_check(String userid) {
		//존재하는 경우: 1(true), 아니면 0(false)
		return (Integer)sql.selectOne("member.id_check", userid)==1 ? true : false;
	}

	@Override
	public int member_update(MemberVO vo) {
		return sql.update("member.update", vo);
	}

	@Override
	public int member_delete() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String member_salt(String userid) {
		return sql.selectOne("member.salt", userid);
	}

	@Override
	public int member_reset_password(MemberVO vo) {
		return sql.update("member.reset_password", vo);
	}

	@Override
	public int member_userid_email(MemberVO vo) {
		return sql.selectOne("member.userid_email", vo);
	}

}
