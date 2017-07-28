<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
  <head>
  	
  		
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
	<script type="text/javascript"
		src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript">
		
	    google.charts.load("current", {packages:['corechart']});
	    google.charts.setOnLoadCallback(drawChart);
	    function drawChart() {
	  		var a = '${a}';
	  		var a_number = Number(a);
	  		var b = '${b}';
	  		var b_number = Number(b);
	  		var c = '${c}';
	  		var c_number = Number(c);
	  		var d = '${d}';
	  		var d_number = Number(d);
	  		var e = '${e}';
	  		var e_number = Number(e);
	  		var f = '${f}';
	  		var f_number = Number(f);
	  		var g = '${g}';
	  		var g_number = Number(g);
	  		var h = '${h}';
	  		var h_number = Number(h);
	  		var i = '${i}';
	  		var i_number = Number(i);
	  		var j = '${j}';
	  		var j_number = Number(j);
	  		
	    	var final = a_number * -19 + c_number * 23 + d_number * -16 + e_number * 23 + j_number * 6
	
	  		
	      var data = google.visualization.arrayToDataTable([
	        ["개봉 후 일수", "관객수", { role: "style" } ],
	        ["1일", a_number, "gold"],
	        ["2일", b_number, "gold"],
	        ["3일", c_number, "gold"],
	        ["4일", d_number, "gold"],
	        ["5일", e_number, "gold"],
	        ["6일", f_number, "gold"],
	        ["7일", g_number, "gold"],
	        ["8일", h_number, "gold"],
	        ["9일", i_number, "gold"],
	        ["10일", j_number, "gold"],
	        //["최종 관객수 예측", final, "gold"]
	      ]);
	
	      // 최종관객수 예측 = a_number * -19.512268 + c_number * 23.792802 + d_number * -16.049622 + e_number * 23.026657 + j_number * 6.041480
	      
	      var view = new google.visualization.DataView(data);
	      view.setColumns([0, 1,
	                       { calc: "stringify",
	                         sourceColumn: 1,
	                         type: "string",
	                         role: "annotation" },
	                       2]);
	
	      var options = {
	        title: "  ",
	        width: 900,
	        height: 600,
	        bar: {groupWidth: "95%"},
	        legend: { position: "none" },
	      };
	      var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
	      chart.draw(view, options);
	      
	      
	     $('#score_values').html(final);
	  }
	  </script>
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
          <h1>최종 관객수 예측 <small></small></h1>
		<span>'${movie_name}' 최종 관객수 예측 결과 :</span>
		<span id="score_values" ></span>
		<div id="columnchart_values" style="width: 900px; height: 600px;" ></div>
  		
  	</body>
</html>