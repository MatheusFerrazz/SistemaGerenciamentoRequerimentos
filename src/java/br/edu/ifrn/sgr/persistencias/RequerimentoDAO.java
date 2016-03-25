/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.sgr.persistencias;
import br.edu.ifrn.sgr.modelos.Aluno;
import br.edu.ifrn.sgr.modelos.Campus;
import br.edu.ifrn.sgr.modelos.Coordenador;
import br.edu.ifrn.sgr.modelos.Curso;
import br.edu.ifrn.sgr.modelos.Diretor;
import br.edu.ifrn.sgr.modelos.Disciplina;
import br.edu.ifrn.sgr.modelos.Ifrn;
import br.edu.ifrn.sgr.modelos.ModalidadeCurso;
import br.edu.ifrn.sgr.modelos.Permissao;
import br.edu.ifrn.sgr.modelos.Professor;
import br.edu.ifrn.sgr.modelos.Requerimento;
import br.edu.ifrn.sgr.modelos.RequerimentoPopuladoString;
import br.edu.ifrn.sgr.modelos.TecnicoAdministrativo;
import br.edu.ifrn.sgr.modelos.TipoDocumento;
import br.edu.ifrn.sgr.modelos.TipoRequerimento;
import br.edu.ifrn.sgr.modelos.Turma;
import br.edu.ifrn.sgr.modelos.Turno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author João
 */
public class RequerimentoDAO extends GeralDAO {

    private final String SELECT_ALUNO_BY_MATRICULA_SENHA = "select * from aluno "
                                              + "where matricula=? and senha=?;";

    private final String SELECT_ALUNOS = "select * from aluno;";
    
    public Aluno getAlunoByMatriculaSenha(String matricula, String senha) throws SQLException, ClassNotFoundException{
        ResultSet resultado = executarConsulta(SELECT_ALUNO_BY_MATRICULA_SENHA,matricula,senha);
       /* if (resultado.next())
            return popularAluno(resultado);
        else*/
            return null;
    }
    
    
        
        public int cadastraRequerimentoComRetornoID(String sql,Object...parametros) throws SQLException, ClassNotFoundException{
            Integer idGerado = null;
            Connection con = FabricaConexao.getConexao();
            PreparedStatement comando = con.prepareStatement(sql);
            for (int i=1;i<=parametros.length;i++){
                comando.setObject(i, parametros[i-1]);
            }
            ResultSet result = comando.executeQuery();
            FabricaConexao.fecharConexao(con);

            if(result.next())
            {
                idGerado = result.getInt("req_id");
            }

            return idGerado;
        }
        
    public void cadastraRequerimentoSemRetornoID(String sql,Object...parametros) throws SQLException, ClassNotFoundException{
        Connection con = FabricaConexao.getConexao();
        
        PreparedStatement comando = con.prepareStatement(sql);         
        for (int i=1;i<=parametros.length;i++){
            comando.setObject(i, parametros[i-1]);
        }
        comando.executeUpdate();
        FabricaConexao.fecharConexao(con);
    }        
    
//    public List<Aluno> getAlunos() throws SQLException, ClassNotFoundException{
//        ResultSet resultado = executarConsulta(SELECT_ALUNOS);
//        List<Aluno> alunos = new java.util.ArrayList();
//        while (resultado.next()){
//            alunos.add(popularAluno(resultado));
//        }
//        return alunos;
//    }
    
    public RequerimentoPopuladoString popularRequerimento(ResultSet resultado) throws SQLException{
            RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
        return null;
    }
    
    public RequerimentoPopuladoString populaAproveitaMentoDeEstudo(ResultSet resultado)
    {
        RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
        
        
        return requerimentoPopuladoString;
    }
    
        public RequerimentoPopuladoString populaCertificacaoDeConhecimento (ResultSet resultado)
    {
        RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
        
        
        return requerimentoPopuladoString;
    }
        
