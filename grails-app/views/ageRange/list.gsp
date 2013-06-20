
<%@ page import="medicalhistory.AgeRange" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'ageRange.label', default: 'AgeRange')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-ageRange" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-ageRange" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="rangeDescription" title="${message(code: 'ageRange.rangeDescription.label', default: 'Range Description')}" />
					
						<g:sortableColumn property="minValue" title="${message(code: 'ageRange.minValue.label', default: 'Min Value')}" />
					
						<g:sortableColumn property="maxValue" title="${message(code: 'ageRange.maxValue.label', default: 'Max Value')}" />
					
						<g:sortableColumn property="sex" title="${message(code: 'ageRange.sex.label', default: 'Sex')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${ageRangeInstanceList}" status="i" var="ageRangeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${ageRangeInstance.id}">${fieldValue(bean: ageRangeInstance, field: "rangeDescription")}</g:link></td>
					
						<td>${fieldValue(bean: ageRangeInstance, field: "minValue")}</td>
					
						<td>${fieldValue(bean: ageRangeInstance, field: "maxValue")}</td>
					
						<td>${fieldValue(bean: ageRangeInstance, field: "sex")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${ageRangeInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
