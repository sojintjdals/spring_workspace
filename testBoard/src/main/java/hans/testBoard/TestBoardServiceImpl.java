package hans.testBoard;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.let.cop.bbs.service.Board;

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

	@Override
	public List<TestBoardVO> listCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listCriteria(cri);
	}

	@Override
	public List<TestBoardVO> listPage(int page) throws Exception {
		// TODO Auto-generated method stub
		return dao.listPage(page);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.countPaging(cri);
	}

	@Override
	public TestBoardVO testBoardRead(int seqno) throws Exception {
		// TODO Auto-generated method stub
		return dao.testBoardRead(seqno);
	}
	//오류가 나도 실제로 들어가지않게하고 롤백시켜주는 명령어
	@Transactional
	@Override
	public void InsertFile(TestBoardVO vo) throws Exception{
		
		dao.testBoardInsert(vo);
		
		String[] files = vo.getFiles();
		
		if(files == null) {
			return;
		}
		
		for(String fileName : files) {
			dao.addAttach(fileName);
		}
	}
}
