<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form action="TransporteCreate.mtw" method="post">
    <legend>Novo Usuario</legend>
    <div>
        <label or="inputNome">Nome</label>
        <div>
            <mtw:input type="text" id="inputNome" name="nome"/>
        </div>
    </div>
    <div>
        <label or="inputLogin">Login:</label>
        <div>
            <mtw:input type="text" id="inputLogin" name="login"/>
        </div>
    </div>
    <div>
        <label or="inputSenha">Senha:</label>
        <div>
            <mtw:input type="password" id="inputSenha" name="senha"/>
        </div>
    </div>
    <div>
        <label or="inputEmpresa">Empresa:</label>
        <div>
            <mtw:input type="text" id="inputNome" name="nome"/>
        </div>
    </div>
    <div>
        <label or="inputCpf">CPF:</label>
        <div>
            <mtw:input type="text" id="inputCpf" name="cpf"/>
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
                <select type="text" name="tipo">
                    <option>Financeiro</option>
                    <option>Solicitante</option>
                </select>
                <span class="label label-important">${error.tipo}</span>
            </div>
            <br/>
            <br/><br/>
            <div class="controls">
                <button type="submit" class="btt botao" style="margin-left: 0%" ><i class="icon-ok icon-white"></i> Confirmar</button>
            </div>
        </div>
       
        <div>
            <label or="inputEmailPessoal">Email Pessoal:</label>
            <div>
                <mtw:input type="text" id="inputEmailPessoal" name="emailpessoal"/>
            </div>
        </div>
        
        <div>
            <label or="inputEmailCorporativo">Email Corporativo:</label>
            <div>
                <mtw:input type="text" id="inputEmailCorporativo" name="emailcorporativo"/>
            </div>
        </div>
        
        <div>
            <label or="inputTelefonePessoal">Telefone Pessoal:</label>
            <div>
                <mtw:input type="text" id="inputTelefonePessoal" name="telefonepessoal"/>
            </div>
        </div>
        <div>
            <label or="inputTelefoneCorporativo">Telefone Corporativo:</label>
            <div>
                <mtw:input type="text" id="inputTelefoneCorporativo" name="telefonecorporativo"/>
            </div>
        </div>
        <div>
        <div>
            <label or="inputEmailCorporativo">Email Corporativo:</label>
            <div>
                <mtw:input type="text" id="inputEmailCorporativo" name="emailcorporativo"/>
            </div>
        </div>    
        <div>
            <button type="submit">Confirmar</button>
        </div>
    </div>
</mtw:form>