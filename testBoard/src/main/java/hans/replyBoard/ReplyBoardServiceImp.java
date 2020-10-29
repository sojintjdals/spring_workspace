package hans.replyBoard;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import hans.replyBoard.ReplyBoardDAO;
import hans.testBoard.Criteria;

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
		System.out.println("===========================> SERVICE" + vo.getReplytext());
		return dao.replyUpdate(vo);
	}

	@Override
	public int replyDelete(ReplyBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.replyDelete(vo);
	}
	
	//댓글페이징부분
	
	@Override
	public List<ReplyBoardVO> replyListCriteria(Criteria cri) {
		// TODO Auto-generated method stub
		return dao.replyListCriteria(cri);
	}
	
	@Override
	public List<ReplyBoardVO> listPage(int page) throws Exception {
		// TODO Auto-generated method stub
		return dao.replyListPage(page);
	}
	
	@Override
	public int replyListCountCriteria(Criteria cri) {
		// TODO Auto-generated method stub
		return dao.replyListCountCriteria(cri);
	}

	@Override
	public int replyAnswerInsert(ReplyBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		int rno = vo.getRno();
		System.out.println("========================> serviceImp" +rno);
		return dao.replyAnswerInsert(vo);
	}

	@Override
	public List<ReplyBoardVO> replyAnswerList(int rno) throws Exception {
		// TODO Auto-generated method stub
		return dao.replyAnswerList(rno);
	}

	@Override
	public int replyAnswerDelete(ReplyBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.replyAnswerDelete(vo);
	}

	@Override
	public int replyAnswerUpdate(ReplyBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.replyAnswerUpdate(vo);
	}
}
