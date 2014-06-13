

		<div id="list-medicalStudy" class="content scaffold-list" role="main">
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="abdominalDiameter" title="${message(code: 'medicalStudy.abdominalDiameter.label', default: 'Abdominal Diameter')}" />
					
						<th><g:message code="medicalStudy.doctor.label" default="Doctor" /></th>
					
						<g:sortableColumn property="height" title="${message(code: 'medicalStudy.height.label', default: 'Height')}" />
					
						<th><g:message code="medicalStudy.mainStudyType.label" default="Main Study Type" /></th>
					
						<th><g:message code="medicalStudy.patient.label" default="Patient" /></th>
					
						<g:sortableColumn property="studyDate" title="${message(code: 'medicalStudy.studyDate.label', default: 'Study Date')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${medicalStudyInstanceList}" status="i" var="medicalStudyInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${medicalStudyInstance.id}">${fieldValue(bean: medicalStudyInstance, field: "abdominalDiameter")}</g:link></td>
					
						<td>${fieldValue(bean: medicalStudyInstance, field: "doctor")}</td>
					
						<td>${fieldValue(bean: medicalStudyInstance, field: "height")}</td>
					
						<td>${fieldValue(bean: medicalStudyInstance, field: "mainStudyType")}</td>
					
						<td>${fieldValue(bean: medicalStudyInstance, field: "patient")}</td>
					
						<td><g:formatDate date="${medicalStudyInstance.studyDate}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${medicalStudyInstanceTotal}" />
			</div>
		</div>
