<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Bootstrap Example</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- font awesome -->
<link rel="stylesheet" href="css/member.font-awesome.min.css"
	media="screen" title="no title" charset="utf-8">
<!-- Custom style -->
<link rel="stylesheet" href="css/member.style.css" media="screen"
	title="no title" charset="utf-8">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
/* Remove the navbar's default rounded borders and increase the bottom margin */
.navbar {
	margin-bottom: 50px;
	border-radius: 0;
}

/* Remove the jumbotron's default bottom margin */
.jumbotron {
	margin-bottom: 0;
}

/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 25px;
}
</style>
<script type="text/javascript"
	src='<c:url value="/resource/js/member.js"/>'></script>
</head>
<body>

	<div class="container text-center">
		<img src= "${context}/resource/img/title.png">
		
	</div>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main">Home</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">WordCloud</a></li>
				<li><a href="#">Analytics</a></li>

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${empty loginUser}">
					<li><a href="${context}/login.do"><span
							class="glyphicon glyphicon-user"></span> Login</a></li>
				</c:if>
				<c:if test="${not empty loginUser}">
					<li><a href="${context}/logout.do"><span
							class="glyphicon glyphicon-user"></span> Logout</a></li>
					<li><a href="${context}/mypage.do"><span
							class="glyphicon glyphicon-user"></span> Mypage</a></li>
				</c:if>



			</ul>
		</div>
	</div>
	</nav>

	<article class="container">
	<div class="page-header">
		<h1>
			회원수정 <small>Sign up</small>
		</h1>
	</div>
	<form method="post" action="memberUpdate.do" name="frm">
		<div class="col-md-6 col-md-offset-3">
			<div class="form-group">
				<label for="username">이름</label> <input type="text"
					class="form-control" name="name" value="${mVo.name}" readonly>
			</div>

			<div class="form-group">
				<label for="InputId">아이디</label> <input type="text" name="userid"
					class="form-control" value="${mVo.userid}" readonly>
			</div>

			<div class="form-group">
				<label for="InputPassword1">비밀번호</label> <input type="password"
					name="pwd" class="form-control">
			</div>

			<div class="form-group">
				<label for="InputPassword2">비밀번호 확인</label> <input type="password"
					name="pwd_check" class="form-control">
				<p class="help-block">비밀번호 확인을 위해 다시 한번 입력 해 주세요</p>
			</div>

			<div class="form-group">
				<label for="nickname">닉네임</label> <input type="text"
					class="form-control" name="nickname" value="${mVo.nickname}">
			</div>

			<div class="form-group">
				<label for="InputEmail">이메일 주소</label> <input type="text"
					class="form-control" name="email" value="${mVo.email}">
			</div>

			<div class="form-group">
				<label for="Inputphone">휴대폰 번호</label> <input type="text"
					class="form-control" name="phone" value="${mVo.phone}">
			</div>

			<div class="form-group">
				<label for="Inputworst">당신의 최악의 영화는?</label> <input type="text"
					class="form-control" name="worstMovie" value="${mVo.worstMovie}">
			</div>

			<div class="form-group">
				<label for="gender">성별</label>
				<c:choose>
					<c:when test="${mVo.gender==0}">
						<input type="radio" name="gender" value="0" checked="checked">남
			  <input type="radio" name="gender" value="1">여
			  </c:when>
					<c:otherwise>
						<input type="radio" name="gender" value="0">남
			  <input type="radio" name="gender" value="1" checked="checked">여
              </c:otherwise>
				</c:choose>
			</div>

			<div class="form-group">
				<label for="이메일수신여부">이메일 수신여부</label>
				<c:choose>
					<c:when test="${mVo.receiveEmail==0}">
						<input type="radio" name="receiveEmail" value="0"
							checked="checked">예
			  <input type="radio" name="receiveEmail" value="1">아니요
			     </c:when>
					<c:otherwise>
						<input type="radio" name="receiveEmail" value="0">예
			  <input type="radio" name="receiveEmail" value="1" checked="checked">아니요
              </c:otherwise>
				</c:choose>
			</div>


			<div class="form-group">
				<label for="SNS수신여무">SNS 수신여부</label> 
				<c:choose>
						<c:when test="${mVo.receiveSns==0}">
						<input type="radio" name="receiveSns" value="0" checked="checked">예 <input
					type="radio" name="receiveSns" value="1">아니요
					</c:when>
						<c:otherwise>
						<input type="radio" name="receiveSns" value="0" >예 <input
					type="radio" name="receiveSns" value="1" checked="checked">아니요
					 </c:otherwise>
					</c:choose>
			</div>

			<div class="form-group text-center">
				<input type="submit" class="btn btn-info" value="수정"
					onclick="return joinCheck()"><i
					class="fa fa-check spaceLeft"></i> <input type="reset"
					class="btn btn-warning" value="재작성"><i
					class="fa fa-times spaceLeft"></i>
			</div>

		</div>
	</form>
	</article>




</body>
</html>
