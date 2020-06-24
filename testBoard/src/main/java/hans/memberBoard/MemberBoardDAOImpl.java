package hans.memberBoard;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository
public class MemberBoardDAOImpl extends EgovAbstractMapper implements MemberBoardDAO {

	@Override
	public MemberBoardVO memberBoardView(MemberBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return selectOne("memberBoardView", vo);
	}

	@Override
	public int memberBoardInsert(MemberBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return insert("memberBoardInsert", vo);
	}

	@Override
	public int memberBoardDelete(MemberBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return delete("memberBoardDelete", vo);
	}
}
