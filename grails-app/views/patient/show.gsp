
		<div id="show-patient" class="content scaffold-show" role="main">
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list patient">
			
				<g:if test="${patientInstance?.firstName}">
				<li class="fieldcontain">
					<span id="firstName-label" class="property-label"><g:message code="patient.firstName.label" default="First Name" /></span>
					
						<span class="property-value" aria-labelledby="firstName-label"><g:fieldValue bean="${patientInstance}" field="firstName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${patientInstance?.lastName}">
				<li class="fieldcontain">
					<span id="lastName-label" class="property-label"><g:message code="patient.lastName.label" default="Last Name" /></span>
					
						<span class="property-value" aria-labelledby="lastName-label"><g:fieldValue bean="${patientInstance}" field="lastName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${patientInstance?.sexId}">
				<li class="fieldcontain">
					<span id="sexId-label" class="property-label"><g:message code="patient.sexId.label" default="Sex Id" /></span>
					
						<span class="property-value" aria-labelledby="sexId-label"><g:fieldValue bean="${patientInstance}" field="sexId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${patientInstance?.birthDate}">
				<li class="fieldcontain">
					<span id="birthDate-label" class="property-label"><g:message code="patient.birthDate.label" default="Birth Date" /></span>
					
						<span class="property-value" aria-labelledby="birthDate-label"><g:formatDate date="${patientInstance?.birthDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${patientInstance?.abdominalDiameter}">
				<li class="fieldcontain">
					<span id="abdominalDiameter-label" class="property-label"><g:message code="patient.abdominalDiameter.label" default="Abdominal Diameter" /></span>
					
						<span class="property-value" aria-labelledby="abdominalDiameter-label"><g:fieldValue bean="${patientInstance}" field="abdominalDiameter"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${patientInstance?.height}">
				<li class="fieldcontain">
					<span id="height-label" class="property-label"><g:message code="patient.height.label" default="Height" /></span>
					
						<span class="property-value" aria-labelledby="height-label"><g:fieldValue bean="${patientInstance}" field="height"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${patientInstance?.medicalHistory}">
				<li class="fieldcontain">
					<span id="medicalHistory-label" class="property-label"><g:message code="patient.medicalHistory.label" default="Medical History" /></span>
					
						<span class="property-value" aria-labelledby="medicalHistory-label"><g:fieldValue bean="${patientInstance}" field="medicalHistory"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${patientInstance?.patientId}">
				<li class="fieldcontain">
					<span id="patientId-label" class="property-label"><g:message code="patient.patientId.label" default="Patient Id" /></span>
					
						<span class="property-value" aria-labelledby="patientId-label"><g:fieldValue bean="${patientInstance}" field="patientId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${patientInstance?.weight}">
				<li class="fieldcontain">
					<span id="weight-label" class="property-label"><g:message code="patient.weight.label" default="Weight" /></span>
					
						<span class="property-value" aria-labelledby="weight-label"><g:fieldValue bean="${patientInstance}" field="weight"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${patientInstance?.id}" />
					<g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" />
                    <g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
			</g:form>
		</div>
