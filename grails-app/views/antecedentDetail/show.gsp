
<%@ page import="medicalhistory.AntecedentDetail" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'antecedentDetail.label', default: 'AntecedentDetail')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-antecedentDetail" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-antecedentDetail" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list antecedentDetail">
			
				<g:if test="${antecedentDetailInstance?.antecedentDetailId}">
				<li class="fieldcontain">
					<span id="antecedentDetailId-label" class="property-label"><g:message code="antecedentDetail.antecedentDetailId.label" default="Antecedent Detail Id" /></span>
					
						<span class="property-value" aria-labelledby="antecedentDetailId-label"><g:fieldValue bean="${antecedentDetailInstance}" field="antecedentDetailId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${antecedentDetailInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="antecedentDetail.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${antecedentDetailInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${antecedentDetailInstance?.internalCode}">
				<li class="fieldcontain">
					<span id="internalCode-label" class="property-label"><g:message code="antecedentDetail.internalCode.label" default="Internal Code" /></span>
					
						<span class="property-value" aria-labelledby="internalCode-label"><g:fieldValue bean="${antecedentDetailInstance}" field="internalCode"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${antecedentDetailInstance?.id}" />
					<g:link class="edit" action="edit" id="${antecedentDetailInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
