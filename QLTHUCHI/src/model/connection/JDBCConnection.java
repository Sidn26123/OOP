/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.connection;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class JDBCConnection {
    public static Connection getJDBCConnection(){
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
    
}