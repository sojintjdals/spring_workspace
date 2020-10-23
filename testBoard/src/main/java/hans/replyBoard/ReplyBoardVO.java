package hans.replyBoard;

public class ReplyBoardVO {
	private int seqno;
	private String regdate;

	// 댓글
	// 댓글번호
	private int rno;
	private int sub_rno;

	public int getSub_rno() {
		return sub_rno;
	}

	public void setSub_rno(int sub_rno) {
		this.sub_rno = sub_rno;
	}

	// seqno는 위에 이미만들어졌음
	private String replytext;
	private String userId;

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

	public String getReplytext() {
		return replytext;
	}

	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ReplyBoardVO [seqno=" + seqno + ", regdate=" + regdate + ", rno=" + rno + ", replytext=" + replytext
				+ ", userId=" + userId + "]";
	}

}
