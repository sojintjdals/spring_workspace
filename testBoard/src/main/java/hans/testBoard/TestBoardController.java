package hans.testBoard;

import java.awt.image.BufferedImage;
import java.beans.MethodDescriptor;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.validator.Msg;
import org.apache.log4j.Logger;
import org.imgscalr.Scalr;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/test/*")
public class TestBoardController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestBoardController.class);

	@Autowired
	TestBoardService service;

	@Resource(name = "uploadPath")
	private String uploadPath;

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

	/*
	 * @RequestMapping(value = "/listPage.do", method = RequestMethod.GET) public
	 * String listPage(@ModelAttribute("cri") Criteria cri, Model model) throws
	 * Exception {
	 * 
	 * System.out.println(cri.toString());
	 * 
	 * model.addAttribute("list", service.listCriteria(cri)); PageMaker pageMaker =
	 * new PageMaker(); pageMaker.setCri(cri);
	 * pageMaker.setTotalCount(service.listCountCriteria(cri));
	 * model.addAttribute("pageMaker", pageMaker); return "test/list"; }
	 */
	// 리스트 관련
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
	public String view(Model model, TestBoardVO vo, int seqno) {
		try {
			List<TestBoardVO> resultList = service.getAttach(vo);
			TestBoardVO result = service.testBoardView(vo);

			System.out.println("View File :" + resultList);
			System.out.println("View Files :" + result.getFullName());

			model.addAttribute("result", result);
			model.addAttribute("list", resultList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "test/view";
	}
	/*
	 * @RequestMapping("view.do")
	 * 
	 * @ResponseBody public List<TestBoardVO> getAttach(@PathVariable("seqno")int
	 * seqno)throws Exception{ return service.getAttach(seqno); }
	 */

	@RequestMapping("smartEditer.do")
	public String smartEditer() {
		return "test/smartEditer";
	}

	@RequestMapping(value = "insert.do", method = RequestMethod.GET)
	public String insertGet() {
		return "test/insert";
	}

	@RequestMapping(value = "insert.do", method = RequestMethod.POST)
	public String insertPost(RedirectAttributes rttr, TestBoardVO vo) {
		int result = 0;
		try {
			result = service.InsertFile(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("==========> result:" + result);
		rttr.addFlashAttribute("message", "데이터 저장이 성공하였습니다.");
		return "redirect:/test/listPage.do";
	}

	@RequestMapping("modify.do")
	public String insertGetUpdate(Model model, TestBoardVO vo) {
		try {
			model.addAttribute("resultUpdate", service.testBoardView(vo));
			model.addAttribute("list", service.getAttach(vo));
			System.out.println("들어가기 성공!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "test/modify";
	}

	@RequestMapping(value = "modify.do", method = RequestMethod.POST)
	public String insertPostUpdate(RedirectAttributes rttr, TestBoardVO vo) {
		try {
			rttr.addFlashAttribute("message", "데이터 저장이 성공하였습니다.");
			service.testBoardUpdate(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rttr.addFlashAttribute("message", "데이터 저장이 실패하였습니다.");
		}
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

	// 파일업로드관련
	// static으로 할시 생성자로 일일이 지정할필요없이 바로가져와서 쓸수있다
	@RequestMapping(value = "uploadForm.do", method = RequestMethod.GET)
	public String uploadGet(MultipartFile file, Model model) throws Exception {

		return "test/uploadForm";
	}

	@RequestMapping(value = "uploadForm.do", method = RequestMethod.POST)
	public String uploadPost(MultipartFile file, Model model) throws Exception {

		logger.info("originalName: " + file.getOriginalFilename());
		logger.info("size: " + file.getSize());
		logger.info("contentType: " + file.getContentType());

		String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());

		model.addAttribute("savedName", savedName);

		return "test/uploadResult";
	}

	@RequestMapping(value = "uploadAjax.do", method = RequestMethod.GET)
	public String uploadAjaxGet() {
		return "test/uploadAjax";
	}

	@ResponseBody
	@RequestMapping(value = "uploadAjax.do", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjaxPost(MultipartFile file) throws Exception {
		logger.info("===========================> uploadAjax Post Start!!!!");
		logger.info("originalName: " + file.getOriginalFilename());
		logger.info("size: " + file.getSize());
		logger.info("contentType: " + file.getContentType());
		logger.info("contentType: ");
		logger.info("result = " + uploadFile2(uploadPath, file.getOriginalFilename(), file.getBytes()));
		// result에 updateFile2의
		String result = uploadFile2(uploadPath, file.getOriginalFilename(), file.getBytes());
		return new ResponseEntity<String>(result, HttpStatus.CREATED);
	}

	// uploadpost에 쓰임
	private String uploadFile(String originalName, byte[] fileData) throws Exception {
		// 고유식별번호를 만듬
		UUID uid = UUID.randomUUID();
		// 기존 파일이름앞에 고유식별번호를 붙임
		String savedName = uid.toString() + "_" + originalName;

		File target = new File(uploadPath, savedName);

		FileCopyUtils.copy(fileData, target);

		return savedName;
	}

	// uploadAjax에 쓰임
	private String uploadFile2(String uploadPath, String originalName, byte[] fileData) throws Exception {
		// 고유식별번호를 만듬
		UUID uid = UUID.randomUUID();
		// 기존 파일이름앞에 고유식별번호를 붙임
		String savedName = uid.toString() + "_" + originalName;
		// 완성된 파일이름을 찍음
		logger.info("savedName: " + savedName);

		String savedPath = calcPath(uploadPath);
		logger.info("savedPath: " + savedPath);
		File target = new File(uploadPath + savedPath, savedName);

		FileCopyUtils.copy(fileData, target);
		/* logger.info(msg); */
		String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);
		logger.info("if전 formatName: " + formatName);
		String uploadedFileName = null;
		logger.info("getMemdiaType uploadFile2 에서 " + MediaUtils.getMediaType(formatName));
		if (MediaUtils.getMediaType(formatName) != null) {
			logger.info("if: " + MediaUtils.getMediaType(formatName));
			logger.info(makeThumbnail(uploadPath, savedPath, savedName));
			uploadedFileName = makeThumbnail(uploadPath, savedPath, savedName);
		} else {
			logger.info("else: " + MediaUtils.getMediaType(formatName));
			uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		}

		return uploadedFileName;
	}

	// calcPath의 yearPath,monthPath,dataPath을 배열형식으로 정리 길이 총 3 [0,1,2]
	private static void makeDir(String uploadPath, String... paths) {
		// 만약 오늘 날짜로 폴더가 있으면 그냥 리턴을 한다.
		if (new File(uploadPath + paths[paths.length - 1]).exists()) {
			return;
		}
		// 없다면 만들기 위해 for문을 돌림 최대 3번
		for (String path : paths) {
			// dirPath에 년,월,일씩 붙임
			File dirPath = new File(uploadPath + path);
			// 존재하지않는다면만듬
			if (!dirPath.exists()) {
				// 폴더를 만드는 구문
				dirPath.mkdir();
			}
		}
	}

	// fileUpload경로에 현재 년도 + 월 + 일 폴더를 만들고 그곳에 넣은 파일들을 집어넣음
	private static String calcPath(String uploadPath) {
		// 현재시간
		Calendar cal = Calendar.getInstance();
		System.out.println("calcPath 캘린더 cal : " + cal);
		// 현재년도 ex) /2020
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		// 현재 달 ex) /2020/09 여기서 월이 8로나와서 + 1을 해야함
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		// 현재 일 ex) /2020/09/14
		String dataPath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));

		makeDir(uploadPath, yearPath, monthPath, dataPath);

		logger.info(dataPath);

		return dataPath;
	}

	private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception {

		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));
		// 이미지 크기조정 이미지 품질조정
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
		// 썸네일이름정하기 원래 파일앞에 s_가 붙음
		String thumbnailName = uploadPath + path + File.separator + "s_" + fileName;
		logger.info("thumbnailName(썸네일이름): " + thumbnailName);
		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		logger.info("thumbnailName(썸네일리턴): "
				+ thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/'));
		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

	private static String makeIcon(String uploadPath, String path, String fileName) throws Exception {

		String iconName = uploadPath + path + File.separator + fileName;

		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

	@ResponseBody
	@RequestMapping("displayFile.do")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {

		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		// 로그에 파일이름 띄움
		logger.info("FILE NAME : " + fileName);

		try {

			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

			MediaType mType = MediaUtils.getMediaType(formatName);

			HttpHeaders headers = new HttpHeaders();

			in = new FileInputStream(uploadPath + fileName);

			if (mType != null) {
				headers.setContentType(mType);
			} else {
				fileName = fileName.substring(fileName.indexOf("_") + 1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition",
						"attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			}

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}

	@ResponseBody
	@RequestMapping("deleteFile.do")
	public ResponseEntity<String> deleteFile(String fileName) {
		// 삭제할 파일이름을 찍는다
		logger.info("delete file: " + fileName);
		// formatName에 .뒤의 파일이름을 찍는다.
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
		// mType에 파일형식을 저장
		MediaType mType = MediaUtils.getMediaType(formatName);

		if (mType != null) {
			// 파일들을 substring으로 잘라낸다
			String front = fileName.substring(0, 12);
			String end = fileName.substring(14);
			// 경로와 잘라낸 파일이름의 앞+뒤를 붙이고
			new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();
		} else {
			// 다른형식의 파일들 pdf나 등등
			new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
		}
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping("deleteAttach.do")
	public ResponseEntity<String> deleteAttach(Model model, TestBoardVO vo) {
		try {
			System.out.println("FileDelete들어감 ===> " + vo.getFullName());
			model.addAttribute("fileDelete", service.selectDeleteAttach(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>("fileDelete", HttpStatus.OK);
	}

	@RequestMapping(value = "/imageSrc.do", method = RequestMethod.GET)
	public void download2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("=========> Back End Start!!");
		Map<String, String[]> map = request.getParameterMap();
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			logger.info(Arrays.toString(map.get(key)));
		}
		String uploadDir = "C:" + File.separator + "FileUpload" + File.separator;
		/*
		 * Date today = new Date(); SimpleDateFormat date = new SimpleDateFormat(
		 * File.separator + "yyyy" + File.separator + "MM" + File.separator + "dd");
		 * String dataFolder = date.format(today);
		 */
//	      String subPath = "smartEditor" + dataFolder + File.separator;
		String subPath = "smartEditor" + File.separator;
		String physical = request.getParameter("physical");
		String mimeType = "image/jpeg";
		logger.info("넘어온 데이터 : " + physical);
		logger.info("완성 경로 : " + uploadDir + subPath + physical);

		viewFile(response, uploadDir, subPath, physical, mimeType);
	}

	public void viewFile(HttpServletResponse response, String where, String serverSubPath, String physicalName,
			String mimeTypeParam) throws Exception {
		String mimeType = mimeTypeParam;
		// String downFileName = where + SEPERATOR + serverSubPath + SEPERATOR +
		// physicalName;
		String downFileName = where + serverSubPath + physicalName;
		logger.info("hello!");
		File file = new File(filePathBlackList(downFileName));

		if (!file.exists()) {
			throw new FileNotFoundException(downFileName);
		}

		if (!file.isFile()) {
			throw new FileNotFoundException(downFileName);
		}

		byte[] b = new byte[8192];

		if (mimeType == null) {
			mimeType = "application/octet-stream;";
		}

		response.setContentType(mimeType.replaceAll("\r", "").replaceAll("\n", ""));
		response.setHeader("Content-Disposition", "filename=image;");

		BufferedInputStream fin = null;
		BufferedOutputStream outs = null;

		try {
			fin = new BufferedInputStream(new FileInputStream(file));
			outs = new BufferedOutputStream(response.getOutputStream());

			int read = 0;

			while ((read = fin.read(b)) != -1) {
				outs.write(b, 0, read);
			}
		} finally {
			close(outs, fin);
		}
	}

	public void close(Closeable... resources) {
		for (Closeable resource : resources) {
			if (resource != null) {
				try {
					resource.close();
				} catch (Exception ignore) {
					logger.debug("Occurred Exception to close resource is ingored!!");
				}
			}
		}
	}

	// 파일경로의 유효성 체크
	public String filePathBlackList(String value) {
		String returnValue = value;
		if (returnValue == null || returnValue.trim().equals("")) {
			return "";
		}
		logger.debug("Hello!");
		returnValue = returnValue.replaceAll("\\.\\./", ""); // ../
		returnValue = returnValue.replaceAll("\\.\\.\\\\", ""); // ..\

		return returnValue;
	}
	/* 파일 관련 유틸 끝 */
	//헤더 푸터
	@RequestMapping("header.do")
	public String Header() {
		try {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "test/header";
	}
	@RequestMapping("footer.do")
	public String Footer() {
		try {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "test/footer";
	}
	//인터셉터
	@RequestMapping(value = "/doA.do", method = RequestMethod.GET)
	public void doA(Locale locale, Model model) {
		System.out.println("doA.............");
	}
	@RequestMapping(value = "/doB.do", method = RequestMethod.GET)
	public void doB(Locale locale, Model model) {
		System.out.println("doB.............");
		model.addAttribute("result", "DOB RESULT");
	}
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception{
		System.out.println("post handle............");
	}
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception{
		
		System.out.println("post handle............");
		return true;
	}
}
