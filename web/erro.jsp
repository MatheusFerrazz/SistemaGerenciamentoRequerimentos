<%-- 
    Document   : erro
    Created on : 24/02/2016, 19:48:00
    Author     : João
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>       
        <title>Ops! Falhou ...</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <p>
                <%
                    if(exception != null){
                        out.println("Ops! Falhou ... ");
                    }
                %>  
            </p>
            <a href="sgr_index.html">Voltar a página principal</a>
        </div>
    </body>
</html>
