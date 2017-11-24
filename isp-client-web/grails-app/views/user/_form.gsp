<div class="box-body">
	<div class="form-group ${hasErrors(bean: userrInstance, field: 'userName', 'error')}">
		<label for="userName">
			<g:message code="user.userName.label" default="userName" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="userName" maxlength="50" required="" value="${userInstance?.userName}"/>
	</div>
	
	<div class="form-group ${hasErrors(bean: userInstance, field: 'name', 'error')} required">
		<label for="name">
			<g:message code="user.name.label" default="Name" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="name" maxlength="50" required="" value="${userInstance?.name}"/>	
	</div>
	
	<div class="form-group ${hasErrors(bean: userInstance, field: 'surName', 'error')} required">
		<label for="surName">
			<g:message code="user.surName.label" default="Sur Name" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="surName" maxlength="50" required="" value="${userInstance?.surName}"/>
	</div>
	
	<div class="from-group ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
		<label for="password">
			<g:message code="user.password.label" default="Password" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="password" maxlength="10" required="" value="${userInstance?.password}"/>
	</div>
	
	<div class="form-group ${hasErrors(bean: userInstance, field: 'role', 'error')} required">
		<label for="role">
			<g:message code="user.role.label" default="Role" />
			<span class="required-indicator">*</span>
		</label>
		<g:select id="role" name="role.id" from="${com.sd.isp.role.Role.list()}" optionKey="id" required="" value="${userInstance?.role?.id}" class="many-to-one"/>
	</div>
</div>
<!-- /.box-body -->