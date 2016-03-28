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
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
