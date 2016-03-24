/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.sgr.controladores;

import br.edu.ifrn.sgr.modelos.Aluno;
import br.edu.ifrn.sgr.persistencias.AlunoDAO;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author João
 */
public class CadastrarAluno implements Controlador{

    @Override
    public String executar(HttpServletRequest requisicao, HttpServletResponse resposta) throws Exception {
//        Aluno aluno = new Aluno();
//        aluno.setNome(requisicao.getParameter("nome"));
//        aluno.setEndereco(requisicao.getParameter("endereco"));
//        aluno.setEmail(requisicao.getParameter("email"));
//        aluno.setEstado(requisicao.getParameter("estado"));
//        aluno.setCidade(requisicao.getParameter("cidade"));
//        aluno.setCpf(requisicao.getParameter("cpf"));
//        aluno.setIdentidade(requisicao.getParameter("identidade"));
//        aluno.setSenha(requisicao.getParameter("senha"));
//        
//        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date data = formato.parse(requisicao.getParameter("data-nascimento"));
//        aluno.setDataNascimento(data);
//        
//        new AlunoDAO().inserirAluno(aluno);       
        //requisicao.setAttribute("aluno", aluno);        
        return "cruds/sucesso-aluno.jsp";
    }
    
}
