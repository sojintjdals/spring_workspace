package hans.testBoard;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.validator.Msg;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/test/*")
public class TestBoardController {

	@Autowired
	TestBoardService service;

	@RequestMapping("list.do")
	public String list(Model model) {
		try {
			model.addAttribute("resultList", service.testBoardList());
			System.out.println(service.testBoardList());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("hello");
			e.printStackTrace();
		}
		return "test/list";
	}

/*	@RequestMapping(value = "/listPage.do", method = RequestMethod.GET)
	public String listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		
		System.out.println(cri.toString());
		
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		model.addAttribute("pageMaker", pageMaker);
		return "test/list";
	}*/
	@RequestMapping(value = "/listPage.do", method = RequestMethod.GET)
	public String seacrhListPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		
		System.out.println(cri.toString());
		
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		model.addAttribute("pageMaker", pageMaker);
		return "test/list";
	}

	@RequestMapping("view.do")
	public String view(Model model, TestBoardVO vo) {
		try {
			model.addAttribute("result", service.testBoardView(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "test/view";
	}

	@RequestMapping(value = "insert.do", method = RequestMethod.GET)
	public String insertGet() {
		return "test/insert";
	}

	@RequestMapping(value = "insert.do", method = RequestMethod.POST)
	public String insertPost(RedirectAttributes rttr, TestBoardVO vo) {
		int result = 0;
		try {
			result = service.testBoardInsert(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("==========> " + result);
		rttr.addFlashAttribute("message", "데이터 저장이 성공하였습니다.");
		return "redirect:/test/listPage.do";
	}

	@RequestMapping("modify.do")
	public String insertGetUpdate(Model model, TestBoardVO vo) {
		try {
			model.addAttribute("resultUpdate", service.testBoardView(vo));
			System.out.println("들어가기 성공!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "test/modify";
	}

	@RequestMapping(value = "modify.do", method = RequestMethod.POST)
	public String insertPostUpdate(RedirectAttributes rttr, TestBoardVO vo) {
		int result = 0;
		try {
			result = service.testBoardUpdate(vo);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == 1)
			rttr.addFlashAttribute("message", "데이터 저장이 성공하였습니다.");
		else
			rttr.addFlashAttribute("message", "데이터 저장이 실패하였습니다.");
		return "redirect:/test/listPage.do";
	}

	@RequestMapping("delete.do")
	public String Delete(Model model, TestBoardVO vo) {
		try {
			model.addAttribute("resultDelete", service.testBoardDelete(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/test/listPage.do";
	}
	
}
