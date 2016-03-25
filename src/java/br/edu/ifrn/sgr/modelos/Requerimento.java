/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.sgr.modelos;

import java.sql.Date;

/**
 *
 * @author CH
 */
public class Requerimento {
    private String alunoID;    
    private String disciplinaCursada;
    private String observacoes;        
    private String encaminhamentos;   
    private String mudancaDe;
    private String mudancaPara;
    private String dataRealizacaoCertificacao;
    private String dataFaltasDe;
    private String dataFaltasAte;
    private String dataFaltasDia;
    private Date dataSolicitacaoRequerimento;
    private String dataAtividade;
    private int periodoTancamento;
    private String outros;
    private String justificativa;
    private String obersavacoesAnaliseAproveitamento;
    private String obervacoesDocumentosApresentados;
    private boolean resultado;
    private boolean diasDescritosAnexo;
    private String professorResponsavelAnaliseID;
    private String professorAtividadeID;
    private String tecnicoAdministrativoResponsavelID;
    private int disciplinaCursoAtualID;
    private int disciplinaCertificacaoID;
    private int tipoRequerimentoID;
    private String tipoAtividade;
    private int cursoOrigemID;
    private int cursoDestinoID;
    private int turmaOrigemID;
    private int turmaDestinoID;
    private int turnoOrigemID;
    private int turnoDestinoID;
    private String tranferenciaCursoOrigem;
    private String tranferenciaCursoDestino;
    private String tranferenciaEscolaOrigem;
    private String tranferenciaEscolaDestino;
    
    public Requerimento()
    {
        
    }

    /**
     * @return the alunoID
     */
    public String getAlunoID() {
        return alunoID;
    }

    /**
     * @param alunoID the alunoID to set
     */
    public void setAlunoID(String alunoID) {
        this.alunoID = alunoID;
    }

    /**
     * @return the disciplinaCursada
     */
    public String getDisciplinaCursada() {
        return disciplinaCursada;
    }

    /**
     * @param disciplinaCursada the disciplinaCursada to set
     */
    public void setDisciplinaCursada(String disciplinaCursada) {
        this.disciplinaCursada = disciplinaCursada;
    }

    /**
     * @return the observacoes
     */
    public String getObservacoes() {
        return observacoes;
    }

    /**
     * @param observacoes the observacoes to set
     */
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    /**
     * @return the encaminhamentos
     */
    public String getEncaminhamentos() {
        return encaminhamentos;
    }

    /**
     * @param encaminhamentos the encaminhamentos to set
     */
    public void setEncaminhamentos(String encaminhamentos) {
        this.encaminhamentos = encaminhamentos;
    }

    /**
     * @return the mudancaDe
     */
    public String getMudancaDe() {
        return mudancaDe;
    }

    /**
     * @param mudancaDe the mudancaDe to set
     */
    public void setMudancaDe(String mudancaDe) {
        this.mudancaDe = mudancaDe;
    }

    /**
     * @return the mudancaPara
     */
    public String getMudancaPara() {
        return mudancaPara;
    }

    /**
     * @param mudancaPara the mudancaPara to set
     */
    public void setMudancaPara(String mudancaPara) {
        this.mudancaPara = mudancaPara;
    }

    /**
     * @return the dataRealizacaoCertificacao
     */
    public String getDataRealizacaoCertificacao() {
        return dataRealizacaoCertificacao;
    }

    /**
     * @param dataRealizacaoCertificacao the dataRealizacaoCertificacao to set
     */
    public void setDataRealizacaoCertificacao(String dataRealizacaoCertificacao) {
        this.dataRealizacaoCertificacao = dataRealizacaoCertificacao;
    }

    /**
     * @return the dataFaltasDe
     */
    public String getDataFaltasDe() {
        return dataFaltasDe;
    }

    /**
     * @param dataFaltasDe the dataFaltasDe to set
     */
    public void setDataFaltasDe(String dataFaltasDe) {
        this.dataFaltasDe = dataFaltasDe;
    }

    /**
     * @return the dataFaltasAte
     */
    public String getDataFaltasAte() {
        return dataFaltasAte;
    }

    /**
     * @param dataFaltasAte the dataFaltasAte to set
     */
    public void setDataFaltasAte(String dataFaltasAte) {
        this.dataFaltasAte = dataFaltasAte;
    }

    /**
     * @return the dataFaltasDia
     */
    public String getDataFaltasDia() {
        return dataFaltasDia;
    }

    /**
     * @param dataFaltasDia the dataFaltasDia to set
     */
    public void setDataFaltasDia(String dataFaltasDia) {
        this.dataFaltasDia = dataFaltasDia;
    }

    /**
     * @return the dataSolicitacaoRequerimento
     */
    public Date getDataSolicitacaoRequerimento() {
        return dataSolicitacaoRequerimento;
    }

