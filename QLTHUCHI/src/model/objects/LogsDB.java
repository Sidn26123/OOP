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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.plaf.nimbus.State;
import Utils.Utils;
import java.sql.Date;
//import model.JDBCConnection;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;
import model.connection.JDBCConnection;
public class LogsDB {
    public Connection getConnection(){
        JDBCConnection myJDBCFuncLib = new JDBCConnection();
        return myJDBCFuncLib.getJDBCConnection();
    }

    //create table
    public void createTable(){
        Connection con = getConnection();
        String createTableSQL = "CREATE TABLE Log (" +
        "id INT AUTO_INCREMENT PRIMARY KEY," +
        "category_id INT," +  // Thêm trường category_id để tham chiếu đến bảng Category
        "FOREIGN KEY (category_id) REFERENCES Category(id)," +  // Đặt đúng vị trí của dấu đóng ngoặc
        "amount INT," +
        "note NVARCHAR(255)," +
        "date DATE,"+ 
        "date_created DATETIME DEFAULT CURRENT_TIMESTAMP);";
        try(PreparedStatement ps = con.prepareStatement(createTableSQL)){
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //get data
    /**
     * Lấy toàn bộ dữ liệu từ bảng Log
     */
    public Object[][] getData(){
        Connection con = getConnection();
        String countSql = "SELECT COUNT(*) AS row_count FROM Log";
        int rowCount = 0;
        try (PreparedStatement countStatement = con.prepareStatement(countSql)) {
            try (ResultSet countResult = countStatement.executeQuery()) {
                if (countResult.next()) {
                    rowCount = countResult.getInt("row_count");
                }
            }
        }
        catch(Exception e){
            ;
        }
        Object[][] ans = new Object[rowCount][6];
        String sql = "SELECT * FROM Log";
        int i = 0;
        try(PreparedStatement ps = con.prepareStatement(sql)){
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    // s += "ID: " + rs.getInt("id") +", cateID: " + rs.getInt("category_id") + ", Amount: " + rs.getInt("amount") +
                    //                     ", Note: " + rs.getString("note") + ", Date Created: " + rs.getString("date_created") + "\n";
                    ans[i][0] = rs.getInt("id");
                    ans[i][1] = rs.getInt("category_id");
                    ans[i][2] = rs.getInt("amount");
                    ans[i][3] = rs.getString("note");
                    ans[i][4] = rs.getString("date_created");
                    ans[i][5] = rs.getString("date");
                    i++;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        // String s = "";
        // for (Object[] item : ans) {
        //     s += "ID: " + item[0] +", cateID: " + item[1] + ", Amount: " + item[2] +
        //                     ", Note: " + item[3] + ", Date : " + item[5] + "\n";
        // }
        return ans;
    }
    
    public void printDatas(){
        String s = "";
        Object[][] datas = getData();
        for (Object[] item : datas) {
            s = "ID: " + item[0] +", cateID: " + item[1] + ", Amount: " + item[2] +
                            ", Note: " + item[3] + ", Date Created: " + item[5] + "\n";
                                    System.out.println(s);

        }
    }

    /**
     * Lấy dữ liệu từ bảng Log theo ngày
     * @param date (dd/MM/yyyy)
     * @return
     */
    public Object[][] getData(String date){
        Connection con = getConnection();
        String countSql = "SELECT COUNT(*) AS row_count FROM Log "+
                        "WHERE date = '"+Utils.convertToSqlDate(date)+"'";
        int rowCount = 0;
        try (PreparedStatement countStatement = con.prepareStatement(countSql)) {
            try (ResultSet countResult = countStatement.executeQuery()) {
                if (countResult.next()) {
                    rowCount = countResult.getInt("row_count");
                }
            }
        }
        catch(Exception e){
            ;
        }
        Object[][] ans = new Object[rowCount][5];
        String sql = "SELECT * FROM Log "+
                    "WHERE date = '"+Utils.convertToSqlDate(date)+"'";
        int i = 0;
        try(PreparedStatement ps = con.prepareStatement(sql)){
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    // s += "ID: " + rs.getInt("id") +", cateID: " + rs.getInt("category_id") + ", Amount: " + rs.getInt("amount") +
                    //                     ", Note: " + rs.getString("note") + ", Date Created: " + rs.getString("date_created") + "\n";
                    ans[i][0] = rs.getInt("id");
                    ans[i][1] = rs.getInt("category_id");
                    ans[i][2] = rs.getInt("amount");
                    ans[i][3] = rs.getString("note");
                    ans[i][4] = rs.getString("date_created");
                    i++;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        String s = "";
        for (Object[] item : ans) {
            s += "ID: " + item[0] +", cateID: " + item[1] + ", Amount: " + item[2] +
                            ", Note: " + item[3] + ", Date Created: " + item[4] + "\n";
        }
        return ans;
    }
    public Object[][] getData(String date, int id){
        Connection con = getConnection();
        String countSql = "SELECT COUNT(*) AS row_count FROM Log "+
                        "WHERE date = '"+Utils.convertToSqlDate(date)+"' " +
                        "AND category_id = " + id;
        int rowCount = 0;
        try (PreparedStatement countStatement = con.prepareStatement(countSql)) {
            try (ResultSet countResult = countStatement.executeQuery()) {
                if (countResult.next()) {
                    rowCount = countResult.getInt("row_count");
                }
            }
        }
        catch(Exception e){
            ;
        }
        Object[][] ans = new Object[rowCount][5];
        String sql = "SELECT * FROM Log "+
                        "WHERE date = '"+Utils.convertToSqlDate(date)+"' " +
                        "AND category_id = " + id;
        int i = 0;
        try(PreparedStatement ps = con.prepareStatement(sql)){
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    // s += "ID: " + rs.getInt("id") +", cateID: " + rs.getInt("category_id") + ", Amount: " + rs.getInt("amount") +
                    //                     ", Note: " + rs.getString("note") + ", Date Created: " + rs.getString("date_created") + "\n";
                    ans[i][0] = rs.getInt("id");
                    ans[i][1] = rs.getInt("category_id");
                    ans[i][2] = rs.getInt("amount");
                    ans[i][3] = rs.getString("note");
                    ans[i][4] = rs.getString("date_created");
                    i++;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        String s = "";
        for (Object[] item : ans) {
            s += "ID: " + item[0] +", cateID: " + item[1] + ", Amount: " + item[2] +
                            ", Note: " + item[3] + ", Date Created: " + item[4] + "\n";
        }
        return ans;
    }
    public Vector<LogO> getDataV(String date, int id){
        Connection con = getConnection();
        String countSql = "SELECT COUNT(*) AS row_count FROM Log "+
                        "WHERE date = '"+Utils.convertToSqlDate(date)+"' " +
                        "AND category_id = " + id;
        int rowCount = 0;
        try (PreparedStatement countStatement = con.prepareStatement(countSql)) {
            try (ResultSet countResult = countStatement.executeQuery()) {
                if (countResult.next()) {
                    rowCount = countResult.getInt("row_count");
                }
            }
        }
        catch(Exception e){
            ;
        }
        // Object[][] ans = new Object[rowCount][5];
        Vector<LogO> ans = new Vector<LogO>();
        String sql = "SELECT * FROM Log "+
                        "WHERE date = '"+Utils.convertToSqlDate(date)+"' " +
                        "AND category_id = " + id;
        int i = 0;
        try(PreparedStatement ps = con.prepareStatement(sql)){
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    // s += "ID: " + rs.getInt("id") +", cateID: " + rs.getInt("category_id") + ", Amount: " + rs.getInt("amount") +
                    //                     ", Note: " + rs.getString("note") + ", Date Created: " + rs.getString("date_created") + "\n";
                    // ans[i][0] = rs.getInt("id");
                    // ans[i][1] = rs.getInt("category_id");
                    // ans[i][2] = rs.getInt("amount");
                    // ans[i][3] = rs.getString("note");
                    // ans[i][4] = rs.getString("date_created");

                    // i++;
                    ans.add(new LogO(rs.getInt("id"), rs.getInt("category_id"), rs.getInt("amount"), rs.getString("note"), rs.getString("date")));
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        String s = "";

        return ans;
    }
    /**
     * Lọc transaction theo các điều kiện và sắp xếp theo các điều kiện
     * @param conditions Vector<String>
     * @param orders Vector<String>
     * @return Object[][]
     */
    public Vector<Object[]> getDataWithCondition(Vector<String> conditions, Vector<String> orders){
        Vector<Object[]> ans = null;
        Connection con = getConnection();
        String whereString  = "";
        String orderString = "";
        if (conditions.size() > 0){
            whereString = "WHERE ";
            for (int i = 0; i < conditions.size(); i++) {
                whereString += conditions.get(i);
                if (i != conditions.size() - 1){
                    whereString += " AND ";
                }
            }
        }
        if (orders.size() > 0){
            orderString = "ORDER BY ";
            for (int i = 0; i < orders.size(); i++) {
                orderString += orders.get(i);
                if (i != orders.size() - 1){
                    orderString += ", ";
                }
            }
        }

        String sql = "SELECT * FROM Log "+ whereString + " " + orderString;
        System.out.println(sql);
        try(PreparedStatement ps = con.prepareStatement(sql)){
            try (ResultSet rs = ps.executeQuery()){
                ans = new Vector<Object[]>();
                while (rs.next()){
                    Object[] item = new Object[6];
                    item[0] = rs.getInt("id");
                    item[1] = rs.getInt("category_id");
                    item[2] = rs.getInt("amount");
                    item[3] = rs.getString("note");
                    item[4] = rs.getString("date_created");
                    System.out.println(item[5]);
                    ans.add(item);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return ans;
    }

    public void insertData(Object[] dataToInsert){
        String sql = "INSERT INTO Log (category_id, amount, note, date) VALUES (?, ?, ?, ?)";
        Connection con = getConnection();
        try (PreparedStatement ps = con.prepareStatement(sql)){
            if (dataToInsert[3] == null || dataToInsert[3] == "" || dataToInsert.length == 3){
                dataToInsert[3] = Utils.getCurrentDateFormatted();
            }
            else{
                dataToInsert[3] = Utils.convertToSqlDate((String) dataToInsert[3]);
            }
            for (int i = 0; i < dataToInsert.length; i++) {
                ps.setObject(i + 1, dataToInsert[i]);
            }
            // Thực thi câu lệnh SQL để chèn dữ liệu
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
 
    //insert data
    public void insertData(Object[][] dataToInsert){
        String sql = "INSERT INTO Log (category_id, amount, note, date) VALUES (?, ?, ?, ?)";
        Connection con = getConnection();
        try (PreparedStatement ps = con.prepareStatement(sql)){
            for (Object[] rowData : dataToInsert) {
                if (rowData[3] == null || rowData[3] == "" || rowData.length == 3){
                    rowData[3] = Utils.getCurrentDateFormatted();
                }
                else{
                    rowData[3] = Utils.convertToSqlDate((String) rowData[3]);
                }
                for (int i = 0; i < rowData.length; i++) {
                    ps.setObject(i + 1, rowData[i]);
                }
                // Thực thi câu lệnh SQL để chèn dữ liệu
                ps.executeUpdate();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Xóa toàn bộ dữ liệu trong bảng Log
     */
    public void clearData(){
        Connection con = getConnection();
        String sql = "DELETE FROM Log";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //drop table
    public void dropTable(){
        Connection con = getConnection();
        String sql = "DROP TABLE Log";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    //get sum
    public int getSpecSum(String date, int item){
        String sqlDate = Utils.convertToSqlDate(date);
        Connection con = getConnection();
        String sql = "SELECT SUM(amount) FROM Log " +
                    "WHERE amount > 0 AND date = '"+sqlDate +"' " +
                    "AND category_id = " + item +
                    " GROUP BY DATE(date)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                // Lặp qua kết quả nếu có
                while (rs.next()) {
                    // Lấy giá trị từ cột đầu tiên (trong trường hợp này, SUM(amount))
                    double sumAmount = rs.getInt(1);
                    return (int) sumAmount;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * Lấy tổng số tiền của date của category đầu tiên được query từ table theo type
     * @param date
     * @param type
     * @return
     */
    public Object[] getFirstItemInCateWithTypeSum(String date, int type){
        String sqlDate = Utils.convertToSqlDate(date);
        Connection con = getConnection();
        String preSql = "SELECT id FROM Category WHERE type = '"+ type +"' LIMIT 1";

        ResultSet rs1 = null;
        int firstCateID = 0;
        Object[] ans = new Object[2];
        // try{
        //     Statement st = con.createStatement();
        //     rs1 = st.executeQuery(preSql);
        //     firstCateID = rs1.getInt(1);
        // }
        // catch(Exception e){
        //     e.printStackTrace();
        // }
        try (PreparedStatement ps = con.prepareStatement(preSql)) {
            try (ResultSet rs = ps.executeQuery()) {
                // Lặp qua kết quả nếu có
                while (rs.next()) {
                    // Lấy giá trị từ cột đầu tiên (trong trường hợp này, SUM(amount))
                    firstCateID = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "SELECT SUM(amount), category_id, type FROM Log " +
                    "INNER JOIN Category AS C ON Log.category_id = C.id " +
                    "WHERE C.id = '"+ firstCateID+"' AND date = '"+sqlDate +"' "+
                    "GROUP BY DATE(date)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                // Lặp qua kết quả nếu có
                while (rs.next()) {
                    // Lấy giá trị từ cột đầu tiên (trong trường hợp này, SUM(amount))
                    int sumAmount = rs.getInt(1);
                    int cateID = rs.getInt(2);
                    ans = new Object[]{sumAmount, cateID};
                    return ans;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ans[0] = 0;
        ans[1] = firstCateID;
        return ans;
    }
    //get type sum
    public int getTypeSum(String date, int type){
        String sqlDate = Utils.convertToSqlDate(date);
        Connection con = getConnection();
        String sql = "SELECT SUM(amount) FROM Log " +
                    "WHERE amount > 0 AND date = '"+sqlDate +"' " +
                    "AND type = " + type +
                    " GROUP BY DATE(date)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                // Lặp qua kết quả nếu có
                while (rs.next()) {
                    // Lấy giá trị từ cột đầu tiên (trong trường hợp này, SUM(amount))
                    double sumAmount = rs.getInt(1);
                    return (int) sumAmount;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }



    public Object[][] getGeneralInfoOfDates(String dateStartInput, String dateEndInput){
        int n = Utils.calDateDiffBetweenToDate(dateStartInput, dateEndInput, "dd/MM/yyyy")+1; //Số ngày giữa 2 ngày
        Object[][] rawData = new Object[2*n][3]; //2*n vì có 2 loại giao dịch trong 1 ngày
        Connection con = getConnection();
        String startDate = Utils.convertToSqlDate(dateStartInput);
        String endDate = Utils.convertToSqlDate(dateEndInput);
        // String tempDate = startDate;
        // int tempType = 0;
        // int count = 0;
        int i = 0;
        String endRawDataDate = "";

        String sql = "SELECT SUM(T.amount), C.type, T.date " +
        "FROM Log T " +
        "INNER JOIN Category C ON C.id = T.category_id " +
        "WHERE T.date >= '" + startDate + "' AND T.date <= '" + endDate + "' " + 
        "GROUP BY C.type, T.date" + 
        " ORDER BY T.date";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while(rs.next()){
                    double sumAmount = rs.getInt(1);
                    int type = rs.getInt(2);
                    String curDate = rs.getString(3);
                    rawData[i][0] = (int)sumAmount;
                    rawData[i][1] = type;
                    rawData[i][2] = Utils.convertSqlDateToString(curDate);
                    endRawDataDate = rawData[i][2].toString(); //Lấy ngày cuối cùng trong rawData (được cập nhật lần cuối thì đó là ngày cuối)
                    // System.out.println("i: " + i + " type: " + type + " sum: " + sumAmount + " date: " + Utils.convertSqlDateToString(curDate));
                    i++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // for (Object[] item : rawData) {
        //     System.out.println("Amount: "  + item[0].toString() + " type: " + item[1].toString() + " " + item[2]);
        // }

        Object[][] ans = new Object[n][3]; //ans có dạng 1 mảng, mỗi ptu có dạng [tổng thu, tổng chi, ngày (dd/MM/yyyy)]
        for (i=0; i < n; i++){
            ans[i][0] = 0; //thu
            ans[i][1] = 0; //chi
            ans[i][2] = Utils.getDateFormattedWithOffset(dateStartInput, "d", i);
        }
        int ind = 0; //chỉ mục hiện tại cho rawData
        String curDate = Utils.getDateFormattedWithOffset(dateStartInput, "d", 0);
        boolean flag = true; //Đánh dấu cho việc hết data trong mảng rawData, flag = false khi hết data
        for (int j = 0; j<n; j++){
            // System.out.println("j: " + j + " ind: " + ind + " curDate: " + curDate + " rawData[ind][2]: " + rawData[ind][2]);
            curDate = Utils.getDateFormattedWithOffset(dateStartInput, "d", j);
            //Nếu bắt đầu gặp null
            if (!flag || rawData[ind][2] == null){
                ans[j][0] = 0;
                ans[j][1] = 0;
                ans[j][2] = curDate;
                flag = false;
            }
            else{
                int diff = Utils.calDateDiffBetweenToDate(curDate,(String)rawData[ind][2],  "dd/MM/yyyy"); //Số ngày giữa 2 ngày curDate và rawData ở ind
                // System.out.println("diff: " + diff + " curDate: " + curDate + " rawData[ind][2]: " + rawData[ind][2]);
                // System.out.println("Amount: "  + rawData[ind][0].toString() + " type: " + rawData[ind][1].toString() + " " + rawData[ind][2]);
                if (diff == 0 ){
                    
                    ans[j][(int)rawData[ind][1]] = (int)rawData[ind][0]; //ans[j][type] = rawData[sum]
                    if (rawData[ind][2] == rawData[ind+1][2] && ind < rawData.length){
                        j--;
                    }
                    ind++;
                    // else{
                    //     ans[j][(int)rawData[ind][1]] = (int)rawData[ind][0]; //ans[j][type] = rawData[sum]
                    // }
                }
                else if (diff > 0){
                    ans[j][0] = 0;
                    ans[j][1] = 0;
                    ans[j][2] = curDate;
                }
                else{
                    ind++;
                    j--;
                }
            }
        }
            ans[n-1][(int)rawData[ind][1]] = (int)rawData[ind][0]; //Đảm bảo item cuối cùng không bị bỏ sót vì ind++ và j thì = n-1 => không lấy đc phần tử ind++;

    // for (Object[] item : ans) {
    //     System.out.println(item[0].toString() + " " + item[1].toString() + " " + item[2]);
    // }
    return ans;

    }
    public void deleteData(int id){
        Connection con = getConnection();
        String sql = "DELETE FROM Log WHERE id = " + id;
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void deleteDatas(Vector<Integer> idList){
        Connection con = getConnection();
        String deleteStringId = "";
        for (int i = 0; i < idList.size(); i++) {
            deleteStringId += idList.get(i);
            if (i == idList.size() - 1){
                break;
            }
            if (i != idList.size() - 1){
                deleteStringId += ", ";
            }
        }
        String sql = "DELETE FROM Log WHERE id IN (" + deleteStringId + ")";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public void updateData(int id, Object[] dataToUpdate){
        Connection con = getConnection();
        String sql = "UPDATE Log SET category_id = ?, amount = ?, note = ? WHERE id = " + id;
        try(PreparedStatement ps = con.prepareStatement(sql)){
            // if (dataToUpdate[3] == null || dataToUpdate[3] == "" || dataToUpdate.length == 3){
            //     dataToUpdate[3] = Utils.getCurrentDateFormatted();
            // }
            // else{
            //     dataToUpdate[3] = Utils.convertToSqlDate((String) dataToUpdate[3]);
            // }
            for (int i = 0; i < dataToUpdate.length; i++) {
                ps.setObject(i + 1, dataToUpdate[i]);
            }
            // Thực thi câu lệnh SQL để chèn dữ liệu
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void updateData(Vector<Object[]> datas){
        Connection con = getConnection();
        String sql = "UPDATE Log SET category_id = ?, amount = ?, note = ? WHERE id = ?";

        try(PreparedStatement ps = con.prepareStatement(sql)){
            for (Object[] data : datas) {
                // if (data[3] == null || data[3] == "" || data.length == 3){
                //     data[3] = Utils.getCurrentDateFormatted();
                // }
                // else{
                //     data[3] = Utils.convertToSqlDate((String) data[3]);
                // }
                ps.setObject(1,data[1]);
                ps.setObject(2,data[2]);
                ps.setObject(3,data[3]);
                ps.setObject(4,data[0]);
                // for (int i = 0; i < data.length; i++) {
                //     ps.setObject(i +1, data[i]);
                //     System.out.println("i" + i + " " + data[i]);
                // }
                ps.addBatch();
                // System.out.println("id: " + data[0] + " cate: " + data[1] + " amount: " + data[2] + " note: " + data[3]);
            }
            ps.executeBatch();
        }
        catch(Exception e){
            e.printStackTrace();
        }   
    }
    public void updateData(Object[] data){
        Connection con = getConnection();
        String sql = "UPDATE Log SET category_id = ?, amount = ?, note = ? WHERE id = ?";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            // if (data[3] == null || data[3] == "" || data.length == 3){
            //     data[3] = Utils.getCurrentDateFormatted();
            // }
            // else{
            //     data[3] = Utils.convertToSqlDate((String) data[3]);
            // }
            ps.setObject(1,data[1]);
            ps.setObject(2,data[2]);
            ps.setObject(3,data[3]);
            ps.setObject(4,data[0]);
            // Thực thi câu lệnh SQL để chèn dữ liệu
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public int getLastId(){
        Connection con = getConnection();
        String sql = "SELECT id FROM Log ORDER BY id DESC LIMIT 1";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    return rs.getInt(1);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
