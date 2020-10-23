package hans.testBoard;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Data;

import egovframework.let.cop.bbs.service.Board;

@Service
public class TestBoardServiceImpl implements TestBoardService {

	@Autowired
	TestBoardDAO dao;

	@Override
	public List<TestBoardVO> testBoardList() throws Exception {
		// TODO Auto-generated method stub
		return dao.testBoardList();
	}

	@Override
	public int testBoardInsert(TestBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.testBoardInsert(vo);
	}

	@Override
	public int testBoardUpdate(TestBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		String[] files = vo.getFiles();
		/*
		 * System.out.println("vo.getFiles :" + files);
		 * System.out.println("vo.getFiles :" + files[0].length()); 이거 null뜨면 파일없는 글안들감;
		 */
		System.out.println("==============================================================>" + files);
		if (files != null && files[0].length() > 0) {
			for (String fileName : files) {
				System.out.println("fileName : " + fileName);
				System.out.println("seqno : " + vo.getSeqno());
				vo.setSeqno(vo.getSeqno());
				vo.setFullName(fileName);
				dao.updateAttach(vo);
			}
		}

		return dao.testBoardUpdate(vo);
	}

	@Override
	public int testBoardDelete(TestBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteAttach(vo);

		return dao.testBoardDelete(vo);
	}

	@Override
	public List<TestBoardVO> listCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listCriteria(cri);
	}

	@Override
	public List<TestBoardVO> listPage(int page) throws Exception {
		// TODO Auto-generated method stub
		return dao.listPage(page);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.countPaging(cri);
	}

	@Override
	public TestBoardVO testBoardRead(int seqno) throws Exception {
		// TODO Auto-generated method stub
		return dao.testBoardRead(seqno);
	}

	// 오류가 나도 실제로 들어가지않게하고 롤백시켜주는 명령어
	@Transactional
	@Override
	public int InsertFile(TestBoardVO vo) throws Exception {
		int result = 0;
		String[] files = vo.getFiles();
		/*
		 * System.out.println("vo.getFiles :" + files);
		 * System.out.println("vo.getFiles :" + files[0].length()); 이거 null뜨면 파일없는 글안들감;
		 */
		System.out.println("userName: " + vo.getUserName());
		System.out.println("userId: " + vo.getUserId());
		vo.setUserName(vo.getUserName());
		vo.setUserId(vo.getUserId());
		dao.testBoardInsert(vo);
		System.out.println("==============================================================>" + files);
		if (files != null && files[0].length() > 0) {
			for (String fileName : files) {
				System.out.println("fileName : " + fileName);
				vo.setFullName(fileName);
				result = dao.addAttach(vo);
			}
		}

		return result;
	}

	// 오류가 나도 실제로 들어가지않게하고 롤백시켜주는 명령어
	@Transactional
	@Override
	public TestBoardVO testBoardView(TestBoardVO vo) throws Exception {
		/*
		 * String[] files = vo.getFiles(); System.out.println("vo.getFiles :" + files);
		 * System.out.println("vo.getFiles :" + files[0].length()); System.out.println(
		 * "==============================================================>" + files);
		 * null떠서 리턴을 못함 그래서 주석 처리한거
		 */
		dao.getAttach(vo);
		dao.cntUpdate(vo);
		return dao.testBoardView(vo);
	}

	@Override
	public List<TestBoardVO> getAttach(TestBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("getAttach fullName :" + dao.getAttach(vo));
		return dao.getAttach(vo);
	}

	@Override
	public int deleteAttach(TestBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		vo.setFullName(vo.getFullName());
		return dao.deleteAttach(vo);
	}

	@Override
	public int selectDeleteAttach(TestBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("fullName : " + vo.getFullName());
		vo.setFullName(vo.getFullName());
		return dao.seleteDeleteAttach(vo);
	}

	@Transactional
	@Override
	public int updateAttach(TestBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.updateAttach(vo);
	}
	// 스마트에디터
	
	
	//조회수
	@Override
	public int cntUpdate(TestBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.cntUpdate(vo);
	}
}
