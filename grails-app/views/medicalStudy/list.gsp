
<%@ page import="medicalhistory.MedicalStudy" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'medicalStudy.label', default: 'MedicalStudy')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-medicalStudy" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-medicalStudy" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="medicalStudy.doctor.label" default="Doctor" /></th>
					
						<g:sortableColumn property="mainStudy" title="${message(code: 'medicalStudy.mainStudy.label', default: 'Main Study')}" />
					
						<th><g:message code="medicalStudy.patient.label" default="Patient" /></th>
					
						<g:sortableColumn property="studyDate" title="${message(code: 'medicalStudy.studyDate.label', default: 'Study Date')}" />
					
						<th><g:message code="medicalStudy.unit.label" default="Unit" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${medicalStudyInstanceList}" status="i" var="medicalStudyInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${medicalStudyInstance.id}">${fieldValue(bean: medicalStudyInstance, field: "doctor")}</g:link></td>
					
						<td>${fieldValue(bean: medicalStudyInstance, field: "mainStudy")}</td>
					
						<td>${fieldValue(bean: medicalStudyInstance, field: "patient")}</td>
					
						<td><g:formatDate date="${medicalStudyInstance.studyDate}" /></td>
					
						<td>${fieldValue(bean: medicalStudyInstance, field: "unit")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${medicalStudyInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
