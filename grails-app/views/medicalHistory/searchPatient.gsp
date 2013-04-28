<%--
  Created by IntelliJ IDEA.
  User: lzacharewicz
  Date: 27/1/13
  Time: 9:45 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Buscar Paciente</title>
</head>
<body>
    <h1>Buscar Paciente</h1>

    <form id="example_form" action="#" method="GET" class="ch-form">
        <div class="ch-form-row">
            <label for="autocomplete">Paciente:</label>
            <input id="autocomplete"
                   type="text"
                   name="autocomplete"
                   placeholder="Nombre del paciente"
                   class="autoComplete_Example ch-autoComplete"
            />
            <input type="submit" value="Buscar">
        </div>
    </form>


</body>
</html>