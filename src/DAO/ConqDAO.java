package DAO;

import Indentidades.Conquista;
import Conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConqDAO {
    /*public static void cadastrarConq(Conquista conq) {
        String sql = "INSERT INTO CONQUISTAS (nome, descri) VALUE (?, ?)";
        PreparedStatement ps = null;
            try {
                ps = Connection.getConn().prepareStatement(sql);
                ps.setString(1,conq.getNome());
                ps.setString(2,conq.getDescri());

                ps.execute();
                ps.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
    }
    *//*public static void recuperarConq(String nome){
        String sql = "";
        PreparedStatement ps = null;
        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.get
        }catch(SQLException e){
            e.printStackTrace();
        }
    }*/
}
