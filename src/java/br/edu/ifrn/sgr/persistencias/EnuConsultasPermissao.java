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
public enum EnuConsultasPermissao 
{       
        

        /*
        Seleciona qual a permissao de acordo com o ID da permissão, basta passar o ID.
        */        
        SELECT_PERMISSAO_POR_ID("SELECT permissao.* FROM permissao WHERE permissao.per_id=?;");
                
    
        private String consulta; 
        private EnuConsultasPermissao(String consulta) { 
            this.consulta = consulta; 
        } 
        
        @Override 
        public String toString(){ 
            return consulta; 
        } 

                 
    
}
