package hans.testBoard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestBoardServiceImpl implements TestBoardService {
	
	@Autowired
	TestBoardDAO dao;
	
	@Override
	public List<TestBoardVO> testBoardList() throws Exception {
		// TODO Auto-generated method stub
		return dao.testBoardList();
	}

	@Override
	public TestBoardVO testBoardView(TestBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.testBoardView(vo);
	}

	@Override
	public int testBoardInsert(TestBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.testBoardInsert(vo);
	}

	@Override
	public int testBoardUpdate(TestBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.testBoardUpdate(vo);
	}

	@Override
	public int testBoardDelete(TestBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.testBoardDelete(vo);
	}
}
