package hans.testBoard;

import java.util.Arrays;

public class TestBoardVO {
	private int seqno;
	private String title;
	private String contents;
	private String regdate;
	private String userName;
	private String userId;
	//조회수 
	private int cnt;

	// 파일업로드때 추가한것들
	private String fullName;
	private int replycnt;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	private String[] files; // 첨부파일의 이름을 보관하는 문자열 배열

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
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
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "TestBoardVO [seqno=" + seqno + ", title=" + title + ", contents=" + contents + ", regdate=" + regdate
				+ ", userName=" + userName + ", userId=" + userId + ", cnt=" + cnt + ", fullName=" + fullName
				+ ", replycnt=" + replycnt + ", files=" + Arrays.toString(files) + "]";
	}

}
