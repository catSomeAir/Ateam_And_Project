package member;

import java.util.HashMap;

public interface MemberService {
	//CRUD(Create, Read, Update, Delete)
	int member_join(MemberVO vo); //회원가입시 회원정보 저장
	MemberVO member_myinfo(String userid); //내정보보기(마이페이지, 마이프로필)
	MemberVO member_login(HashMap<String, String> map); //로그인처리
	boolean member_id_check(String userid);//회원가입시 아이디중복확인(아이디존재여부)
	String member_salt(String userid); //회원의 salt 조회
	int member_update(MemberVO vo); //마이페이지에서 회원정보변경저장
	int member_reset_password(MemberVO vo); //비밀번호변경
	int member_userid_email(MemberVO vo); //비밀번호변경을 위한 아이디와 이메일확인
	int member_delete(); //회원탈퇴시 회원정보삭제
}
