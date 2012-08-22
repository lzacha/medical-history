<%--
  Created by IntelliJ IDEA.
  User: leozacha
  Date: 8/6/12
  Time: 11:12 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>

    <head>
        <!-- login/index.gsp  head -->
        <title>Login Title</title>
        <!-- login/index.gsp  head -->
    </head>

    <body>
        <!-- login/index.gsp  body -->

        <div>
        <g:form name="myForm" url="[action:'validate',controller:'login']">
            <label>Username:</label> <input type="text" name="username">
            <label>Password:</label> <input type="password" name="password">
            <input type="submit" value="login">
        </g:form>
        </div>
        <!-- login/index.gsp  body -->
    </body>

</html>