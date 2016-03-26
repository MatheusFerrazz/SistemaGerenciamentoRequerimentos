/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.sgr.servlets;

import br.edu.ifrn.sgr.controladores.Controlador;
import br.edu.ifrn.sgr.modelos.Aluno;
import br.edu.ifrn.sgr.modelos.Requerimento;
import br.edu.ifrn.sgr.persistencias.EnuInsercaoRequerimento;
import br.edu.ifrn.sgr.persistencias.RequerimentoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author João
 */
@WebServlet(name = "CadastrarRequerimento", urlPatterns = {"/CadastrarRequerimento"})
public class CadastrarRequerimento extends HttpServlet {

    public int toInt(String str)
    {
        return Integer.parseInt(str.trim());
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        RequerimentoDAO daoRequerimento = new RequerimentoDAO();
        Aluno aluno = (Aluno) request.getSession().getAttribute("aluno");
        Requerimento requerimento = new Requerimento();

        int tipoRequerimento = toInt(request.getParameter("tipo_requerimento"));
        requerimento.setAlunoID(aluno.getMatricula());
        requerimento.setTipoRequerimentoID(tipoRequerimento);
        Integer idGerado = 0;
                        
        if(tipoRequerimento==1)
        {
            requerimento.setDisciplinaCursada(request.getParameter("disciplina_cursada").trim());
            requerimento.setDisciplinaCursoAtualID(toInt(request.getParameter("disciplina_cursoAtual")));
            requerimento.setObservacoes(request.getParameter("observacao").trim());
            idGerado = daoRequerimento.cadastraRequerimentoComRetornoID(EnuInsercaoRequerimento.APROVEITAMENTO_DE_ESTUDOS.toString(), requerimento.getAlunoID(), requerimento.getDisciplinaCursada(), requerimento.getDisciplinaCursoAtualID(), requerimento.getObersavacoesAnaliseAproveitamento(), requerimento.getTipoRequerimentoID());                               
            String[] documentos_apresentados = request.getParameterValues("documentos_apresentados");        
            if (documentos_apresentados != null) 
            {                    
                for (String documentos_apresentado : documentos_apresentados) {
                    daoRequerimento.executarComando(EnuInsercaoRequerimento.DOCUMENTOS_APRESENTADOS.toString(), idGerado, toInt(documentos_apresentado));
                }
            }  
        }                
        else if(tipoRequerimento==2)
        {
            requerimento.setDisciplinaCertificacaoID(toInt(request.getParameter("disciplina_certificacao")));            
            requerimento.setObservacoes(request.getParameter("observacao").trim());
            daoRequerimento.cadastraRequerimentoSemRetornoID(EnuInsercaoRequerimento.CERTIFICACAO_DE_CONHECIMENTOS.toString(), requerimento.getAlunoID(), requerimento.getTipoRequerimentoID(), requerimento.getDisciplinaCertificacaoID(), requerimento.getObservacoes());            
        }
        else if(tipoRequerimento==3)
        {
            requerimento.setTipoAtividade(request.getParameter("tipo_atividade").trim());            
            requerimento.setObservacoes(request.getParameter("observacao").trim());
            requerimento.setProfessorAtividadeID(request.getParameter("professor_atividade"));
            idGerado = daoRequerimento.cadastraRequerimentoComRetornoID(EnuInsercaoRequerimento.REPOSICAO_DE_ATIVIDADES.toString(), requerimento.getAlunoID(), requerimento.getTipoRequerimentoID(), requerimento.getObservacoes(),requerimento.getTipoAtividade(),requerimento.getProfessorAtividadeID());
            String[] documentos_apresentados = request.getParameterValues("documentos_apresentados");        
            if (documentos_apresentados != null) 
            {                    
                for (String documentos_apresentado : documentos_apresentados) {
                    daoRequerimento.executarComando(EnuInsercaoRequerimento.DOCUMENTOS_APRESENTADOS.toString(), idGerado, toInt(documentos_apresentado));
                }
            }             
        }
        else if(tipoRequerimento==4)
        {
            requerimento.setCursoOrigemID(aluno.getCurso().getCursoID());
            requerimento.setCursoDestinoID(toInt(request.getParameter("curso_tranfencia")));
            requerimento.setObservacoes(request.getParameter("observacao").trim());
            idGerado = daoRequerimento.cadastraRequerimentoComRetornoID(EnuInsercaoRequerimento.MUDANCA_DE_CURSO.toString(), requerimento.getAlunoID(), requerimento.getTipoRequerimentoID(), requerimento.getObservacoes(), requerimento.getCursoOrigemID(), requerimento.getCursoDestinoID());
            String[] documentos_apresentados = request.getParameterValues("documentos_apresentados");        
            if (documentos_apresentados != null) 
            {                    
                for (String documentos_apresentado : documentos_apresentados) {
                    daoRequerimento.executarComando(EnuInsercaoRequerimento.DOCUMENTOS_APRESENTADOS.toString(), idGerado, toInt(documentos_apresentado));
                }
            } 
        }
        else if(tipoRequerimento==5)
        {
            requerimento.setTurmaOrigemID(aluno.getTurma().getCodigo());
            requerimento.setTurmaDestinoID(toInt(request.getParameter("turma_tranferencia")));
            requerimento.setObservacoes(request.getParameter("observacao").trim());
            idGerado = daoRequerimento.cadastraRequerimentoComRetornoID(EnuInsercaoRequerimento.MUDANCA_DE_TURMA.toString(), requerimento.getAlunoID(), requerimento.getTipoRequerimentoID(), requerimento.getObservacoes(), requerimento.getTurmaOrigemID(), requerimento.getTurmaDestinoID());
            String[] documentos_apresentados = request.getParameterValues("documentos_apresentados");        
            if (documentos_apresentados != null) 
            {                    
                for (String documentos_apresentado : documentos_apresentados) {
                    daoRequerimento.executarComando(EnuInsercaoRequerimento.DOCUMENTOS_APRESENTADOS.toString(), idGerado, toInt(documentos_apresentado));
                }
            } 
        }
        else if(tipoRequerimento==6)
        {
            requerimento.setTurnoOrigemID(aluno.getCurso().getTurno().getId());
            requerimento.setTurnoDestinoID(toInt(request.getParameter("turno_tranferencia")));
            requerimento.setObservacoes(request.getParameter("observacao").trim());
            idGerado = daoRequerimento.cadastraRequerimentoComRetornoID(EnuInsercaoRequerimento.MUDANCA_DE_TURNO.toString(), requerimento.getAlunoID(), requerimento.getTipoRequerimentoID(), requerimento.getObservacoes(), requerimento.getTurnoOrigemID(), requerimento.getTurnoDestinoID());
            String[] documentos_apresentados = request.getParameterValues("documentos_apresentados");        
            if (documentos_apresentados != null) 
            {                    
                for (String documentos_apresentado : documentos_apresentados) {
                    daoRequerimento.executarComando(EnuInsercaoRequerimento.DOCUMENTOS_APRESENTADOS.toString(), idGerado, toInt(documentos_apresentado));
                }
            } 
        }
        else if(tipoRequerimento==7)
        {
            requerimento.setTranferenciaEscolaOrigem(request.getParameter("escola_origem").trim());
            requerimento.setTranferenciaCursoOrigem(request.getParameter("curso_origem").trim());
            requerimento.setTranferenciaEscolaDestino(request.getParameter("escola_destino").trim());
            requerimento.setTranferenciaCursoDestino(request.getParameter("curso_destino").trim());
            requerimento.setObservacoes(request.getParameter("observacao").trim());
            idGerado = daoRequerimento.cadastraRequerimentoComRetornoID(EnuInsercaoRequerimento.TRANSFERENCIA.toString(), requerimento.getAlunoID(), requerimento.getTipoRequerimentoID(), requerimento.getObservacoes(), requerimento.getTranferenciaCursoOrigem(), requerimento.getTranferenciaCursoDestino(), requerimento.getTranferenciaEscolaOrigem(), requerimento.getTranferenciaEscolaDestino());
            String[] documentos_apresentados = request.getParameterValues("documentos_apresentados");        
            if (documentos_apresentados != null) 
            {                    
                for (String documentos_apresentado : documentos_apresentados) {
                    daoRequerimento.executarComando(EnuInsercaoRequerimento.DOCUMENTOS_APRESENTADOS.toString(), idGerado, toInt(documentos_apresentado));
                }
            } 
        }
        else if(tipoRequerimento==8)
        {
            requerimento.setObservacoes(request.getParameter("observacao"));
            idGerado = daoRequerimento.cadastraRequerimentoComRetornoID(EnuInsercaoRequerimento.LANCAMENTO_OU_REVISAO_DE_FALTAS_NOTAS_SITUACAO.toString(), requerimento.getAlunoID(), requerimento.getTipoRequerimentoID(), requerimento.getObservacoes());
            String[] documentos_apresentados = request.getParameterValues("documentos_apresentados");        
            if (documentos_apresentados != null) 
            {                    
                for (String documentos_apresentado : documentos_apresentados) {
                    daoRequerimento.executarComando(EnuInsercaoRequerimento.DOCUMENTOS_APRESENTADOS.toString(), idGerado, toInt(documentos_apresentado));
                }
            } 
        }
        else if(tipoRequerimento==9)
        {
            requerimento.setObservacoes(request.getParameter("observacao"));
            idGerado = daoRequerimento.cadastraRequerimentoComRetornoID(EnuInsercaoRequerimento.RENOVACAO_MATRICULA.toString(), requerimento.getAlunoID(), requerimento.getTipoRequerimentoID(), requerimento.getObservacoes());
            String[] documentos_apresentados = request.getParameterValues("documentos_apresentados");        
            if (documentos_apresentados != null) 
            {                    
                for (String documentos_apresentado : documentos_apresentados) {
                    daoRequerimento.executarComando(EnuInsercaoRequerimento.DOCUMENTOS_APRESENTADOS.toString(), idGerado, toInt(documentos_apresentado));
                }
            } 
        }
        else if(tipoRequerimento==10)
        {
            requerimento.setObservacoes(request.getParameter("observacao"));            
            idGerado = daoRequerimento.cadastraRequerimentoComRetornoID(EnuInsercaoRequerimento.REABERTURA_MATRICULA.toString(), requerimento.getAlunoID(), requerimento.getTipoRequerimentoID(), requerimento.getObservacoes());
            String[] documentos_apresentados = request.getParameterValues("documentos_apresentados");            
            if (documentos_apresentados != null) 
            {                    
                for (String documentos_apresentado : documentos_apresentados) {
                    daoRequerimento.executarComando(EnuInsercaoRequerimento.DOCUMENTOS_APRESENTADOS.toString(), idGerado, toInt(documentos_apresentado));
                }
            } 
        }
        else if(tipoRequerimento==11)
        {
            requerimento.setObservacoes(request.getParameter("observacao"));
            idGerado = daoRequerimento.cadastraRequerimentoComRetornoID(EnuInsercaoRequerimento.JUSTIFICATIVA_DE_FALTAS_DIAS_EM_ANEXO.toString(), requerimento.getAlunoID(), requerimento.getTipoRequerimentoID(), requerimento.getObservacoes());
            String[] documentos_apresentados = request.getParameterValues("documentos_apresentados");        
            if (documentos_apresentados != null) 
            {                    
                for (String documentos_apresentado : documentos_apresentados) {
                    daoRequerimento.executarComando(EnuInsercaoRequerimento.DOCUMENTOS_APRESENTADOS.toString(), idGerado, toInt(documentos_apresentado));
                }
            } 
        }
        else if(tipoRequerimento==12)
        {  
            String string = request.getParameter("dia_especifico");
            Date diaEspecifico = new SimpleDateFormat("yyyy-MM-dd").parse(string);                        
            requerimento.setDataFaltasDia(new java.sql.Date(diaEspecifico.getTime()));
            requerimento.setObservacoes(request.getParameter("observacao"));
            idGerado = daoRequerimento.cadastraRequerimentoComRetornoID(EnuInsercaoRequerimento.JUSTIFICATIVA_DE_FALTA_DIA_ESPECIFICO.toString(), requerimento.getAlunoID(), requerimento.getTipoRequerimentoID(), requerimento.getObservacoes(),requerimento.getDataFaltasDia());
            String[] documentos_apresentados = request.getParameterValues("documentos_apresentados");        
            if (documentos_apresentados != null) 
            {                    
                for (String documentos_apresentado : documentos_apresentados) {
                    daoRequerimento.executarComando(EnuInsercaoRequerimento.DOCUMENTOS_APRESENTADOS.toString(), idGerado, toInt(documentos_apresentado));
                }
            } 
        }
        else if(tipoRequerimento==13)
        {
            String deString = request.getParameter("dia_de");
            String ateString = request.getParameter("dia_ate");
            Date de = new SimpleDateFormat("yyyy-MM-dd").parse(deString);            
            Date ate = new SimpleDateFormat("yyyy-MM-dd").parse(ateString);                         
            requerimento.setDataFaltasDe(new java.sql.Date(de.getTime()));
            requerimento.setDataFaltasAte(new java.sql.Date(ate.getTime()));
            requerimento.setObservacoes(request.getParameter("observacao"));
            idGerado = daoRequerimento.cadastraRequerimentoComRetornoID(EnuInsercaoRequerimento.JUSTIFICATIVA_DE_FALTA_POR_PERIODO.toString(), requerimento.getAlunoID(), requerimento.getTipoRequerimentoID(), requerimento.getObservacoes(),requerimento.getDataFaltasDe(),requerimento.getDataFaltasAte());
            String[] documentos_apresentados = request.getParameterValues("documentos_apresentados");        
            if (documentos_apresentados != null) 
            {                    
                for (String documentos_apresentado : documentos_apresentados) {
                    daoRequerimento.executarComando(EnuInsercaoRequerimento.DOCUMENTOS_APRESENTADOS.toString(), idGerado, toInt(documentos_apresentado));
                }
            } 
        }
        else if(tipoRequerimento==14)
        {
            requerimento.setObservacoes(request.getParameter("observacao"));
            idGerado = daoRequerimento.cadastraRequerimentoComRetornoID(EnuInsercaoRequerimento.TRANCAMENTO_DE_MATRICULA_PERIODO.toString(), requerimento.getAlunoID(), requerimento.getTipoRequerimentoID(), requerimento.getObservacoes());
            String[] documentos_apresentados = request.getParameterValues("documentos_apresentados");        
            if (documentos_apresentados != null) 
            {                    
                for (String documentos_apresentado : documentos_apresentados) {
                    daoRequerimento.executarComando(EnuInsercaoRequerimento.DOCUMENTOS_APRESENTADOS.toString(), idGerado, toInt(documentos_apresentado));
                }
            } 
        }
        else if(tipoRequerimento==15)
        {
            requerimento.setObservacoes(request.getParameter("observacao"));
            idGerado = daoRequerimento.cadastraRequerimentoComRetornoID(EnuInsercaoRequerimento.TRANCAMENTO_DE_MATRICULA_PERIODO.toString(), requerimento.getAlunoID(), requerimento.getTipoRequerimentoID(), requerimento.getObservacoes());
            String[] documentos_apresentados = request.getParameterValues("documentos_apresentados");        
            if (documentos_apresentados != null) 
            {                    
                for (String documentos_apresentado : documentos_apresentados) {
                    daoRequerimento.executarComando(EnuInsercaoRequerimento.DOCUMENTOS_APRESENTADOS.toString(), idGerado, toInt(documentos_apresentado));
                }
            } 
        }
        else if(tipoRequerimento==16)
        {
            requerimento.setObservacoes(request.getParameter("observacao"));
            idGerado = daoRequerimento.cadastraRequerimentoComRetornoID(EnuInsercaoRequerimento.CANCELAMENTO_DE_MATRiCULA.toString(), requerimento.getAlunoID(), requerimento.getTipoRequerimentoID(), requerimento.getObservacoes());            
            String[] documentos_apresentados = request.getParameterValues("documentos_apresentados");        
            if (documentos_apresentados != null) 
            {                    
                for (String documentos_apresentado : documentos_apresentados) {
                    daoRequerimento.executarComando(EnuInsercaoRequerimento.DOCUMENTOS_APRESENTADOS.toString(), idGerado, toInt(documentos_apresentado));
                }
            } 
        }
        else if(tipoRequerimento==17)
        {
            requerimento.setObservacoes(request.getParameter("observacao"));
            idGerado = daoRequerimento.cadastraRequerimentoComRetornoID(EnuInsercaoRequerimento.ATENDIMENTO_DOMICILIAR.toString(), requerimento.getAlunoID(), requerimento.getTipoRequerimentoID(), requerimento.getObservacoes());
            String[] documentos_apresentados = request.getParameterValues("documentos_apresentados");        
            if (documentos_apresentados != null) 
            {                    
                for (String documentos_apresentado : documentos_apresentados) {
                    daoRequerimento.executarComando(EnuInsercaoRequerimento.DOCUMENTOS_APRESENTADOS.toString(), idGerado, toInt(documentos_apresentado));
                }
            } 
        }
        else if(tipoRequerimento==18)
        {
            requerimento.setObservacoes(request.getParameter("observacao"));
            idGerado = daoRequerimento.cadastraRequerimentoComRetornoID(EnuInsercaoRequerimento.OUTROS.toString(), requerimento.getAlunoID(), requerimento.getTipoRequerimentoID(), requerimento.getObservacoes());
            String[] documentos_apresentados = request.getParameterValues("documentos_apresentados");        
            if (documentos_apresentados != null) 
            {                    
                for (String documentos_apresentado : documentos_apresentados) {
                    daoRequerimento.executarComando(EnuInsercaoRequerimento.DOCUMENTOS_APRESENTADOS.toString(), idGerado, toInt(documentos_apresentado));
                }
            } 
        }    
        else if(tipoRequerimento==19)
        {
            requerimento.setObservacoes(request.getParameter("observacao"));
            idGerado = daoRequerimento.cadastraRequerimentoComRetornoID(EnuInsercaoRequerimento.DISPENSA_DE_ATIVIDADES.toString(), requerimento.getAlunoID(), requerimento.getTipoRequerimentoID(), requerimento.getObservacoes());
            String[] documentos_apresentados = request.getParameterValues("documentos_apresentados");        
            if (documentos_apresentados != null) 
            {                    
                for (String documentos_apresentado : documentos_apresentados) {
                    daoRequerimento.executarComando(EnuInsercaoRequerimento.DOCUMENTOS_APRESENTADOS.toString(), idGerado, toInt(documentos_apresentado));
                }
            } 
        }
        else if(tipoRequerimento==20)
        {
            requerimento.setObservacoes(request.getParameter("observacao"));
            idGerado = daoRequerimento.cadastraRequerimentoComRetornoID(EnuInsercaoRequerimento.ADEQUACAO_DE_HORARIOS.toString(), requerimento.getAlunoID(), requerimento.getTipoRequerimentoID(), requerimento.getObservacoes());
            String[] documentos_apresentados = request.getParameterValues("documentos_apresentados");        
            if (documentos_apresentados != null) 
            {                    
                for (String documentos_apresentado : documentos_apresentados) {
                    daoRequerimento.executarComando(EnuInsercaoRequerimento.DOCUMENTOS_APRESENTADOS.toString(), idGerado, toInt(documentos_apresentado));
                }
            } 
        }
        else if(tipoRequerimento==21)
        {
            requerimento.setObservacoes(request.getParameter("observacao"));
            idGerado = daoRequerimento.cadastraRequerimentoComRetornoID(EnuInsercaoRequerimento.ESTUDO_INDIVIDUALIZADO.toString(), requerimento.getAlunoID(), requerimento.getTipoRequerimentoID(), requerimento.getObservacoes());
            String[] documentos_apresentados = request.getParameterValues("documentos_apresentados");        
            if (documentos_apresentados != null) 
            {                    
                for (String documentos_apresentado : documentos_apresentados) {
                    daoRequerimento.executarComando(EnuInsercaoRequerimento.DOCUMENTOS_APRESENTADOS.toString(), idGerado, toInt(documentos_apresentado));
                }
            } 
        }
        else if(tipoRequerimento==22)
        {
            requerimento.setObservacoes(request.getParameter("observacao"));
            idGerado = daoRequerimento.cadastraRequerimentoComRetornoID(EnuInsercaoRequerimento.INCLUSAO_DE_DISCIPLINAS.toString(), requerimento.getAlunoID(), requerimento.getTipoRequerimentoID(), requerimento.getObservacoes());
            String[] documentos_apresentados = request.getParameterValues("documentos_apresentados");        
            if (documentos_apresentados != null) 
            {                    
                for (String documentos_apresentado : documentos_apresentados) {
                    daoRequerimento.executarComando(EnuInsercaoRequerimento.DOCUMENTOS_APRESENTADOS.toString(), idGerado, toInt(documentos_apresentado));
                }
            } 
        }
        else if(tipoRequerimento==23)
        {
            requerimento.setObservacoes(request.getParameter("observacao"));
            idGerado = daoRequerimento.cadastraRequerimentoComRetornoID(EnuInsercaoRequerimento.REMOCAO_DE_DISCIPLINAS.toString(), requerimento.getAlunoID(), requerimento.getTipoRequerimentoID(), requerimento.getObservacoes());            
            String[] documentos_apresentados = request.getParameterValues("documentos_apresentados");        
            if (documentos_apresentados != null) 
            {                    
                for (String documentos_apresentado : documentos_apresentados) {
                    daoRequerimento.executarComando(EnuInsercaoRequerimento.DOCUMENTOS_APRESENTADOS.toString(), idGerado, toInt(documentos_apresentado));
                }
            } 
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CadastrarRequerimento.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CadastrarRequerimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
