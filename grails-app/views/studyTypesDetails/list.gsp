
<%@ page import="medicalhistory.StudyTypesDetails" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'studyTypesDetails.label', default: 'StudyTypesDetails')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-studyTypesDetails" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-studyTypesDetails" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="abbreviation" title="${message(code: 'studyTypesDetails.abbreviation.label', default: 'Abbreviation')}" />
					
						<g:sortableColumn property="completeName" title="${message(code: 'studyTypesDetails.completeName.label', default: 'Complete Name')}" />
					
						<g:sortableColumn property="decimalsQuantity" title="${message(code: 'studyTypesDetails.decimalsQuantity.label', default: 'Decimals Quantity')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'studyTypesDetails.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="maxRange" title="${message(code: 'studyTypesDetails.maxRange.label', default: 'Max Range')}" />
					
						<g:sortableColumn property="minRange" title="${message(code: 'studyTypesDetails.minRange.label', default: 'Min Range')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${studyTypesDetailsInstanceList}" status="i" var="studyTypesDetailsInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${studyTypesDetailsInstance.id}">${fieldValue(bean: studyTypesDetailsInstance, field: "abbreviation")}</g:link></td>
					
						<td>${fieldValue(bean: studyTypesDetailsInstance, field: "completeName")}</td>
					
						<td>${fieldValue(bean: studyTypesDetailsInstance, field: "decimalsQuantity")}</td>
					
						<td>${fieldValue(bean: studyTypesDetailsInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: studyTypesDetailsInstance, field: "maxRange")}</td>
					
						<td>${fieldValue(bean: studyTypesDetailsInstance, field: "minRange")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${studyTypesDetailsInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
