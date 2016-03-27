
<%@include file="sgr_cabecalho.jsp"%>
                <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                        <li class="active">
                            <a href="index.html"><i class="fa fa-fw fa-dashboard"></i> Inicio</a>
                        </li>
                        <li>
                            <a href="" id="solicitar"><i class="fa fa-fw fa-bar-chart-o"></i> Solicitar Requerimento</a>
                        </li>
                        <li>
                            <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-arrows-v"></i> Consultar Requerimento <i class="fa fa-fw fa-caret-down"></i></a>
                            <ul id="demo" class="collapse">
                                <li>
                                    <a href="" id="andamento">Em Andamento</a>
                                </li>
                                <li>
                                    <a href="" id="deferido">Deferidos</a>
                                </li>
                                <li>
                                    <a href="" id="indeferido">Indeferidos</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </nav>

            <div id="page-wrapper">

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
                <!-- /.container-fluid -->

            </div>


                        
<%@include file="sgr_rodape.jsp"%>