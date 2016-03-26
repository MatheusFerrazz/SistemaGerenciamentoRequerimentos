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
import br.edu.ifrn.sgr.modelos.RequerimentoPopuladoString;
import br.edu.ifrn.sgr.modelos.TecnicoAdministrativo;
import br.edu.ifrn.sgr.modelos.TipoDocumento;
import br.edu.ifrn.sgr.modelos.TipoRequerimento;
import br.edu.ifrn.sgr.modelos.Turma;
import br.edu.ifrn.sgr.modelos.Turno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author João
 */
public class RequerimentoDAO extends GeralDAO {

    private static SimpleDateFormat formatDataBrasil = new SimpleDateFormat("dd/MM/yyyy");


    /*public Aluno getRequerimentos(String matricula, String senha) throws SQLException, ClassNotFoundException{
        ResultSet resultado = executarConsulta(SELECT_ALUNO_BY_MATRICULA_SENHA,matricula,senha);
        if (resultado.next())
            return popularAluno(resultado);
        
            return null;
    }*/
    public int cadastraRequerimentoComRetornoID(String sql, Object... parametros) throws SQLException, ClassNotFoundException {
        Integer idGerado = null;
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);
        for (int i = 1; i <= parametros.length; i++) {
            comando.setObject(i, parametros[i - 1]);
        }
        ResultSet result = comando.executeQuery();
        FabricaConexao.fecharConexao(con);

        if (result.next()) {
            idGerado = result.getInt("req_id");
        }

