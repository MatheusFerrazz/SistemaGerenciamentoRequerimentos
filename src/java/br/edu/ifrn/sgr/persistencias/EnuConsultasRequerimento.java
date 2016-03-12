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
public enum EnuConsultasRequerimento {

//Seleciona um requerimento específico pelo ID do requerimento, basta passar o ID
SELECT_REQUERIMENTO_POR_ID_REQUERIMENTO("SELECT requerimento.*, aluno.*, pessoa.*, turma.trm_codigo, curso.*, tipo_requerimento.* FROM requerimento"
+" JOIN aluno ON aluno.\"alu_id_PK\"=requerimento.\"alu_id_FK\""
+" JOIN pessoa ON aluno.\"alu_id_PK\"=pessoa.\"pes_matricula_PK\""
+" JOIN turma ON aluno.\"trm_codigo_FK\"=turma.trm_codigo"
+" JOIN curso ON curso.cur_id=aluno.\"cur_id_FK\""
+" JOIN tipo_requerimento ON tipo_requerimento.tip_req_id=requerimento.\"tip_req_id_FK\""
+" WHERE requerimento.req_id=?;"),
             

/*Selectiona todos os requerimentos do tipo_id ? feitos pelo aluno de do ID ?, basta passar o id do tipo de requerimento e o ID do aluno */
SELECT_TODOS_REQUERIMENTOS_POR_ALUNOID_E_TIPO_REQUERIMENTO_ID("SELECT requerimento.*, aluno.*, pessoa.*, turma.trm_codigo, curso.*, tipo_requerimento.* FROM requerimento"
+ " JOIN aluno ON aluno.\"alu_id_PK\"=requerimento.\"alu_id_FK\""
+ " JOIN pessoa ON aluno.\"alu_id_PK\"=pessoa.\"pes_matricula_PK\""
+ " JOIN turma ON aluno.\"trm_codigo_FK\"=turma.trm_codigo"
+ " JOIN curso ON curso.cur_id=aluno.\"cur_id_FK\""
+ " JOIN tipo_requerimento ON tipo_requerimento.tip_req_id=requerimento.\"tip_req_id_FK\""                
+ " WHERE aluno.\"alu_id_PK\"=? AND tipo_requerimento.tip_req_id=?"
+ " ORDER BY requerimento.req_data_solicitacao_requerimento;"),
        
        
/*Seleciona requerimentos do tipo_id ? feitos pelo aluno_nome ?, 
basta passar o id do tipo de requerimento e o nome do aluno ou parte dele*/
/*==============  OBS quando for passar o setString usar assim >> setString("%"+"VARIÁVEL DA STRING"+"%") @@@@@@*/
SELECT_TODOS_REQUERIMENTOS_POR_ALUNO_NOME_E_TIPO_REQUERIMENTO_ID("SELECT requerimento.*, aluno.*, pessoa.*, turma.trm_codigo, curso.*, tipo_requerimento.* FROM requerimento"
+ " JOIN aluno ON aluno.\"alu_id_PK\"=requerimento.\"alu_id_FK\""
+ " JOIN pessoa ON aluno.\"alu_id_PK\"=pessoa.\"pes_matricula_PK\""
+ " JOIN turma ON aluno.\"trm_codigo_FK\"=turma.trm_codigo"
+ " JOIN curso ON curso.cur_id=aluno.\"cur_id_FK\""
+ " JOIN tipo_requerimento ON tipo_requerimento.tip_req_id=requerimento.\"tip_req_id_FK\""                    
+ " WHERE LOWER(pessoa.pes_nome) LIKE LOWER(?) AND tipo_requerimento.tip_req_id=?"
+ " ORDER BY requerimento.req_data_solicitacao_requerimento;"),        

/*Seleciona todos os requerimentos em andamento, por ID aluno, basta passar o ID do aluno*/
SELECT_REQUERIMENTOS_EM_ANDAMENTO_POR_ALUNO_ID("SELECT requerimento.*, aluno.*, pessoa.*, turma.trm_codigo, curso.*, tipo_requerimento.* FROM requerimento"
+ " JOIN aluno ON aluno.\"alu_id_PK\"=requerimento.\"alu_id_FK\""
+ " JOIN pessoa ON aluno.\"alu_id_PK\"=pessoa.\"pes_matricula_PK\""
+ " JOIN turma ON aluno.\"trm_codigo_FK\"=turma.trm_codigo"
+ " JOIN curso ON curso.cur_id=aluno.\"cur_id_FK\""
+ " JOIN tipo_requerimento ON tipo_requerimento.tip_req_id=requerimento.\"tip_req_id_FK\""
+ " WHERE aluno.\"alu_id_PK\"=? AND requerimento.req_resultado IS NULL"
+ " ORDER BY requerimento.req_data_solicitacao_requerimento;"),        


/*Seleciona todos os requerimentos deferidos, por ID aluno, basta passar o ID do aluno*/
SELECT_REQUERIMENTOS_DEFERIDOS_POR_ALUNO_ID("SELECT requerimento.*, aluno.*, pessoa.*, turma.trm_codigo, curso.*, tipo_requerimento.* FROM requerimento"
+ " JOIN aluno ON aluno.\"alu_id_PK\"=requerimento.\"alu_id_FK\""
+ " JOIN pessoa ON aluno.\"alu_id_PK\"=pessoa.\"pes_matricula_PK\""
+ " JOIN turma ON aluno.\"trm_codigo_FK\"=turma.trm_codigo"
+ " JOIN curso ON curso.cur_id=aluno.\"cur_id_FK\""
+ " JOIN tipo_requerimento ON tipo_requerimento.tip_req_id=requerimento.\"tip_req_id_FK\""
+ " WHERE aluno.\"alu_id_PK\"=? AND requerimento.req_resultado=true"
+ " ORDER BY requerimento.req_data_solicitacao_requerimento;"),        

/*Seleciona todos os requerimentos indeferidos, por ID aluno, basta passar o ID do aluno*/
SELECT_REQUERIMENTOS_INDEFERIDOS_POR_ALUNO_ID("SELECT requerimento.*, aluno.*, pessoa.*, turma.trm_codigo, curso.*, tipo_requerimento.* FROM requerimento"
+ " JOIN aluno ON aluno.\"alu_id_PK\"=requerimento.\"alu_id_FK\""
+ " JOIN pessoa ON aluno.\"alu_id_PK\"=pessoa.\"pes_matricula_PK\""
+ " JOIN turma ON aluno.\"trm_codigo_FK\"=turma.trm_codigo"
+ " JOIN curso ON curso.cur_id=aluno.\"cur_id_FK\""
+ " JOIN tipo_requerimento ON tipo_requerimento.tip_req_id=requerimento.\"tip_req_id_FK\""
+ " WHERE aluno.\"alu_id_PK\"=? AND requerimento.req_resultado=false"
+ " ORDER BY requerimento.req_data_solicitacao_requerimento;"),        

/*Seleciona todos os requerimentos do aluno, por ID aluno, basta passar o ID do aluno*/
SELECT_TODOS_REQUERIMENTOS_DO_ALUNO_("SELECT requerimento.*, aluno.*, pessoa.*, turma.trm_codigo, curso.*, tipo_requerimento.* FROM requerimento"
+ " JOIN aluno ON aluno.\"alu_id_PK\"=requerimento.\"alu_id_FK\""
+ " JOIN pessoa ON aluno.\"alu_id_PK\"=pessoa.\"pes_matricula_PK\""
+ " JOIN turma ON aluno.\"trm_codigo_FK\"=turma.trm_codigo"
+ " JOIN curso ON curso.cur_id=aluno.\"cur_id_FK\""
+ " JOIN tipo_requerimento ON tipo_requerimento.tip_req_id=requerimento.\"tip_req_id_FK\""
+ " WHERE aluno.\"alu_id_PK\"=?"
+ " ORDER BY requerimento.req_data_solicitacao_requerimento;"),

/*Seleciona todos os requerimentos em andamento*/
SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_("SELECT requerimento.*, aluno.*, pessoa.*, turma.trm_codigo, curso.*, tipo_requerimento.* FROM requerimento"
+ " JOIN aluno ON aluno.\"alu_id_PK\"=requerimento.\"alu_id_FK\""
+ " JOIN pessoa ON aluno.\"alu_id_PK\"=pessoa.\"pes_matricula_PK\""
+ " JOIN turma ON aluno.\"trm_codigo_FK\"=turma.trm_codigo"
+ " JOIN curso ON curso.cur_id=aluno.\"cur_id_FK\""
+ " JOIN tipo_requerimento ON tipo_requerimento.tip_req_id=requerimento.\"tip_req_id_FK\""
+ " WHERE requerimento.req_resultado IS NULL;"
+ " ORDER BY requerimento.req_data_solicitacao_requerimento;"),        

/*Seleciona todos os requerimentos deferidos*/
SELECT_TODOS_REQUERIMENTOS_DEFERIDOS("SELECT requerimento.*, aluno.*, pessoa.*, turma.trm_codigo, curso.*, tipo_requerimento.* FROM requerimento"
+ " JOIN aluno ON aluno.\"alu_id_PK\"=requerimento.\"alu_id_FK\""
+ " JOIN pessoa ON aluno.\"alu_id_PK\"=pessoa.\"pes_matricula_PK\""
+ " JOIN turma ON aluno.\"trm_codigo_FK\"=turma.trm_codigo"
+ " JOIN curso ON curso.cur_id=aluno.\"cur_id_FK\""
+ " JOIN tipo_requerimento ON tipo_requerimento.tip_req_id=requerimento.\"tip_req_id_FK\""
+ " WHERE requerimento.req_resultado=true"
+ " ORDER BY requerimento.req_data_solicitacao_requerimento;"),        


/*Seleciona todos os requerimentos indeferidos*/
SELECT_TODOS_REQUERIMENTOS_INDEFERIDOS_("SELECT requerimento.*, aluno.*, pessoa.*, turma.trm_codigo, curso.*, tipo_requerimento.* FROM requerimento"
+ " JOIN aluno ON aluno.\"alu_id_PK\"=requerimento.\"alu_id_FK\""
+ " JOIN pessoa ON aluno.\"alu_id_PK\"=pessoa.\"pes_matricula_PK\""
+ " JOIN turma ON aluno.\"trm_codigo_FK\"=turma.trm_codigo"
+ " JOIN curso ON curso.cur_id=aluno.\"cur_id_FK\""
+ " JOIN tipo_requerimento ON tipo_requerimento.tip_req_id=requerimento.\"tip_req_id_FK\""
+ " WHERE requerimento.req_resultado=false"
+ " ORDER BY requerimento.req_data_solicitacao_requerimento;"),        

/*Seleciona todos os requerimentos em andamento*/
SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_POR_TIPO_REQUERIMENTO("SELECT requerimento.*, aluno.*, pessoa.*, turma.trm_codigo, curso.*, tipo_requerimento.* FROM requerimento"
+ " JOIN aluno ON aluno.\"alu_id_PK\"=requerimento.\"alu_id_FK\""
+ " JOIN pessoa ON aluno.\"alu_id_PK\"=pessoa.\"pes_matricula_PK\""
+ " JOIN turma ON aluno.\"trm_codigo_FK\"=turma.trm_codigo"
+ " JOIN curso ON curso.cur_id=aluno.\"cur_id_FK\""
+ " JOIN tipo_requerimento ON tipo_requerimento.tip_req_id=requerimento.\"tip_req_id_FK\""
+ " WHERE requerimento.\"tip_req_id_FK\"=? AND requerimento.req_resultado IS NULL"
+ " ORDER BY requerimento.req_data_solicitacao_requerimento;"),

/*/////////////////////////////////////////////////////////////////////////////////////////////////////////
         DAQUI PARA BAIXO VÂO TODOS OS SELECTS ESPECÍFICOS DE ACORDO COM O REQUERIMENTO ESCOLHIDO 
/////////////////////////////////////////////////////////////////////////////////////////////////////////*/

//Seleciona todos os documentos apresentados do requerimento específico, basta passar o ID do requerimento 
SELECT_DOCUMENTOS_APRESENTADOS_DO_REQUERIMENTO("SELECT DISTINCT tipo_documento_apresentado.*, documento.* FROM tipo_documento_apresentado"
+ " JOIN documento ON documento.\"doc_apr_id_PK\"=tipo_documento_apresentado.\"doc_apr_id_FK\""
+ " WHERE tipo_documento_apresentado.\"req_id_FK\"=?;");

private String consulta; 
        private EnuConsultasRequerimento(String consulta) { 
            this.consulta = consulta; 
        } 
        
        @Override 
        public String toString(){ 
            return consulta; 
        } 

    
}
