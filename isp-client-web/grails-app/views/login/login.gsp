

<%@ page contentType="text/html;charset=UTF-8" %>
<html><head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <!-- Tell the browser to be responsive to screen width -->
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'application.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'AdminLTE.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'skins/_all-skins.css')}" type="text/css">
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

    <title>Sistema</title>

    <r:require modules="bootstrap"/>
    <r:require modules="adminlte-core"/>
    <r:layoutResources />
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js does nott work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>

    <![endif]-->
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="../../index2.html"><b>Sistemas</b>Distribuidos</a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg"></p>

        <form action="../../index2.html" method="post">
            <div class="form-group has-feedback">
                <input type="userName" class="form-control" placeholder="Usuario">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="Contraseña">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>

                        </label>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-5">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">Iniciar sesión</button>
                </div>
                <!-- /.col -->
            </div>
        </form>



    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });
</script>


</body></html>