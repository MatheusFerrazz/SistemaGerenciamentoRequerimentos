/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.sgr.modelos;

import java.util.ArrayList;

/**
 *
* @author CH
 */
public class Curso {
    private ModalidadeCurso modalidade;
    private Campus campus;
    private Turno turno;
    private Coordenador coordenador;
    private int cursoID;    
    private String nome;
    private Integer periodo;
    private int anos;
    private boolean cursoAtivo;
    private ArrayList<Disciplina> disciplinasDoCurso = new ArrayList<>();
    private ArrayList<Professor> professores = new ArrayList<>();
    private ArrayList<Turno> turnosTranferencia = new ArrayList<>();
    private ArrayList<Turma> turmasTranferencia = new ArrayList<>();
    private ArrayList<Curso> cursosTranferencia = new ArrayList<>();

    public Curso(ModalidadeCurso modalidade, Campus campus, Turno turno, Coordenador coordenador, int cursoID, String nome, int periodo, int anos, boolean cursoAtivo) {
        this.modalidade = modalidade;
        this.campus = campus;
        this.turno = turno;
        this.coordenador = coordenador;
        this.cursoID = cursoID;
        this.nome = nome;
        this.periodo = periodo;
        this.anos = anos;
        this.cursoAtivo = cursoAtivo;
    }

    public Curso()
    {
        
    }            
    /**
     * @return the modalidade
     */
    public ModalidadeCurso getModalidade() {
        return modalidade;
    }

    /**
     * @param modalidade the modalidade to set
     */
    public void setModalidade(ModalidadeCurso modalidade) {
        this.modalidade = modalidade;
    }

    /**
     * @return the campus
     */
    public Campus getCampus() {
        return campus;
    }

    /**
     * @param campus the campus to set
     */
    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    /**
     * @return the turno
     */
    public Turno getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    /**
     * @return the coordenador
     */
    public Coordenador getCoordenador() {
        return coordenador;
    }

    /**
     * @param coordenador the coordenador to set
     */
    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }

    /**
     * @return the cursoID
     */
    public int getCursoID() {
        return cursoID;
    }

    /**
     * @param cursoID the cursoID to set
     */
    public void setCursoID(int cursoID) {
        this.cursoID = cursoID;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the periodo
     */
    public Integer getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    /**
     * @return the anos
     */
    public int getAnos() {
        return anos;
    }

    /**
     * @param anos the anos to set
     */
    public void setAnos(int anos) {
        this.anos = anos;
    }

    /**
     * @return the cursoAtivo
     */
    public boolean isCursoAtivo() {
        return cursoAtivo;
    }

    /**
     * @param cursoAtivo the cursoAtivo to set
     */
    public void setCursoAtivo(boolean cursoAtivo) {
        this.cursoAtivo = cursoAtivo;
    }
    
    /**
     * @return the professores
     */
    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    /**
     * @param professores the professores to set
     */
    public void setProfessores(ArrayList<Professor> professores) {
        this.professores = professores;
    }

    /**
     * @return the turnosTranferencia
     */
    public ArrayList<Turno> getTurnosTranferencia() {
        return turnosTranferencia;
    }

    /**
     * @param turnosTranferencia the turnosTranferencia to set
     */
    public void setTurnosTranferencia(ArrayList<Turno> turnosTranferencia) {
        this.turnosTranferencia = turnosTranferencia;
    }

    /**
     * @return the turmasTranferencia
     */
    public ArrayList<Turma> getTurmasTranferencia() {
        return turmasTranferencia;
    }

    /**
     * @param turmasTranferencia the turmasTranferencia to set
     */
    public void setTurmasTranferencia(ArrayList<Turma> turmasTranferencia) {
        this.turmasTranferencia = turmasTranferencia;
    }

    /**
     * @return the cursosTranferencia
     */
    public ArrayList<Curso> getCursosTranferencia() {
        return cursosTranferencia;
    }

    /**
     * @param cursosTranferencia the cursosTranferencia to set
     */
    public void setCursosTranferencia(ArrayList<Curso> cursosTranferencia) {
        this.cursosTranferencia = cursosTranferencia;
    }

    /**
     * @return the disciplinasDoCurso
     */
    public ArrayList<Disciplina> getDisciplinasDoCurso() {
        return disciplinasDoCurso;
    }

    /**
     * @param disciplinasDoCurso the disciplinasDoCurso to set
     */
    public void setDisciplinasDoCurso(ArrayList<Disciplina> disciplinasDoCurso) {
        this.disciplinasDoCurso = disciplinasDoCurso;
    }


    
}
