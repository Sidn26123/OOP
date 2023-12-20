
package model.connection;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utils.ConfigFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.sql.PreparedStatement;
public class JDBCConnection {
    public static Connection getJDBCConnection(){
        ConfigFile c = new ConfigFile();
//<<<<<<< HEAD
////<<<<<<< HEAD
//        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=QLTHUCHI;encrypt = true;trustServerCertificate=true";
//        String user = "sa";
//        String password = "123456789";
//
//=======
        if (c.getDB() == "SQLServer"){
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=QLTHUCHI;encrypt = true;trustServerCertificate=true";
        String user = "sa";
        String password = "123456789";
   
        try {
            Connection connection = DriverManager.getConnection(url,user, password);
            System.out.println("Connect successful");
            return connection;
        } catch (SQLException e) {
            System.out.println("Opp, there is a error!");
            e.printStackTrace();
        }
        return null;
        }
        else{
        Connection con = null;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop", "nguyenuy", "2612");
            return con;
        }
        catch(Exception e){
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, e);
            return con;
        }
    }   
}
}