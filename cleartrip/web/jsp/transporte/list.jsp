<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Meio de Transporte</title>
    </head>

    <body>
        <div>
            <mtw:form action="TransporteRead.mtw">
                <mtw:input name="nome" type="text"/>
                <button class="btn" type="submit"><i class="icon-search"></i> Pesquisar</button>
                <a href="TransporteShowForm.mtw" class="btn"><i class="icon-plus"></i> Novo</a>
            </mtw:form>
        </div>
        <div>
            <div class="tabela">
                <display:table name="lista" id="item" pagesize="3" requestURI="" defaultsort="1" sort="list">
                    <display:column property="id" sortName="id" sortable="true" title="Código" style="width:10%;"/>
                    <display:column property="nome" sortable="true" title="Nome" style="width:80%;"/>
                    <display:column value="Editar" href="TransporteShowForm.mtw" paramId="id" paramProperty="id" style="width:5%;"/>
                    <display:column value="Excluir" href="TransporteDelete.mtw"  paramId="id" paramProperty="id" style="width:5%;"/>
                </display:table>
            </div>
        </div>
    </body>
</html>
