package view.XuatBC;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.connection.JDBCConnection;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XuatExcel {

    public static void XuatExcel1() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCConnection.getJDBCConnection();
            String query = "SELECT Log.ID_Log, Log.ID_User, Type.Name_Type, Log.Price, Log.Note, Log.Date " +
                            "FROM Log " +
                            "JOIN Type ON Log.ID_Type = Type.ID_Type";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Báo cáo Excel");

            // Create header row
            Row headerRow = sheet.createRow(0);
            String[] columns = {"Mã Log", "Mã người dùng", "Danh mục", "Tiền", "Ghi chú", "Ngày"};
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            // Populate data rows
            int rowNum = 1;
            while (resultSet.next()) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(resultSet.getInt("ID_Log"));
                row.createCell(1).setCellValue(resultSet.getInt("ID_User"));
                row.createCell(2).setCellValue(resultSet.getString("Name_Type"));
                row.createCell(3).setCellValue(resultSet.getDouble("Price"));
                row.createCell(4).setCellValue(resultSet.getString("Note"));
                row.createCell(5).setCellValue(resultSet.getDate("Date").toString());
            }

            // Write the workbook content to a file
            try (FileOutputStream fileOut = new FileOutputStream("D:/Log_Report.xlsx")) {
                workbook.write(fileOut);
            }
            JOptionPane.showMessageDialog(null, "Xuất Excel thành công. Tài liệu đã được lưu tại: D:/Log_Report.xlsx");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            // Close resources in the reverse order of their creation
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
