package hans.memberBoard;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/test/*")
public class MemberBoardController {
	private static final Logger logger = LoggerFactory.getLogger(MemberBoardController.class);

	@Autowired
	MemberBoardServiceImpl service;

//로그인
	@RequestMapping(value = "Login.do", method = RequestMethod.GET)
	public String LoginGet() {
		return "test/login";
	}

//로그인	
	@RequestMapping(value = "Login.do", method = RequestMethod.POST)
	public ModelAndView LoginPost(@ModelAttribute MemberBoardVO vo, HttpSession session, RedirectAttributes rttr) {
		boolean result = false;
		String msg = null;
		try {
			result = service.loginCheck(vo, session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView();
		if (result) {
			System.out.println(result);
			mav.setViewName("redirect:list.do");
		} else {
			mav.setViewName("redirect:Login.do");
			rttr.addFlashAttribute("msg", "로그인에 실패하였습니다");
			msg = "로그인에 실패하였습니다";
		}
		return mav;
	}

//로그아웃
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session) {
//		service.logout(session);
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:list.do");
		mav.addObject("msg", "failure");
		return mav;
	}

//회원가입
	@RequestMapping(value = "mInsert.do", method = RequestMethod.GET)
	public String mInsertGet() {
		return "test/mInsert";
	}

	@RequestMapping(value = "mInsert.do", method = RequestMethod.POST)
	public String mInsertPost(RedirectAttributes rttr, MemberBoardVO vo) {
		System.out.println("2");
		int result = 0;
		try {
			result = service.memberBoardInsert(vo);
			rttr.addFlashAttribute("message", "회원가입에 성공하였습니다.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rttr.addFlashAttribute("message", "회원가입에 실패하였습니다.");
		}
		System.out.println("==========> " + result);

		return "redirect:list.do";
	}

//회원탈퇴
	@RequestMapping("mDelete.do")
	public String delete(Model model, MemberBoardVO vo, HttpSession session) {
		System.out.println("mDelete");
		try {
			model.addAttribute("resultDelete", service.memberBoardDelete(vo, session));
			session.invalidate();
			System.out.println("삭제성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:list.do";
	}

//아이디 중복체크
	// String 보냄
	@ResponseBody
	@RequestMapping(value = "idCheckAjax.do", method = RequestMethod.POST)
	public String idCheck(MemberBoardVO vo) throws Exception {
		System.out.println("idCheck start!!");
		logger.info("idCheck start!!");
		String result = "N";
		boolean checkResult = service.idCheck(vo);
		if (checkResult) {
			result = "Y";
		}
		logger.info("result :" + result);
		return result;
	}

//회원정보
	@RequestMapping("mView.do")
	public String MemberView(Model model, MemberBoardVO vo) {
		System.out.println("mView시작");
		try {
			System.out.println("mView성공");
			model.addAttribute("resultView", service.MemberView(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("mView실패");
		}
		return "test/mView";
	}

//회원수정
	@RequestMapping("mModify.do")
	public String insertGetUpdate(Model model, MemberBoardVO vo) {
		try {
			model.addAttribute("resultUpdate", service.MemberView(vo));
			System.out.println("멤버 수정 들어가기 성공!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("멤버 수정 들어가기 실패");
		}
		return "test/mModify";
	}

	@RequestMapping(value = "mModify.do", method = RequestMethod.POST)
	public String insertPostUpdate(RedirectAttributes rttr, MemberBoardVO vo, HttpSession session) {
		int result = 0;
		try {
			result = service.memberBoardUpdate(vo, session);
			session.invalidate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == 1)
			rttr.addFlashAttribute("message", "수정에 성공하였습니다. 다시 로그인해 주십시오");
		else
			rttr.addFlashAttribute("message", "수정에 실패하였습니다.");
		return "redirect:/test/list.do";
	}
}
