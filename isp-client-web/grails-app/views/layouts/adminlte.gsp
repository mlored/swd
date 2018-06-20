<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <!-- Tell the browser to be responsive to screen width -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

    <link rel="stylesheet" href="${resource(dir: 'css', file: 'skins/_all-skins.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'AdminLTE.css')}" type="text/css">

    <title>Sistema</title>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js does nott work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="${resource(dir: 'js', file: 'jquery.js')}"></script>
    <script type="text/javascript" src="${resource(dir: 'js', file: 'bootstrap.js')}"></script>
    <script type="text/javascript" src="${resource(dir: 'js', file: 'adminlte.js')}"></script>
    <script type="text/javascript" src="${resource(dir: 'js', file: 'jquery.validate.js')}"></script>
    <script type="text/javascript" src="${resource(dir: 'js', file: 'localization/messages_es.js')}"></script>
</head>
<body class="skin-blue sidebar-mini">


<div class="wrapper">

    <header class="main-header">

        <!-- Logo -->
        <a href="${createLink(uri: '/')}" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->

            <span class="logo-mini"><b>S</b>D</span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>Sistemas</b>Distribuidos</span>

        </a>

        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>
            <!-- Navbar Right Menu -->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- Messages: style can be found in dropdown.less-->

                    <!-- User Account: style can be found in dropdown.less -->
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">

                            <span class="hidden-xs">Usuario</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- User image -->
                            <li class="user-header">
                                <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                                <p>
                                    <sec:ifLoggedIn>
                                        <sec:username/>!
                                    </sec:ifLoggedIn>
                                    <small>Member since Nov. 2012</small>
                                </p>
                            </li>
                            <!-- Menu Body -->
                            <li class="user-body">
                                <div class="row">
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Followers</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Sales</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Friends</a>
                                    </div>
                                </div>
                                <!-- /.row -->
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="#" class="btn btn-default btn-flat">Profile</a>
                                </div>
                                <div class="pull-right">
                                    <a href="/isp-client-web/j_spring_security_logout"  class="btn btn-default btn-flat"/>Salir</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <!-- Control Sidebar Toggle Button -->
                    <li>
                        <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
                    </li>
                </ul>
            </div>

        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar" style="height: auto;">
            <!-- Sidebar user panel -->

            <!-- search form -->
            <form action="#" method="get" class="sidebar-form">
                <div class="input-group">
                    <input type="text" name="q" class="form-control" placeholder="Buscar...">
                    <span class="input-group-btn">
                        <button type="submit" name="search" id="search-btn" class="btn btn-flat">
                            <i class="fa fa-search"></i>
                        </button>
                    </span>
                </div>
            </form>
            <!-- /.search form -->
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu tree" data-widget="tree">
                <li class="header">MENU</li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-users"></i> <span>Personas</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                    	<li><a href="/isp-client-web/user/list"><i class="fa fa-user"></i> Usuarios</a></li>
                        <li><a href="/isp-client-web/employee/list"><i class="fa fa-user"></i> Empleados</a></li>
                        <li><a href="/isp-client-web/client/list"><i class="fa fa-user"></i> Clientes</a></li>
                        <li><a href="/isp-client-web/supplier/list"><i class="fa fa-user"></i> Proveedores</a></li>
                    </ul>
                </li>

                <li>
                    <a href="/isp-client-web/cars/list">
                        <i class="fa fa-car"></i> <span>Autos</span>

                    </a>
                </li>

                <li>
                    <a href="/isp-client-web/buy/list">
                        <i class="fa fa-shopping-cart"></i> <span>Compras</span>

                    </a>
                </li>
                <li>
                    <a href="/isp-client-web/#">
                        <i class="fa fa-credit-card"></i> <span>Ventas (No Funciona)</span>

                    </a>
                </li>
                <li class="treeview">
                    <a href="/isp-client-web/#">
                        <i class="fa fa-file"></i> <span>Fichas</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/isp-client-web/entry/list"><i class="fa fa-file-text"></i> Entradas de vehiculos</a></li>
                        <li><a href="/isp-client-web/#"><i class="fa fa-file-text"></i> Servicios realizados (No funciona)</a></li>
                    </ul>
                </li>

                <li>
                    <a href="/isp-client-web/report/list">
                        <i class="fa fa-file-text-o"></i> <span>Reportes (no funciona) </span>

                    </a>
                </li>
                <li>
                    <a href="/isp-client-web/stock/list">
                        <i class="fa fa-cubes"></i> <span>Stock</span>

                    </a>
                </li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-gears"></i> <span>Items</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/isp-client-web/service/list"><i class="fa fa-wrench"></i> Servicios</a></li>
                        <li><a href="/isp-client-web/part/list"><i class="fa fa-gear"></i> Repuestos</a></li>
                    </ul>
                </li>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper" style="min-height: 960px;">
        <!-- Content Header (Page header) -->


        <!-- Main content -->
        <section class="content">
            <!-- Info boxes -->
            <div class="row">



                <g:layoutBody/>

            </div>

        </section>
    </div>
