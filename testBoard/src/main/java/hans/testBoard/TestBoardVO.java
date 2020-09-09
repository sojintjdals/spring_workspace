package hans.testBoard;

import java.util.Arrays;

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
	//파일업로드때 추가한것들
	private int viewcnt;
	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public int getReplycnt() {
		return replycnt;
	}

	public void setReplycnt(int replycnt) {
		this.replycnt = replycnt;
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	private int replycnt;
	
	private String[] files; //첨부파일의 이름을 보관하는 문자열 배열

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
				+ ", viewcnt=" + viewcnt + ", replycnt=" + replycnt + ", files=" + Arrays.toString(files) + "]";
	}

}
