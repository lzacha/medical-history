
<%@ page import="medicalhistory.Philiatory" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'philiatory.label', default: 'Philiatory')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-philiatory" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-philiatory" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="abdominalDiameter" title="${message(code: 'philiatory.abdominalDiameter.label', default: 'Abdominal Diameter')}" />
					
						<g:sortableColumn property="height" title="${message(code: 'philiatory.height.label', default: 'Height')}" />
					
						<th><g:message code="philiatory.patient.label" default="Patient" /></th>
					
						<g:sortableColumn property="weight" title="${message(code: 'philiatory.weight.label', default: 'Weight')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${philiatoryInstanceList}" status="i" var="philiatoryInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${philiatoryInstance.id}">${fieldValue(bean: philiatoryInstance, field: "abdominalDiameter")}</g:link></td>
					
						<td>${fieldValue(bean: philiatoryInstance, field: "height")}</td>
					
						<td>${fieldValue(bean: philiatoryInstance, field: "patient")}</td>
					
						<td>${fieldValue(bean: philiatoryInstance, field: "weight")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${philiatoryInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
