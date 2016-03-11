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
public enum EnuConsultasDiretor  //Feito por Luan - Funcionando
{       
//Seleciona todas as informações do diretor, basta passar o ID do diretor.
SELECT_INFORMAÇÕES_DIRETOR("SELECT pessoa.*, diretor.*, permissao.* FROM diretor"
        + " JOIN pessoa ON pessoa.\"pes_matricula_PK\"=diretor.\"dir_id_PK\""
        + " JOIN permissao ON permissao.per_id=diretor.\"per_id_FK\""
        + " WHERE diretor.\"dir_id_PK\"=?;");

        private String consulta; 
        private  EnuConsultasDiretor(String consulta) { 
            this.consulta = consulta; 
        } 
        
        @Override 
        public String toString(){ 
            return consulta; 
        } 
                
    
}
