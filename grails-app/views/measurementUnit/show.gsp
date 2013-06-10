
<%@ page import="medicalhistory.MeasurementUnit" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'measurementUnit.label', default: 'MeasurementUnit')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
        <!-- chico-ui css-->
        <link rel="stylesheet" href="/medical-history/static/css/chico-ui/css/chico-min-0.13.1.css" type="text/css">
        <link rel="stylesheet" href="/medical-history/static/css/chico-ui/css/mesh-min-2.1.css" type="text/css">
	</head>
	<body>
		<div id="show-measurementUnit" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list measurementUnit">
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${measurementUnitInstance?.id}" />
					<g:link class="edit" action="edit" id="${measurementUnitInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
