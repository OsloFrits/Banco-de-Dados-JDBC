package db;

import java.sql.*;

public class DB {
    private static final String url = "jdbc:mysql://localhost:3306/testedb";
    private static final String user = "root";
    private static final String password = "Dudu2106";
    private static Connection conn = null;

    public static Connection getConexao(){
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            }else{
                return conn;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(){
        if(conn != null){
            try {
                conn.close();
            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement st){
        if(st != null){
            try{
                st.close();
            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }
    public static void closeResultSet(ResultSet rs){
        if(rs != null){
            try{
                rs.close();
            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }
}
