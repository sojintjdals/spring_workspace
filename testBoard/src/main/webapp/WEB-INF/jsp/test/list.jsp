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
<link rel="stylesheet"
	href="<c:url value='/css/bulma-0.9.0/bulma.min.css' />">
<script>
	$(document).ready(function() {
		$("tr").click(function() {
			$("#seqno").val($(this).data("id"));
			$("#frm").submit();
		});
		$("#writing").click(function() {
			$("#frm").attr("action", "/test/insert.do");
			$("#frm").submit();
		});
		$("#insertMember").click(function() {
			$("#lfm").attr("action", "/test/mInsert.do");
			$("#lfm").submit();
		});
		$("#loginmember").click(function() {
			$("#lfm").attr("action", "/test/Login.do");
			$("#lfm").submit();
		});
		$("#logout").click(function() {
			$("#lfm").attr("action", "/test/logout.do");
			$("#lfm").submit();
		});
		$("#memberView").click(function() {
			$("#lfm").attr("action", "/test/mView.do");
			$("#lfm").submit();
		});
		var message = '${message}';
		if (message) {
			alert(message);
		}
	});
</script>
<link href="<c:url value="/testCss/reset.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/testCss/list.css" />" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="main">
		<header>
			<h1 id="title">Simple Board</h1>
				<c:if test="${not empty userId}">
					<div id="login">
						<form id="lfm" class="lfm" action='/test/view.do'>
							<span id="welcome">${userName}(${userId})님환영합니다.</span> <input
								type="button" name="logout" class="button is-primary is-light"
								id="logout" value="로그아웃"> <input type="button"
								name="memberView" class="button is-primary is-light"
								id="memberView" value="회원정보">
						</form>
					</div>
				</c:if>
				<c:if test="${empty userId}">
					<form id="lfm" class="login" action='/test/view.do'>
						<button class="button is-primary is-light" name="loginmember"
							id="loginmember">로그인</button>
						<button class="button is-primary is-light" name="insertMember"
							id="insertMember">회원가입</button>
					</form>
				</c:if>
		</header>
		
		<section>
			<form id="frm" action='/test/view.do'>
				<input type="hidden" name="seqno" id="seqno">
				<table id="list" class="table">
					<tr id="top_tr">
						<th id="top_th">번호</th>
						<th id="top_th">제목</th>
						<th id="top_th">등록일</th>
					</tr>
					<!-- status.count는 1,2,3 순서로 숫자찍음 -->
					<c:forEach items="${resultList}" var="result" varStatus="status">
						<tr data-id="${result.seqno}">
							<td>${status.count}</td>
							<td>${result.title}</td>
							<td>${result.regdate}</td>
						</tr>
					</c:forEach>
				</table>
				<c:if test="${not empty userId}">
					<input type="button" class="button is-primary is-light" value="글쓰기"
						id="writing">
				</c:if>
			</form>
		</section>
		
		<footer>
		</footer>
	</div>
</body>
</html>