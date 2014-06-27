<%@ page contentType="text/html;charset=UTF-8" %>

<div id="tabs">
    <ul>
        <li><a id="mainStudyType-tab" href="#iframe1">Estudios principales</a></li>
        <li><a id="StudyTypes-tab" href="#iframe2">Tipos de estudio</a></li>
        <li><a id="studyTypesDetails-tab" href="#iframe3">Detalles de estudio</a></li>
        <li><a id="ageRanges-tab" href="#iframe4">Rangos de Edades</a></li>
        <li><a id="doctor-tab" href="#iframe5">Doctores</a></li>
        <li><a id="referenceValue-tab" href="#iframe6">Valores de referencia</a></li>
    </ul>

    <iframe id="iframe1" src="/medical-history/mainStudyType/list/" class="frameref">
    </iframe>

    <iframe id="iframe2" src="/medical-history/StudyTypes/list/" style="width:100%;">
    </iframe>

    <iframe id="iframe3" src="/medical-history/studyTypesDetails/show/" style="width:100%;">
    </iframe>

    <iframe id="iframe4" src="/medical-history/ageRanges/list" style="width:100%;">
    </iframe>

    <iframe id="iframe5" src="/medical-history/doctor/list" style="width:100%;">
    </iframe>

    <iframe id="iframe6" src="/medical-history/referenceValue/list" style="width:100%;">
    </iframe>



</div>