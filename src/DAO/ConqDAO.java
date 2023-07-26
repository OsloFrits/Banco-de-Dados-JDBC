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
                ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,conq.getNome());
                ps.setString(2,conq.getDescri());
                ps.setInt(3,conq.getIDrelacao());

                int up = ps.executeUpdate();

                if(up > 0){
                    ResultSet rs = ps.getGeneratedKeys();
                    while(rs.next()){
                        int id = rs.getInt(1);
                        System.out.println("Cadastro concluido! foram inseridos com IDs = " + id + "\n");
                    }
                }else{
                    System.out.println("Nenhuma linha foi alterada");
                }
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                DB.closeStatement(ps);
                DB.closeConnection();
            }
    }
    public static String recuperarConq(){
        Statement st = null;
        ResultSet rs = null;
        String s = "";
        try{
            Connection conn = DB.getConexao();
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
