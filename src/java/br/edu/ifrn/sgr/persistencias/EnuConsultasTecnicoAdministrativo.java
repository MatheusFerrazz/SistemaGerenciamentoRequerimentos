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
public enum EnuConsultasTecnicoAdministrativo  //Feito por Luan - Funcionando
{       
//Seleciona todas as informações do diretor, basta passar o ID do diretor.
SELECT_INFORMAÇÕES_TECADMINISTRATIVO("SELECT pessoa.*, tecnico_administrativo.*, permissao.* FROM tecnico_administrativo"
        + " JOIN pessoa ON pessoa.\"pes_matricula_PK\"=tecnico_administrativo.\"tec_adm_id_PK\""
        + " JOIN permissao ON permissao.per_id=tecnico_administrativo.\"per_id_FK\""
        + " WHERE tecnico_administrativo.\"tec_adm_id_PK\"=?;");

        private String consulta; 
        private  EnuConsultasTecnicoAdministrativo(String consulta) { 
            this.consulta = consulta; 
        } 
        
        @Override 
        public String toString(){ 
            return consulta; 
        } 
                
    
}
