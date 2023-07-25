package DAO;

import Indentidades.Conquista;
import db.DB;

import java.sql.*;

public class ConqDAO {
    public static void cadastrarConq(Conquista conq) {
        Connection conn = DB.getConexao();
        String sql = "INSERT INTO CONQUISTAS (Nome, Descricao, IDrelacao) VALUE (?, ?, ?)";
        PreparedStatement ps = null;
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1,conq.getNome());
                ps.setString(2,conq.getDescri());
                ps.setInt(3,conq.getIDrelacao());

                ps.execute();
                ps.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
    }
    public static String recuperarConq(){
        Connection conn = DB.getConexao();
        Statement st = null;
        ResultSet rs = null;
        String s = "";
        try{
            st = conn.createStatement();
            rs = st.executeQuery("select * from conquistas");

            while(rs.next()) {

                s = s + rs.getInt("id") + "-" + rs.getString("Nome") + ", " + rs.getString("Descricao") + "\n";
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }
        return s;
    }
}
