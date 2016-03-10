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
public enum EnuConsultaTipoRequerimento  //Feito por Luan - Funcionando
{       
        //Retorna todos os tipos de requerimentos.
        SELECT_TIPOS_REQUERIMENTO("SELECT * FROM tipo_requerimento ORDER BY tip_req_nome;");

        private String consulta; 
        private  EnuConsultaTipoRequerimento(String consulta) { 
            this.consulta = consulta; 
        } 
        
        @Override 
        public String toString(){ 
            return consulta; 
        } 
                
    
}
