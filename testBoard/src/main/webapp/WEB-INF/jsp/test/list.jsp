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
		$(".td").click(function() {
			$("#seqno").val($(this).data("id"));
			$("#frm").attr("action", "/test/view.do");
			$("#frm").submit();
		});
		$("#writing").click(function() {
			$("#frm").attr("action", "/test/insert.do");
			$("#frm").submit();
		});
		$("#insertMember").click(function() {
			$("#frm").attr("action", "/test/mInsert.do");
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
		$("#memberView").click(function() {
			$("#frm").attr("action", "/test/mView.do");
			$("#frm").submit();
		});
		if ($("#L1").val() == $("#h1").val()) {
			$("#L1").css("background-color", "#175EB8");
			$("#L1").css("color", "#77FFFF");
		}
		var message = '${message}';
		if (message) {
			alert(message);
		}
	});
</script>
<link href="<c:url value="/testCss/reset.css" />" rel="stylesheet"
	type="text/css">
<link href="<c:url value="/testCss/list.css" />" rel="stylesheet"
	type="text/css">
</head>
<body>
	<form id="frm" action=''>
		<div class="main">
			<header>
				<div></div>
				<div></div>
				<span id="h1">게시판1</span>
				<div>
					<c:if test="${not empty userId}">
						<div class="login">
							<span id="welcome">${userName}(${userId})</span> <input
								type="button" name="logout" class="button is-primary is-light"
								id="logout" value="로그아웃"> <input type="hidden" name="id"
								id="id" value="${userId}"> <input type="button"
								name="memberView" class="button is-primary is-light"
								id="memberView" value="회원정보">
						</div>
					</c:if>
					<c:if test="${empty userId}">
						<div class="login">
							<button class="button is-primary is-light" name="loginmember"
								id="loginmember">로그인</button>
							<button class="button is-primary is-light" name="insertMember"
								id="insertMember">회원가입</button>
						</div>
					</c:if>
				</div>
			</header>
			<nav>
				<ul>
					<li id="L1">게시판1</li>
				</ul>
				<ul>
					<li id="L2">게시판2</li>
				</ul>
				<ul>
					<li id="L3">게시판3</li>
				</ul>
				<ul>
					<li id="L4">게시판4</li>
				</ul>
				<ul>
					<li id="L5">게시판5</li>
				</ul>
				<ul>
					<li id="L6">게시판6</li>
				</ul>
				<ul>
					<li id="L7">게시판7</li>
				</ul>
			</nav>
			<section>
				<input type="hidden" name="seqno" id="seqno">
				<div class="top_tr">번호</div>
				<div class="top_tr">제목</div>
				<div class="top_tr">등록일</div>
				<!-- status.count는 1,2,3 순서로 숫자찍음 -->
				<c:forEach items="${resultList}" var="result" varStatus="status">
					<div class="td" data-id="${result.seqno}">${status.count}</div>
					<div class="td" id="title" data-id="${result.seqno}">${result.title}</div>
					<div class="td" data-id="${result.seqno}">${result.regdate}</div>
				</c:forEach>

				<c:if test="${not empty userId}">
					<div></div>
					<div></div>
					<input type="button" class="button is-primary is-light" value="글쓰기"
						id="writing">
				</c:if>
			</section>


			<footer>
				<div></div>
				<div></div>
				<div class="metami">위 내용에 대한 저작권 및 법적 책임은 자료제공사 또는 글쓴이에 있으며
					metamiweb의 입장과 다를 수 있습니다.</div>
				<div></div>
				<div></div>
			</footer>
		</div>
	</form>
</body>
</html>