
<%@ page import="medicalhistory.ReferenceValue" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'referenceValue.label', default: 'ReferenceValue')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-referenceValue" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-referenceValue" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="referenceValue.ageRange.label" default="Age Range" /></th>
					
						<g:sortableColumn property="decimalQuantity" title="${message(code: 'referenceValue.decimalQuantity.label', default: 'Decimal Quantity')}" />
					
						<g:sortableColumn property="maxValue" title="${message(code: 'referenceValue.maxValue.label', default: 'Max Value')}" />
					
						<g:sortableColumn property="minValue" title="${message(code: 'referenceValue.minValue.label', default: 'Min Value')}" />
					
						<g:sortableColumn property="sex" title="${message(code: 'referenceValue.sex.label', default: 'Sex')}" />
					
						<th><g:message code="referenceValue.studyTypesDetails.label" default="Study Types Details" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${referenceValueInstanceList}" status="i" var="referenceValueInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${referenceValueInstance.id}">${fieldValue(bean: referenceValueInstance, field: "ageRange")}</g:link></td>
					
						<td>${fieldValue(bean: referenceValueInstance, field: "decimalQuantity")}</td>
					
						<td>${fieldValue(bean: referenceValueInstance, field: "maxValue")}</td>
					
						<td>${fieldValue(bean: referenceValueInstance, field: "minValue")}</td>
					
						<td>${fieldValue(bean: referenceValueInstance, field: "sex")}</td>
					
						<td>${fieldValue(bean: referenceValueInstance, field: "studyTypesDetails")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${referenceValueInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
