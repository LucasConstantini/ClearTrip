<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/reset.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap-responsive.css" rel="stylesheet">
        <link href="css/tabela.css" rel="stylesheet">
        <style>
            body {
                padding-top: 60px;
            }
        </style>
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <title>Acadêmico</title>     
    </head>
    <body>
        <div class="container">
            <template:block id="header"/>
            <template:block id="body"/>
            <template:block id="footer"/>
        </div>
    </body>
</html>
