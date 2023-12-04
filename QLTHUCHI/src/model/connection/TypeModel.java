/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.connection;


import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.objects.Types;

/**
 *
 * @author LENOVO
 */
public class TypeModel {
    public List<Types> getAllTypeExpenses(){
        List <Types> types = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select * from [dbo].[Type] where Receipts_Or_Expenses = 0";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Types type = new Types();
                type.setID_Type(rs.getInt("ID_Type"));
                type.setID_User(rs.getInt("ID_User"));
                type.setReceipts_Or_Expenses(rs.getBoolean("Receipts_Or_Expenses"));
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
}
