<%@ page import="medicalhistory.AntecedentDetail" %>



<div class="fieldcontain ${hasErrors(bean: antecedentDetailInstance, field: 'antecedentDetailId', 'error')} required">
	<label for="antecedentDetailId">
		<g:message code="antecedentDetail.antecedentDetailId.label" default="Antecedent Detail Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="antecedentDetailId" type="number" value="${antecedentDetailInstance.antecedentDetailId}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: antecedentDetailInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="antecedentDetail.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${antecedentDetailInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: antecedentDetailInstance, field: 'internalCode', 'error')} ">
	<label for="internalCode">
		<g:message code="antecedentDetail.internalCode.label" default="Internal Code" />
		
	</label>
	<g:textField name="internalCode" value="${antecedentDetailInstance?.internalCode}"/>
</div>

