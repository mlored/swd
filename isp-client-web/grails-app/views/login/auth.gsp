<!DOCTYPE html>
<html>
	<head>	
		<meta name="layout" content="main" />
		%{-- <title><g:message code="Inicio de Sesion"/></title> --}%
		<asset:stylesheet src="auth.css"/>
	</head>
	<body>
		<div class="container">
	      <form class="form-signin form-horizontal" action='${postUrl}' method='POST' id='loginForm' autocomplete='off'>
	        <h2> Iniciar Sesión</h2>

	        <g:if test='${flash.message}'>
				<div class='login_message'>${flash.message = "Usuario y/o Contraseña incorrectos."}</div>
			</g:if>			

	        <div class="form-group">
				<label for='username' class="col-sm-3 control-label"><g:message code="Usuario"/></label>
				<div class="col-sm-8">
					<input type='text' class='form-control' name='j_username' id='username'/>
				</div>
			</div>

			<div class="row">
				<label for='password' class="col-sm-3 control-label"><g:message code="Contraseña"/></label>
				<div class="col-sm-8">
					<input type='password' class='form-control' name='j_password' id='password'/>
				</div>
			</div>

			<p id="remember_me_holder">
				<input type='checkbox' class='chk' name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if>/>
				<label for='remember_me'><g:message code="Recuérdame"/></label>
			</p>

			<p>
				<input type='submit' id="submit" class ="btn" value='${message(code: "Entrar")}'/>
			</p>
	      </form>

	    </div>					
		
		<script type='text/javascript'>
			<!--
			(function() {
				document.forms['loginForm'].elements['j_username'].focus();
			})();
			// -->
		</script>

	</body>
</html>

