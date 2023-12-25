package view.Chi;

import view.thu.*;
import com.formdev.flatlaf.FlatLightLaf;
import controller.DanhMucChi;
import controller.LogController;
import controller.TypeController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import model.objects.LogO;
import model.objects.TypeO;
import view.calculator.Calculator_Chi;
import view.danhmuc.ChiJPanel;

public class Chi extends javax.swing.JFrame {

    TypeController typeController;
    LogController logController;
    private int id_user;
    
    public Chi(int id_user) {
        this.id_user = id_user;
        FlatLightLaf.setup();
        initComponents();
        setDefaultThings();
        setPanelDanhMuc();
        
    }
    
    
    public void update_valueCalculator(double value){
        text_tienthu.setText(String.valueOf(value));
    }
    
    private void setDefaultThings(){
        dialog_dsThu.setSize(500,500);
        dialog_dsThu.setLocationRelativeTo(null);
        dialog_dsThu.setTitle("Danh sách thu");
        
        button_save.setIcon(new ImageIcon("src\\source\\img\\Thu_Chi\\icons8-pencil-64.png"));
        logController = new LogController();
        jDateChooser1.setDate(Calendar.getInstance().getTime());
        this.setLocationRelativeTo(null);
        button_calculator.setIcon(new ImageIcon("src\\source\\img\\Thu_Chi\\icons8-calculator-64.png"));
    }
    
