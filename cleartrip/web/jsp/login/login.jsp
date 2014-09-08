<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<!DOCTYPE html>
<html>  
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/reset.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap-responsive.css" rel="stylesheet">
        <link href="css/tabela.css" rel="stylesheet">
        <link href="css/login.css" rel="stylesheet" media="screen">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script> 
        <title>Clear Trip</title>
    </head> 
    <body>
        <div> 
            <mtw:form klass="form-signin" method="post" action="Login.mtw">
                <div>
                    <div>
                        Login: <mtw:input type="text" name="usuario" id="inputLogin"/>
                    </div>
                    <div>
                        Senha:<mtw:input type="password" name="senha" id="inputSenha"/>
                    </div>
                    <mtw:submit klass="btt botao" value="Entrar" />
                </div>
            </mtw:form>
        </div>
    </body>
</html>