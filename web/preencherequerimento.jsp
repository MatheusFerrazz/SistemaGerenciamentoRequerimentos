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
<%@page import="br.edu.ifrn.sgr.persistencias.FabricaConexao"%>
<%@page import="br.edu.ifrn.sgr.persistencias.TiposRequeriemtoDAO"%>
<%@page import="br.edu.ifrn.sgr.persistencias.GeralDAO"%>
<%@page import="java.sql.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"
      prefix="c" %>

<jsp:useBean id="alunoDAO" class="br.edu.ifrn.sgr.persistencias.AlunoDAO" scope="request"/>
<jsp:useBean id="tiporequerimento" class="br.edu.ifrn.sgr.persistencias.TiposRequeriemtoDAO" scope="request"/>
<jsp:useBean id="documento" class="br.edu.ifrn.sgr.persistencias.DocumentoDAO" scope="request"/>
<jsp:setProperty name="aluno" property="*"></jsp:setProperty>
<jsp:setProperty name="dao" property="*"></jsp:setProperty>
<jsp:setProperty name="tiporequerimento" property="*"></jsp:setProperty>

<%

 %>

<style>
.divRequerimentoConsultado{display:none;}
.acao{display:none;}
.divRequerimentoSolicitado{display:none;}

</style>

<script src="jquery.js"></script>
 
<script src="jquery.js"></script>
 
<script>
$(function() {
        $('#selectRequerimento').change(function(){
            $('.divRequerimento').hide();
            $('#' + $(this).val()).show();
        });
    });

//Escolhe entre listar requerimentos e fazer requerimentos
$(function() {
        $('#acao').change(function(){
            $('.divRequerimento').hide();
            $('#' + $(this).val()).show();
        });
    });

//Mostra a div de preencheencimento do requerimento solicitado
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


 <select id="acao">
   <option value=""></option>
  <option value="solicitacao">Solicitação de Requerimento</option>
  <option value="consulta">Solicitação de Requerimento</option>
</select> 



<div id="solicitacao" class="acao">
 <select id="selectSolicitaRequerimento">
   <option value=""></option>
<% for(TipoRequerimento tipo : tiporequerimento.getTiposRequerimento()){%>
  <option value="<%= tipo.getId() %>"><%= tipo.getNome() %></option>
 <%} %>
</select> 
 
 <% 
    //Resgatando o objeto aluno pela session
    Aluno aluno = (Aluno) session.getAttribute("aluno");
    
    //Preenchendo as divis com os formulários e as informações do objeto aluno já preecarregados.
    for(TipoRequerimento tipo : tiporequerimento.getTiposRequerimento()){%>
    <div id="<%= tipo.getId() %>" class="divRequerimentoSolicitado"><%= tipo.getNome() %>
        <form action="gravarequerimento.jsp" method="post" id="<%= "form"+tipo.getId() %>">
        <h2><b>Senhor(a) Diretor Acadêmico: </b><h2> <%= aluno.getCurso().getCampus().getDiretor().getNome() %> 
        <input type="hidden" name="tipoRequerimento" value="<%= tipo.getId() %>">
        Eu, <input type='text' value="<%= aluno.getNome() %>" readonly="readonly" >,       
        matrícula <input type='text' value="<%= aluno.getMatricula() %>" readonly="readonly" >,         
        aluno(a) do curso <input type='text' value="<%= aluno.getCurso().getModalidade().getNome() %>" readonly="readonly" >
        de nível <input type='text' value="<%= aluno.getCurso().getModalidade().getNivel() %>" readonly="readonly" >
        em <input type='text' value="<%= aluno.getCurso().getNome() %>" readonly="readonly" >,
        turma <input type='text' value="<%= aluno.getTurma().getCodigo() %>" readonly="readonly" >,
        telefone(s) <input type='text' value="<%= aluno.getTelefone() %>" readonly="readonly" > / <input type='text' value="<%= aluno.getCelular() %>" readonly="readonly" >, 
        , email <input type='text' value="<%= aluno.getEmail() %>" readonly="readonly" >, venho requerer a V. Sa.:
        
       <%
        //Preenchendo os formulários de acordo com o tipo do requerimento
        switch (tipo.getId()) {
            //Aproveitamento de estudo
            case 1:%>
                Disciplina cursada:  <input type='text' name="disciplinaCursada" value="">
                Disciplina curso atual: 
                <select name="disciplinaCursoAtual">
                <% for(Disciplina disci : aluno.getCurso().getDisciplinasDoCurso()){%>
                  <option value="<%= disci.getId() %>"><%= disci.getNome() %></option>
                 <%} %>
                </select>                 
                <textarea rows="4" cols="50" name="observacao" form="<%= "form"+tipo.getId() %>">Observações...</textarea>                
                Documentos apresentados: 
                <%for(Documento doc : documento.getDocumentos()){%>
                    <input type="checkbox" name="documento" value="<%= doc.getId() %>"><%= doc.getNome() %> <br>
                <%} %>
                <input type="submit" value="SOLICITAR">
                <%break;
            case 2:%>
                <input type="submit" value="SOLICITAR">
                <%break;
            case 3:%>
                <input type="submit" value="SOLICITAR">
                <%break;
            case 4:%>
                <input type="submit" value="SOLICITAR">
                <%break;
            case 5:%>
                <input type="submit" value="SOLICITAR">
                <%break;
            case 6:%>
                <input type="submit" value="SOLICITAR">
                <%break;
             case 7:%>
                <input type="submit" value="SOLICITAR">
                <%break;
             case 8:%>
                <input type="submit" value="SOLICITAR">
                <%break;
             case 9:%>
                <input type="submit" value="SOLICITAR">
                <%break;
             case 10:%>
                <input type="submit" value="SOLICITAR">
                <%break;
             case 11:%>
                <input type="submit" value="SOLICITAR">
                <%break;
             case 12:%>
                <input type="submit" value="SOLICITAR">
                <%break;                
             case 13:%>
                <input type="submit" value="SOLICITAR">
                <%break;
             case 14:%>
                <input type="submit" value="SOLICITAR">
                <%break;
             case 15:%>
                <input type="submit" value="SOLICITAR">
                <%break;
             case 16:%>
                <input type="submit" value="SOLICITAR">
                <%break;
             case 17:%>
                <input type="submit" value="SOLICITAR">
                <%break;
             case 18:%>
                <input type="submit" value="SOLICITAR">
                <%break;
             case 19:%>
                <input type="submit" value="SOLICITAR">
                <%break;
             case 20:%>
                <input type="submit" value="SOLICITAR">
                <%break;
             case 21:%>
                <input type="submit" value="SOLICITAR">
                <%break;
             case 22:%>
                <input type="submit" value="SOLICITAR">
                <%break;
             case 23:%>
                <input type="submit" value="SOLICITAR">
                <%break;               
             default:%>
                 testando
         <%}%>
       </form>
    </div>
 <%}%>
</div>


<div id="consulta" class="acao">
    <h1> Consultas de Requerimento </h1>

<div>    

<%--<c:choose>
    <c:when test="${dao.alunoByMatriculaSenha(aluno.nome, aluno.matricula)== null}">
      <p><c:out value="Não existe esse aluno!"/></p>
    </c:when>
    <c:otherwise> 
        <p><c:out value="${aluno.nome}"/></p>
        <p><c:out value="${aluno.matricula}"/></p>
    </c:otherwise>
</c:choose>--%>