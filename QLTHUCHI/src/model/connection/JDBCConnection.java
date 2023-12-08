
package model.connection;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class JDBCConnection {
    public static Connection getJDBCConnection(){
//<<<<<<< HEAD
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=QLTC;encrypt = true;trustServerCertificate=true";
        String user = "sa";
        String password = "sa";

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
    
}