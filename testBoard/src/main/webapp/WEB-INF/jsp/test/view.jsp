<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous">
	
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#modify").click(function() {
			$("#frm").attr("action", "/test/modify.do");
			$("#frm").submit();
		});
		$("#loginmember").click(function() {
			$("#frm").attr("action", "/test/Login.do");
			$("#frm").submit();
		});
		$("#logout").click(function() {
			$("#frm").attr("action", "/test/logout.do");
			$("#frm").submit();
		});
	});
	$(document)
			.ready(
					function() {
						$("#delete").click(function() {

							var answer = false;

							answer = confirm("글을 삭제하시겠습니까?");

							if (answer == true) {
								alert("삭제가 완료되었습니다.");
								$("#frm").attr("action", "/test/delete.do");
								$("#frm").submit();
							}
						});
						/* 	$("#back").click(function() {
								$(location).attr('href','/test/list.do');
							}) */
						$("#back").click(function() {
							window.location.href = "<c:url value='/test/listPage.do' />";
						})
						$("#commentsBtn")
								.on(
										"click",
										function(event) {
											var that = $(this);
											$
													.ajax({
														url : '/test/comments.do',
														data : formData,
														dataType : 'text',
														processData : false,
														contentType : false,
														type : 'POST',
														success : function(data) {
															var str = "";
															console.log(data);
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
						/* <!--네이버 스마트에디터 --> */
						var editor_object = [];

						nhn.husky.EZCreator
								.createInIFrame({
									oAppRef : editor_object,
									elPlaceHolder : "comments",
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

					});
</script>
<!-- 네이버스마트에디터 -->
<script type="text/javascript"
	src="/resources/smartEditor/js/HuskyEZCreator.js" charset="utf-8"></script>
<link rel="stylesheet"
	href="<c:url value='/css/bulma-0.9.0/bulma.min.css' />">
<link href="<c:url value="/testCss/view.css" />" rel="stylesheet"
	type="text/css">
</head>
<body>
	<form id="frm" action='/test/modify.do'>
		<input type="hidden" name="seqno" value="${result.seqno}">
		<div class="main">
			<c:import url="header.jsp"></c:import>
			<div></div>
			<div></div>
			<div id="frt">
				<div id="frt">
					<div id="td">
						<input type="hidden" name="seqno" id="seqno"
							value="${result.seqno}"> <input type="hidden"
							name="userName" id="userName" value="${result.userName}">
						<input type="hidden" name="userId" id="userId"
							value="${result.userId}"> <input type="hidden" name="cnt"
							id="cnt" value="${result.cnt}">
					</div>
					<div id="td">
						<input type="hidden" name="userId" id="userId"
							value="${userName}(${userId})">
					</div>
					<div id="th">제목</div>
					<div id="td">
						<input type="text" class="input" name="title" id="title"
							value="${result.title}" readonly>
					</div>
					<div id="th">내용</div>
					<div id="td">
						<div style="height: 100%;" class="textarea is-large" id="contents"
							name="contents">${result.contents}</div>

						<c:forEach items="${list}" var="result2">
							<div class="td" data-id="${result2.seqno}"></div>
							<div class="td" id="title" data-id="${result2.seqno}">
								<img src="/test/displayFile.do?fileName=${result2.fullName}" />
								<a>${result2.fullName}</a>
							</div>
						</c:forEach>

					</div>
					<div class="bt" id="td">
						<%-- <c:if test="${not empty userId}">
							<div>
								<!-- <div class="textarea is-large" id="comments"
							name="comments"></div> -->
								<textarea class="textarea is-large" rows="1" cols="20"
									name="comments" id="comments" placeholder="댓글을 작성해보세요"></textarea>
							</div>
							<input type="button" id="commentsBtn" name="commentsBtn"
								class="button is-primary is-light" value="댓글작성">
						</c:if> --%>
						<c:if test="${result.userId eq userId}">
							<input type="button" class="button is-primary is-light"
								value="수정" id="modify">
							<input type="button" value="삭제" id="delete"
								class="button is-primary is-light">
						</c:if>
						<input type="button" value="홈" id="back"
							class="button is-primary is-light">
					</div>
				</div>
			</div>
			<c:import url="footer.jsp"></c:import>
		</div>

	</form>
</body>
</html>