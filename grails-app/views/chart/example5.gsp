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
          ['ID', 'X', 'Y', 'Sexo', 'Pacientes'],
          ['Entre 26 y 35',    75,              2.67,      'Hombre',1],
          ['Entre 26 y 35',    60,              2.36,      'Mujer',1],
          ['Entre 36 y 45',    65,               2.84,      'Hombre',3],
          ['Entre 36 y 45',   70,              2.78,      'Mujer',5],
          ['Entre 46 y 55',   73,              2,         'Hombre',2],
          ['Entre 46 y 55',    67,              3.7,       'Mujer',4],
          ['Entre 56 y 65',    71,              4.47,      'Hombre',3],
          ['Entre 56 y 65',    78,              3.96,      'Mujer',5],
          ['Entre 66 y 75',    80,               3.54,      'Hombre',2],
          ['Entre 66 y 75',    79,              2.05,      'Mujer',5],
		  ['Mayor de 75',   63,               4,      'Hombre',3],
          ['Mayor de 75',    67,              2.05,      'Mujer',2]
        ]);

        var options = {
          title: 'Tratamiento BETA BLOQ por Sexo y Edad',
          hAxis: {textPosition: 'none'},
          vAxis: {textPosition: 'none'},
          bubble: {textStyle: {fontSize: 11}}, 
		  sizeAxis:  {minSize: 10,  maxSize: 50},
		  tooltip: {trigger: 'none'}
		  
        };

        var chart = new google.visualization.BubbleChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="chart_div" style="width: 900px; height: 500px;"></div>
  </body>
</html>	