<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}"/> 
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>mini_project</title>
<link rel="shortcut icon" href="/favicon.ico" />

<!-- Bootstrap Core CSS -->
<link
	href="<c:url value="/resource/vendor/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- Custom Fonts -->
<link href="${context}/resource/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href='${context}/resource/https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link
	href='${context}/resource/https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>

<!-- Plugin CSS -->
<link href="${context}/resource/vendor/magnific-popup/magnific-popup.css"
	rel="stylesheet">

<!-- Theme CSS -->
<link href="${context}/resource/css/creative.css" rel="stylesheet">


</head>
<body id="page-top">

	<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> Menu <i
						class="fa fa-bars"></i>
				</button>
				<a class="navbar-brand page-scroll" href="/main">홈으로</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${context}/testAction">test</a></li>
					<c:if test="${empty loginUser}">
					<li><a href="${context}/login.do">로그인</a></li>
					</c:if>
					<c:if test="${not empty loginUser}">
					<li><a href="${context}/logout.do">로그아웃</a></li>
					<li><a href="${context}/mypage.do">마이페이지</a></li>
					</c:if>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<header>
		<div class="header-content">
			<div class="header-content-inner">
			
				<h1 id="homeHeading"><img src="${context}/resource/img/portfolio/letter/title.png"></h1>
				<input type="text"  name="moive" style="color: grey" value ="영화이름입력"> <input type="button" value="검색">

				<br>
			</div>
		</div>
	</header>

	<section class="bg-primary" id="about">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 text-center">
					<h2 class="section-heading">We've got what you need!</h2>
					<hr class="light">
					<p class="text-faded">You know, there are so many movies that
						are being released. but... I mean. It is very hard to choise
						movie. We will help you make a decision where you go to theater or
						at your'home</p>
					<a href="${context}login.jsp"
						class="page-scroll btn btn-default btn-xl sr-button">After
						logging Get Started!</a>
				</div>
			</div>
		</div>
	</section>



</body>





</html>