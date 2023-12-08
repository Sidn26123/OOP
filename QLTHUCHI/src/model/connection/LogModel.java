/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.connection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import model.objects.Logs;

/**
 *
 * @author LENOVO
 */
public class LogModel {
    public void addLog(Logs log){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "insert into Log (ID_Type, Price, Note, Date) values(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, log.getID_Type());
            preparedStatement.setDouble(2, log.getPrice());
            preparedStatement.setString(3,log.getNote());
            Date utilDate = log.getDatesString();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            preparedStatement.setDate(4, sqlDate);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
