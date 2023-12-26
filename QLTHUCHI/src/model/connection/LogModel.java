
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
    
    public List<LogO> getAllLogGroup(int id_group,int month, int year){
        List<LogO> logsGroup = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select * from Log where Group_ID = ? and MONTH(Log.Date) = ? and YEAR(Log.Date) = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_group);
            preparedStatement.setInt(2, month);
            preparedStatement.setInt(3, year);
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
                     select ID,Name, u.Group_ID, Receipts, Expenses
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
                user.setReceipts(rs.getDouble("Receipts"));
                user.setExpenses(rs.getDouble("Expenses"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
//    public boolean deleteLog(int id_log) {
//        Connection connection = JDBCConnection.getJDBCConnection();
//        String sql = "DELETE FROM Log WHERE ID_Log = ?";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1, id_log);
//            int rowsAffected = preparedStatement.executeUpdate();
//            return rowsAffected > 0;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
        public boolean deleteLog(int id_log) {
        Connection connection = JDBCConnection.getJDBCConnection();
        String deleteLogSQL = "DELETE FROM Log WHERE ID_Log = ?";
        String deleteGroupLogSQL = "DELETE FROM Group_Log WHERE ID_Log = ?";

        try {
            // Xóa dữ liệu từ bảng Log
            PreparedStatement deleteLogStatement = connection.prepareStatement(deleteLogSQL);
            deleteLogStatement.setInt(1, id_log);
            int rowsAffectedLog = deleteLogStatement.executeUpdate();

            // Xóa dữ liệu từ bảng group_log
            PreparedStatement deleteGroupLogStatement = connection.prepareStatement(deleteGroupLogSQL);
            deleteGroupLogStatement.setInt(1, id_log);
            int rowsAffectedGroupLog = deleteGroupLogStatement.executeUpdate();

            // Trả về true nếu ít nhất một trong hai bảng có dữ liệu bị xóa
            return rowsAffectedLog > 0 || rowsAffectedGroupLog > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

     public void updateLogGroup(LogO log){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "update Log set Price=?, Note=?, Date=?, User_ID=?, Group_ID=? where ID_Log= ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, log.getPrice());
            preparedStatement.setString(2,log.getNote());
            String utilDate = Utils.convertToSqlDate(log.getDateString());
            preparedStatement.setString(3, utilDate);
            preparedStatement.setInt(4,log.getUser_ID());
            preparedStatement.setInt(5, log.getGroup_ID());
            preparedStatement.setInt(6, log.getID());
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
