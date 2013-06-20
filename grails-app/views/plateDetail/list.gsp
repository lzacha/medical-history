
<%@ page import="medicalhistory.PlateDetail" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'plateDetail.label', default: 'PlateDetail')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-plateDetail" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-plateDetail" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="fieldPlateDetail1" title="${message(code: 'plateDetail.fieldPlateDetail1.label', default: 'Field Plate Detail1')}" />
					
						<g:sortableColumn property="fieldPlateDetail2" title="${message(code: 'plateDetail.fieldPlateDetail2.label', default: 'Field Plate Detail2')}" />
					
						<g:sortableColumn property="fieldPlateDetail3" title="${message(code: 'plateDetail.fieldPlateDetail3.label', default: 'Field Plate Detail3')}" />
					
						<th><g:message code="plateDetail.plate.label" default="Plate" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${plateDetailInstanceList}" status="i" var="plateDetailInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${plateDetailInstance.id}">${fieldValue(bean: plateDetailInstance, field: "fieldPlateDetail1")}</g:link></td>
					
						<td>${fieldValue(bean: plateDetailInstance, field: "fieldPlateDetail2")}</td>
					
						<td>${fieldValue(bean: plateDetailInstance, field: "fieldPlateDetail3")}</td>
					
						<td>${fieldValue(bean: plateDetailInstance, field: "plate")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${plateDetailInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