    /**
     * @param dataSolicitacaoRequerimento the dataSolicitacaoRequerimento to set
     */
    public void setDataSolicitacaoRequerimento(Date dataSolicitacaoRequerimento) {
        this.dataSolicitacaoRequerimento = dataSolicitacaoRequerimento;
    }

    /**
     * @return the dataAtividade
     */
    public String getDataAtividade() {
        return dataAtividade;
    }

    /**
     * @param dataAtividade the dataAtividade to set
     */
    public void setDataAtividade(String dataAtividade) {
        this.dataAtividade = dataAtividade;
    }

    /**
     * @return the periodoTancamento
     */
    public int getPeriodoTancamento() {
        return periodoTancamento;
    }

    /**
     * @param periodoTancamento the periodoTancamento to set
     */
    public void setPeriodoTancamento(int periodoTancamento) {
        this.periodoTancamento = periodoTancamento;
    }

    /**
     * @return the outros
     */
    public String getOutros() {
        return outros;
    }

    /**
     * @param outros the outros to set
     */
    public void setOutros(String outros) {
        this.outros = outros;
    }

    /**
     * @return the justificativa
     */
    public String getJustificativa() {
        return justificativa;
    }

    /**
     * @param justificativa the justificativa to set
     */
    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    /**
     * @return the obersavacoesAnaliseAproveitamento
     */
    public String getObersavacoesAnaliseAproveitamento() {
        return obersavacoesAnaliseAproveitamento;
    }

    /**
     * @param obersavacoesAnaliseAproveitamento the obersavacoesAnaliseAproveitamento to set
     */
    public void setObersavacoesAnaliseAproveitamento(String obersavacoesAnaliseAproveitamento) {
        this.obersavacoesAnaliseAproveitamento = obersavacoesAnaliseAproveitamento;
    }

    /**
     * @return the obervacoesDocumentosApresentados
     */
    public String getObervacoesDocumentosApresentados() {
        return obervacoesDocumentosApresentados;
    }

    /**
     * @param obervacoesDocumentosApresentados the obervacoesDocumentosApresentados to set
     */
    public void setObervacoesDocumentosApresentados(String obervacoesDocumentosApresentados) {
        this.obervacoesDocumentosApresentados = obervacoesDocumentosApresentados;
    }

