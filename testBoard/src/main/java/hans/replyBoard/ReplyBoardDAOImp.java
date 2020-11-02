package hans.replyBoard;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import hans.replyBoard.ReplyBoardDAO;
import hans.testBoard.Criteria;
import hans.testBoard.TestBoardVO;

@Repository
public class ReplyBoardDAOImp extends EgovAbstractMapper implements ReplyBoardDAO {

	@Override
	public List<ReplyBoardVO> replyList(int seqno) throws Exception {
		// TODO Auto-generated method stub
		return selectList("replyList", seqno);
	}

	@Override
	public int replyInsert(ReplyBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return insert("replyInsert", vo);
	}

	@Override
	public int replyUpdate(ReplyBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("===========================> DAO" + vo.getReplytext());
		return update("replyUpdate", vo);
	}

	@Override
	public int replyDelete(ReplyBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return delete("replyDelete", vo);
	}

	@Override
	public List<ReplyBoardVO> replyListCriteria(Criteria cri) {
		// TODO Auto-generated method stub
		return selectList("replyListCriteria", cri);
	}

	@Override
	public int replyListCountCriteria(Criteria cri) {
		// TODO Auto-generated method stub
		return selectOne("replyCountPaging", cri);
	}

	@Override
	public List<ReplyBoardVO> replyListPage(int page) {
		// TODO Auto-generated method stub
		return selectList("listPage", page);
	}
	
	@Override
	public int replyAnswerInsert(ReplyBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		int rno = vo.getRno();
		System.out.println("========================> daoImp" +rno);
		return insert("replyAnswerInsert", vo);
	}

	@Override
	public List<ReplyBoardVO> replyAnswerList(int rno) throws Exception {
		// TODO Auto-generated method stub
		return selectList("replyAnswerList", rno);
	}

	@Override
	public int replyAnswerDelete(ReplyBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return delete("replyAnswerDelete", vo);
	}

	@Override
	public int replyAnswerUpdate(ReplyBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return update("replyAnswerUpdate", vo);
	}

	@Override
	public int replyDeleteAll(ReplyBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return delete("replyDeleteAll", vo);
	}
}
