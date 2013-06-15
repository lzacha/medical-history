
<%@ page import="medicalhistory.Patient" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'patient.label', default: 'Patient')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		    <style>

    body {
        color: #333333;
        font: 13px/20px Arial,Helvetica,"Nimbus Sans L",sans-serif;
    }

    .ch-box {
        border: 1px solid #ccc;
        padding: 10px;
        margin: 10px auto;
    }

    .ch-header {
        height: 50px;
        padding: 20px 10px;
        background: #eee;
        margin: 10px auto 0px;
    }

    .ch-footer {
        clear:both;
        text-align: center;
        margin: 10px auto;
        background: #eee;

    }
    </style>

    <!-- chico-ui css-->
    <link rel="stylesheet" href="${resource(dir: 'css/chico-ui/css', file: 'chico-min-0.13.1.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css/chico-ui/css', file: 'mesh-min-2.1.css')}" type="text/css">

	</head>
	<body>
		<a href="#list-patient" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-patient" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="birthDate" title="${message(code: 'patient.birthDate.label', default: 'Birth Date')}" />
					
						<g:sortableColumn property="firstName" title="${message(code: 'patient.firstName.label', default: 'First Name')}" />
					
						<g:sortableColumn property="lastName" title="${message(code: 'patient.lastName.label', default: 'Last Name')}" />
					
						<g:sortableColumn property="patientId" title="${message(code: 'patient.patientId.label', default: 'Patient Id')}" />
					
						<g:sortableColumn property="sexId" title="${message(code: 'patient.sexId.label', default: 'Sex Id')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${patientInstanceList}" status="i" var="patientInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${patientInstance.id}">${fieldValue(bean: patientInstance, field: "birthDate")}</g:link></td>
					
						<td>${fieldValue(bean: patientInstance, field: "firstName")}</td>
					
						<td>${fieldValue(bean: patientInstance, field: "lastName")}</td>
					
						<td>${fieldValue(bean: patientInstance, field: "patientId")}</td>
					
						<td>${fieldValue(bean: patientInstance, field: "sexId")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${patientInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
