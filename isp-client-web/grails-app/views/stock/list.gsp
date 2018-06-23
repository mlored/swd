
<!DOCTYPE html>
<html>
<head>
    <meta name='layout' content='adminlte'/>
    <g:set var="entityName" value="${message(code: 'part.label', default: 'Part')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<div id="list-part" class="content scaffold-list" role="main">
<div class="col-sm-12" align="right">
		<g:form action="list" class="form-search">
			<div class="input-group col-md-5" >
				        <input type="text" name="text" class="form-control" maxlength="50" value="${text}"
						   placeholder="Ingrese un texto para buscar" />
						<span class="input-group-btn">
							<button class="btn btn-primary" name="list" value="Buscar">
								<span class="fa fa-search" style="font-size:20px"></span>
							</button>
						</span>
			</div>
	    </g:form>
     </div>
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
                    <td>${fieldValue(bean: partInstance, field: "quantity")}</td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
		<g:render template="/layouts/paginate"/>
</div>
</body>
</html>