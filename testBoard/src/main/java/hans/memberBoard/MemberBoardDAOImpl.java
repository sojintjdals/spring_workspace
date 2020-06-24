package hans.memberBoard;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository
public class MemberBoardDAOImpl extends EgovAbstractMapper implements MemberBoardDAO {

	@Override
	public int memberBoardInsert(MemberBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return insert("MemberInsert", vo);
	}

	@Override
	public int memberBoardDelete(MemberBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return delete("MemberDelete", vo);
	}
	//로그인 체크
	@Override
	public MemberBoardVO loginCheck(MemberBoardVO vo) {
		return selectOne("MemberBoardVO.loginCheck", vo);
	}
	//로그아웃
	@Override
	public void logout(HttpSession session) {
	}
	//로그인정보
	@Override
	public MemberBoardVO viewMember(MemberBoardVO vo) {
		// TODO Auto-generated method stub
		return selectOne("MemberBoardVO.loginCheck", vo);
	}
}
