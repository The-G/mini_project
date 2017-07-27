<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="context" value="${pageContext.request.contextPath}"/> 
<html>
<head>
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
	margin-bottom: 0px;
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
<title>mini_project</title>
<link rel="shortcut icon" href="../resource/img/favicon.png" />

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
<body>
<div class="container text-center">
		 <img src= "../resource/img/title.png"><br>
		
		
	</div>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="main">Home</a>
        </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">WordCloud</a></li>
        <li><a href="#">Analytics</a></li>
        
      </ul>
      <ul class="nav navbar-nav navbar-right">
      <li><a href="testAction"><span class="glyphicon glyphicon-user"></span>test</font></a></li>
         <c:if test="${empty loginUser}">
        <li><a href="${context}/login.do"><span class="glyphicon glyphicon-user"></span> Login</a></li>
         </c:if>
         <c:if test="${not empty loginUser}">  
		<li><a href="${context}/logout.do"><span class="glyphicon glyphicon-user"></span> Logout</a></li>			
		<li><a href="${context}/mypage.do"><span class="glyphicon glyphicon-user"></span> Mypage</a></li>			
		</c:if>			
					
					
					
      </ul>
    </div>
  </div>
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
			style="width: 75; font-family: 돋움; background-color: #eff7f9; color: #000000; border: 1 solid #A0DBE4"
			></b>
	</form>

</body>





</html>