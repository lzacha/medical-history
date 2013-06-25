
<%@ page import="medicalhistory.StudyType" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'studyType.label', default: 'StudyType')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-studyType" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-studyType" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="description" title="${message(code: 'studyType.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="shortDescription" title="${message(code: 'studyType.shortDescription.label', default: 'Short Description')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${studyTypeInstanceList}" status="i" var="studyTypeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${studyTypeInstance.id}">${fieldValue(bean: studyTypeInstance, field: "description")}</g:link></td>
					
						<td>${fieldValue(bean: studyTypeInstance, field: "shortDescription")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${studyTypeInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
