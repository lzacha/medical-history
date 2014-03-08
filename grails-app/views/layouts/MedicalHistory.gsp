<!doctype html>
<!--[if IE 7]>    <html class="no-js lt-ie10 lt-ie9 lt-ie8 ie7" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie10 lt-ie9 ie8" lang="en"> <![endif]-->
<!--[if IE 9]>    <html class="no-js lt-ie10 ie9" lang="en"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="no-js" lang="en"> <!--<![endif]-->

<html>

    <!-- HEAD HTML -->
    <head>

        <!--g:layoutTitle -->
        <title><g:layoutTitle default="Grails"/></title>

        <!-- Some metas-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- require modules -->
        <r:require modules="jquery, jquery-ui, blueprint, mesh, appJs, appCss"/>

        <!-- shortcut icon -->
        <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">

        <link href="/medical-history/static/css/medicalHistory.css" type="text/css" rel="stylesheet" media="screen, projection" />

        <!-- chico-ui css-->

        <!-- g:layoutHead -->
        <g:layoutHead/>

        <!-- r:layoutResources -->
        <r:layoutResources/>

        <r:script>
            /* Cualquier cosa que tire aca, resources la baja al fondo del body */
            $(function() {
                $('#form').dialog('open');
            });
        </r:script>
    </head>

    <!-- BODY HTML -->
    <body>

        <g:render template="/laying/header" model="[:]" />

        <div class="mh-margins">
        <g:render template="/laying/menu" model="[:]" />
        <g:render template="/laying/appContainer" model="[:]" />
        </div>
        <g:render template="/laying/footer" model="[:]" />

        <!-- r:layoutResources -->
        <r:layoutResources />
    </body>
</html>