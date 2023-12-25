package model.objects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Utils.MyJDBCFuncLib;

public class DebtDB {
    private int idOfDestination;
    private String[] colsDBName = new String[] {"id", "idUser", "debtor", "totalAmount", "paidAmount", "description", "date", "status", "dateCreate", "paymentDeadline", "paymentType", "nextPayDate", "destination", "priority"};
    private String[] statusValue = new String[] {"Chưa trả", "Đã trả", "Đã xong","Đã hủy"};
    public Connection getConnection(){
        MyJDBCFuncLib myJDBCFuncLib = new MyJDBCFuncLib();
        return myJDBCFuncLib.getConnection();
    }

    public int getIdOfDestination() {
        return idOfDestination;
    }

    public void setIdOfDestination(int idOfDestination) {
        this.idOfDestination = idOfDestination;
    }

    public String getIDName(){
        return colsDBName[0];
    }
    public String getIDUserName(){
        return colsDBName[1];
    }
    public String getIDDebtorName(){
        return colsDBName[2];
    }
    public String getTotalAmountName(){
        return colsDBName[3];
    }
    public String getPaidAmountName(){
        return colsDBName[4];
    }
    public String getDescriptionName(){
        return colsDBName[5];
    }
    public String getDateName(){
        return colsDBName[6];
    }
    public String getStatusName(){
        return colsDBName[7];
    }
    public String getDateCreateName(){
        return colsDBName[8];
    }
    public String getPaymentDeadlineName(){
        return colsDBName[9];
    }
    public String getPaymentTypeName(){
        return colsDBName[10];
    }
    public String getPaymentName(){
        return colsDBName[11];
    }
    public String getNextPayDateName(){
        return colsDBName[12];
    }
    public String getDestinationName(){
        return colsDBName[13];
    }
    
