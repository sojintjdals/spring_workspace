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
		return selectOne("testBoardView", vo);
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

	@Override
	public List<TestBoardVO> listPage(int page) throws Exception {
		// TODO Auto-generated method stub
		return selectList("listPage", page);
	}

	@Override
	public List<TestBoardVO> listCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return selectList("listCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return selectOne("countPaging", cri);
	}

	@Override
	public TestBoardVO testBoardRead(int seqno) throws Exception {
		// TODO Auto-generated method stub
		return selectOne("testBoardRead", seqno);
	}

	@Override
	public List<TestBoardVO> listSearch(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Search");
		return selectList("listCriteria", cri);
	}

	@Override
	public int listSearchCount(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return selectOne("listSearchCount", cri);
	}

	@Override
	public int addAttach(String fullName) throws Exception {
		// TODO Auto-generated method stub
		return insert("addAttach", fullName);
	}
	
	public List<TestBoardVO> getAttach(int seqno) throws Exception {
		// TODO Auto-generated method stub
		return selectList("getAttach", seqno);
	}

}
