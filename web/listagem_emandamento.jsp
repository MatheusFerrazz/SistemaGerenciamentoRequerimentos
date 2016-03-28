<%-- 
    Document   : tiposrequerimentos
    Created on : 09/03/2016, 22:21:09
    Author     : Luan Medeiros
--%>

<%@page import="java.util.ArrayList"%>
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
                                                         
                                                           
                                                    


                   
                    
<% ArrayList<RequerimentoPopuladoString> listarequerimentos = new ArrayList<>(); %>
            <!-- Div para as consultas -->
            <div id="consulta" class="row acao">
                <div class="col-md-12" style="padding-left:28px">
                    <!--Div requerimentos em andamento-->
                    <div id="requerimentos_deferidos">
                        <h1><font color = "#1E90FF">EM ANDAMENTO</font></h1><br>
                        <% listarequerimentos = requerimentos.populaAproveitaMentoDeEstudo(EnuConsultasRequerimento.SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_POR_TIPO_REQUERIMENTO_E_IDALUNO.toString(), 1, aluno.getMatricula());
                          if(!listarequerimentos.isEmpty()){
                        %>
                        <div id="aproveitamento_de_estudo">
                            <div class="container">
                                <h3>APROVEITAMENTO DE ESTUDO</h3>  
                                <div class="panel-group" id="accordion">
                                <%for (RequerimentoPopuladoString req : listarequerimentos) {%>                    
                                
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                              <a data-toggle="collapse" data-parent="#accordion" href="#<%= req.getRequerimentoID() %>" ><b>++ DETALHES </b> </a>REQUERIMENTO N° <%= req.getRequerimentoID() %>
                                            </h4>
                                        </div>
                                        <div id="<%= req.getRequerimentoID() %>" class="panel-collapse collapse in">
                                            <div class="panel-body">
                                                  <p>Requerimento solicitado no dia <%= req.getDataSolicitacaoRequerimento() %><br>
                                                      
                                                      
                                               <p><b>DISCIPLINA CURSADA: </b> <%= req.getDisciplinaCursada() %></p>
                                               <p><b>DISCIPLINA CURSO ATUAL: </b> <%= req.getDisciplinaCursoAtual() %></p>
                                               <p><b>OBSERVAÇÔES: </b> <%= req.getObservacoes() %></p>                                               
                                               <!--DOCUMENTOS APRESENTADO-->
                                               <%if(!req.getDocumentosApresentados().isEmpty()){%>
                                                <br><b>DOCUMENTOS APRESENTADOS</b>                                               
                                                   <% for(String doc : req.getDocumentosApresentados()){%> 
                                                        <LI><%= doc%></LI>
                                                   <%}%>
                                               <%}%>       
                                            </div>
                                        </div>
                                    </div>                                                                                                                             
                                <%} listarequerimentos.clear(); %>
                                </div>
                            </div> 
                        </div>
                        <%}%>
                        
                        
                        
                        <% listarequerimentos = requerimentos.populaCertificacaoDeConhecimento(EnuConsultasRequerimento.SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_POR_TIPO_REQUERIMENTO_E_IDALUNO.toString(), 2, aluno.getMatricula());
                          if(!listarequerimentos.isEmpty()){
                        %>
                        <div id="cartificacao_de_conhecimento">
                            <div class="container">
                                <h3>CERTIFICAÇÃO DE CONHECIMENTOS</h3>  
                                <div class="panel-group" id="accordion">
                                <%for (RequerimentoPopuladoString req : listarequerimentos) {%>                    
                                
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                              <a data-toggle="collapse" data-parent="#accordion" href="#<%= req.getRequerimentoID() %>" aria-expanded="false" style="height: 0px;"><b>++ DETALHES </b> </a>REQUERIMENTO N° <%= req.getRequerimentoID() %>
                                            </h4>
                                        </div>
                                        <div id="<%= req.getRequerimentoID() %>" class="panel-collapse collapse in">
                                            <div class="panel-body">
                                                  <p>Requerimento solicitado no dia <%= req.getDataSolicitacaoRequerimento() %><br>

                                               <p><b>DISCIPLINA PARA CERTIFICAÇÃO: </b> <%= req.getDisciplinaCertificacao() %><p>
                                               <p><b>OBSERVAÇÔES: </b> <%= req.getObservacoes() %></p>                                                                                                    
                                            </div>
                                        </div>
                                    </div>                                                                                                                             
                                <%} listarequerimentos.clear(); %>
                                </div>
                            </div> 
                        </div>
                        <%}%> 
                        
                        
                        
                        <% listarequerimentos = requerimentos.populaReposicaoAtividade(EnuConsultasRequerimento.SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_POR_TIPO_REQUERIMENTO_E_IDALUNO.toString(), 3, aluno.getMatricula());
                          if(!listarequerimentos.isEmpty()){
                        %>
                        <div id="reposicao_de_atividades">
                            <div class="container">
                                <h3>REPOSIÇÃO DE ATIVIDADES</h3>  
                                <div class="panel-group" id="accordion">
                                <%for (RequerimentoPopuladoString req : listarequerimentos) {%>                    
                                
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                              <a data-toggle="collapse" data-parent="#accordion" href="#<%= req.getRequerimentoID() %>" aria-expanded="false" style="height: 0px;"><b>++ DETALHES </b> </a>REQUERIMENTO N° <%= req.getRequerimentoID() %>
                                            </h4>
                                        </div>
                                        <div id="<%= req.getRequerimentoID() %>" class="panel-collapse collapse in">
                                            <div class="panel-body">
                                                  <p>Requerimento solicitado no dia <%= req.getDataSolicitacaoRequerimento() %><br>

                                                      
                                               <p><b>TIPO ATIVIDADE: </b> <%= req.getTipoAtividade() %></p>
                                               <p><b>PROFESSOR: </b> <%= req.getProfessorAtividade() %></p>
                                               <p><b>OBSERVAÇÔES: </b> <%= req.getObservacoes() %></p>                                               
                                               <!--DOCUMENTOS APRESENTADO-->
                                               <%if(!req.getDocumentosApresentados().isEmpty()){%>
                                                <br><b>DOCUMENTOS APRESENTADOS</b>                                               
                                                   <% for(String doc : req.getDocumentosApresentados()){%> 
                                                        <LI><%= doc%></LI>
                                                   <%}%>
                                               <%}%>                                                        
                                            </div>
                                        </div>
                                    </div>                                                                                                                             
                                <%} listarequerimentos.clear(); %>
                                </div>
                            </div> 
                        </div>
                        <%}%>                         
                        
                        
                        
                        <% listarequerimentos = requerimentos.populaMudancaCurso(EnuConsultasRequerimento.SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_POR_TIPO_REQUERIMENTO_E_IDALUNO.toString(), 4, aluno.getMatricula());
                          if(!listarequerimentos.isEmpty()){
                        %>
                        <div id="mudanca_de_curso">
                            <div class="container">
                                <h3>MUDANÇA DE CURSO</h3>  
                                <div class="panel-group" id="accordion">
                                <%for (RequerimentoPopuladoString req : listarequerimentos) {%>                    
                                
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                              <a data-toggle="collapse" data-parent="#accordion" href="#<%= req.getRequerimentoID() %>" aria-expanded="false" style="height: 0px;"><b>++ DETALHES </b> </a>REQUERIMENTO N° <%= req.getRequerimentoID() %>
                                            </h4>
                                        </div>
                                        <div id="<%= req.getRequerimentoID() %>" class="panel-collapse collapse in">
                                            <div class="panel-body">
                                                  <p>Requerimento solicitado no dia <%= req.getDataSolicitacaoRequerimento() %><br>
                               
                                                      
                                               <p><b>CURSO DESEJADO: </b> <%= req.getCursoDestino()%></p>       
                                               <p><b>OBSERVAÇÔES: </b> <%= req.getObservacoes() %></p>                                               
                                               <!--DOCUMENTOS APRESENTADO-->
                                               <%if(!req.getDocumentosApresentados().isEmpty()){%>
                                                <br><b>DOCUMENTOS APRESENTADOS</b>                                               
                                                   <% for(String doc : req.getDocumentosApresentados()){%> 
                                                        <LI><%= doc%></LI>
                                                   <%}%>
                                               <%}%>                                                      
                                            </div>
                                        </div>
                                    </div>                                                                                                                             
                                <%} listarequerimentos.clear(); %>
                                </div>
                            </div> 
                        </div>
                        <%}%>                         
                        
                        
                        
                        <% listarequerimentos = requerimentos.populaMudancaTurma(EnuConsultasRequerimento.SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_POR_TIPO_REQUERIMENTO_E_IDALUNO.toString(), 5, aluno.getMatricula());
                          if(!listarequerimentos.isEmpty()){
                        %>
                        <div id="mudanca_de_turma">
                            <div class="container">
                                <h3>MUDANÇA DE TURMA</h3>  
                                <div class="panel-group" id="accordion">
                                <%for (RequerimentoPopuladoString req : listarequerimentos) {%>                    
                                
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                              <a data-toggle="collapse" data-parent="#accordion" href="#<%= req.getRequerimentoID() %>" aria-expanded="false" style="height: 0px;"><b>++ DETALHES </b> </a>REQUERIMENTO N° <%= req.getRequerimentoID() %>
                                            </h4>
                                        </div>
                                        <div id="<%= req.getRequerimentoID() %>" class="panel-collapse collapse in">
                                            <div class="panel-body">
                                               <p>Requerimento solicitado no dia <%= req.getDataSolicitacaoRequerimento() %><br>
                                        
                                                      
                                                      
                                               <p><b>TURMA DESEJADA: </b> <%= req.getTurmaDestino() %></p>       
                                               <p><b>OBSERVAÇÔES: </b> <%= req.getObservacoes() %></p>                                               
                                               <!--DOCUMENTOS APRESENTADO-->
                                               <%if(!req.getDocumentosApresentados().isEmpty()){%>
                                                <br><b>DOCUMENTOS APRESENTADOS</b>                                               
                                                   <% for(String doc : req.getDocumentosApresentados()){%> 
                                                        <LI><%= doc%></LI>
                                                   <%}%>
                                               <%}%>                                                         
                                            </div>
                                        </div>
                                    </div>                                                                                                                             
                                <%} listarequerimentos.clear(); %>
                                </div>
                            </div> 
                        </div>
                        <%}%>                         
                        
                        
                        
                        <% listarequerimentos = requerimentos.populaMudancaTurno(EnuConsultasRequerimento.SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_POR_TIPO_REQUERIMENTO_E_IDALUNO.toString(), 6, aluno.getMatricula());
                          if(!listarequerimentos.isEmpty()){
                        %>
                        <div id="mudanca_de_turno">
                            <div class="container">
                                <h3>MUDANÇA DE TURNO</h3>  
                                <div class="panel-group" id="accordion">
                                <%for (RequerimentoPopuladoString req : listarequerimentos) {%>                    
                                
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#accordion" href="#<%= req.getRequerimentoID() %>" aria-expanded="false" style="height: 0px;"><b>++ DETALHES </b> </a>REQUERIMENTO N° <%= req.getRequerimentoID() %>
                                            </h4>
                                        </div>
                                        <div id="<%= req.getRequerimentoID() %>" class="panel-collapse collapse in">
                                            <div class="panel-body">
                                                  <p>Requerimento solicitado no dia <%= req.getDataSolicitacaoRequerimento() %><br>
                                                      
                                                      

                                                      
                                               <p><b>TURNO DESEJADO: </b> <%= req.getTurnoDestino() %></p>       
                                               <p><b>OBSERVAÇÔES: </b> <%= req.getObservacoes() %></p>                                               
                                               <!--DOCUMENTOS APRESENTADO-->
                                               <%if(!req.getDocumentosApresentados().isEmpty()){%>
                                                <br><b>DOCUMENTOS APRESENTADOS</b>                                               
                                                   <% for(String doc : req.getDocumentosApresentados()){%> 
                                                        <LI><%= doc%></LI>
                                                   <%}%>
                                               <%}%>                                                         
                                            </div>
                                        </div>
                                    </div>                                                                                                                             
                                <%} listarequerimentos.clear(); %>
                                </div>
                            </div> 
                        </div>
                        <%}%>                         

                        
                        
                        
                        <% listarequerimentos = requerimentos.populaTransferencia(EnuConsultasRequerimento.SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_POR_TIPO_REQUERIMENTO_E_IDALUNO.toString(), 7, aluno.getMatricula());
                          if(!listarequerimentos.isEmpty()){
                        %>
                        <div id="transferencia">
                            <div class="container">
                                <h3>TRANSFERÊNCIA</h3>  
                                <div class="panel-group" id="accordion">
                                <%for (RequerimentoPopuladoString req : listarequerimentos) {%>                    
                                
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                              <a data-toggle="collapse" data-parent="#accordion" href="#<%= req.getRequerimentoID() %>" aria-expanded="false" style="height: 0px;"><b>++ DETALHES </b> </a>REQUERIMENTO N° <%= req.getRequerimentoID() %>
                                            </h4>
                                        </div>
                                        <div id="<%= req.getRequerimentoID() %>" class="panel-collapse collapse in">
                                            <div class="panel-body">
                                                  <p>Requerimento solicitado no dia <%= req.getDataSolicitacaoRequerimento() %><br>
                                                      
                                               <p><b>CURSO ORIGEM: </b> <%= req.getTranferenciaCursoOrigem() %></p>                                                      
                                               <p><b>CURSO DESTINO: </b> <%= req.getTranferenciaCursoDestino() %></p>                                                      
                                               <p><b>ESCOLA ORIGEM: </b> <%= req.getTranferenciaEscolaOrigem() %></p>                                                
                                               <p><b>ESCOLA DESTINO: </b> <%= req.getTranferenciaEscolaDestino() %></p>                                               
                                               <p><b>OBSERVAÇÔES: </b> <%= req.getObservacoes() %></p>                                               
                                               <!--DOCUMENTOS APRESENTADO-->
                                               <%if(!req.getDocumentosApresentados().isEmpty()){%>
                                                <br><b>DOCUMENTOS APRESENTADOS</b>                                               
                                                   <% for(String doc : req.getDocumentosApresentados()){%> 
                                                        <LI><%= doc%></LI>
                                                   <%}%>
                                               <%}%>                                                         
                                            </div>
                                        </div>
                                    </div>                                                                                                                             
                                <%} listarequerimentos.clear(); %>
                                </div>
                            </div> 
                        </div>
                        <%}%> 
                        
                        
                        
                        <% listarequerimentos = requerimentos.populaLancamentoRevisaoFaltas(EnuConsultasRequerimento.SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_POR_TIPO_REQUERIMENTO_E_IDALUNO.toString(), 8, aluno.getMatricula());
                          if(!listarequerimentos.isEmpty()){
                        %>
                        <div id="lancamento_revisao_faltas">
                            <div class="container">
                                <h3>LANÇAMENTO OU REVISÃO DE FALTAS/NOTAS/SITUAÇÃO</h3>  
                                <div class="panel-group" id="accordion">
                                <%for (RequerimentoPopuladoString req : listarequerimentos) {%>                    
                                
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                              <a data-toggle="collapse" data-parent="#accordion" href="#<%= req.getRequerimentoID() %>" aria-expanded="false" style="height: 0px;"><b>++ DETALHES </b> </a>REQUERIMENTO N° <%= req.getRequerimentoID() %>
                                            </h4>
                                        </div>
                                        <div id="<%= req.getRequerimentoID() %>" class="panel-collapse collapse in">
                                            <div class="panel-body">
                                                  <p>Requerimento solicitado no dia <%= req.getDataSolicitacaoRequerimento() %><br>
                                                      
       
                                               <p><b>OBSERVAÇÔES: </b> <%= req.getObservacoes() %></p>                                               
                                               <!--DOCUMENTOS APRESENTADO-->
                                               <%if(!req.getDocumentosApresentados().isEmpty()){%>
                                                <br><b>DOCUMENTOS APRESENTADOS</b>                                               
                                                   <% for(String doc : req.getDocumentosApresentados()){%> 
                                                        <LI><%= doc%></LI>
                                                   <%}%>
                                               <%}%>                                                         
                                            </div>
                                        </div>
                                    </div>                                                                                                                             
                                <%} listarequerimentos.clear(); %>
                                </div>
                            </div> 
                        </div>
                        <%}%> 
                        
                        
                        
                        <% listarequerimentos = requerimentos.populaRenovacaoMatricula(EnuConsultasRequerimento.SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_POR_TIPO_REQUERIMENTO_E_IDALUNO.toString(), 9, aluno.getMatricula());
                          if(!listarequerimentos.isEmpty()){
                        %>
                        <div id="renovacao_matricula">
                            <div class="container">
                                <h3>RENOVAÇÃO MATRÍCULA</h3>  
                                <div class="panel-group" id="accordion">
                                <%for (RequerimentoPopuladoString req : listarequerimentos) {%>                    
                                
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                              <a data-toggle="collapse" data-parent="#accordion" href="#<%= req.getRequerimentoID() %>" aria-expanded="false" style="height: 0px;"><b>++ DETALHES </b> </a>REQUERIMENTO N° <%= req.getRequerimentoID() %>
                                            </h4>
                                        </div>
                                        <div id="<%= req.getRequerimentoID() %>" class="panel-collapse collapse in">
                                            <div class="panel-body">
                                                  <p>Requerimento solicitado no dia <%= req.getDataSolicitacaoRequerimento() %><br>
                                                      
                                                      
                                                      
                                               <p><b>OBSERVAÇÔES: </b> <%= req.getObservacoes() %></p>                                               
                                               <!--DOCUMENTOS APRESENTADO-->
                                               <%if(!req.getDocumentosApresentados().isEmpty()){%>
                                                <br><b>DOCUMENTOS APRESENTADOS</b>                                               
                                                   <% for(String doc : req.getDocumentosApresentados()){%> 
                                                        <LI><%= doc%></LI>
                                                   <%}%>
                                               <%}%>                                                          
                                            </div>
                                        </div>
                                    </div>                                                                                                                             
                                <%} listarequerimentos.clear(); %>
                                </div>
                            </div> 
                        </div>
                        <%}%> 
                        
                        
                        
                        <% listarequerimentos = requerimentos.populaReaberturaMatricula(EnuConsultasRequerimento.SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_POR_TIPO_REQUERIMENTO_E_IDALUNO.toString(), 10, aluno.getMatricula());
                          if(!listarequerimentos.isEmpty()){
                        %>
                        <div id="reabertura_matricula">
                            <div class="container">
                                <h3>REABERTURA MATRÍCULA</h3>  
                                <div class="panel-group" id="accordion">
                                <%for (RequerimentoPopuladoString req : listarequerimentos) {%>                    
                                
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                              <a data-toggle="collapse" data-parent="#accordion" href="#<%= req.getRequerimentoID() %>" aria-expanded="false" style="height: 0px;"><b>++ DETALHES </b> </a>REQUERIMENTO N° <%= req.getRequerimentoID() %>
                                            </h4>
                                        </div>
                                        <div id="<%= req.getRequerimentoID() %>" class="panel-collapse collapse in">
                                            <div class="panel-body">
                                                  <p>Requerimento solicitado no dia <%= req.getDataSolicitacaoRequerimento() %><br>
                                                      
                                                      
                                                      
                                               <p><b>OBSERVAÇÔES: </b> <%= req.getObservacoes() %></p>                                               
                                               <!--DOCUMENTOS APRESENTADO-->
                                               <%if(!req.getDocumentosApresentados().isEmpty()){%>
                                                <br><b>DOCUMENTOS APRESENTADOS</b>                                               
                                                   <% for(String doc : req.getDocumentosApresentados()){%> 
                                                        <LI><%= doc%></LI>
                                                   <%}%>
                                               <%}%>                                                         
                                            </div>
                                        </div>
                                    </div>                                                                                                                             
                                <%} listarequerimentos.clear(); %>
                                </div>
                            </div> 
                        </div>
                        <%}%> 
                        
                        
                        
                        <% listarequerimentos = requerimentos.populaJustificativaDeFaltasEmAnexo(EnuConsultasRequerimento.SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_POR_TIPO_REQUERIMENTO_E_IDALUNO.toString(), 11, aluno.getMatricula());
                          if(!listarequerimentos.isEmpty()){
                        %>
                        <div id="justificativa_faltas_anexo">
                            <div class="container">
                                <h3>JUSTIFICATIVA DE FALTAS (DIAS EM ANEXO)</h3>  
                                <div class="panel-group" id="accordion">
                                <%for (RequerimentoPopuladoString req : listarequerimentos) {%>                    
                                
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                              <a data-toggle="collapse" data-parent="#accordion" href="#<%= req.getRequerimentoID() %>" aria-expanded="false" style="height: 0px;"><b>++ DETALHES </b> </a>REQUERIMENTO N° <%= req.getRequerimentoID() %>
                                            </h4>
                                        </div>
                                        <div id="<%= req.getRequerimentoID() %>" class="panel-collapse collapse in">
                                            <div class="panel-body">
                                                  <p>Requerimento solicitado no dia <%= req.getDataSolicitacaoRequerimento() %><br>
                                                                                                                                                                  
                                               <p><b>OBSERVAÇÔES: </b> <%= req.getObservacoes() %></p>                                               
                                               <!--DOCUMENTOS APRESENTADO-->
                                               <%if(!req.getDocumentosApresentados().isEmpty()){%>
                                                <br><b>DOCUMENTOS APRESENTADOS</b>                                               
                                                   <% for(String doc : req.getDocumentosApresentados()){%> 
                                                        <LI><%= doc%></LI>
                                                   <%}%>
                                               <%}%>                                                         
                                            </div>
                                        </div>
                                    </div>                                                                                                                             
                                <%} listarequerimentos.clear(); %>
                                </div>
                            </div> 
                        </div>
                        <%}%> 
                        
                        
                        
                        <% listarequerimentos = requerimentos.populaJustificativaDeFaltaDiaEspecifico(EnuConsultasRequerimento.SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_POR_TIPO_REQUERIMENTO_E_IDALUNO.toString(), 12, aluno.getMatricula());
                          if(!listarequerimentos.isEmpty()){
                        %>
                        <div id="justifica_falta_dia_especifico">
                            <div class="container">
                                <h3>JUSTIFICATIVA DE FALTA - DIA ESPECÍFICO</h3>  
                                <div class="panel-group" id="accordion">
                                <%for (RequerimentoPopuladoString req : listarequerimentos) {%>                    
                                
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                              <a data-toggle="collapse" data-parent="#accordion" href="#<%= req.getRequerimentoID() %>" aria-expanded="false" style="height: 0px;"><b>++ DETALHES </b> </a>REQUERIMENTO N° <%= req.getRequerimentoID() %>
                                            </h4>
                                        </div>
                                        <div id="<%= req.getRequerimentoID() %>" class="panel-collapse collapse in">
                                            <div class="panel-body">
                                                  <p>Requerimento solicitado no dia <%= req.getDataSolicitacaoRequerimento() %><br>
                                                      
                                               <p><b>DIA DA FALTA: </b> <%= req.getDataFaltasDia() %></p>                                                      
                                               <p><b>OBSERVAÇÔES: </b> <%= req.getObservacoes() %></p>                                               
                                               <!--DOCUMENTOS APRESENTADO-->
                                               <%if(!req.getDocumentosApresentados().isEmpty()){%>
                                                <br><b>DOCUMENTOS APRESENTADOS</b>                                               
                                                   <% for(String doc : req.getDocumentosApresentados()){%> 
                                                        <LI><%= doc%></LI>
                                                   <%}%>
                                               <%}%>                                                        
                                            </div>
                                        </div>
                                    </div>                                                                                                                             
                                <%} listarequerimentos.clear(); %>
                                </div>
                            </div> 
                        </div>
                        <%}%> 
                        
                        
                        
                        <% listarequerimentos = requerimentos.populaJustificativaDeFaltasPeriodo(EnuConsultasRequerimento.SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_POR_TIPO_REQUERIMENTO_E_IDALUNO.toString(), 13, aluno.getMatricula());
                          if(!listarequerimentos.isEmpty()){
                        %>
                        <div id="justifica_falta_periodo">
                            <div class="container">
                                <h3>JUSTIFICATIVA DE FALTA POR PERÍODO</h3>  
                                <div class="panel-group" id="accordion">
                                <%for (RequerimentoPopuladoString req : listarequerimentos) {%>                    
                                
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                              <a data-toggle="collapse" data-parent="#accordion" href="#<%= req.getRequerimentoID() %>" aria-expanded="false" style="height: 0px;"><b>++ DETALHES </b> </a>REQUERIMENTO N° <%= req.getRequerimentoID() %>
                                            </h4>
                                        </div>
                                        <div id="<%= req.getRequerimentoID() %>" class="panel-collapse collapse in">
                                            <div class="panel-body">
                                                  <p>Requerimento solicitado no dia <%= req.getDataSolicitacaoRequerimento() %><br>
                                                      
                                               <p><b>DE: </b> <%= req.getDataFaltasDe() %></p>
                                               <p><b>ATE: </b> <%= req.getDataFaltasAte() %></p>                                               
                                               <p><b>OBSERVAÇÔES: </b> <%= req.getObservacoes() %></p>                                               
                                               <!--DOCUMENTOS APRESENTADO-->
                                               <%if(!req.getDocumentosApresentados().isEmpty()){%>
                                                <br><b>DOCUMENTOS APRESENTADOS</b>                                               
                                                   <% for(String doc : req.getDocumentosApresentados()){%> 
                                                        <LI><%= doc%></LI>
                                                   <%}%>
                                               <%}%>                                                         
                                            </div>
                                        </div>
                                    </div>                                                                                                                             
                                <%} listarequerimentos.clear(); %>
                                </div>
                            </div> 
                        </div>
                        <%}%> 
                        
                        
                        
                        <% listarequerimentos = requerimentos.populaTrancamentoDeMatricula(EnuConsultasRequerimento.SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_POR_TIPO_REQUERIMENTO_E_IDALUNO.toString(), 14, aluno.getMatricula());
                          if(!listarequerimentos.isEmpty()){
                        %>
                        <div id="trancamento_matricula_periodo">
                            <div class="container">
                                <h3>TRANCAMENTO DE MATRÍCULA - PERÍODO</h3>  
                                <div class="panel-group" id="accordion">
                                <%for (RequerimentoPopuladoString req : listarequerimentos) {%>                    
                                
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                              <a data-toggle="collapse" data-parent="#accordion" href="#<%= req.getRequerimentoID() %>" aria-expanded="false" style="height: 0px;"><b>++ DETALHES </b> </a>REQUERIMENTO N° <%= req.getRequerimentoID() %>
                                            </h4>
                                        </div>
                                        <div id="<%= req.getRequerimentoID() %>" class="panel-collapse collapse in">
                                            <div class="panel-body">
                                                  <p>Requerimento solicitado no dia <%= req.getDataSolicitacaoRequerimento() %><br>
                                                      
                                                      
                                               <p><b>OBSERVAÇÔES: </b> <%= req.getObservacoes() %></p>                                               
                                               <!--DOCUMENTOS APRESENTADO-->
                                               <%if(!req.getDocumentosApresentados().isEmpty()){%>
                                                <br><b>DOCUMENTOS APRESENTADOS</b>                                               
                                                   <% for(String doc : req.getDocumentosApresentados()){%> 
                                                        <LI><%= doc%></LI>
                                                   <%}%>
                                               <%}%>                                                         
                                            </div>
                                        </div>
                                    </div>                                                                                                                             
                                <%} listarequerimentos.clear(); %>
                                </div>
                            </div> 
                        </div>
                        <%}%> 
                        
                        
                        
                        <% listarequerimentos = requerimentos.populaTrancamentoDeMatriculaCompusorio(EnuConsultasRequerimento.SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_POR_TIPO_REQUERIMENTO_E_IDALUNO.toString(), 15, aluno.getMatricula());
                          if(!listarequerimentos.isEmpty()){
                        %>
                        <div id="trancamento_matricula_compulsorio">
                            <div class="container">
                                <h3>TRANCAMENTO DE MATRÍCULA - COMPULSÓRIO</h3>  
                                <div class="panel-group" id="accordion">
                                <%for (RequerimentoPopuladoString req : listarequerimentos) {%>                    
                                
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                              <a data-toggle="collapse" data-parent="#accordion" href="#<%= req.getRequerimentoID() %>" aria-expanded="false" style="height: 0px;"><b>++ DETALHES </b> </a>REQUERIMENTO N° <%= req.getRequerimentoID() %>
                                            </h4>
                                        </div>
                                        <div id="<%= req.getRequerimentoID() %>" class="panel-collapse collapse in">
                                            <div class="panel-body">
                                                  <p>Requerimento solicitado no dia<%= req.getDataSolicitacaoRequerimento() %><br>
                                                      
                                                      
                                               <p><b>OBSERVAÇÔES: </b> <%= req.getObservacoes() %></p>                                               
                                               <!--DOCUMENTOS APRESENTADO-->
                                               <%if(!req.getDocumentosApresentados().isEmpty()){%>
                                                <br><b>DOCUMENTOS APRESENTADOS</b>                                               
                                                   <% for(String doc : req.getDocumentosApresentados()){%> 
                                                        <LI><%= doc%></LI>
                                                   <%}%>
                                               <%}%>                                                         
                                            </div>
                                        </div>
                                    </div>                                                                                                                             
                                <%} listarequerimentos.clear(); %>
                                </div>
                            </div> 
                        </div>
                        <%}%> 
                        
                        
                        
                        <% listarequerimentos = requerimentos.populaCancelamentoDeMatricula(EnuConsultasRequerimento.SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_POR_TIPO_REQUERIMENTO_E_IDALUNO.toString(), 16, aluno.getMatricula());
                          if(!listarequerimentos.isEmpty()){
                        %>
                        <div id="cancelamento_matricula">
                            <div class="container">
                                <h3>CANCELAMENTO DE MATRÍCULA</h3>  
                                <div class="panel-group" id="accordion">
                                <%for (RequerimentoPopuladoString req : listarequerimentos) {%>                    
                                
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                              <a data-toggle="collapse" data-parent="#accordion" href="#<%= req.getRequerimentoID() %>" aria-expanded="false" style="height: 0px;"><b>++ DETALHES </b> </a>REQUERIMENTO N° <%= req.getRequerimentoID() %>
                                            </h4>
                                        </div>
                                        <div id="<%= req.getRequerimentoID() %>" class="panel-collapse collapse in">
                                            <div class="panel-body">
                                                  <p>Requerimento solicitado no dia <%= req.getDataSolicitacaoRequerimento() %><br>
                                                      
                                                      
                                               <!--DOCUMENTOS APRESENTADO-->
                                               <%if(!req.getDocumentosApresentados().isEmpty()){%>
                                                <b>DOCUMENTOS APRESENTADOS</b><br>
                                                <UL TYPE="square">
                                                   <% for(String doc : req.getDocumentosApresentados()){%> 
                                                        <LI><%= doc%></LI>
                                                   <%}%>
                                                </UL>
                                               <%}%>                                                       
                                            </div>
                                        </div>
                                    </div>                                                                                                                             
                                <%} listarequerimentos.clear(); %>
                                </div>
                            </div> 
                        </div>
                        <%}%> 
                        
                        
                        
                        <% listarequerimentos = requerimentos.populaAtendimentoDomiciliar(EnuConsultasRequerimento.SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_POR_TIPO_REQUERIMENTO_E_IDALUNO.toString(), 17, aluno.getMatricula());
                          if(!listarequerimentos.isEmpty()){
                        %>
                        <div id="atendimento_domiciliar">
                            <div class="container">
                                <h3>ATENDIMENTO DOMICILIAR</h3>  
                                <div class="panel-group" id="accordion">
                                <%for (RequerimentoPopuladoString req : listarequerimentos) {%>                    
                                
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                              <a data-toggle="collapse" data-parent="#accordion" href="#<%= req.getRequerimentoID() %>" aria-expanded="false" style="height: 0px;"><b>++ DETALHES </b> </a>REQUERIMENTO N° <%= req.getRequerimentoID() %>
                                            </h4>
                                        </div>
                                        <div id="<%= req.getRequerimentoID() %>" class="panel-collapse collapse in">
                                            <div class="panel-body">
                                                  <p>Requerimento solicitado no dia <%= req.getDataSolicitacaoRequerimento() %><br>
                                                      
                                                      
                                               <p><b>OBSERVAÇÔES: </b> <%= req.getObservacoes() %></p>                                               
                                               <!--DOCUMENTOS APRESENTADO-->
                                               <%if(!req.getDocumentosApresentados().isEmpty()){%>
                                                <br><b>DOCUMENTOS APRESENTADOS</b>                                               
                                                   <% for(String doc : req.getDocumentosApresentados()){%> 
                                                        <LI><%= doc%></LI>
                                                   <%}%>
                                               <%}%>                                                         
                                            </div>
                                        </div>
                                    </div>                                                                                                                             
                                <%} listarequerimentos.clear(); %>
                                </div>
                            </div> 
                        </div>
                        <%}%> 
                        
                        
                        
                        <% listarequerimentos = requerimentos.populaOutros(EnuConsultasRequerimento.SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_POR_TIPO_REQUERIMENTO_E_IDALUNO.toString(), 18, aluno.getMatricula());
                          if(!listarequerimentos.isEmpty()){
                        %>
                        <div id="outros">
                            <div class="container">
                                <h3>OUTROS</h3>  
                                <div class="panel-group" id="accordion">
                                <%for (RequerimentoPopuladoString req : listarequerimentos) {%>                    
                                
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                              <a data-toggle="collapse" data-parent="#accordion" href="#<%= req.getRequerimentoID() %>" aria-expanded="false" style="height: 0px;"><b>++ DETALHES </b> </a>REQUERIMENTO N° <%= req.getRequerimentoID() %>
                                            </h4>
                                        </div>
                                        <div id="<%= req.getRequerimentoID() %>" class="panel-collapse collapse in">
                                            <div class="panel-body">
                                                  <p>Requerimento solicitado no dia <%= req.getDataSolicitacaoRequerimento() %><br>
                                                      
                                                      
                                               <p><b>OBSERVAÇÔES: </b> <%= req.getObservacoes() %></p>                                               
                                               <!--DOCUMENTOS APRESENTADO-->
                                               <%if(!req.getDocumentosApresentados().isEmpty()){%>
                                                <br><b>DOCUMENTOS APRESENTADOS</b>                                               
                                                   <% for(String doc : req.getDocumentosApresentados()){%> 
                                                        <LI><%= doc%></LI>
                                                   <%}%>
                                               <%}%>                                                         
                                            </div>
                                        </div>
                                    </div>                                                                                                                             
                                <%} listarequerimentos.clear(); %>
                                </div>
                            </div> 
                        </div>
                        <%}%> 
                        
                        
                        
                        <% listarequerimentos = requerimentos.populaDispensaDeAtividades(EnuConsultasRequerimento.SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_POR_TIPO_REQUERIMENTO_E_IDALUNO.toString(), 19, aluno.getMatricula());
                          if(!listarequerimentos.isEmpty()){
                        %>
                        <div id="dispensa_atividades">
                            <div class="container">
                                <h3>DISPENSA DE ATIVIDADES</h3>  
                                <div class="panel-group" id="accordion">
                                <%for (RequerimentoPopuladoString req : listarequerimentos) {%>                    
                                
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                              <a data-toggle="collapse" data-parent="#accordion" href="#<%= req.getRequerimentoID() %>" aria-expanded="false" style="height: 0px;"><b>++ DETALHES </b> </a>REQUERIMENTO N° <%= req.getRequerimentoID() %>
                                            </h4>
                                        </div>
                                        <div id="<%= req.getRequerimentoID() %>" class="panel-collapse collapse in">
                                            <div class="panel-body">
                                                  <p>Requerimento solicitado no dia <%= req.getDataSolicitacaoRequerimento() %><br>
                                                      
                                                      
                                               <p><b>OBSERVAÇÔES: </b> <%= req.getObservacoes() %></p>                                               
                                               <!--DOCUMENTOS APRESENTADO-->
                                               <%if(!req.getDocumentosApresentados().isEmpty()){%>
                                                <br><b>DOCUMENTOS APRESENTADOS</b>                                               
                                                   <% for(String doc : req.getDocumentosApresentados()){%> 
                                                        <LI><%= doc%></LI>
                                                   <%}%>
                                               <%}%>                                                       
                                            </div>
                                        </div>
                                    </div>                                                                                                                             
                                <%} listarequerimentos.clear(); %>
                                </div>
                            </div> 
                        </div>
                        <%}%> 
                        
                        
                        
                        <% listarequerimentos = requerimentos.populaAdequacaoHorarios(EnuConsultasRequerimento.SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_POR_TIPO_REQUERIMENTO_E_IDALUNO.toString(), 20, aluno.getMatricula());
                          if(!listarequerimentos.isEmpty()){
                        %>
                        <div id="adequacao_de_horarios">
                            <div class="container">
                                <h3>ADEQUAÇÃO DE HORÁRIOS</h3>  
                                <div class="panel-group" id="accordion">
                                <%for (RequerimentoPopuladoString req : listarequerimentos) {%>                    
                                
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                              <a data-toggle="collapse" data-parent="#accordion" href="#<%= req.getRequerimentoID() %>" aria-expanded="false" style="height: 0px;"><b>++ DETALHES </b> </a>REQUERIMENTO N° <%= req.getRequerimentoID() %>
                                            </h4>
                                        </div>
                                        <div id="<%= req.getRequerimentoID() %>" class="panel-collapse collapse in">
                                            <div class="panel-body">
                                                  <p>Requerimento solicitado no dia <%= req.getDataSolicitacaoRequerimento() %><br>
                                                      
                                                      
                                               <p><b>OBSERVAÇÔES: </b> <%= req.getObservacoes() %></p>                                               
                                               <!--DOCUMENTOS APRESENTADO-->
                                               <%if(!req.getDocumentosApresentados().isEmpty()){%>
                                                <br><b>DOCUMENTOS APRESENTADOS</b>                                               
                                                   <% for(String doc : req.getDocumentosApresentados()){%> 
                                                        <LI><%= doc%></LI>
                                                   <%}%>
                                               <%}%>                                                        
                                            </div>
                                        </div>
                                    </div>                                                                                                                             
                                <%} listarequerimentos.clear(); %>
                                </div>
                            </div> 
                        </div>
                        <%}%> 
                        
                        
                        
                        <% listarequerimentos = requerimentos.populaEstudoIndividualizado(EnuConsultasRequerimento.SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_POR_TIPO_REQUERIMENTO_E_IDALUNO.toString(), 21, aluno.getMatricula());
                          if(!listarequerimentos.isEmpty()){
                        %>
                        <div id="estudo_individualizado">
                            <div class="container">
                                <h3>ESTUDO INDIVIDUALIZADO</h3>  
                                <div class="panel-group" id="accordion">
                                <%for (RequerimentoPopuladoString req : listarequerimentos) {%>                    
                                
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                              <a data-toggle="collapse" data-parent="#accordion" href="#<%= req.getRequerimentoID() %>" aria-expanded="false" style="height: 0px;"><b>++ DETALHES </b> </a>REQUERIMENTO N° <%= req.getRequerimentoID() %>
                                            </h4>
                                        </div>
                                        <div id="<%= req.getRequerimentoID() %>" class="panel-collapse collapse in">
                                            <div class="panel-body">
                                                  <p>Requerimento solicitado no dia <%= req.getDataSolicitacaoRequerimento() %><br>
                                                      
                                               <p><b>OBSERVAÇÔES: </b> <%= req.getObservacoes() %></p>                                               
                                               <!--DOCUMENTOS APRESENTADO-->
                                               <%if(!req.getDocumentosApresentados().isEmpty()){%>
                                                <br><b>DOCUMENTOS APRESENTADOS</b>                                               
                                                   <% for(String doc : req.getDocumentosApresentados()){%> 
                                                        <LI><%= doc%></LI>
                                                   <%}%>
                                               <%}%>                                                         
                                            </div>
                                        </div>
                                    </div>                                                                                                                             
                                <%} listarequerimentos.clear(); %>
                                </div>
                            </div> 
                        </div>
                        <%}%> 
                        
                        
                        
                        <% listarequerimentos = requerimentos.populaInclusaoDisciplinas(EnuConsultasRequerimento.SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_POR_TIPO_REQUERIMENTO_E_IDALUNO.toString(), 22, aluno.getMatricula());
                          if(!listarequerimentos.isEmpty()){
                        %>
                        <div id="inclusao_disciplina">
                            <div class="container">
                                <h3>INCLUSÃO DE DISCIPLINAS</h3>  
                                <div class="panel-group" id="accordion">
                                <%for (RequerimentoPopuladoString req : listarequerimentos) {%>                    
                                
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                              <a data-toggle="collapse" data-parent="#accordion" href="#<%= req.getRequerimentoID() %>" aria-expanded="false" style="height: 0px;"><b>++ DETALHES </b> </a>REQUERIMENTO N° <%= req.getRequerimentoID() %>
                                            </h4>
                                        </div>
                                        <div id="<%= req.getRequerimentoID() %>" class="panel-collapse collapse in">
                                            <div class="panel-body">
                                                  <p>Requerimento solicitado no dia <%= req.getDataSolicitacaoRequerimento() %><br>
                                                      
                                                      
                                               <p><b>OBSERVAÇÔES: </b> <%= req.getObservacoes() %></p>                                               
                                               <!--DOCUMENTOS APRESENTADO-->
                                               <%if(!req.getDocumentosApresentados().isEmpty()){%>
                                                <br><b>DOCUMENTOS APRESENTADOS</b>                                               
                                                   <% for(String doc : req.getDocumentosApresentados()){%> 
                                                        <LI><%= doc%></LI>
                                                   <%}%>
                                               <%}%>                                                      
                                            </div>
                                        </div>
                                    </div>                                                                                                                             
                                <%} listarequerimentos.clear(); %>
                                </div>
                            </div> 
                        </div>
                        <%}%> 
                        
                        
                        
                        <% listarequerimentos = requerimentos.populaAproveitaMentoDeEstudo(EnuConsultasRequerimento.SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_POR_TIPO_REQUERIMENTO_E_IDALUNO.toString(), 23, aluno.getMatricula());
                          if(!listarequerimentos.isEmpty()){
                        %>
                        <div id="remocao_disciplinas">
                            <div class="container">
                                <h3>REMOÇÃO DE DISCIPLINAS</h3>  
                                <div class="panel-group" id="accordion">
                                <%for (RequerimentoPopuladoString req : listarequerimentos) {%>                    
                                
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                              <a data-toggle="collapse" data-parent="#accordion" href="#<%= req.getRequerimentoID() %>" aria-expanded="false" style="height: 0px;"><b>++ DETALHES </b> </a>REQUERIMENTO N° <%= req.getRequerimentoID() %>
                                            </h4>
                                        </div>
                                        <div id="<%= req.getRequerimentoID() %>" class="panel-collapse collapse in">
                                            <div class="panel-body">
                                                  <p>Requerimento solicitado no dia <%= req.getDataSolicitacaoRequerimento() %><br>
                                                      
                                                      
                                               <p><b>OBSERVAÇÔES: </b> <%= req.getObservacoes() %></p>                                               
                                               <!--DOCUMENTOS APRESENTADO-->
                                               <%if(!req.getDocumentosApresentados().isEmpty()){%>
                                                <br><b>DOCUMENTOS APRESENTADOS</b>                                               
                                                   <% for(String doc : req.getDocumentosApresentados()){%> 
                                                        <LI><%= doc%></LI>
                                                   <%}%>
                                               <%}%>                                                         
                                            </div>
                                        </div>
                                    </div>                                                                                                                             
                                <%} listarequerimentos.clear(); %>
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
                            


    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  </body>
</html>