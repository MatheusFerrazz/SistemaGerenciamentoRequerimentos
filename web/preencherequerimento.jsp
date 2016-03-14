<%-- 
    Document   : tiposrequerimentos
    Created on : 09/03/2016, 22:21:09
    Author     : Luan Medeiros
--%>

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
<%@taglib uri="http://java.sun.com/jsp/jstl/core"
      prefix="c" %>

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
	<style>
	.divRequerimentoConsultado{display:none;}
	.acao{display:none;}
	.divRequerimentoSolicitado{display:none;}
	</style>

	<!--Carregando arquivo jquery-->
	
        <script src="js/jquery.min.js"></script>
        <script src="js/scripts.js"></script>
	<script src="js/bootstrap-select.min.js"></script> 
        <script src="js/base.js"></script>        
        <script src="js/jquery.js"></script>
        
	<!--Funções usadas nos selects-->
	<script>
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
    
    <div class="container-fluid" id="#divPrincipal">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-3" style="width:19%" id="divColunaFigura">
					<img alt="Bootstrap Image Preview" src="imagens/LogoIF.png" class="img-circle">
				</div>
				<div class="col-md-7" style="width:38%"id="divColunaCabecalho">
					 
					<address>
						 <strong>Campus <%= aluno.getCurso().getCampus().getNome() %> - Diretoria Acadêmica</strong><br> <%= aluno.getCurso().getCampus().getEndereco() %>, <%= aluno.getCurso().getCampus().getNumero() %><br> <%= aluno.getCurso().getCampus().getCidade()+" - "+aluno.getCurso().getCampus().getBairro() %>, <%= aluno.getCurso().getCampus().getCep() %><br> Telefone: <%= aluno.getCurso().getCampus().getTelefone() %>
					</address>
				</div>
				<div class="col-md-2" style="width:36%"id="divColunaBoasVindas">
					<h3 class="text-center" id="h3TextoBoasVindas">
                                            Bem vindo,<br> <%= aluno.getNome() %>
					</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
                                    <h3 class="text-left text-primary">
                                     Escolha o que deseja fazer
                                    </h3>
                                    <div class="row div-select col-md-12">
                                        <select id="acao" >
                                           <option value="">OPÇÔES</option>
                                          <option value="solicitacao">Solicitar Requerimento</option>
                                          <option value="consulta">Consultar Requerimentos</option>
                                        </select> 
                                    </div>
				</div>
			</div>
			<div id="solicitacao" class="row acao" >
				<div class="col-md-12">
					<h3 class="text-success">
						Requerimentos - Solicitações
					</h3>
					<div class="row div-select col-md-12">
                                            <select id="selectSolicitaRequerimento">
                                              <option value=""></option>
                                            <% for(TipoRequerimento tipo : tiporequerimento.getTiposRequerimento()){%>
                                             <option value="<%= tipo.getId() %>"><%= tipo.getNome() %></option>
                                            <%} %>
                                            </select>
					</div>
                                        <% //Preenchendo as divis com os formulários e as informações do objeto aluno já preecarregados.
                                        for(TipoRequerimento tipo : tiporequerimento.getTiposRequerimento())
                                        {%>
                                        <div id="<%= tipo.getId()%>" class="divRequerimentoSolicitado row">                                            
                                            <form action="gravarequerimento.jsp" role="form" method="post" id="<%= "form"+tipo.getId() %>">
                                                <div class="row col-md-12" >
                                                        <input type="hidden" name="tipoRequerimento" value="<%= tipo.getId() %>">
                                                        <h2>Senhor(a) Diretor Acadêmico: <%= aluno.getCurso().getCampus().getDiretor().getNome() %></h2>
                                                        <p>Eu, <%= aluno.getNome() %>", matrícula <%= aluno.getMatricula() %>, aluno(a) do curso <%= aluno.getCurso().getModalidade().getNome() %> de nível <%= aluno.getCurso().getModalidade().getNivel() %> em <%= aluno.getCurso().getNome() %>, 
                                                        turma <%= aluno.getTurma().getCodigo() %>, telefone(s) <%= aluno.getTelefone() %> <%= " / "+aluno.getCelular()%>,  email <%= aluno.getEmail() %>, venho requerer a V. Sa.:</p>
                                                        <p><a class="btn btn-primary btn-large" href="#">Learn more</a></p>
                                                </div>                                                 
                                            </form>
                                        </div>
                                        <%}%>					
						<div class="col-md-12">
							<form role="form">
								<div class="form-group">
									 
									<label for="exampleInputEmail1">
										Email address
									</label>
									<input type="text" class="form-control" id="exampleInputEmail1">
								</div>
								<div class="form-group">
									 
									<label for="exampleInputPassword1">
										Password
									</label>
									<input type="text" class="form-control" id="exampleInputPassword1">
								</div>
								<div class="form-group">
									 
									<label for="exampleInputFile">
										File input
									</label>
									<input type="file" id="exampleInputFile">
									<p class="help-block">
										Example block-level help text here.
									</p>
								</div>
								<div class="checkbox">
									 
									<label>
										<input type="checkbox"> Check me out
									</label>
								</div> 
								<button type="submit" class="btn btn-default">
									Submit
								</button>
							</form> 
							<button type="button" class="btn btn-primary">
								SOLICITAR
							</button>
						</div>
					</div>
				</div>
			</div>
                                            
                                            
                    <!--Div para as consultas-->
			<div id="consulta" class="row acao">
				<div class="col-md-12">
					<h3 class="text-danger">
						Requerimentos - Consultas
					</h3>
					<div class="row">
						<div class="col-md-12">
							<div class="btn-group dropup">
								 
								<button class="btn btn-default">
									Action
								</button> 
								<button data-toggle="dropdown" class="btn btn-default dropdown-toggle">
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li>
										<a href="#">Action</a>
									</li>
									<li class="disabled">
										<a href="#">Another action</a>
									</li>
									<li class="divider">
									</li>
									<li>
										<a href="#">Something else here</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
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