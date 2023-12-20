
package model.connection;

import LoginSignup.Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
}
