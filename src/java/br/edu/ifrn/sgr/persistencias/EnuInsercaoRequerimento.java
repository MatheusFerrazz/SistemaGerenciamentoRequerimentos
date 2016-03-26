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
public enum EnuInsercaoRequerimento {
    
        DOCUMENTOS_APRESENTADOS("insert into tipo_documento_apresentado (\"req_id_FK\",\"doc_apr_id_FK\") values (?,?);"),
        
        APROVEITAMENTO_DE_ESTUDOS("insert into requerimento (\"alu_id_FK\",req_disciplina_cursada, \"req_disciplina_curso_atual_FK\",req_observacoes, \"tip_req_id_FK\", req_data_solicitacao_requerimento) values (?,?,?,?,?,current_date) returning req_id;"),
        
        CERTIFICACAO_DE_CONHECIMENTOS("insert into requerimento (\"alu_id_FK\",\"tip_req_id_FK\",req_data_solicitacao_requerimento,\"req_disciplina_certificacao_FK\", req_observacoes) values (?,?,current_date,?,?);"),
        
        REPOSICAO_DE_ATIVIDADES("insert into requerimento (\"alu_id_FK\",\"tip_req_id_FK\",req_data_solicitacao_requerimento,req_observacoes,req_tipo_atividade,\"req_professor_atividade_FK\") values (?,?,current_date,?,?,?) returning req_id;"),
        
        MUDANCA_DE_CURSO("insert into requerimento (\"alu_id_FK\",\"tip_req_id_FK\",req_data_solicitacao_requerimento,req_observacoes,\"req_curso_origem_FK\", \"req_curso_destino_FK\") values (?,?,current_date,?,?,?) returning req_id;"),
        
        MUDANCA_DE_TURMA("insert into requerimento (\"alu_id_FK\",\"tip_req_id_FK\",req_data_solicitacao_requerimento,req_observacoes,\"req_turma_origem_FK\", \"req_turma_destino_FK\") values (?,?,current_date,?,?,?) returning req_id;"),
        
        MUDANCA_DE_TURNO("insert into requerimento (\"alu_id_FK\",\"tip_req_id_FK\",req_data_solicitacao_requerimento,req_observacoes,\"req_turno_origem_FK\", \"req_turno_destino_FK\") values (?,?,current_date,?,?,?) returning req_id;"),
        
        TRANSFERENCIA("insert into requerimento (\"alu_id_FK\",\"tip_req_id_FK\",req_data_solicitacao_requerimento,req_observacoes, req_tranferencia_curso_origem, req_tranferencia_curso_destino, req_tranferencia_escola_origem, req_tranferencia_escola_destino) values (?,?,current_date,?,?,?,?,?) returning req_id;"),
        
        LANCAMENTO_OU_REVISAO_DE_FALTAS_NOTAS_SITUACAO("insert into requerimento (\"alu_id_FK\",\"tip_req_id_FK\",req_data_solicitacao_requerimento,req_observacoes,req_tipo_atividade,\"req_professor_atividade_FK\") values (?,?,current_date,?,?,?) returning req_id;"),
        
        RENOVACAO_MATRICULA("insert into requerimento (\"alu_id_FK\",\"tip_req_id_FK\",req_data_solicitacao_requerimento,req_observacoes,req_tipo_atividade,\"req_professor_atividade_FK\") values (?,?,current_date,?,?,?) returning req_id;"),
        
        REABERTURA_MATRICULA("insert into requerimento (\"alu_id_FK\",req_disciplina_cursada, \"req_disciplina_curso_atual_FK\",req_observacoes) values (?,?,?,?) returning tip_req_id;"),
        
        JUSTIFICATIVA_DE_FALTAS_DIAS_EM_ANEXO("insert into requerimento (\"alu_id_FK\",req_disciplina_cursada, \"req_disciplina_curso_atual_FK\",req_observacoes) values (?,?,?,?) returning tip_req_id;"),
        
        JUSTIFICATIVA_DE_FALTA_DIA_ESPECIFICO("insert into requerimento (\"alu_id_FK\",req_disciplina_cursada, \"req_disciplina_curso_atual_FK\",req_observacoes) values (?,?,?,?) returning tip_req_id;"),
        
        JUSTIFICATIVA_DE_FALTA_POR_PERIODO("insert into requerimento (\"alu_id_FK\",req_disciplina_cursada, \"req_disciplina_curso_atual_FK\",req_observacoes) values (?,?,?,?) returning tip_req_id;"),
        
        TRANCAMENTO_DE_MATRICULA_COMPULSORIO("insert into requerimento (\"alu_id_FK\",req_disciplina_cursada, \"req_disciplina_curso_atual_FK\",req_observacoes) values (?,?,?,?) returning tip_req_id;"),
        
        CANCELAMENTO_DE_MATRiCULA("insert into requerimento (\"alu_id_FK\",req_disciplina_cursada, \"req_disciplina_curso_atual_FK\",req_observacoes) values (?,?,?,?) returning tip_req_id;"),
        
        ATENDIMENTO_DOMICILIAR("insert into requerimento (\"alu_id_FK\",req_disciplina_cursada, \"req_disciplina_curso_atual_FK\",req_observacoes) values (?,?,?,?) returning tip_req_id;"),
        
        OUTROS("insert into requerimento (\"alu_id_FK\",req_disciplina_cursada, \"req_disciplina_curso_atual_FK\",req_observacoes) values (?,?,?,?) returning tip_req_id;"),
        
        DISPENSA_DE_ATIVIDADES("insert into requerimento (\"alu_id_FK\",req_disciplina_cursada, \"req_disciplina_curso_atual_FK\",req_observacoes) values (?,?,?,?) returning tip_req_id;"),
        
        ADEQUACAO_DE_HORARIOS("insert into requerimento (\"alu_id_FK\",req_disciplina_cursada, \"req_disciplina_curso_atual_FK\",req_observacoes) values (?,?,?,?) returning tip_req_id;"),
        
        ESTUDO_INDIVIDUALIZADO("insert into requerimento (\"alu_id_FK\",req_disciplina_cursada, \"req_disciplina_curso_atual_FK\",req_observacoes) values (?,?,?,?) returning tip_req_id;"),
        
        INCLUSAO_DE_DISCIPLINAS("insert into requerimento (\"alu_id_FK\",req_disciplina_cursada, \"req_disciplina_curso_atual_FK\",req_observacoes) values (?,?,?,?) returning tip_req_id;"),
        
        REMOCAO_DE_DISCIPLINAS("insert into requerimento (\"alu_id_FK\",req_disciplina_cursada, \"req_disciplina_curso_atual_FK\",req_observacoes) values (?,?,?,?) returning tip_req_id;");        
        
        
        

        
        private String consulta; 
        private EnuInsercaoRequerimento(String consulta) { 
            this.consulta = consulta; 
        } 
        
        @Override 
        public String toString(){ 
            return consulta; 
        } 
}
