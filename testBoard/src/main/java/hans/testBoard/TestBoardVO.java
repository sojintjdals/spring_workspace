package hans.testBoard;

public class TestBoardVO {
//	CREATE TABLE `test_metami` (
//			  `seqno` int(11) NOT NULL AUTO_INCREMENT,
//			  `title` varchar(100) NOT NULL,
//			  `contents` varchar(1000) DEFAULT NULL,
//			  `regdate` datetime DEFAULT NULL,
//			  PRIMARY KEY (`seqno`)
//			) ENGINE=MyISAM DEFAULT CHARSET=utf8
	private int seqno;
	private String title;
	private String contents;
	private String regdate;

	public int getSeqno() {
		return seqno;
	}

	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "TestBoardVO [seqno=" + seqno + ", title=" + title + ", contents=" + contents + ", regdate=" + regdate
				+ ", getSeqno()=" + getSeqno() + ", getTitle()=" + getTitle() + ", getContents()=" + getContents()
				+ ", getRegdate()=" + getRegdate() + "]";
	}

}
