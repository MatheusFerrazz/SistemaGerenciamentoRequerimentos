/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.sgr.persistencias;

import br.edu.ifrn.sgr.modelos.Aluno;
import br.edu.ifrn.sgr.modelos.Campus;
import br.edu.ifrn.sgr.modelos.Coordenador;
import br.edu.ifrn.sgr.modelos.Curso;
import br.edu.ifrn.sgr.modelos.ModalidadeCurso;
import br.edu.ifrn.sgr.modelos.Turma;
import br.edu.ifrn.sgr.modelos.Turno;
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
        Aluno aluno = new Aluno();
        aluno.setNome(resultado.getString("nome"));
        aluno.setMatricula(resultado.getString("matricula"));
        aluno.setEmail(resultado.getString("email"));
        aluno.setTelefone(resultado.getString("telefone"));
        aluno.setCelular(resultado.getString("celular"));
        java.sql.Date dataSQL = resultado.getDate("datanascimento");
        java.util.Date data = new java.util.Date(dataSQL.getTime());
        aluno.setDataNascimento(data);
        
         
        Curso curso = new Curso();
        curso.setAnos(resultado.getInt("ano"));
        curso.setNome(resultado.getString("nomeCurso"));
        curso.setPeriodo(resultado.getInt("periodo"));
        curso.setCursoAtivo(resultado.getBoolean("cursoAtivo"));
        
        ModalidadeCurso modalidadeCurso = new ModalidadeCurso();
        modalidadeCurso.setModalidadeID(resultado.getInt("modalidadeCurso"));
        modalidadeCurso.setNivel(resultado.getString("modalidadeCurso"));
        modalidadeCurso.setNome(resultado.getString("nomeModalidade"));
                
        Campus campus = new Campus();
        campus.setCampusID(resultado.getInt("idCampus"));
        campus.setNome(resultado.getString("nomeCampus"));
        campus.setEndereco(resultado.getString("campusEndereco"));
        campus.setBairro(resultado.getString("campusBairro"));
        campus.setEstado(resultado.getString("campusEstado"));
        campus.setCep(resultado.getString("campusCep"));
        campus.setTelefone(resultado.getString("campusTelefone"));
        
        Turno turno = new Turno();
        turno.setId(resultado.getInt("idTurno"));
        turno.setNome(resultado.getString("nomeTurno"));
              
        Coordenador coordenador = new Coordenador();
                 
        Turma turma = new Turma();
        turma.setCodigo(resultado.getInt("codigoTurma"));
        
        return aluno;
    }
}
