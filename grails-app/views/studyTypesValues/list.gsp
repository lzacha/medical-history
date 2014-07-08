
<%@ page import="medicalhistory.StudyTypesValues" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'studyTypesValues.label', default: 'StudyTypesValues')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-studyTypesValues" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-studyTypesValues" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="studyTypesValues.patient.label" default="Patient" /></th>
					
						<g:sortableColumn property="studyTypeValue" title="${message(code: 'studyTypesValues.studyTypeValue.label', default: 'Study Type Value')}" />
					
						<th><g:message code="studyTypesValues.studyTypesDetail.label" default="Study Types Detail" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${studyTypesValuesInstanceList}" status="i" var="studyTypesValuesInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${studyTypesValuesInstance.id}">${fieldValue(bean: studyTypesValuesInstance, field: "patient")}</g:link></td>
					
						<td>${fieldValue(bean: studyTypesValuesInstance, field: "studyTypeValue")}</td>
					
						<td>${fieldValue(bean: studyTypesValuesInstance, field: "studyTypesDetail")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${studyTypesValuesInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
