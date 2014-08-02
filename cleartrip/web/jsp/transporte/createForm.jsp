<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form action="TransporteCreate.mtw" method="post">
    <legend>Novo Meio de Transporte</legend>
    <div>
        <label or="inputNome">Nome</label>
        <div>
            <mtw:input type="text" id="inputNome" name="nome"/>
        </div>
    </div>
    <div>
        <div>
            <button type="submit">Confirmar</button>
        </div>
    </div>
</mtw:form>