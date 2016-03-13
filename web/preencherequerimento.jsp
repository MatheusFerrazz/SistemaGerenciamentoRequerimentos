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

//Escolhe entre listar requerimentos e fazer requerimentos
$(function() {
        $('#acao').change(function(){
            $('.acao').hide();
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
    <div id="<%= tipo.getId()%>" class="divRequerimentoSolicitado">
        <form action="gravarequerimento.jsp" method="post" id="<%= "form"+tipo.getId() %>">
        Senhor(a) Diretor Acadêmico: <%= aluno.getCurso().getCampus().getDiretor().getNome() %> <br>
        <input type="hidden" name="tipoRequerimento" value="<%= tipo.getId() %>">
        Eu, <%= aluno.getNome() %>", matrícula <%= aluno.getMatricula() %>, aluno(a) do curso <%= aluno.getCurso().getModalidade().getNome() %> de nível <%= aluno.getCurso().getModalidade().getNivel() %> em <%= aluno.getCurso().getNome() %>, 
        turma <%= aluno.getTurma().getCodigo() %>, telefone(s) <%= aluno.getTelefone() %> <%= " / "+aluno.getCelular()%>,  email <%= aluno.getEmail() %>, venho requerer a V. Sa.:        
       <%
            //Preenchendo os formulários de acordo com o tipo do requerimento
            int tipoReq = tipo.getId();
            //Aproveitamento de estudo
            if(tipoReq==1){%>
                <br>Disciplina cursada:  <input type='text' name="disciplinaCursada" value="">
                <br>Disciplina curso atual: 
                <select name="disciplinaCursoAtual">
                <% for(Disciplina disci : aluno.getCurso().getDisciplinasDoCurso()){%>
                  <option value="<%= disci.getId() %>"><%= disci.getNome() %></option>
                 <%} %>
                </select>
                <br><textarea rows="4" cols="50" name="observacao" placeholder="Observações..." form="<%= "form"+tipo.getId() %>"></textarea><br>                
                <br>Documentos apresentados:
                <%for(Documento doc : documento.getDocumentos()){%>
                     <br><input type="checkbox" name="documento" value="<%= doc.getId() %>">&nbsp; <%= doc.getNome() %>
                <%} %>
                <input type="submit" value="SOLICITAR">
            <%}else if(tipoReq==2){%>
                <input type="submit" value="SOLICITAR">            
            <%}else if(tipoReq==3){%>
                <input type="submit" value="SOLICITAR">                
            <%}else if(tipoReq==4){%>
                <input type="submit" value="SOLICITAR">                
            <%}else if(tipoReq==5){%>
                <input type="submit" value="SOLICITAR">                
            <%}else if(tipoReq==6){%>
                <input type="submit" value="SOLICITAR">                
            <%}else if(tipoReq==7){%>
                <input type="submit" value="SOLICITAR">                
             <%}else if(tipoReq==8){%>
                <input type="submit" value="SOLICITAR">
            <%}else if(tipoReq==9){%>
                <input type="submit" value="SOLICITAR">
            <%}else if(tipoReq==10){%>             
                <input type="submit" value="SOLICITAR">
            <%}else if(tipoReq==11){%>
                <input type="submit" value="SOLICITAR">
            <%}else if(tipoReq==12){%>
                <input type="submit" value="SOLICITAR">
            <%}else if(tipoReq==13){%>
                <input type="submit" value="SOLICITAR">
            <%}else if(tipoReq==14){%>
                <input type="submit" value="SOLICITAR">
            <%}else if(tipoReq==15){%>
                <input type="submit" value="SOLICITAR">
            <%}else if(tipoReq==16){%>
                <input type="submit" value="SOLICITAR">
            <%}else if(tipoReq==17){%>
                <input type="submit" value="SOLICITAR">
            <%}else if(tipoReq==18){%>
                <input type="submit" value="SOLICITAR">
            <%}else if(tipoReq==19){%>
                <input type="submit" value="SOLICITAR">
            <%}else if(tipoReq==20){%>
                <input type="submit" value="SOLICITAR">
            <%}else if(tipoReq==21){%>
                <input type="submit" value="SOLICITAR">
            <%}else if(tipoReq==22){%>
                <input type="submit" value="SOLICITAR">
            <%}else if(tipoReq==23){%>
                <input type="submit" value="SOLICITAR">
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