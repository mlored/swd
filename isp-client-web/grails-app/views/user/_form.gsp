<div class="box-body">
	<div class="form-group ${hasErrors(bean: userrInstance, field: 'username', 'error')}">
		<label for="username">
			<g:message code="user.username.label" default="Usuario" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="username" class="form-control" required="true" maxlength="50" minlength="2" placeholder="username" value="${userInstance?.username}" autofocus="autofocus" />
	</div>
	
	<div class="form-group ${hasErrors(bean: userInstance, field: 'name', 'error')} required">
		<label for="name">
			<g:message code="user.name.label" default="Nombre" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="name" class="form-control" required="true" maxlength="50" minlength="2" placeholder="nombre" value="${userInstance?.name}"/>
	</div>
	
	<div class="form-group ${hasErrors(bean: userInstance, field: 'surName', 'error')} required">
		<label for="surName">
			<g:message code="user.surName.label" default="Apellido" />
			<span class="required-indicator">*</span>
		</label>
		<g:textField name="surName" class="form-control" required="true" maxlength="50" minlength="2" placeholder="apellido" value="${userInstance?.surName}"/>
	</div>
	
	<div class="from-group ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
		<label for="password">
			<g:message code="user.password.label" default="Contraseña" />
			<span class="required-indicator">*</span>
		</label>
		<g:passwordField name="password" class="form-control" required="true" maxlength="20" minlength="6" placeholder="contraseña" value="${userInstance?.password}"/>
	</div>
</div>
<!-- /.box-body -->