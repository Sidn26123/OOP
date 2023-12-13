<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.objects;

/**
 *
 * @author sidac
 */
public class Types {
=======
package models;
import java.sql.Connection;
import Utils.Utils;
import Utils.MyJDBCFuncLib;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
public class Types {
    public Connection getConnection() {
        MyJDBCFuncLib myJDBCFuncLib = new MyJDBCFuncLib();
        return myJDBCFuncLib.getConnection();
    }

    public void createTable() {
        Connection con = getConnection();
        String createTableSQL = "CREATE TABLE Category (" +
                                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                                "name NVARCHAR(255), " +
                                "color NVARCHAR(255), " + 
                                "icon_path NVARCHAR(255), " +
                                "type INT)";
        try (PreparedStatement ps = con.prepareStatement(createTableSQL)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // public void addItemCategorys(String name) {
    //     if (name == null) {
    //         return;
    //     }
    //     MyJDBCFuncLib myJDBCFuncLib = new MyJDBCFuncLib();
    //     Connection con = myJDBCFuncLib.getConnection();
    //     String sql = "INSERT INTO Category (name) VALUES (?)";
    //     try {
    //         PreparedStatement ps = con.prepareStatement(sql);
    //         ps.setString(1, name);
    //         ps.executeUpdate();
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }
>>>>>>> 0f18cb3521e2502f23fddfc7e1eceb9367e98437
    
    public void clearData(){
        String sql = "DELETE FROM Category";
        Connection con = getConnection();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteDataTable(String tableName, String condition){
        String sql = "";
        if (condition == null) {
            sql = "DELETE FROM Category";
        }
        else{
            sql = "DELETE FROM Category" +
                 "WHERE " + condition;
        }
        Connection con = getConnection();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertData(Object[][] dataToInsert){
        String sql = "INSERT INTO Category (name, color, icon_path, type) VALUES (?, ?, ?, ?);";
        Connection con = getConnection();

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            // Dữ liệu muốn chèn vào bảng
            // Duyệt qua mảng dữ liệu và chèn từng hàng vào bảng
            for (Object[] rowData : dataToInsert) {
                for (int i = 0; i < rowData.length; i++) {
                    preparedStatement.setObject(i + 1, rowData[i]);
                }

                // Thực thi câu lệnh SQL để chèn dữ liệu
                preparedStatement.executeUpdate();
            }

            System.out.println("Dữ liệu đã được thêm vào bảng.");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public Vector<Object[]> getData(){
        String sql = "SELECT * FROM Category";
        Connection con = getConnection();
        Vector<Object[]> dataVector = new Vector<>();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            try (ResultSet resultSet = ps.executeQuery(sql)){
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String color = resultSet.getString("color");
                    String iconPath = resultSet.getString("icon_path");
                    int type = resultSet.getInt("type");
                    dataVector.add(new Object[]{id, name, color, iconPath, type});
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return dataVector;
    }
    public Object[][] getSpecData(int idToGet){
        Object[][] ans = null;
        String sql = "SELECT * FROM Log " +
                    "WHERE category_id = '" + idToGet+"'";
        Connection con = getConnection();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            try (ResultSet resultSet = ps.executeQuery(sql)){
                List<Integer> idList = new ArrayList<>();
                List<String> nameList = new ArrayList<>();
                List<String> colorList = new ArrayList<>();
                List<String> iconPathList = new ArrayList<>();
                List<Integer> CategoryList = new ArrayList<>();
                while (resultSet.next()){
                    // int id = resultSet.getInt("id");
                    // String name = resultSet.getString("name");
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String color = resultSet.getString("color");
                    String iconPath = resultSet.getString("icon_path");
                    int Category = resultSet.getInt("type");
                    idList.add(id);
                    nameList.add(name);
                    colorList.add(color);
                    iconPathList.add(iconPath);
                    CategoryList.add(Category);
                    // Xử lý dữ liệu theo ý muốn của bạn
                    // System.out.println("ID: " + id + ", Name: " + name + ", Color: " + color +
                                    //    ", Icon Path: " + iconPath + ", Category: " + Category);
                }
                ans = new Object[idList.size()][5];
                for (int i = 0; i < idList.size(); i++) {
                    ans[i][0] = idList.get(i);
                    ans[i][1] = nameList.get(i);
                    ans[i][2] = colorList.get(i);
                    ans[i][3] = iconPathList.get(i);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        };
        return ans;
    }

    public void printData(){
        String sql = "SELECT * FROM Category";
        Connection con = getConnection();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            try (ResultSet resultSet = ps.executeQuery(sql)){
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String color = resultSet.getString("color");
                    String iconPath = resultSet.getString("icon_path");
                    int type = resultSet.getInt("type");
                    System.out.println("ID: " + id + ", Name: " + name + ", Color: " + color +
                                       ", type: " + type);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void dropTable(){
        String sql = "DROP TABLE Category";
        Connection con = getConnection();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
