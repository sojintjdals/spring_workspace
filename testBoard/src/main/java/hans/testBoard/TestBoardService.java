package hans.testBoard;

import java.util.List;

public interface TestBoardService {
	List<TestBoardVO> testBoardList() throws Exception;
	//page
	List<TestBoardVO> listPage(int page)throws Exception;
	//Criteria
	List<TestBoardVO> listCriteria(Criteria cri) throws Exception;
	int listCountCriteria(Criteria cri) throws Exception;
	//read
	TestBoardVO testBoardView(TestBoardVO vo) throws Exception;
	List<TestBoardVO> getAttach(TestBoardVO vo) throws Exception;
	TestBoardVO testBoardRead(int seqno) throws Exception;
	int testBoardInsert(TestBoardVO vo) throws Exception;
	//modify
	int testBoardUpdate(TestBoardVO vo) throws Exception;
	//remove
	int testBoardDelete(TestBoardVO vo) throws Exception;
	//fileUpload
	int InsertFile(TestBoardVO vo) throws Exception;
	//fileGet
	int deleteAttach(TestBoardVO vo) throws Exception;
	int updateAttach(TestBoardVO vo) throws Exception;
	int cntUpdate(TestBoardVO vo) throws Exception;
	int selectDeleteAttach(TestBoardVO vo) throws Exception;
}
