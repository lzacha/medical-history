
<%@ page import="medicalhistory.TreatmentValue" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'treatmentValue.label', default: 'TreatmentValue')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-treatmentValue" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-treatmentValue" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="treatmentValue.frequency.label" default="Frequency" /></th>
					
						<th><g:message code="treatmentValue.patient.label" default="Patient" /></th>
					
						<th><g:message code="treatmentValue.treatmentDetail.label" default="Treatment Detail" /></th>
					
						<g:sortableColumn property="treatmentValue" title="${message(code: 'treatmentValue.treatmentValue.label', default: 'Treatment Value')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${treatmentValueInstanceList}" status="i" var="treatmentValueInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${treatmentValueInstance.id}">${fieldValue(bean: treatmentValueInstance, field: "frequency")}</g:link></td>
					
						<td>${fieldValue(bean: treatmentValueInstance, field: "patient")}</td>
					
						<td>${fieldValue(bean: treatmentValueInstance, field: "treatmentDetail")}</td>
					
						<td>${fieldValue(bean: treatmentValueInstance, field: "treatmentValue")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${treatmentValueInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
