
package model.connection;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utils.ConfigFile;
public class JDBCConnection {
    public static Connection getJDBCConnection(){
        ConfigFile c = new ConfigFile();
//<<<<<<< HEAD
////<<<<<<< HEAD
//        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=QLTHUCHI;encrypt = true;trustServerCertificate=true";
//        String user = "sa";
//        String password = "123456789";
//
//=======
        if (c.getDB() == "SQLServer"){
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=QLTC;encrypt = true;trustServerCertificate=true";
        String user = "sa";
        String password = "sa";
   
        try {
            Connection connection = DriverManager.getConnection(url,user, password);
            System.out.println("Connect successful");
            return connection;
        } catch (SQLException e) {
            System.out.println("Opp, there is a error!");
            e.printStackTrace();
        }
        return null;
        }
        else{
                        String url = "jdbc:mysql://localhost:3306/oop";
        String username = "nguyenuy";
        String password = "2612";
        // Biến Connection để thực hiện kết nối
        Connection connection = null;

        try {
            // Load JDBC Driver
            //mýysql
             Class.forName("com.mysql.cj.jdbc.Driver");
            //sql server
            // Thực hiện kết nối
            connection = DriverManager.getConnection(url, username, password);

            // Kiểm tra kết nối thành công
            if (connection != null) {
                System.out.println("Kết nối thành công!");

                // Tại đây bạn có thể thực hiện các thao tác với cơ sở dữ liệu
                // Ví dụ: truy vấn dữ liệu, cập nhật dữ liệu, ...

                // Đóng kết nối sau khi sử dụng
                connection.close();
            } else {
                System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Đảm bảo rằng kết nối đã được đóng trong trường hợp có lỗi xảy ra
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }   
        return null;
}
}