<%@ page import="medicalhistory.FieldType" %>



<div class="fieldcontain ${hasErrors(bean: fieldTypeInstance, field: 'fieldName', 'error')} ">
	<label for="fieldName">
		<g:message code="fieldType.fieldName.label" default="Field Name" />
		
	</label>
	<g:textField name="fieldName" value="${fieldTypeInstance?.fieldName}"/>
</div>

