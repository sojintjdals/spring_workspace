<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<script type="text/javascript">

</script>
</head>
<header>
	<div></div>
	<div></div>
	<span id="banner">MTMWEB</span>
	<div>
		<%-- <c:if test="${not empty userId}">
			<div class="login">
				<span id="welcome">${userName}(${userId})</span> <input
					type="button" name="logout" class="button is-primary is-light"
					id="logout" value="로그아웃"> <input type="hidden" name="id"
					id="id" data-id="${userId}" value="${userId}"> <input
					type="button" name="memberView" class="button is-primary is-light"
					data-id="${userId}" id="memberView" value="회원정보">
			</div>
		</c:if> --%>
		<!-- 인터셉터 로그인 버튼 부분 -->
		<c:if test="${not empty sessionScope.MemberBoardVO}">
			<div class="login">
				<span id="welcome">${sessionScope.MemberBoardVO.name}(${sessionScope.MemberBoardVO.id})</span> <input
					type="button" name="logout" class="button is-primary is-light"
					id="logout" value="로그아웃"> <input type="hidden" name="id"
					id="id" data-id="${sessionScope.MemberBoardVO.id}" value="${sessionScope.MemberBoardVO.id}"> <input
					type="button" name="memberView" class="button is-primary is-light"
					data-id="${sessionScope.MemberBoardVO.id}" id="memberView" value="회원정보">
			</div>
		</c:if>
		<%-- <c:if test="${empty userId}">
			<div class="login">
				<button class="button is-primary is-light" name="loginmember"
					id="loginmember">로그인</button>
				<button class="button is-primary is-light" name="register"
					id="register">회원가입</button>
			</div>
		</c:if> --%>
		<c:if test="${empty sessionScope.MemberBoardVO}">
			<div class="login">
				<button class="button is-primary is-light" name="loginmember"
					id="loginmember">로그인</button>
				<button class="button is-primary is-light" name="register"
					id="register">회원가입</button>
			</div>
		</c:if>
	</div>
</header>
<nav>
	<ul>
		<li id="L1" class="nav">게시판1</li>
	</ul>
	<ul>
		<li id="L2" class="nav">게시판2</li>
	</ul>
	<ul>
		<li id="L3" class="nav">게시판3</li>
	</ul>
	<ul>
		<li id="L4" class="nav">게시판4</li>
	</ul>
	<ul>
		<li id="L5" class="nav">게시판5</li>
	</ul>
	<ul>
		<li id="L6" class="nav">게시판6</li>
	</ul>
	<ul>
		<li id="L7" class="nav">게시판7</li>
	</ul>
</nav>