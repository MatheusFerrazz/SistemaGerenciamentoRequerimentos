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
<%@page import="br.edu.ifrn.sgr.persistencias.EnuConsultasRequerimento"%>
<%@page import="br.edu.ifrn.sgr.modelos.RequerimentoPopuladoString"%>


<jsp:useBean id="alunoDAO" class="br.edu.ifrn.sgr.persistencias.AlunoDAO" scope="request"/>
<jsp:useBean id="tiporequerimento" class="br.edu.ifrn.sgr.persistencias.TiposRequeriemtoDAO" scope="request"/>
<jsp:useBean id="documento" class="br.edu.ifrn.sgr.persistencias.DocumentoDAO" scope="request"/>
<jsp:useBean id="requerimentos" class="br.edu.ifrn.sgr.persistencias.RequerimentoDAO" scope="request"/>
<jsp:setProperty name="dao" property="*"></jsp:setProperty>
<jsp:setProperty name="tiporequerimento" property="*"></jsp:setProperty>
        <link href="css/estilos_personalizados.css" rel="stylesheet">
        <script src="js/jquery.js"></script>
           
        
<%
    //Resgatando o objeto aluno pela sessão
    Aluno aluno = (Aluno) session.getAttribute("aluno");
%>  
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

                <div class="container-fluid" id="corpo">
                    <div id="solicitacao" class="row acao" >
                        <div class="col-md-12">
                            <h3 class="text-success">
                                    Requerimentos - Solicitações
                            </h3>
                            <div class="row col-md-12 form-group" style="clear: both">
                                <select id="selectSolicitaRequerimento" class="form-control" style="width: 56%;">
