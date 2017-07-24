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

</head>
<body>
	<div class="container">
		<table class="table">
			<h1 class="text-center">영화 리스트</h1>
			<thead class="thead-inverse">
				<tr>
					<th>title</th>
					<th>crawling_daum_id</th>
					<th>img_url</th>
					<th>개봉일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="vo">
					<tr>
						<td>${vo.name}</td>
						<td>${vo.crawling_daum_id}</td>
						<td><img src="${vo.img_url}" /></td>
						<td><fmt:formatDate value="${vo.release_date}" type="both"
								dateStyle="short" timeStyle="short" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>

