<%@ page contentType="text/html;charset=UTF-8" %>

<div id="tabs" class="tabref">
    <ul style="padding: 0; margin: 0;">
        <!-- <li><a id="patient-tab" href="#iframe1">Paciente</a></li> -->
        <li><a id="fil-tab" href="#iframe1">Datos Filiatorios</a></li>
        <li><a id="study-tab" href="#iframe2">Ingreso Estudio</a></li>
        <li><a id="treatment-tab" href="#iframe3">Ingreso Tratamiento</a></li>
        <li><a id="antecedent-tab" href="#iframe4">Ingreso Antecedente</a></li>
        <li><a id="palte-tab" href="#iframe5">Ingreso Placa</a></li>

        <!--
        <li><a id="history-tab" href="#iframe3">Estudios</a></li>
        <li><a id="treatment-tab" href="#iframe4">Tratamientos</a></li>
        <li><a id="antecedent-tab" href="#iframe5">Antecedentes</a></li>
        <li><a id="plate-tab" href="#iframe6">Placas</a></li>
        -->

    </ul>

    <iframe id="iframe1" src="/medical-history/philiatory/create/" style="width:100%;">
    </iframe>

    <iframe id="iframe2" src="/medical-history/medicalStudy/create/" style="width:100%;">
    </iframe>

    <iframe id="iframe3" src="/medical-history/treatment/create" style="width:100%;">
    </iframe>

    <iframe id="iframe4" src="/medical-history/antecedent/create" style="width:100%;">
    </iframe>

    <iframe id="iframe5" src="/medical-history/plate/list" style="width:100%;">
    </iframe>

</div>