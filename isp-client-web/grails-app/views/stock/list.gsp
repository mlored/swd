
<!DOCTYPE html>
<html>
<head>
    <meta name='layout' content='adminlte'/>
    <g:set var="entityName" value="${message(code: 'part.label', default: 'Part')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<div id="list-part" class="content scaffold-list" role="main">
    <h1>Stock</h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <div class="box">
        <table class="table table-striped table-hover table-condensed">
            <thead>
            <tr>
                <th>#</th>
                <g:sortableColumn property="name" title="Nombre" />
                <g:sortableColumn property="description" title="Descripción" />
                <g:sortableColumn property="price" title="Precio" />
                <g:sortableColumn property="quantity" title="Cantidad" />
            	<th></th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${partInstanceList}" status="i" var="partInstance">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td>${i+1}</td>
                    <td><g:link action="edit" id="${partInstance?.id}"><g:message code="${fieldValue(bean: partInstance, field: "name")}" default="${fieldValue(bean: partInstance, field: "name")}" /></g:link></td>
                    <td>${fieldValue(bean: partInstance, field: "description")}</td>
                    <td>${fieldValue(bean: partInstance, field: "price")}</td>
                    <td>${fieldValue(bean: partInstance, field: "quantity")}</td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>

    <div class="pagination">
        <g:paginate total="${partInstanceTotal}" />
    </div>
</div>
</body>
</html>