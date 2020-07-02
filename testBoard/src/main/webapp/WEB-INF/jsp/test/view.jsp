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
			$("#frm").attr("action", "/test/delete.do");
			$("#frm").submit();
		});
		$("#back").click(function() {
			$("#frm").attr("action", "/test/list.do");
			$("#frm").submit();
		})
	});
</script>
<link rel="stylesheet"
	href="<c:url value='/css/bulma-0.9.0/bulma.min.css' />">
<link href="<c:url value="/testCss/view.css" />" rel="stylesheet"
	type="text/css">
</head>
<body>
	<h1 id="h">리스트</h1>
	<div id="border">
		<form id="frm" action='/test/modify.do'>
			<div id="frt">
				<table id="frt">
					<tr>
						<td><input type="hidden" name="seqno" id="seqno"
							value="${result.seqno}"></td>
					</tr>
					<tr>
						<th>제목</th>
					</tr>
					<tr>
						<td><input type="text" class="input" name="title" id="title"
							value="${result.title}" readonly></td>
					</tr>
					<tr>
						<th>내용</th>
					</tr>
					<tr>
						<td><textarea class="textarea is-large color1 size1 width1"
								name="contents" id="contents" readonly="readonly">${result.contents}</textarea></td>
					</tr>
					<tr>
						<td id="bt"><input type="button"
							class="button is-primary is-light" value="수정" id="modify">
							<input type="button" value="삭제" id="delete"
							class="button is-primary is-light"> <input type="button"
							value="홈" id="back" class="button is-primary is-light"></td>
					</tr>
				</table>

			</div>
		</form>
	</div>
</body>
</html>