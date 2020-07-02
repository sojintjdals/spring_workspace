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
	<h1 id="h">리스트</h1>
	<div id="border">
		<form id="frm" name="frm" method="post" action='/test/insert.do'>
			<table id="frt">
				<tr>
					<th class=" color1 size1 width1" id="sentence">제목</th>
				</tr>
				<tr>
					<td><input class="input" type="text" name="title" id="title"></td>
				</tr>
				<tr>
					<th>내용</th>
				</tr>
				<tr>
					<td><textarea class="textarea is-large"
							rows="10" cols="50" name="contents" id="contents"></textarea></td>
				</tr>
				<tr>
					<td id="bt"><input type="button" value="완료" id="writing"
						class="button is-primary is-light"> <input type="button"
						id="back" value="홈" class="button is-primary is-light"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>