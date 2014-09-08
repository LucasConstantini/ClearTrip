<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<head>
    <script>
        $(function(){
            $('#Usuarios').addClass('active');
        });
    </script>
</head>

<div class="input-append tabelaFormatacao">
    <mtw:form action="UsuarioRead.mtw" method="post">
        <mtw:input name="nome" type="text"/>
        <button class="btn" type="submit"><img src='img/pesquisar.png'></button>
        <a href="UsuarioShowForm.mtw" class="btn"><img src='img/novo.png'></i></a>
        </mtw:form>    
</div>


<div class="tabela tabelaFormatacao">
    <display:table name="lista" pagesize="20" requestURI="" defaultsort="1">
        <display:column property="login" sortName="login" sortable="true" title="Código" style="width:4%;"/>
        <display:column property="nome" sortable="true" title="Nome" style="width:10%;"/>
        <display:column property="tipo" sortable="true" title="Tipo" style="width:10%;"/>
        <display:column title="Editar" value="<img src='img/editar.png'alt='Editar'>" href="UsuarioShowForm.mtw"  paramId="login" paramProperty="login" style="width:5%;"/>
        <display:column title="Excluir" value="<img src='img/lixeira.png'alt='Alterar'>" href="UsuarioDelete.mtw" class="deleteLink" paramId="login" paramProperty="login" style="width:5%;"/>
    </display:table>
</div>
<!--------------------------------------------------------------------------------->
<!--Nao deletar usuário vinculado a disciplina -->
<span>

</span>
<div class="modal hide fade" id="excessaoDelete">
    <div class="modal-header">
        <button style="color: red;font-size: 24px" type="button" class="close" data-dismiss="modal">×</button>
        <h3>Atenção</h3>
    </div>
    <div class="modal-body">

        <div class="alert alert-error">
            <input class="hide" id="mensagemErro" value="${erro.erro}"/>
            <p>${erro.erro}</p>
        </div>
    </div>
    <div class="modal-footer">
        <a href="#" class="btn btn-danger" data-dismiss="modal" id="botaoOk">OK</a>
    </div>   
</div>
<!--------------------------------------------------------------------------------->        

<div class="modal hide fade" id="confirmDelete">
    <div class="modal-header">
        <button style="color: red;font-size: 24px"type="button" class="close" data-dismiss="modal">×</button>
        <h3>Atenção</h3>
    </div>
    <div class="modal-body">
        <p>Você deseja realmente excluir?</p>
        <div class="alert alert-error">
            Atenção: esta operação não pode ser desfeita.
        </div>
    </div>
    <div class="modal-footer">
        <a href="#" class="btn btn-danger">Excluir</a>
        <a href="#" class="btn" data-dismiss="modal">Cancelar</a>
    </div>   
</div>
<!--------------------------------------------------------------------------------->
<!--Nao deletar Administrador -->

<div class="modal hide fade" id="excessaoDeleteAdm">
    <div class="modal-header">
        <button style="color: red;font-size: 24px" type="button" class="close" data-dismiss="modal">×</button>
        <h3>Atenção</h3>
    </div>
    <div class="modal-body">

        <div class="alert alert-error">
            <input class="hide" id="mensagemErroAdm" value="${erro.erroAdm}"/>
            <p>${erro.erroAdm}</p>
        </div>
    </div>
    <div class="modal-footer">
        <a href="#" class="btn btn-danger" data-dismiss="modal" id="botaoOk">OK</a>
    </div>   
</div>
<!--------------------------------------------------------------------------------->        
<script>
    $(function(){
        $("td.deleteLink a").click(function(){
            $('#confirmDelete').modal('show');
            $("#confirmDelete .btn-danger").attr("href", $(this).attr("href"));
            return false;
        });
        if ($('#mensagemErro').val()){
            $('#excessaoDelete').modal('show');
            
        };
        if ($('#mensagemErroAdm').val()){
            $('#excessaoDeleteAdm').modal('show');
            
        };
        $('#botaoOk').click(function(){
            $('#mensagemErro').val('');
                
        });
    });
</script>