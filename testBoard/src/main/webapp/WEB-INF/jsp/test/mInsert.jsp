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
		$("#writing").click(function() {
			var id = $("#id").val();
			var password = $("#password").val();
			var name = $("#name").val();

			if (id == "") {
				alert("아이디을 입력하세요");
				document.lrm.id.focus();
				return;
			}
			if (password == "") {
				alert("비밀번호를 입력하세요");
				document.lrm.password.focus();
				return;
			}
			if (name == "") {
				alert("이름을 입력하세요");
				document.lrm.name.focus();
				return;
			}
			if (phone1 == "") {
				alert("전화번호를 입력하세요");
				document.lrm.phone1.focus();
				return;
			}
			if (phone2 == "") {
				alert("전화번호를 입력하세요");
				document.lrm.phone2.focus();
				return;
			}
			if (phone3 == "") {
				alert("전화번호를 입력하세요");
				document.lrm.phone3.focus();
				return;
			}
			document.lrm.submit();
		})
		$("#back").click(function() {
			$("#lrm").attr("action", "/test/list.do");
			$("#lrm").submit();
		})
	})
</script>
<link href="<c:url value="/testCss/mInsert.css" />" rel="stylesheet"
	type="text/css">
</head>
<body>
	<form id="lrm" name="lrm" method="post" action='/test/mInsert.do'>
		<div class="main">
			<header>
				<h1 id="h">회원가입</h1>
			</header>
			<div></div>
			<div></div>
			<div id="lrt">

				<div class="th">아이디</div>

				<div class="td">
					<input type="text" class="input" name="id" id="id">
				</div>

				<div class="th">비밀번호</div>

				<div class="td">
					<input type="password" class="input" name="password" id="password">
				</div>

				<div class="th">이름</div>

				<div class="td">
					<input type="text" class="input" name="name" id="name">
				</div>

				<div class="th">전화번호</div>

				<div class="td">
					<input type="text" class="input" name="phone1" id="phone1">
					_ <input type="text" class="input" name="phone2" id="phone2">
					_ <input type="text" class="input" name="phone3" id="phone3">
				</div>
				<div class="th">이메일</div>
				<div class="td">
					<input type="text" class="input" name="email1" id="email1"><span>@</span>
					<input type="text" class="input" name="email2" id="email2"><span>.</span>
					<input type="text" class="input" name="email3" id="email3">
				</div>
				<div class="td" id="bt">
					<input type="button" value="완료" id="writing"
						class="button is-primary is-light"> <input type="button"
						id="back" value="홈" class="button is-primary is-light">
				</div>
			</div>
			<div></div>
			<div></div>
			<footer></footer>
		</div>
	</form>
</body>
</html>