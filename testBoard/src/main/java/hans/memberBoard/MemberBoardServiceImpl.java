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

@Service
public class MemberBoardServiceImpl implements MemberBoardService {

	@Inject
	MemberBoardDAO dao;
	// 로그인 체크
	@Override
	public boolean loginCheck(MemberBoardVO vo, HttpSession session) throws Exception{
		boolean result = false;
		vo.setPassword(EgovFileScrty.encryptPassword(vo.getPassword(), vo.getId()));
		MemberBoardVO userInfo = dao.loginCheck(vo);
		if(userInfo != null) {
			if(userInfo.getId() != null) {
				result = true;
				
				session.setAttribute("userId", userInfo.getId());
				session.setAttribute("userName", userInfo.getName());
			}			
		}
		
		return result;
	}
	// 로그인정보
	@Override
	public MemberBoardVO viewMember(MemberBoardVO vo) {
		return dao.viewMember(vo);
	}
	// 회원 로그아웃
	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}
	@Override
	public int memberBoardInsert(MemberBoardVO vo) throws Exception {
		vo.setPassword(EgovFileScrty.encryptPassword(vo.getPassword(), vo.getId()));
		return dao.memberBoardInsert(vo);
	}

	@Override
	public int memberBoardDelete(MemberBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.memberBoardDelete(vo);
	}
	
}