        //Popula reposicao atividade
        public RequerimentoPopuladoString populaReposicaoAtividade (ResultSet resultado)
    {
        RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
                
        return requerimentoPopuladoString;
    } 
        
        //Popula mudança de curso
        public RequerimentoPopuladoString populaMudancaCurso (ResultSet resultado)
    {
        RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
                
        return requerimentoPopuladoString;
    } 

        //Popula mudança de turma
        public RequerimentoPopuladoString populaMudancaTurma (ResultSet resultado)
    {
        RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
                
        return requerimentoPopuladoString;
    } 

        //Popula mudança de turno
        public RequerimentoPopuladoString populaMudancaTurno (ResultSet resultado)
    {
        RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
                
        return requerimentoPopuladoString;
    }

        //Popula tranferencia
        public RequerimentoPopuladoString populaTransferencia (ResultSet resultado)
    {
        RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
                
        return requerimentoPopuladoString;
    }

       //Popula lancamento revisao faltas, notas, situacao
        public RequerimentoPopuladoString populaLancamentoRevisaoFaltas (ResultSet resultado)
    {
        RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
                
        return requerimentoPopuladoString;
    }
        
       //Popula renovacao matricula
        public RequerimentoPopuladoString populaRenovacaoMatricula (ResultSet resultado)
    {
        RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
                
        return requerimentoPopuladoString;
    } 
        
       //Popula reabertura matricula
        public RequerimentoPopuladoString populaReaberturaMatricula (ResultSet resultado)
    {
        RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
                
        return requerimentoPopuladoString;
    }           

       //Popula outros
        public RequerimentoPopuladoString populaOutros (ResultSet resultado)
    {
        RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
                
        return requerimentoPopuladoString;
    }          

       //Popula justificativa de faltas
        public RequerimentoPopuladoString populaJustificativaDeFaltas (ResultSet resultado)
    {
        RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
                
        return requerimentoPopuladoString;
    }          

        //Popula trancamento de matricula
        public RequerimentoPopuladoString populaTrancamentoDeMatricula (ResultSet resultado)
    {
        RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
                
        return requerimentoPopuladoString;
    }       

        //Popula trancamento de matricula compusorio
        public RequerimentoPopuladoString populaTrancamentoDeMatriculaCompusorio (ResultSet resultado)
    {
        RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
                
        return requerimentoPopuladoString;
    }     
        
        //Popula cancelamento de matricula
        public RequerimentoPopuladoString populaCancelamentoDeMatricula (ResultSet resultado)
    {
        RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
                
        return requerimentoPopuladoString;
    }    

        //Popula atendimento docmicilar
        public RequerimentoPopuladoString populaAtendimentoDomiciliar (ResultSet resultado)
    {
        RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
                
        return requerimentoPopuladoString;
    }      

        //Popula dispensa de atividades
        public RequerimentoPopuladoString populaDispensaDeAtividades (ResultSet resultado)
    {
        RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
                
        return requerimentoPopuladoString;
    }    
        //Popula adequação de horários
        public RequerimentoPopuladoString populaAdequacaoHorarios (ResultSet resultado)
    {
        RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
                
        return requerimentoPopuladoString;
    } 
        
        //Popula estudo individualizado
        public RequerimentoPopuladoString populaEstudoIndividualizado (ResultSet resultado)
    {
        RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
                
        return requerimentoPopuladoString;
    } 

        //Popula inclusão de disciplinas
        public RequerimentoPopuladoString populaInclusaoDisciplinas (ResultSet resultado)
    {
        RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
                
        return requerimentoPopuladoString;
    }         

        //Popula remoção de disciplinas
        public RequerimentoPopuladoString populaRemocaoDisciplinas (ResultSet resultado)
    {
        RequerimentoPopuladoString requerimentoPopuladoString = new RequerimentoPopuladoString();
                
        return requerimentoPopuladoString;
    }  
        
        public int toInt(String num)
        {
            return Integer.parseInt(num);
        }          
    // Daqui para baixo vão os insertes de requeriment
      
}
