package hans.memberBoard;

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
	MemberBoardService service;
	
	@RequestMapping(value = "Login.do", method = RequestMethod.GET)
	public String LoginGet() {
		return "test/login";
	}
	
	@RequestMapping(value = "Login.do", method = RequestMethod.POST)
	public ModelAndView LoginPost(@ModelAttribute MemberBoardVO vo, HttpServletRequest request) {
		boolean result = false;
		try {
			result = service.loginCheck(vo, request.getSession());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView();
		if(result) {
			mav.setViewName("test/list");
			mav.addObject("msg", "success");
		} else {
			mav.setViewName("test/list");
			mav.addObject("msg", "failure");
		}
		return mav;
	}
	
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session) {
		service.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("test/list");
		mav.addObject("msg","logout");
		return mav;
	}
	
	@RequestMapping(value = "mInsert.do", method = RequestMethod.GET)
	public String mInsertGet() {
		return "test/mInsert";
	}

	@RequestMapping(value = "mInsert.do", method = RequestMethod.POST)
	public String mInsertPost(RedirectAttributes rttr, MemberBoardVO vo) {
		int result = 0;
		try {
			result = service.memberBoardInsert(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("==========> " + result);
		rttr.addFlashAttribute("message", "데이터 저장이 성공하였습니다.");
		return "redirect:/test/list.do";
	}
	
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
}
