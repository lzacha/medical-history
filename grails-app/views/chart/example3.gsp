<%--
  Created by IntelliJ IDEA.
  User: lzacharewicz
  Date: 8/6/14
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
		  var data = google.visualization.arrayToDataTable([
			['x', 'Paciente A', 'Paciente B'],
			['Enero 2012',   101,       85],
			['Febrero 2012',   80,       105],
			['Marzo 2012',   78,       110],
			['Abril 2012',   98,       90],
			['Mayo 2012',   88,       82],
			['Junio 2012',   141,       85],
			['Julio 2012',   96,       80],
			['Agosto 2012',   100,       81],
			['Septiembre 2012',   110,       100],
			['Octubre 2012',   80,     98]
			
		  ]);

        var options = {
          title: 'Evolución de Glucosa Basal',
		  pointSize:5
        };

        var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="chart_div" style="width: 900px; height: 500px;"></div>
  </body>
</html>