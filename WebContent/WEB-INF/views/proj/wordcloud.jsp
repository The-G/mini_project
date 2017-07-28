<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="/favicon.ico" />

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="<c:url value="/resource/css/bootstrap.css" />">
<script src="<c:url value="/resource/js/jquery-3.2.1.js" />"></script>
<script src="<c:url value="/resource/js/bootstrap.js" />"></script>

<script src="<c:url value="/resource/js/d3.v3.min.js" />"></script>
<script src="<c:url value="/resource/js/d3.layout.cloud.js" />"></script>

</head>
<body>

	<div class="container text-center">
		<img src="../resource/img/title.png"><br>


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
					<a class="navbar-brand" href="main">MoiveChart</a>

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
				WORDCLOUD FOR<small> ${movie_name} </small>
			</h1>
		</div>
	</article>


	<div class="container">
		<div class="row">
			<!-- wordcloud -->
			<div class="col-md-12 col-sm-12 col-xs-12" align="center">
				<div id="word-cloud"></div>
			</div>
			<div class="col-md-12 col-sm-12 col-xs-12" align="center">
				<div id="word-cloud2"></div>
			</div>
			<!-- some comments -->
			<div class="col-md-12 col-sm-12 col-xs-12">
				<table class="table">
					<h1 class="text-center">영화 댓글</h1>
					<thead class="thead-inverse">
						<tr>

						</tr>
						<tr>
							<th>score</th>
							<th>content</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="vo">
							<tr>
								<td>${vo.score}</td>
								<td>${vo.content}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>

<script>
	var result = '${count_word}';
	// 	console.log("first : " + typeof result);
	var json_result = JSON.parse(result);
	// 	console.log("second : " + json_result);
	var frequency_list = json_result;
	
	var color = d3.scale.linear().domain(
			[ 0, 1, 2, 3, 4, 5, 6, 10, 15, 20, 100 ]).range(
			[ "#154360", "#1B4F72", "#1A5276", "#21618C", "#1F618D", "#2874A6",
					"#2471A3", "#2E86C1", "#2980B9", "#3498DB", "#5499C7",
					"#5DADE2" ]);

	d3.layout.cloud().size([ 800, 1000 ]).words(frequency_list).rotate(0)
			.fontSize(function(d) {
				return d.size;
			}).on("end", draw).start();

	function draw(words) {
		d3.select("#word-cloud").append("svg").attr("width", 850).attr(
				"height", 550).attr("class", "wordcloud").append("g")
		// without the transform, words words would get cutoff to the left and top, they would
		// appear outside of the SVG area
		.attr("transform", "translate(320,300)").selectAll("text").data(words)
				.enter().append("text").style("font-size", function(d) {
					return d.size + 15 + "px";
				}).style("fill", function(d, i) {
					return color(i);
				}).attr(
						"transform",
						function(d) {
							return "translate(" + [ d.x, d.y ] + ")rotate("
									+ d.rotate + ")";
						}).text(function(d) {
					return d.text;
				});
	}
</script>

<script>
	var result = '${count_word2}';
	// 	console.log("first : " + typeof result);
	var json_result = JSON.parse(result);
	// 	console.log("second : " + json_result);
	var frequency_list = json_result;
	
	var color = d3.scale.linear().domain(
			[ 0, 1, 2, 3, 4, 5, 6, 10, 15, 20, 100 ]).range(
			[ "#4A235A", "#512E5F", "#5B2C6F", "#633974", "#6C3483", "#76448A",
					"#7D3C98", "#884EA0", "#8E44AD", "#9B59B6", "#A569BD",
					"#AF7AC5" ]);

	d3.layout.cloud().size([ 800, 1000 ]).words(frequency_list).rotate(0)
			.fontSize(function(d) {
				return d.size;
			}).on("end", draw).start();

	function draw(words) {
		d3.select("#word-cloud2").append("svg").attr("width", 850).attr(
				"height", 550).attr("class", "wordcloud").append("g")
		// without the transform, words words would get cutoff to the left and top, they would
		// appear outside of the SVG area
		.attr("transform", "translate(320,300)").selectAll("text").data(words)
				.enter().append("text").style("font-size", function(d) {
					return d.size + 15 + "px";
				}).style("fill", function(d, i) {
					return color(i);
				}).attr(
						"transform",
						function(d) {
							return "translate(" + [ d.x, d.y ] + ")rotate("
									+ d.rotate + ")";
						}).text(function(d) {
					return d.text;
				});
	}
</script>
</html>