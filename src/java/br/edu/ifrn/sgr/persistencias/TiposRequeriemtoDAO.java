/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.sgr.persistencias;

import br.edu.ifrn.sgr.modelos.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Luan Medeiros
 */
public class TiposRequeriemtoDAO extends GeralDAO {
    
    public static List<TipoRequerimento> getAlunos() throws SQLException, ClassNotFoundException{ //Feito por Luan
        List<TipoRequerimento> tiposRequerimentos =  new java.util.ArrayList<TipoRequerimento>();
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(EnuConsultaTipoRequerimento.SELECT_TIPOS_REQUERIMENTO.toString());
        ResultSet resultado = comando.executeQuery();        

        
        while (resultado.next()){
            tiposRequerimentos.add(new TipoRequerimento(resultado.getInt("tip_req_id"), resultado.getString("tip_req_nome")));
        }
        FabricaConexao.fecharConexao(con);
        return tiposRequerimentos;
    }
}
