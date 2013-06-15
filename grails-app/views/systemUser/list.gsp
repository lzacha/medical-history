
<%@ page import="medicalhistory.SystemUser" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'systemUser.label', default: 'SystemUser')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-systemUser" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-systemUser" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="firstName" title="${message(code: 'systemUser.firstName.label', default: 'First Name')}" />
					
						<g:sortableColumn property="lastLogin" title="${message(code: 'systemUser.lastLogin.label', default: 'Last Login')}" />
					
						<g:sortableColumn property="lastName" title="${message(code: 'systemUser.lastName.label', default: 'Last Name')}" />
					
						<g:sortableColumn property="password" title="${message(code: 'systemUser.password.label', default: 'Password')}" />
					
						<g:sortableColumn property="role" title="${message(code: 'systemUser.role.label', default: 'Role')}" />
					
						<g:sortableColumn property="status" title="${message(code: 'systemUser.status.label', default: 'Status')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${systemUserInstanceList}" status="i" var="systemUserInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${systemUserInstance.id}">${fieldValue(bean: systemUserInstance, field: "firstName")}</g:link></td>
					
						<td><g:formatDate date="${systemUserInstance.lastLogin}" /></td>
					
						<td>${fieldValue(bean: systemUserInstance, field: "lastName")}</td>
					
						<td>${fieldValue(bean: systemUserInstance, field: "password")}</td>
					
						<td>${fieldValue(bean: systemUserInstance, field: "role")}</td>
					
						<td>${fieldValue(bean: systemUserInstance, field: "status")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${systemUserInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
