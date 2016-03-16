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
	.divRequerimentoConsultado{display:none;padding-left:15px;;}
	.acao{display:none;}
	.divRequerimentoSolicitado{display:none;padding-left:15px;;}
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
				<div class="col-md-3"  id="divColunaFigura">
					<img alt="Bootstrap Image Preview" src="imagens/LogoIF.png" class="img-circle">
				</div>
				<div class="col-md-6" id="divColunaCabecalho">
					 
					<address>
						 <strong>Campus <%= aluno.getCurso().getCampus().getNome() %> - Diretoria Acadêmica</strong><br> <%= aluno.getCurso().getCampus().getEndereco() %>, <%= aluno.getCurso().getCampus().getNumero() %><br> <%= aluno.getCurso().getCampus().getCidade()+"/"+aluno.getCurso().getCampus().getEstado()+" - "+aluno.getCurso().getCampus().getBairro() %>, <%= aluno.getCurso().getCampus().getCep() %><br> Telefone: <%= aluno.getCurso().getCampus().getTelefone() %>
					</address>
                                        <br><h3 class="text-left" id="cabecalho">Bem vindo,<br> <%= aluno.getNome() %></h3>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
                                    <h3 class="text-left text-primary">
                                     Escolha o que deseja fazer
                                    </h3>
                                    <div class="row col-md-12 form-group" >
                                        <select id="acao" title="Selecione" class="form-control" style="width:26%;padding-right:0px;">                                           
                                          <option selected disabled style="padding-bottom: 1px; padding-top: 1px">Selecione</option>
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
                                    <div class="row col-md-12 form-group">
                                        <select id="selectSolicitaRequerimento" class="form-control" style="width:40%;padding-right:0px;">
                                          <option selected disabled style="padding-bottom: 1px; padding-top: 1px">Selecione</option>
                                        <% for(TipoRequerimento tipo : tiporequerimento.getTiposRequerimento()){%>
                                         <option value="<%= tipo.getId() %>"><%= tipo.getNome() %></option>
                                        <%} %>
                                        </select>
                                    </div>
                                        <% //Preenchendo as divis com os formulários e as informações do objeto aluno já preecarregados.
                                        for(TipoRequerimento tipo : tiporequerimento.getTiposRequerimento())
                                        {%>
                                        <div id="<%= tipo.getId()%>" class="divRequerimentoSolicitado row">                                            
                                            <div class="row col-md-12 form-group" >
                                            <form action="gravarequerimento.jsp" role="form" method="post" id="<%= "form"+tipo.getId() %>">                                            
                                                <input type="hidden" name="tipoRequerimento" value="<%= tipo.getId() %>">
                                                <h2>Senhor(a) Diretor Acadêmico: <%= aluno.getCurso().getCampus().getDiretor().getNome() %></h2>
                                                <h3><p>&emsp;Eu, <%= aluno.getNome() %>, matrícula <%= aluno.getMatricula() %>, aluno(a) do curso <%= aluno.getCurso().getModalidade().getNome() %> de nível <%= aluno.getCurso().getModalidade().getNivel() %> em <%= aluno.getCurso().getNome() %>, 
                                                 turma <%= aluno.getTurma().getCodigo() %>, telefone(s) <%= aluno.getTelefone() %> <%= " / "+aluno.getCelular()%>,  email <%= aluno.getEmail() %>, venho requerer a V. Sa.:</p></h3>                                                        
                                                <%//Preenchendo os formulários de acordo com o tipo de requerimento
                                                //int tipoReq = tipo.getId();
                                                //Aproveitamento de estudo
                                                if(tipo.getId()==1){%>
                                                    <br><label>Disciplina cursada:  <input type='text' name="disciplinaCursada" value=""></label>
                                                    <br><label> Disciplina curso atual: 
                                                        <select name="disciplinaCursoAtual" class="form-group">
                                                        <%for(Disciplina disci : aluno.getCurso().getDisciplinasDoCurso()){%>
                                                            <option value="<%= disci.getId() %>"><%= disci.getNome() %></option>
                                                        <%}%>
                                                    </select> </label>
                                                    <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form"+tipo.getId() %>"></textarea>               
                                                    <br><label>Documentos apresentados:</label>
                                                    <%for(Documento doc : documento.getDocumentos()){%>
                                                        <input type="checkbox" name="documentoApresentado" value="<%= doc.getId() %>"> <%= doc.getNome() %><br>
                                                    <%}%>
                                                    <div class="form-group">

                                                    <label for="exampleInputFile">
                                                            Anexar arquivo <input type="file" id="exampleInputFile">
                                                    </label>
                                                    <br><button type="submit" class="btn btn-primary">SOLICITAR</button>								
                                                <%//Certificação de conhecimentos
                                                }else if(tipo.getId()==2){%>

                                                    <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                <%}else if(tipo.getId()==3){%>
                                                    <br><button type="submit" class="btn btn-primary">SOLICITAR</button>              
                                                <%}else if(tipo.getId()==4){%>
                                                    <br><button type="submit" class="btn btn-primary">SOLICITAR</button>              
                                                <%}else if(tipo.getId()==5){%>
                                                    <br><button type="submit" class="btn btn-primary">SOLICITAR</button>              
                                                <%}else if(tipo.getId()==6){%>
                                                    <br><button type="submit" class="btn btn-primary">SOLICITAR</button>              
                                                <%}else if(tipo.getId()==7){%>
                                                    <br><button type="submit" class="btn btn-primary">SOLICITAR</button>              
                                                 <%}else if(tipo.getId()==8){%>
                                                    <br><button type="submit" class="btn btn-primary">SOLICITAR</button>  
                                                <%}else if(tipo.getId()==9){%>
                                                    <br><button type="submit" class="btn btn-primary">SOLICITAR</button>  
                                                <%}else if(tipo.getId()==10){%>             
                                                    <br><button type="submit" class="btn btn-primary">SOLICITAR</button>  
                                                <%}else if(tipo.getId()==11){%>
                                                    <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                <%}else if(tipo.getId()==12){%>
                                                    <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                <%}else if(tipo.getId()==13){%>
                                                    <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                <%}else if(tipo.getId()==14){%>
                                                    <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                <%}else if(tipo.getId()==15){%>
                                                    <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                <%}else if(tipo.getId()==16){%>
                                                    <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                <%}else if(tipo.getId()==17){%>
                                                    <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                <%}else if(tipo.getId()==18){%>
                                                    <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                <%}else if(tipo.getId()==19){%>
                                                    <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                <%}else if(tipo.getId()==20){%>
                                                    <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                <%}else if(tipo.getId()==21){%>
                                                    <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                <%}else if(tipo.getId()==22){%>
                                                    <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                <%}else if(tipo.getId()==23){%>
                                                    <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                <%}%>                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
                                            </div>                                                 
                                        </form>
                                    </div>                                    					
                                    </div>
                                <%}%>
                            </div>
			</div>
                                            
                                            
                    <!--Div para as consultas-->
			<div id="consulta" class="row acao">
                            <div class="col-md-12" style="padding-left:28px">
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