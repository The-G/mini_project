<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
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
	  		
	    	var final = a_number * -19.512268 + c_number * 23.792802 + d_number * -16.049622 + e_number * 23.026657 + j_number * 6.041480
	  		
	      var data = google.visualization.arrayToDataTable([
	        ["개봉 후 일수", "관객수", { role: "style" } ],
	        ["1일", a_number, "color: #e5e4e2"],
	        ["2일", b_number, "color: #e5e4e2"],
	        ["3일", c_number, "color: #e5e4e2"],
	        ["4일", d_number, "color: #e5e4e2"],
	        ["5일", e_number, "color: #e5e4e2"],
	        ["6일", f_number, "color: #e5e4e2"],
	        ["7일", g_number, "color: #e5e4e2"],
	        ["8일", h_number, "color: #e5e4e2"],
	        ["9일", i_number, "color: #e5e4e2"],
	        ["10일", j_number, "color: #e5e4e2"],
	        ["최종 관객수 예측", final, "gold"]
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