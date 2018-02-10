
<div class="fieldcontain ${hasErrors(bean: roleInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="role.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="50" required="" value="${roleInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: roleInstance, field: 'user', 'error')} ">
	<label for="user">
		<g:message code="role.user.label" default="User" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${roleInstance?.user?}" var="u">
    <li><g:link controller="user" action="show" id="${u.id}">${u?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="user" action="create" params="['role.id': roleInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'user.label', default: 'User')])}</g:link>
</li>
</ul>


</div>

