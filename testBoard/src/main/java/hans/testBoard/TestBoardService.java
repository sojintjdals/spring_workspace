package hans.testBoard;

import java.util.List;

public interface TestBoardService {
	List<TestBoardVO> testBoardList() throws Exception; 
	TestBoardVO testBoardView(TestBoardVO vo) throws Exception;
	int testBoardInsert(TestBoardVO vo) throws Exception;
	int testBoardUpdate(TestBoardVO vo) throws Exception;
	int testBoardDelete(TestBoardVO vo) throws Exception;
}
