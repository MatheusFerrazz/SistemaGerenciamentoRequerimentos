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
        Integer idGerado;
                        
        if(tipoRequerimento==1)
        {
            requerimento.setDisciplinaCursada(request.getParameter("disciplina_cursada"));
            requerimento.setDisciplinaCursoAtualID(toInt(request.getParameter("disciplina_cursoAtual")));
            requerimento.setObservacoes(request.getParameter("observacao"));
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

        }
        else if(tipoRequerimento==3)
        {

        }
        else if(tipoRequerimento==4)
        {

        }
        else if(tipoRequerimento==5)
        {

        }
        else if(tipoRequerimento==6)
        {

        }
        else if(tipoRequerimento==7)
        {

        }
        else if(tipoRequerimento==8)
        {

        }
        else if(tipoRequerimento==9)
        {

        }
        else if(tipoRequerimento==10)
        {

        }
        else if(tipoRequerimento==11)
        {

        }
        else if(tipoRequerimento==12)
        {

        }
        else if(tipoRequerimento==13)
        {

        }
        else if(tipoRequerimento==14)
        {

        }
        else if(tipoRequerimento==15)
        {

        }
        else if(tipoRequerimento==16)
        {

        }
        else if(tipoRequerimento==17)
        {

        }
        else if(tipoRequerimento==18)
        {

        }    
        else if(tipoRequerimento==19)
        {

        }
        else if(tipoRequerimento==20)
        {

        }
        else if(tipoRequerimento==21)
        {

        }
        else if(tipoRequerimento==22)
        {

        }
        else if(tipoRequerimento==22)
        {

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
