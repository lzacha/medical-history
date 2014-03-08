
<%@ page import="medicalhistory.AgeRanges" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'ageRanges.label', default: 'AgeRanges')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-ageRanges" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-ageRanges" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="maxValue" title="${message(code: 'ageRanges.maxValue.label', default: 'Max Value')}" />
					
						<g:sortableColumn property="minValue" title="${message(code: 'ageRanges.minValue.label', default: 'Min Value')}" />
					
						<g:sortableColumn property="rangeDescription" title="${message(code: 'ageRanges.rangeDescription.label', default: 'Range Description')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${ageRangesInstanceList}" status="i" var="ageRangesInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${ageRangesInstance.id}">${fieldValue(bean: ageRangesInstance, field: "maxValue")}</g:link></td>
					
						<td>${fieldValue(bean: ageRangesInstance, field: "minValue")}</td>
					
						<td>${fieldValue(bean: ageRangesInstance, field: "rangeDescription")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${ageRangesInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
