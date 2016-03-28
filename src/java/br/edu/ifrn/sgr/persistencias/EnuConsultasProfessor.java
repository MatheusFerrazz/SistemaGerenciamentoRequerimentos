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
public enum EnuConsultasProfessor  //Feito por Luan - Funcionando
{       
//Seleciona todas as informações do diretor, basta passar o ID do diretor.
SELECT_INFORMACOES_PROFESSOR("SELECT pessoa.*, professor.*, permissao.* FROM professor"
        + " JOIN pessoa ON pessoa.\"pes_matricula_PK\"=professor.\"pro_id_PK\""
        + " JOIN permissao ON permissao.per_id=professor.\"per_id_FK\""
        + " WHERE professor.\"pro_id_PK\"=?;"),

        SELECT_NOME_PROFESSOR("select pessoa.pes_nome nome from pessoa"
        + " join professor on professor.\"pro_id_PK\"=pessoa.\"pes_matricula_PK\""
        + " where professor.\"pro_id_PK\"=?;");

        private String consulta; 
        private  EnuConsultasProfessor(String consulta) { 
            this.consulta = consulta; 
        } 
        
        @Override 
        public String toString(){ 
            return consulta; 
        } 
                
    
}
