package hans.replyBoard;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import hans.replyBoard.ReplyBoardDAO;;

@Service
public class ReplyBoardServiceImp implements ReplyBoardService {

	@Inject
	ReplyBoardDAO dao;

	@Override
	public List<ReplyBoardVO> replyList(int seqno) throws Exception {
		// TODO Auto-generated method stub
		return dao.replyList(seqno);
	}

	@Override
	public int replyInsert(ReplyBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.replyInsert(vo);
	}

	@Override
	public int replyUpdate(ReplyBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.replyUpdate(vo);
	}

	@Override
	public int replyDelete(int rno) throws Exception {
		// TODO Auto-generated method stub
		return dao.replyDelete(rno);
	}

}
