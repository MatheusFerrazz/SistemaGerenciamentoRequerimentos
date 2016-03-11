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

<%--<jsp:useBean id="aluno" class="br.edu.ifrn.sgr.modelos.Aluno" scope="request"/>
<jsp:useBean id="dao" class="br.edu.ifrn.sgr.persistencias.AlunoDAO" scope="request"/>
<jsp:setProperty name="aluno" property="*"></jsp:setProperty>
<jsp:setProperty name="dao" property="*"></jsp:setProperty>--%>

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
    <c:when test="${dao.alunoByMatriculaSenha(aluno.nome, aluno.matricula   )= null}">
        <p><c:out value="Nome: ${aluno.nome}"/></p>
        <p><c:out value="Matricula: ${aluno.matricula}"/></p>

    </c:when>
</c:choose>


      


<%--
    /** FAZER - modificar o código para XML, 
     * utilizando Beans, linguagem de expressão e
     * JSTL. 
     */
    Aluno aluno = new Aluno();
    
    AlunoDAO dao = new AlunoDAO();

    if (dao.alunoByMatriculaSenha("Luan Medeiros Macena","20142148000001") == null) { 
        out.println ("Aluno não Existe!"); 
    } else {
         out.print(aluno.getNome());
         out.print(aluno.getMatricula());
    }
--%>
