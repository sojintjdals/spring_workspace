package hans.testBoard;

import java.util.List;

public interface TestBoardDAO {
	//listAll
	List<TestBoardVO> testBoardList() throws Exception; 
	//listPage
	List<TestBoardVO> listPage(int page)throws Exception;
	//listCriteria
	List<TestBoardVO> listCriteria(Criteria cri) throws Exception;
	//read
	TestBoardVO testBoardView(TestBoardVO vo) throws Exception;
	TestBoardVO testBoardRead(int seqno) throws Exception;
	//create
	int testBoardInsert(TestBoardVO vo) throws Exception;
	//update
	int testBoardUpdate(TestBoardVO vo) throws Exception;
	//delete
	int testBoardDelete(TestBoardVO vo) throws Exception;
	//count
	int countPaging(Criteria cri)throws Exception;
	List<TestBoardVO> listSearch(Criteria cri) throws Exception;
	int listSearchCount(Criteria cri) throws Exception;
 }
