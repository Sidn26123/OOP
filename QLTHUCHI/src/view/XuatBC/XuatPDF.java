package view.XuatBC;

import com.itextpdf.text.BaseColor;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import model.connection.JDBCConnection;

public class XuatPDF {

    public static void XuatPDF1() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCConnection.getJDBCConnection();
            String query = "SELECT Log.ID_Log, Log.User_ID, Type.Name_Type, Log.Price, Log.Note, Log.Date " +
                            "FROM Log " +
                            "JOIN Type ON Log.ID_Type = Type.ID_Type";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:/Log_Report.pdf"));
            writer.getAcroForm().setNeedAppearances(true);
            document.open();

         
            Paragraph title = new Paragraph("BÁO CÁO THU CHI", getUnicodeFont());
            title.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(title);

            
            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100); 
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);
            table.getDefaultCell().setPadding(5);
            table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
            table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);
            
            table.addCell(new PdfPCell(new Phrase("Mã Log", getUnicodeFont())));
            table.addCell(new PdfPCell(new Phrase("Mã người dùng", getUnicodeFont())));
            table.addCell(new PdfPCell(new Phrase("Danh mục", getUnicodeFont())));
            table.addCell(new PdfPCell(new Phrase("Tiền", getUnicodeFont())));
            table.addCell(new PdfPCell(new Phrase("Ghi chú", getUnicodeFont())));
            table.addCell(new PdfPCell(new Phrase("Ngày", getUnicodeFont())));

            
            while (resultSet.next()) {
                table.addCell(new PdfPCell(new Phrase(String.valueOf(resultSet.getInt("ID_Log")), getUnicodeFont())));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(resultSet.getInt("User_ID")), getUnicodeFont())));
                table.addCell(new PdfPCell(new Phrase(resultSet.getString("Name_Type"), getUnicodeFont())));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(resultSet.getDouble("Price")), getUnicodeFont())));
                table.addCell(new PdfPCell(new Phrase(resultSet.getString("Note"), getUnicodeFont())));
                table.addCell(new PdfPCell(new Phrase(resultSet.getDate("Date").toString(), getUnicodeFont())));
            }

           
            document.add(table);

           
            document.close();

            JOptionPane.showMessageDialog(null, "Xuất PDF thành công. Tài liệu đã được lưu tại: D:/Log_Report.pdf");
        } catch (SQLException | DocumentException | java.io.IOException e) {
            e.printStackTrace();
        } finally {
            
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

  
    private static Font getUnicodeFont() throws DocumentException, java.io.IOException {
        BaseFont arialFont = BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        return new Font(arialFont, 12);
    }


}
