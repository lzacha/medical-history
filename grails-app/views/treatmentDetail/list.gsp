
<%@ page import="medicalhistory.TreatmentDetail" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'treatmentDetail.label', default: 'TreatmentDetail')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-treatmentDetail" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-treatmentDetail" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="abbreviation" title="${message(code: 'treatmentDetail.abbreviation.label', default: 'Abbreviation')}" />
					
						<g:sortableColumn property="completeName" title="${message(code: 'treatmentDetail.completeName.label', default: 'Complete Name')}" />
					
						<g:sortableColumn property="decimalsQuantity" title="${message(code: 'treatmentDetail.decimalsQuantity.label', default: 'Decimals Quantity')}" />
					
						<th><g:message code="treatmentDetail.fieldType.label" default="Field Type" /></th>
					
						<th><g:message code="treatmentDetail.measurementUnit.label" default="Measurement Unit" /></th>
					
						<g:sortableColumn property="treatmentType" title="${message(code: 'treatmentDetail.treatmentType.label', default: 'Treatment Type')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${treatmentDetailInstanceList}" status="i" var="treatmentDetailInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${treatmentDetailInstance.id}">${fieldValue(bean: treatmentDetailInstance, field: "abbreviation")}</g:link></td>
					
						<td>${fieldValue(bean: treatmentDetailInstance, field: "completeName")}</td>
					
						<td>${fieldValue(bean: treatmentDetailInstance, field: "decimalsQuantity")}</td>
					
						<td>${fieldValue(bean: treatmentDetailInstance, field: "fieldType")}</td>
					
						<td>${fieldValue(bean: treatmentDetailInstance, field: "measurementUnit")}</td>
					
						<td>${fieldValue(bean: treatmentDetailInstance, field: "treatmentType")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${treatmentDetailInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
