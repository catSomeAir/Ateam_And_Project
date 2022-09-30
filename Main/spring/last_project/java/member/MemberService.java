package member;

import java.util.HashMap;
import java.util.List;


public interface MemberService {
	public int join(MemberVO joinVo);
	public MemberVO login(HashMap<String, String> map);
	int email_check(String email);//email 중복확인
}
