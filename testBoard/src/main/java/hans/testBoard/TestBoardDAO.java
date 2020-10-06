package hans.testBoard;

import java.util.List;

public interface TestBoardDAO {
	// listAll
	List<TestBoardVO> testBoardList() throws Exception;

	// listPage
	List<TestBoardVO> listPage(int page) throws Exception;

	// listCriteria
	List<TestBoardVO> listCriteria(Criteria cri) throws Exception;

	// read
	TestBoardVO testBoardView(TestBoardVO vo) throws Exception;

	// fileGet
	List<TestBoardVO> getAttach(TestBoardVO vo) throws Exception;

	// 댓글
	List<TestBoardVO> replyList(TestBoardVO vo) throws Exception;

	// 댓글만들기

	int replyInsert(TestBoardVO vo) throws Exception;

	// 댓글업데이트

	int replyUpdate(TestBoardVO vo)throws Exception;
	
	// 댓글삭제
	
	int replyDelete(int rno)throws Exception;

	TestBoardVO testBoardRead(int seqno) throws Exception;

	// create
	int testBoardInsert(TestBoardVO vo) throws Exception;

	// update
	int testBoardUpdate(TestBoardVO vo) throws Exception;

	int cntUpdate(TestBoardVO vo) throws Exception;

	// delete
	int testBoardDelete(TestBoardVO vo) throws Exception;

	// count
	int countPaging(Criteria cri) throws Exception;

	List<TestBoardVO> listSearch(Criteria cri) throws Exception;

	int listSearchCount(Criteria cri) throws Exception;

	// 파일업로드
	int addAttach(TestBoardVO vo) throws Exception;

	int updateAttach(TestBoardVO vo) throws Exception;

	int deleteAttach(TestBoardVO vo) throws Exception;

	int seleteDeleteAttach(TestBoardVO vo) throws Exception;
}
