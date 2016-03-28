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
public enum EnuConsultasCoordenador  //Feito por Luan - Funcionando
{       
//Seleciona todas as informações do diretor, basta passar o ID do diretor.
SELECT_INFORMACOES_COORDENADOR("SELECT pessoa.*, coordenador.*, permissao.* FROM coordenador"
        + " JOIN pessoa ON pessoa.\"pes_matricula_PK\"=coordenador.\"coo_id_PK\""
        + " JOIN permissao ON permissao.per_id=coordenador.\"per_id_FK\""
        + " WHERE coordenador.\"coo_id_PK\"=?;");

        private String consulta; 
        private  EnuConsultasCoordenador(String consulta) { 
            this.consulta = consulta; 
        } 
        
        @Override 
        public String toString(){ 
            return consulta; 
        } 
                
    
}
