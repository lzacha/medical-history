
<%@ page import="medicalhistory.AntecedentDetail" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'antecedentDetail.label', default: 'AntecedentDetail')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-antecedentDetail" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-antecedentDetail" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="abbreviation" title="${message(code: 'antecedentDetail.abbreviation.label', default: 'Abbreviation')}" />
					
						<g:sortableColumn property="antecedentStudyType" title="${message(code: 'antecedentDetail.antecedentStudyType.label', default: 'Antecedent Study Type')}" />
					
						<g:sortableColumn property="completeName" title="${message(code: 'antecedentDetail.completeName.label', default: 'Complete Name')}" />
					
						<g:sortableColumn property="decimalsQuantity" title="${message(code: 'antecedentDetail.decimalsQuantity.label', default: 'Decimals Quantity')}" />
					
						<th><g:message code="antecedentDetail.fieldType.label" default="Field Type" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${antecedentDetailInstanceList}" status="i" var="antecedentDetailInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${antecedentDetailInstance.id}">${fieldValue(bean: antecedentDetailInstance, field: "abbreviation")}</g:link></td>
					
						<td>${fieldValue(bean: antecedentDetailInstance, field: "antecedentStudyType")}</td>
					
						<td>${fieldValue(bean: antecedentDetailInstance, field: "completeName")}</td>
					
						<td>${fieldValue(bean: antecedentDetailInstance, field: "decimalsQuantity")}</td>
					
						<td>${fieldValue(bean: antecedentDetailInstance, field: "fieldType")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${antecedentDetailInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
