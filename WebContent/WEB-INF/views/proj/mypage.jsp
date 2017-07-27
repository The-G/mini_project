<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Bootstrap Example</title>
 <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- font awesome -->
    <link rel="stylesheet" href="css/member.font-awesome.min.css" media="screen" title="no title" charset="utf-8">
    <!-- Custom style -->
    <link rel="stylesheet" href="css/member.style.css" media="screen" title="no title" charset="utf-8">
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
<script type="text/javascript" src='<c:url value="/resource/js/member.js"/>'></script>
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
			<a class="navbar-brand" href="${context}/main">Home</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">WordCloud</a></li>
				<li><a href="#">Analytics</a></li>

			</ul>
			<ul class="nav navbar-nav navbar-right">
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
<article class="container">
        <div class="page-header">
          <h1>마이페이지 <small>Mypage</small></h1> <input type="button" value="회원정보변경" class="btn btn-warning"
	onclick="location.href='memberUpdate.do?userid=${loginUser.userid}'">
        </div>
안녕하세요. ${loginUser.name}(${loginUser.userid})님;</br>
영화관 가서 돈 버린적이 한 두 번 아니죠?</br>
긴가민가 할 때는 한 번 검색하세요!</br>


</body>
</html>