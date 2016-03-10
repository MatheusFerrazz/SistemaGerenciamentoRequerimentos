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
public class Permissao {
    private int permissaoID;
    private String nome;

    public Permissao(int permissaoID, String nome) {
        this.permissaoID = permissaoID;
        this.nome = nome;
    }

    public Permissao() {
        
    }
    
    /**
     * @return the permissaoID
     */
    public int getPermissaoID() {
        return permissaoID;
    }

    /**
     * @param permissaoID the permissaoID to set
     */
    public void setPermissaoID(int permissaoID) {
        this.permissaoID = permissaoID;
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
    
    
}
