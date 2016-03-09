/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.sgr.modelos;
import java.util.Date;
/**
 *
 * @author CH
 */
public class Requerimento {
    private Aluno aluno;    
    private String disciplinaCursada = "";
    private String observacoes = "";        
    private String encaminhamentos = "";   
    private String mudancaDe = "";
    private String mudancaPara = "";
    private Date dataRealizacaoCertificacao;
    private Date dataFaltasDe;
    private Date dataFaltasAte;
    private Date dataFaltasDia;
    private Date dataSolicitacaoRequerimento;
    private Date dataAtividade;
    private int periodoTancamento;
    private TipoDocumento tipoDoumento;
    private String outros = "";
    private String justificativa = "";
    private String obersavacoesAnaliseAproveitamento = "";
    private String obervacoesDocumentosApresentados = "";
    private boolean resultado;
    private boolean diasDescritosAnexo;
    private Professor professorResponsavelAnalise;
    private Professor professorAtividade;
    private TecnicoAdministrativo tecnicoAdministrativoResponsavel;
    private Disciplina disciplinaCursoAtual;
    private TipoRequerimento tipoRquerimento;
    private TipoAtividade tipoAtividade;
    private Curso cursoOrigem;
    private Curso cursoDestino;
    private Turma turmaOrigem;
    private Turma turmaDestino;
    private Turno turnoOrigem;
    private Turno turnoDestino;
    
    public Requerimento()
    {
        
    }

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
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
    public Date getDataRealizacaoCertificacao() {
        return dataRealizacaoCertificacao;
    }

    /**
     * @param dataRealizacaoCertificacao the dataRealizacaoCertificacao to set
     */
    public void setDataRealizacaoCertificacao(Date dataRealizacaoCertificacao) {
        this.dataRealizacaoCertificacao = dataRealizacaoCertificacao;
    }

    /**
     * @return the dataFaltasDe
     */
    public Date getDataFaltasDe() {
        return dataFaltasDe;
    }

    /**
     * @param dataFaltasDe the dataFaltasDe to set
     */
    public void setDataFaltasDe(Date dataFaltasDe) {
        this.dataFaltasDe = dataFaltasDe;
    }

    /**
     * @return the dataFaltasAte
     */
    public Date getDataFaltasAte() {
        return dataFaltasAte;
    }

    /**
     * @param dataFaltasAte the dataFaltasAte to set
     */
    public void setDataFaltasAte(Date dataFaltasAte) {
        this.dataFaltasAte = dataFaltasAte;
    }

    /**
     * @return the dataFaltasDia
     */
    public Date getDataFaltasDia() {
        return dataFaltasDia;
    }

    /**
     * @param dataFaltasDia the dataFaltasDia to set
     */
    public void setDataFaltasDia(Date dataFaltasDia) {
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
    public Date getDataAtividade() {
        return dataAtividade;
    }

    /**
     * @param dataAtividade the dataAtividade to set
     */
    public void setDataAtividade(Date dataAtividade) {
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
     * @return the tipoDoumento
     */
    public TipoDocumento getTipoDoumento() {
        return tipoDoumento;
    }

    /**
     * @param tipoDoumento the tipoDoumento to set
     */
    public void setTipoDoumento(TipoDocumento tipoDoumento) {
        this.tipoDoumento = tipoDoumento;
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
     * @return the professorResponsavelAnalise
     */
    public Professor getProfessorResponsavelAnalise() {
        return professorResponsavelAnalise;
    }

    /**
     * @param professorResponsavelAnalise the professorResponsavelAnalise to set
     */
    public void setProfessorResponsavelAnalise(Professor professorResponsavelAnalise) {
        this.professorResponsavelAnalise = professorResponsavelAnalise;
    }

    /**
     * @return the professorAtividade
     */
    public Professor getProfessorAtividade() {
        return professorAtividade;
    }

    /**
     * @param professorAtividade the professorAtividade to set
     */
    public void setProfessorAtividade(Professor professorAtividade) {
        this.professorAtividade = professorAtividade;
    }

    /**
     * @return the tecnicoAdministrativoResponsavel
     */
    public TecnicoAdministrativo getTecnicoAdministrativoResponsavel() {
        return tecnicoAdministrativoResponsavel;
    }

    /**
     * @param tecnicoAdministrativoResponsavel the tecnicoAdministrativoResponsavel to set
     */
    public void setTecnicoAdministrativoResponsavel(TecnicoAdministrativo tecnicoAdministrativoResponsavel) {
        this.tecnicoAdministrativoResponsavel = tecnicoAdministrativoResponsavel;
    }

    /**
     * @return the disciplinaCursoAtual
     */
    public Disciplina getDisciplinaCursoAtual() {
        return disciplinaCursoAtual;
    }

    /**
     * @param disciplinaCursoAtual the disciplinaCursoAtual to set
     */
    public void setDisciplinaCursoAtual(Disciplina disciplinaCursoAtual) {
        this.disciplinaCursoAtual = disciplinaCursoAtual;
    }

    /**
     * @return the tipoRquerimento
     */
    public TipoRequerimento getTipoRquerimento() {
        return tipoRquerimento;
    }

    /**
     * @param tipoRquerimento the tipoRquerimento to set
     */
    public void setTipoRquerimento(TipoRequerimento tipoRquerimento) {
        this.tipoRquerimento = tipoRquerimento;
    }

    /**
     * @return the tipoAtividade
     */
    public TipoAtividade getTipoAtividade() {
        return tipoAtividade;
    }

    /**
     * @param tipoAtividade the tipoAtividade to set
     */
    public void setTipoAtividade(TipoAtividade tipoAtividade) {
        this.tipoAtividade = tipoAtividade;
    }

    /**
     * @return the cursoOrigem
     */
    public Curso getCursoOrigem() {
        return cursoOrigem;
    }

    /**
     * @param cursoOrigem the cursoOrigem to set
     */
    public void setCursoOrigem(Curso cursoOrigem) {
        this.cursoOrigem = cursoOrigem;
    }

    /**
     * @return the cursoDestino
     */
    public Curso getCursoDestino() {
        return cursoDestino;
    }

    /**
     * @param cursoDestino the cursoDestino to set
     */
    public void setCursoDestino(Curso cursoDestino) {
        this.cursoDestino = cursoDestino;
    }

    /**
     * @return the turmaOrigem
     */
    public Turma getTurmaOrigem() {
        return turmaOrigem;
    }

    /**
     * @param turmaOrigem the turmaOrigem to set
     */
    public void setTurmaOrigem(Turma turmaOrigem) {
        this.turmaOrigem = turmaOrigem;
    }

    /**
     * @return the turmaDestino
     */
    public Turma getTurmaDestino() {
        return turmaDestino;
    }

    /**
     * @param turmaDestino the turmaDestino to set
     */
    public void setTurmaDestino(Turma turmaDestino) {
        this.turmaDestino = turmaDestino;
    }

    /**
     * @return the turnoOrigem
     */
    public Turno getTurnoOrigem() {
        return turnoOrigem;
    }

    /**
     * @param turnoOrigem the turnoOrigem to set
     */
    public void setTurnoOrigem(Turno turnoOrigem) {
        this.turnoOrigem = turnoOrigem;
    }

    /**
     * @return the turnoDestino
     */
    public Turno getTurnoDestino() {
        return turnoDestino;
    }

    /**
     * @param turnoDestino the turnoDestino to set
     */
    public void setTurnoDestino(Turno turnoDestino) {
        this.turnoDestino = turnoDestino;
    }
    
    
    
    

}