package hans.replyBoard;

import java.util.List;

import hans.testBoard.Criteria;

public interface ReplyBoardService {
	List<ReplyBoardVO> replyList(int seqno) throws Exception;

	int replyInsert(ReplyBoardVO vo) throws Exception;

	int replyUpdate(ReplyBoardVO vo) throws Exception;

	int replyDelete(ReplyBoardVO vo) throws Exception;

	List<ReplyBoardVO> replyListCriteria(Criteria cri);

	int replyListCountCriteria(Criteria cri);

	// page
	List<ReplyBoardVO> listPage(int page) throws Exception;

	// 답글
	int replyAnswerInsert(ReplyBoardVO vo) throws Exception;

	List<ReplyBoardVO> replyAnswerList(int rno) throws Exception;

	int replyAnswerDelete(ReplyBoardVO vo) throws Exception;

	int replyAnswerUpdate(ReplyBoardVO vo) throws Exception;

	int replyDeleteAll(ReplyBoardVO vo) throws Exception;
}
