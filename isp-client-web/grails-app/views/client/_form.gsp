
<div class="fieldcontain ${hasErrors(bean: clientInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="client.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" maxlength="50" required="" value="${clientInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: clientInstance, field: 'lastName', 'error')} required">
	<label for="lastName">
		<g:message code="client.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" maxlength="50" required="" value="${clientInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: clientInstance, field: 'document', 'error')} required">
	<label for="document">
		<g:message code="client.document.label" default="Document" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="document" maxlength="10" required="" value="${clientInstance?.document}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: clientInstance, field: 'city', 'error')} required">
	<label for="city">
		<g:message code="state.city.label" default="City" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="country" name="cityId" from="${cities}" optionKey="id" optionValue="name" required="" value="${clientInstance?.city?.id}" class="many-to-one"/>
</div>

