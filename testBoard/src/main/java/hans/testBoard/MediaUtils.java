package hans.testBoard;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

public class MediaUtils {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestBoardController.class);
	
	private static Map<String, MediaType> mediaMap;
	
	static {
		//형식을 대문자들로 바꾼것들을 이런 형식으로 바꿈
		mediaMap = new HashMap<String, MediaType>();
		mediaMap.put("JPG", MediaType.IMAGE_JPEG);
		mediaMap.put("GIF", MediaType.IMAGE_GIF);
		mediaMap.put("PNG", MediaType.IMAGE_PNG);
	}
	//파일형식을 대문자로바꿈
	public static MediaType getMediaType(String type) {
		logger.info("getMediaType: " + mediaMap.get(type.toUpperCase()));
		return mediaMap.get(type.toUpperCase());
	}
}
