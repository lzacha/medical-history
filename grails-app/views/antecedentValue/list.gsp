
<%@ page import="medicalhistory.AntecedentValue" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'antecedentValue.label', default: 'AntecedentValue')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-antecedentValue" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-antecedentValue" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="antecedentValue.antecedentDetail.label" default="Antecedent Detail" /></th>
					
						<g:sortableColumn property="antecedentValue" title="${message(code: 'antecedentValue.antecedentValue.label', default: 'Antecedent Value')}" />
					
						<th><g:message code="antecedentValue.patient.label" default="Patient" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${antecedentValueInstanceList}" status="i" var="antecedentValueInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${antecedentValueInstance.id}">${fieldValue(bean: antecedentValueInstance, field: "antecedentDetail")}</g:link></td>
					
						<td>${fieldValue(bean: antecedentValueInstance, field: "antecedentValue")}</td>
					
						<td>${fieldValue(bean: antecedentValueInstance, field: "patient")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${antecedentValueInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
