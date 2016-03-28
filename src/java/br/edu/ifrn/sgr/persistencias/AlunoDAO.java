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
import br.edu.ifrn.sgr.modelos.Turma;
import br.edu.ifrn.sgr.modelos.Turno;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.edu.ifrn.sgr.persistencias.EnuConsultasAluno;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;
/**
 *
 * @author Luan Medeiros
 */
public class AlunoDAO extends GeralDAO {

    private final String SELECT_ALUNO_BY_MATRICULA_SENHA = "select * from aluno "
                                              + "where matricula=? and senha=?;";

    private final String SELECT_ALUNOS = "select * from aluno;";
    
    public Aluno getAlunoByMatriculaSenha(String nome, String matricula) throws SQLException, ClassNotFoundException{
        ResultSet resultado = executarConsulta(EnuConsultasAluno.SELECT_ALUNO_LOGIN.toString(),nome,matricula);
        ResultSet resultadoPopular = null;
        if (resultado.next())
        {
            resultadoPopular = executarConsulta(EnuConsultasAluno.SELECT_ALUNO_COMPLETO.toString(), resultado.getString("alu_id_PK"));
            return popularAluno(resultadoPopular);
        }
        else
            return null;
    }
    
    public Aluno populaAlunoPorMatricula(String matricula) throws SQLException, ClassNotFoundException
    {
            ResultSet resultadoPopular = executarConsulta(EnuConsultasAluno.SELECT_ALUNO_COMPLETO.toString(), matricula);
            return popularAluno(resultadoPopular);
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
        String CEP = "";
        String TEL = "";
        String CEL = "";
        
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
        
        
        while(resultado.next()){
        aluno.setNome(resultado.getString("pes_nome"));
        aluno.setMatricula(resultado.getString("pes_matricula_PK"));
        aluno.setEmail(resultado.getString("pes_email"));
        TEL = formatString(resultado.getString("pes_telefone"),"(##) ####-####");
        CEL = formatString(resultado.getString("pes_celular"),"(##) #####-####");
        aluno.setTelefone(resultado.getString("pes_telefone"));
        aluno.setCelular(resultado.getString("pes_celular"));
        java.sql.Date dataAlunoSQL = resultado.getDate("pes_data_nascimento");
        java.util.Date data = new java.util.Date(dataAlunoSQL.getTime());
        aluno.setDataNascimento(data);
        
        
        
        campus.setCampusID(resultado.getInt("cam_id"));
        campus.setNome(resultado.getString("cam_nome"));
        campus.setEndereco(resultado.getString("cam_endereco"));
        campus.setBairro(resultado.getString("cam_bairro"));
        campus.setEstado(resultado.getString("cam_estado"));
        campus.setNumero(resultado.getInt("cam_numero"));
        campus.setCidade(resultado.getString("cam_cidade"));
        CEP = formatString(resultado.getString("cam_cep"),"#####-###");
        TEL = formatString(resultado.getString("cam_telefone"),"(##) #####-####");
        campus.setCep(CEP);
        campus.setTelefone(TEL);
        ResultSet consultaCoordenador = executarConsulta(EnuConsultasCoordenador.SELECT_INFORMACOES_COORDENADOR.toString(), resultado.getString("coo_id_PK"));
        while(consultaCoordenador.next())
        {
            coordenador.setNome(consultaCoordenador.getString("pes_nome"));
            coordenador.setMatricula(consultaCoordenador.getString("pes_matricula_PK"));
            coordenador.setEmail(consultaCoordenador.getString("pes_email"));
            TEL = formatString(consultaCoordenador.getString("pes_telefone"),"(##) ####-####");
            CEL = formatString(consultaCoordenador.getString("pes_celular"),"(##) #####-####");
            coordenador.setTelefone(TEL);
            coordenador.setCelular(CEL);
            java.sql.Date dataCoordenadorSQL = consultaCoordenador.getDate("pes_data_nascimento");
            java.util.Date dataCoordenador = new java.util.Date(dataCoordenadorSQL.getTime());
            coordenador.setDataNascimento(dataCoordenador);
        }
      
        curso.setCursoID(resultado.getInt("cur_id_FK"));
        curso.setAnos(resultado.getInt("cur_anos"));
        curso.setNome(resultado.getString("cur_nome"));
        curso.setPeriodo(resultado.getInt("cur_periodos"));
        curso.setCursoAtivo(resultado.getBoolean("cur_ativo"));
        
        ResultSet consultaDiretor = executarConsulta(EnuConsultasDiretor.SELECT_INFORMAÇÕES_DIRETOR.toString(), resultado.getString("dir_id_PK"));
        while(consultaDiretor.next())
        {        
            diretor.setNome(consultaDiretor.getString("pes_nome"));
            diretor.setMatricula(consultaDiretor.getString("pes_matricula_PK"));
            diretor.setEmail(consultaDiretor.getString("pes_email"));
            TEL = formatString(consultaDiretor.getString("pes_telefone"),"(##) ####-####");
            CEL = formatString(consultaDiretor.getString("pes_celular"),"(##) #####-####");            
            diretor.setTelefone(TEL);
            diretor.setCelular(CEL);
            java.sql.Date dataDiretorSQL = consultaDiretor.getDate("pes_data_nascimento");
            java.util.Date dataDiretor = new java.util.Date(dataDiretorSQL.getTime());
            diretor.setDataNascimento(dataDiretor);
        }               
       
        modalidadeCurso.setModalidadeID(resultado.getInt("mod_cur_id"));
        modalidadeCurso.setNivel(resultado.getString("mod_cur_nivel"));
        modalidadeCurso.setNome(resultado.getString("mod_cur_nome"));
        
        
        permissao.setPermissaoID(resultado.getInt("per_id_FK"));
        permissao.setNome(resultado.getString("per_nome"));
         
        turma.setCodigo(resultado.getInt("trm_codigo"));
        
       
        turno.setId(resultado.getInt("trn_id"));
        turno.setNome(resultado.getString("trn_nome"));
        }
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
        

        
        //Inserindo todas as disciplinas no curso.
        ResultSet consultaDisciplinas = executarConsulta(EnuConsultasCurso.SELECT_TODAS_DISCIPLINAS_CURSO.toString(), aluno.getCurso().getCursoID());
        while(consultaDisciplinas.next())
        {
            curso.getDisciplinasDoCurso().add(new Disciplina(consultaDisciplinas.getInt("dis_id"), curso, consultaDisciplinas.getBoolean("dis_ativo"), consultaDisciplinas.getString("dis_nome")));
        }

        //Inserindo todos os professores do curso.
        ResultSet consultaProfessores = executarConsulta(EnuConsultasCurso.SELECT_TODOS_PROFESSORES_DO_CURSO.toString(), aluno.getCurso().getCursoID());
        while(consultaProfessores.next())
        {            
            //java.sql.Date dataProfessorSQL = consultaProfessores.getDate("pes_data_nascimento");
            //java.util.Date dataProfessor = new java.util.Date(dataProfessorSQL.getTime());
            //Permissao novaPermissao = new Permissao(consultaProfessores.getInt("per_id"),consultaProfessores.getString("per_nome"));
            aluno.getCurso().getProfessores().add(new Professor(consultaProfessores.getString("pro_id_PK"),consultaProfessores.getString("pes_nome")));
        }
        

        //Inserindo os professores das disciplinas em cada disciplina. o array encontrade na clase curso.
        for(Disciplina disci : curso.getDisciplinasDoCurso())
        {
            ResultSet consultaProfessoresDisciplina = executarConsulta(EnuConsultasCurso.SELECT_TODOS_PROFESSORES_DA_DISCIPLINA.toString(), disci.getId(), disci.getCurso().getCursoID());
            while(consultaProfessoresDisciplina.next())
            {                
                Permissao novaPermissao = new Permissao();
                java.sql.Date dataProfessorSQL = consultaProfessoresDisciplina.getDate("pes_data_nascimento");
                java.util.Date dataProfessor = new java.util.Date(dataProfessorSQL.getTime());               
                novaPermissao = new Permissao(consultaProfessoresDisciplina.getInt("per_id"), consultaProfessoresDisciplina.getString("per_nome"));                
                disci.getProfessores().add(new Professor(novaPermissao, consultaProfessoresDisciplina.getString("pro_id_PK"),consultaProfessoresDisciplina.getString("pes_nome"),consultaProfessoresDisciplina.getString("pes_email"),consultaProfessoresDisciplina.getString("pes_telefone"),consultaProfessoresDisciplina.getString("pes_celular"),dataProfessor));                
            }            
        }
        
        //Inserindo no arraylist de cursos possíveis para transferência, o array encontra-se na classe Aluno.
        ResultSet consultaCursosTranferencia = executarConsulta(EnuConsultasCurso.SELECT_CURSOS_POSSIVEIS_TRANSFERÊNCIA.toString(), curso.getModalidade().getModalidadeID(), curso.getCursoID());
        while(consultaCursosTranferencia.next())
        {           
            Campus campusCursoTransferencia = new Campus();            
            Curso cursoTransferencia = new Curso();
            
            campusCursoTransferencia.setCampusID(consultaCursosTranferencia.getInt("cam_id_FK"));
            campusCursoTransferencia.setNome("Campus "+consultaCursosTranferencia.getString("cam_nome"));
            
            cursoTransferencia.setCampus(campusCursoTransferencia);
            cursoTransferencia.setNome(consultaCursosTranferencia.getString("cur_nome"));
            cursoTransferencia.setCursoID(consultaCursosTranferencia.getInt("cur_id"));            
            
            curso.getCursosTranferencia().add(cursoTransferencia);
        }
        
        //Inserindo no arraylist de turmas possíveis para transferência, o array encontra-se na classe Aluno.
        ResultSet consultaTurmasTranferencia = executarConsulta(EnuConsultasCurso.SELECT_TURMAS_POSSIVEIS_MUDANCA.toString(), aluno.getTurma().getCodigo(), curso.getCursoID());
        while(consultaTurmasTranferencia.next())
        {
            curso.getTurmasTranferencia().add(new Turma(consultaTurmasTranferencia.getInt("trm_codigo"), curso));
            
        }

        //Inserindo no arraylist de turnos possíveis para transferência, o array encontra-se na classe Aluno.
        ResultSet consultaTurnosTranferencia = executarConsulta(EnuConsultasCurso.SELECT_TURNOS_POSSIVEIS_MUDANCA.toString(), curso.getTurno().getId(), curso.getCampus().getCampusID(), curso.getNome(),curso.getModalidade().getModalidadeID());
        while(consultaTurnosTranferencia.next())
        {
            curso.getTurnosTranferencia().add(new Turno(consultaTurnosTranferencia.getInt("trn_id"), consultaTurnosTranferencia.getString("trn_nome")));
        }        
        

        return aluno;
    }
    private String formatString(String value, String pattern) {
        MaskFormatter mf;
        try {
            mf = new MaskFormatter(pattern);
            mf.setValueContainsLiteralCharacters(false);
            return mf.valueToString(value);
        } catch (ParseException ex) {
            return value;
        }
    }
}
