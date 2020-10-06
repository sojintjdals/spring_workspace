package hans.replyBoard;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hans.memberBoard.MemberBoardController;

@RestController
@RequestMapping("/rest/*")
public class ReplyBoardController {
	private static final Logger logger = LoggerFactory.getLogger(MemberBoardController.class);
	
	@Inject
	private ReplyBoardService service;
	
	
	//댓글관련
	
	@RequestMapping(value = "/replyInsert.do", method = RequestMethod.POST)
	public ResponseEntity<String> replyInsert(@RequestBody ReplyBoardVO vo) throws Exception {
		
		ResponseEntity<String> entity = null;
		try {
			service.replyInsert(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;	
	}
	
}
