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
public enum EnuConsultasModalidadeCurso 
{       
        

        /*
        Seleciona a modalidade do curso de acordo com o ID da modalidade, basta passar o ID.
        */        
        SELECT_MODALIDADE_CURSO_POR_ID("SELECT modalidade_curso.* FROM modalidade_curso WHERE modalidade_curso.mod_cur_id=?;");
                
    
        private String consulta; 
        private EnuConsultasModalidadeCurso(String consulta) { 
            this.consulta = consulta; 
        } 
        
        @Override 
        public String toString(){ 
            return consulta; 
        } 

                 
    
}
