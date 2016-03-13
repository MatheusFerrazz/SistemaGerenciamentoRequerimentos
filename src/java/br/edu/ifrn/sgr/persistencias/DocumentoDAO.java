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
public class DocumentoDAO extends GeralDAO {
    
    public List<Documento> getDocumentos() throws SQLException, ClassNotFoundException{ //Feito por Luan
        List<Documento> documentos =  new java.util.ArrayList<Documento>();
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement(EnuConsultasDocumento.SELECT_TODOS_DOCUMENTOS.toString());
        ResultSet resultado = comando.executeQuery();                
        while (resultado.next()){
            documentos.add(new Documento(resultado.getString("doc_apr_nome"), resultado.getInt("doc_apr_id_PK")));            
        }
        FabricaConexao.fecharConexao(con);
        return documentos;
    }
}
