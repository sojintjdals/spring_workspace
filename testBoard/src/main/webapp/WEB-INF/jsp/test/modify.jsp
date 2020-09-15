<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>
<script>
	$(document).ready(function() {
		$("#writing").click(function() {
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
			$("#frm").attr("action", "/test/modify.do");
			document.frm.submit();
		})
		$("#back").click(function() {
			window.location.href="<c:url value='/test/listPage.do' />";
		})

	})
</script>
<link rel="stylesheet"
	href="<c:url value='/css/bulma-0.9.0/bulma.min.css' />">
<link href="<c:url value="/testCss/modify.css" />" rel="stylesheet"
	type="text/css">
</head>
<body>
	<form id="frm" name="frm" method="post" action='/test/modify.do'>
		<div class="main">
			<header>
				<h1 id="h">수정</h1>
			</header>
			<div></div>
			<div></div>
			<input type="hidden" name="seqno" value="${resultUpdate.seqno}">
			<div id="frt">
				<div class="th">제목</div>

				<div class="td">
					<input type="text" class="input" name="title" id="title"
						value="${resultUpdate.title}" style="width: 100%">
				</div>

				<div class="th">내용</div>

				<div class="td">
					<textarea class="textarea is-large" rows="10" cols="50" name="contents"
						id="contents">${resultUpdate.contents}</textarea>
				</div>
				<div id="bt">
					<input type="button" value="완료" id="writing"
						class="button is-primary is-light"> <input type="button"
						value="홈" id="back" class="button is-primary is-light">
				</div>

			</div>
			<div></div>
			<div></div>
			<footer></footer>
		</div>
	</form>
</body>
</html>
