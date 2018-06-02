

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
                    <strong>Contactanos</strong>
                </h4>
            </div>
            <div class="panel-body">
                <g:form url="[action:'save', method:'post']" >
                    <fieldset class="form">
                        <g:render template="form" />
                    </fieldset>
                    <fieldset class="buttons">
                        <br> <br>
                        <div class="col-xs-12" align="center">
                            <button type="submit" class="btn btn-primary " name="create"
                                    value="${message(code: 'default.button.create.label', default: 'Create')}">
                                <i class="fa fa-floppy-o"></i> Enviar
                            </button>

                        </div>
                    </fieldset>
                </g:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>