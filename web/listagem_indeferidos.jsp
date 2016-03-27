<%-- 
    Document   : tiposrequerimentos
    Created on : 09/03/2016, 22:21:09
    Author     : Luan Medeiros
--%>

<%@page import="br.edu.ifrn.sgr.persistencias.EnuConsultasRequerimento"%>
<%@page import="br.edu.ifrn.sgr.modelos.Turma"%>
<%@page import="br.edu.ifrn.sgr.modelos.Turno"%>
<%@page import="br.edu.ifrn.sgr.modelos.Curso"%>
<%@page import="br.edu.ifrn.sgr.modelos.Professor"%>
<%@page import="br.edu.ifrn.sgr.modelos.Disciplina"%>
<%@page import="br.edu.ifrn.sgr.modelos.Documento"%>
<%@page import="br.edu.ifrn.sgr.modelos.TipoRequerimento"%>
<%@page import="br.edu.ifrn.sgr.modelos.RequerimentoPopuladoString"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.edu.ifrn.sgr.modelos.Aluno"%>
<%@page import="br.edu.ifrn.sgr.persistencias.AlunoDAO"%>
<%@page import="br.edu.ifrn.sgr.persistencias.FabricaConexao"%>
<%@page import="br.edu.ifrn.sgr.persistencias.TiposRequeriemtoDAO"%>
<%@page import="br.edu.ifrn.sgr.persistencias.GeralDAO"%>
<%@page import="java.sql.*"%>


<jsp:useBean id="alunoDAO" class="br.edu.ifrn.sgr.persistencias.AlunoDAO" scope="request"/>
<jsp:useBean id="tiporequerimento" class="br.edu.ifrn.sgr.persistencias.TiposRequeriemtoDAO" scope="request"/>
<jsp:useBean id="requerimentos" class="br.edu.ifrn.sgr.persistencias.RequerimentoDAO" scope="request"/>
<jsp:useBean id="documento" class="br.edu.ifrn.sgr.persistencias.DocumentoDAO" scope="request"/>
<jsp:setProperty name="dao" property="*"></jsp:setProperty>
<jsp:setProperty name="tiporequerimento" property="*"></jsp:setProperty>


<%
    //Resgatando o objeto aluno pela sessão
    Aluno aluno = (Aluno) session.getAttribute("aluno");
%>  

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>SGR - IFRN</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <!--Importando estilos-->
    <link href="css/estilos_personalizados.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/bootstrap-select.min.css" rel="stylesheet">
    <link href="css/base.css" rel="stylesheet">
    <link href="css/bootstrap-theme.min" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/highlight.css" rel="stylesheet">
    <link href="css/custom.css" rel="stylesheet">    
    <link href="css/estilos_personalizados.css" rel="stylesheet">

    <!--Ocultando as divs-->


	<!--Carregando arquivo jquery-->
	
        <script src="js/jquery.min.js"></script>
        <script src="js/scripts.js"></script>
	<script src="js/bootstrap-select.min.js"></script> 
        <script src="js/base.js"></script>        
        <script src="js/jquery.js"></script>

        
	<!--Funções usadas nos selects-->
	<script>
        //Script para exibição de detalhes do requerimento solicitado
        $(function () {

            $('.toggle').click(function (event) {
                event.preventDefault();
                var target = $(this).attr('href');
                
                $(target).toggleClass('hidden show');
            });

        });   
            
	//Funlçao jquery que escolhe entre listar requerimentos e fazer requerimentos
	$(function() {
	        $('#acao').change(function(){
	            $('.acao').hide();
	            $('#' + $(this).val()).show();
	        });
	    });

	//Função jquery para mostrar a div de preencheencimento do requerimento solicitado
	$(function() {
	        $('#selectSolicitaRequerimento').change(function(){
	            $('.divRequerimentoSolicitado').hide();
	            $('#' + $(this).val()).show();
	        });
	    });    
	    
	//Mostra a div de consulta solicitada   
	$(function() {
	        $('#selectConsultaRequerimento').change(function(){
	            $('.divRequerimentoConsultado').hide();
	            $('#' + $(this).val()).show();
	        });
	    });      
    </script>
  </head>
  <body>
                                                         
                                                           
                                                    


                   
                    
            <!-- Div para as consultas -->
            <div id="consulta" class="row acao">
                <div class="col-md-12" style="padding-left:28px">
                    <!--Div requerimentos em andamento-->
                    <div id="requerimentos_em_andamento">
                        <div id="aproveitamento_de_estudo">
                            <div class="container">
                                <h2>APROVEITAMENTO DE ESTUDO</h2>  
                                <div class="panel-group" id="accordion">
                                <%for (RequerimentoPopuladoString req : requerimentos.populaAproveitaMentoDeEstudo(EnuConsultasRequerimento.SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_POR_TIPO_REQUERIMENTO_E_IDALUNO.toString(), 1, aluno.getMatricula())) {%>                    
                                
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                              <a data-toggle="collapse" data-parent="#accordion" href="#<%= req.getRequerimentoID() %>" aria-expanded="false" style="height: 0px;">++ DETALHES </a>REQUERIMENTO N° <%= req.getRequerimentoID() %>
                                            </h4>
                                        </div>
                                        <div id="<%= req.getRequerimentoID() %>" class="panel-collapse collapse in">
                                            <div class="panel-body">
                                                  <p>Requerimento solicitado no dia<%= req.getDataSolicitacaoRequerimento() %><br>
                                            </div>
                                        </div>
                                    </div>                                                                                                                             
                                <%}%>
                                </div>
                            </div> 
                        </div>  
                    </div>        
                </div>
            </div>                      
                    
                                               
        </div>
    </div>
</div>
                            


    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  </body>
</html>