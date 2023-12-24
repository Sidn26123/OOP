package Utils;

/**
 *
 * @author sidac
 */
    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.sql.PreparedStatement;
//main_window import

public class MyJDBCFuncLib {
    public void test(String[] args) {
        // Thông tin kết nối
        String url = "jdbc:mysql://localhost:3306/oop";
        String username = "nguyenuy";
        String password = "2612";
        // Biến Connection để thực hiện kết nối
        Connection connection = null;

        try {
            // Load JDBC Driver
            //mýysql
            // Class.forName("com.mysql.cj.jdbc.Driver");
            //sql server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
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
    public static void createTable() {
        // Biến Connection để thực hiện kết nối
        Connection connection = null;

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Thông tin kết nối
            String url = "jdbc:mysql://localhost:3306/oop";
            String username = "nguyenuy";
            String password = "2612";

            // Thực hiện kết nối
            connection = DriverManager.getConnection(url, username, password);

            // Kiểm tra kết nối thành công
            if (connection != null) {
                System.out.println("Kết nối thành công!");

                // Tạo bảng
                Statement statement = connection.createStatement();
                // String createTableSQL = "CREATE TABLE Category (" +
                //                         "id INT AUTO_INCREMENT PRIMARY KEY," +
                //                         "name NVARCHAR(50) NOT NULL," +
                //                         "color NVARCHAR(10)," +
                //                         "icon_path NVARCHAR(255)," +
                //                         "type INT);";
                // String sql = "DROP TABLE Transaction";
                                        // "CREATE TABLE Category (" +
                                        // "id INT PRIMARY KEY," +
                                        // "name NVARCHAR(50) NOT NULL," +
                                        // "color NVARCHAR(10)," +
                                        // "icon_path NVARCHAR(255)," +
                                        // "type INT)";
                // statement.executeUpdate(sql);
                // Tạo câu lệnh SQL với tham số (?)
                // String insertDataSQL = "INSERT INTO Category (name, color, icon_path, type) VALUES (?, ?, ?, ?);";
                // String sql = "SELECT * FROM Category";

                // Thực hiện truy vấn và nhận kết quả
                // try (ResultSet resultSet = statement.executeQuery(sql)) {
                    // Duyệt qua kết quả và xử lý dữ liệu
                    // while (resultSet.next()) {
                    //     // Đọc dữ liệu từ các cột
                    //     int id = resultSet.getInt("id");
                    //     String name = resultSet.getString("name");
                    //     String color = resultSet.getString("color");
                    //     String iconPath = resultSet.getString("icon_path");
                    //     int type = resultSet.getInt("type");

                    //     // Xử lý dữ liệu theo ý muốn của bạn
                    //     System.out.println("ID: " + id + ", Name: " + name + ", Color: " + color +
                    //                        ", Icon Path: " + iconPath + ", Type: " + type);
                    // }
                // }
                // Tạo đối tượng PreparedStatement để thực hiện câu lệnh SQL
                // try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {
                //     // Dữ liệu muốn chèn
                //     Object[][] dataToInsert = {
                //             {"Việc", "green", "", 0},
                //             {"Ăn", "green", "", 1},
                //             {"Hằng ngày", "blue", "", 1}
                //             // Thêm các hàng dữ liệu khác nếu cần
                //     };
    
                //     // Duyệt qua mảng dữ liệu và chèn từng hàng vào bảng
                //     for (Object[] rowData : dataToInsert) {
                //         for (int i = 0; i < rowData.length; i++) {
                //             preparedStatement.setObject(i + 1, rowData[i]);
                //         }
    
                //         // Thực thi câu lệnh SQL để chèn dữ liệu
                //         preparedStatement.executeUpdate();
                //     }
    
                //     System.out.println("Dữ liệu đã được thêm vào bảng.");
                // }

                // System.out.println(statement.execute(getDataSQL));
                statement.close();

                System.out.println("Bảng đã được tạo thành công.");

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
    public  void getData(String JDBC_URL,String USER,String PASSWORD){
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            // Lấy đối tượng DatabaseMetaData từ Connection
            DatabaseMetaData metaData = connection.getMetaData();

            // Lấy tên cơ sở dữ liệu
            String databaseName = connection.getCatalog();
            System.out.println("Danh sách các bảng trong cơ sở dữ liệu '" + databaseName + "':");

            // Lấy ResultSet chứa thông tin về bảng
            ResultSet resultSet = metaData.getTables(databaseName, null, "%", new String[]{"TABLE"});

            // Duyệt qua ResultSet để lấy tên các bảng
            while (resultSet.next()) {
                String tableName = resultSet.getString("TABLE_NAME");
                System.out.println(tableName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        Connection con = null;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop", "nguyenuy", "2612");
            return con;
        }
        catch(Exception e){
            Logger.getLogger(MyJDBCFuncLib.class.getName()).log(Level.SEVERE, null, e);
            return con;
        }
    }
    public static void getDataF() {
        // Thông tin kết nối
        String url = "jdbc:mysql://localhost:3306/oop";
        String username = "nguyenuy";
        String password = "2612";

        // Tên bảng bạn muốn truy vấn
        String tableName = "Category";

        // Biến Connection để thực hiện kết nối
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Tạo một đối tượng Statement
            try (Statement statement = connection.createStatement()) {
                // Lệnh SQL SELECT để lấy toàn bộ dữ liệu từ bảng
                String sql = "SELECT * FROM " + tableName;

                // Thực hiện truy vấn và nhận kết quả
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    // Duyệt qua kết quả và xử lý dữ liệu
                    while (resultSet.next()) {
                        // Đọc dữ liệu từ cột cụ thể
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        int age = resultSet.getInt("age");

                        // Xử lý dữ liệu theo ý muốn của bạn
                        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
                    }
                }
            }
        } catch (SQLException e) {
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
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void insertDataSQL(String tableName, Object[][] dataToInsert){
        String sql = "INSERT INTO "+ tableName + " (name, color, icon_path, type) VALUES (?, ?, ?, ?);";
        Connection con = getConnection();
        //insert data
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            for (Object[] rowData : dataToInsert) {
                for (int i = 0; i < rowData.length; i++) {
                    preparedStatement.setObject(i + 1, rowData[i]);
                }
                // Thực thi câu lệnh SQL để chèn dữ liệu
                preparedStatement.executeUpdate();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
