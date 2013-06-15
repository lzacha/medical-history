
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
					
						<g:sortableColumn property="antecedentDetailId" title="${message(code: 'antecedentDetail.antecedentDetailId.label', default: 'Antecedent Detail Id')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'antecedentDetail.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="internalCode" title="${message(code: 'antecedentDetail.internalCode.label', default: 'Internal Code')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${antecedentDetailInstanceList}" status="i" var="antecedentDetailInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${antecedentDetailInstance.id}">${fieldValue(bean: antecedentDetailInstance, field: "antecedentDetailId")}</g:link></td>
					
						<td>${fieldValue(bean: antecedentDetailInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: antecedentDetailInstance, field: "internalCode")}</td>
					
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
