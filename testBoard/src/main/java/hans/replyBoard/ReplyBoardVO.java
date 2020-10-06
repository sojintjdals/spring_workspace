package hans.replyBoard;

public class ReplyBoardVO {
	private int seqno;
	private String regdate;

	// 댓글
	private int rno;
	// seqno는 위에 이미만들어졌음
	private String replytext;
	private String replyer;

	public int getSeqno() {
		return seqno;
	}

	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	@Override
	public String toString() {
		return "ReplyBoardVO [seqno=" + seqno + ", regdate=" + regdate + ", rno=" + rno + ", replytext=" + replytext
				+ ", replyer=" + replyer + "]";
	}

	public String getReplytext() {
		return replytext;
	}

	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}

	public String getReplyer() {
		return replyer;
	}

	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
}
