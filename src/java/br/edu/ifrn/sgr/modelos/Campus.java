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
public class Campus {
    private int campusID;
    private Ifrn ifrn;
    private Diretor diretor;
    private String nome;    
    private String endereco;
    private String bairro;
    private String telefone;
    private String cidade;
    private String estado;
    private String cep;
    private int numero;

    public Campus(int campusID, Ifrn ifrn, Diretor diretor, String nome, String endereco, String bairro, String telefone, String estado, String cep, int numero, String cidade) {
        this.campusID = campusID;
        this.ifrn = ifrn;
        this.diretor = diretor;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.telefone = telefone;
        this.estado = estado;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
    }

    public Campus() {
        
    }

    /**
     * @return the campusID
     */
    public int getCampusID() {
        return campusID;
    }

    /**
     * @param campusID the campusID to set
     */
    public void setCampusID(int campusID) {
        this.campusID = campusID;
    }

    /**
     * @return the ifrn
     */
    public Ifrn getIfrn() {
        return ifrn;
    }

    /**
     * @param ifrn the ifrn to set
     */
    public void setIfrn(Ifrn ifrn) {
        this.ifrn = ifrn;
    }

    /**
     * @return the diretor
     */
    public Diretor getDiretor() {
        return diretor;
    }

    /**
     * @param diretor the diretor to set
     */
    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
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
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
          
}
