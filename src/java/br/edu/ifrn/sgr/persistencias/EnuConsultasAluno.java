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
        
        //SELECT_ALUNO_COMPLETO2("SELECT * FROM aluno WHERE alu_id=(?)"),
        
        //Seleciona tudo do aluno, o ? é a matrícula do aluno. FUNCIONANDO
        SELECT_ALUNO_COMPLETO("SELECT distinct aluno.*, pessoa.*, curso.*, permissao.*, modalidade_curso.*, turno.*, turma.*, coordenador.*, campus.*, diretor.* FROM aluno"+                
                " JOIN pessoa ON pessoa.\"pes_matricula_PK\"=aluno.\"alu_id_PK\""+
                " JOIN curso ON curso.cur_id=aluno.\"cur_id_FK\""+
                " JOIN permissao ON aluno.\"per_id_FK\"=permissao.per_id"+
                " JOIN modalidade_curso ON curso.\"mod_cur_id_FK\"=modalidade_curso.mod_cur_id"+
                " JOIN turno ON curso.\"trn_id_FK\"=turno.trn_id"+
                " JOIN turma ON aluno.\"trm_codigo_FK\"=turma.trm_codigo"+
                " JOIN coordenador ON curso.\"coo_id_FK\"=coordenador.\"coo_id_PK\""+  
                " JOIN campus ON campus.cam_id=curso.\"cam_id_FK\""+  
                " JOIN diretor ON diretor.\"dir_id_PK\"=campus.\"dir_id_FK\""+        
                " WHERE aluno.\"alu_id_PK\"=?;"),
        
        SELECT_ALUNO_LOGIN("select aluno.\"alu_id_PK\" FROM aluno"
                + " JOIN pessoa ON pessoa.\"pes_matricula_PK\"=aluno.\"alu_id_PK\""
                + " WHERE aluno.\"alu_id_PK\"=? AND pessoa.pes_senha=?;");
        

    
        private String consulta; 
        private EnuConsultasAluno(String consulta) { 
            this.consulta = consulta; 
        } 
        
        @Override 
        public String toString(){ 
            return consulta; 
        } 

                 
    
}
