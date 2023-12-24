
package model.connection;

import LoginSignup.Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.objects.Price_Group;

public class FamilyModel {
    public List<User> getUsersGroup(int id_user){
        List<User> usersGroup = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = """
                     select * 
                     from [dbo].[User] as u
                     join [dbo].[Group_User] as gu
                     on u.Group_ID = gu.ID_Group
                     where u.Group_ID = (
                     \tselect u.Group_ID
                     \tfrom [dbo].[User] as u
                     \twhere u.ID = ?
                     )""";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_user);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                User user = new User(
                        rs.getInt("ID"),
                        rs.getString("Name"),
                        rs.getInt("Group_ID"),
                        rs.getString("EmailAddress"),
                        rs.getDouble("Receipts"),
                        rs.getDouble("Expenses")
                );
                usersGroup.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersGroup;
    }
    
    public int getIdGroup(int id_user){
        int id_group = -1;
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select Group_ID from [dbo].[User] where ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_user);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                id_group = rs.getInt("Group_ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id_group;
    }
    public void addTypeGroup(int id_user, int id_log){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "insert into Group_Log (ID_Log, ID_User_Expenses) values (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_log);
            preparedStatement.setInt(2, id_user);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<List<String>> getNameUserChoice(int id_log){
        List<List<String>> ls_userChoice = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = """
                     select u.ID, Name
                     from [dbo].[User] as u
                     join [dbo].[Group_Log] as gl
                     on u.ID = gl.ID_User_Expenses
                     where gl.ID_Log = ?
                     """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_log);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                List<String> tmp_ls = new ArrayList<>();
                tmp_ls.add(String.valueOf(rs.getInt("ID")));
                tmp_ls.add(rs.getString("Name"));
                ls_userChoice.add(tmp_ls);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ls_userChoice;
    }
    public String getNameGroup(int id_group){
        String name_group = "";
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select Name_Group from [dbo].[Group_User] where ID_Group = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_group);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                name_group = rs.getString("Name_Group");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name_group;
    }
    public void setOutGroup(int id_user){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "update [User] set Group_ID = ? where ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setNull(1, -1);
            preparedStatement.setInt(2, id_user);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean is_HostGroupUser(int id_user, int id_group){
        int id_host = 0;
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = """
                     select gu.HostID
                     from Group_User as gu 
                     where gu.ID_Group = ?
                     """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_group);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                id_host = rs.getInt("HostID");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id_host == id_user;
    }
    
    public int add_member_toGroup(int id_user, int id_group){
        int rs = -1;
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "update [User] set Group_ID = ? where ID = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_group);
            preparedStatement.setInt(2, id_user);
            rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public boolean is_user_had_group(int id_user){
        int id_group = 0;
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select Group_ID from [User] where ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_user);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                id_group = rs.getInt("Group_ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  id_group != 0;
    }
    public List<User> getAllUser(){
        List<User> users = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select * from [User]";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setID(rs.getInt("ID"));
                user.setName(rs.getString("Name"));
                user.setUserName(rs.getString("UserName"));
                user.setGroup_ID(rs.getInt("Group_ID"));
                user.setEmailAddress(rs.getString("EmailAddress"));
                
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    public void setID_Host(int id_user, int id_group){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "update [Group_User] set HostID = ? where ID_Group = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_user);
            preparedStatement.setInt(2, id_group);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Price_Group> getPrice_Group(int id_group, int month, int year){
        List<Price_Group> lsPrice_Group = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = """
                     select gl.ID_Log, gl.ID_User_Expenses,tmp.price_per_user, l.Date, l.User_ID,l.Group_ID
                     from Group_Log as gl
                     join (
                     	select COUNT(l.ID_Log) as num_log, l.ID_Log, l.Price/COUNT(l.ID_Log) as price_per_user
                     	from Log as l
                     	join Group_Log as gl
                     	on l.ID_Log = gl.ID_Log
                     	group by l.ID_Log, l.Price
                     )  as tmp
                     on gl.ID_Log = tmp.ID_Log
                     join Log as l
                     on l.ID_Log = gl.ID_Log
                     where l.Group_ID = ? and MONTH(l.Date) = ? and YEAR(l.Date) = ?
                     """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_group);
            preparedStatement.setInt(2, month);
            preparedStatement.setInt(3, year);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Price_Group price_Group = new Price_Group();
                price_Group.setID_Log(rs.getInt("ID_Log"));
                price_Group.setID_User_Expenses(rs.getInt("ID_User_Expenses"));
                price_Group.setPrice_per_user(rs.getDouble("price_per_user"));
                price_Group.setDate(String.valueOf(rs.getDate("Date")));
                price_Group.setUser_ID(rs.getInt("User_ID"));
                price_Group.setGroup_ID(rs.getInt("Group_ID"));
                
                lsPrice_Group.add(price_Group);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lsPrice_Group;
    }
}
