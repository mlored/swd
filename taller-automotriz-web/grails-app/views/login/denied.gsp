<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="adminlte"/>
	<title><g:message code="Acceso Denegado" /></title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">

			<%-- SIDEBAR  --%>
			<div class="col-sm-3 col-md-2 sidebar">

				<%-- LOGO  --%>

			</div>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<%-- MENU  --%>

				<%-- CONTENT  --%>
	      <div id="contenido">
	        <div class="jumbotron">
	          <h1>Lo sentimos</h1>
	          <p class="lead">No estas autorizado para ver esta página</p>
	          <p><g:link controller='secure' action='logout' class="btn btn-lg btn-success">Cerrar Sesion</g:link></p>
	        </div>
	      </div>
				<%-- FOOTER
				<g:render template="/layouts/footer"></g:render>  	--%>

			</div>
		</div>
	</div>
</body>
</html>

