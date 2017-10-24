<%@ page import="com.sd.isp.city.City" %>



<div class="fieldcontain ${hasErrors(bean: cityInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="city.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="50" required="" value="${cityInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: cityInstance, field: 'state', 'error')} required">
	<label for="state">
		<g:message code="city.state.label" default="State" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="state" name="stateId" from="${states}" optionKey="id" optionValue="name" required="" value="${cityInstance?.state?.id}" class="many-to-one"/>
</div>

