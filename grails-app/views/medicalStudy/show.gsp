
<%@ page import="medicalhistory.MedicalStudy" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'medicalStudy.label', default: 'MedicalStudy')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-medicalStudy" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-medicalStudy" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list medicalStudy">
			
				<g:if test="${medicalStudyInstance?.abdominalDiameter}">
				<li class="fieldcontain">
					<span id="abdominalDiameter-label" class="property-label"><g:message code="medicalStudy.abdominalDiameter.label" default="Abdominal Diameter" /></span>
					
						<span class="property-value" aria-labelledby="abdominalDiameter-label"><g:fieldValue bean="${medicalStudyInstance}" field="abdominalDiameter"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${medicalStudyInstance?.doctor}">
				<li class="fieldcontain">
					<span id="doctor-label" class="property-label"><g:message code="medicalStudy.doctor.label" default="Doctor" /></span>
					
						<span class="property-value" aria-labelledby="doctor-label"><g:link controller="doctor" action="show" id="${medicalStudyInstance?.doctor?.id}">${medicalStudyInstance?.doctor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${medicalStudyInstance?.height}">
				<li class="fieldcontain">
					<span id="height-label" class="property-label"><g:message code="medicalStudy.height.label" default="Height" /></span>
					
						<span class="property-value" aria-labelledby="height-label"><g:fieldValue bean="${medicalStudyInstance}" field="height"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${medicalStudyInstance?.mainStudyType}">
				<li class="fieldcontain">
					<span id="mainStudyType-label" class="property-label"><g:message code="medicalStudy.mainStudyType.label" default="Main Study Type" /></span>
					
						<span class="property-value" aria-labelledby="mainStudyType-label"><g:link controller="mainStudyType" action="show" id="${medicalStudyInstance?.mainStudyType?.id}">${medicalStudyInstance?.mainStudyType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${medicalStudyInstance?.patient}">
				<li class="fieldcontain">
					<span id="patient-label" class="property-label"><g:message code="medicalStudy.patient.label" default="Patient" /></span>
					
						<span class="property-value" aria-labelledby="patient-label"><g:link controller="patient" action="show" id="${medicalStudyInstance?.patient?.id}">${medicalStudyInstance?.patient?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${medicalStudyInstance?.studyDate}">
				<li class="fieldcontain">
					<span id="studyDate-label" class="property-label"><g:message code="medicalStudy.studyDate.label" default="Study Date" /></span>
					
						<span class="property-value" aria-labelledby="studyDate-label"><g:formatDate date="${medicalStudyInstance?.studyDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${medicalStudyInstance?.weight}">
				<li class="fieldcontain">
					<span id="weight-label" class="property-label"><g:message code="medicalStudy.weight.label" default="Weight" /></span>
					
						<span class="property-value" aria-labelledby="weight-label"><g:fieldValue bean="${medicalStudyInstance}" field="weight"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${medicalStudyInstance?.id}" />
					<g:link class="edit" action="edit" id="${medicalStudyInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
