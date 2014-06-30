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
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var dataH = google.visualization.arrayToDataTable([
          ['Rango de Edad', 'Pacientes'],
          ['Entre 26 y 35',     1],
          ['Entre 46 y 55',      2],
          ['Entre 56 y 65',  9],
          ['Entre 66 y 75', 2],
          ['Mayor a 75',    2]
        ]);


        var dataM = google.visualization.arrayToDataTable([
          ['Rango de Edad', 'Pacientes'],
          ['Entre 36 y 45',     1],
          ['Entre 46 y 55',      2],
          ['Entre 56 y 65',  4],
          ['Entre 66 y 75', 4]
        ]);


        var options = {
          title: 'Hombre'
        };

        var chartH = new google.visualization.PieChart(document.getElementById('piechartH'));
        chartH.draw(dataH, options);

        options = {
          title: 'Mujer'
        };


        var chartM = new google.visualization.PieChart(document.getElementById('piechartM'));
        chartM.draw(dataM, options);

	  
	  }
    </script>
  </head>
  <body>
  <table border=0 >
  
  <tr>

  <td colspan="2"><font face="Arial"><h3>Antecedentes DBT por Sexo</h3></font></td>
  </tr>
  <tr>

  <td width= "500px" >
	<div id="piechartH" style="width: 500px; height: 500px;"></div>
  </td>
  <td width= "500px" style ="border-left:solid">
	<div id="piechartM" style="width: 500px; height: 500px;"></div>
  </td>
  </tr>
  </table>
  </body>
</html>