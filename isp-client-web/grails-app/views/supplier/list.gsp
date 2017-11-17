
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="adminlte">
    <g:set var="entityName" value="${message(code: 'supplier.label', default: 'Supplier')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<div id="list-supplier" class="content scaffold-list" role="main">
    <h1>Lista de Proveedores</h1>
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