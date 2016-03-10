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
        SELECT_ALUNO_COMPLETO(
                "SELECT distinct * FROM aluno"+
                "INNER JOIN pessoa ON pessoa.\"pes_matricula_PK\"=aluno.\"alu_id_PK\""+
                "INNER JOIN curso ON curso.cur_id=aluno.\"cur_id_FK\""+
                "INNER JOIN permissao ON aluno.\"per_id_FK\"=permissao.per_id"+
                "INNER JOIN modalidade_curso ON curso.\"mod_cur_id_FK\"=modalidade_curso.mod_cur_id"+
                "INNER JOIN turno ON curso.\"trn_id_FK\"=turno.trn_id"+
                "INNER JOIN turma ON aluno.\"trm_codigo_FK\"=turma.trm_codigo"+
                "INNER JOIN coordenador ON curso.\"coo_id_FK\"=coordenador.\"coo_id_PK\""+  
                "INNER JOIN campus ON campus.cam_id=curso.\"cam_id_FK\""+  
                "INNER JOIN diretor ON diretor.\"dir_id_PK\"=campus.\"dir_id_FK\""+        
                "WHERE aluno.\"alu_id_PK\"=?"),
        
         
        /* Seleciona todos os professores do curso, basta passar o id do curso*/        
        SELECT_TODOS_PROFESSORES_DO_CURSO(
                "SELECT DISTINCT professor.*, pessoa.* FROM disciplina"+
                "JOIN relacao_disciplina_professor ON relacao_disciplina_professor.\"dis_id_FK\"=disciplina.dis_id"+
                "JOIN professor ON professor.\"pro_id_PK\"=relacao_disciplina_professor.\"pro_id_FK\""+
                "JOIN pessoa ON pessoa.\"pes_matricula_PK\"=professor.\"pro_id_PK\""+
                "WHERE disciplina.\"cur_id_FK\"=?;"),

        /*Seleciona todas as disciplinas ativas do curso, basta passar o id do curso*/
        SELECT_TODAS_DISCIPLINAS_CURSO("SELECT DISTINCT disciplina.* FROM disciplina WHERE disciplina.\"cur_id_FK\"=? AND disciplina.dis_ativo=true;"),
        
        /*Seleciona todos os professores de uma disciplina expecífica, basta passar o ID da disciplina e o ID do curso */
        SELECT_TODOS_PROFESSORES_DA_DISCIPLINA(
                "SELECT DISTINCT professor.*, pessoa.* FROM disciplina"+ 
                "JOIN relacao_disciplina_professor ON disciplina.dis_id=relacao_disciplina_professor.\"dis_id_FK\""+
                "JOIN professor ON relacao_disciplina_professor.\"pro_id_FK\" = professor.\"pro_id_PK\""+
                "JOIN pessoa ON pessoa.\"pes_matricula_PK\"=professor.\"pro_id_PK\""+
                "WHERE disciplina.dis_id=1 AND disciplina.\"cur_id_FK\"=2 AND disciplina.dis_ativo=true;"),

        /*Seleciona cursos da mesma modalidade do atual para tranferência e também o campus do curso, basta passar o ID da modalidade
        do curso e o ID do curso atual.        
        */
        SELECT_CURSOS_POSSIVEIS_TRANSFERÊNCIA(
                "SELECT DISTINCT curso.*, campus.* FROM curso"+
                "JOIN campus ON campus.cam_id= curso.\"cam_id_FK\""+
                "WHERE curso.\"mod_cur_id_FK\"=3 AND curso.cur_ativo=true AND curso.cur_id!=3;"),
        
        
        
        //////////////////    DAQUI PRA BAIXO AINDA VOU FAZER - O SONO BATEEEEEEU //////////////////////////
        //Seleciona todos os turnos possíveis para mudança. Basta passar o ID do curso atual.
        SELECT_TURNOS_POSSIVEIS_MUDANCA("SELECT * FROM curso WHERE cur_id=?"),
        
        //Seleciona todos as turmas possíveis para mudança. Basta passar o ID do curso atual.
        SELECT_TURMAS_POSSIVEIS_MUDANCA("SELECT * FROM curso WHERE cur_id=?"),
        
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
