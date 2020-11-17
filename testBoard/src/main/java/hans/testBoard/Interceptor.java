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

	private static final String LOGIN = "login";
	private static final String USERID = "userId";
	private static final String USERNAME = "userName";
	private static final String USEREMAIL = "userEmail";

	private static final Logger logger = LoggerFactory.getLogger(Interceptor.class);

	//전처리기는 클라이언트에서 컨트롤러로 요청할 때 가로채는 것이다. 쉽게 말해 컨트롤러가 호출되기 전에 실행되는 메서드이다.
	@Override	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler
			, ModelAndView modelAndView) throws Exception {
			
		HttpSession session = request.getSession();
		
		Object userVO = modelAndView.getModel().get("MemberBoardVO");
		Object userId = modelAndView.getModel().get("userId");
		Object userName = modelAndView.getModel().get("userName");
		Object userEmail = modelAndView.getModel().get("userEmail");
		Object logout = modelAndView.getModel().get("logout");
		
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
			session.setAttribute(LOGIN, userVO);
			session.setAttribute(USERID, userId);
			session.setAttribute(USERNAME, userName);
			session.setAttribute(USEREMAIL, userEmail);
/*			response.sendRedirect("/");*/
			logger.info("인터셉터 로그인");
		}
	}
	
	//후처리기는 컨트롤러에서 클라이언트로 요청할 때 가로채는 것이다. 쉽게 말해 컨트롤러가 호출되고 난 후에 실행되는 메서드이다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute(LOGIN) == null) {

		}
		
		return true;
	}
}
