/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.sgr.persistencias;

import java.util.List;
import br.edu.ifrn.sgr.modelos.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            consulta = geralDAO.executarConsulta(EnuConsultasAluno.SELECT_TODOS_PROFESSORES_DO_CURSO.toString(), 2);
        } catch (SQLException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(consulta.next())
        {
            System.out.println(consulta.getString("pes_nome"));
        }
    }
}
