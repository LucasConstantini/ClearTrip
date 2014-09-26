<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<ul  class="nav nav-tabs">

    <li class="dropdown" style="margin-left:0px;" id="Configuracao">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><button type="button" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-tasks"></span></button></a>
        <ul class="dropdown-menu" role="menu" aria_labelLedby ="dropdownMenu" >
            <li>
                <mtw:hasAuthorization permission="Inicio"><li id="Inicio"><a href="Inicio.mtw">Início</a></li></mtw:hasAuthorization>
            </li>
            <li class="divider"></li>
            <li>
                <mtw:hasAuthorization permission="Usuario"><li id="Usuarios"><a href="UsuarioRead.mtw">Usuários</a></li></mtw:hasAuthorization>
            </li>
            <li class="divider"></li>
            <li>
                <mtw:hasAuthorization permission="Transporte"><li id="Transporte"><a href="TransporteRead.mtw">Meios de Transporte</a></li></mtw:hasAuthorization>
            </li>
        </ul>
    </li>
</ul>