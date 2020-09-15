<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
				document.frm.id.focus();
				return;
			}
			if (password == "") {
				alert("비밀번호를 입력하세요");
				document.frm.password.focus();
				return;
			}
			if (name == "") {
				alert("이름을 입력하세요");
				document.frm.name.focus();
				return;
			}
			if (phone1 == "") {
				alert("전화번호를 입력하세요");
				document.frm.phone1.focus();
				return;
			}
			if (phone2 == "") {
				alert("전화번호를 입력하세요");
				document.frm.phone2.focus();
				return;
			}
			if (phone3 == "") {
				alert("전화번호를 입력하세요");
				document.frm.phone3.focus();
				return;
			}
			if (email1 == "") {
				alert("이메일을 입력하세요");
				document.frm.email1.focus();
				return;
			}
			if (email2 == "") {
				alert("이메일을 입력하세요");
				document.frm.email2.focus();
				return;
			}
			if (email3 == "") {
				alert("이메일을 입력하세요");
				document.frm.email3.focus();
				return;
			}
			document.frm.submit();
		})
		$("#back").click(function() {
			window.location.href="<c:url value='/test/listPage.do' />";
		})
	})
</script>
<link href="<c:url value="/testCss/mModify.css" />" rel="stylesheet"
	type="text/css">
</head>
<body>
	<form id="frm" name="frm" method="post" action='/test/mModify.do'>

		<div class="main">
			<header>
				<h1 id="h">회원수정</h1>
			</header>
			<div></div>
			<div></div>
			<div id="lrt">
				<div class="th">아이디(수정못함)</div>

				<div class="td">
					<input type="text" class="input" name="id" id="id"
						value="${resultUpdate.id}" readonly="readonly">
					<!-- 변경되지않는 아이디 -->
					<input type="hidden" class="input" name="fakeId" id="fakeId"
						value="${resultUpdate.id}">
				</div>

				<div class="th">이름</div>


				<div class="td">
					<input type="text" class="input" name="name" id="name"
						value="${resultUpdate.name}">
				</div>


				<div class="th">전화번호${resultUpdate.phone}</div>
				<c:set var="phoneArr" value="${fn:split(resultUpdate.phone,'-')}" />

				<div class="td">
					<input type="text" class="input" name="phone1" id="phone1" value="${phoneArr[0]}" maxlength="3">
					<span id="span1"> - </span>
					<input type="text" class="input" name="phone2" id="phone2" value="${phoneArr[1]}" maxlength="4"> 
					<span class="1"> - </span>
					<input type="text" class="input" name="phone3" id="phone3" value="${phoneArr[2]}" maxlength="4">
				</div>


				<div class="th">이메일</div>


				<div class="td">
					<input type="text" class="input" name="email1" id="email1" value="${fn:substring(resultUpdate.email, 0, fn:indexOf(resultUpdate.email,'@'))}" maxlength="15"><span
						id="span3">@</span><input type="text" class="input" name="email2"
						id="email2" value="${fn:substring(resultUpdate.email, fn:indexOf(resultUpdate.email,'@')+1, fn:indexOf(resultUpdate.email,'.'))}" maxlength="7"><span id="span2">.</span><input
						type="text" class="input" name="email3" id="email3" value="${fn:substring(resultUpdate.email, fn:indexOf(resultUpdate.email,'.')+1, -1)}" maxlength="3"> 
				</div>


				<div id="bt" class="td">
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