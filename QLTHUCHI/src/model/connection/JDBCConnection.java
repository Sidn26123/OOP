
package model.connection;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class JDBCConnection {
    public static Connection getJDBCConnection(){
<<<<<<< HEAD
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=QLCT;encrypt = true;trustServerCertificate=true";
        String user = "sa";
        String password = "sa";
=======
<<<<<<< HEAD
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=QLCT;encrypt = true;trustServerCertificate=true";
        String user = "sa";
        String password = "sa";
=======
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=QLTHUCHI;encrypt = true;trustServerCertificate=true";
        String user = "sa";
        String password = "123456789";
>>>>>>> 5700697411fd1d0c4908684aa132beb38c23a87c
>>>>>>> 983b3f9fd0fd7b2a442444b19ecb715fb0b7cf3e
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