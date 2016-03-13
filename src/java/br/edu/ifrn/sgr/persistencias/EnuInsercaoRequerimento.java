/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.sgr.persistencias;

/**
 *
 * @author Luan Medeiros
 */
public enum EnuInsercaoRequerimento {
        
        INSERT_APROVEITAMENTO_DE_ESTUDOS("SELECT permissao.* FROM permissao WHERE permissao.per_id=?;");
                
    
        private String consulta; 
        private EnuInsercaoRequerimento(String consulta) { 
            this.consulta = consulta; 
        } 
        
        @Override 
        public String toString(){ 
            return consulta; 
        } 
}
