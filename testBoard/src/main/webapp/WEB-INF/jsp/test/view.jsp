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
			$("#frm").attr("action", "/test/modify.do");
			$("#frm").submit();
		});
	});
	$(document).ready(function() {
		$("#delete").click(function() {
			$("#frm").attr("action", "/test/delete.do");
			$("#frm").submit();
		});
	});
</script>

</head>
<body>
	<h1>리스트</h1>
	<form id="frm" action='/test/modify.do'>
		<input type="hidden" name="seqno" id="seqno" value="${result.seqno}">
		<h3>제목 : ${result.title}</h3>
		<p>내용 : ${result.contents}</p>
		<input type="button" value="수정" id="modify">
		<input type="button" value="삭제" id="delete">
	</form>
</body>
</html>