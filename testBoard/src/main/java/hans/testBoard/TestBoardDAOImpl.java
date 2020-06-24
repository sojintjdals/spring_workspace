package hans.testBoard;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository
public class TestBoardDAOImpl extends EgovAbstractMapper implements TestBoardDAO {

	@Override
	public List<TestBoardVO> testBoardList() throws Exception {
		// TODO Auto-generated method stub
		return selectList("testBoardList");
	}

	@Override
	public TestBoardVO testBoardView(TestBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return selectOne("testBoardView",vo);
	}

	@Override
	public int testBoardInsert(TestBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return insert("testBoardInsert", vo);
	}

	@Override
	public int testBoardUpdate(TestBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return update("testBoardUpdate", vo);
	}

	@Override
	public int testBoardDelete(TestBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return delete("testBoardDelete", vo);
	}
	
	
	
	

}
