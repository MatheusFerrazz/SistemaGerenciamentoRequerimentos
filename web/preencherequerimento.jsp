<%-- 
    Document   : tiposrequerimentos
    Created on : 09/03/2016, 22:21:09
    Author     : Luan Medeiros
--%>

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

<jsp:useBean id="aluno" class="br.edu.ifrn.sgr.modelos.Aluno" scope="request"/>
<jsp:useBean id="dao" class="br.edu.ifrn.sgr.persistencias.AlunoDAO" scope="request"/>
<jsp:useBean id="tiporequerimento" class="br.edu.ifrn.sgr.persistencias.TiposRequeriemtoDAO" scope="request"/>
<jsp:setProperty name="aluno" property="*"></jsp:setProperty>
<jsp:setProperty name="dao" property="*"></jsp:setProperty>
<jsp:setProperty name="tiporequerimento" property="*"></jsp:setProperty>

<style>
.div{display:none;}
</style>

<script src="jquery.js"></script>
 
<script>
$(document).ready(function() {
$('#select').change(function() {
$('.div').hide();
$('.div').each(function() {
if($(this).index() <= $('#select option:selected').val()) {
$('#d'+$(this).index()).show();
}
});
});
});
</script>


 <select id="select">
<% for(TipoRequerimento tipo : tiporequerimento.getTiposRequerimento()){%>
  <option value="<%= tipo.getId() %>"><%= tipo.getNome() %></option>
 <%} %>
</select> 
 
 
<div id="d1" class="div" style="display: none;">APROVEITAMENTO DE ESTUDOS</div>
<div id="d2" class="div" style="display: none;">CERTIFICAÇÃO DE CONHECIMENTOS</div>
<div id="d3" class="div" style="display: none;">REPOSIÇÃO DE ATIVIDADES</div>
<div id="d4" class="div" style="display: none;">MUDANÇA DE CURSO</div>
<div id="d5" class="div" style="display: none;">MUDANÇA DE TURMA</div>
<div id="d6" class="div" style="display: none;">MUDANÇA DE TURNO</div>
<div id="d7" class="div" style="display: none;">TRANSFERÊNCIA</div>
<div id="d8" class="div" style="display: none;">LANÇAMENTO OU REVISÃO DE FALTAS/NOTAS/SITUAÇÃO</div>
<div id="d9" class="div" style="display: none;">RENOVAÇÃO MATRÍCULA</div>
<div id="d10" class="div" style="display: none;">REABERTURA MATRÍCULA</div>
<div id="d11" class="div" style="display: none;">JUSTIFICATIVA DE FALTAS (EM ANEXO)</div>
<div id="d12" class="div" style="display: none;">JUSTIFICATIVA DE FALTA - DIA ESPECÍFICO</div>
<div id="d13" class="div" style="display: none;">JUSTIFICATIVA DE FALTA POR PERÍODO</div>
<div id="d14" class="div" style="display: none;">TRANCAMENTO DE MATRÍCULA - PERÍODO</div>
<div id="d15" class="div" style="display: none;">TRANCAMENTO DE MATRÍCULA - PERÍODO</div>
<div id="d16" class="div" style="display: none;">TRANCAMENTO DE MATRÍCULA - COMPULSÓRIO</div>
<div id="d17" class="div" style="display: none;">CANCELAMENTO DE MATRÍCULA</div>
<div id="d18" class="div" style="display: none;">ATENDIMENTO DOMICILIAR</div>
<div id="d19" class="div" style="display: none;">OUTROS</div>
<div id="d20" class="div" style="display: none;">DISPENSA DE ATIVIDADES</div>
<div id="d21" class="div" style="display: none;">ADEQUAÇÃO DE HORÁRIOS</div>
<div id="d22" class="div" style="display: none;">ESTUDO INDIVIDUALIZADO</div>
<div id="d23" class="div" style="display: none;">REMOÇÃO DE DISCIPLINAS</div>


<%--<c:choose>
    <c:when test="${dao.alunoByMatriculaSenha(aluno.nome, aluno.matricula)== null}">
      <p><c:out value="Não existe esse aluno!"/></p>
    </c:when>
    <c:otherwise> 
        <p><c:out value="${aluno.nome}"/></p>
        <p><c:out value="${aluno.matricula}"/></p>
    </c:otherwise>
</c:choose>--%>




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
