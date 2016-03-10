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
public class TipoRequerimento {
    private int id;
    private String nome;

    public TipoRequerimento(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public TipoRequerimento() {
   
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "TipoRequerimento{" + "id=" + id + ", nome=" + nome + '}';
    }
    
    
}
