package hans.memberBoard;

import javax.inject.Inject;
import javax.jms.Session;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ibm.icu.util.BytesTrie.Result;

import egovframework.let.utl.sim.service.EgovFileScrty;
import hans.testBoard.TestBoardDAO;
import hans.testBoard.TestBoardVO;

@Service
public class MemberBoardServiceImpl implements MemberBoardService {

	@Inject
	MemberBoardDAO dao;

	// 로그인 체크
	@Override
	public boolean loginCheck(MemberBoardVO vo, HttpSession session) throws Exception {
		boolean result = false;
		vo.setPassword(EgovFileScrty.encryptPassword(vo.getPassword(), vo.getId()));
		MemberBoardVO userInfo = dao.loginCheck(vo);
		if (userInfo != null) {
			if (userInfo.getId() != null) {
				result = true;

				session.setAttribute("userId", userInfo.getId());
				session.setAttribute("userName", userInfo.getName());
				session.setAttribute("userPhone", userInfo.getPhone());
				session.setAttribute("userEmail", userInfo.getEmail());
				System.out.println(userInfo.getId());
				System.out.println(userInfo.getName());
				System.out.println(userInfo.getPhone());
				System.out.println(userInfo.getEmail());
			}
		}

		return result;
	}
	
	public boolean idCheck(MemberBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		vo.setPassword(EgovFileScrty.encryptPassword(vo.getPassword(), vo.getId()));
		boolean result = false;
		MemberBoardVO userInfo = dao.idCheck(vo);
		if (userInfo != null) {
			if (userInfo.getId() != null) {
				result = true;

				System.out.println(userInfo.getId());
			}
		}
		return result;
	}

	
	// 회원 로그아웃
	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

	@Override
	public int memberBoardInsert(MemberBoardVO vo) throws Exception {
		vo.setPassword(EgovFileScrty.encryptPassword(vo.getPassword(), vo.getId()));
		System.out.println(vo.getPhone1());
		System.out.println(vo.getPhone2());
		System.out.println(vo.getPhone3());
		return dao.memberBoardInsert(vo);
	}

	@Override
	public int memberBoardDelete(MemberBoardVO vo, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		session.invalidate();
		return dao.memberBoardDelete(vo, session);
	}

	@Override
	public int memberBoardUpdate(MemberBoardVO vo, HttpSession session) throws Exception {
		vo.setPassword(EgovFileScrty.encryptPassword(vo.getPassword(), vo.getId()));
		System.out.println("수정ServiceImpl 들어가짐");
		System.out.println(vo.getPhone());
		System.out.println(vo.getPhone1());
		System.out.println(vo.getPhone2());
		System.out.println(vo.getPhone3());
		System.out.println(vo.getEmail());
		System.out.println(vo.getEmail1());
		System.out.println(vo.getEmail2());
		System.out.println(vo.getEmail3());
		return dao.memberBoardUpdate(vo, session);
	}

	@Override
	public MemberBoardVO MemberView(MemberBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		vo.setPassword(EgovFileScrty.encryptPassword(vo.getPassword(), vo.getId()));
		return dao.MemberView(vo);
	}

}
