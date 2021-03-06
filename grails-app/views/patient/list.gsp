
<%@ page import="medicalhistory.Patient" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'patient.label', default: 'Patient')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-patient" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-patient" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="abdominalDiameter" title="${message(code: 'patient.abdominalDiameter.label', default: 'Abdominal Diameter')}" />
					
						<g:sortableColumn property="birthDate" title="${message(code: 'patient.birthDate.label', default: 'Birth Date')}" />
					
						<g:sortableColumn property="firstName" title="${message(code: 'patient.firstName.label', default: 'First Name')}" />
					
						<g:sortableColumn property="height" title="${message(code: 'patient.height.label', default: 'Height')}" />
					
						<g:sortableColumn property="lastName" title="${message(code: 'patient.lastName.label', default: 'Last Name')}" />
					
						<g:sortableColumn property="medicalHistory" title="${message(code: 'patient.medicalHistory.label', default: 'Medical History')}" />
					
						<g:sortableColumn property="patientId" title="${message(code: 'patient.patientId.label', default: 'Patient Id')}" />
					
						<g:sortableColumn property="sex" title="${message(code: 'patient.sex.label', default: 'Sex')}" />
					
						<g:sortableColumn property="weight" title="${message(code: 'patient.weight.label', default: 'Weight')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${patientInstanceList}" status="i" var="patientInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${patientInstance.id}">${fieldValue(bean: patientInstance, field: "abdominalDiameter")}</g:link></td>
					
						<td><g:formatDate date="${patientInstance.birthDate}" /></td>
					
						<td>${fieldValue(bean: patientInstance, field: "firstName")}</td>
					
						<td>${fieldValue(bean: patientInstance, field: "height")}</td>
					
						<td>${fieldValue(bean: patientInstance, field: "lastName")}</td>
					
						<td>${fieldValue(bean: patientInstance, field: "medicalHistory")}</td>
					
						<td>${fieldValue(bean: patientInstance, field: "patientId")}</td>
					
						<td>${fieldValue(bean: patientInstance, field: "sex")}</td>
					
						<td>${fieldValue(bean: patientInstance, field: "weight")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${patientInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
