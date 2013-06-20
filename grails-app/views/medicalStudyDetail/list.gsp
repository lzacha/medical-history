
<%@ page import="medicalhistory.MedicalStudyDetail" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'medicalStudyDetail.label', default: 'MedicalStudyDetail')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-medicalStudyDetail" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-medicalStudyDetail" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="abbreviation" title="${message(code: 'medicalStudyDetail.abbreviation.label', default: 'Abbreviation')}" />
					
						<th><g:message code="medicalStudyDetail.ageRange.label" default="Age Range" /></th>
					
						<g:sortableColumn property="completeName" title="${message(code: 'medicalStudyDetail.completeName.label', default: 'Complete Name')}" />
					
						<g:sortableColumn property="decimalsQuantity" title="${message(code: 'medicalStudyDetail.decimalsQuantity.label', default: 'Decimals Quantity')}" />
					
						<th><g:message code="medicalStudyDetail.fieldType.label" default="Field Type" /></th>
					
						<g:sortableColumn property="maxValue" title="${message(code: 'medicalStudyDetail.maxValue.label', default: 'Max Value')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${medicalStudyDetailInstanceList}" status="i" var="medicalStudyDetailInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${medicalStudyDetailInstance.id}">${fieldValue(bean: medicalStudyDetailInstance, field: "abbreviation")}</g:link></td>
					
						<td>${fieldValue(bean: medicalStudyDetailInstance, field: "ageRange")}</td>
					
						<td>${fieldValue(bean: medicalStudyDetailInstance, field: "completeName")}</td>
					
						<td>${fieldValue(bean: medicalStudyDetailInstance, field: "decimalsQuantity")}</td>
					
						<td>${fieldValue(bean: medicalStudyDetailInstance, field: "fieldType")}</td>
					
						<td>${fieldValue(bean: medicalStudyDetailInstance, field: "maxValue")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${medicalStudyDetailInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
