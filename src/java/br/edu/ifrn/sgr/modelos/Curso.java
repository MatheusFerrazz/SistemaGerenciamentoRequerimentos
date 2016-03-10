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
    private int periodo;
    private int anos;
    private boolean cursoAtivo;
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();
    private ArrayList<Professor> professores = new ArrayList<>();

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
    public int getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(int periodo) {
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
     * @return the disciplinas
     */
    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    /**
     * @param disciplinas the disciplinas to set
     */
    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
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
    
    public void inserirProfessor(Professor professor)
    {
        professores.add(professor);
    }
    
    public void inserirDisciplina(Disciplina disciplina)
    {
        disciplinas.add(disciplina);
    }


    
    
}
