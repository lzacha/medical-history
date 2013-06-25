
<%@ page import="medicalhistory.ValueReference" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'valueReference.label', default: 'ValueReference')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-valueReference" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-valueReference" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="valueReference.ageRange.label" default="Age Range" /></th>
					
						<g:sortableColumn property="decimalQuantity" title="${message(code: 'valueReference.decimalQuantity.label', default: 'Decimal Quantity')}" />
					
						<g:sortableColumn property="maxValue" title="${message(code: 'valueReference.maxValue.label', default: 'Max Value')}" />
					
						<g:sortableColumn property="minValue" title="${message(code: 'valueReference.minValue.label', default: 'Min Value')}" />
					
						<g:sortableColumn property="sex" title="${message(code: 'valueReference.sex.label', default: 'Sex')}" />
					
						<th><g:message code="valueReference.studyTypeDetail.label" default="Study Type Detail" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${valueReferenceInstanceList}" status="i" var="valueReferenceInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${valueReferenceInstance.id}">${fieldValue(bean: valueReferenceInstance, field: "ageRange")}</g:link></td>
					
						<td>${fieldValue(bean: valueReferenceInstance, field: "decimalQuantity")}</td>
					
						<td>${fieldValue(bean: valueReferenceInstance, field: "maxValue")}</td>
					
						<td>${fieldValue(bean: valueReferenceInstance, field: "minValue")}</td>
					
						<td>${fieldValue(bean: valueReferenceInstance, field: "sex")}</td>
					
						<td>${fieldValue(bean: valueReferenceInstance, field: "studyTypeDetail")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${valueReferenceInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
