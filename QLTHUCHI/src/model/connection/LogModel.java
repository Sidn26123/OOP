/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.connection;


import LoginSignup.Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import model.objects.LogO;
import Utils.Utils;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author LENOVO
 */
public class LogModel {
    public void addLog(LogO log){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "insert into Log (ID_Type, Price, Note, Date, User_ID) values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, log.getID_Type());
            preparedStatement.setDouble(2, log.getPrice());
            preparedStatement.setString(3,log.getNote());
            String utilDate = Utils.convertToSqlDate(log.getDateString());
//            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
           
            preparedStatement.setString(4, utilDate);
            preparedStatement.setInt(5,log.getUser_ID());
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addLogGroup(LogO log){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "insert into Log (ID_Type, Price, Note, Date, User_ID, Group_ID) values(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, log.getID_Type());
            preparedStatement.setDouble(2, log.getPrice());
            preparedStatement.setString(3,log.getNote());
            String utilDate = Utils.convertToSqlDate(log.getDateString());
            preparedStatement.setString(4, utilDate);
            preparedStatement.setInt(5,log.getUser_ID());
            preparedStatement.setInt(6, log.getGroup_ID());
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<LogO> getAllLogGroup(int id_group){
        List<LogO> logsGroup = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select * from Log where Group_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_group);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                LogO log = new LogO();
                log.setUser_ID(rs.getInt("User_ID"));
                log.setID_Type(rs.getInt("ID_Type"));
                log.setPrice(rs.getDouble("Price"));
                log.setNote(rs.getString("Note"));
                log.setDateString(rs.getDate("Date").toString());
                log.setGroup_ID(id_group);
                log.setID_Log(rs.getInt("ID_Log"));
                logsGroup.add(log);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logsGroup;
    }
    public int getID_Log(){
        int id_log = -1;
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = """
                     select Top 1 id_log from Log
                     order by id_log desc
                     """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                id_log = rs.getInt("ID_Log");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id_log;
    }
    public User getInfoUserbyLog(int id_log){
        User user = new User();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = """
                     select ID,Name, u.Group_ID, Receipt, Expenses
                     from [dbo].[User] as u
                     join [dbo].[Log] as l
                     on u.ID = l.User_ID
                     where l.ID_Log = ?
                     """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_log);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                user.setID(rs.getInt("ID"));
                user.setName(rs.getString("Name"));
                user.setGroup_ID(rs.getInt("Group_ID"));
                user.setReceipts(rs.getDouble("Receipt"));
                user.setExpenses(rs.getDouble("Expenses"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
