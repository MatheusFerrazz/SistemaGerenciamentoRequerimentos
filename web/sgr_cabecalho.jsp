<%-- 
    Document   : newjsp
    Created on : 24/03/2016, 14:04:31
    Author     : CH
--%>
<%@page import="br.edu.ifrn.sgr.modelos.Turma"%>
<%@page import="br.edu.ifrn.sgr.modelos.Turno"%>
<%@page import="br.edu.ifrn.sgr.modelos.Curso"%>
<%@page import="br.edu.ifrn.sgr.modelos.Professor"%>
<%@page import="br.edu.ifrn.sgr.modelos.Disciplina"%>
<%@page import="br.edu.ifrn.sgr.modelos.Documento"%>
<%@page import="br.edu.ifrn.sgr.modelos.TipoRequerimento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.edu.ifrn.sgr.modelos.Aluno"%>
<%@page import="br.edu.ifrn.sgr.persistencias.AlunoDAO"%>
<%@page import="br.edu.ifrn.sgr.persistencias.FabricaConexao"%>
<%@page import="br.edu.ifrn.sgr.persistencias.TiposRequeriemtoDAO"%>
<%@page import="br.edu.ifrn.sgr.persistencias.GeralDAO"%>
<%@page import="java.sql.*"%>


<jsp:useBean id="alunoDAO" class="br.edu.ifrn.sgr.persistencias.AlunoDAO" scope="request"/>
<jsp:useBean id="tiporequerimento" class="br.edu.ifrn.sgr.persistencias.TiposRequeriemtoDAO" scope="request"/>
<jsp:useBean id="documento" class="br.edu.ifrn.sgr.persistencias.DocumentoDAO" scope="request"/>
<jsp:setProperty name="dao" property="*"></jsp:setProperty>
<jsp:setProperty name="tiporequerimento" property="*"></jsp:setProperty>


<%
    //Resgatando o objeto aluno pela sessão
    Aluno aluno = (Aluno) session.getAttribute("aluno");
%>  
<!DOCTYPE html>
<html lang="pt-BR">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SGR - Sistema de Gerenciamento de Requerimentos</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/sb-admin.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="css/plugins/morris.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <script>
            //Funlçao jquery que escolhe entre listar requerimentos e fazer requerimentos
            $(function () {
                $('#acao').change(function () {
                    $('.acao').hide();
                    $('#' + $(this).val()).show();
                });
            });

            //Função jquery para mostrar a div de preencheencimento do requerimento solicitado
            $(function () {
                $('#selectSolicitaRequerimento').change(function () {
                    $('.divRequerimentoSolicitado').hide();
                    $('#' + $(this).val()).show();
                });
            });

            //Mostra a div de consulta solicitada   
            $(function () {
                $('#selectConsultaRequerimento').change(function () {
                    $('.divRequerimentoConsultado').hide();
                    $('#' + $(this).val()).show();
                });
            });
        </script>
                                
            <script src="js/jquery.min.js"></script>
            <script>
                //Script para carregar os requerimentos em andamento
                $(function()
                {
                        $( "#andamento" ).click(function(e)
                        {
                          $("#corpo").load("listagem_emandamento.jsp");
                          e.preventDefault();
                        });
                });

                //Script para carregar os requerimentos em indeferidos
                    $(function()
                {
                        $( "#indeferido" ).click(function(e)
                        {
                          $("#corpo").load("listagem_indeferidos.jsp");
                          e.preventDefault();
                        });
                });
                
                //Script para carregar as solicitações de requerimento
                $(function()
                {
                        $( "#deferido" ).click(function(e)
                        {
                          $("#corpo").load("listagem_deferidos.jsp");
                          e.preventDefault();
                        });
                });
                
                $(function()
                {
                        $( "#solicitar" ).click(function(e)
                        {
                          $("#corpo").load("sgr_solicitar_requerimento.jsp");
                          e.preventDefault();
                        });
                });                
        </script>
    </head>

    <body>

        <div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html">SGR</a>
                </div>
                <!-- Top Menu Items -->
                <ul class="nav navbar-right top-nav">

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <%= aluno.getNome()%><b class="caret"></b></a>
                        <ul class="dropdown-menu">                                       
                            <li>
                                <a href="ControladorLogout"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                            </li>
                        </ul>
                    </li>
                </ul>