    /**
     * @return the resultado
     */
    public boolean isResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }

    /**
     * @return the diasDescritosAnexo
     */
    public boolean isDiasDescritosAnexo() {
        return diasDescritosAnexo;
    }

    /**
     * @param diasDescritosAnexo the diasDescritosAnexo to set
     */
    public void setDiasDescritosAnexo(boolean diasDescritosAnexo) {
        this.diasDescritosAnexo = diasDescritosAnexo;
    }

    /**
     * @return the professorResponsavelAnaliseID
     */
    public String getProfessorResponsavelAnaliseID() {
        return professorResponsavelAnaliseID;
    }

    /**
     * @param professorResponsavelAnaliseID the professorResponsavelAnaliseID to set
     */
    public void setProfessorResponsavelAnaliseID(String professorResponsavelAnaliseID) {
        this.professorResponsavelAnaliseID = professorResponsavelAnaliseID;
    }

    /**
     * @return the professorAtividadeID
     */
    public String getProfessorAtividadeID() {
        return professorAtividadeID;
    }

    /**
     * @param professorAtividadeID the professorAtividadeID to set
     */
    public void setProfessorAtividadeID(String professorAtividadeID) {
        this.professorAtividadeID = professorAtividadeID;
    }

    /**
     * @return the tecnicoAdministrativoResponsavelID
     */
    public String getTecnicoAdministrativoResponsavelID() {
        return tecnicoAdministrativoResponsavelID;
    }

    /**
     * @param tecnicoAdministrativoResponsavelID the tecnicoAdministrativoResponsavelID to set
     */
    public void setTecnicoAdministrativoResponsavelID(String tecnicoAdministrativoResponsavelID) {
        this.tecnicoAdministrativoResponsavelID = tecnicoAdministrativoResponsavelID;
    }

    /**
     * @return the disciplinaCursoAtualID
     */
    public int getDisciplinaCursoAtualID() {
        return disciplinaCursoAtualID;
    }

    /**
     * @param disciplinaCursoAtualID the disciplinaCursoAtualID to set
     */
    public void setDisciplinaCursoAtualID(int disciplinaCursoAtualID) {
        this.disciplinaCursoAtualID = disciplinaCursoAtualID;
    }

    /**
     * @return the tipoRequerimentoID
     */
    public int getTipoRequerimentoID() {
        return tipoRequerimentoID;
    }

    /**
     * @param tipoRequerimentoID the tipoRequerimentoID to set
     */
    public void setTipoRequerimentoID(int tipoRequerimentoID) {
        this.tipoRequerimentoID = tipoRequerimentoID;
    }

    /**
     * @return the tipoAtividade
     */
    public String getTipoAtividade() {
        return tipoAtividade;
    }

    /**
     * @param tipoAtividade the tipoAtividade to set
     */
    public void setTipoAtividade(String tipoAtividade) {
        this.tipoAtividade = tipoAtividade;
    }

    /**
     * @return the cursoOrigemID
     */
    public int getCursoOrigemID() {
        return cursoOrigemID;
    }

    /**
     * @param cursoOrigemID the cursoOrigemID to set
     */
    public void setCursoOrigemID(int cursoOrigemID) {
        this.cursoOrigemID = cursoOrigemID;
    }

    /**
     * @return the cursoDestinoID
     */
    public int getCursoDestinoID() {
        return cursoDestinoID;
    }

    /**
     * @param cursoDestinoID the cursoDestinoID to set
     */
    public void setCursoDestinoID(int cursoDestinoID) {
        this.cursoDestinoID = cursoDestinoID;
    }

    /**
     * @return the turmaOrigemID
     */
    public int getTurmaOrigemID() {
        return turmaOrigemID;
    }

    /**
     * @param turmaOrigemID the turmaOrigemID to set
     */
    public void setTurmaOrigemID(int turmaOrigemID) {
        this.turmaOrigemID = turmaOrigemID;
    }

    /**
     * @return the turmaDestinoID
     */
    public int getTurmaDestinoID() {
        return turmaDestinoID;
    }

    /**
     * @param turmaDestinoID the turmaDestinoID to set
     */
    public void setTurmaDestinoID(int turmaDestinoID) {
        this.turmaDestinoID = turmaDestinoID;
    }

    /**
     * @return the turnoOrigemID
     */
    public int getTurnoOrigemID() {
        return turnoOrigemID;
    }

    /**
     * @param turnoOrigemID the turnoOrigemID to set
     */
    public void setTurnoOrigemID(int turnoOrigemID) {
        this.turnoOrigemID = turnoOrigemID;
    }

    /**
     * @return the turnoDestinoID
     */
    public int getTurnoDestinoID() {
        return turnoDestinoID;
    }

    /**
     * @param turnoDestinoID the turnoDestinoID to set
     */
    public void setTurnoDestinoID(int turnoDestinoID) {
        this.turnoDestinoID = turnoDestinoID;
    }

    /**
     * @return the tranferenciaCursoOrigem
     */
    public String getTranferenciaCursoOrigem() {
        return tranferenciaCursoOrigem;
    }

    /**
     * @param tranferenciaCursoOrigem the tranferenciaCursoOrigem to set
     */
    public void setTranferenciaCursoOrigem(String tranferenciaCursoOrigem) {
        this.tranferenciaCursoOrigem = tranferenciaCursoOrigem;
    }

    /**
     * @return the tranferenciaCursoDestino
     */
    public String getTranferenciaCursoDestino() {
        return tranferenciaCursoDestino;
    }

    /**
     * @param tranferenciaCursoDestino the tranferenciaCursoDestino to set
     */
    public void setTranferenciaCursoDestino(String tranferenciaCursoDestino) {
        this.tranferenciaCursoDestino = tranferenciaCursoDestino;
    }

    /**
     * @return the tranferenciaEscolaOrigem
     */
    public String getTranferenciaEscolaOrigem() {
        return tranferenciaEscolaOrigem;
    }

    /**
     * @param tranferenciaEscolaOrigem the tranferenciaEscolaOrigem to set
     */
    public void setTranferenciaEscolaOrigem(String tranferenciaEscolaOrigem) {
        this.tranferenciaEscolaOrigem = tranferenciaEscolaOrigem;
    }

    /**
     * @return the tranferenciaEscolaDestino
     */
    public String getTranferenciaEscolaDestino() {
        return tranferenciaEscolaDestino;
    }

    /**
     * @param tranferenciaEscolaDestino the tranferenciaEscolaDestino to set
     */
    public void setTranferenciaEscolaDestino(String tranferenciaEscolaDestino) {
        this.tranferenciaEscolaDestino = tranferenciaEscolaDestino;
    }

    /**
     * @return the disciplinaCertificacaoID
     */
    public int getDisciplinaCertificacaoID() {
        return disciplinaCertificacaoID;
    }

    /**
     * @param disciplinaCertificacaoID the disciplinaCertificacaoID to set
     */
    public void setDisciplinaCertificacaoID(int disciplinaCertificacaoID) {
        this.disciplinaCertificacaoID = disciplinaCertificacaoID;
    }


    
    
    

}