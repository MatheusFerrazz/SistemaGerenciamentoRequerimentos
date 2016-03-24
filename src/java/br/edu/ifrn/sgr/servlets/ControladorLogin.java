/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.sgr.servlets;

import br.edu.ifrn.sgr.modelos.Aluno;
import br.edu.ifrn.sgr.persistencias.AlunoDAO;
import br.edu.ifrn.sgr.persistencias.Login;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author João
 */
@WebServlet(name = "ControladorLogin", urlPatterns = {"/ControladorLogin"})
public class ControladorLogin extends HttpServlet {

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
            throws ServletException, IOException {
        String matricula = request.getParameter("matricula");
        String senha = request.getParameter("senha");
        String tipoLogin = request.getParameter("tipoLogin");
        Login login = new Login(matricula, senha, tipoLogin);
        AlunoDAO alunoDAO = new AlunoDAO();
        Aluno aluno = null;
        if (login.getTipoLogin().equalsIgnoreCase("aluno")) {
            try {
                aluno = alunoDAO.getAlunoByMatriculaSenha(matricula, senha);
            } catch (Exception ex) {
                Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (aluno != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("aluno", aluno);
                session.setMaxInactiveInterval(30 * 60);
                Cookie cookie = new Cookie("nome", session.getId() + aluno.getNome());
                response.addCookie(cookie);
                response.sendRedirect("newjsp.jsp");
            } else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/loginaluno.html");
                response.setContentType("text/html; charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<font color=red>Usuário e senha errado</font>");
                rd.include(request, response);
            }
        }
        /*        // login como Tec Administrativo
        else if(login.getTipoLogin().equalsIgnoreCase("aluno")){
            try {
            aluno = alunoDAO.getAlunoByMatriculaSenha(matricula, senha);
        } catch (Exception ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (aluno != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("aluno", aluno);
            session.setMaxInactiveInterval(30 * 60);
            Cookie cookie = new Cookie("nome", session.getId() + aluno.getNome());
            response.addCookie(cookie);
            response.sendRedirect("preencherequerimento.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/loginaluno.html");
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Usuário e senha errado</font>");
            rd.include(request, response);
               }
        }
        // login como Professor
        else if(login.getTipoLogin().equalsIgnoreCase("aluno")){
            try {
            aluno = alunoDAO.getAlunoByMatriculaSenha(matricula, senha);
        } catch (Exception ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (aluno != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("aluno", aluno);
            session.setMaxInactiveInterval(30 * 60);
            Cookie cookie = new Cookie("nome", session.getId() + aluno.getNome());
            response.addCookie(cookie);
            response.sendRedirect("preencherequerimento.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/loginaluno.html");
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Usuário e senha errado</font>");
            rd.include(request, response);
               }
        }
        // login como Diretor
        else{
            try {
            aluno = alunoDAO.getAlunoByMatriculaSenha(matricula, senha);
        } catch (Exception ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (aluno != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("aluno", aluno);
            session.setMaxInactiveInterval(30 * 60);
            Cookie cookie = new Cookie("nome", session.getId() + aluno.getNome());
            response.addCookie(cookie);
            response.sendRedirect("preencherequerimento.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/loginaluno.html");
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Usuário e senha errado</font>");
            rd.include(request, response);
               }
            
        }*/
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
        processRequest(request, response);
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
        processRequest(request, response);
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
