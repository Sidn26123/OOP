package view.XuatBC;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.danhmuc.PDFJPanel;

public class JPanelToPDF {
    public static void JPanelToPDF(JPanel panel, String outputPath) throws FileNotFoundException, BadElementException, IOException {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(outputPath));
            document.open();

            // Chuyển đổi JPanel thành hình ảnh và thêm vào PDF
            Rectangle panelBounds = panel.getBounds();
            BufferedImage image = new BufferedImage(panelBounds.width, panelBounds.height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            panel.paint(g);

            float offsetX = (document.getPageSize().getWidth() - image.getWidth()) / 2;
            float offsety = 290;
            com.itextpdf.text.Image pdfImage = com.itextpdf.text.Image.getInstance(image, null);
            pdfImage.setAbsolutePosition(offsetX,offsety);
            document.add(pdfImage);
            JOptionPane.showMessageDialog(null, "Xuất PDF thành công. Tài liệu đã được lưu tại: D:/output.pdf");
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

    public static void exportPanelToPDF() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("PDF Export Example");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel pdfPanel = new PDFJPanel(); // Thay YourPDFJPanel bằng tên của JPanel bạn muốn xuất ra PDF
            frame.getContentPane().add(pdfPanel, BorderLayout.CENTER);

            frame.setSize(500, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            // Xuất PDF
            String outputPath = "D:/output.pdf"; // Đường dẫn của file PDF đầu ra trên ổ đĩa D
            try {
                JPanelToPDF(pdfPanel, outputPath);
            } catch (BadElementException ex) {
                Logger.getLogger(JPanelToPDF.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(JPanelToPDF.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
