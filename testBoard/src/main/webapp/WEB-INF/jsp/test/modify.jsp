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
			document.frm.submit();
		})
		$("#back").click(function() {
			$("#frm").attr("action", "/test/list.do");
			$("#frm").submit();
		})

	})
</script>
<link rel="stylesheet"
	href="<c:url value='/css/bulma-0.9.0/bulma.min.css' />">
<link href="<c:url value="/testCss/insert.css" />" rel="stylesheet"
	type="text/css">
</head>
<body>
	<h1 id="h">수정</h1>
	<div id="border">
		<form id="frm" name="frm" method="post" action='/test/modify.do'>
			<input type="hidden" name="seqno" value="${resultUpdate.seqno}">
			<table id="frt">
				<tr>
					<th>제목</th>
				</tr>
				<tr>
					<td><input type="text" class="input" name="title" id="title"
						value="${resultUpdate.title}" style="width: 100%"></td>
				</tr>
				<tr>
					<th>내용</th>
				</tr>
				<tr>
					<td><textarea class="textarea is-large color1" name="contents"
							id="contents">${resultUpdate.contents}</textarea></td>
				</tr>
				<tr>
					<td><span class="col1">글자색</span> : <select id="selectColor">
							<option value="black">검정</option>
							<option value="blue">파랑</option>
							<option value="green">초록</option>
							<option value="red">빨강</option>
					</select></td>
				</tr>
				<tr>
					<td><input type="button" value="완료" id="writing"
						class="button is-primary is-light"> <input type="button"
						value="홈" id="back" class="button is-primary is-light"></td>
				</tr>
			</table>
		</form>
	</div>
	<script src="/testJs/modify.js"></script>
</body>
</html>