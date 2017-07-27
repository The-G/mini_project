<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="/favicon.ico" />

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<c:url value="/resource/css/bootstrap.css" />">
<script src="<c:url value="/resource/js/jquery-3.2.1.js" />"></script>
<script src="<c:url value="/resource/js/bootstrap.js" />"></script>

<script src="<c:url value="/resource/js/d3.v3.min.js" />"></script>
<script src="<c:url value="/resource/js/d3.layout.cloud.js" />" ></script>

</head>
<body>
	<div class="container">
		<div class="row">
			<!-- wordcloud -->
			<div class="col-md-12 col-sm-12 col-xs-12" align="center">
				<div id="word-cloud"></div>
			</div>
			<!-- some comments -->
			<div class="col-md-12 col-sm-12 col-xs-12">
				<table class="table">
					<h1 class="text-center">영화 댓글</h1>
					<thead class="thead-inverse">
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

	var color = d3.scale.linear()
		.domain([ 0, 1, 2, 3, 4, 5, 6, 10, 15, 20, 100 ])
		.range([ "#21618C", "#2874A6", "#2E86C1", "#3498DB", "#5DADE2", "#85C1E9", "#AED6F1", "#AED6F1", "#AED6F1", "#AED6F1", "#AED6F1", "#AED6F1" ]);

	d3.layout.cloud().size([ 800, 350 ])
		.words(frequency_list)
		.rotate(0)
		.fontSize(function(d) {
			return d.size;
		})
		.on("end", draw)
		.start();

	function draw(words) {
		d3.select("#word-cloud").append("svg")
			.attr("width", 850)
			.attr("height", 550)
			.attr("class", "wordcloud")
			.append("g")
			// without the transform, words words would get cutoff to the left and top, they would
			// appear outside of the SVG area
			.attr("transform", "translate(320,300)")
			.selectAll("text")
			.data(words)
			.enter().append("text")
			.style("font-size", function(d) {
				return d.size + 10 + "px";
			})
			.style("fill", function(d, i) {
				return color(i);
			})
			.attr("transform", function(d) {
				return "translate(" + [ d.x, d.y ] + ")rotate(" + d.rotate + ")";
			})
			.text(function(d) {
				return d.text;
			});
	}
</script>

</html>