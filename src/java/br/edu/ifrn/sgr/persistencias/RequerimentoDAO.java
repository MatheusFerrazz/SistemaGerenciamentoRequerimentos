/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.sgr.persistencias;


import br.edu.ifrn.sgr.modelos.RequerimentoPopuladoString;
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

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            ResultSet consultaDisciplina = executarConsulta(EnuConsultasDisciplinas.SELECT_NOME_DISCIPLINA.toString(), resultado.getInt("req_disciplina_curso_atual_FK"));
            if (consultaDisciplina.next()) {
                requerimentoPopuladoString.setDisciplinaCertificacao(consultaDisciplina.getString("disciplina"));
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
            requerimentoPopuladoString.setTipoAtividade(resultado.getString("req_tipo_atividade"));

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            ResultSet consultaProfessor = executarConsulta(EnuConsultasProfessor.SELECT_NOME_PROFESSOR.toString(), resultado.getString("req_professor_atividade_FK"));
            if (consultaProfessor.next()) {
                requerimentoPopuladoString.setProfessorAtividade(consultaProfessor.getString("nome"));
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
            

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            ResultSet consultaCurso = executarConsulta(EnuConsultasCurso.SELECT_CURSO_NOME_E_CAMPUS_NOME.toString(), resultado.getInt("req_curso_destino_FK"));
            if (consultaCurso.next()) {                
                requerimentoPopuladoString.setCursoDestino(consultaCurso.getString("curso")+" - Campus "+consultaCurso.getString("campus"));
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
            requerimentoPopuladoString.setTurmaDestino(resultado.getString("req_turma_destino_FK")+"");

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

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
            

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            ResultSet consultaTurno = executarConsulta(EnuConsultasTurno.SELECT_NOME_TURNO.toString(), resultado.getInt("req_turno_destino_FK"));
            if (consultaTurno.next()) {
                requerimentoPopuladoString.setTurnoDestino(consultaTurno.getString("turno"));
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
            requerimentoPopuladoString.setTranferenciaCursoOrigem(resultado.getString("req_tranferencia_curso_origem"));
            requerimentoPopuladoString.setTranferenciaCursoDestino(resultado.getString("req_tranferencia_curso_destino"));
            requerimentoPopuladoString.setTranferenciaEscolaOrigem(resultado.getString("req_tranferencia_escola_origem"));
            requerimentoPopuladoString.setTranferenciaEscolaDestino(resultado.getString("req_tranferencia_escola_destino"));

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

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

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

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

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

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
            
            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            
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

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

            ResultSet consultaDocumentosApresentados = executarConsulta(EnuConsultasRequerimento.SELECT_DOCUMENTOS_APRESENTADOS_DO_REQUERIMENTO.toString(), requerimentoPopuladoString.getRequerimentoID());
            while (consultaDocumentosApresentados.next()) {
                requerimentoPopuladoString.getDocumentosApresentados().add(consultaDocumentosApresentados.getString("documento"));
            }

            //Adicionados objeto ao array de requerimentos já populado
            requerimentosPopulados.add(requerimentoPopuladoString);

        }

        return requerimentosPopulados;
    }

    //Popula justificativa de faltas em anexo
    public ArrayList<RequerimentoPopuladoString> populaJustificativaDeFaltasEmAnexo(String sql, Object... parametros) throws ClassNotFoundException, SQLException {
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

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));


            ResultSet consultaDocumentosApresentados = executarConsulta(EnuConsultasRequerimento.SELECT_DOCUMENTOS_APRESENTADOS_DO_REQUERIMENTO.toString(), requerimentoPopuladoString.getRequerimentoID());
            while (consultaDocumentosApresentados.next()) {
                requerimentoPopuladoString.getDocumentosApresentados().add(consultaDocumentosApresentados.getString("documento"));
            }

            //Adicionados objeto ao array de requerimentos já populado
            requerimentosPopulados.add(requerimentoPopuladoString);

        }

        return requerimentosPopulados;
    }
    
    
    
    //Popula justificativa de faltas dia específico
    public ArrayList<RequerimentoPopuladoString> populaJustificativaDeFaltaDiaEspecifico(String sql, Object... parametros) throws ClassNotFoundException, SQLException {
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

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            Date faltaDiaEspecifico = resultado.getDate("req_data_falta_dia");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));
            requerimentoPopuladoString.setDataFaltasDia(formatDataBrasil.format(faltaDiaEspecifico));



            ResultSet consultaDocumentosApresentados = executarConsulta(EnuConsultasRequerimento.SELECT_DOCUMENTOS_APRESENTADOS_DO_REQUERIMENTO.toString(), requerimentoPopuladoString.getRequerimentoID());
            while (consultaDocumentosApresentados.next()) {
                requerimentoPopuladoString.getDocumentosApresentados().add(consultaDocumentosApresentados.getString("documento"));
            }

            //Adicionados objeto ao array de requerimentos já populado
            requerimentosPopulados.add(requerimentoPopuladoString);

        }

        return requerimentosPopulados;
    }

    //Popula justificativa de faltas por período
    public ArrayList<RequerimentoPopuladoString> populaJustificativaDeFaltasPeriodo(String sql, Object... parametros) throws ClassNotFoundException, SQLException {
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
                       
            Date faltasDe = resultado.getDate("req_data_faltas_de");
            Date faltasAte = resultado.getDate("req_data_faltas_ate");            
            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");            
            requerimentoPopuladoString.setDataFaltasDe(formatDataBrasil.format(faltasDe));
            requerimentoPopuladoString.setDataFaltasAte(formatDataBrasil.format(faltasAte));                        
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

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

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

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

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

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

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

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

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));


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
            
            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));


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

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));


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

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

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

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));

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

            Date dataSolicitacao = resultado.getDate("req_data_solicitacao_requerimento");
            requerimentoPopuladoString.setDataSolicitacaoRequerimento(formatDataBrasil.format(dataSolicitacao));


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
