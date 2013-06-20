
<%@ page import="medicalhistory.Plate" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'plate.label', default: 'Plate')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-plate" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-plate" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="plate.doctor.label" default="Doctor" /></th>
					
						<g:sortableColumn property="fieldPlate2" title="${message(code: 'plate.fieldPlate2.label', default: 'Field Plate2')}" />
					
						<g:sortableColumn property="fieldPlate3" title="${message(code: 'plate.fieldPlate3.label', default: 'Field Plate3')}" />
					
						<g:sortableColumn property="imagePlate" title="${message(code: 'plate.imagePlate.label', default: 'Image Plate')}" />
					
						<g:sortableColumn property="observation" title="${message(code: 'plate.observation.label', default: 'Observation')}" />
					
						<g:sortableColumn property="plateDate" title="${message(code: 'plate.plateDate.label', default: 'Plate Date')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${plateInstanceList}" status="i" var="plateInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${plateInstance.id}">${fieldValue(bean: plateInstance, field: "doctor")}</g:link></td>
					
						<td>${fieldValue(bean: plateInstance, field: "fieldPlate2")}</td>
					
						<td>${fieldValue(bean: plateInstance, field: "fieldPlate3")}</td>
					
						<td>${fieldValue(bean: plateInstance, field: "imagePlate")}</td>
					
						<td>${fieldValue(bean: plateInstance, field: "observation")}</td>
					
						<td><g:formatDate date="${plateInstance.plateDate}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${plateInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
