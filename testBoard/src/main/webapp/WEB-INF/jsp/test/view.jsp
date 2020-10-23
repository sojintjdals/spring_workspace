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
					var userId = $("#userId").val();
					var rno = this.rno;
					console.log(data);
					console.log(data.length);
					console.log(seqno);
					$(data).each(function() {
						
						str += 	"<li data-rno='"+this.rno+"' class='replyLi'>"
						+ this.rno+" : " 
						+ "<span class='replyUser' id='replyUser' data-user=" + this.userId + ">" + this.userId + "</span> : "
						+ "<span class='replyVal' id='replyVal'>" + this.replytext + "</span>";
						if(this.userId == userId){
							str += "<input type='text' class='replyUpdate' id='replyUpdate' name='replyUpdate' />"
							+ "<input type='button' class='replyMBtn' id='replyMBtn' name='replyMBtn' value='댓글수정' />"
							+ "<input data-rno="+this.rno+" type='button' class='replyMBtn2' id='replyMBtn2' name='replyMBtn2' value='댓글수정' />"
							+ "<input type='button' class='replyCancel' id='replyCancel' name='replyCancel' value='취소' />"
							+ "<span data-rno ="+this.rno+" class='X'>X</span>"
						} 
						//답글부문
						str += "<input type='text' class='replyAnswerVal' id='replyAnswerVal' name='replyAnswerVal' />"
							+ "<input type='button' class='replyAnswer' id='replyAnswer' name='replyAnswer' value='답글' />"
							+ "<input data-rno="+this.rno+" type='button' class='replyAnswer2' id='replyAnswer2' name='replyAnswer2' value='답글2' />"
							+ "<input type='button' class='replyCancel2' id='replyCancel2' name='replyCancel2' value='취소' /></li>"
							+ "<ul class='replyAnswerList' id='replyAnswerList' name='replyAnswerList'></ul>";
						//답글리스트
						$.getJSON("/rest/answer/" + seqno + ".do", function(data) {
							var userId = $("#userId").val();
							alert(rno);
							console.log(data);
							console.log(data.length);
							console.log(seqno);
							if(data.length != 0){
								$(data).each(function() {
									str += 	"<li data-sub_rno='"+this.sub_rno+"' class='replyAnswerLi'>"
									+ this.sub_rno+" : " 
									+ "<span class='replyAnswerUser' id='replyAnswerUser' data-answerUser=" + this.userId + ">" + this.userId + "</span> : "
									+ "<span class='replyAnswerVal' id='replyAnswerVal'>" + this.replytext + "</span>";
									if(this.userId == userId){
										str += "<input type='text' class='replyAnswerUpdate' id='replyAnswerUpdate' name='replyAnswerUpdate' />"
										+ "<input type='button' class='replyAnswerMBtn' id='replyAnswerMBtn' name='replyAnswerMBtn' value='댓글수정' />"
										+ "<input data-rno="+this.rno+" type='button' class='replyAnswerMBtn2' id='replyAnswerMBtn2' name='replyAnswerMBtn2' value='댓글수정' />"
										+ "<input type='button' class='replyAnswerCancel' id='replyAnswerCancel' name='replyAnswerCancel' value='취소' />"
										+ "<span data-rno ="+this.rno+" class='X'>X</span>"
									} 
									//답글부문
									str += "</li>";
								});
								$("#replyAnswerList").html(str);
								$(".replyAnswerUpdate").hide();
								$(".replyAnswerMBtn2").hide();
								$(".replyAnswerCancel").hide();
								$(".replyAnswerVal").hide();
								$(".replyAnswer2").hide();
								$(".replyCancel2").hide();
								if(userId == '()'){
									$(".replyMBtn").hide();
									$(".X").hide();
									$(".replyAnswer").hide();
								}
							}
						});
					});
					$("#replyList").html(str);
					$(".replyUpdate").hide();
					$(".replyMBtn2").hide();
					$(".replyCancel").hide();
					$(".replyAnswerVal").hide();
					$(".replyAnswer2").hide();
					$(".replyCancel2").hide();
					if(userId == '()'){
						$(".replyMBtn").hide();
						$(".X").hide();
						$(".replyAnswer").hide();
					}
					
				});
				//답글 텍스트창으로 돌입하기
				$(".replyList").on("click", ".replyAnswer", function(event) {
					$(".replyMBtn").show();
					$(".X").show();
					$(this).prevAll().hide();
					$(".replyUser").show();
					$(".replyVal").show();
					$(".replyUpdate").hide();
					$(".replyMBtn2").hide();
					$(".replyCancel").hide();
					$(".replyAnswerVal").hide();
					$(".replyAnswer2").hide();
					$(".replyCancel2").hide();
					$(".replyAnswer").show();
					$(this).hide();//버튼숨기기
					$(this).prev().show();
					$(this).next().show();
					$(this).next().next().show();
					
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
								$.getJSON("/rest/all/" + seqno + ".do", function(data) {
									var str = "";
									$(data).each(function() {
										str += 	"<li data-rno='"+this.rno+"' class='replyLi'>"
										+ this.rno+" : " 
										+ "<span class='replyUser' id='replyUser' data-user=" + this.userId + ">" + this.userId + "</span> : "
										+ "<span class='replyVal' id='replyVal'>" + this.replytext + "</span>"
										if(this.userId == userId){
											str += "<input type='text' class='replyUpdate' id='replyUpdate' name='replyUpdate' />"
											+ "<input type='button' class='replyMBtn' id='replyMBtn' name='replyMBtn' value='댓글수정' />"
											+ "<input data-rno="+this.rno+" type='button' class='replyMBtn2' id='replyMBtn2' name='replyMBtn2' value='댓글수정2' />"
											+ "<input type='button' class='replyCancel' id='replyCancel' name='replyCancel' value='취소' />"
											+ "<span data-rno ="+this.rno+" class='X'>X</span>"
										} 
										str += "<input type='text' class='replyAnswerVal' id='replyAnswerVal' name='replyAnswerVal' />"
										+ "<input type='button' class='replyAnswer' id='replyAnswer' name='replyAnswer' value='답글' />"
										+ "<input data-rno="+this.rno+" type='button' class='replyAnswer2' id='replyAnswer2' name='replyAnswer2' value='답글2' />"
										+ "<input type='button' class='replyCancel2' id='replyCancel2' name='replyCancel2' value='취소' /></li>";
									});
									$("#replyList").html(str);
									$(".replyUpdate").hide();
									$(".replyMBtn2").hide();
									$(".replyCancel").hide();
									$(".replyAnswerVal").hide();
									$(".replyAnswer2").hide();
									$(".replyCancel2").hide();
									if(userId == '()'){
										$(".replyMBtn").hide();
										$(".X").hide();
										$(".replyAnswer").hide();
									}								
								});
							 } 
						}
					});
					$("#replytext").val('');
				});
				//댓글수정하는 텍스트창으로 돌입하기
				$(".replyList").on("click", ".replyMBtn", function(event) {
					$(".replyMBtn").show();
					$(this).prevAll().hide();
					$(".replyUser").show();
					$(".replyVal").show();
					$(".replyUpdate").hide();
					$(".replyMBtn2").hide();
					$(".replyCancel").hide();
					$(".replyAnswerVal").hide();
					$(".replyAnswer2").hide();
					$(".replyCancel2").hide();
					$(".replyAnswer").show();
					$(this).prev().show();//텍스트보여주기
					$(this).prev().val($(this).prev().prev().text());//텍스트값채우기
					$(this).prev().prev().hide();//span숨기기
					$(this).hide();//버튼숨기기
					$(this).next().show();//다른버튼보여주기
					$(this).next().next().show();//취소버튼 보여주기
				});
				//수정취소
				$(".replyList").on("click", ".replyCancel", function(event) {
					$(this).prev().hide();
					$(this).prev().prev().show();
					$(this).hide();
					$(this).prev().prev().prev().prev().show();
					$(this).prev().prev().prev().val('');
					$(this).prev().prev().prev().hide();
					$(this).prev().prev().prev().prev().prev().hide();
					$(".replyUser").show();
				});
				//댓글수정완료
				$(".replyList").on("click", ".replyMBtn2", function(event) {
					var that = $(this);
					var replytext = $(this).prev().prev().val();
					alert(replytext);
					var jsonData = JSON.stringify({
						rno : that.attr("data-rno"),
						replytext : replytext
					})
					console.log(jsonData);
					if(replytext = $(this).prev().prev().val() == ''){
						alert("댓글을 입력해주세요!");
						return 0;
					}
					
					$.ajax({
						url : "/rest/replyUpdate.do",
						headers : {
							"Content-Type" : "application/json",
							"X-HTTP-Method-Override" : "POST"
						},
						type : "post",
						data : jsonData,
						dataType : "text",
						success : function(result) {
							if (result == 'SUCCESS') {
								alert("수정에 성공하였습니다.");
							}
						}
					});
					$(this).prev().show();
					$(this).prev().prev().hide();
					$(this).hide();
					$(this).next().hide();
					$(this).prev().prev().prev().text($(this).prev().prev().val());
					$(this).prev().prev().prev().show();
					$(this).prev().prev().val('');
					$(this).prev().prev().hide();
				});
				//답글달기
				$(".replyList").on("click", ".replyAnswer2", function(event) {
					var userId = $("#userId").val();
					var replyAnswerVal = $(this).prev().prev().val();
					var rno = $(this).attr("data-rno");
					alert(replyAnswerVal);
					alert(rno);
					if(replyAnswerVal == ''){
						alert("답글을 입력해주세요!");
						return 0;
					}
					
					$.ajax({
						url : "/rest/replyAnswerInsert.do",
						headers : {
							"Content-Type" : "application/json",
							"X-HTTP-Method-Override" : "POST"
						},
						type : "post",
						data : JSON.stringify({
							rno : $(this).attr("data-rno"),
							userId : userId,
							replytext : replyAnswerVal
						}),
						dataType : "text",
						success : function(result) {
							if (result == 'SUCCESS') {
								/* $.getJSON("/rest/all/" + seqno + ".do", function(data) {
									var str = "";
									$(data).each(function() {
										str += 	"<li data-rno='"+this.rno+"' class='replyLi'>"
										+ this.rno+" : " 
										+ "<span class='replyUser' id='replyUser' data-user=" + this.userId + ">" + this.userId + "</span> : "
										+ "<span class='replyVal' id='replyVal'>" + this.replytext + "</span>"
										if(this.userId == userId){
											str += "<input type='text' class='replyUpdate' id='replyUpdate' name='replyUpdate' />"
											+ "<input type='button' class='replyMBtn' id='replyMBtn' name='replyMBtn' value='댓글수정' />"
											+ "<input data-rno="+this.rno+" type='button' class='replyMBtn2' id='replyMBtn2' name='replyMBtn2' value='댓글수정2' />"
											+ "<input type='button' class='replyCancel' id='replyCancel' name='replyCancel' value='취소' />"
											+ "<span data-rno ="+this.rno+" class='X'>X</span>"
										} 
										str += "<input type='text' class='replyAnswerVal' id='replyAnswerVal' name='replyAnswerVal' />"
										+ "<input type='button' class='replyAnswer' id='replyAnswer' name='replyAnswer' value='답글' />"
										+ "<input data-rno="+this.rno+" type='button' class='replyAnswer2' id='replyAnswer2' name='replyAnswer2' value='답글2' />"
										+ "<input type='button' class='replyCancel2' id='replyCancel2' name='replyCancel2' value='취소' /></li>";
									});						
								}); */
								alert("답글 성공!");
								$("#replyList").html(str);
								$(".replyUpdate").hide();
								$(".replyMBtn2").hide();
								$(".replyCancel").hide();
								$(".replyAnswerVal").hide();
								$(".replyAnswer2").hide();
								$(".replyCancel2").hide();
								if(userId == '()'){
									$(".replyMBtn").hide();
									$(".X").hide();
									$(".replyAnswer").hide();
								}		
							}
						}
					});
				});
				//답글취소
				$(".replyList").on("click", ".replyCancel2", function(event) {
					$(".replyMBtn").show();
					$(".X").show();
					$(".replyUser").show();
					$(".replyVal").show();
					$(".replyUpdate").hide();
					$(".replyMBtn2").hide();
					$(".replyCancel").hide();
					$(".replyAnswerVal").hide();
					$(".replyAnswer2").hide();
					$(".replyCancel2").hide();
					$(".replyAnswer").show();
					$(this).hide();//버튼숨기기
					$(this).prev().show();
					$(this).next().show();
					$(this).next().next().show();
					$(this).prev().prev().show();
					$(this).prev().prev().prev().hide();//버튼숨기기
					$(this).prev().hide();
					$(this).hide();
				});
				//댓글삭제
				$("#replyList").on("click", ".X", function(event) {
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
				<ul id="replyList" class="replyList"></ul>
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
						<input type="hidden" name="replyCri" id="replyCri" value="${replyList.rno}">
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