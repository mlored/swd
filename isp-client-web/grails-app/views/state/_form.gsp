
<div class="fieldcontain ${hasErrors(bean: stateInstance, field: 'country', 'error')} required">
	<label for="country">
		<g:message code="state.country.label" default="Country" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="country" name="countryId" from="${countries}" optionKey="id" optionValue="name" required="" value="${stateInstance?.country?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: stateInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="state.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="50" required="" value="${stateInstance?.name}"/>
</div>



