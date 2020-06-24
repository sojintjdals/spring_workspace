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
		$("tr").click(function() {
			$("#seqno").val($(this).data("id"));
			$("#frm").submit();
		});
		$("#writing").click(function() {
			$("#frm").attr("action", "/test/insert.do");
			$("#frm").submit();
		});
		$("#insertMember").click(function() {
			location.href("/test/insertMember.do")
		});
		var message = '${message}';
		if(message){
			alert(message);
		}
	});
		
</script>
</head>
<body>
	<h1>리스트</h1>
	<input type="button" value="로그인">
	<input type="button" value="회원가입" id="insertMember">
	<form id="frm" action='/test/view.do'>
		<input type="hidden" name="seqno" id="seqno">
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>등록일</th>
			</tr>
			<!-- status.count는 1,2,3 순서로 숫자찍음 -->
			<c:forEach items="${resultList}" var="result" varStatus="status">
				<tr data-id="${result.seqno}">
					<td>${status.count}</td>
					<td>${result.title}</td>
					<td>${result.regdate}</td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="button" value="글쓰기" id="writing"></td>
			</tr>
		</table>
	</form>
</body>
</html>