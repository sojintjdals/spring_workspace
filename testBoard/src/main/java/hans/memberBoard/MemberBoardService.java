package hans.memberBoard;

public interface MemberBoardService {
	MemberBoardVO memberBoardView(MemberBoardVO vo) throws Exception;
	int memberBoardInsert(MemberBoardVO vo) throws Exception;
	int memberBoardDelete(MemberBoardVO vo) throws Exception;
}
