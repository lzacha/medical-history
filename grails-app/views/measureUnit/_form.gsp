<%@ page import="medicalhistory.MeasureUnit" %>



<div class="fieldcontain ${hasErrors(bean: measureUnitInstance, field: 'desc', 'error')} ">
	<label for="desc">
		<g:message code="measureUnit.desc.label" default="Desc" />
		
	</label>
	<g:textField name="desc" value="${measureUnitInstance?.desc}"/>
</div>

