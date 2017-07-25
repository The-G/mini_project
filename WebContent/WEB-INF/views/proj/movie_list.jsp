<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<h1>Serched Movies</h1>
		<p>you can Find, Wordcloud & Analytics</p>
	</div>


	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

			</div>
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<form action="searchAction" method="post">
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
								<input type="hidden" value="${vo.crawling_daum_id}" /><br>
								<input type="submit" value="Make WordCloud" />
							</div>

						</div>
					</div>
				</c:forEach>
			</form>
		</div>
	</div>
</body>
</html>
