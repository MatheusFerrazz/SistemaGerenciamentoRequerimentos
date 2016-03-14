/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.sgr.modelos;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Luan Medeiros
 */
public class RequerimentoPopuladoString {
    private String alunoNome = "";    
    private String disciplinaCursada;
    private String observacoes = "";        
    private String encaminhamentos = "";   
    private String mudancaDe = "";
    private String mudancaPara = "";
    private String dataRealizacaoCertificacao;
    private String dataFaltasDe;
    private String dataFaltasAte;
    private String dataFaltasDia;
    private String dataSolicitacaoRequerimento;
    private String dataAtividade;
    private int periodoTancamento;
    private ArrayList<String> documentosApresentados = new ArrayList<>();
    private String outros = "";
    private String justificativa = "";
    private String obersavacoesAnaliseAproveitamento = "";
    private String obervacoesDocumentosApresentados = "";
    private String resultado = "EM ANDAMENTO";
    private String diasDescritosAnexo;
    private String professorResponsavelAnalise;
    private String professorAtividade;
    private String tecnicoAdministrativoResponsavel;
    private String disciplinaCursoAtual;
    private int tipoRquerimento;
    private int idRquerimento;
    private String tipoAtividade;
    private String cursoOrigem;
    private String cursoDestino;
    private String turmaOrigem;
    private String turmaDestino;
    private String turnoOrigem;
    private String turnoDestino;
    private String tranferenciaCursoOrigem;
    private String tranferenciaCursoDestino;
    private String tranferenciaEscolaOrigem;
    private String tranferenciaEscolaDestino;
    private String disciplinaCertificacao;
    

    public RequerimentoPopuladoString()
    {
        
    }

    /**
     * @return the alunoNome
     */
    public String getAlunoNome() {
        return alunoNome;
    }

    /**
     * @param alunoNome the alunoNome to set
     */
    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
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
    public String getDataSolicitacaoRequerimento() {
        return dataSolicitacaoRequerimento;
    }

    /**
     * @param dataSolicitacaoRequerimento the dataSolicitacaoRequerimento to set
     */
    public void setDataSolicitacaoRequerimento(String dataSolicitacaoRequerimento) {
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
     * @return the documentosApresentados
     */
    public ArrayList<String> getDocumentosApresentados() {
        return documentosApresentados;
    }

    /**
     * @param documentosApresentados the documentosApresentados to set
     */
    public void setDocumentosApresentados(ArrayList<String> documentosApresentados) {
        this.documentosApresentados = documentosApresentados;
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
    public String getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    /**
     * @return the diasDescritosAnexo
     */
    public String getDiasDescritosAnexo() {
        return diasDescritosAnexo;
    }

    /**
     * @param diasDescritosAnexo the diasDescritosAnexo to set
     */
    public void setDiasDescritosAnexo(String diasDescritosAnexo) {
        this.diasDescritosAnexo = diasDescritosAnexo;
    }

    /**
     * @return the professorResponsavelAnalise
     */
    public String getProfessorResponsavelAnalise() {
        return professorResponsavelAnalise;
    }

    /**
     * @param professorResponsavelAnalise the professorResponsavelAnalise to set
     */
    public void setProfessorResponsavelAnalise(String professorResponsavelAnalise) {
        this.professorResponsavelAnalise = professorResponsavelAnalise;
    }

    /**
     * @return the professorAtividade
     */
    public String getProfessorAtividade() {
        return professorAtividade;
    }

    /**
     * @param professorAtividade the professorAtividade to set
     */
    public void setProfessorAtividade(String professorAtividade) {
        this.professorAtividade = professorAtividade;
    }

    /**
     * @return the tecnicoAdministrativoResponsavel
     */
    public String getTecnicoAdministrativoResponsavel() {
        return tecnicoAdministrativoResponsavel;
    }

    /**
     * @param tecnicoAdministrativoResponsavel the tecnicoAdministrativoResponsavel to set
     */
    public void setTecnicoAdministrativoResponsavel(String tecnicoAdministrativoResponsavel) {
        this.tecnicoAdministrativoResponsavel = tecnicoAdministrativoResponsavel;
    }

    /**
     * @return the disciplinaCursoAtual
     */
    public String getDisciplinaCursoAtual() {
        return disciplinaCursoAtual;
    }

    /**
     * @param disciplinaCursoAtual the disciplinaCursoAtual to set
     */
    public void setDisciplinaCursoAtual(String disciplinaCursoAtual) {
        this.disciplinaCursoAtual = disciplinaCursoAtual;
    }

    /**
     * @return the tipoRquerimento
     */
    public int getTipoRquerimento() {
        return tipoRquerimento;
    }

    /**
     * @param tipoRquerimento the tipoRquerimento to set
     */
    public void setTipoRquerimento(int tipoRquerimento) {
        this.tipoRquerimento = tipoRquerimento;
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
     * @return the cursoOrigem
     */
    public String getCursoOrigem() {
        return cursoOrigem;
    }

    /**
     * @param cursoOrigem the cursoOrigem to set
     */
    public void setCursoOrigem(String cursoOrigem) {
        this.cursoOrigem = cursoOrigem;
    }

    /**
     * @return the cursoDestino
     */
    public String getCursoDestino() {
        return cursoDestino;
    }

    /**
     * @param cursoDestino the cursoDestino to set
     */
    public void setCursoDestino(String cursoDestino) {
        this.cursoDestino = cursoDestino;
    }

    /**
     * @return the turmaOrigem
     */
    public String getTurmaOrigem() {
        return turmaOrigem;
    }

    /**
     * @param turmaOrigem the turmaOrigem to set
     */
    public void setTurmaOrigem(String turmaOrigem) {
        this.turmaOrigem = turmaOrigem;
    }

    /**
     * @return the turmaDestino
     */
    public String getTurmaDestino() {
        return turmaDestino;
    }

    /**
     * @param turmaDestino the turmaDestino to set
     */
    public void setTurmaDestino(String turmaDestino) {
        this.turmaDestino = turmaDestino;
    }

    /**
     * @return the turnoOrigem
     */
    public String getTurnoOrigem() {
        return turnoOrigem;
    }

    /**
     * @param turnoOrigem the turnoOrigem to set
     */
    public void setTurnoOrigem(String turnoOrigem) {
        this.turnoOrigem = turnoOrigem;
    }

    /**
     * @return the turnoDestino
     */
    public String getTurnoDestino() {
        return turnoDestino;
    }

    /**
     * @param turnoDestino the turnoDestino to set
     */
    public void setTurnoDestino(String turnoDestino) {
        this.turnoDestino = turnoDestino;
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
     * @return the disciplinaCertificacao
     */
    public String getDisciplinaCertificacao() {
        return disciplinaCertificacao;
    }

    /**
     * @param disciplinaCertificacao the disciplinaCertificacao to set
     */
    public void setDisciplinaCertificacao(String disciplinaCertificacao) {
        this.disciplinaCertificacao = disciplinaCertificacao;
    }

    /**
     * @return the idRquerimento
     */
    public int getIdRquerimento() {
        return idRquerimento;
    }

    /**
     * @param idRquerimento the idRquerimento to set
     */
    public void setIdRquerimento(int idRquerimento) {
        this.idRquerimento = idRquerimento;
    }
    
    

}
