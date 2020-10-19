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
	$(document).ready(
			
			function() {
				$("#modify").click(function() {
					$("#frm").attr("action", "/test/modify.do");
					$("#frm").submit();
				});
				$("#loginmember").click(function() {
					$("#frm").attr("action", "/test/Login.do");
					$("#frm").submit();
				});
				$("#logout").click(function() {
					$("#frm").attr("action", "/test/logout.do");
					$("#frm").submit();
				});
				var seqno = $("#seqno").val();
				var str = '';
				// 댓글리스트
				$.getJSON("/rest/all/" + seqno + ".do", function(data) {
					console.log(data);
					console.log(data.length);
					console.log(seqno);
					$(data).each(function() {
						str += "<li data-rno='"+this.rno+"' class='replyLi'>"
								+ this.userId + ":" + this.replytext 
								+ "<input type='button' id='replyMBtn' name='replyMBtn' value='댓글수정'>"
								+ "<span data-rno ="+this.rno+">X<span></li>";
					});
					$("#replyList").html(str);
				});
				
				
				//댓글작성
				$("#replyBtn").on("click", function(event) {
					var userId = $("#userId").val();
					var replytext = $("#replytext").val();
					
					if($("#replytext").val() == ''){
						alert("댓글을 입력해주세요!");
						return 0;
					}
					$.ajax({
						url : "/rest/replyInsert.do",
						headers : {
							"Content-Type" : "application/json",
							"X-HTTP-Method-Override" : "POST"
						},
						type : "post",
						data : JSON.stringify({
							seqno : seqno,
							userId : userId,
							replytext : replytext
						}),
						dataType : "text",
						success : function(result) {
							if (result == 'SUCCESS') {
								str += "<li data-rno="+rno+" class='replyLi'>"
								+ userId + ":" + replytext + "<input type='button' id='replyMBtn' name='replyMBtn' value='댓글수정'>"
								+ "<span data-rno="+rno+">X<span></li>";
								$("#replyList").html(str);
								$("#replytext").val('');
								replytext = '';
								rno += 1;
							}
						}
					});
				});
				$("#replyMBtn").on("click", function(event) {
					
					if($("#replyMtext").val() == ''){
						alert("댓글을 입력해주세요!");
						return 0;
					}
					$.ajax({
						url : "/rest/replyModify.do",
						headers : {
							"Content-Type" : "application/json",
							"X-HTTP-Method-Override" : "POST"
						},
						type : "post",
						data : JSON.stringify({
							seqno : seqno,
							userId : userId,
							replytext : replytext,
							rno : rno
						}),
						dataType : "text",
						success : function(result) {
							if (result == 'SUCCESS') {
								alert("수정");
							}
						}
					});
				});
				//댓글삭제
				$("#replyList").on("click", "span", function(event) {
					var that = $(this);
					$.ajax({
						url : "/rest/replyDelete.do",
						headers : {
							"Content-Type" : "application/json",
							"X-HTTP-Method-Override" : "POST"
						},
						type : "post",
						data :JSON.stringify({
							rno : that.attr("data-rno")
						}),
						dataType : "text",
						success : function(result) {
							if (result == 'SUCCESS') {
								that.parent("li").remove();
							}
						}
					});
				});
			});
	$(document).ready(function() {
		$("#delete").click(function() {

			var answer = false;

			answer = confirm("글을 삭제하시겠습니까?");

			if (answer == true) {
				alert("삭제가 완료되었습니다.");
				$("#frm").attr("action", "/test/delete.do");
				$("#frm").submit();
			}
		});
		/* 	$("#back").click(function() {
				$(location).attr('href','/test/list.do');
			}) */
		$("#back").click(function() {
			window.location.href = "<c:url value='/test/listPage.do' />";
		})
	});
</script>
<!-- 네이버스마트에디터 -->
<script type="text/javascript"
	src="/resources/smartEditor/js/HuskyEZCreator.js" charset="utf-8"></script>
<link rel="stylesheet"
	href="<c:url value='/css/bulma-0.9.0/bulma.min.css' />">
<link href="<c:url value="/testCss/view.css" />" rel="stylesheet"
	type="text/css">
</head>
<body>
	<form id="frm" action='/test/modify.do'>
		<%-- <input type="hidden" name="seqno" value="${result.seqno}"> --%>
		<div class="main">
			<c:import url="header.jsp"></c:import>
			<div></div>
			<div>
				<ul id="replyList"></ul>
			</div>
			<div id="frt">
				<div id="frt">
					<div id="td">
						<input type="hidden" name="seqno" id="seqno"
							value="${result.seqno}"> <input type="hidden"
							name="userName" id="userName" value="${result.userName}">
						<%-- <input type="hidden" name="userId" id="userId"
							value="${result.userId}">  --%>
						<input type="hidden" name="cnt" id="cnt" value="${result.cnt}">
					</div>
					<div id="td">
						<input type="hidden" name="userId" id="userId"
							value="${userName}(${userId})">
					</div>
					<div id="th">제목</div>
					<div id="td">
						<input type="text" class="input" name="title" id="title"
							value="${result.title}" readonly>
					</div>
					<div id="th">내용</div>
					<div id="td">
						<div style="height: 100%;" class="textarea is-large" id="contents"
							name="contents">${result.contents}</div>

						<c:forEach items="${list}" var="result2">
							<div class="td" data-id="${result2.seqno}"></div>
							<div class="td" id="title" data-id="${result2.seqno}">
								<img src="/test/displayFile.do?fileName=${result2.fullName}" />
								<a>${result2.fullName}</a>
							</div>
						</c:forEach>

					</div>
					<div class="bt" id="td">
						<c:if test="${not empty userId}">
							<br>
							<textarea class="textarea is-large" id="replytext"
								name="replytext" placeholder="댓글을 입력해보세요!"></textarea>
							<input type="button" id="replyBtn" name="replyBtn"
								class="button is-primary is-light" value="댓글작성">

						</c:if>
						<c:if test="${result.userId eq userId}">
							<input type="button" class="button is-primary is-light"
								value="수정" id="modify">
							<input type="button" value="삭제" id="delete"
								class="button is-primary is-light">
						</c:if>
						<input type="button" value="홈" id="back"
							class="button is-primary is-light">
					</div>
				</div>
			</div>
			<c:import url="footer.jsp"></c:import>
		</div>
	</form>
</body>
</html>