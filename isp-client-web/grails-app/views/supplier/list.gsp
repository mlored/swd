
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="adminlte">
    <g:set var="entityName" value="${message(code: 'supplier.label', default: 'Supplier')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<div id="list-supplier" class="content scaffold-list" role="main">
    <h1>Proveedores
   		 <g:link class="btn btn-primary" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link>
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
        <g:each in="${supplierInstanceList}" status="i" var="supplierInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td>${i+1}</td>
                <td><g:link action="show" id="${supplierInstance.id}">${fieldValue(bean: supplierInstance, field: "name")}</g:link></td>
                <td>${fieldValue(bean: supplierInstance, field: "surName")}</td>
                <td>${fieldValue(bean: supplierInstance, field: "ruc")}</td>
                <td>${fieldValue(bean: supplierInstance, field: "address")}</td>
                <td>${fieldValue(bean: supplierInstance, field: "cellphone")}</td>
                <td>
                  <g:form controller="supplier" method="DELETE">
                    <g:submitButton name="borrar" action="delete" class="btn btn-danger"  />
                  </g:form>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
    </div>
    <div class="pagination">
        <g:paginate total="${supplierInstanceTotal}" />
    </div>
</div>
</body>
</html>