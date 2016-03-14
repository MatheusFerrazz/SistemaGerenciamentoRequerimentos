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
<%@page import="br.edu.ifrn.sgr.persistencias.Login"%>
<%@page import="br.edu.ifrn.sgr.persistencias.FabricaConexao"%>
<%@page import="br.edu.ifrn.sgr.persistencias.TiposRequeriemtoDAO"%>
<%@page import="br.edu.ifrn.sgr.persistencias.GeralDAO"%>
<%@page import="java.sql.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"
      prefix="c" %>


<jsp:useBean id="alunoDAO" class="br.edu.ifrn.sgr.persistencias.AlunoDAO" scope="request"/>
<jsp:useBean id="diretorDAO" class="br.edu.ifrn.sgr.persistencias.DiretorDAO" scope="request"/>
<jsp:useBean id="coordenadorDAO" class="br.edu.ifrn.sgr.persistencias.CoordenadorDAO" scope="request"/>
<jsp:useBean id="ProfessorDAO" class="br.edu.ifrn.sgr.persistencias.ProfessorDAO" scope="request"/>
<jsp:useBean id="tecnicoAdministrativoDAO" class="br.edu.ifrn.sgr.persistencias.TecnicoAdministrativoDAO" scope="request"/>
<jsp:useBean id="tiporequerimento" class="br.edu.ifrn.sgr.persistencias.TiposRequeriemtoDAO" scope="request"/>
<jsp:useBean id="documento" class="br.edu.ifrn.sgr.persistencias.DocumentoDAO" scope="request"/>


<%
        Login login = new Login(request.getParameter("matricula"), request.getParameter("senha"), request.getParameter("tipoLogon"));        
        if(login.getTipoLogin().equalsIgnoreCase("aluno"))
        {
            Aluno aluno = null;
            aluno = alunoDAO.getAlunoByMatriculaSenha(login.getMatricula(), login.getSenha());
            if(aluno == null) 
            {
                request.getSession().invalidate();
                response.sendRedirect("index.html");
            }
            else
            {
                session.setAttribute("aluno", aluno);
                session.setMaxInactiveInterval(600);
                response.sendRedirect("preencherequerimento.jsp");                                
            }                
        }       
%>