
package view.calendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarT extends javax.swing.JPanel {
    private int id_user;

    public CalendarT(int id_user) {
        this.id_user = id_user;
        initComponents();
        setDefault();
    }

    private void setDefault(){
        button_next.setIcon(new ImageIcon("src\\source\\img\\Calendar\\icons8-next-50.png"));
        button_pre.setIcon(new ImageIcon("src\\source\\img\\Calendar\\icons8-previous-50.png"));
        Calendar c = Calendar.getInstance();
        setTextLabelDate(c);
        label_date.setHorizontalAlignment(JLabel.CENTER);

    }
    private void setTextLabelDate(Calendar c){
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int end_month = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        String date = String.valueOf(month) + "/" + String.valueOf(year) +" "
                + "(01/" + String.valueOf(month) + " - "
                +  String.valueOf(end_month) + "/" + String.valueOf(month)
                + ")";
        label_date.setText(date);
    }
    
    private Calendar getMonthYear(){
        String[] date = (String.valueOf(label_date.getText()).split(" "))[0].split("/");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, Integer.parseInt(date[0])-1);
        c.set(Calendar.YEAR, Integer.parseInt(date[1]));    
        return c;
    }
    
    private Calendar getPreviousMonth() {
        Calendar calendar = getMonthYear();
        
        if (calendar.get(Calendar.MONTH) == Calendar.JANUARY) {
            calendar.set(Calendar.MONTH, Calendar.DECEMBER);
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
        } else {
            calendar.roll(Calendar.MONTH, false);
        }

        return calendar;
    }
    private Calendar getNextMonth() {
        Calendar calendar = getMonthYear();

        if (calendar.get(Calendar.MONTH) == Calendar.DECEMBER) {
            calendar.set(Calendar.MONTH, Calendar.JANUARY);
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + 1);
        } else {
            calendar.roll(Calendar.MONTH, true);
        }

        return calendar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        button_pre = new javax.swing.JButton();
        button_next = new javax.swing.JButton();
        dateChooseBtn = new javax.swing.JButton();
        label_date = new javax.swing.JTextField();
        calendarWrapper = new view.calendar.PanelBorder();
        calendarShowPanel = new javax.swing.JPanel();
        calendarItem = new javax.swing.JPanel();
        dateItemLabel = new javax.swing.JLabel();
        incomeValueLabel = new javax.swing.JLabel();
        spentValueLabel = new javax.swing.JLabel();
        totalValueLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(637, 604));
        setLayout(null);

        button_pre.setBackground(new java.awt.Color(153, 153, 153));
        button_pre.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        button_pre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/img/Calendar/icons8-previous-50.png"))); // NOI18N
        button_pre.setBorder(null);
        button_pre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_preActionPerformed(evt);
            }
        });
        add(button_pre);
        button_pre.setBounds(140, 10, 20, 20);

        button_next.setBackground(new java.awt.Color(153, 153, 153));
        button_next.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        button_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/img/Calendar/icons8-next-50.png"))); // NOI18N
        button_next.setBorder(null);
        button_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_nextActionPerformed(evt);
            }
        });
        add(button_next);
        button_next.setBounds(410, 10, 20, 20);

        dateChooseBtn.setBackground(new java.awt.Color(153, 153, 153));
        dateChooseBtn.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        dateChooseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/img/Calendar/icons8-next-50.png"))); // NOI18N
        dateChooseBtn.setBorder(null);
        dateChooseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateChooseBtnActionPerformed(evt);
            }
        });
        add(dateChooseBtn);
        dateChooseBtn.setBounds(380, 10, 20, 20);

        label_date.setText("jTextField1");
        label_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label_dateActionPerformed(evt);
            }
        });
        add(label_date);
        label_date.setBounds(210, 10, 150, 30);

        calendarWrapper.setBackground(new java.awt.Color(153, 153, 255));
        calendarWrapper.setLayout(null);

        calendarShowPanel.setBackground(new java.awt.Color(255, 255, 255));
        calendarShowPanel.setLayout(new java.awt.GridLayout(5, 7));

        calendarItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calendarItemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                calendarItemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                calendarItemMouseExited(evt);
            }
        });
