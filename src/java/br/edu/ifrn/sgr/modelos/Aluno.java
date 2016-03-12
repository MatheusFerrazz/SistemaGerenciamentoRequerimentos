/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.sgr.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author CH
 */
public class Aluno extends Pessoa implements Serializable{
  private Curso curso;
  private Turma turma;
  private Permissao permissao;
  ArrayList<Curso> cursosTranferência = new ArrayList<>();


    public Aluno(Curso curso, Turma turma, Permissao permissao, String matricula, String nome, String email, String telefone, String celular, Date dataNascimento, String senha) {
        super(matricula, nome, email, telefone, celular, dataNascimento);
        this.curso = curso;
        this.turma = turma;
        this.permissao = permissao;
    }

    public Aluno() {
        
    }

    /**
     * @return the curso
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /**
     * @return the turma
     */
    public Turma getTurma() {
        return turma;
    }

    /**
     * @param turma the turma to set
     */
    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    /**
     * @return the permissao
     */
    public Permissao getPermissao() {
        return permissao;
    }

    /**
     * @param permissao the permissao to set
     */
    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }
}