</div><!-- ./wrapper -->

<h1>Instancia : ${grailsApplication.config.app.instance} </h1>
</body>

<script>
    // Set jQuery.validate settings for bootstrap integration
    jQuery.validator.setDefaults({
        highlight: function(element, errorClass, validClass) {
            if ($(element).closest('.input-group').length > 0) {
                $(element).closest('.form-group').removeClass('has-error').addClass('has-error');
            } else {
                if (element.type === "radio") {
                    this.findByName(element.name).addClass(errorClass).removeClass(validClass);
                } else {
                    $(element).closest('.form-group').removeClass('has-success has-feedback').addClass('has-error has-feedback');
                    if ($(element).closest('form').hasClass('form-horizontal')) {
                        $(element).closest('.form-group > div[class^="col"]').find('i.fa').remove();
                        $(element).closest('.form-group > div[class^="col"]').append('<i class="fa fa-exclamation fa-lg form-control-feedback"></i>');
                    } else {
                        $(element).closest('.form-group').find('i.fa').remove();
                        $(element).closest('.form-group').append('<i class="fa fa-exclamation fa-lg form-control-feedback"></i>');
                    }
                }
            }
        },
        unhighlight: function(element, errorClass, validClass) {
            if ($(element).closest('.input-group').length > 0) {
                $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
            } else {
                if (element.type === "radio") {
                    this.findByName(element.name).removeClass(errorClass).addClass(validClass);
                } else {
                    if ($(element).closest('form').hasClass('form-horizontal')) {
                        $(element).closest('.form-group > div[class^="col"]').find('i.fa').remove();
                        $(element).closest('.form-group').removeClass('has-error has-feedback').addClass('has-success has-feedback');
                    } else {
                        $(element).closest('.form-group').removeClass('has-error has-feedback').addClass('has-success has-feedback');
                        $(element).closest('.form-group').find('i.fa').remove();
                        $(element).closest('.form-group').append('<i class="fa fa-check fa-lg form-control-feedback"></i>');
                    }
                }
            }
        },
        errorPlacement: function(error, element) {
            if (element.parent('.input-group').length) {
                error.insertAfter(element.parent());
            } else if (element.parent('.radio-inline').length) {
                error.insertAfter(element.parent().parent());
            } else {
                error.insertAfter(element);
            }
        },
        errorElement: 'span',
        errorClass: 'help-block',
        ignore: ''
    });

    $('a[data-method="delete"]').click(function(){
        $.ajax(
            {
                url: this.getAttribute('href'),
                type: 'DELETE',
                async: false,
                complete: function(response, status) {
                    if (status == 'success')
                    //alert('success!')
                        location.reload();
                    else
                    alert('Error: the service responded with: ' + response.status + '\n' + response.responseText)
                }
            }
        )
        return false
    });
</script>
</html>
