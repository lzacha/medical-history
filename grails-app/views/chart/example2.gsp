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
      google.load("visualization", "1", {packages:["imagebarchart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Tratamientos', 'Hombre', 'Mujer'],
          ['Beta Bloq',  40,      50],
          ['IECA',  30,      50],
          ['AAS',  35,       45],
          ['INH AT2',  31,      39]
        ]);

/*        var options = {
          title: 'Tratamientos por Sexo',
          vAxis: {title: 'Year',  titleTextStyle: {color: 'red'}}
        };

        var chart = new google.visualization.BarChart(document.getElementById('chart_div'));

        chart.draw(data, options);*/
        var chart = new google.visualization.ImageBarChart(document.getElementById('chart_div'));
        chart.draw(data, {title: 'Tratamientos por Sexo' , width: 600, height: 150, min: 0} );
      }
    </script>
  </head>
  <body>
    <div id="chart_div" style="width: 900px; height: 500px;"></div>
  </body>
</html>

