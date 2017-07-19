<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>mini_project</title>
<link rel="shortcut icon" href="/favicon.ico" />

<!-- Bootstrap Core CSS -->
<link
	href="<c:url value="../resource/vendor/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- Custom Fonts -->
<link href="../resource/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href='../resource/https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link
	href='../resource/https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>

<!-- Plugin CSS -->
<link href="../resource/vendor/magnific-popup/magnific-popup.css"
	rel="stylesheet">

<!-- Theme CSS -->
<link href="../resource/css/creative.min.css" rel="stylesheet">


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
				<a class="navbar-brand page-scroll" href="#page-top">Start
					Bootstrap</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="testAction">test</a></li>
					<li><a href="sign_up">회원가입</a></li>
					<li><a href="login">로그인</a></li>
					<li><a href="mypage">마이 페이지</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<header>
		<div class="header-content">
			<div class="header-content-inner">
				<h1 id="homeHeading">To see oR Not</h1>
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
					<a href="login.jsp"
						class="page-scroll btn btn-default btn-xl sr-button">After
						logging Get Started!</a>
				</div>
			</div>
		</div>
	</section>



</body>
</html>