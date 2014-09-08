<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<head>
    <script>
        $(function(){
            $('#Usuarios').addClass('active');
        });
    </script>
</head>
<mtw:form klass="form-horizontal blocoExterno" action="UsuarioUpdate.mtw" method="post" style="background-color: white">
    <!--<mtw:input type="hidden" name="usuario.login"/>-->
    <div>
        <legend class ="sub-header">
            <p style="margin-left: 40%">Alterar Usuário</p></legend>
    </div>
    <div class="blocoInterno imagemUsuarioEdit "> 

        <div class="control-group">
            <div class="control-group">
                <label class="control-label" for="inputNome">Nome *</label>
                <div class="controls">
                    <mtw:input type="text" id="inputNome" name="usuario.nome"/>
                    <span class="label label-important">${error.nome}</span>
                </div>
            </div>

        <div>
        <label or="inputNome">Nome</label>
        <div>
            <mtw:input type="text" id="inputNome" name="usuario.nome"/>
                    <span class="label label-important">${error.nome}</span>

        </div>
    </div>
    <div>
        <label or="inputLogin">Login:</label>
        <div>
            <mtw:input type="text" id="inputLogin" name="usuario.login"/>
        </div>
    </div>
    <div>
        <label or="inputEmpresa">Empresa:</label>
        <div>
            <mtw:input type="text" id="inputNome" name="usuario.empresa"/>
        </div>
    </div>
    <div>
        <label or="inputCpf">CPF:</label>
        <div>
            <mtw:input type="text" id="inputCpf" name="usuario.cpf"/>
        </div>
    </div>
        <div>
            <label or="inputRg">RG:</label>
            <div>
                <mtw:input type="text" id="inputRg" name="rg"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="inputTipo">Tipo *</label>
            <div class="controls">
                <select type="text" name="usuario.tipo">
                    <option>Financeiro</option>
                    <option>Solicitante</option>
                </select>
                <span class="label label-important">${error.tipo}</span>
            </div>
        <div>
            <label or="inputEmailPessoal">Email Pessoal:</label>
            <div>
                <mtw:input type="text" id="inputEmailPessoal" name="usuario.emailpessoal"/>
            </div>
        </div>
        <div>
            <label or="inputEmailCorporativo">Email Corporativo:</label>
            <div>
                <mtw:input type="text" id="inputEmailCorporativo" name="usuario.emailcorporativo"/>
            </div>
        </div>
        <div>
        <div>
            <label or="inputTelefonePessoal">Telefone Pessoal:</label>
            <div>
                <mtw:input type="text" id="inputTelefonePessoal" name="usuario.telefonepessoal"/>
            </div>
        </div>
        <div>
        <div>
            <label or="inputTelefoneCorporativo">Telefone Corporativo:</label>
            <div>
                <mtw:input type="text" id="inputTelefoneCorporativo" name="usuario.telefonecorporativo"/>
            </div>
        </div>
        <div>
        <div>
            <label or="inputEmailCorporativo">Email Corporativo:</label>
            <div>
                <mtw:input type="text" id="inputEmailCorporativo" name="usuario.emailcorporativo"/>
            </div>
        </div>    
    
                <div class="span4 blocoInterno" style="color: red">
                    <img src="img/atencao.ico">
                    <p>Atenção:</p>
                    <p>Os campos com asterísco ( * )</p>
                    <p>são obrigatórios de preenchimento!</p>
                </div>
            </div>
        </div>
    </div>
    <input type="text" id="tipoUsuario" value="${usuario.tipo}" class="hide"/>
</mtw:form>

<script>
    $(function(){
        var tipo = $('#tipoUsuario').val();
        if (tipo == "Administrador"){
            $('#tipo').attr('disabled', 'disabled');
        } else {
            $('#tipo option').each(function(){
                if($(this).val() == tipo){
                    $(this).attr('selected',true);
                }
            });            
        }

        $('#inputLogin').addClass('hide');
        $('#loginDesabilitado').attr('value',$('#inputLogin').val()).removeClass('hide').attr('disabled', 'disabled');
    });
</script>




