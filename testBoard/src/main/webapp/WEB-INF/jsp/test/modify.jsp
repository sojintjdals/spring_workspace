<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
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
	<h1>수정</h1>
	<form id="frm" name="frm" method="post" action='/test/modify.do'>
		<input type="hidden" name="seqno" value="${resultUpdate.seqno}">
		<table>			
			<tr>
				<th>제목</th>
			</tr>
			<tr>
				<td><input type="text" name="title" id="title" value="${resultUpdate.title}" style="width: 100%"></td>
			</tr>
			<tr>
				<th>내용</th>
			</tr>
			<tr>
				<td><textarea style="width: 100%; height: 100%;" name="contents" id="contents">
				${resultUpdate.contents}
				</textarea>
				</td>
			</tr>
			<tr>
				<td><input type="button" value="완료" id="writing">
					<input type="button" value="취소" id="back"></td>
			</tr>
		</table>
	</form>
</body>
</html>