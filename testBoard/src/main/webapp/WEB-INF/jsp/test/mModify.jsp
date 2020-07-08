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
			var phone1 = $("#phone1").val();
			var phone2 = $("#phone2").val();
			var phone3 = $("#phone2").val();
			var email1 = $("#email1").val();
			var email2 = $("#email2").val();
			var email3 = $("#email3").val();

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
			if (email1 == "") {
				alert("이메일을 입력하세요");
				document.lrm.email1.focus();
				return;
			}
			if (email2 == "") {
				alert("이메일을 입력하세요");
				document.lrm.email2.focus();
				return;
			}
			if (email3 == "") {
				alert("이메일을 입력하세요");
				document.lrm.email3.focus();
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
	<h1 id="h">회원가입</h1>
	<div id="border">
		<form id="lrm" name="lrm" method="post" action='/test/mInsert.do'>
			<table id="lrt">
				<tr>
					<th>아이디</th>
				</tr>
				<tr>
					<td><input type="text" class="input" name="id" id="id" value="${resultUpdate.id}"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
				</tr>
				<tr>
					<td><input type="password" class="input" name="password"
						id="password" value="${resultUpdate.password}"></td>
				</tr>
				<tr>
					<th>이름</th>
				</tr>
				<tr>
					<td><input type="text" class="input" name="name" id="name" value="${resultUpdate.name}"></td>
				</tr>
				<tr>
					<th>전화번호</th>
				</tr>
				<tr>
					<td><input type="text" class="input" name="phone" id="phone" value="${resultUpdate.phone}">
						_ <input type="text" class="input" name="phone2" id="phone2">
						_ <input type="text" class="input" name="phone3" id="phone3"></td>
				</tr>
				<tr>
					<th>이메일</th>
				</tr>
				<tr>
					<td><input type="text" class="input" name="email1" id="email1" value="${resultUpdate.email}">@
						<input type="text" class="input" name="email2" id="email2">.
						<input type="text" class="input" name="email3" id="email3"></td>
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