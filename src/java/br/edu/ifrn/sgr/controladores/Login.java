/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.sgr.controladores;

import br.edu.ifrn.sgr.modelos.Aluno;
import br.edu.ifrn.sgr.persistencias.AlunoDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author João
 */
public class Login implements Controlador{

    @Override
    public String executar(HttpServletRequest requisicao, HttpServletResponse resposta) throws Exception {
        String matricula = requisicao.getParameter("matricula");
        String senha = requisicao.getParameter("senha");
        AlunoDAO alunoDAO = new AlunoDAO();
        Aluno aluno = alunoDAO.getAlunoByMatriculaSenha(matricula, senha);
        
        if (aluno != null){
            requisicao.setAttribute("aluno", aluno);
            return "principal.jsp";
        }else
            return "login.jsp";        
    }
    
}
