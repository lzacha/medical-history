
<g:each in="${inputs}">
    id: ${it}<g:textField name="PID_${it}" value="" /><br>
</g:each>
<g:submitButton name="update" value="Update" />
