package hans.replyBoard;

import java.util.List;

import hans.testBoard.Criteria;

public interface ReplyBoardDAO {

	List<ReplyBoardVO> replyList(int seqno) throws Exception;

	int replyInsert(ReplyBoardVO vo) throws Exception;

	int replyUpdate(ReplyBoardVO vo) throws Exception;

	int replyDelete(ReplyBoardVO vo) throws Exception;

	// 댓글페이징부분

	List<ReplyBoardVO> replyListCriteria(Criteria cri);

	int replyListCountCriteria(Criteria cri);

	List<ReplyBoardVO> replyListPage(int page);

	// 답글
	int replyAnswerInsert(ReplyBoardVO vo) throws Exception;
	
	int replyAnswerDelete(ReplyBoardVO vo) throws Exception;
	
	int replyAnswerUpdate(ReplyBoardVO vo) throws Exception;

	List<ReplyBoardVO> replyAnswerList(int rno) throws Exception;
}
