/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.sgr.persistencias;

import br.edu.ifrn.sgr.modelos.Aluno;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author João
 */
public class AlunoDAO extends GeralDAO {

    private final String SELECT_ALUNO_BY_MATRICULA_SENHA = "select * from aluno "
                                              + "where matricula=? and senha=?;";

    private final String SELECT_ALUNOS = "select * from aluno;";
    
    public Aluno getAlunoByMatriculaSenha(String matricula, String senha) throws SQLException, ClassNotFoundException{
        ResultSet resultado = executarConsulta(SELECT_ALUNO_BY_MATRICULA_SENHA,matricula,senha);
        if (resultado.next())
            return popularAluno(resultado);
        else
            return null;
    }
    
//    public List<Aluno> getAlunos() throws SQLException, ClassNotFoundException{
//        ResultSet resultado = executarConsulta(SELECT_ALUNOS);
//        List<Aluno> alunos = new java.util.ArrayList();
//        while (resultado.next()){
//            alunos.add(popularAluno(resultado));
//        }
//        return alunos;
//    }
    
    public Aluno popularAluno(ResultSet resultado) throws SQLException{
       // Aluno aluno = new Aluno();
        aluno.setNome(resultado.getString("nome"));
        aluno.setMatricula(resultado.getString("matricula"));
        aluno.setEmail(resultado.getString("email"));
        aluno.setTelefone(resultado.getString("telefone"));
        aluno.setCelular(resultado.getString("celular"));
        java.sql.Date dataSQL = resultado.getDate("datanascimento");
        java.util.Date data = new java.util.Date(dataSQL.getTime());
        aluno.setDataNascimento(data);
        
        return aluno;
    }
}
