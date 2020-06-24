package hans.memberBoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import hans.testBoard.TestBoardDAO;

@Service
public class MemberBoardServiceImpl implements MemberBoardService {

	@Autowired
	MemberBoardDAO dao;
	
	@Override
	public MemberBoardVO memberBoardView(MemberBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.memberBoardView(vo);
	}

	@Override
	public int memberBoardInsert(MemberBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.memberBoardInsert(vo);
	}

	@Override
	public int memberBoardDelete(MemberBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.memberBoardDelete(vo);
	}
}
