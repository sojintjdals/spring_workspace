package hans.memberBoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test/*")
public class MemberBoardController {

	@Autowired
	MemberBoardService service;
	
	@RequestMapping("mview.do")
	public String view(Model model, MemberBoardVO vo) {
		try {
			model.addAttribute("memberView", service.memberBoardView(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "test/mView";
	}
	
	@RequestMapping("mview.do")
	public String insert(Model model, MemberBoardVO vo) {
		try {
			model.addAttribute("memberInsert", service.memberBoardInsert(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "test/mInsert";
	}
	
	@RequestMapping("mview.do")
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
