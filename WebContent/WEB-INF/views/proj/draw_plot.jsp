<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
	<script type="text/javascript"
		src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript">
	    google.charts.load("current", {packages:['corechart']});
	    google.charts.setOnLoadCallback(drawChart);
	    function drawChart() {
	      var data = google.visualization.arrayToDataTable([
	        ["개봉 후 일수", "관객수", { role: "style" } ],
	        ["1일", 130.94, "color: #e5e4e2"],
	        ["2일", 220.49, "color: #e5e4e2"],
	        ["3일", 809.30, "color: #e5e4e2"],
	        ["4일", 190.30, "color: #e5e4e2"],
	        ["5일", 224.30, "color: #e5e4e2"],
	        ["6일", 255.30, "color: #e5e4e2"],
	        ["7일", 144.30, "color: #e5e4e2"],
	        ["8일", 133.30, "color: #e5e4e2"],
	        ["9일", 366.30, "color: #e5e4e2"],
	        ["10일", 135.30, "color: #e5e4e2"],
	        ["최종 관객수 예측", 1341.45, "gold"]
	      ]);
	
	      var view = new google.visualization.DataView(data);
	      view.setColumns([0, 1,
	                       { calc: "stringify",
	                         sourceColumn: 1,
	                         type: "string",
	                         role: "annotation" },
	                       2]);
	
	      var options = {
	        title: "영화 최종 관객수 예측",
	        width: 1200,
	        height: 800,
	        bar: {groupWidth: "95%"},
	        legend: { position: "none" },
	      };
	      var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
	      chart.draw(view, options);
	  }
	  </script>
</head>
	<body>
		<div id="columnchart_values" style="width: 900px; height: 300px;"></div>
  	</body>
</html>