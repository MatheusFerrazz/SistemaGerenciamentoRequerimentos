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
import br.edu.ifrn.sgr.modelos.Turma;
import br.edu.ifrn.sgr.modelos.Turno;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.edu.ifrn.sgr.persistencias.EnuConsultasAluno;
/**
 *
 * @author João
 */
public class AlunoDAO extends GeralDAO {

    private final GeralDAO geralDAO = new GeralDAO();
    private final String SELECT_ALUNO_BY_MATRICULA_SENHA = "select * from aluno "
                                              + "where matricula=? and senha=?;";

    private final String SELECT_ALUNOS = "select * from aluno;";
    
    public Aluno alunoByMatriculaSenha(String nome, String matricula) throws SQLException, ClassNotFoundException{
        ResultSet resultado = executarConsulta(EnuConsultasAluno.SELECT_ALUNO_COMPLETO.toString(),nome,matricula);
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
    
    public Aluno popularAluno(ResultSet resultado) throws SQLException, ClassNotFoundException{
        
        
        Aluno aluno = new Aluno();
        Campus campus = new Campus();
        Coordenador coordenador = new Coordenador();
        Curso curso = new Curso();
        Diretor diretor = new Diretor();
        Disciplina disciplina = new Disciplina();
        Ifrn ifrn = new Ifrn();
        ModalidadeCurso modalidadeCurso = new ModalidadeCurso();
        Permissao permissao = new Permissao();
        Turma turma = new Turma();
        Turno turno = new Turno();
        
        
        
        aluno.setNome(resultado.getString("pes_nome"));
        aluno.setMatricula(resultado.getString("pes_matricula"));
        aluno.setEmail(resultado.getString("pes_email"));
        aluno.setTelefone(resultado.getString("pes_telefone"));
        aluno.setCelular(resultado.getString("pes_celular"));
        java.sql.Date dataAlunoSQL = resultado.getDate("pes_data_nascimento");
        java.util.Date data = new java.util.Date(dataAlunoSQL.getTime());
        aluno.setDataNascimento(data);
        
        
        
        campus.setCampusID(resultado.getInt("cam_id"));
        campus.setNome(resultado.getString("cam_nome"));
        campus.setEndereco(resultado.getString("cam_endereco"));
        campus.setBairro(resultado.getString("cam-bairro"));
        campus.setEstado(resultado.getString("cam-estado"));
        campus.setCep(resultado.getString("cam-cep"));
        campus.setTelefone(resultado.getString("cam-telefone"));
        
        
        coordenador.setNome(resultado.getString("nomeCoordenador"));
        coordenador.setMatricula(resultado.getString("matriculaCoordenador"));
        coordenador.setEmail(resultado.getString("emailCoordenador"));
        coordenador.setTelefone(resultado.getString("telefoneCoordenador"));
        coordenador.setCelular(resultado.getString("celularCoordenador"));
        java.sql.Date dataCoordenadorSQL = resultado.getDate("datanascimentoCoordenador");
        java.util.Date dataCoordenador = new java.util.Date(dataCoordenadorSQL.getTime());
        coordenador.setDataNascimento(dataCoordenador);
        
      
        curso.setCursoID(resultado.getInt("idCurso"));
        curso.setAnos(resultado.getInt("anoCurso"));
        curso.setNome(resultado.getString("nomeCurso"));
        curso.setPeriodo(resultado.getInt("periodoCurso"));
        curso.setCursoAtivo(resultado.getBoolean("cursoAtivo"));
        
        
        diretor.setNome(resultado.getString("nomeDiretor"));
        diretor.setMatricula(resultado.getString("matriculaDiretor"));
        diretor.setEmail(resultado.getString("emailDiretor"));
        diretor.setTelefone(resultado.getString("telefoneDiretor"));
        diretor.setCelular(resultado.getString("celularDiretor"));
        java.sql.Date dataDiretorSQL = resultado.getDate("datanascimentoDiretor");
        java.util.Date dataDiretor = new java.util.Date(dataDiretorSQL.getTime());
        diretor.setDataNascimento(dataDiretor);
        
        
        disciplina.setId(resultado.getInt("idDisciplina"));
        disciplina.setNome(resultado.getString("nomeDisciplina"));
        disciplina.setAtiva(resultado.getBoolean("disciplinaAtiva"));
        
        
        ifrn.setIfrnID(resultado.getInt("idIfrn"));
        ifrn.setRazaoSocial(resultado.getString("ifrnRazaoSocial"));
        
       
        modalidadeCurso.setModalidadeID(resultado.getInt("idModalidade"));
        modalidadeCurso.setNivel(resultado.getString("modalidadeCurso"));
        modalidadeCurso.setNome(resultado.getString("nomeModalidade"));
        
       
        permissao.setPermissaoID(resultado.getInt("idPermissao"));
        permissao.setNome(resultado.getString("nomePermissao"));
         
        turma.setCodigo(resultado.getInt("codigoTurma"));
        
       
        turno.setId(resultado.getInt("idTurno"));
        turno.setNome(resultado.getString("nomeTurno"));
        
        //Encapuslando objetos
        campus.setDiretor(diretor);
        curso.setTurno(turno);
        curso.setCampus(campus);
        curso.setModalidade(modalidadeCurso);
        curso.setCoordenador(coordenador);
        turma.setCurso(curso);
        aluno.setCurso(curso);
        aluno.setTurma(turma);
        aluno.setPermissao(permissao);      
        
        //Preenchendo os array dos objetos
        ResultSet consulta = geralDAO.executarConsulta(EnuConsultasAluno.SELECT_TODAS_DISCIPLINAS_CURSO.toString(), aluno.getCurso().getCursoID());
        while(consulta.next())
        {
            curso.getDisciplinas().add(new Disciplina(consulta.getInt("dis_id"), curso, true, consulta.getString("dis_nome")));
        }
        
//        consulta = geralDAO.executarConsulta(EnuConsultasAluno.SELECT_TODOS_PROFESSORES_DO_CURSO.toString(), aluno.getCurso().getCursoID());
//        while(consulta.next())
//        {
//            java.sql.Date dataNascimento = consulta.getDate("pes_data_nascimento");
//            curso.getProfessores().add(new Professor(new Permissao(consulta.getInt("per_id_FK"), consulta.getString("per_nome")), consulta.getString("pro_id_PK"), consulta.getString("pes_nome"), consulta.getString("pes_email"), consulta.getString("pes_telefone"), consulta.getString("pes_celular"), new java.util.Date(dataNascimento.getTime())));
//        }
//        
        return aluno;
    }
}