    private void setPanelDanhMuc(){
        
        
        
        typeController = new TypeController();
        List<TypeO> types = typeController.getAllTypeReceipt(id_user);
        int length = types.size();
        int rows = (int)length/3 + 1;
        panel_danhmuc.setLayout(new GridLayout(rows,3));
        
        for(TypeO type:types){
            ImageIcon icon;
            JToggleButton toggleButton;
            if(!(type.getIcon_Path() == null)){
                icon = new ImageIcon(type.getIcon_Path());
                toggleButton = new JToggleButton(type.getName_Type(), icon);
            }
            else{
                toggleButton = new JToggleButton(type.getName_Type());
            }
            
            toggleButton.setFont(new Font("Times New Roman",Font.PLAIN, 16));
            toggleButton.setActionCommand(String.valueOf(type.getID_Type()));
            toggleButton.setForeground(new Color(333333));
            
            toggleButton.setBackground(new Color(255, 230, 230));
            toggleButton.setMaximumSize(new java.awt.Dimension(50, 50));
            toggleButton.setMinimumSize(new java.awt.Dimension(10, 10));
            toggleButton.setPreferredSize(new Dimension(50,50));
            panel_danhmuc.add(toggleButton);
            buttonGroup1.add(toggleButton);
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        dialog_dsThu = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        text_ghichu = new javax.swing.JTextField();
        text_tienthu = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        button_save = new javax.swing.JButton();
        button_calculator = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel_danhmuc = new javax.swing.JPanel();
        button_chinhsua1 = new javax.swing.JButton();
        button_danh_sach_chi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        dialog_dsThu.setModal(true);

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("Xóa");

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setText("Tất cả");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1)
                .addComponent(jButton2))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout dialog_dsThuLayout = new javax.swing.GroupLayout(dialog_dsThu.getContentPane());
        dialog_dsThu.getContentPane().setLayout(dialog_dsThuLayout);
        dialog_dsThuLayout.setHorizontalGroup(
            dialog_dsThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        dialog_dsThuLayout.setVerticalGroup(
            dialog_dsThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialog_dsThuLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Ngày");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Ghi chú");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Tiền thu");

        jDateChooser1.setBackground(new java.awt.Color(245, 177, 109));
        jDateChooser1.setForeground(new java.awt.Color(255, 0, 0));
        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jDateChooser1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Danh mục");

        text_ghichu.setBackground(new java.awt.Color(245, 177, 109));
        text_ghichu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        text_ghichu.setForeground(new java.awt.Color(102, 102, 102));
        text_ghichu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_ghichuActionPerformed(evt);
            }
        });

        text_tienthu.setBackground(new java.awt.Color(245, 177, 109));
        text_tienthu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        text_tienthu.setForeground(new java.awt.Color(51, 51, 51));
        text_tienthu.setText("0");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("đ");

        button_save.setBackground(new java.awt.Color(242, 242, 242));
        button_save.setForeground(new java.awt.Color(255, 102, 0));
        button_save.setBorder(null);
        button_save.setPreferredSize(new java.awt.Dimension(64, 64));
        button_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_saveActionPerformed(evt);
            }
        });

        button_calculator.setBackground(new java.awt.Color(242, 242, 242));
        button_calculator.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        button_calculator.setBorder(null);
        button_calculator.setMaximumSize(new java.awt.Dimension(64, 64));
        button_calculator.setMinimumSize(new java.awt.Dimension(64, 64));
        button_calculator.setPreferredSize(new java.awt.Dimension(64, 64));
        button_calculator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_calculatorActionPerformed(evt);
            }
        });

        jScrollPane1.setPreferredSize(new java.awt.Dimension(625, 111));

        button_chinhsua1.setBackground(new java.awt.Color(242, 86, 29));
        button_chinhsua1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        button_chinhsua1.setForeground(new java.awt.Color(255, 255, 255));
        button_chinhsua1.setText("Chỉnh sửa");
        button_chinhsua1.setBorder(null);
        button_chinhsua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_chinhsua1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_danhmucLayout = new javax.swing.GroupLayout(panel_danhmuc);
        panel_danhmuc.setLayout(panel_danhmucLayout);
        panel_danhmucLayout.setHorizontalGroup(
            panel_danhmucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button_chinhsua1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panel_danhmucLayout.setVerticalGroup(
            panel_danhmucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_danhmucLayout.createSequentialGroup()
                .addComponent(button_chinhsua1)
                .addContainerGap(232, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(panel_danhmuc);

        button_danh_sach_chi.setBackground(new java.awt.Color(51, 255, 255));
        button_danh_sach_chi.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        button_danh_sach_chi.setForeground(new java.awt.Color(255, 255, 255));
        button_danh_sach_chi.setText("Danh sách chi");
        button_danh_sach_chi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_danh_sach_chiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe Script", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setText("Chi");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))))
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(text_ghichu, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(button_danh_sach_chi)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(text_tienthu, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(button_calculator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27))))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(1, 1, 1))
                            .addComponent(button_save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(text_ghichu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(text_tienthu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(button_calculator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(button_danh_sach_chi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_chinhsua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_chinhsua1ActionPerformed

        ChiJPanel chiJPanel = new ChiJPanel(id_user);
        JFrame newFrame = new JFrame("Chỉnh sửa");
        newFrame.getContentPane().add(chiJPanel);
        newFrame.setSize(330, 150);
        newFrame.setLocationRelativeTo(null);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Gọi phương thức để xử lý lại request hoặc làm mới trang
                DanhMucChi.updateDanhMucChiPanel(id_user, panel_danhmuc, buttonGroup1, button_chinhsua1);
            }
        });
        newFrame.setVisible(true);
    }//GEN-LAST:event_button_chinhsua1ActionPerformed

    private void text_ghichuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_ghichuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_ghichuActionPerformed

    private void button_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_saveActionPerformed
        
        int choice_addLog = JOptionPane.showConfirmDialog(Chi.this, "Bạn có chắc muốn thêm vào không!", "Thông báo",JOptionPane.YES_NO_OPTION);
        if(choice_addLog == JOptionPane.YES_OPTION){
            Date date = jDateChooser1.getDate();
        
            if(date == null){
                JOptionPane.showMessageDialog(Chi.this, "Vui lòng nhập đúng định dạng ngày!","Thông báo", JOptionPane.OK_OPTION);
            }

            String ghichu = text_ghichu.getText();

            int tienthu = 0;
            try {
                tienthu = Integer.parseInt(String.valueOf(text_tienthu.getText()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(Chi.this, "Vụi lòng nhập đúng số tiền!", "Thông báo",JOptionPane.OK_OPTION);
            }
            String id_Type = "";

            for (Enumeration<AbstractButton> buttons = buttonGroup1.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    id_Type = button.getActionCommand();
                    break;
                }
            }
            if(id_Type.equals("")){
                JOptionPane.showMessageDialog(Chi.this, "Vui lòng chọn một danh mục!","Thông báo", JOptionPane.OK_OPTION);
                return;
            }
            LogO log = new LogO();
            
            log.setUser_ID(id_user);
            log.setID_Type(Integer.parseInt(id_Type));
            log.setNote(ghichu);
            log.setPrice(tienthu);
            log.setDateString(Utils.Utils.converDateToString(date, "dd/MM/yyyy"));
            try {
                logController.addLog(log);
                JOptionPane.showMessageDialog(Chi.this, "Thành Công","Thông báo", JOptionPane.OK_OPTION);
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(Chi.this, "Thất bại","Thông báo", JOptionPane.OK_OPTION);
            }
        }
        
        
        
    }//GEN-LAST:event_button_saveActionPerformed

    private void button_calculatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_calculatorActionPerformed
        Calculator_Chi calculator = new Calculator_Chi(this);
        calculator.setVisible(true);
        
    }//GEN-LAST:event_button_calculatorActionPerformed

    private void button_danh_sach_chiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_danh_sach_chiActionPerformed
        dialog_dsThu.setVisible(true);
    }//GEN-LAST:event_button_danh_sach_chiActionPerformed

//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Chi(1).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton button_calculator;
    private javax.swing.JButton button_chinhsua1;
    private javax.swing.JButton button_danh_sach_chi;
    private javax.swing.JButton button_save;
    private javax.swing.JDialog dialog_dsThu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panel_danhmuc;
    private javax.swing.JTextField text_ghichu;
    private javax.swing.JTextField text_tienthu;
    // End of variables declaration//GEN-END:variables
}
