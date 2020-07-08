package hans.memberBoard;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hans.testBoard.TestBoardVO;

@Controller
@RequestMapping("/test/*")
public class MemberBoardController {

	@Autowired
	MemberBoardServiceImpl service;

//로그인
	@RequestMapping(value = "Login.do", method = RequestMethod.GET)
	public String LoginGet() {
		return "test/login";
	}

//로그인	
	@RequestMapping(value = "Login.do", method = RequestMethod.POST)
	public ModelAndView LoginPost(@ModelAttribute MemberBoardVO vo, HttpSession session) {
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
			mav.addObject("msg", "success");
			msg = "success";
		} else {
			mav.setViewName("redirect:list.do");
			mav.addObject("msg", "failure");
			msg = "failure";
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

//회원탈퇴(아직)
	@RequestMapping("mDelete.do")
	public String delete(Model model, MemberBoardVO vo) {
		try {
			model.addAttribute("memberDelete", service.memberBoardDelete(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "test/mDelete";
	}
//회원정보
	@RequestMapping("mView.do")
	public String mView(Model model, MemberBoardVO vo) {
/*		try {
			model.addAttribute("result", service.memberBoardView(vo, null));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return "test/mView";
	}
//회원수정
	@RequestMapping("mModify.do")
	public String insertGetUpdate(Model model, MemberBoardVO vo) {
		try {
			model.addAttribute("resultUpdate", service.memberBoardView(vo));
			System.out.println("멤버 수정 들어가기 성공!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("멤버 수정 들어가기 실패");
		}
		return "test/mModify";
	}

	@RequestMapping(value = "mModify.do", method = RequestMethod.POST)
	public String insertPostUpdate(RedirectAttributes rttr, MemberBoardVO vo) {
		int result = 0;
		try {
			result = service.memberBoardUpdate(vo);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result == 1)
			rttr.addFlashAttribute("message", "데이터 저장이 성공하였습니다.");
		else rttr.addFlashAttribute("message", "데이터 저장이 실패하였습니다.");
		return "redirect:/test/list.do";
	}
}
