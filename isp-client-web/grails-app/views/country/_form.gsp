<%@ page import="com.sd.isp.country.Country" %>



<div class="fieldcontain ${hasErrors(bean: countryInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="country.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="50" required="" value="${countryInstance?.name}"/>
</div>



