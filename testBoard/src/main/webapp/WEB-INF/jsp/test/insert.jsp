<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/
3.0.1/handlebars.js"></script>
<script>
	$(document)
			.ready(
					function() {

						$("#writing")
								.click(
										function() {
											editor_object.getById["contents"]
													.exec(
															"UPDATE_CONTENTS_FIELD",
															[]);
											var title = $("#title").val();
											var contents = $("#contents").val();

											if (title == "") {
												alert("제목을 입력하세요");
												document.frm.title.focus();
												return;
											}
											if (contents == "") {
												alert("내용을 입력하세요");
												document.frm.contents.focus();
												return;
											}
											alert($("#userName").val());
											alert($("#userId").val());
											$("#frm").attr("action",
													"/test/insert.do");
											document.frm.submit();
										})
						$("#back")
								.click(
										function() {
											window.location.href = "<c:url value='/test/listPage.do' />";
										})
						//파일업로드 부분
						$(".fileDrop").on("dragenter dragover",
								function(event) {
									event.preventDefault();
								})
						$(".fileDrop")
								.on(
										"drop",
										function(event) {
											event.preventDefault();

											var files = event.originalEvent.dataTransfer.files;
											var file = files[0];
											var formData = new FormData();

											formData.append("file", file);
											//에이젝스부분
											$
													.ajax({
														url : '/test/uploadAjax.do',
														data : formData,
														dataType : 'text',
														processData : false,
														contentType : false,
														type : 'POST',
														success : function(data) {
															var str = "";
															console.log(data);
															console
																	.log(checkImageType);
															if (checkImageType(data)) {
																str = "<div>"
																		+ "<img src='/test/displayFile.do?fileName="
																		+ getImageLink(data)
																		+ "'/><small data-src="+data+">X</small></div>";
															} else {
																str = "<div><a href='/test/displayFile.do?fileName="
																		+ data
																		+ "'>"
																		+ getOriginalName(data)
																		+ "</a><small data-src="+data+">X</small></div>";
																alert(data);
															}
															var str2 = "<input type='hidden' name='files' value='" + data +"'> ";
															$(".uploadedList")
																	.append(str);
															$(".uploadedList")
																	.append(
																			str2);
														}
													});
										});
						$(".uploadedList").on("click", "small",
								function(event) {
									var that = $(this);

									$.ajax({
										url : "/test/deleteFile.do",
										type : "post",
										data : {
											fileName : $(this).attr("data-src")
										},
										dataType : "text",
										success : function(result) {
											if (result == 'deleted') {
												that.parent("div").remove();
											}
										}
									});
								});

						function checkImageType(fileName) {

							var pattern = /jpg|gif|png|jpeg/i;

							return fileName.match(pattern);
						}

						//ㅋㅋ ppt에 안나오누
						function getOriginalName(fileName) {

							if (checkImageType(fileName)) {
								return;
							}

							var idx = fileName.indexOf("_") + 1;
							return fileName.substr(idx);

						}

						function getImageLink(fileName) {
							if (!checkImageType(fileName)) {
								return;
							}
							var front = fileName.substr(0, 12);
							var end = fileName.substr(14);

							return front + end;
						}
						/* <!--네이버 스마트에디터 --> */
						var editor_object = [];

						nhn.husky.EZCreator
								.createInIFrame({
									oAppRef : editor_object,
									elPlaceHolder : "contents",
									sSkinURI : "/resources/smartEditor/SmartEditor2Skin.html",
									htParams : {
										// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
										bUseToolbar : true,
										// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
										bUseVerticalResizer : false,
										// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
										bUseModeChanger : false,
									}
								});
					})
</script>
<!-- 네이버스마트에디터 -->
<script type="text/javascript"
	src="/resources/smartEditor/js/HuskyEZCreator.js" charset="utf-8"></script>
<link rel="stylesheet"
	href="<c:url value='/css/bulma-0.9.0/bulma.min.css' />">
<link href="<c:url value="/testCss/insert.css" />" rel="stylesheet"
	type="text/css">
<style type="text/css">
.fileDrop {
	width: 100%;
	margin-top: 10px;
	height: 15%;
	border: 1px solid black;
}
</style>
</head>
<body>
	<form id="frm" name="frm" method="post" action='/test/insert.do'>
		<div class="main">
			<c:import url="header.jsp"></c:import>
			<div></div>
			<div></div>
			<div id="frt">
				<div class="tr">
					<div class="th" id="sentence">제목</div>
				</div>
				<div>
					<div class="td">
						<input class="input" type="text" name="title" id="title">
						<input type="hidden" name="userId" id="userId" value="${userId}">
						<input type="hidden" name="userName" id="userName"
							value="${userName}">
					</div>
				</div>

				<div class="th">내용</div>

				<div class="td">
					<input type="text" id="contents" name="contents">
				</div>
				<div class="td bt">
					<input type="button" value="완료" id="writing"
						class="button is-primary is-light"> <input type="button"
						id="back" value="홈" class="button is-primary is-light">
				</div>
			</div>
			<div></div>
			<div></div>
			<c:import url="footer.jsp"></c:import>
		</div>
	</form>
</body>
</html>