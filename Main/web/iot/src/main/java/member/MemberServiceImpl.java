package member;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired private MemberDAO dao;
	
	@Override
	public int member_join(MemberVO vo) {
		return dao.member_join(vo);
	}

	@Override
	public MemberVO member_myinfo(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO member_login(HashMap<String, String> map) {
		return dao.member_login(map);
	}

	@Override
	public boolean member_id_check(String userid) {
		return dao.member_id_check(userid);
	}

	@Override
	public int member_update(MemberVO vo) {
		return dao.member_update(vo);
	}

	@Override
	public int member_delete() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String member_salt(String userid) {
		return dao.member_salt(userid);
	}

	@Override
	public int member_reset_password(MemberVO vo) {
		return dao.member_reset_password(vo);
	}

	@Override
	public int member_userid_email(MemberVO vo) {
		return dao.member_userid_email(vo);
	}

}
