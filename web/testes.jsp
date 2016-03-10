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

<%--
   
    String up = "Linhas alteradas"+ Integer.toString(dao.inserir(aluno));
    <c:out value="${aluno.nome} Usuário já cadastrado!"/>
    
--%>

<%--<c:if test="${dao.obterAluno(aluno.matricula)== null}">
    <c:out value="${dao.inserir(aluno)}"/>
</c:if>
<c:if test="${!dao.obterAluno(aluno.matricula)== null}">
    <c:out value="${aluno.nome}"/>
</c:if>--%>

<c:choose>
    <c:when test="${dao.obterAluno(aluno.matricula)== null}">
        <p><c:out value="${Integer.toString(dao.inserir(aluno))} linha alterada no banco."/></p>
        <p><c:out value="${aluno.toString()}"/></p>
        <p><c:out value="FOI CADASTRADO COM SUCESSO!"/></p>
    </c:when>
    <c:otherwise> 
        <p><c:out value="${aluno.toString()}"/></p>
        <p><c:out value="JÁ EXISTE!"/></p>
    </c:otherwise>
</c:choose>
<p><a href="login.html">Voltar</a></p>

      


<%--
    /** FAZER - modificar o código para XML, 
     * utilizando Beans, linguagem de expressão e
     * JSTL. 
     */
    Aluno aluno = new Aluno("123456", "Carlos Henrique");
    AlunoDAO dao = new AlunoDAO();

    if (dao.obterAluno("123456") == null) { 
    int up = dao.inserir(aluno); 
    out.println ("linhas alteradas = " + up); 
    } else {
         out.print("Usuário já cadastrado!");
    }
--%>