        return idGerado;
    }

    public void cadastraRequerimentoSemRetornoID(String sql, Object... parametros) throws SQLException, ClassNotFoundException {
        Connection con = FabricaConexao.getConexao();

        PreparedStatement comando = con.prepareStatement(sql);
        for (int i = 1; i <= parametros.length; i++) {
            comando.setObject(i, parametros[i - 1]);
        }
        comando.executeUpdate();
        FabricaConexao.fecharConexao(con);
    }

    /*Métodos para polular requerimentos do lado do aluno*/
 /*public RequerimentoPopuladoString popularRequerimento(ResultSet resultado) throws SQLException{            
            RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
        return null;
    }*/
    public ArrayList<RequerimentoPopuladoString> populaAproveitaMentoDeEstudo(String sql, Object... parametros) throws ClassNotFoundException, SQLException {
        ArrayList requerimentosPopulados = new ArrayList<>();
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);
        for (int i = 1; i <= parametros.length; i++) {
            comando.setObject(i, parametros[i - 1]);
        }
        ResultSet resultado = comando.executeQuery();
        FabricaConexao.fecharConexao(con);

        /*Preenchendo os objetos de requerimentos após a consulta e inserido no array*/
        while (resultado.next()) {
            RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
            requerimentoPopuladoString.setRequerimentoID(resultado.getInt("req_id"));
            requerimentoPopuladoString.setAlunoMatricula(resultado.getString("alu_id_FK"));
            requerimentoPopuladoString.setObservacoes(resultado.getString("req_observacoes"));
            requerimentoPopuladoString.setDisciplinaCursada(resultado.getString("req_disciplina_cursada"));

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            ResultSet consultaDisciplina = executarConsulta(EnuConsultasDisciplinas.SELECT_NOME_DISCIPLINA.toString(), resultado.getInt("req_disciplina_curso_atual_FK"));
            if (consultaDisciplina.next()) {
                requerimentoPopuladoString.setDisciplinaCursoAtual(consultaDisciplina.getString("disciplina"));
            }

            ResultSet consultaDocumentosApresentados = executarConsulta(EnuConsultasRequerimento.SELECT_DOCUMENTOS_APRESENTADOS_DO_REQUERIMENTO.toString(), requerimentoPopuladoString.getRequerimentoID());
            while (consultaDocumentosApresentados.next()) {
                requerimentoPopuladoString.getDocumentosApresentados().add(consultaDocumentosApresentados.getString("documento"));
            }

            //Adicionados objeto ao array de requerimentos já populado
            requerimentosPopulados.add(requerimentoPopuladoString);

        }

        return requerimentosPopulados;
    }

    public ArrayList<RequerimentoPopuladoString> populaCertificacaoDeConhecimento(String sql, Object... parametros) throws ClassNotFoundException, SQLException {
        ArrayList requerimentosPopulados = new ArrayList<>();
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);
        for (int i = 1; i <= parametros.length; i++) {
            comando.setObject(i, parametros[i - 1]);
        }
        ResultSet resultado = comando.executeQuery();
        FabricaConexao.fecharConexao(con);

        /*Preenchendo os objetos de requerimentos após a consulta e inserido no array*/
        while (resultado.next()) {
            RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
            requerimentoPopuladoString.setRequerimentoID(resultado.getInt("req_id"));
            requerimentoPopuladoString.setAlunoMatricula(resultado.getString("alu_id_FK"));
            requerimentoPopuladoString.setObservacoes(resultado.getString("req_observacoes"));
            requerimentoPopuladoString.setDisciplinaCursada(resultado.getString("req_disciplina_cursada"));

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            ResultSet consultaDisciplina = executarConsulta(EnuConsultasDisciplinas.SELECT_NOME_DISCIPLINA.toString(), resultado.getInt("req_disciplina_curso_atual_FK"));
            if (consultaDisciplina.next()) {
                requerimentoPopuladoString.setDisciplinaCursoAtual(consultaDisciplina.getString("disciplina"));
            }

            ResultSet consultaDocumentosApresentados = executarConsulta(EnuConsultasRequerimento.SELECT_DOCUMENTOS_APRESENTADOS_DO_REQUERIMENTO.toString(), requerimentoPopuladoString.getRequerimentoID());
            while (consultaDocumentosApresentados.next()) {
                requerimentoPopuladoString.getDocumentosApresentados().add(consultaDocumentosApresentados.getString("documento"));
            }

            //Adicionados objeto ao array de requerimentos já populado
            requerimentosPopulados.add(requerimentoPopuladoString);

        }

        return requerimentosPopulados;
    }

    //Popula reposicao atividade
    public ArrayList<RequerimentoPopuladoString> populaReposicaoAtividade(String sql, Object... parametros) throws ClassNotFoundException, SQLException {
        ArrayList requerimentosPopulados = new ArrayList<>();
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);
        for (int i = 1; i <= parametros.length; i++) {
            comando.setObject(i, parametros[i - 1]);
        }
        ResultSet resultado = comando.executeQuery();
        FabricaConexao.fecharConexao(con);

        /*Preenchendo os objetos de requerimentos após a consulta e inserido no array*/
        while (resultado.next()) {
            RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
            requerimentoPopuladoString.setRequerimentoID(resultado.getInt("req_id"));
            requerimentoPopuladoString.setAlunoMatricula(resultado.getString("alu_id_FK"));
            requerimentoPopuladoString.setObservacoes(resultado.getString("req_observacoes"));
            requerimentoPopuladoString.setDisciplinaCursada(resultado.getString("req_disciplina_cursada"));

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            ResultSet consultaDisciplina = executarConsulta(EnuConsultasDisciplinas.SELECT_NOME_DISCIPLINA.toString(), resultado.getInt("req_disciplina_curso_atual_FK"));
            if (consultaDisciplina.next()) {
                requerimentoPopuladoString.setDisciplinaCursoAtual(consultaDisciplina.getString("disciplina"));
            }

            ResultSet consultaDocumentosApresentados = executarConsulta(EnuConsultasRequerimento.SELECT_DOCUMENTOS_APRESENTADOS_DO_REQUERIMENTO.toString(), requerimentoPopuladoString.getRequerimentoID());
            while (consultaDocumentosApresentados.next()) {
                requerimentoPopuladoString.getDocumentosApresentados().add(consultaDocumentosApresentados.getString("documento"));
            }

            //Adicionados objeto ao array de requerimentos já populado
            requerimentosPopulados.add(requerimentoPopuladoString);

        }

        return requerimentosPopulados;
    }

    //Popula mudança de curso
    public ArrayList<RequerimentoPopuladoString> populaMudancaCurso(String sql, Object... parametros) throws ClassNotFoundException, SQLException {
        ArrayList requerimentosPopulados = new ArrayList<>();
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);
        for (int i = 1; i <= parametros.length; i++) {
            comando.setObject(i, parametros[i - 1]);
        }
        ResultSet resultado = comando.executeQuery();
        FabricaConexao.fecharConexao(con);

        /*Preenchendo os objetos de requerimentos após a consulta e inserido no array*/
        while (resultado.next()) {
            RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
            requerimentoPopuladoString.setRequerimentoID(resultado.getInt("req_id"));
            requerimentoPopuladoString.setAlunoMatricula(resultado.getString("alu_id_FK"));
            requerimentoPopuladoString.setObservacoes(resultado.getString("req_observacoes"));
            requerimentoPopuladoString.setDisciplinaCursada(resultado.getString("req_disciplina_cursada"));

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            ResultSet consultaDisciplina = executarConsulta(EnuConsultasDisciplinas.SELECT_NOME_DISCIPLINA.toString(), resultado.getInt("req_disciplina_curso_atual_FK"));
            if (consultaDisciplina.next()) {
                requerimentoPopuladoString.setDisciplinaCursoAtual(consultaDisciplina.getString("disciplina"));
            }

            ResultSet consultaDocumentosApresentados = executarConsulta(EnuConsultasRequerimento.SELECT_DOCUMENTOS_APRESENTADOS_DO_REQUERIMENTO.toString(), requerimentoPopuladoString.getRequerimentoID());
            while (consultaDocumentosApresentados.next()) {
                requerimentoPopuladoString.getDocumentosApresentados().add(consultaDocumentosApresentados.getString("documento"));
            }

            //Adicionados objeto ao array de requerimentos já populado
            requerimentosPopulados.add(requerimentoPopuladoString);

        }

        return requerimentosPopulados;
    }

    //Popula mudança de turma
    public ArrayList<RequerimentoPopuladoString> populaMudancaTurma(String sql, Object... parametros) throws ClassNotFoundException, SQLException {
        ArrayList requerimentosPopulados = new ArrayList<>();
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);
        for (int i = 1; i <= parametros.length; i++) {
            comando.setObject(i, parametros[i - 1]);
        }
        ResultSet resultado = comando.executeQuery();
        FabricaConexao.fecharConexao(con);

        /*Preenchendo os objetos de requerimentos após a consulta e inserido no array*/
        while (resultado.next()) {
            RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
            requerimentoPopuladoString.setRequerimentoID(resultado.getInt("req_id"));
            requerimentoPopuladoString.setAlunoMatricula(resultado.getString("alu_id_FK"));
            requerimentoPopuladoString.setObservacoes(resultado.getString("req_observacoes"));
            requerimentoPopuladoString.setDisciplinaCursada(resultado.getString("req_disciplina_cursada"));

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            ResultSet consultaDisciplina = executarConsulta(EnuConsultasDisciplinas.SELECT_NOME_DISCIPLINA.toString(), resultado.getInt("req_disciplina_curso_atual_FK"));
            if (consultaDisciplina.next()) {
                requerimentoPopuladoString.setDisciplinaCursoAtual(consultaDisciplina.getString("disciplina"));
            }

            ResultSet consultaDocumentosApresentados = executarConsulta(EnuConsultasRequerimento.SELECT_DOCUMENTOS_APRESENTADOS_DO_REQUERIMENTO.toString(), requerimentoPopuladoString.getRequerimentoID());
            while (consultaDocumentosApresentados.next()) {
                requerimentoPopuladoString.getDocumentosApresentados().add(consultaDocumentosApresentados.getString("documento"));
            }

            //Adicionados objeto ao array de requerimentos já populado
            requerimentosPopulados.add(requerimentoPopuladoString);

        }

        return requerimentosPopulados;
    }

    //Popula mudança de turno
    public ArrayList<RequerimentoPopuladoString> populaMudancaTurno(String sql, Object... parametros) throws ClassNotFoundException, SQLException {
        ArrayList requerimentosPopulados = new ArrayList<>();
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);
        for (int i = 1; i <= parametros.length; i++) {
            comando.setObject(i, parametros[i - 1]);
        }
        ResultSet resultado = comando.executeQuery();
        FabricaConexao.fecharConexao(con);

        /*Preenchendo os objetos de requerimentos após a consulta e inserido no array*/
        while (resultado.next()) {
            RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
            requerimentoPopuladoString.setRequerimentoID(resultado.getInt("req_id"));
            requerimentoPopuladoString.setAlunoMatricula(resultado.getString("alu_id_FK"));
            requerimentoPopuladoString.setObservacoes(resultado.getString("req_observacoes"));
            requerimentoPopuladoString.setDisciplinaCursada(resultado.getString("req_disciplina_cursada"));

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            ResultSet consultaDisciplina = executarConsulta(EnuConsultasDisciplinas.SELECT_NOME_DISCIPLINA.toString(), resultado.getInt("req_disciplina_curso_atual_FK"));
            if (consultaDisciplina.next()) {
                requerimentoPopuladoString.setDisciplinaCursoAtual(consultaDisciplina.getString("disciplina"));
            }

            ResultSet consultaDocumentosApresentados = executarConsulta(EnuConsultasRequerimento.SELECT_DOCUMENTOS_APRESENTADOS_DO_REQUERIMENTO.toString(), requerimentoPopuladoString.getRequerimentoID());
            while (consultaDocumentosApresentados.next()) {
                requerimentoPopuladoString.getDocumentosApresentados().add(consultaDocumentosApresentados.getString("documento"));
            }

            //Adicionados objeto ao array de requerimentos já populado
            requerimentosPopulados.add(requerimentoPopuladoString);

        }

        return requerimentosPopulados;
    }

    //Popula tranferencia
    public ArrayList<RequerimentoPopuladoString> populaTransferencia(String sql, Object... parametros) throws ClassNotFoundException, SQLException {
        ArrayList requerimentosPopulados = new ArrayList<>();
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);
        for (int i = 1; i <= parametros.length; i++) {
            comando.setObject(i, parametros[i - 1]);
        }
        ResultSet resultado = comando.executeQuery();
        FabricaConexao.fecharConexao(con);

        /*Preenchendo os objetos de requerimentos após a consulta e inserido no array*/
        while (resultado.next()) {
            RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
            requerimentoPopuladoString.setRequerimentoID(resultado.getInt("req_id"));
            requerimentoPopuladoString.setAlunoMatricula(resultado.getString("alu_id_FK"));
            requerimentoPopuladoString.setObservacoes(resultado.getString("req_observacoes"));
            requerimentoPopuladoString.setDisciplinaCursada(resultado.getString("req_disciplina_cursada"));

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            ResultSet consultaDisciplina = executarConsulta(EnuConsultasDisciplinas.SELECT_NOME_DISCIPLINA.toString(), resultado.getInt("req_disciplina_curso_atual_FK"));
            if (consultaDisciplina.next()) {
                requerimentoPopuladoString.setDisciplinaCursoAtual(consultaDisciplina.getString("disciplina"));
            }

            ResultSet consultaDocumentosApresentados = executarConsulta(EnuConsultasRequerimento.SELECT_DOCUMENTOS_APRESENTADOS_DO_REQUERIMENTO.toString(), requerimentoPopuladoString.getRequerimentoID());
            while (consultaDocumentosApresentados.next()) {
                requerimentoPopuladoString.getDocumentosApresentados().add(consultaDocumentosApresentados.getString("documento"));
            }

            //Adicionados objeto ao array de requerimentos já populado
            requerimentosPopulados.add(requerimentoPopuladoString);

        }

        return requerimentosPopulados;
    }

    //Popula lancamento revisao faltas, notas, situacao
    public ArrayList<RequerimentoPopuladoString> populaLancamentoRevisaoFaltas(String sql, Object... parametros) throws ClassNotFoundException, SQLException {
        ArrayList requerimentosPopulados = new ArrayList<>();
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);
        for (int i = 1; i <= parametros.length; i++) {
            comando.setObject(i, parametros[i - 1]);
        }
        ResultSet resultado = comando.executeQuery();
        FabricaConexao.fecharConexao(con);

        /*Preenchendo os objetos de requerimentos após a consulta e inserido no array*/
        while (resultado.next()) {
            RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
            requerimentoPopuladoString.setRequerimentoID(resultado.getInt("req_id"));
            requerimentoPopuladoString.setAlunoMatricula(resultado.getString("alu_id_FK"));
            requerimentoPopuladoString.setObservacoes(resultado.getString("req_observacoes"));
            requerimentoPopuladoString.setDisciplinaCursada(resultado.getString("req_disciplina_cursada"));

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            ResultSet consultaDisciplina = executarConsulta(EnuConsultasDisciplinas.SELECT_NOME_DISCIPLINA.toString(), resultado.getInt("req_disciplina_curso_atual_FK"));
            if (consultaDisciplina.next()) {
                requerimentoPopuladoString.setDisciplinaCursoAtual(consultaDisciplina.getString("disciplina"));
            }

            ResultSet consultaDocumentosApresentados = executarConsulta(EnuConsultasRequerimento.SELECT_DOCUMENTOS_APRESENTADOS_DO_REQUERIMENTO.toString(), requerimentoPopuladoString.getRequerimentoID());
            while (consultaDocumentosApresentados.next()) {
                requerimentoPopuladoString.getDocumentosApresentados().add(consultaDocumentosApresentados.getString("documento"));
            }

            //Adicionados objeto ao array de requerimentos já populado
            requerimentosPopulados.add(requerimentoPopuladoString);

        }

        return requerimentosPopulados;
    }

    //Popula renovacao matricula
    public ArrayList<RequerimentoPopuladoString> populaRenovacaoMatricula(String sql, Object... parametros) throws ClassNotFoundException, SQLException {
        ArrayList requerimentosPopulados = new ArrayList<>();
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);
        for (int i = 1; i <= parametros.length; i++) {
            comando.setObject(i, parametros[i - 1]);
        }
        ResultSet resultado = comando.executeQuery();
        FabricaConexao.fecharConexao(con);

        /*Preenchendo os objetos de requerimentos após a consulta e inserido no array*/
        while (resultado.next()) {
            RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
            requerimentoPopuladoString.setRequerimentoID(resultado.getInt("req_id"));
            requerimentoPopuladoString.setAlunoMatricula(resultado.getString("alu_id_FK"));
            requerimentoPopuladoString.setObservacoes(resultado.getString("req_observacoes"));
            requerimentoPopuladoString.setDisciplinaCursada(resultado.getString("req_disciplina_cursada"));

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            ResultSet consultaDisciplina = executarConsulta(EnuConsultasDisciplinas.SELECT_NOME_DISCIPLINA.toString(), resultado.getInt("req_disciplina_curso_atual_FK"));
            if (consultaDisciplina.next()) {
                requerimentoPopuladoString.setDisciplinaCursoAtual(consultaDisciplina.getString("disciplina"));
            }

            ResultSet consultaDocumentosApresentados = executarConsulta(EnuConsultasRequerimento.SELECT_DOCUMENTOS_APRESENTADOS_DO_REQUERIMENTO.toString(), requerimentoPopuladoString.getRequerimentoID());
            while (consultaDocumentosApresentados.next()) {
                requerimentoPopuladoString.getDocumentosApresentados().add(consultaDocumentosApresentados.getString("documento"));
            }

            //Adicionados objeto ao array de requerimentos já populado
            requerimentosPopulados.add(requerimentoPopuladoString);

        }

        return requerimentosPopulados;
    }

    //Popula reabertura matricula
    public ArrayList<RequerimentoPopuladoString> populaReaberturaMatricula(String sql, Object... parametros) throws ClassNotFoundException, SQLException {
        ArrayList requerimentosPopulados = new ArrayList<>();
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);
        for (int i = 1; i <= parametros.length; i++) {
            comando.setObject(i, parametros[i - 1]);
        }
        ResultSet resultado = comando.executeQuery();
        FabricaConexao.fecharConexao(con);

        /*Preenchendo os objetos de requerimentos após a consulta e inserido no array*/
        while (resultado.next()) {
            RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
            requerimentoPopuladoString.setRequerimentoID(resultado.getInt("req_id"));
            requerimentoPopuladoString.setAlunoMatricula(resultado.getString("alu_id_FK"));
            requerimentoPopuladoString.setObservacoes(resultado.getString("req_observacoes"));
            requerimentoPopuladoString.setDisciplinaCursada(resultado.getString("req_disciplina_cursada"));

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            ResultSet consultaDisciplina = executarConsulta(EnuConsultasDisciplinas.SELECT_NOME_DISCIPLINA.toString(), resultado.getInt("req_disciplina_curso_atual_FK"));
            if (consultaDisciplina.next()) {
                requerimentoPopuladoString.setDisciplinaCursoAtual(consultaDisciplina.getString("disciplina"));
            }

            ResultSet consultaDocumentosApresentados = executarConsulta(EnuConsultasRequerimento.SELECT_DOCUMENTOS_APRESENTADOS_DO_REQUERIMENTO.toString(), requerimentoPopuladoString.getRequerimentoID());
            while (consultaDocumentosApresentados.next()) {
                requerimentoPopuladoString.getDocumentosApresentados().add(consultaDocumentosApresentados.getString("documento"));
            }

            //Adicionados objeto ao array de requerimentos já populado
            requerimentosPopulados.add(requerimentoPopuladoString);

        }

        return requerimentosPopulados;
    }

    //Popula outros
    public ArrayList<RequerimentoPopuladoString> populaOutros(String sql, Object... parametros) throws ClassNotFoundException, SQLException {
        ArrayList requerimentosPopulados = new ArrayList<>();
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);
        for (int i = 1; i <= parametros.length; i++) {
            comando.setObject(i, parametros[i - 1]);
        }
        ResultSet resultado = comando.executeQuery();
        FabricaConexao.fecharConexao(con);

        /*Preenchendo os objetos de requerimentos após a consulta e inserido no array*/
        while (resultado.next()) {
            RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
            requerimentoPopuladoString.setRequerimentoID(resultado.getInt("req_id"));
            requerimentoPopuladoString.setAlunoMatricula(resultado.getString("alu_id_FK"));
            requerimentoPopuladoString.setObservacoes(resultado.getString("req_observacoes"));
            requerimentoPopuladoString.setDisciplinaCursada(resultado.getString("req_disciplina_cursada"));

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            ResultSet consultaDisciplina = executarConsulta(EnuConsultasDisciplinas.SELECT_NOME_DISCIPLINA.toString(), resultado.getInt("req_disciplina_curso_atual_FK"));
            if (consultaDisciplina.next()) {
                requerimentoPopuladoString.setDisciplinaCursoAtual(consultaDisciplina.getString("disciplina"));
            }

            ResultSet consultaDocumentosApresentados = executarConsulta(EnuConsultasRequerimento.SELECT_DOCUMENTOS_APRESENTADOS_DO_REQUERIMENTO.toString(), requerimentoPopuladoString.getRequerimentoID());
            while (consultaDocumentosApresentados.next()) {
                requerimentoPopuladoString.getDocumentosApresentados().add(consultaDocumentosApresentados.getString("documento"));
            }

            //Adicionados objeto ao array de requerimentos já populado
            requerimentosPopulados.add(requerimentoPopuladoString);

        }

        return requerimentosPopulados;
    }

    //Popula justificativa de faltas
    public ArrayList<RequerimentoPopuladoString> populaJustificativaDeFaltas(String sql, Object... parametros) throws ClassNotFoundException, SQLException {
        ArrayList requerimentosPopulados = new ArrayList<>();
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);
        for (int i = 1; i <= parametros.length; i++) {
            comando.setObject(i, parametros[i - 1]);
        }
        ResultSet resultado = comando.executeQuery();
        FabricaConexao.fecharConexao(con);

        /*Preenchendo os objetos de requerimentos após a consulta e inserido no array*/
        while (resultado.next()) {
            RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
            requerimentoPopuladoString.setRequerimentoID(resultado.getInt("req_id"));
            requerimentoPopuladoString.setAlunoMatricula(resultado.getString("alu_id_FK"));
            requerimentoPopuladoString.setObservacoes(resultado.getString("req_observacoes"));
            requerimentoPopuladoString.setDisciplinaCursada(resultado.getString("req_disciplina_cursada"));

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            ResultSet consultaDisciplina = executarConsulta(EnuConsultasDisciplinas.SELECT_NOME_DISCIPLINA.toString(), resultado.getInt("req_disciplina_curso_atual_FK"));
            if (consultaDisciplina.next()) {
                requerimentoPopuladoString.setDisciplinaCursoAtual(consultaDisciplina.getString("disciplina"));
            }

            ResultSet consultaDocumentosApresentados = executarConsulta(EnuConsultasRequerimento.SELECT_DOCUMENTOS_APRESENTADOS_DO_REQUERIMENTO.toString(), requerimentoPopuladoString.getRequerimentoID());
            while (consultaDocumentosApresentados.next()) {
                requerimentoPopuladoString.getDocumentosApresentados().add(consultaDocumentosApresentados.getString("documento"));
            }

            //Adicionados objeto ao array de requerimentos já populado
            requerimentosPopulados.add(requerimentoPopuladoString);

        }

        return requerimentosPopulados;
    }

    //Popula trancamento de matricula
    public ArrayList<RequerimentoPopuladoString> populaTrancamentoDeMatricula(String sql, Object... parametros) throws ClassNotFoundException, SQLException {
        ArrayList requerimentosPopulados = new ArrayList<>();
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);
        for (int i = 1; i <= parametros.length; i++) {
            comando.setObject(i, parametros[i - 1]);
        }
        ResultSet resultado = comando.executeQuery();
        FabricaConexao.fecharConexao(con);

        /*Preenchendo os objetos de requerimentos após a consulta e inserido no array*/
        while (resultado.next()) {
            RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
            requerimentoPopuladoString.setRequerimentoID(resultado.getInt("req_id"));
            requerimentoPopuladoString.setAlunoMatricula(resultado.getString("alu_id_FK"));
            requerimentoPopuladoString.setObservacoes(resultado.getString("req_observacoes"));
            requerimentoPopuladoString.setDisciplinaCursada(resultado.getString("req_disciplina_cursada"));

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            ResultSet consultaDisciplina = executarConsulta(EnuConsultasDisciplinas.SELECT_NOME_DISCIPLINA.toString(), resultado.getInt("req_disciplina_curso_atual_FK"));
            if (consultaDisciplina.next()) {
                requerimentoPopuladoString.setDisciplinaCursoAtual(consultaDisciplina.getString("disciplina"));
            }

            ResultSet consultaDocumentosApresentados = executarConsulta(EnuConsultasRequerimento.SELECT_DOCUMENTOS_APRESENTADOS_DO_REQUERIMENTO.toString(), requerimentoPopuladoString.getRequerimentoID());
            while (consultaDocumentosApresentados.next()) {
                requerimentoPopuladoString.getDocumentosApresentados().add(consultaDocumentosApresentados.getString("documento"));
            }

            //Adicionados objeto ao array de requerimentos já populado
            requerimentosPopulados.add(requerimentoPopuladoString);

        }

        return requerimentosPopulados;
    }

    //Popula trancamento de matricula compusorio
    public ArrayList<RequerimentoPopuladoString> populaTrancamentoDeMatriculaCompusorio(String sql, Object... parametros) throws ClassNotFoundException, SQLException {
        ArrayList requerimentosPopulados = new ArrayList<>();
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);
        for (int i = 1; i <= parametros.length; i++) {
            comando.setObject(i, parametros[i - 1]);
        }
        ResultSet resultado = comando.executeQuery();
        FabricaConexao.fecharConexao(con);

        /*Preenchendo os objetos de requerimentos após a consulta e inserido no array*/
        while (resultado.next()) {
            RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
            requerimentoPopuladoString.setRequerimentoID(resultado.getInt("req_id"));
            requerimentoPopuladoString.setAlunoMatricula(resultado.getString("alu_id_FK"));
            requerimentoPopuladoString.setObservacoes(resultado.getString("req_observacoes"));
            requerimentoPopuladoString.setDisciplinaCursada(resultado.getString("req_disciplina_cursada"));

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            ResultSet consultaDisciplina = executarConsulta(EnuConsultasDisciplinas.SELECT_NOME_DISCIPLINA.toString(), resultado.getInt("req_disciplina_curso_atual_FK"));
            if (consultaDisciplina.next()) {
                requerimentoPopuladoString.setDisciplinaCursoAtual(consultaDisciplina.getString("disciplina"));
            }

            ResultSet consultaDocumentosApresentados = executarConsulta(EnuConsultasRequerimento.SELECT_DOCUMENTOS_APRESENTADOS_DO_REQUERIMENTO.toString(), requerimentoPopuladoString.getRequerimentoID());
            while (consultaDocumentosApresentados.next()) {
                requerimentoPopuladoString.getDocumentosApresentados().add(consultaDocumentosApresentados.getString("documento"));
            }

            //Adicionados objeto ao array de requerimentos já populado
            requerimentosPopulados.add(requerimentoPopuladoString);

        }

        return requerimentosPopulados;
    }

    //Popula cancelamento de matricula
    public ArrayList<RequerimentoPopuladoString> populaCancelamentoDeMatricula(String sql, Object... parametros) throws ClassNotFoundException, SQLException {
        ArrayList requerimentosPopulados = new ArrayList<>();
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);
        for (int i = 1; i <= parametros.length; i++) {
            comando.setObject(i, parametros[i - 1]);
        }
        ResultSet resultado = comando.executeQuery();
        FabricaConexao.fecharConexao(con);

        /*Preenchendo os objetos de requerimentos após a consulta e inserido no array*/
        while (resultado.next()) {
            RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
            requerimentoPopuladoString.setRequerimentoID(resultado.getInt("req_id"));
            requerimentoPopuladoString.setAlunoMatricula(resultado.getString("alu_id_FK"));
            requerimentoPopuladoString.setObservacoes(resultado.getString("req_observacoes"));
            requerimentoPopuladoString.setDisciplinaCursada(resultado.getString("req_disciplina_cursada"));

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            ResultSet consultaDisciplina = executarConsulta(EnuConsultasDisciplinas.SELECT_NOME_DISCIPLINA.toString(), resultado.getInt("req_disciplina_curso_atual_FK"));
            if (consultaDisciplina.next()) {
                requerimentoPopuladoString.setDisciplinaCursoAtual(consultaDisciplina.getString("disciplina"));
            }

            ResultSet consultaDocumentosApresentados = executarConsulta(EnuConsultasRequerimento.SELECT_DOCUMENTOS_APRESENTADOS_DO_REQUERIMENTO.toString(), requerimentoPopuladoString.getRequerimentoID());
            while (consultaDocumentosApresentados.next()) {
                requerimentoPopuladoString.getDocumentosApresentados().add(consultaDocumentosApresentados.getString("documento"));
            }

            //Adicionados objeto ao array de requerimentos já populado
            requerimentosPopulados.add(requerimentoPopuladoString);

        }

        return requerimentosPopulados;
    }

    //Popula atendimento docmicilar
    public ArrayList<RequerimentoPopuladoString> populaAtendimentoDomiciliar(String sql, Object... parametros) throws ClassNotFoundException, SQLException {
        ArrayList requerimentosPopulados = new ArrayList<>();
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);
        for (int i = 1; i <= parametros.length; i++) {
            comando.setObject(i, parametros[i - 1]);
        }
        ResultSet resultado = comando.executeQuery();
        FabricaConexao.fecharConexao(con);

        /*Preenchendo os objetos de requerimentos após a consulta e inserido no array*/
        while (resultado.next()) {
            RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
            requerimentoPopuladoString.setRequerimentoID(resultado.getInt("req_id"));
            requerimentoPopuladoString.setAlunoMatricula(resultado.getString("alu_id_FK"));
            requerimentoPopuladoString.setObservacoes(resultado.getString("req_observacoes"));
            requerimentoPopuladoString.setDisciplinaCursada(resultado.getString("req_disciplina_cursada"));

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            ResultSet consultaDisciplina = executarConsulta(EnuConsultasDisciplinas.SELECT_NOME_DISCIPLINA.toString(), resultado.getInt("req_disciplina_curso_atual_FK"));
            if (consultaDisciplina.next()) {
                requerimentoPopuladoString.setDisciplinaCursoAtual(consultaDisciplina.getString("disciplina"));
            }

            ResultSet consultaDocumentosApresentados = executarConsulta(EnuConsultasRequerimento.SELECT_DOCUMENTOS_APRESENTADOS_DO_REQUERIMENTO.toString(), requerimentoPopuladoString.getRequerimentoID());
            while (consultaDocumentosApresentados.next()) {
                requerimentoPopuladoString.getDocumentosApresentados().add(consultaDocumentosApresentados.getString("documento"));
            }

            //Adicionados objeto ao array de requerimentos já populado
            requerimentosPopulados.add(requerimentoPopuladoString);

        }

        return requerimentosPopulados;
    }

    //Popula dispensa de atividades
    public ArrayList<RequerimentoPopuladoString> populaDispensaDeAtividades(String sql, Object... parametros) throws ClassNotFoundException, SQLException {
        ArrayList requerimentosPopulados = new ArrayList<>();
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);
        for (int i = 1; i <= parametros.length; i++) {
            comando.setObject(i, parametros[i - 1]);
        }
        ResultSet resultado = comando.executeQuery();
        FabricaConexao.fecharConexao(con);

        /*Preenchendo os objetos de requerimentos após a consulta e inserido no array*/
        while (resultado.next()) {
            RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
            requerimentoPopuladoString.setRequerimentoID(resultado.getInt("req_id"));
            requerimentoPopuladoString.setAlunoMatricula(resultado.getString("alu_id_FK"));
            requerimentoPopuladoString.setObservacoes(resultado.getString("req_observacoes"));
            requerimentoPopuladoString.setDisciplinaCursada(resultado.getString("req_disciplina_cursada"));

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            ResultSet consultaDisciplina = executarConsulta(EnuConsultasDisciplinas.SELECT_NOME_DISCIPLINA.toString(), resultado.getInt("req_disciplina_curso_atual_FK"));
            if (consultaDisciplina.next()) {
                requerimentoPopuladoString.setDisciplinaCursoAtual(consultaDisciplina.getString("disciplina"));
            }

            ResultSet consultaDocumentosApresentados = executarConsulta(EnuConsultasRequerimento.SELECT_DOCUMENTOS_APRESENTADOS_DO_REQUERIMENTO.toString(), requerimentoPopuladoString.getRequerimentoID());
            while (consultaDocumentosApresentados.next()) {
                requerimentoPopuladoString.getDocumentosApresentados().add(consultaDocumentosApresentados.getString("documento"));
            }

            //Adicionados objeto ao array de requerimentos já populado
            requerimentosPopulados.add(requerimentoPopuladoString);

        }

        return requerimentosPopulados;
    }
    //Popula adequação de horários

    public ArrayList<RequerimentoPopuladoString> populaAdequacaoHorarios(String sql, Object... parametros) throws ClassNotFoundException, SQLException {
        ArrayList requerimentosPopulados = new ArrayList<>();
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);
        for (int i = 1; i <= parametros.length; i++) {
            comando.setObject(i, parametros[i - 1]);
        }
        ResultSet resultado = comando.executeQuery();
        FabricaConexao.fecharConexao(con);

        /*Preenchendo os objetos de requerimentos após a consulta e inserido no array*/
        while (resultado.next()) {
            RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
            requerimentoPopuladoString.setRequerimentoID(resultado.getInt("req_id"));
            requerimentoPopuladoString.setAlunoMatricula(resultado.getString("alu_id_FK"));
            requerimentoPopuladoString.setObservacoes(resultado.getString("req_observacoes"));
            requerimentoPopuladoString.setDisciplinaCursada(resultado.getString("req_disciplina_cursada"));

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            ResultSet consultaDisciplina = executarConsulta(EnuConsultasDisciplinas.SELECT_NOME_DISCIPLINA.toString(), resultado.getInt("req_disciplina_curso_atual_FK"));
            if (consultaDisciplina.next()) {
                requerimentoPopuladoString.setDisciplinaCursoAtual(consultaDisciplina.getString("disciplina"));
            }

            ResultSet consultaDocumentosApresentados = executarConsulta(EnuConsultasRequerimento.SELECT_DOCUMENTOS_APRESENTADOS_DO_REQUERIMENTO.toString(), requerimentoPopuladoString.getRequerimentoID());
            while (consultaDocumentosApresentados.next()) {
                requerimentoPopuladoString.getDocumentosApresentados().add(consultaDocumentosApresentados.getString("documento"));
            }

            //Adicionados objeto ao array de requerimentos já populado
            requerimentosPopulados.add(requerimentoPopuladoString);

        }

        return requerimentosPopulados;
    }

    //Popula estudo individualizado
    public ArrayList<RequerimentoPopuladoString> populaEstudoIndividualizado(String sql, Object... parametros) throws ClassNotFoundException, SQLException {
        ArrayList requerimentosPopulados = new ArrayList<>();
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);
        for (int i = 1; i <= parametros.length; i++) {
            comando.setObject(i, parametros[i - 1]);
        }
        ResultSet resultado = comando.executeQuery();
        FabricaConexao.fecharConexao(con);

        /*Preenchendo os objetos de requerimentos após a consulta e inserido no array*/
        while (resultado.next()) {
            RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
            requerimentoPopuladoString.setRequerimentoID(resultado.getInt("req_id"));
            requerimentoPopuladoString.setAlunoMatricula(resultado.getString("alu_id_FK"));
            requerimentoPopuladoString.setObservacoes(resultado.getString("req_observacoes"));
            requerimentoPopuladoString.setDisciplinaCursada(resultado.getString("req_disciplina_cursada"));

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            ResultSet consultaDisciplina = executarConsulta(EnuConsultasDisciplinas.SELECT_NOME_DISCIPLINA.toString(), resultado.getInt("req_disciplina_curso_atual_FK"));
            if (consultaDisciplina.next()) {
                requerimentoPopuladoString.setDisciplinaCursoAtual(consultaDisciplina.getString("disciplina"));
            }

            ResultSet consultaDocumentosApresentados = executarConsulta(EnuConsultasRequerimento.SELECT_DOCUMENTOS_APRESENTADOS_DO_REQUERIMENTO.toString(), requerimentoPopuladoString.getRequerimentoID());
            while (consultaDocumentosApresentados.next()) {
                requerimentoPopuladoString.getDocumentosApresentados().add(consultaDocumentosApresentados.getString("documento"));
            }

            //Adicionados objeto ao array de requerimentos já populado
            requerimentosPopulados.add(requerimentoPopuladoString);

        }

        return requerimentosPopulados;
    }

    //Popula inclusão de disciplinas
    public ArrayList<RequerimentoPopuladoString> populaInclusaoDisciplinas(String sql, Object... parametros) throws ClassNotFoundException, SQLException {
        ArrayList requerimentosPopulados = new ArrayList<>();
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);
        for (int i = 1; i <= parametros.length; i++) {
            comando.setObject(i, parametros[i - 1]);
        }
        ResultSet resultado = comando.executeQuery();
        FabricaConexao.fecharConexao(con);

        /*Preenchendo os objetos de requerimentos após a consulta e inserido no array*/
        while (resultado.next()) {
            RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
            requerimentoPopuladoString.setRequerimentoID(resultado.getInt("req_id"));
            requerimentoPopuladoString.setAlunoMatricula(resultado.getString("alu_id_FK"));
            requerimentoPopuladoString.setObservacoes(resultado.getString("req_observacoes"));
            requerimentoPopuladoString.setDisciplinaCursada(resultado.getString("req_disciplina_cursada"));

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            ResultSet consultaDisciplina = executarConsulta(EnuConsultasDisciplinas.SELECT_NOME_DISCIPLINA.toString(), resultado.getInt("req_disciplina_curso_atual_FK"));
            if (consultaDisciplina.next()) {
                requerimentoPopuladoString.setDisciplinaCursoAtual(consultaDisciplina.getString("disciplina"));
            }

            ResultSet consultaDocumentosApresentados = executarConsulta(EnuConsultasRequerimento.SELECT_DOCUMENTOS_APRESENTADOS_DO_REQUERIMENTO.toString(), requerimentoPopuladoString.getRequerimentoID());
            while (consultaDocumentosApresentados.next()) {
                requerimentoPopuladoString.getDocumentosApresentados().add(consultaDocumentosApresentados.getString("documento"));
            }

            //Adicionados objeto ao array de requerimentos já populado
            requerimentosPopulados.add(requerimentoPopuladoString);

        }

        return requerimentosPopulados;
    }

    //Popula remoção de disciplinas
    public ArrayList<RequerimentoPopuladoString> populaRemocaoDisciplinas(String sql, Object... parametros) throws ClassNotFoundException, SQLException {
        ArrayList requerimentosPopulados = new ArrayList<>();
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);
        for (int i = 1; i <= parametros.length; i++) {
            comando.setObject(i, parametros[i - 1]);
        }
        ResultSet resultado = comando.executeQuery();
        FabricaConexao.fecharConexao(con);

        /*Preenchendo os objetos de requerimentos após a consulta e inserido no array*/
        while (resultado.next()) {
            RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
            requerimentoPopuladoString.setRequerimentoID(resultado.getInt("req_id"));
            requerimentoPopuladoString.setAlunoMatricula(resultado.getString("alu_id_FK"));
            requerimentoPopuladoString.setObservacoes(resultado.getString("req_observacoes"));
            requerimentoPopuladoString.setDisciplinaCursada(resultado.getString("req_disciplina_cursada"));

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            ResultSet consultaDisciplina = executarConsulta(EnuConsultasDisciplinas.SELECT_NOME_DISCIPLINA.toString(), resultado.getInt("req_disciplina_curso_atual_FK"));
            if (consultaDisciplina.next()) {
                requerimentoPopuladoString.setDisciplinaCursoAtual(consultaDisciplina.getString("disciplina"));
            }

            ResultSet consultaDocumentosApresentados = executarConsulta(EnuConsultasRequerimento.SELECT_DOCUMENTOS_APRESENTADOS_DO_REQUERIMENTO.toString(), requerimentoPopuladoString.getRequerimentoID());
            while (consultaDocumentosApresentados.next()) {
                requerimentoPopuladoString.getDocumentosApresentados().add(consultaDocumentosApresentados.getString("documento"));
            }

            //Adicionados objeto ao array de requerimentos já populado
            requerimentosPopulados.add(requerimentoPopuladoString);

        }

        return requerimentosPopulados;
    }

    public int toInt(String num) {
        return Integer.parseInt(num);
    }
    // Daqui para baixo vão os insertes de requeriment

}