//        calendarItem.setLayout(null);
//
//        dateItemLabel.setText("jLabel1");
//        calendarItem.add(dateItemLabel);
//        dateItemLabel.setBounds(0, 0, 60, 20);
//
//        incomeValueLabel.setText("jLabel1");
//        calendarItem.add(incomeValueLabel);
//        incomeValueLabel.setBounds(30, 20, 34, 14);
//
//        spentValueLabel.setText("jLabel2");
//        calendarItem.add(spentValueLabel);
//        spentValueLabel.setBounds(30, 40, 34, 14);
//
//        totalValueLabel.setText("jLabel3");
//        calendarItem.add(totalValueLabel);
        Object[][] data = {
            {81, 84, "1/01/2023"},
            {51, 88, "2/01/2023"},
            {14, 66, "3/01/2023"},
            {36, 54, "4/01/2023"},
            {27, 7, "5/01/2023"},
            {61, 93, "6/01/2023"},
            {60, 65, "7/01/2023"},
            {5, 19, "8/01/2023"},
            {90, 68, "9/01/2023"},
            {41, 42, "10/01/2023"},
            {46, 64, "11/01/2023"},
            {12, 20, "12/01/2023"},
            {85, 71, "13/01/2023"},
            {24, 3, "14/01/2023"},
            {15, 46, "15/01/2023"},
            {11, 9, "16/01/2023"},
            {66, 37, "17/01/2023"},
            {68, 78, "18/01/2023"},
            {1, 79, "19/01/2023"},
            {99, 79, "20/01/2023"},
            {93, 23, "21/01/2023"},
            {7, 90, "22/01/2023"},
            {89, 23, "23/01/2023"},
            {89, 60, "24/01/2023"},
            {49, 99, "25/01/2023"},
            {70, 6, "26/01/2023"},
            {45, 15, "27/01/2023"},
            {0, 67, "28/01/2023"},
            {92, 47, "29/01/2023"},
            {6, 84, "30/01/2023"},
            {63, 71, "31/01/2023"},
            {36, 16, "01/02/2023"},
            {65, 96, "02/02/2023"},
            {88, 4, "03/02/2023"},
            {48, 15, "04/02/2023"}
        };
        totalValueLabel.setBounds(30, 60, 34, 14);
        for (int i = 0; i< 5*7; i++){
            JPanel calendarItem1 = new JPanel();
            calendarItem1.setLayout(null);

        JLabel dateItemLabel = new JLabel(((String)data[i][2]));
        dateItemLabel.setFont(new java.awt.Font("Times New Roman", 0, 12));
        calendarItem1.add(dateItemLabel);
        dateItemLabel.setBounds(0, 0, 60, 20);
            if ((int)data[i][0] - (int)data[i][1] < 0){
                dateItemLabel.setForeground(Color.RED);
            }
            else if ((int)data[i][0] - (int)data[i][1] > 0){
                dateItemLabel.setForeground(Color.GREEN);
            }
//
        JLabel incomeValueLabel = new JLabel(data[i][0].toString());
        incomeValueLabel.setFont(new java.awt.Font("Times New Roman", 0, 12));
        calendarItem1.add(incomeValueLabel);
        incomeValueLabel.setBounds(30, 20, 34, 14);

        JLabel spentValueLabel = new JLabel(data[i][1].toString());
        spentValueLabel.setFont(new java.awt.Font("Times New Roman", 0, 12));
        calendarItem1.add(spentValueLabel);
        spentValueLabel.setBounds(30, 40, 34, 14);
        calendarItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createFrame(evt.getX(), evt.getY());
            }
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                createFrame(e.getX(), e.getY());
//            }
//        });
//            }
//        }
        public void mouseEntered(java.awt.event.MouseEvent e) {
            calendarItem1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            dateItemLabel.setFont(new java.awt.Font("Times New Roman", 0, 15));
//            calendarItem1.setBackground(Color.LIGHT_GRAY);
        }

        public void mouseExited(java.awt.event.MouseEvent e) {
            calendarItem1.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            dateItemLabel.setFont(new java.awt.Font("Times New Roman", 0, 12));
        }
        });
        
            calendarShowPanel.add(calendarItem1);
        }
        
        calendarWrapper.add(calendarShowPanel);
        calendarShowPanel.setBounds(10, 10, 560, 270);

        add(calendarWrapper);
        calendarWrapper.setBounds(10, 60, 580, 290);
    }// </editor-fold>                        
    private JPanel drawTable(Object[][] data){
                for (int i = 0; i< 5*7; i++){
            JPanel calendarItem1 = new JPanel();
            calendarItem1.setLayout(null);

        JLabel dateItemLabel = new JLabel(((String)data[i][2]));
        dateItemLabel.setFont(new java.awt.Font("Times New Roman", 0, 12));
        calendarItem1.add(dateItemLabel);
        dateItemLabel.setBounds(0, 0, 60, 20);
            if ((int)data[i][0] - (int)data[i][1] < 0){
                dateItemLabel.setForeground(Color.RED);
            }
            else if ((int)data[i][0] - (int)data[i][1] > 0){
                dateItemLabel.setForeground(Color.GREEN);
            }
//
        JLabel incomeValueLabel = new JLabel(data[i][0].toString());
        incomeValueLabel.setFont(new java.awt.Font("Times New Roman", 0, 12));
        calendarItem1.add(incomeValueLabel);
        incomeValueLabel.setBounds(30, 20, 34, 14);

        JLabel spentValueLabel = new JLabel(data[i][1].toString());
        spentValueLabel.setFont(new java.awt.Font("Times New Roman", 0, 12));
        calendarItem1.add(spentValueLabel);
        spentValueLabel.setBounds(30, 40, 34, 14);
        int borderWidth = 1;
        calendarItem1.setBorder(new javax.swing.border.LineBorder(Color.CYAN, borderWidth));
        
        calendarItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createFrame(evt.getX(), evt.getY());
            }
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                createFrame(e.getX(), e.getY());
//            }
//        });
//            }
//        }
        public void mouseEntered(java.awt.event.MouseEvent e) {
            calendarItem1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            dateItemLabel.setFont(new java.awt.Font("Times New Roman", 0, 15));
//            calendarItem1.setBackground(Color.LIGHT_GRAY);
        }

        public void mouseExited(java.awt.event.MouseEvent e) {
            calendarItem1.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            dateItemLabel.setFont(new java.awt.Font("Times New Roman", 0, 12));
        }
        });
        
            calendarShowPanel.add(calendarItem1);
        }
        
        return calendarShowPanel;
    }
    private void button_preActionPerformed(java.awt.event.ActionEvent evt) {                                           
        setTextLabelDate(getPreviousMonth());
    }                                          

    private void button_nextActionPerformed(java.awt.event.ActionEvent evt) {                                            
        setTextLabelDate(getNextMonth());
        Object[][] data = {
            {11111, 84, "1/01/2023"},
            {51, 88, "2/01/2023"},
            {14, 66, "3/01/2023"},
            {36, 54, "4/01/2023"},
            {27, 7, "5/01/2023"},
            {61, 93, "6/01/2023"},
            {60, 65, "7/01/2023"},
            {5, 19, "8/01/2023"},
            {90, 68, "9/01/2023"},
            {41, 42, "10/01/2023"},
            {46, 64, "11/01/2023"},
            {12, 20, "12/01/2023"},
            {85, 71, "13/01/2023"},
            {24, 3, "14/01/2023"},
            {15, 46, "15/01/2023"},
            {11, 9, "16/01/2023"},
            {66, 37, "17/01/2023"},
            {68, 78, "18/01/2023"},
            {1, 79, "19/01/2023"},
            {99, 79, "20/01/2023"},
            {93, 23, "21/01/2023"},
            {7, 90, "22/01/2023"},
            {89, 23, "23/01/2023"},
            {89, 60, "24/01/2023"},
            {49, 99, "25/01/2023"},
            {70, 6, "26/01/2023"},
            {45, 15, "27/01/2023"},
            {0, 67, "28/01/2023"},
            {92, 47, "29/01/2023"},
            {6, 84, "30/01/2023"},
            {63, 71, "31/01/2023"},
            {36, 16, "01/02/2023"},
            {65, 96, "02/02/2023"},
            {88, 4, "03/02/2023"},
            {48, 15, "04/02/2023"}
        };
        calendarWrapper.removeAll();
        calendarWrapper.add(drawTable(data));
        
    }                                           

    private void dateChooseBtnActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void label_dateActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void calendarItemMouseClicked(java.awt.event.MouseEvent evt) {                                          
        // TODO add your handling code here:
        

    }                                         
    private static void createFrame(int mouseX,int mouseY) {
        
        JFrame frame = new JFrame("Mouse Clicked Frame");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        System.out.println(mouseX);
        int frameWidth = 200;
        int frameHeight = 150;

        // Lấy kích thước màn hình
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Tính toán vị trí sao cho frame không chạm vào các viền
        int frameX = mouseX;
        int frameY = mouseY;

        if (frameX + frameWidth > screenSize.width) {
            frameX = screenSize.width - frameWidth;
        }

        if (frameY + frameHeight > screenSize.height) {
            frameY = screenSize.height - frameHeight;
        }

        frame.setBounds(frameX, frameY, frameWidth, frameHeight);
        frame.setVisible(true);
    }

    private void calendarItemMouseEntered(java.awt.event.MouseEvent evt) {                                          
        java.awt.Color borderColor = java.awt.Color.RED;
        int borderWidth = 2;
        this.setBorder(new javax.swing.border.LineBorder(borderColor, borderWidth));
    }                                         

    private void calendarItemMouseExited(java.awt.event.MouseEvent evt) {                                         
        this.setBorder(null);
    }                                        


    // Variables declaration - do not modify                     
    private javax.swing.JButton button_next;
    private javax.swing.JButton button_pre;
    private javax.swing.JPanel calendarItem;
    private javax.swing.JPanel calendarShowPanel;
    private view.calendar.PanelBorder calendarWrapper;
    private javax.swing.JButton dateChooseBtn;
    private javax.swing.JLabel dateItemLabel;
    private javax.swing.JLabel incomeValueLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField label_date;
    private javax.swing.JLabel spentValueLabel;
    private javax.swing.JLabel totalValueLabel;
    private Object[][] data;
    // End of variables declaration                   
}
