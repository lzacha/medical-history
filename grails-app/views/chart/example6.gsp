<%--
  Created by IntelliJ IDEA.
  User: lzacharewicz
  Date: 8/6/14
  Time: 6:20 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["treemap"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        // Create and populate the data table.
        var data = google.visualization.arrayToDataTable([
          ['Location', 'Parent', 'Market trade volume (size)'],
		  [' ',    null,                 0],
          ['Entre 56 y 65',' ',            13],
          ['Entre 66 y 75', ' ',            6],
          ['Entre 46 y 55',    ' ',            4],
          ['Mayor a 75',    ' ',            8],
          ['Entre 26 y 35',   ' ',             3],
          ['Entre 36 y 45',   ' ',             1]
        ]);

        // Create and draw the visualization.
        var tree = new google.visualization.TreeMap(document.getElementById('chart_div'));
        tree.draw(data, {
          title: 'Antecedente DBT por Rango de Edad',
		  minColor: '#f00',
          midColor: '#dfd',
          maxColor: '#0d0',
          headerHeight: 15,
          fontColor: 'black',
          showScale: false});
        }
    </script>
  </head>

  <body>
    <div id="chart_div" style="width: 900px; height: 500px;"></div>
  </body>
</html>