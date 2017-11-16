<html>
<head>
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
                                    Alexander Pierce - Web Developer
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
                                    <a href="#" class="btn btn-default btn-flat">Sign out</a>
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
                        <li><a href="employee/list"><i class="fa fa-user"></i> Empleados</a></li>
                        <li><a href="client/list"><i class="fa fa-user"></i> Clientes</a></li>
                        <li><a href="index2.html"><i class="fa fa-user"></i> Proveedores</a></li>
                    </ul>
                </li>

                <li>
                    <a href="cars/list">
                        <i class="fa fa-car"></i> <span>Autos</span>

                    </a>
                </li>

                <li>
                    <a href="cars/list">
                        <i class="fa fa-shopping-cart"></i> <span>Compras</span>

                    </a>
                </li>
                <li>
                    <a href="cars/list">
                        <i class="fa fa-credit-card"></i> <span>Ventas</span>

                    </a>
                </li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-file"></i> <span>Fichas</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="index.html"><i class="fa fa-file-text"></i> Entradas de vehiculos</a></li>
                        <li><a href="index2.html"><i class="fa fa-file-text"></i> Servicios realizados</a></li>
                    </ul>
                </li>

                <li>
                    <a href="cars/list">
                        <i class="fa fa-file-text-o"></i> <span>Reportes</span>

                    </a>
                </li>
                <li>
                    <a href="cars/list">
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
                        <li><a href="index.html"><i class="fa fa-wrench"></i> Servicios</a></li>
                        <li><a href="index2.html"><i class="fa fa-gear"></i> Repuestos</a></li>
                    </ul>
                </li>



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

</body>
<asset:javascript src="jquery.js"/>
<asset:javascript src="adminlte.js"/>
</html>
