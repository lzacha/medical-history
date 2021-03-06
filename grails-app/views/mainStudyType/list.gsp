

		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-mainStudyType" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="description" title="${message(code: 'mainStudyType.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="mainStudyType" title="${message(code: 'mainStudyType.mainStudyType.label', default: 'Main Study Type')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${mainStudyTypeInstanceList}" status="i" var="mainStudyTypeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${mainStudyTypeInstance.id}">${fieldValue(bean: mainStudyTypeInstance, field: "description")}</g:link></td>
					
						<td>${fieldValue(bean: mainStudyTypeInstance, field: "mainStudyType")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${mainStudyTypeInstanceTotal}" />
			</div>
		</div>
