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
<html lang="en">

    <head>
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

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SGR - Sistma de Gerenciamento de Requerimentos</title>

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
                                <a href="#"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                        <li>
                            <a href="index.html"><i class="fa fa-fw fa-dashboard"></i> Inicio</a>
                        </li>
                        <li class="active">
                            <a href="charts.html"><i class="fa fa-fw fa-bar-chart-o"></i> Solicitar Requerimento</a>
                        </li>
                        <li>
                            <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-arrows-v"></i> Consultar Requerimento <i class="fa fa-fw fa-caret-down"></i></a>
                            <ul id="demo" class="collapse">
                                <li>
                                    <a href="#">Em Andamento</a>
                                </li>
                                <li>
                                    <a href="#">Deferidos</a>
                                </li>
                                <li>
                                    <a href="#">Indeferidos</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </nav>

            <div id="page-wrapper">

              <div class="container-fluid" id="#divPrincipal">
            <div class="row">
                <div class="col-md-12">
                    <div class="row">
                        <div class="col-md-3"  id="divColunaFigura">
                            <img alt="Bootstrap Image Preview" src="imagens/LogoIF.png" class="img-circle">
                        </div>
                        <div class="col-md-6" id="divColunaCabecalho">

                            <address>
                                <strong>Campus <%= aluno.getCurso().getCampus().getNome()%> - Diretoria Acadêmica</strong><br> <%= aluno.getCurso().getCampus().getEndereco()%>, <%= aluno.getCurso().getCampus().getNumero()%><br> <%= aluno.getCurso().getCampus().getCidade() + "/" + aluno.getCurso().getCampus().getEstado() + " - " + aluno.getCurso().getCampus().getBairro()%>, <%= aluno.getCurso().getCampus().getCep()%><br> Telefone: <%= aluno.getCurso().getCampus().getTelefone()%>
                            </address>
                            <br><h3 class="text-left" id="cabecalho">Bem vindo,<br> <%= aluno.getNome()%></h3>
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
                            <div class="row col-md-12 form-group" style="clear: both">
                                <select id="selectSolicitaRequerimento" class="form-control" style="width:40%;padding-right:0px;;">
                                    <!--                                          <option selected disabled style="padding-bottom: 1px; padding-top: 1px">Selecione</option>-->
                                    <option title="SELECIONE" ></option>
                                    <% for (TipoRequerimento tipo : tiporequerimento.getTiposRequerimento()) {%>
                                    <option value="<%= tipo.getId()%>"><%= tipo.getNome()%></option>
                                    <%} %>
                                </select>
                            </div>
                            <% //Preenchendo as divis com os formulários e as informações do objeto aluno já preecarregados.
                                            for (TipoRequerimento tipo : tiporequerimento.getTiposRequerimento()) {%>
                            <div id="<%= tipo.getId()%>" class="divRequerimentoSolicitado row" style="clear: both;">                                            
                                <div class="row col-md-12 form-group" >
                                    <form action="gravarequerimento.jsp" role="form" method="post" id="<%= "form" + tipo.getId()%>">                                            
                                        <input type="hidden" name="tipo_requerimento" value="<%= tipo.getId()%>">
                                        <h2>Senhor(a) Diretor Acadêmico: <%= aluno.getCurso().getCampus().getDiretor().getNome()%></h2>
                                        <h3><p>&emsp;Eu, <%= aluno.getNome()%>, matrícula <%= aluno.getMatricula()%>, aluno(a) do curso <%= aluno.getCurso().getModalidade().getNome()%> de nível <%= aluno.getCurso().getModalidade().getNivel()%> em <%= aluno.getCurso().getNome()%>, 
                                                turma <%= aluno.getTurma().getCodigo()%>, telefone(s) <%= aluno.getTelefone()%> <%= " / " + aluno.getCelular()%>,  email <%= aluno.getEmail()%>, venho requerer a V. Sa.:</p></h3>                                                        
                                                <%//Preenchendo os formulários de acordo com o tipo de requerimento
                                                    //int tipoReq = tipo.getId();

                                                    //Aproveitamento de estudo
                                                    if (tipo.getId() == 1) {%>
                                        <br><label>Disciplina cursada:  <input type='text' name="disciplina_cursada" value="" required="true"></label>
                                        <br><label> Disciplina curso atual: 
                                            <select name="disciplina_cursoAtual" class="form-group" required="true">
                                                <option title="SELECIONE" ></option>
                                                <%for (Disciplina disci : aluno.getCurso().getDisciplinasDoCurso()) {%>
                                                <option value="<%= disci.getId()%>"><%= disci.getNome()%></option>
                                                <%}%>
                                            </select> </label>
                                        <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form" + tipo.getId()%>"></textarea>               
                                        <br><label>Documentos apresentados:</label>
                                        <%for (Documento doc : documento.getDocumentos()) {%>
                                        <input type="checkbox" name="documento_apresentado" value="<%= doc.getId()%>"> <%= doc.getNome()%><br>
                                        <%}%>
                                        <!--                                                <div class="form-group">                                                    -->
                                        <br><label for="exampleInputFile">
                                            Anexar arquivo <input type="file" id="exampleInputFile">
                                        </label>
                                        <br><button type="submit" class="btn btn-primary">SOLICITAR</button>                                                    
                                        <!--                                                </div>-->
                                        <%//Certificação de conhecimentos
                                                } else if (tipo.getId() == 2) {%>
                                        <br><label> Disciplina: 
                                            <select name="disciplina_certificacao" class="form-group" required="true">
                                                <option title="SELECIONE" ></option>
                                                <%for (Disciplina disci : aluno.getCurso().getDisciplinasDoCurso()) {%>
                                                <option value="<%= disci.getId()%>"><%= disci.getNome()%></option>
                                                <%}%>
                                            </select> </label>
                                        <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form" + tipo.getId()%>"></textarea>
                                        <br><button type="submit" class="btn btn-primary">SOLICITAR</button>                                                    
                                        <%//REPOSIÇÃO DE ATIVIDADES
                                                } else if (tipo.getId() == 3) {%>
                                        <br>Tipo de atividade<input type="text" name="tipo_atividade" required="true">
                                        <br><label> Professor: 
                                            <select name="professor_atividade" class="form-group" required="true">
                                                <option title="SELECIONE" ></option>
                                                <%for (Professor prof : aluno.getCurso().getProfessores()) {%>
                                                <option value="<%= prof.getMatricula()%>"><%= prof.getNome()%></option>
                                                <%}%>
                                            </select> </label>
                                        <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form" + tipo.getId()%>"></textarea>                                                    
                                        <br><button type="submit" class="btn btn-primary">SOLICITAR</button>              
                                        <%//MUDANÇA DE CURSO
                                                } else if (tipo.getId() == 4) {
                                                    if (!aluno.getCurso().getCursosTranferencia().isEmpty()) {%>
                                        <br><label> Curso desejado: 
                                            <select name="curso_tranfencia" class="form-group" required="true">
                                                <option title="SELECIONE" ></option>
                                                <%for (Curso curso : aluno.getCurso().getCursosTranferencia()) {%>
                                                <option value="<%= curso.getCursoID()%>"><%= curso.getNome() + " - CAMPUS " + curso.getCampus().getNome()%></option>
                                                <%}%>
                                            </select> </label>                                                
                                        <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form" + tipo.getId()%>"></textarea>
                                        <br><button type="submit" class="btn btn-primary">SOLICITAR</button>              
                                        <% } else {%><br><h2><font color="red">NÃO HÁ CURSOS DISPONÍVEIS PARA MUDANÇA!</font><h2> <% }%>
                                                <%//MUDANÇA DE TURMA
                                                } else if (tipo.getId() == 5) {
                                                    if (!aluno.getCurso().getTurmasTranferencia().isEmpty()) {%>
                                                <br><label> Turma desejada: 
                                                    <select name="turma_tranferencia" class="form-group" required="true">
                                                        <option title="SELECIONE" ></option>
                                                        <%for (Turma turma : aluno.getCurso().getTurmasTranferencia()) {%>
                                                        <option value="<%= turma.getCodigo()%>"><%= turma.getCodigo()%></option>
                                                        <%}%>
                                                    </select> </label>                                                 
                                                <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form" + tipo.getId()%>"></textarea>                                                
                                                <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                <% } else {%><br><h2><font color="red">NÃO HÁ TURMAS DISPONÍVEIS PARA MUDANÇA!</font><h2> <% }%>
                                                        <%//MUDANÇA DE TURNO
                                                } else if (tipo.getId() == 6) {
                                                    if (!aluno.getCurso().getTurnosTranferencia().isEmpty()) {%>
                                                        <br><label> Turno desejado: 
                                                            <select name="turno_tranferencia" class="form-group" required="true">
                                                                <option title="SELECIONE" ></option>
                                                                <%for (Turno turno : aluno.getCurso().getTurnosTranferencia()) {%>
                                                                <option value="<%= turno.getId()%>"><%= turno.getNome()%></option>
                                                                <%}%>
                                                            </select> </label>                                                 
                                                        <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form" + tipo.getId()%>"></textarea>
                                                        <br><button type="submit" class="btn btn-primary">SOLICITAR</button>              
                                                        <% } else {%><br><h2><font color="red">NÃO HÁ TURNOS DISPONÍVEIS PARA MUDANÇA!</font><h2> <% }%>
                                                                <%//TRANSFERÊNCIA
                                                } else if (tipo.getId() == 7) {%>
                                                                <br><label>Escola origem:  <input type='text' name="escola_origem" value="" required="true"></label>
                                                                <br><label>Curso origem:  <input type='text' name="curso_origem" value="" required="true"></label>
                                                                <br><label>Escola destino:  <input type='text' name="escola_destino" value="" required="true"></label>
                                                                <br><label>Curso destino:  <input type='text' name="curso_destino" value="" required="true"></label>
                                                                <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form" + tipo.getId()%>"></textarea>
                                                                <br><button type="submit" class="btn btn-primary">SOLICITAR</button>              
                                                                <%//LANÇAMENTO OU REVISÃO DE FALTAS/NOTAS/SITUAÇÃO
                                                } else if (tipo.getId() == 8) {%>
                                                                <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form" + tipo.getId()%>" required="true"></textarea>
                                                                <br><button type="submit" class="btn btn-primary">SOLICITAR</button>  
                                                                <%//RENOVAÇÃO MATRÍCULA
                                                } else if (tipo.getId() == 9) {%>
                                                                <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form" + tipo.getId()%>" required="true"></textarea>
                                                                <br><button type="submit" class="btn btn-primary">SOLICITAR</button>  
                                                                <%//REABERTURA MATRÍCULA
                                                } else if (tipo.getId() == 10) {%>
                                                                <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form" + tipo.getId()%>" required="true"></textarea>
                                                                <br><button type="submit" class="btn btn-primary">SOLICITAR</button>  
                                                                <%//JUSTIFICATIVA DE FALTAS (DIAS EM ANEXO)
                                                } else if (tipo.getId() == 11) {%>
                                                                <br><label for="exampleInputFile">
                                                                    Anexar arquivo <input type="file" id="exampleInputFile" name="dia_anexo">
                                                                </label>                                                
                                                                <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form" + tipo.getId()%>"></textarea>
                                                                <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                                <%//JUSTIFICATIVA DE FALTA - DIA ESPECÍFICO
                                                } else if (tipo.getId() == 12) {%>
                                                                <br><label>Dia :  <input type='date' name="dia_especifico" value="" required="true"></label>
                                                                <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form" + tipo.getId()%>"></textarea>
                                                                <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                                <%//JUSTIFICATIVA DE FALTA POR PERÍODO
                                                } else if (tipo.getId() == 13) {%>
                                                                <br><label>De :  <input type='date' name="dia_de" value="" required="true"></label>
                                                                <br><label>Até :  <input type='date' name="dia_ate" value="" required="true"></label>
                                                                <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form" + tipo.getId()%>"></textarea>
                                                                <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                                <%//TRANCAMENTO DE MATRÍCULA - PERÍODO
                                                } else if (tipo.getId() == 14) {%>
                                                                <br><label>Período :  <input type='number' name="periodo" value="" required="true"></label>
                                                                <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form" + tipo.getId()%>"></textarea>
                                                                <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                                <%//TRANCAMENTO DE MATRÍCULA - COMPULSÓRIO
                                                } else if (tipo.getId() == 15) {%>
                                                                <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form" + tipo.getId()%>"></textarea>
                                                                <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                                <%//CANCELAMENTO DE MATRÍCULA
                                                } else if (tipo.getId() == 16) {%>
                                                                <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form" + tipo.getId()%>"></textarea>
                                                                <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                                <%//ATENDIMENTO DOMICILIAR
                                                } else if (tipo.getId() == 17) {%>
                                                                <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form" + tipo.getId()%>"></textarea>
                                                                <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                                <%//OUTROS
                                                } else if (tipo.getId() == 18) {%>
                                                                <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form" + tipo.getId()%>"></textarea>
                                                                <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                                <%//DISPENSA DE ATIVIDADES
                                                } else if (tipo.getId() == 19) {%>
                                                                <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form" + tipo.getId()%>"></textarea>
                                                                <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                                <%//ADEQUAÇÃO DE HORÁRIOS
                                                } else if (tipo.getId() == 20) {%>
                                                                <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form" + tipo.getId()%>"></textarea>
                                                                <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                                <%//ESTUDO INDIVIDUALIZADO
                                                } else if (tipo.getId() == 21) {%>
                                                                <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form" + tipo.getId()%>"></textarea>
                                                                <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                                <%//INCLUSÃO DE DISCIPLINAS
                                                } else if (tipo.getId() == 22) {%>
                                                                <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form" + tipo.getId()%>"></textarea>
                                                                <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                                <%//REMOÇÃO DE DISCIPLINAS
                                                } else if (tipo.getId() == 23) {%>
                                                                <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form" + tipo.getId()%>"></textarea>
                                                                <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                                                <%}%>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
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

            </div>
            <!-- /#page-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>

        <!-- Morris Charts JavaScript -->
        <script src="js/plugins/morris/raphael.min.js"></script>
        <script src="js/plugins/morris/morris.min.js"></script>
        <script src="js/plugins/morris/morris-data.js"></script>

    </body>

</html>
