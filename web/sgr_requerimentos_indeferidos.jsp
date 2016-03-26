<%@include file="sgr_cabecalho.jsp"%>
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

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- /#page-wrapper -->

        </div>
<%@include file="sgr_rodape.jsp" %>