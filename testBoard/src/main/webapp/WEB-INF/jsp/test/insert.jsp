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
			
			if(title == ""){
				alert("제목을 입력하세요");
				document.frm.title.focus();
				return;
			}
			if(contents == ""){
				alert("내용을 입력하세요");
				document.frm.contents.focus();
				return;
			}
			document.frm.submit();
		})
	})
</script>
</head>
<body>
	<h1>리스트</h1>
	<form id="frm" name="frm" method="post" action='/test/insert.do'>
		<table>
			<tr>
				<th>제목</th>
			</tr>
			<tr>
				<td><input type="text" name="title" id="title"></td>
			</tr>
			<tr>
				<th>내용</th>
			</tr>
			<tr>
				<td><textarea rows="10" cols="50" name="contents" id="contents"></textarea>
				</td>
			</tr>
			<tr>
				<td><input type="button" value="완료" id="writing">
					<input type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>