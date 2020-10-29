package hans.replyBoard;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hans.memberBoard.MemberBoardController;
import hans.testBoard.Criteria;
import hans.testBoard.PageMaker;

@RestController
@RequestMapping("/rest/*")
public class ReplyBoardController {
	private static final Logger logger = LoggerFactory.getLogger(MemberBoardController.class);

	@Inject
	private ReplyBoardService service;

	// 댓글관련

	@RequestMapping(value = "/replyInsert.do")
	public ResponseEntity<String> replyInsert(@RequestBody ReplyBoardVO vo) throws Exception {
		
		int seqno = vo.getSeqno();
		int rno = vo.getRno();
		String replytext = vo.getReplytext();
		
		ResponseEntity<String> entity = null;

		System.out.println(seqno);
		System.out.println(rno);
		System.out.println(replytext);
		try {
			System.out.println("댓글입력성공");
			service.replyInsert(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("댓글입력실패");
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/replyDelete.do")
	public ResponseEntity<String> replyDelete(@RequestBody ReplyBoardVO vo) throws Exception {

		int rno = vo.getRno();
		
		ResponseEntity<String> entity = null;
		
		System.out.println(rno);
		
		try {
			System.out.println("댓글삭제성공");
			service.replyDelete(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("삭제실패");
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/replyAnswerDelete.do")
	public ResponseEntity<String> replyAnswerDelete(@RequestBody ReplyBoardVO vo) throws Exception {

		int rno = vo.getSub_rno();
		
		ResponseEntity<String> entity = null;
		
		System.out.println(rno);
		
		try {
			System.out.println("답글글삭제성공");
			service.replyAnswerDelete(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("삭제실패");
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/replyUpdate.do")
	public ResponseEntity<String> replyUpdate(@RequestBody ReplyBoardVO vo) throws Exception {

		int rno = vo.getRno();
		String replytext = vo.getReplytext();
		
		ResponseEntity<String> entity = null;
		
		System.out.println(rno);
		System.out.println(replytext);
		
		try {
			System.out.println("댓글수정성공");
			service.replyUpdate(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("삭제실패");
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/replyAnswerUpdate.do")
	public ResponseEntity<String> replyAnswerUpdate(@RequestBody ReplyBoardVO vo) throws Exception {

		int rno = vo.getSub_rno();
		String replytext = vo.getReplytext();
		
		ResponseEntity<String> entity = null;
		
		System.out.println(rno);
		System.out.println(replytext);
		
		try {
			System.out.println("답글글수정성공");
			service.replyAnswerUpdate(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("삭제실패");
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/all/{seqno}.do")
	public ResponseEntity<List<ReplyBoardVO>> replyList(@PathVariable int seqno) throws Exception {

		ResponseEntity<List<ReplyBoardVO>> entity = null;

		try {		
			
		/*	
		 * 댓글 페이징 중지
		 * model.addAttribute("replyList", service.replyListCriteria(cri));
			System.out.println("======================> 성공1");
			PageMaker pageMaker = new PageMaker();
			System.out.println("======================> 성공2");
			pageMaker.setCri(cri);
			System.out.println("======================> 성공3");
			pageMaker.setTotalCount(service.replyListCountCriteria(cri));
			System.out.println("======================> 성공4");
			model.addAttribute("pageMaker", pageMaker);
			System.out.println("======================> 성공5");
			entity = new ResponseEntity<List<ReplyBoardVO>>(service.replyListCriteria(cri), HttpStatus.OK);*/
			entity = new ResponseEntity<List<ReplyBoardVO>>(service.replyList(seqno), HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<List<ReplyBoardVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@RequestMapping(value = "/answer/{seqno}.do")
	public ResponseEntity<List<ReplyBoardVO>> replyAnswerList(@PathVariable int seqno) throws Exception {

		ResponseEntity<List<ReplyBoardVO>> entity = null;

		try {		
			entity = new ResponseEntity<List<ReplyBoardVO>>(service.replyAnswerList(seqno), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<List<ReplyBoardVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	//답글
	@RequestMapping(value = "/replyAnswerInsert.do")
	public ResponseEntity<String> replyAnswerInsert(@RequestBody ReplyBoardVO vo) throws Exception {
		
		int rno = vo.getRno();
		String replytext = vo.getReplytext();
		
		ResponseEntity<String> entity = null;

		System.out.println(rno);
		vo.setRno(rno);
		System.out.println(replytext);
		try {
			System.out.println("답글입력성공");
			service.replyAnswerInsert(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("댓글입력실패");
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
