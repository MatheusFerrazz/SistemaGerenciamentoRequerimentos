/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.sgr.persistencias;

import java.util.List;
import br.edu.ifrn.sgr.modelos.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


/**
 *
 * @author Luan Medeiros
 */
public class teste { //Classe para testar métodos
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
      /*  List<TipoRequerimento> lista = null;
        try {
            lista = TiposRequeriemtoDAO.getAlunos();
        } catch (SQLException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(TipoRequerimento tipo : lista){            
            System.out.println(tipo.toString()+"\n");
        
        } */
        
        ResultSet consulta = null;
        GeralDAO geralDAO = new GeralDAO();
        AlunoDAO alunoDAO = new AlunoDAO();
        RequerimentoDAO requerimentoDAO =  new RequerimentoDAO();
        Aluno alu = null;
        try {
            consulta = geralDAO.executarConsulta(EnuConsultasAluno.SELECT_ALUNO_COMPLETO.toString(), "20142148000007");
            alu = alunoDAO.popularAluno(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }

            //System.out.println(consulta.getString("pes_nome"));
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");             
            System.out.println(sdf.format(alu.getDataNascimento()));
            
            ArrayList<RequerimentoPopuladoString> req = requerimentoDAO.populaAproveitaMentoDeEstudo(EnuConsultasRequerimento.SELECT_TODOS_REQUERIMENTOS_EM_ANDAMENTO_POR_TIPO_REQUERIMENTO_E_IDALUNO.toString(), 1, "20142148000001");
            System.out.println("TESTANDO: "+req.get(req.size()-1).getDataSolicitacaoRequerimento());
            
    }
}
