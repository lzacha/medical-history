<%@ page import="medicalhistory.Patient" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'patient.label', default: 'Patient')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
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
	
		<div id="edit-patient" class="content scaffold-edit" role="main">
			<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${patientInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${patientInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form method="post" >
				<g:hiddenField name="id" value="${patientInstance?.id}" />
				<g:hiddenField name="version" value="${patientInstance?.version}" />
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" formnovalidate="" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
