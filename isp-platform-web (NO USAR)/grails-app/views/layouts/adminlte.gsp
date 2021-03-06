<!doctype html>
<html lang="es" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
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
                    <a href="/isp-client-web/#">
                        <i class="fa fa-shopping-cart"></i> <span>Compras</span>

                    </a>
                </li>
                <li>
                    <a href="/isp-client-web/#">
                        <i class="fa fa-credit-card"></i> <span>Ventas</span>

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
                        <li><a href="/isp-client-web/#"><i class="fa fa-file-text"></i> Entradas de vehiculos</a></li>
                        <li><a href="/isp-client-web/#"><i class="fa fa-file-text"></i> Servicios realizados</a></li>
                    </ul>
                </li>

                <li>
                    <a href="/isp-client-web/#">
                        <i class="fa fa-file-text-o"></i> <span>Reportes</span>

                    </a>
                </li>
                <li>
                    <a href="/isp-client-web/stock">
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
                <div class="footer" role="contentinfo"></div>

                <div id="spinner" class="spinner" style="display:none;">
                    <g:message code="spinner.alt" default="Loading&hellip;"/>
                </div>

            </div>

        </section>
    </div>
</div><!-- ./wrapper -->

</body>
<asset:javascript src="application.js"/>
<script>
    $(function(){
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
        })
    });
</script>
</html>
