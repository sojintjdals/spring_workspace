package hans.testBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//인터셉터 로그인 할때 쓰는곳

public class Interceptor extends HandlerInterceptorAdapter{


	private static final Logger logger = LoggerFactory.getLogger(Interceptor.class);

	//전처리기는 클라이언트에서 컨트롤러로 요청할 때 가로채는 것이다. 쉽게 말해 컨트롤러가 호출되기 전에 실행되는 메서드이다.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		Object loginCheck = session.getAttribute("loginCheck");
		
		System.out.println("로그인 체크: " + loginCheck);
		
		if(loginCheck == "loginCheck") {
			logger.info("인터셉터 로그인 필요");
			response.sendRedirect("/test/Login.do");
			response.sendRedirect("/test/header.do");
		}
		
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	//후처리기는 컨트롤러에서 클라이언트로 요청할 때 가로채는 것이다. 쉽게 말해 컨트롤러가 호출되고 난 후에 실행되는 메서드이다.
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub

		return super.preHandle(request, response, handler);
	}
	
	/*@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		session.getAttribute("MemberBoardVO");
		session.getAttribute("userId");
		session.getAttribute("userName");
		session.getAttribute("userEmail");
		
		System.out.println(session.getAttribute("MemberBoardVO"));
		System.out.println(session.getAttribute("userId"));
		System.out.println(session.getAttribute("userName"));
		System.out.println(session.getAttribute("userEmail"));
		Object userVO = modelAndView.getModel().get("MemberBoardVO");
		
		
		logger.info("userVO : " + userVO);
		logger.info("userId : " + userId);
		logger.info("userName : " + userName);
		logger.info("userEmail : " + userEmail);
		logger.info("logout : " + logout);
		
		if(logout == "logout") {
			logger.info("인터셉터 로그아웃");
			session.removeAttribute(LOGIN);
		}else if(userVO != null) {
			logger.info("new login success");
//			session.setAttribute(LOGIN, userVO);
//			session.setAttribute(USERID, userId);
//			session.setAttribute(USERNAME, userName);
//			session.setAttribute(USEREMAIL, userEmail);
			logger.info("인터셉터 로그인");
		}else {
			response.sendRedirect("/test/Login.do");
		}
	}*/
}
