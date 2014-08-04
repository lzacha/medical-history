
<%@ page import="medicalhistory.StudyTypesTable" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'studyTypesTable.label', default: 'StudyTypesTable')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-studyTypesTable" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-studyTypesTable" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="studyTypesTable.patient.label" default="Patient" /></th>
					
						<g:sortableColumn property="studyDate" title="${message(code: 'studyTypesTable.studyDate.label', default: 'Study Date')}" />
					
						<g:sortableColumn property="studyType" title="${message(code: 'studyTypesTable.studyType.label', default: 'Study Type')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${studyTypesTableInstanceList}" status="i" var="studyTypesTableInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${studyTypesTableInstance.id}">${fieldValue(bean: studyTypesTableInstance, field: "patient")}</g:link></td>
					
						<td><g:formatDate date="${studyTypesTableInstance.studyDate}" /></td>
					
						<td>${fieldValue(bean: studyTypesTableInstance, field: "studyType")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${studyTypesTableInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
