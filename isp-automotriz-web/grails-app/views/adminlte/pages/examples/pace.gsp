<!DOCTYPE html>
<html>
<head><meta name="layout" content="adminlte"/>
    <title>AdminLTE 2 | Pace Page</title>
    <!-- Ionicons -->
    <link rel="stylesheet" href="/static/bower_components/Ionicons/css/ionicons.min.css">
    <!-- Pace style -->
    <link rel="stylesheet" href="/static/plugins/pace/pace.min.css">
</head>

<body>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Pace page
                <small>Loading example</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a href="#">Examples</a></li>
                <li class="active">Pace page</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <!-- Default box -->
            <div class="box">
                <div class="box-header with-border">
                    <h3 class="box-title">Title</h3>

                    <div class="box-tools pull-right">
                        <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip"
                                title="Collapse">
                            <i class="fa fa-minus"></i></button>
                        <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip"
                                title="Remove">
                            <i class="fa fa-times"></i></button>
                    </div>
                </div>

                <div class="box-body">
                    Pace loading works automatically on page. You can still implement it with ajax requests by adding this js:
                    <br/><code>$(document).ajaxStart(function() { Pace.restart(); });</code>
                    <br/>

                    <div class="row">
                        <div class="col-xs-12 text-center">
                            <button type="button" class="btn btn-default btn-lrg ajax" title="Ajax Request">
                                <i class="fa fa-spin fa-refresh"></i>&nbsp; Get External Content
                            </button>
                        </div>
                    </div>

                    <div class="ajax-content">
                    </div>
                </div>
                <!-- /.box-body -->
                <div class="box-footer">
                    Footer
                </div>
                <!-- /.box-footer-->
            </div>
            <!-- /.box -->

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
<content tag="script">
<!-- PACE -->
<script src="/static/bower_components/PACE/pace.min.js"></script>
<!-- SlimScroll -->
<script src="/static/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="/static/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="/static/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/static/dist/js/demo.js"></script>
<!-- page script -->
<script type="text/javascript">
    // To make Pace works on Ajax calls
    $(document).ajaxStart(function () {
        Pace.restart()
    })
    $('.ajax').click(function () {
        $.ajax({
            url: '#', success: function (result) {
                $('.ajax-content').html('<hr>Ajax Request Completed !')
            }
        })
    })
</script>
</content>
</body>
</html>
