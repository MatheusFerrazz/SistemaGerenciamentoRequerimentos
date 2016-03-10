/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.sgr.persistencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author João
 */
public class GeralDAO {
    
    public void executarComando(String sql,Object...parametros) throws SQLException, ClassNotFoundException{
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);
        for (int i=1;i<=parametros.length;i++){
            comando.setObject(i, parametros[i-1]);
        }
        comando.executeUpdate();
        FabricaConexao.fecharConexao(con);
    }
    
    public ResultSet executarConsulta(String sql, Object...parametros) throws SQLException, ClassNotFoundException{
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(sql);
        for (int i=1;i<=parametros.length;i++){
            comando.setObject(i, parametros[i-1]);
        }
        ResultSet resultado = comando.executeQuery();
        FabricaConexao.fecharConexao(con);
        return resultado;
    }    
}
