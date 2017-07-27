<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<head>
<title>Bootstrap Example</title>
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
</head>
<body>
	<div class="container text-center">
		<img src="${context}/resource/img/title3.png">
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
	<div class="container">
		<div class="row">
			<c:forEach items="${list}" var="vo">
				<div class="col-sm-3">
					<div class="panel panel-primary">
						<div class="panel-heading">${vo.name}</div>
						<div class="panel-body">
							<img src="${vo.img_url}" class="img-responsive"
								style="width: 100%" alt="Image">
						</div>
						<div class="panel-footer">
							<fmt:formatDate value="${vo.release_date}" type="both"
								dateStyle="short" timeStyle="short" />
							<form action="crawlingCommentAction" method="post">
								<input type="hidden" name="movie_id" value="${vo.movie_id}" />
								<input type="hidden" name="crawling_id"
									value="${vo.crawling_daum_id}" /><br> 
								<input type="submit" value="Make WordCloud" />
							</form>
							<form action="drawplot" method="post">
								<input type="hidden" name="name" value="${vo.name}" />
								<input type="submit" value="Plot" />
							</form>
						</div>

					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>
