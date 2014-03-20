<%@ page import="medicalhistory.Units" %>



<div class="fieldcontain ${hasErrors(bean: unitsInstance, field: 'desc', 'error')} ">
	<label for="desc">
		<g:message code="units.desc.label" default="Desc" />
		
	</label>
	<g:textField name="desc" value="${unitsInstance?.desc}"/>
</div>

