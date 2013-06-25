<div>
    <g:form name="myForm" url="[action:'validate',controller:'medicalLogin']">
      <table>
        <tr>
          <td><label>Usuario:</label></td>
          <td><input type="text" name="username" required="required" id="username"></td>
        </tr>
        <tr>
          <td><label>Clave:</label></td>
          <td><input type="password" name="password" required="required" id="password"></td>
        </tr>
        <tr>
          <td><input type="submit" value="Ingresar" class="ch-btn ch-btn-small"></td>
          <td></td>
        </tr>
      </table>
    </g:form>
</div>

<script>
    //var user = $("#username").required("The field must be completed").validate();
    //var pass = $("#password").required("The field must be completed").validate();
</script>
