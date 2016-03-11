<%-- 
    Document   : tiposrequerimentos
    Created on : 09/03/2016, 22:21:09
    Author     : Luan Medeiros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.edu.ifrn.sgr.modelos.Aluno"%>
<%@page import="br.edu.ifrn.sgr.persistencias.AlunoDAO"%>
<%@page import="br.edu.ifrn.sgr.persistencias.FabricaConexao"%>
<%@page import="br.edu.ifrn.sgr.persistencias.GeralDAO"%>
<%@page import="java.sql.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"
      prefix="c" %>

<%
    /** FAZER - modificar o código para XML, 
     * utilizando Beans, linguagem de expressão e
     * JSTL. 
     */
    String nome = request.getParameter("nome");
    String matricula = request.getParameter("matricula");
    AlunoDAO dao = new AlunoDAO();
    
    Aluno aluno = dao.alunoByMatriculaSenha(nome, matricula);   

    if (aluno != null) { 
        out.println ("Aluno não Existe!"); 
    } else {
         out.print(aluno.getNome());
         out.print(aluno.getMatricula());
    }
%>
