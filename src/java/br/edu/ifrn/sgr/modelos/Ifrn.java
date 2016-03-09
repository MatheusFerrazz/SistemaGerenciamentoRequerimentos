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
public class Ifrn {
    private int ifrnID;
    private String razaoSocial;

    public Ifrn(int ifrnID, String razaoSocial) {
        this.ifrnID = ifrnID;
        this.razaoSocial = razaoSocial;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public int getIfrnID() {
        return ifrnID;
    }

    public void setIfrnID(int ifrnID) {
        this.ifrnID = ifrnID;
    }
        
}
