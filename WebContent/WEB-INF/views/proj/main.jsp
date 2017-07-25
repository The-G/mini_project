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
				<a class="navbar-brand page-scroll" href="main"><font color="f2f516" >영화를 부탁해</font></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="testAction"><font color="f2f516" >test</font></a></li>
					<c:if test="${empty loginUser}">
					<li><a href="${context}/login.do"><font color="f2f516" >로그인</font></a></li>
					</c:if>
					<c:if test="${not empty loginUser}">
					<li><a href="${context}/logout.do"><font color="f2f516" >로그아웃</font></a></li>
					<li><a href="${context}/mypage.do"><font color="f2f516" >마이페이지</font></a></li>
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
		
			
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				
				
			
	<form action="searchAction" method="post">
		<input type="text" name="movie_name" style="color: black"
			placeholder="영화이름입력" required="required"> <b> <input
			type="submit" color="color:black" value="검색"
			style="width: 75; font-family: 돋움; background-color: #eff7f9; color: #000000; border: 1 solid #A0DBE4"></b>
	</form>

</body>





</html>