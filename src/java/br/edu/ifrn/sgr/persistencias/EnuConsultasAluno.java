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
public enum EnuConsultasAluno 
{       
        //Seleciona tudo do aluno, o ? é a matrícula do aluno.
        SELECT_ALUNO_COMPLETO("SELECT * FROM aluno WHERE alu_id=(?)"),
        /* Seleciona tudo da tabela curso, na primeira ? vai o ID do curso atual do aluno, na segunda ?
        vai o id da modalidade do curso atual do aluno.
        */
        SELECT_TROCA_CURSO_DISPONIVEL("SELECT * FROM curso WHERE curso.cur_id=(?) != curso.cur_id AND curso.mod_cur_id_FK=(?)"),

        
        
        SELECT_TURMAS_TROCA_DISPONIVEL("SELECT * FROM curso WHERE curso.cur_id=(?) != curso.cur_id AND curso.mod_cur_id_FK=(?)"),
        
        
        SELECT_TURNOS_TROCA_DISPONIVEL("ee2");
    
        private String consulta; 
        private EnuConsultasAluno(String consulta) { 
            this.consulta = consulta; 
        } 
        
        @Override 
        public String toString(){ 
            return consulta; 
        } 

                 
    
}
