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
            


    String senha1 = "";
    String senha2 = "";
    MessageDigest mDigest = null;
        try {
            mDigest = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    byte[] result = mDigest.digest("123456".getBytes());
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < result.length; i++) {
        sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
    }
        senha1= sb.toString();
        System.out.println("SENH: "+sb.toString());
       
    
    
    MessageDigest mDigest2 = null;
        try {
            mDigest2 = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException ex2) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex2);
        }    
    byte[] result2 = mDigest2.digest("123456".getBytes());
    StringBuffer sb2 = new StringBuffer();
    for (int j = 0; j < result.length; j++) {
        sb2.append(Integer.toString((result2[j] & 0xff) + 0x100, 16).substring(1));
    }
        senha2 = sb2.toString();
        System.out.println("SENH: "+sb.toString());       
    
      if(senha1.equals(senha2)) System.out.println("SÃO IGUAIS");
    
    }         
}