    public void createTable(){
        Connection con = getConnection();
        String createTableSQL = "CREATE TABLE IF NOT EXISTS debt ("
            + "id INT PRIMARY KEY AUTO_INCREMENT, "
            + "idUser INT , "
            + "debtor NVARCHAR(255) , "
            + "totalAmount INT , "
            + "paidAmount INT , "
            + "description NVARCHAR(255) , "
            + "date NVARCHAR(25) , "
            + "status INT , "
            + "dateCreate NVARCHAR(25) , "
            + "paymentDeadline NVARCHAR(25) , "
            + "paymentType NVARCHAR(25) , "
            + "payment NVARCHAR(255) , "
            + "nextPayDate NVARCHAR(255) , "
            + "destination INT , "
            + "priority INT " + " );";
        
        try(PreparedStatement ps = con.prepareStatement(createTableSQL)){
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void clearTable(){
        Connection con = getConnection();
        String clearTableSQL = "DELETE FROM debt;";
        
        try(PreparedStatement ps = con.prepareStatement(clearTableSQL)){
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void dropTable(){
        Connection con = getConnection();
        String dropTableSQL = "DROP TABLE IF EXISTS debt;";
        
        try(PreparedStatement ps = con.prepareStatement(dropTableSQL)){
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void insertData(int idUser, String debtor, int totalAmount, String description, String dateCreate, String paymentDeadline, String paymentType, String nextPayDate, String destination, int priority){
        String curDate = Utils.Utils.getCurrentDateFormatted();
        if (nextPayDate == null || nextPayDate.equals("")){
            nextPayDate = Utils.Utils.getDateFormattedWithOffset(curDate, "m", 1);
        }
        Connection con = getConnection();
        String insertDataSQL = "INSERT INTO debt (idUser, debtor, totalAmount, description, date, paymentDeadline, paymentType, nextPayDate, destination, priority, status, paidAmount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement ps = con.prepareStatement(insertDataSQL)){

            ps.setInt(1, idUser);
            ps.setString(2, debtor);
            ps.setInt(3, totalAmount);
            ps.setString(4, description);
            ps.setString(5, dateCreate);
            ps.setString(6, paymentDeadline);
            ps.setString(7, paymentType);
            ps.setString(8, nextPayDate);
            ps.setString(9, destination);
            ps.setInt(10, priority);
            ps.setInt(11, 0); //status
            ps.setInt(12, 0);

            ps.executeUpdate();

            //số dòng
        }
        catch(Exception e){
            e.printStackTrace();

        }
        System.out.println("Insert data successfull");

    }

    public Object[][] getData(){
        Connection con = getConnection();
        String getDataSQL = "SELECT * FROM debt;";
        Object[][] data = null;
        
        try(PreparedStatement ps = con.prepareStatement(getDataSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)){
            try (ResultSet rs = ps.executeQuery()){
                int i = 0;
                rs.last();
                int numRows = rs.getRow();
                rs.beforeFirst();

                data = new Object[numRows][15];

                while(rs.next()){
                    data[i][0] = rs.getInt(colsDBName[0]);
                    data[i][1] = rs.getInt(colsDBName[1]);
                    data[i][2] = rs.getString(colsDBName[2]);
                    data[i][3] = rs.getInt(colsDBName[3]);
                    data[i][4] = rs.getInt(colsDBName[4]);
                    data[i][5] = rs.getString(colsDBName[5]);
                    data[i][6] = rs.getString(colsDBName[6]);
                    data[i][7] = rs.getString(colsDBName[7]);
                    data[i][8] = rs.getString(colsDBName[8]);
                    data[i][9] = rs.getString(colsDBName[9]);
                    data[i][10] = rs.getString(colsDBName[10]);
                    data[i][11] = rs.getString(colsDBName[11]);
                    data[i][12] = rs.getString(colsDBName[12]);
                    // data[i][13] = rs.getString(colsDBName[13]);
                    // data[i][14] = rs.getInt(colsDBName[14]);
                    System.out.println("a: "+ data[i][0]);
                    i++;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        //in data
            
        return data;
    }

    /**
     * Lọc theo status, trả về mảng 2 chiều với các cột trong colsName
     * @param status
     * @param colsName
     * @return
     */
    public Object[][] getData(int status, int idUser, String[] colsName){
        Connection con = getConnection();
        String getDataSQL = "SELECT * FROM debt WHERE status = ? AND idUser = ?;";
        Object[][] data = null;
        try(PreparedStatement ps = con.prepareStatement(getDataSQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)){
            ps.setInt(1, status);
            ps.setInt(2, idUser);
            try (ResultSet rs = ps.executeQuery()){
                rs.last();
                int rowCount = rs.getRow();
                System.out.println("rowCount: " + rowCount);
                data = new Object[rowCount][colsName.length];
                rs.beforeFirst();
                int i = 0;
                //Lấy các cột cần lấy có trong colsName
                while(rs.next()){
                    for(int j = 0; j < colsName.length; j++){
                        data[i][j] = rs.getString(colsName[j]);
                    }
                    System.out.println("a: "+ data[i][0] + data[i][1]);
                    i++;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }

    public void deleteRow(int id){
        Connection con = getConnection();
        String deleteRowSQL = "DELETE FROM debt WHERE id = ?;";
        try(PreparedStatement ps = con.prepareStatement(deleteRowSQL)){
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteRows(int[] id){
        Connection con = getConnection();
        String deleteStringID = "";
        for(int i = 0; i < id.length; i++){
            deleteStringID += id[i];
            if(i < id.length - 1){
                deleteStringID += ", ";
            }
        }
        String deleteRowsSQL = "DELETE FROM debt WHERE id IN (" + deleteStringID + ");";
        try(PreparedStatement ps = con.prepareStatement(deleteRowsSQL)){
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateData(int id, int amout){
        Connection con = getConnection();
        //Lấy row có id = id ra, cộng paidAmount với amount, nếu paidAmount >= totalAmount thì status = 1
        String updateDataSQL = "UPDATE debt SET paidAmount = paidAmount + ? WHERE id = ?;";
        try(PreparedStatement ps = con.prepareStatement(updateDataSQL)){
            ps.setInt(1, amout);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
