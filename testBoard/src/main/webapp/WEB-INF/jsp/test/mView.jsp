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
			$("#frm").attr("action", "/test/mModify.do");
			$("#frm").submit();
		});
	});

	$(document).ready(function() {
		$("#delete").click(function() {

			var answer = false;

			answer = confirm("회원 탈퇴를 하시겠습니까?");

			if (answer == true) {
				alert("삭제가 완료되었습니다.");
				$("#frm").attr("action", "/test/mDelete.do");
				$("#frm").submit();
			}
		});
		$("#back").click(function() {
			window.location.href="<c:url value='/test/listPage.do' />";
		})
	});
</script>
<link rel="stylesheet"
	href="<c:url value='/css/bulma-0.9.0/bulma.min.css' />">
<link href="<c:url value="/testCss/mView.css" />" rel="stylesheet"
	type="text/css">
</head>
<body>
	<form id="frm" class="frm" action='/test/mModify.do'>

		<div class="main">
			<header>
				<h1 id="h">리스트</h1>
			</header>
			<div></div>
			<div></div>

			<div id="frt">
				<div id="lrt">
					<div class="th">이름</div>

					<div class="td">
						<input type="text" class="input" name="title" id="title"
							value="${resultView.name}" readonly="readonly">
					</div>

					<div class="th">아이디</div>

					<div class="td">
						<input type="text" class="input" name="id" id="id"
							value="${resultView.id}" readonly="readonly"> 
					</div>

					<div class="th">전화번호</div>

					<div class="td">
						<input type="text" class="input" name="phone" id="phone"
							value="${resultView.phone}" readonly="readonly">
					</div>

					<div class="th">이메일</div>

					<div class="td">
						<input type="text" class="input" name="email" id="email"
							value="${resultView.email}" readonly="readonly">
					</div>

					<div id="bt" class="td">
						<input type="button" class="button is-primary is-light" value="수정"
							id="modify"> <input type="button" value="홈" id="back"
							class="button is-primary is-light"><input type="button"
							class="button is-primary is-light" value="회원탈퇴" id="delete">
					</div>
				</div>
			</div>
			<div></div>
			<div></div>
			<footer></footer>
		</div>
	</form>
</body>
</html>