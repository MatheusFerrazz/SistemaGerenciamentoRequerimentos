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
public enum EnuConsultasDocumento 
{       
        

        /*
        Seleciona qual a permissao de acordo com o ID da permissão, basta passar o ID.
        */        
        SELECT_TODOS_DOCUMENTOS("SELECT documento.* FROM documento ORDER BY documento.doc_apr_nome;");
                
    
        private String consulta; 
        private EnuConsultasDocumento(String consulta) { 
            this.consulta = consulta; 
        } 
        
        @Override 
        public String toString(){ 
            return consulta; 
        } 

                 
    
}
