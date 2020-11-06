package hans.memberBoard;

import javax.servlet.http.HttpSession;

public interface MemberBoardDAO {
//	MemberBoardVO memberBoardLogin(MemberBoardVO vo) throws Exception;
	// 회원 로그인 체크
	public MemberBoardVO loginCheck(MemberBoardVO vo);
	// 인터셉터 로그인
	public MemberBoardVO Login(MemberBoardVO vo);
	// 회원 로그인 정보
	public MemberBoardVO MemberView(MemberBoardVO vo);

	// 회원 로그아웃
	public void logout(HttpSession session);

	// 회원 가입
	int memberBoardInsert(MemberBoardVO vo) throws Exception;

	// 회원 탈퇴
	int memberBoardDelete(MemberBoardVO vo, HttpSession session) throws Exception;

	// 회원 변경
	int memberBoardUpdate(MemberBoardVO vo, HttpSession session) throws Exception;

	// 아이디 체크
	public MemberBoardVO idCheck(MemberBoardVO vo) throws Exception;
}
