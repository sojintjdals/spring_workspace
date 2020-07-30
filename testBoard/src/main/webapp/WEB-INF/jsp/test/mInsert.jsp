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
		});
		$("#back").click(function() {
			$("#lrm").attr("action", "/test/list.do");
			$("#lrm").submit();
		});
		$("#id").blur(function() {
			if ($("#id").val().length > 0) {
				var jsonv = {
					id : $("#id").val()
				};
				$.ajax({
					type : "POST",
					url : "/test/idCheckAjax.do",
					data : jsonv,
					success : function(data) {
						console.log(data);
						if (data == "Y") {
							$("#idcheck").text("이미 가입한 ID입니다.");
							$("#idcheck").css("color", "red");
							$("#id").val("");
							$("#id").focus();
						} else if (data == "N") {
							$("#idcheck").text("회원가입이 가능합니다.");
							$("#idcheck").css("color", "#29d616");

						}
					}//END OF 콜백함수 즉 DB상 중복체크를 해온결과가 data
				});//END OF AJAX
			} else {
				alert("아이디를 입력하세요.");
			}
		});
	});
	if ($.trim($("#id").val())) {

	}//END OF IF 아이디 입력이 있는경우
	else {
		$("#idcheck").text("아이디를 입력해주세요.");
		$("#idcheck").css("color", "red");
		$("#id").focus();
	}
</script>
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function sample6_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var addr = ''; // 주소 변수
						var extraAddr = ''; // 참고항목 변수

						//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							addr = data.roadAddress;
						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							addr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
						if (data.userSelectedType === 'R') {
							// 법정동명이 있을 경우 추가한다. (법정리는 제외)
							// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
							if (data.bname !== ''
									&& /[동|로|가]$/g.test(data.bname)) {
								extraAddr += data.bname;
							}
							// 건물명이 있고, 공동주택일 경우 추가한다.
							if (data.buildingName !== ''
									&& data.apartment === 'Y') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
							if (extraAddr !== '') {
								extraAddr = ' (' + extraAddr + ')';
							}
							// 조합된 참고항목을 해당 필드에 넣는다.
							document.getElementById("sample6_extraAddress").value = extraAddr;

						} else {
							document.getElementById("sample6_extraAddress").value = '';
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample6_postcode').value = data.zonecode;
						document.getElementById("sample6_address").value = addr;
						// 커서를 상세주소 필드로 이동한다.
						document.getElementById("sample6_detailAddress")
								.focus();
					}
				}).open();
	}
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
					<div id="idcheck"></div>
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
				<!-- 				우편번호
				<div>
					<input type="text" id="sample6_postcode" placeholder="우편번호">
					<input type="button" onclick="sample6_execDaumPostcode()"
						value="우편번호 찾기"><br> <input type="text"
						id="sample6_address" placeholder="주소"><br> <input
						type="text" id="sample6_detailAddress" placeholder="상세주소">
					<input type="text" id="sample6_extraAddress" placeholder="참고항목">
				</div> -->
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