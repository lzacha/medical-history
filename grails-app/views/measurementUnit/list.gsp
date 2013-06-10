
<%@ page import="medicalhistory.MeasurementUnit" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'measurementUnit.label', default: 'MeasurementUnit')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
        <!-- chico-ui css-->
        <link rel="stylesheet" href="/medical-history/static/css/chico-ui/css/chico-min-0.13.1.css" type="text/css">
        <link rel="stylesheet" href="/medical-history/static/css/chico-ui/css/mesh-min-2.1.css" type="text/css">
	</head>
	<body>
		<div id="list-measurementUnit" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${measurementUnitInstanceList}" status="i" var="measurementUnitInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${measurementUnitInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
