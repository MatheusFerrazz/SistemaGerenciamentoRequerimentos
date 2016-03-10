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
        aluno.setNome(resultado.getString("nomeAluno"));
        aluno.setMatricula(resultado.getString("matriculaAluno"));
        aluno.setEmail(resultado.getString("emailAluno"));
        aluno.setTelefone(resultado.getString("telefonealuno"));
        aluno.setCelular(resultado.getString("celularAluno"));
        java.sql.Date dataAlunoSQL = resultado.getDate("datanascimentoAluno");
        java.util.Date data = new java.util.Date(dataAlunoSQL.getTime());
        aluno.setDataNascimento(data);
        
        Campus campus = new Campus();
        campus.setCampusID(resultado.getInt("idCampus"));
        campus.setNome(resultado.getString("nomeCampus"));
        campus.setEndereco(resultado.getString("campusEndereco"));
        campus.setBairro(resultado.getString("campusBairro"));
        campus.setEstado(resultado.getString("campusEstado"));
        campus.setCep(resultado.getString("campusCep"));
        campus.setTelefone(resultado.getString("campusTelefone"));
        
        Coordenador coordenador = new Coordenador();
        coordenador.setNome(resultado.getString("nomeCoordenador"));
        coordenador.setMatricula(resultado.getString("matriculaCoordenador"));
        coordenador.setEmail(resultado.getString("emailCoordenador"));
        coordenador.setTelefone(resultado.getString("telefoneCoordenador"));
        coordenador.setCelular(resultado.getString("celularCoordenador"));
        java.sql.Date dataCoordenadorSQL = resultado.getDate("datanascimentoCoordenador");
        java.util.Date dataCoordenador = new java.util.Date(dataCoordenadorSQL.getTime());
        coordenador.setDataNascimento(dataCoordenador);
        
        Curso curso = new Curso();
        curso.setCursoID(resultado.getInt("idCurso"));
        curso.setAnos(resultado.getInt("anoCurso"));
        curso.setNome(resultado.getString("nomeCurso"));
        curso.setPeriodo(resultado.getInt("periodoCurso"));
        curso.setCursoAtivo(resultado.getBoolean("cursoAtivo"));
        
        Diretor diretor = new Diretor();
        diretor.setNome(resultado.getString("nomeDiretor"));
        diretor.setMatricula(resultado.getString("matriculaDiretor"));
        diretor.setEmail(resultado.getString("emailDiretor"));
        diretor.setTelefone(resultado.getString("telefoneDiretor"));
        diretor.setCelular(resultado.getString("celularDiretor"));
        java.sql.Date dataDiretorSQL = resultado.getDate("datanascimentoDiretor");
        java.util.Date dataDiretor = new java.util.Date(dataDiretorSQL.getTime());
        diretor.setDataNascimento(dataDiretor);
        
        Disciplina disciplina = new Disciplina();
        disciplina.setId(resultado.getInt("idDisciplina"));
        disciplina.setNome(resultado.getString("nomeDisciplina"));
        disciplina.setAtiva(resultado.getBoolean("disciplinaAtiva"));
        
        Ifrn ifrn = new Ifrn();
        ifrn.setIfrnID(resultado.getInt("idIfrn"));
        ifrn.setRazaoSocial(resultado.getString("ifrnRazaoSocial"));
        
        ModalidadeCurso modalidadeCurso = new ModalidadeCurso();
        modalidadeCurso.setModalidadeID(resultado.getInt("idModalidade"));
        modalidadeCurso.setNivel(resultado.getString("modalidadeCurso"));
        modalidadeCurso.setNome(resultado.getString("nomeModalidade"));
        
        Permissao permissao = new Permissao();
        permissao.setPermissaoID(resultado.getInt("idPermissao"));
        permissao.setNome(resultado.getString("nomePermissao"));
               
        Professor professor = new Professor();
        professor.setNome(resultado.getString("nomeProfessor"));
        professor.setMatricula(resultado.getString("matriculaProfessor"));
        professor.setEmail(resultado.getString("emailProfessor"));
        professor.setTelefone(resultado.getString("telefoneProfessor"));
        professor.setCelular(resultado.getString("celularProfessor"));
        java.sql.Date dataProfessorSQL = resultado.getDate("datanascimentoProfessor");
        java.util.Date dataProfessor = new java.util.Date(dataProfessorSQL.getTime());
        professor.setDataNascimento(dataDiretor);
        
        TecnicoAdministrativo tecAdministrativo = new TecnicoAdministrativo();
        tecAdministrativo.setNome(resultado.getString("nomeTecAdministrativo"));
        tecAdministrativo.setMatricula(resultado.getString("matriculaTecAdministrativo"));
        tecAdministrativo.setEmail(resultado.getString("emailTecAdministrativo"));
        tecAdministrativo.setTelefone(resultado.getString("telefoneTecAdministrativo"));
        tecAdministrativo.setCelular(resultado.getString("celularTecAdministrativo"));
        java.sql.Date dataTecAdministrativoSQL = resultado.getDate("datanascimentoTecAdministrativo");
        java.util.Date dataTecAdministrativo = new java.util.Date(dataTecAdministrativoSQL.getTime());
        tecAdministrativo.setDataNascimento(dataTecAdministrativo);
               
        TipoAtividade tipoAtividade = new TipoAtividade();
        tipoAtividade.setId(resultado.getInt("idTipoAtividade"));
        tipoAtividade.setNome(resultado.getString("nomeTipoAtividade"));
        
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setId(resultado.getInt("idTipoDocumento"));
        tipoDocumento.setNome(resultado.getString("nomeTipoDocumento"));
        
        TipoRequerimento tipoRequerimento = new TipoRequerimento();
        tipoRequerimento.setId(resultado.getInt("idTipoRequerimento"));
        tipoRequerimento.setNome(resultado.getString("nomeTipoRequerimento"));
               
        Turma turma = new Turma();
        turma.setCodigo(resultado.getInt("codigoTurma"));
               
        Turno turno = new Turno();
        turno.setId(resultado.getInt("idTurno"));
        turno.setNome(resultado.getString("nomeTurno"));
                                         
        
        return aluno;
    }
}
