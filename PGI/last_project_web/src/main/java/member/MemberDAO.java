package member;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO /* implements MemberService */ {
	@Autowired @Qualifier("ateam") private SqlSession sql;

	
	public int member_join(MemberVO vo) {
		return sql.insert("member.join", vo);
	}

	
	public MemberVO member_myinfo(String userid) {
		// TODO Auto-generated method stub
		return null;
	}


	public int member_email_check(String userid) {
		//존재하는 경우: 1(true), 아니면 0(false)
		return (Integer)sql.selectOne("member.id_check", userid);
	}

	public int member_update(MemberVO vo) {
		return sql.update("member.update", vo);
	}

	public int member_delete() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String member_salt(String userid) {
		return sql.selectOne("member.salt", userid);
	}
	
	public int member_reset_password(MemberVO vo) {
		return sql.update("member.reset_password", vo);
	}

	public int member_userid_email(MemberVO vo) {
		return sql.selectOne("member.userid_email", vo);
	}
	
	
	//==================================
	//내부로그인

	public MemberVO login(HashMap<String, String> map) {
		return sql.selectOne("member.login", map);
	}
	
	//회원정보수정
	public int edit(MemberVO vo) {
		return sql.update("member.edit", vo);
	}
	
	//회원정보조회
	public MemberVO getuserList(String email) {
		return sql.selectOne("member.show",email);
	}

}
