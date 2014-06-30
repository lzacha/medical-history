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
          ['Year', 'DgHTA', 'HTAL', 'RCVC'],
          ['2002 - Hombre',  100,      40, 33],
          ['2002 - Mujer',  50,      20, 43],
          ['2003 - Hombre',  17,      60,67],
          ['2003 - Mujer',  37,      40,27],
          ['2004 - Hombre',  20,       11,86],
          ['2004 - Mujer',  29,       21,56],
          ['2005 - Hombre',  30,      20,50],
          ['2005 - Mujer',  10,      40,20]
        ]);

        var chart = new google.visualization.ImageBarChart(document.getElementById('chart_div'));
        chart.draw(data, {title: 'Evolucion Anual por Tipo de Estudio' , width: 900, height: 350, min: 0, isVertical:true} );
      }
    </script>
  </head>

  <body>
    <div id="chart_div"></div>
  </body>
</html>

<script>

    // Using YQL and JSONP
    $.ajax({
        url: "http://localhost:8080/medical-history/medicalHistoryJson/patient/1",

        jsonp: "callback",

        dataType: "jsonp",

        // work with the response
        success: function( response ) {
            console.log( response ); // server response
        }
    });

</script>

