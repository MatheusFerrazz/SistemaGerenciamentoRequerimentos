
<%@include file="sgr_cabecalho.jsp"%>
                <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                        <li class="active">
                            <a href="sgr_aluno.jsp"><i class="fa fa-fw fa-dashboard"></i> Inicio</a>
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
                    <address>
                        <strong>Campus <%= aluno.getCurso().getCampus().getNome()%> - Diretoria AcadÍmica</strong><br><%= aluno.getCurso().getCampus().getEndereco()%>, <%= aluno.getCurso().getCampus().getNumero()%><br> <%= aluno.getCurso().getCampus().getCidade() + "/" + aluno.getCurso().getCampus().getEstado() + " - " + aluno.getCurso().getCampus().getBairro()%>, <%= aluno.getCurso().getCampus().getCep()%><br> Telefone: <%= aluno.getCurso().getCampus().getTelefone()%>
                    </address>
                    <br><h3 class="text-left" id="cabecalho">Bem vindo,<br> <%= aluno.getNome()%></h3>

                </div>
                <!-- /.container-fluid -->

            </div>


                        
<%@include file="sgr_rodape.jsp"%>