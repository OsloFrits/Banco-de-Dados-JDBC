package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    public static Connection getConn(){
           if (conn == null) {
               try {
               Properties props = loadProperties();
               String url = props.getProperty("db_url");
               conn = DriverManager.getConnection(url, props);
               return conn;
               }catch (SQLException e){
                   throw new DbException(e.getMessage());
               }
           }
       return conn;
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

    private static Properties loadProperties(){
        try (FileInputStream fs = new FileInputStream("db_properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        }catch(IOException e){
            throw new DbException(e.getMessage());
        }
    }
}
