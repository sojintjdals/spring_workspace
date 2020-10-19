package hans.replyBoard;

import java.util.List;

public interface ReplyBoardService {
	List<ReplyBoardVO> replyList(int seqno) throws Exception;

	int replyInsert(ReplyBoardVO vo) throws Exception;

	int replyUpdate(ReplyBoardVO vo) throws Exception;

	int replyDelete(ReplyBoardVO vo) throws Exception;
}
