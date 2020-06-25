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
<link rel="stylesheet" href="<c:url value='/css/bulma-0.9.0/bulma.min.css' />">
<script type="text/javascript">
	$(document).ready(function() {
		$("#writing").click(function() {
			var id = $("#id").val();
			var password = $("#password").val();

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
			document.lrm.submit();
		})
	})
</script>
</head>
<body>
	<h1>로그인</h1>
	<form id="lrm" name="lrm" method="post" action='/test/Login.do'>
		<table>
			<tr>
				<th>아이디</th>
			</tr>
			<tr>
				<td><input type="text" name="id" id="id"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
			</tr>
			<tr>
				<td><input type="password" name="password" id="password"></td>
			</tr>
			<tr>
				<td><input type="button" value="로그인" id="writing" class="button is-primary is-light">
				 <input type="button" class="button is-primary is-light" value="취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>