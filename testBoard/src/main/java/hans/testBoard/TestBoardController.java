package hans.testBoard;

import java.awt.image.BufferedImage;
import java.beans.MethodDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.inject.Inject;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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

	// 파일업로드관련
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

	@RequestMapping(value = "uploadAjax.do", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjaxPost(MultipartFile file) throws IOException, Exception {

		logger.info("originalName: " + file.getOriginalFilename());
		logger.info("size: " + file.getSize());
		logger.info("contentType: " + file.getContentType());

		return new ResponseEntity<>(uploadFile2(uploadPath, file.getOriginalFilename(), file.getBytes()),
				HttpStatus.CREATED);
	}

	// uploadpost
	private String uploadFile(String originalName, byte[] fileData) throws Exception {

		UUID uid = UUID.randomUUID();

		String savedName = uid.toString() + "_" + originalName;

		File target = new File(uploadPath, savedName);

		FileCopyUtils.copy(fileData, target);

		return savedName;
	}

	// uploadajax
	private String uploadFile2(String uploadPath, String originalName, byte[] fileData) throws Exception {

		UUID uid = UUID.randomUUID();

		String savedName = uid.toString() + "_" + originalName;

		String savedPath = calcPath(uploadPath);

		File target = new File(uploadPath + savedPath, savedName);

		FileCopyUtils.copy(fileData, target);

		String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);

		String uploadedFileName = null;

		if (MediaUtils.getMediaType(formatName) != null) {
			uploadedFileName = makeThumbnail(uploadedFileName, savedPath, savedName);
		} else {
			uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		}

		return savedName;
	}

	private static void makeDir(String uploadPath, String... paths) {

		if (new File(paths[paths.length - 1]).exists()) {
			return;
		}

		for (String path : paths) {

			File dirPath = new File(uploadPath + path);

			if (!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
	}

	private static String calcPath(String uploadPath) {

		Calendar cal = Calendar.getInstance();

		String yearPath = File.separator + cal.get(Calendar.YEAR);

		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);

		String dataPath = File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));

		makeDir(uploadPath, yearPath, monthPath, dataPath);

		logger.info(dataPath);

		return dataPath;
	}

	private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception {

		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));

		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);

		String thumbnailName = uploadPath + path + File.separator + "s_" + fileName;

		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

	private static String makeIcon(String uploadPath, String path, String fileName) throws Exception {

		String iconName = uploadPath + path + File.separator + fileName;

		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

	@RequestMapping("displayFile.do")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		logger.info("FILE NAME : " + fileName);
		
		try {
			
			String formatName =
		fileName.substring(fileName.lastIndexOf(".")+1);
			
			MediaType mType = MediaUtils.getMediaType(formatName);
	
			HttpHeaders headers = new HttpHeaders();
			
			in = new FileInputStream(uploadPath+fileName);
			
			if(mType != null) {
				headers.setContentType(mType);
			}else {
				fileName = fileName.substring(fileName.indexOf("_")+1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment; filename=\"" +
					new String(fileName));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally {
			in.close();
		}
		return entity;
	}
	

}
