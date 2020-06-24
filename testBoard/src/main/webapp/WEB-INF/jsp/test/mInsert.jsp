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
			var id = $("#id").val();
			var password = $("#password").val();
			var name = $("#name").val();
			
			if(id == ""){
				alert("아이디을 입력하세요");
				document.lrm.id.focus();
				return;
			}
			if(password == ""){
				alert("내용을 입력하세요");
				document.lrm.password.focus();
				return;
			}
			if(name == ""){
				alert("내용을 입력하세요");
				document.lrm.name.focus();
				return;
			}
			document.lrm.submit();
		})
	})
</script>
</head>
<body>
	<h1>리스트</h1>
	<form id="lrm" name="lrm" method="post" action='/test/mInsert.do'>
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
				<th>이름</th>
			</tr>
			<tr>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td><input type="button" value="완료" id="writing">
					<input type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>