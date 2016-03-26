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
public enum EnuConsultasTurno 
{       
        

        
        //Consultado o nome da disciplina, basta passar o id da disciplina
        SELECT_NOME_DISCIPLINA("select disciplina.dis_nome from disciplina where disciplina.dis_id=?;");

        

    
        private String consulta; 
        private EnuConsultasTurno(String consulta) { 
            this.consulta = consulta; 
        } 
        
        @Override 
        public String toString(){ 
            return consulta; 
        } 

                 
    
}
