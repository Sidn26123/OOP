package model.connection;


import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.objects.TypeO;

public class TypeModel {
    public List<TypeO> getAllTypeExpenses(int ID_User){
        List <TypeO> types = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select * from [dbo].[Type] where (ID_User = ? OR ID_User = -1) and (Receipts_Or_expenses = 0)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ID_User);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                TypeO type = new TypeO();
                type.setID_Type(rs.getInt("ID_Type"));
                type.setID_User(rs.getInt("ID_User"));
                type.setReceipts_Or_Expenses(rs.getInt("Receipts_Or_Expenses"));
                type.setName_Type(rs.getString("Name_Type"));
                type.setIcon_Path(rs.getString("Icon_Path"));
                type.setColor(rs.getString("Color"));
                type.setID_Budget(rs.getInt("ID_Budget"));
                types.add(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return types;
    }
    public List<TypeO> getAllTypeReceipt(){
        List <TypeO> types = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select * from [dbo].[Type] where Receipts_Or_Expenses = 1";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                TypeO type = new TypeO();
                type.setID_Type(rs.getInt("ID_Type"));
                type.setID_User(rs.getInt("ID_User"));
                type.setReceipts_Or_Expenses(rs.getInt("Receipts_Or_Expenses"));
                type.setName_Type(rs.getString("Name_Type"));
                type.setIcon_Path(rs.getString("Icon_Path"));
                type.setColor(rs.getString("Color"));
                type.setID_Budget(rs.getInt("ID_Budget"));
                types.add(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return types;
    }
    public TypeO findTypebyID(int id_type){
        TypeO type = new TypeO();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select * from Type where ID_Type = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_type);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                type.setID_Type(id_type);
                type.setID_User(rs.getInt("ID_User"));
                type.setReceipts_Or_Expenses(rs.getInt("Receipts_Or_Expenses"));
                type.setName_Type(rs.getString("Name_Type"));
                type.setIcon_Path(rs.getString("Icon_Path"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }
}
