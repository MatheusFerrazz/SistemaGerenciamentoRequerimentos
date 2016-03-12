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
import br.edu.ifrn.sgr.modelos.Diretor;
import br.edu.ifrn.sgr.modelos.Disciplina;
import br.edu.ifrn.sgr.modelos.Ifrn;
import br.edu.ifrn.sgr.modelos.ModalidadeCurso;
import br.edu.ifrn.sgr.modelos.Permissao;
import br.edu.ifrn.sgr.modelos.Professor;
import br.edu.ifrn.sgr.modelos.Requerimento;
import br.edu.ifrn.sgr.modelos.TecnicoAdministrativo;
import br.edu.ifrn.sgr.modelos.TipoAtividade;
import br.edu.ifrn.sgr.modelos.TipoDocumento;
import br.edu.ifrn.sgr.modelos.TipoRequerimento;
import br.edu.ifrn.sgr.modelos.Turma;
import br.edu.ifrn.sgr.modelos.Turno;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author João
 */
public class RequerimentoDAO extends GeralDAO {

    private final String SELECT_ALUNO_BY_MATRICULA_SENHA = "select * from aluno "
                                              + "where matricula=? and senha=?;";

    private final String SELECT_ALUNOS = "select * from aluno;";
    
    public Aluno getAlunoByMatriculaSenha(String matricula, String senha) throws SQLException, ClassNotFoundException{
        ResultSet resultado = executarConsulta(SELECT_ALUNO_BY_MATRICULA_SENHA,matricula,senha);
       /* if (resultado.next())
            return popularAluno(resultado);
        else*/
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
    
    public Requerimento popularAluno(ResultSet resultado) throws SQLException{

        return null;
    }
}
