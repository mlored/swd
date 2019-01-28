<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>
        <g:layoutTitle default="AdminLTE 2 | Dashboard"/>
    </title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="/static/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/static/bower_components/font-awesome/css/font-awesome.min.css">
    <g:layoutHead/>
    <!-- Theme style -->
    <link rel="stylesheet" href="/static/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="/static/dist/css/skins/_all-skins.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
  <script src="/static/https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="/static/https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>

<body class="hold-transition skin-blue sidebar-mini">
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

                            <span class="hidden-xs">
                                <sec:ifLoggedIn>
                                    <sec:username/>
                                </sec:ifLoggedIn>
                            </span>
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
                                    <a href="/taller-automotriz-web/logoff"  class="btn btn-default btn-flat"/>Salir</a>
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
                <sec:ifAnyGranted roles="ROLE_ADMIN, ROLE_SECRETARIO, ROLE_MECANICO">
                    <li class="header">MENU</li>
                    <sec:ifAnyGranted roles="ROLE_SECRETARIO,ROLE_ADMIN">
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-gear"></i> <span>Configuracion</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="/taller-automotriz-web/employee/list"><i class="fa fa-id-card"></i> Empleados</a></li>
                                <li><a href="/taller-automotriz-web/client/list"><i class="fa fa-user"></i> Clientes</a></li>
                                <li><a href="/taller-automotriz-web/supplier/list"><i class="fa fa-user"></i> Proveedores</a></li>
                                <sec:ifAnyGranted roles="ROLE_ADMIN">
                                    <li><a href="/taller-automotriz-web/user/list"><i class="fa fa-user"></i> Usuarios</a></li>
                                    <li><a href="/taller-automotriz-web/service/list"><i class="fa fa-wrench"></i> Servicios</a></li>
                                    <li><a href="/taller-automotriz-web/part/list"><i class="fa fa-gear"></i> Repuestos</a></li>
                                    <li><a href="/taller-automotriz-web/cars/list"><i class="fa fa-car"></i> Automoviles</a></li>
                                </sec:ifAnyGranted>
                            </ul>
                        </li>
                    </sec:ifAnyGranted>
                    <sec:ifAnyGranted roles="ROLE_SECRETARIO,ROLE_ADMIN">
                        <li>
                            <a href="/taller-automotriz-web/buy/list">
                                <i class="fa fa-shopping-cart"></i> <span>Compras</span>
                            </a>
                        </li>
                    </sec:ifAnyGranted>
                    <sec:ifAnyGranted roles="ROLE_SECRETARIO,ROLE_ADMIN">
                        <li>
                            <a href="/taller-automotriz-web/#">
                                <i class="fa fa-credit-card"></i> <span>Ventas</span>
                            </a>
                        </li>
                    </sec:ifAnyGranted>
                    <sec:ifAnyGranted roles="ROLE_SECRETARIO, ROLE_MECANICO,ROLE_ADMIN">
                        <li>
                            <a href="/taller-automotriz-web/entry/list">
                                <i class="fa fa-file-text-o"></i> <span>Fichas</span>
                            </a>
                        </li>
                    </sec:ifAnyGranted>
                    <sec:ifAnyGranted roles="ROLE_ADMIN">
                        <li>
                            <a href="/taller-automotriz/report/list">
                                <i class="fa fa-pie-chart"></i> <span>Reportes </span>

                            </a>
                        </li>
                    </sec:ifAnyGranted>
                    <sec:ifAnyGranted roles="ROLE_SECRETARIO, ROLE_MECANICO,ROLE_ADMIN">
                        <li>
                            <a href="/taller-automotriz-web/stock/list">
                                <i class="fa fa-cubes"></i> <span>Stock</span>

                            </a>
                        </li>
                    </sec:ifAnyGranted>
                </sec:ifAnyGranted>
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
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="/static/bower_components/jquery/dist/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="/static/bower_components/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.7 -->
<script src="/static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<g:pageProperty name="page.script"/>
<!-- AdminLTE App -->
<script src="/static/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/static/dist/js/demo.js"></script>
</body>
</html>
