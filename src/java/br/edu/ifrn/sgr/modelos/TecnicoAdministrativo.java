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
public class TecnicoAdministrativo extends Pessoa {
    private Permissao permissao;

    public TecnicoAdministrativo(Permissao permissao, String matricula, String nome, String email, String telefone, String celular, Date dataNascimento) {
        super(matricula, nome, email, telefone, celular, dataNascimento);
        this.permissao = permissao;
    }

    public TecnicoAdministrativo() {
        
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
