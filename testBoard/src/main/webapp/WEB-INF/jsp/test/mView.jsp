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
			$("#lrm").attr("action", "/test/mModify.do");
			$("#lrm").submit();
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
			$("#lrm").attr("action", "/test/list.do");
			$("#lrm").submit();
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
		<form id="lrm" class="mList" action='/test/mModify.do'>
			<div id="frt">
				<table id="lrt">
					<tr>
						<th>이름</th>
					</tr>
					<tr>
						<td><input type="text" class="input" name="title" id="title"
							value="${userName}" readonly></td>
					</tr>
					<tr>
						<th>아이디</th>
					</tr>
					<tr>
						<td><input type="text" class="input" name="userId"
							id="userId" value="${userId}" readonly="readonly"></td>
					</tr>
					<tr>
						<th>전화번호</th>
					</tr>
					<tr>
						<td><input type="text" class="input" name="userPhone"
							id="userPhone" value="${userPhone}" readonly="readonly"></td>
					</tr>
					<tr>
						<th>이메일</th>
					</tr>
					<tr>
						<td><input type="text" class="input" name="userPhone"
							id="userPhone" value="${userEmail}" readonly="readonly"></td>
					</tr>
					<tr>
						<td id="bt"><input type="button"
							class="button is-primary is-light" value="수정" id="modify">
							<input type="button" value="홈" id="back"
							class="button is-primary is-light"></td>
					</tr>
				</table>

			</div>
		</form>
	</div>
</body>
</html>