package view.calendar;

import com.toedter.calendar.JCalendar;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.calendar.CalendarT;
public class Test {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calendar Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Object[][] data = {
    {1, 2, "String 1"},
    {2, 4, "String 2"},
    {3, 6, "String 3"},
    {4, 8, "String 4"},
    {5, 10, "String 5"},
    {6, 12, "String 6"},
    {7, 14, "String 7"},
    {8, 16, "String 8"},
    {9, 18, "String 9"},
    {10, 20, "String 10"},
    {11, 22, "String 11"},
    {12, 24, "String 12"},
    {13, 26, "String 13"},
    {14, 28, "String 14"},
    {15, 30, "String 15"},
    {16, 32, "String 16"},
    {17, 34, "String 17"},
    {18, 36, "String 18"},
    {19, 38, "String 19"},
    {20, 40, "String 20"},
    {21, 42, "String 21"},
    {22, 44, "String 22"},
    {23, 46, "String 23"},
    {24, 48, "String 24"},
    {25, 50, "String 25"},
    {26, 52, "String 26"},
    {27, 54, "String 27"},
    {28, 56, "String 28"},
    {29, 58, "String 29"},
    {30, 60, "String 30"}
};
        JPanel calendar = new JPanel();

        calendar.setBackground(new java.awt.Color(51, 255, 51));
        calendar.setLayout(new java.awt.GridLayout(5, 7));
        for (Object[] item: data){
            JPanel jPanel = new JPanel();
            jPanel.setBackground(new java.awt.Color(255, 255, 255));
            jPanel.setLayout(new java.awt.GridLayout(3, 1));
            JLabel date = new JLabel(item[2].toString());
            JLabel income = new JLabel(item[0].toString());
            JLabel spent = new JLabel(item[1].toString());
            System.out.println(date.getText());

            if ((int)item[0] - (int)item[1] > 0){
                // jPanel.setBackground(new java.awt.Color(10, 200, 12));
                date.setForeground(new java.awt.Color(20,30,50));
            }
            jPanel.add(date);
            jPanel.add(income);
            jPanel.add(spent);
            jPanel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                }
            });

            calendar.add(jPanel);
        }
        javax.swing.GroupLayout calendarShowPanelLayout = new javax.swing.GroupLayout(calendar);
        calendar.setLayout(calendarShowPanelLayout);
        calendarShowPanelLayout.setHorizontalGroup(
            calendarShowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        calendarShowPanelLayout.setVerticalGroup(
            calendarShowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );


        // Tạo một JPanel để chứa JCalendar
        JPanel panel = new JPanel(new BorderLayout());
        
        // Tạo một JCalendar và thêm nó vào JPanel
        CalendarT calendars = new view.calendar.CalendarT(1);
        panel.add(calendars, BorderLayout.CENTER);
        
        // Thêm JPanel vào JFrame
        frame.getContentPane().add(panel);
        
        // Cấu hình JFrame
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Đặt JFrame vào giữa màn hình
        frame.setVisible(true);
        JPanel newFrame = new JPanel();
        // JFrame newFrame = new JFrame("New Frame");
        // newFrame.setType(JFrame.Type.UTILITY);
        // newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // newFrame.setLocationRelativeTo(null);
        // newFrame.setVisible(true);
    }
}
