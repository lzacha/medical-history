
<%@ page import="medicalhistory.StudyTypesDetail" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'studyTypesDetail.label', default: 'StudyTypesDetail')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-studyTypesDetail" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-studyTypesDetail" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="abbreviation" title="${message(code: 'studyTypesDetail.abbreviation.label', default: 'Abbreviation')}" />
					
						<g:sortableColumn property="completeName" title="${message(code: 'studyTypesDetail.completeName.label', default: 'Complete Name')}" />
					
						<g:sortableColumn property="decimalsQuantity" title="${message(code: 'studyTypesDetail.decimalsQuantity.label', default: 'Decimals Quantity')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'studyTypesDetail.description.label', default: 'Description')}" />
					
						<th><g:message code="studyTypesDetail.fieldType.label" default="Field Type" /></th>
					
						<g:sortableColumn property="maxRange" title="${message(code: 'studyTypesDetail.maxRange.label', default: 'Max Range')}" />
					
						<th><g:message code="studyTypesDetail.measurementUnit.label" default="Measurement Unit" /></th>
					
						<g:sortableColumn property="minRange" title="${message(code: 'studyTypesDetail.minRange.label', default: 'Min Range')}" />
					
						<th><g:message code="studyTypesDetail.studyTypes.label" default="Study Types" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${studyTypesDetailInstanceList}" status="i" var="studyTypesDetailInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${studyTypesDetailInstance.id}">${fieldValue(bean: studyTypesDetailInstance, field: "abbreviation")}</g:link></td>
					
						<td>${fieldValue(bean: studyTypesDetailInstance, field: "completeName")}</td>
					
						<td>${fieldValue(bean: studyTypesDetailInstance, field: "decimalsQuantity")}</td>
					
						<td>${fieldValue(bean: studyTypesDetailInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: studyTypesDetailInstance, field: "fieldType")}</td>
					
						<td>${fieldValue(bean: studyTypesDetailInstance, field: "maxRange")}</td>
					
						<td>${fieldValue(bean: studyTypesDetailInstance, field: "measurementUnit")}</td>
					
						<td>${fieldValue(bean: studyTypesDetailInstance, field: "minRange")}</td>
					
						<td>${fieldValue(bean: studyTypesDetailInstance, field: "studyTypes")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${studyTypesDetailInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
