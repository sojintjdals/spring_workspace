package hans.memberBoard;

import javax.servlet.http.HttpSession;

import hans.testBoard.TestBoardVO;

public interface MemberBoardService {
	// 회원 로그인 체크
	public boolean loginCheck(MemberBoardVO vo, HttpSession session) throws Exception;
	// 인터셉터 로그인
	public MemberBoardVO Login(MemberBoardVO vo) throws Exception;
	// 회원 로그아웃
	public void logout(HttpSession session);
	int memberBoardInsert(MemberBoardVO vo) throws Exception;
	int memberBoardDelete(MemberBoardVO vo, HttpSession session) throws Exception;
	int memberBoardUpdate(MemberBoardVO vo, HttpSession session) throws Exception;
	MemberBoardVO MemberView(MemberBoardVO vo) throws Exception;
	// 아이디 체크
	public boolean idCheck(MemberBoardVO vo) throws Exception;
}
