package hans.testBoard;

import java.util.List;

public interface TestBoardService {
	List<TestBoardVO> testBoardList() throws Exception;
	//page
	List<TestBoardVO> listPage(int page)throws Exception;
	//Criteria
	List<TestBoardVO> listCriteria(Criteria cri) throws Exception;
	//read
	TestBoardVO testBoardView(TestBoardVO vo) throws Exception;
	int testBoardInsert(TestBoardVO vo) throws Exception;
	//modify
	int testBoardUpdate(TestBoardVO vo) throws Exception;
	//remove
	int testBoardDelete(TestBoardVO vo) throws Exception;
}
