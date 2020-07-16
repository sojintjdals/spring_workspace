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
	});

	$(document).ready(function() {
		$("#delete").click(function() {

			var answer = false;

			answer = confirm("글을 삭제하시겠습니까?");

			if (answer == true) {
				alert("삭제가 완료되었습니다.");
				$("#frm").attr("action", "/test/delete.do");
				$("#frm").submit();
			}
		});
		$("#back").click(function() {
			$(location).attr('href','/test/list.do');
		})
	});
</script>
<link rel="stylesheet"
	href="<c:url value='/css/bulma-0.9.0/bulma.min.css' />">
<link href="<c:url value="/testCss/view.css" />" rel="stylesheet"
	type="text/css">
</head>
<body>
	<form id="frm" action='/test/modify.do'>
		<div class="main">
			<header>
				<h1 id="h">게시물</h1>
			</header>
			<div></div>
			<div></div>
			<div id="frt">
				<div id="frt">
					<div id="td">
						<input type="hidden" name="seqno" id="seqno"
							value="${result.seqno}">
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
						<textarea class="textarea is-large" rows="10" cols="50" name="contents" id="contents"
							readonly="readonly">${result.contents}</textarea>
					</div>
					<div class="bt" id="td">
						<c:if test="${not empty userId}">
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
			<footer></footer>
		</div>

	</form>
</body>
</html>