<g:form action="saveStudyTypesValues">

<g:each in="${inputs}">
    <p>id: ${it}</p><g:textField name="ST_${it}" value="" />
    
</g:each>
<g:submitButton name="update" value="Update" />
</g:form>
