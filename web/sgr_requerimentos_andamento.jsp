<%@include file="sgr_cabecalho.jsp" %>
                <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                        <li>
                            <a href="index.html"><i class="fa fa-fw fa-dashboard"></i> Inicio</a>
                        </li>
                        <li>
                            <a href="sgr_solicitar_requerimento.jsp"><i class="fa fa-fw fa-bar-chart-o"></i> Solicitar Requerimento</a>
                        </li>
                        <li>
                            <a href="" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-arrows-v"></i> Consultar Requerimento <i class="fa fa-fw fa-caret-down"></i></a>
                            <ul id="demo" class="collapse">
                                <li>
                                    <a href="sgr_requerimentos_andamento.jsp">Em Andamento</a>
                                </li>
                                <li>
                                    <a href="sgr_requerimentos_deferidos.jsp">Deferidos</a>
                                </li>
                                <li>
                                    <a href="sgr_requerimentos_indeferidos.jsp">Indeferidos</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </nav>

            <div id="page-wrapper">

                <div class="container-fluid">
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
                <!-- /.container-fluid -->

            </div>
            <!-- /#page-wrapper -->

        </div>
<%@include file="sgr_rodape.jsp" %>