<!--[if lt IE 7]> <html class="no-js lt-ie10 lt-ie9 lt-ie8 lt-ie7 ie6" lang="en"> <![endif]-->
<!--[if IE 7]>	<html class="no-js  lt-ie10 lt-ie9 lt-ie8 ie7" lang="en"> <![endif]-->
<!--[if IE 8]>	<html class="no-js lt-ie10 lt-ie9 ie8" lang="en"> <![endif]-->
<!--[if IE 9]>	<html class="no-js lt-ie10 ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang="es"> <!--<![endif]-->

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Grails"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">

    <style>

    body {
        color: #333333;
        font: 13px/20px Arial,Helvetica,"Nimbus Sans L",sans-serif;
    }

    .ch-box {
        border: 1px solid #ccc;
        padding: 10px;
        margin: 10px auto;
    }

    .ch-header {
        height: 50px;
        padding: 20px 10px;
        background: #eee;
        margin: 10px auto 0px;
    }

    .ch-footer {
        clear:both;
        text-align: center;
        margin: 10px auto;
        background: #eee;

    }
    </style>

    <!-- chico-ui css-->
    <link rel="stylesheet" href="${resource(dir: 'css/chico-ui/css', file: 'chico-min-0.13.1.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css/chico-ui/css', file: 'mesh-min-2.1.css')}" type="text/css">


    <!-- jquery -->
    <g:javascript library="jquery" plugin="jquery"/>

    <!-- g:layoutHead -->
    <g:layoutHead/>

    <!-- r:layoutResources -->
    <r:layoutResources/>

</head>
<body>

<div class="ch-header ch-box">
    <h1>Medical History Site Title</h1>
</div>

<div class="ch-g1-5">
    <div class="ch-box ch-leftcolumn">
        <ul id="example">
            <li>
                <span>Pacientes</span>
                <ul>
                    <li><a href="searchPatient">Buscar Paciente</a></li>
                    <li><a href="addPatient">Agregar Paciente</a></li>
                </ul>
            </li>
            <li>
                <span>Estadisticas</span>
                <ul>
                    <li><a href="#">Estadistica 1</a></li>
                    <li><a href="#">Estadistica 2</a></li>
                </ul>
            </li>
            <li>
                <span>Administración</span>
                <ul>
                    <li><a href="#">Admin 1</a></li>
                    <li><a href="#">Admin 2</a></li>
                </ul>
            </li>
        </ul>
    </div>
</div>


<div class="ch-g4-5">
    <div class="ch-box ch-rightcolumn">
        <h2>Contenido</h2>
        <g:layoutBody/>
    </div>
</div>

<div class="ch-footer ch-box">
    <p>Footer de la app</p>
</div>

<!-- chico-ui js-->
<g:javascript src="chico-ui/js/chico-min-0.13.1.js"/>

<!-- g:javascript library=application -->
<g:javascript library="application"/>

<!-- r:layoutResources -->
<r:layoutResources />

<!-- medicalHistory.gsp script tag-->
<script>

    //Menu
    var foo = $("#example").menu();

    //foo.on("select",function(){
        //alert("alert");
    //});

    //foo.select(1);
    //foo.select(2);
    /*
    var foo = $("#example").menu({
        "bar": foobar,
        "baz": quux
    });*/

</script>
<script>
    var ac = $("#autocomplete").autoComplete({
        "url": "/medical-history/suggest?q=",
        "jsonpCallback": "autoComplete"
    });

    var autoComplete = function(data){ ac.suggest(data); };

</script>

</body>
</html>