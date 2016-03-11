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

<jsp:useBean id="aluno" class="br.edu.ifrn.sgr.modelos.Aluno" scope="request"/>
<jsp:useBean id="dao" class="br.edu.ifrn.sgr.persistencias.AlunoDAO" scope="request"/>
<jsp:setProperty name="aluno" property="*"></jsp:setProperty>
<jsp:setProperty name="dao" property="*"></jsp:setProperty>

<c:choose>
    <c:when test="${dao.alunoByMatriculaSenha(aluno.nome, aluno.matricula)== null}">
      <p><c:out value="Não existe esse aluno!"/></p>
    </c:when>
    <c:otherwise> 
        <p><c:out value="${aluno.nome}"/></p>
        <p><c:out value="${aluno.matricula}"/></p>
    </c:otherwise>
</c:choose>




<%--
    /** FAZER - modificar o código para XML, 
     * utilizando Beans, linguagem de expressão e
     * JSTL. 
     */
    String nome = request.getParameter("nome");
    String matricula = request.getParameter("matricula");
    AlunoDAO dao = new AlunoDAO();
    
    Aluno aluno = new Aluno();   

    if (dao.alunoByMatriculaSenha(nome, matricula) == null) { 
        out.println ("Aluno não Existe!"); 
    } else {
         out.print(aluno.getNome());
         out.print(aluno.getMatricula());
         out.print(aluno.getCurso());
         out.print(aluno.getTurma());
         
    }
--%>
