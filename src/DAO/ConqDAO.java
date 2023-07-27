package DAO;

import Indentidades.Conquista;
import db.DB;
import db.DbIntegrityException;

import javax.swing.text.html.HTMLDocument;
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
    /*public static Conquista pesquisaConq(int id){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conquista conq = new Conquista();
        try{
            Connection conn = DB.getConexao();
            ps = conn.prepareStatement("SELECT FROM conquistas WHERE (IDrelacao = ?)");
            ps.setInt(1,id);

            rs = ps.executeQuery();

            conq.setIDrelacao(rs.getInt("id"));
            conq.setNome(rs.getString("Nome"));
            conq.setDescri(rs.getString("Descricao"));

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
            DB.closeConnection();
        }
        return conq;
    }*///A continuar
    public static  void deletarConq(int id){
        PreparedStatement ps = null;
        try{
            Connection conn = DB.getConexao();

            ps = conn.prepareStatement("DELETE FROM conquistas WHERE IDrelacao = ?");
            ps.setInt(1,id);
            ps.execute();

            System.out.println("DELETADO");
        }catch(SQLException e){
            throw new DbIntegrityException(e.getMessage());
        }finally {
            DB.closeStatement(ps);
            DB.closeConnection();
        }
    }
}
