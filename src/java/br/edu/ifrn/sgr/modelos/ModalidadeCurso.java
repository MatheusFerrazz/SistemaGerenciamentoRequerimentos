/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.sgr.modelos;

/**
 *
 * @author CH
 */
public class ModalidadeCurso {
    private int modalidadeID;
    private String nome;
    private String nivel;

    public ModalidadeCurso(int modalidadeID, String nome, String nivel) {
        this.modalidadeID = modalidadeID;
        this.nome = nome;
        this.nivel = nivel;
    }

    public ModalidadeCurso() {
        
    }

    /**
     * @return the modalidadeID
     */
    public int getModalidadeID() {
        return modalidadeID;
    }

    /**
     * @param modalidadeID the modalidadeID to set
     */
    public void setModalidadeID(int modalidadeID) {
        this.modalidadeID = modalidadeID;
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
     * @return the nivel
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    
}