<!--                                          <option selected disabled style="padding-bottom: 1px; padding-top: 1px">Selecione</option>-->
                                 <option title="SELECIONE" ></option>
                                <% for(TipoRequerimento tipo : tiporequerimento.getTiposRequerimento()){%>
                                 <option value="<%= tipo.getId() %>"><%= tipo.getNome() %></option>
                                <%} %>
                                </select>
                            </div>
                                <% //Preenchendo as divis com os formulários e as informações do objeto aluno já preecarregados.
                                for(TipoRequerimento tipo : tiporequerimento.getTiposRequerimento())
                                {%>
                                <div id="<%= tipo.getId()%>" class="divRequerimentoSolicitado row" style="clear: both;">                                            
                                    <div class="row col-md-12 form-group" >
                                    <form action="CadastrarRequerimento" role="form" method="post" id="<%= "form"+tipo.getId() %>">                                            
                                        <input type="hidden" name="tipo_requerimento" value="<%= tipo.getId() %>">
                                        <input type="hidden" name="controlador" value="CadastrarRequerimento">
                                        <h2>Senhor(a) Diretor Acadêmico: <%= aluno.getCurso().getCampus().getDiretor().getNome() %></h2>
                                        <h3><p>&emsp;Eu, <%= aluno.getNome() %>, matrícula <%= aluno.getMatricula() %>, aluno(a) do curso <%= aluno.getCurso().getModalidade().getNome() %> de nível <%= aluno.getCurso().getModalidade().getNivel() %> em <%= aluno.getCurso().getNome() %>, 
                                         turma <%= aluno.getTurma().getCodigo() %>, telefone(s) <%= aluno.getTelefone() %> <%= " / "+aluno.getCelular()%>,  email <%= aluno.getEmail() %>, venho requerer a V. Sa.:</p></h3>                                                        
                                        <%//Preenchendo os formulários de acordo com o tipo de requerimento
                                        //Aproveitamento de estudo
                                        if(tipo.getId()==1){%>
                                            <br><label>Disciplina cursada:  <input type='text' name="disciplina_cursada" value="" required="true"></label>
                                            <br><label> Disciplina curso atual: 
                                                <select name="disciplina_cursoAtual" class="form-group" required="true">
                                                <option title="SELECIONE" ></option>
                                                <%for(Disciplina disci : aluno.getCurso().getDisciplinasDoCurso()){%>
                                                    <option value="<%= disci.getId() %>"><%= disci.getNome() %></option>
                                                <%}%>
                                                </select> </label>
                                            <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form"+tipo.getId() %>"></textarea>               
                                            <br><label>Documentos apresentados:</label><br>
                                            <%for(Documento doc : documento.getDocumentos()){%>
                                                <input type="checkbox" name="documentos_apresentados" value="<%= doc.getId() %>"> <%= doc.getNome() %><br>
                                            <%}%>
<!--                                                <div class="form-group">                                                    -->
                                            <br><label for="exampleInputFile">
                                                    Anexar arquivo <input type="file" id="exampleInputFile">
                                                </label>
                                            <br><button type="submit" class="btn btn-primary">SOLICITAR</button>                                                    
<!--                                                </div>-->
                                        <%//Certificação de conhecimentos
                                        }else if(tipo.getId()==2){%>
                                            <br><label> Disciplina: 
                                                <select name="disciplina_certificacao" class="form-group" required="true">
                                                    <option title="SELECIONE" ></option>
                                                <%for(Disciplina disci : aluno.getCurso().getDisciplinasDoCurso()){%>
                                                    <option value="<%= disci.getId() %>"><%= disci.getNome() %></option>
                                                <%}%>
                                                </select> </label>
                                            <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form"+tipo.getId() %>"></textarea>
                                            <br><button type="submit" class="btn btn-primary">SOLICITAR</button>                                                    
                                        <%//REPOSIÇÃO DE ATIVIDADES
                                        }else if(tipo.getId()==3){%>
                                        <br>Tipo de atividade<input type="text" name="tipo_atividade" required="true">
                                            <br><label> Professor: 
                                                <select name="professor_atividade" class="form-group" required="true">
                                                      <option title="SELECIONE" ></option>
                                                <%for(Professor prof : aluno.getCurso().getProfessores()){%>
                                                    <option value="<%= prof.getMatricula() %>"><%= prof.getNome() %></option>
                                                <%}%>
                                                </select> </label>
                                            <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form"+tipo.getId() %>"></textarea>                                                    
                                            <br><label>Documentos apresentados:</label><br>
                                            <%for(Documento doc : documento.getDocumentos()){%>
                                                <input type="checkbox" name="documentos_apresentados" value="<%= doc.getId() %>"> <%= doc.getNome() %><br>
                                            <%}%>
                                            <br><button type="submit" class="btn btn-primary">SOLICITAR</button>              
                                        <%//MUDANÇA DE CURSO
                                        }else if(tipo.getId()==4){ if(!aluno.getCurso().getCursosTranferencia().isEmpty()){%>
                                            <br><label> Curso desejado: 
                                                <select name="curso_tranfencia" class="form-group" required="true">
                                                   <option title="SELECIONE" ></option>
                                                <%for(Curso curso : aluno.getCurso().getCursosTranferencia()){%>
                                                    <option value="<%= curso.getCursoID() %>"><%= curso.getNome()+" - "+curso.getCampus().getNome() %></option>
                                                <%}%>
                                                </select> </label>                                                
                                            <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form"+tipo.getId() %>"></textarea>
                                            <br><label>Documentos apresentados:</label><br>
                                            <%for(Documento doc : documento.getDocumentos()){%>
                                                <input type="checkbox" name="documentos_apresentados" value="<%= doc.getId() %>"> <%= doc.getNome() %><br>
                                            <%}%>
                                            <br><button type="submit" class="btn btn-primary">SOLICITAR</button>              
                                            <% }else{%><br><h2><font color="red">NÃO HÁ CURSOS DISPONÍVEIS PARA MUDANÇA!</font><h2> <% }%>
                                        <%//MUDANÇA DE TURMA
                                        }else if(tipo.getId()==5){ if(!aluno.getCurso().getTurmasTranferencia().isEmpty()){%>
                                            <br><label> Turma desejada: 
                                                <select name="turma_tranferencia" class="form-group" required="true">
                                                    <option title="SELECIONE" ></option>
                                                <%for(Turma turma : aluno.getCurso().getTurmasTranferencia()){%>
                                                    <option value="<%= turma.getCodigo() %>"><%= turma.getCodigo()%></option>
                                                <%}%>
                                            </select> </label>                                                 
                                            <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form"+tipo.getId() %>"></textarea>                                                
                                            <br><label>Documentos apresentados:</label><br>
                                            <%for(Documento doc : documento.getDocumentos()){%>
                                                <input type="checkbox" name="documentos_apresentados" value="<%= doc.getId() %>"> <%= doc.getNome() %><br>
                                            <%}%>
                                            <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                            <% }else{%><br><h2><font color="red">NÃO HÁ TURMAS DISPONÍVEIS PARA MUDANÇA!</font><h2> <% }%>
                                        <%//MUDANÇA DE TURNO
                                        }else if(tipo.getId()==6){ if(!aluno.getCurso().getTurnosTranferencia().isEmpty()){%>
                                            <br><label> Turno desejado: 
                                                <select name="turno_tranferencia" class="form-group" required="true">
                                                    <option title="SELECIONE" ></option>
                                                <%for(Turno turno : aluno.getCurso().getTurnosTranferencia()){%>
                                                    <option value="<%= turno.getId() %>"><%= turno.getNome() %></option>
                                                <%}%>
                                            </select> </label>                                                 
                                            <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form"+tipo.getId() %>"></textarea>
                                            <br><label>Documentos apresentados:</label><br>
                                            <%for(Documento doc : documento.getDocumentos()){%>
                                                <input type="checkbox" name="documentos_apresentados" value="<%= doc.getId() %>"> <%= doc.getNome() %><br>
                                            <%}%>
                                            <br><button type="submit" class="btn btn-primary">SOLICITAR</button>              
                                            <% }else{%><br><h2><font color="red">NÃO HÁ TURNOS DISPONÍVEIS PARA MUDANÇA!</font><h2> <% }%>
                                        <%//TRANSFERÊNCIA
                                        }else if(tipo.getId()==7){%>
                                            <br><label>Escola origem:  <input type='text' name="escola_origem" value="" required="true"></label>
                                            <br><label>Curso origem:  <input type='text' name="curso_origem" value="" required="true"></label>
                                            <br><label>Escola destino:  <input type='text' name="escola_destino" value="" required="true"></label>
                                            <br><label>Curso destino:  <input type='text' name="curso_destino" value="" required="true"></label>
                                            <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form"+tipo.getId() %>"></textarea>
                                            <br><label>Documentos apresentados:</label><br>
                                            <%for(Documento doc : documento.getDocumentos()){%>
                                                <input type="checkbox" name="documentos_apresentados" value="<%= doc.getId() %>"> <%= doc.getNome() %><br>
                                            <%}%>
                                            <br><button type="submit" class="btn btn-primary">SOLICITAR</button>              
                                        <%//LANÇAMENTO OU REVISÃO DE FALTAS/NOTAS/SITUAÇÃO
                                        }else if(tipo.getId()==8){%>
                                            <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form"+tipo.getId() %>" required="true"></textarea>
                                            <br><label>Documentos apresentados:</label><br>
                                            <%for(Documento doc : documento.getDocumentos()){%>
                                                <input type="checkbox" name="documentos_apresentados" value="<%= doc.getId() %>"> <%= doc.getNome() %><br>
                                            <%}%>
                                            <br><button type="submit" class="btn btn-primary">SOLICITAR</button>  
                                        <%//RENOVAÇÃO MATRÍCULA
                                        }else if(tipo.getId()==9){%>
                                            <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form"+tipo.getId() %>" required="true"></textarea>
                                            <br><label>Documentos apresentados:</label><br>
                                            <%for(Documento doc : documento.getDocumentos()){%>
                                                <input type="checkbox" name="documentos_apresentados" value="<%= doc.getId() %>"> <%= doc.getNome() %><br>
                                            <%}%>
                                            <br><button type="submit" class="btn btn-primary">SOLICITAR</button>  
                                        <%//REABERTURA MATRÍCULA
                                        }else if(tipo.getId()==10){%>
                                            <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form"+tipo.getId() %>" required="true"></textarea>
                                            <br><label>Documentos apresentados:</label><br>
                                            <%for(Documento doc : documento.getDocumentos()){%>
                                                <input type="checkbox" name="documentos_apresentados" value="<%= doc.getId() %>"> <%= doc.getNome() %><br>
                                            <%}%>
                                            <br><button type="submit" class="btn btn-primary">SOLICITAR</button>  
                                        <%//JUSTIFICATIVA DE FALTAS (DIAS EM ANEXO)
                                        }else if(tipo.getId()==11){%>
                                            <br><label for="exampleInputFile">
                                                    Anexar arquivo <input type="file" id="exampleInputFile" name="dia_anexo">
                                                </label>                                                
                                            <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form"+tipo.getId() %>"></textarea>
                                            <br><label>Documentos apresentados:</label><br>
                                            <%for(Documento doc : documento.getDocumentos()){%>
                                                <input type="checkbox" name="documentos_apresentados" value="<%= doc.getId() %>"> <%= doc.getNome() %><br>
                                            <%}%>
                                            <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                        <%//JUSTIFICATIVA DE FALTA - DIA ESPECÍFICO
                                        }else if(tipo.getId()==12){%>
                                            <br><label>Dia :  <input type='date' name="dia_especifico" value="" required="true"></label>
                                            <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form"+tipo.getId() %>"></textarea>
                                            <br><label>Documentos apresentados:</label><br>
                                            <%for(Documento doc : documento.getDocumentos()){%>
                                                <input type="checkbox" name="documentos_apresentados" value="<%= doc.getId() %>"> <%= doc.getNome() %><br>
                                            <%}%>
                                            <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                        <%//JUSTIFICATIVA DE FALTA POR PERÍODO
                                        }else if(tipo.getId()==13){%>
                                            <br><label>De :  <input type='date' name="dia_de" value="" required="true"></label>
                                            <br><label>Até :  <input type='date' name="dia_ate" value="" required="true"></label>
                                            <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form"+tipo.getId() %>"></textarea>
                                            <br><label>Documentos apresentados:</label><br>
                                            <%for(Documento doc : documento.getDocumentos()){%>
                                                <input type="checkbox" name="documentos_apresentados" value="<%= doc.getId() %>"> <%= doc.getNome() %><br>
                                            <%}%>
                                            <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                        <%//TRANCAMENTO DE MATRÍCULA - PERÍODO
                                        }else if(tipo.getId()==14){ if(aluno.getCurso().getPeriodo() != 0){%>                                                    
                                            <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form"+tipo.getId() %>"></textarea>
                                            <br><label>Documentos apresentados:</label>
                                            <%for(Documento doc : documento.getDocumentos()){%>
                                                <input type="checkbox" name="documentos_apresentados" value="<%= doc.getId() %>"> <%= doc.getNome() %><br>
                                            <%}%>
                                            <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                            <% }else{%><br><h2><font color="red">SEU CURSO NÃO DISPÕE DE PERÍODOS PARA TRANCAMENTO!</font><h2> <% }%>
                                        <%//TRANCAMENTO DE MATRÍCULA - COMPULSÓRIO
                                        }else if(tipo.getId()==15){%>
                                            <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form"+tipo.getId() %>"></textarea>
                                            <br><label>Documentos apresentados:</label>
                                            <%for(Documento doc : documento.getDocumentos()){%>
                                                <input type="checkbox" name="documentos_apresentados" value="<%= doc.getId() %>"> <%= doc.getNome() %><br>
                                            <%}%>
                                            <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                        <%//CANCELAMENTO DE MATRÍCULA
                                        }else if(tipo.getId()==16){%>
                                            <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form"+tipo.getId() %>"></textarea>
                                            <br><label>Documentos apresentados:</label>
                                            <%for(Documento doc : documento.getDocumentos()){%>
                                                <input type="checkbox" name="documentos_apresentados" value="<%= doc.getId() %>"> <%= doc.getNome() %><br>
                                            <%}%>
                                            <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                        <%//ATENDIMENTO DOMICILIAR
                                        }else if(tipo.getId()==17){%>
                                            <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form"+tipo.getId() %>"></textarea>
                                            <br><label>Documentos apresentados:</label>
                                            <%for(Documento doc : documento.getDocumentos()){%>
                                                <input type="checkbox" name="documentos_apresentados" value="<%= doc.getId() %>"> <%= doc.getNome() %><br>
                                            <%}%>
                                            <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                        <%//OUTROS
                                        }else if(tipo.getId()==18){%>
                                            <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form"+tipo.getId() %>"></textarea>
                                            <br><label>Documentos apresentados:</label>
                                            <%for(Documento doc : documento.getDocumentos()){%>
                                                <input type="checkbox" name="documentos_apresentados" value="<%= doc.getId() %>"> <%= doc.getNome() %><br>
                                            <%}%>
                                            <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                        <%//DISPENSA DE ATIVIDADES
                                        }else if(tipo.getId()==19){%>
                                            <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form"+tipo.getId() %>"></textarea>
                                            <br><label>Documentos apresentados:</label>
                                            <%for(Documento doc : documento.getDocumentos()){%>
                                                <input type="checkbox" name="documentos_apresentados" value="<%= doc.getId() %>"> <%= doc.getNome() %><br>
                                            <%}%>
                                            <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                        <%//ADEQUAÇÃO DE HORÁRIOS
                                        }else if(tipo.getId()==20){%>
                                            <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form"+tipo.getId() %>"></textarea>
                                            <br><label>Documentos apresentados:</label>
                                            <%for(Documento doc : documento.getDocumentos()){%>
                                                <input type="checkbox" name="documentos_apresentados" value="<%= doc.getId() %>"> <%= doc.getNome() %><br>
                                            <%}%>
                                            <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                        <%//ESTUDO INDIVIDUALIZADO
                                        }else if(tipo.getId()==21){%>
                                            <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form"+tipo.getId() %>"></textarea>
                                            <br><label>Documentos apresentados:</label>
                                            <%for(Documento doc : documento.getDocumentos()){%>
                                                <input type="checkbox" name="documentos_apresentados" value="<%= doc.getId() %>"> <%= doc.getNome() %><br>
                                            <%}%>
                                            <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                        <%//INCLUSÃO DE DISCIPLINAS
                                        }else if(tipo.getId()==22){%>
                                            <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form"+tipo.getId() %>"></textarea>
                                            <br><label>Documentos apresentados:</label>
                                            <%for(Documento doc : documento.getDocumentos()){%>
                                                <input type="checkbox" name="documentos_apresentados" value="<%= doc.getId() %>"> <%= doc.getNome() %><br>
                                            <%}%>
                                            <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                        <%//REMOÇÃO DE DISCIPLINAS
                                        }else if(tipo.getId()==23){%>
                                            <br><textarea rows="4" cols="79" name="observacao" placeholder="Observações..." form="<%= "form"+tipo.getId() %>"></textarea>
                                            <br><label>Documentos apresentados:</label>
                                            <%for(Documento doc : documento.getDocumentos()){%>
                                                <input type="checkbox" name="documentos_apresentados" value="<%= doc.getId() %>"> <%= doc.getNome() %><br>
                                            <%}%>
                                            <br><button type="submit" class="btn btn-primary">SOLICITAR</button>
                                        <%}%>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
                                </form>
                            </div>                                    					
                            </div>
                        <%}%>
                    </div>
                </div>

                </div>
           