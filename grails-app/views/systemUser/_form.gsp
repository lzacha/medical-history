<%@ page import="medicalhistory.SystemUser" %>



<div class="fieldcontain ${hasErrors(bean: systemUserInstance, field: 'firstName', 'error')} ">
	<label for="firstName">
		<g:message code="systemUser.firstName.label" default="First Name" />
		
	</label>
	<g:textField name="firstName" value="${systemUserInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: systemUserInstance, field: 'lastLogin', 'error')} required">
	<label for="lastLogin">
		<g:message code="systemUser.lastLogin.label" default="Last Login" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="lastLogin" precision="day"  value="${systemUserInstance?.lastLogin}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: systemUserInstance, field: 'lastName', 'error')} ">
	<label for="lastName">
		<g:message code="systemUser.lastName.label" default="Last Name" />
		
	</label>
	<g:textField name="lastName" value="${systemUserInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: systemUserInstance, field: 'password', 'error')} ">
	<label for="password">
		<g:message code="systemUser.password.label" default="Password" />
		
	</label>
	<g:textField name="password" value="${systemUserInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: systemUserInstance, field: 'role', 'error')} ">
	<label for="role">
		<g:message code="systemUser.role.label" default="Role" />
		
	</label>
	<g:textField name="role" value="${systemUserInstance?.role}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: systemUserInstance, field: 'status', 'error')} ">
	<label for="status">
		<g:message code="systemUser.status.label" default="Status" />
		
	</label>
	<g:textField name="status" value="${systemUserInstance?.status}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: systemUserInstance, field: 'username', 'error')} ">
	<label for="username">
		<g:message code="systemUser.username.label" default="Username" />
		
	</label>
	<g:textField name="username" value="${systemUserInstance?.username}"/>
</div>

