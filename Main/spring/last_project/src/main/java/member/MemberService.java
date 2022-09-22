package member;

import java.util.HashMap;


public interface MemberService {
	public int join(MemberVO joinVo);
	public MemberVO login(HashMap<String, String> map);
}
