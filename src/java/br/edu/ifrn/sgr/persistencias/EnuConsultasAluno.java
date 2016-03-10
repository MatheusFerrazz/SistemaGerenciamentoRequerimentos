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
        SELECT_ALUNO_COMPLETO("SELECT distinct * FROM aluno"+
        "INNER JOIN pessoa ON pessoa.pes_matricula_PK=aluno.alu_id_PK"+
        "INNER JOIN curso ON curso.cur_id=aluno.cur_id_FK"+
        "INNER JOIN permissao ON aluno.per_id_FK=permissao.per_id"+
        "INNER JOIN modalidade_curso ON curso.mod_cur_id_FK=modalidade_curso.mod_cur_id"+
        "INNER JOIN turno ON curso.trn_id_FK=turno.trn_id"+
        "INNER JOIN turma ON aluno.trm_codigo_FK=turma.trm_codigo"+
        "INNER JOIN coordenador ON curso.coo_id_FK=coordenador.coo_id_PK"+  
        "INNER JOIN disciplina ON disciplina.cur_id_FK=aluno.cur_id_FK"+  
        "INNER JOIN campus ON campus.cam_id=curso.cam_id_FK"+
        "INNER JOIN diretor ON diretor.dir_id_PK=campus.dir_id_FK"+
        "WHERE aluno.alu_id_PK=?;"),
        
        /* Seleciona tudo da tabela curso, na primeira ? vai o ID do curso atual do aluno, na segunda ?
        vai o id da modalidade do curso atual do aluno.
        */
        SELECT_TROCA_CURSO_DISPONIVEL("SELECT * FROM curso WHERE curso.cur_id=(?) != curso.cur_id AND curso.mod_cur_id_FK=(?)"),

        SELECT_CURSO_COMPLETO("SELECT * FROM curso WHERE cur_id=(?)"),
        
        SELECT_DISCIPLINAS_CURSO("SELECT * FROM curso WHERE cur_id=?"),
        
        SELECT_TURNO_COMPLETO("SELECT * FROM turno WHERE trn_id=(?)"),
        
        SELECT_MODALIDADE_CURSO_COMPLETO("SELECT * FROM modalidade_curso WHERE mod_cur_id_FK=(?)"),
        
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
