<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="adminlte">
    <g:set var="entityName" value="${message(code: 'employee.label', default: 'Employee')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<div id="list-employee" class="content scaffold-list" role="main">
     <div class="col-sm-5" align="center">
		<g:form action="list" class="form-search">
			<div class="input-group col-md-7">
				<input type="text" name="text" class="form-control" maxlength="50" value="${text}"
						placeholder="Ingrese un texto para buscar" /> <span
					    class="input-group-btn">
					<button class="btn btn-primary" name="list" value="Buscar">
					 	<span class=" glyphicon glyphicon-search"></span>
					</button>
				</span>
			</div>
	    </g:form>
     </div>
    <h1>
    	Empleados
   		 <g:link class="btn btn-primary" action="create">Nuevo</g:link>
    </h1>
    
     <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    
    <div class="box">
    <table class="table table-striped table-hover table-condensed">
        <thead>
        <tr>
        	<th>#</th>
            <g:sortableColumn property="name" title="Nombre" />
            <g:sortableColumn property="surName" title="Apellido" />
            <g:sortableColumn property="ruc" title="Ruc" />
            <g:sortableColumn property="address" title="Dirección" />
            <g:sortableColumn property="cellphone" title="Telefono" />
        </tr>
        </thead>
        <tbody>
        <g:each in="${employeeInstanceList}" status="i" var="employeeInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td>${i+1}</td>
                <td><g:link action="edit" id="${employeeInstance?.id}"><g:message code="${fieldValue(bean: employeeInstance, field: "name")}" default="${fieldValue(bean: employeeInstance, field: "name")}" /></g:link></td>
                <td>${fieldValue(bean: employeeInstance, field: "surName")}</td>
                <td>${fieldValue(bean: employeeInstance, field: "ruc")}</td>
                <td>${fieldValue(bean: employeeInstance, field: "address")}</td>
                <td>${fieldValue(bean: employeeInstance, field: "cellphone")}</td>
                <td>
                  <g:form controller="employee" method="DELETE">
                    <td><a data-confirm="Estas Seguro?" method="delete" href="/isp-client-web/employee/delete/${employeeInstance.id}" rel="nofollow">Borrar</a></td>
                  </g:form>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
    </div>
    <div class="pagination">
        <g:paginate total="${employeeInstanceTotal}" />
    </div>
</div>
</body>
</html>