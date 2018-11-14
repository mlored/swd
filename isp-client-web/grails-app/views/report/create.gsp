
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="adminlte">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>
						<strong>Generar Informe</strong>
					</h4>
				</div>
				<div class="panel-body">
						<fieldset class="form">		
							<g:render template="form" />
						</fieldset>		
				</div>
			</div>
		</div>
	</div>
	<br><br><br><br>
	<!-- jQuery -->
	<script src=" ${request.contextPath}/template/js/jquery.js"></script>
	<script src=" ${request.contextPath}/template/js/jquery.validate.js"></script>
	<script src=" ${request.contextPath}/template/js/validationFormReport.js"></script>
	<script src=" ${request.contextPath}/template/js/validationModalDiagnostic.js"></script>
</body>
</html>
