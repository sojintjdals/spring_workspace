package hans.memberBoard;

import javax.servlet.http.HttpSession;

import hans.testBoard.TestBoardVO;

public interface MemberBoardService {
	// 회원 로그인 체크
	public boolean loginCheck(MemberBoardVO vo, HttpSession session) throws Exception;
	// 회원 로그아웃
	public void logout(HttpSession session);
	int memberBoardInsert(MemberBoardVO vo) throws Exception;
	int memberBoardDelete(MemberBoardVO vo) throws Exception;
	int memberBoardUpdate(MemberBoardVO vo) throws Exception;
	MemberBoardVO MemberView(MemberBoardVO vo) throws Exception;
}
