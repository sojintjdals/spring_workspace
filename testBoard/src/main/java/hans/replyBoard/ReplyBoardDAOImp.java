package hans.replyBoard;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import hans.replyBoard.ReplyBoardDAO;

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
		return update("replyUpdate", vo);
	}

	@Override
	public int replyDelete(ReplyBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return delete("replyDelete", vo);
	}

}
