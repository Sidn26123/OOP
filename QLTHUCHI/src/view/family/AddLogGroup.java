package view.family;

import LoginSignup.Model.User;
import com.formdev.flatlaf.FlatLightLaf;
import controller.FamilyController;
import controller.LogController;
import controller.TypeController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.objects.LogO;
import model.objects.TypeO;
import view.calculator.Calculator;
import view.danhmuc.ThuJPanel;

/**
 *
 * @author LENOVO
 */
public class AddLogGroup extends javax.swing.JFrame {

    TypeController typeController;
    LogController logController;
    private int id_user;
    private Family family;
    private DefaultTableModel tblModel = new DefaultTableModel();
    FamilyController familyController = new FamilyController();
    public List<List<String>> UserChoce = new ArrayList<>();
    
    public AddLogGroup(int id_user, Family family) {
        this.family = family;
        this.id_user = id_user;
        FlatLightLaf.setup();
        initComponents();
        setDefaultThings();
        setPanelDanhMuc();
        
    }
    
    
    private void fillTableDs_NguoiChi() {
        List<User> users = familyController.getUsersGroup(id_user);

        tblModel.setRowCount(0);
        for (User user: users) {
            String id_user_choce = String.valueOf(user.getID());
            tblModel.addRow(new String[]{id_user_choce,user.getName(), user.getEmailAddress()});
        }
        tblModel.fireTableDataChanged();
        table_ds_nguoiChi.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }
    
    public void update_valueCalculator(double value){
        text_tienthu.setText(String.valueOf(value));
    }
    
    private void setDefaultThings(){
        dialog_dsNguoiChi.setSize(500,500);
        dialog_dsNguoiChi.setLocationRelativeTo(null);
        dialog_dsNguoiChi.setTitle("Danh sách người chi");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        button_save.setIcon(new ImageIcon("src\\source\\img\\Thu_Chi\\icons8-pencil-64.png"));
        logController = new LogController();
        jDateChooser1.setDate(Calendar.getInstance().getTime());
        this.setLocationRelativeTo(null);
        button_calculator.setIcon(new ImageIcon("src\\source\\img\\Thu_Chi\\icons8-calculator-64.png"));
        initTable();
        fillTableDs_NguoiChi();
        TableColumn column1 = table_ds_nguoiChi.getColumnModel().getColumn(0);
        column1.setPreferredWidth(0);
        TableColumn column2 = table_ds_nguoiChi.getColumnModel().getColumn(1);
        column2.setPreferredWidth(180);
        TableColumn column3 = table_ds_nguoiChi.getColumnModel().getColumn(2);
        column3.setPreferredWidth(180);
    }
    
    private void initTable() {
        String[] header = new String[]{"ID","Họ và Tên", "Email"};
        tblModel.setColumnIdentifiers(header);
        table_ds_nguoiChi.setModel(tblModel);
        table_ds_nguoiChi.getTableHeader().setFont(new Font("Times New Roman",Font.PLAIN, 18));
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
        dialog_dsNguoiChi = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_ds_nguoiChi = new javax.swing.JTable();
        button_add = new javax.swing.JButton();
        button_save_ds = new javax.swing.JButton();
        box_ls = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        button_delete_ds = new javax.swing.JButton();
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
        button_dsNguoiChi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        dialog_dsNguoiChi.setModal(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        table_ds_nguoiChi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        table_ds_nguoiChi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(table_ds_nguoiChi);

        button_add.setBackground(new java.awt.Color(0, 255, 255));
        button_add.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        button_add.setForeground(new java.awt.Color(255, 255, 255));
        button_add.setText("Thêm");
        button_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_addActionPerformed(evt);
            }
        });

        button_save_ds.setBackground(new java.awt.Color(255, 255, 0));
        button_save_ds.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        button_save_ds.setForeground(new java.awt.Color(255, 255, 255));
        button_save_ds.setText("Lưu");
        button_save_ds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_save_dsActionPerformed(evt);
            }
        });

        box_ls.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe Script", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setText("Danh Sách");

        button_delete_ds.setBackground(new java.awt.Color(255, 51, 51));
        button_delete_ds.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        button_delete_ds.setForeground(new java.awt.Color(255, 255, 255));
        button_delete_ds.setText("Xóa");
        button_delete_ds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_delete_dsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialog_dsNguoiChiLayout = new javax.swing.GroupLayout(dialog_dsNguoiChi.getContentPane());
        dialog_dsNguoiChi.getContentPane().setLayout(dialog_dsNguoiChiLayout);
        dialog_dsNguoiChiLayout.setHorizontalGroup(
            dialog_dsNguoiChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialog_dsNguoiChiLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jLabel2)
                .addGap(82, 82, 82)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialog_dsNguoiChiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_save_ds)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_delete_ds)
                .addGap(11, 11, 11))
            .addGroup(dialog_dsNguoiChiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(box_ls, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dialog_dsNguoiChiLayout.setVerticalGroup(
            dialog_dsNguoiChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialog_dsNguoiChiLayout.createSequentialGroup()
                .addGroup(dialog_dsNguoiChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(3, 3, 3)
                .addComponent(box_ls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(dialog_dsNguoiChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_save_ds)
                    .addComponent(button_add)
                    .addComponent(button_delete_ds))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        button_dsNguoiChi.setBackground(new java.awt.Color(51, 255, 255));
        button_dsNguoiChi.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        button_dsNguoiChi.setForeground(new java.awt.Color(255, 255, 255));
        button_dsNguoiChi.setText("Người Chi");
        button_dsNguoiChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_dsNguoiChiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe Script", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setText("Your Group");

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
                                .addGap(82, 82, 82)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(text_ghichu, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(button_dsNguoiChi)
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
                    .addComponent(button_dsNguoiChi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        new ThuJPanel(id_user).setVisible(true);
    }//GEN-LAST:event_button_chinhsua1ActionPerformed

    private void text_ghichuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_ghichuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_ghichuActionPerformed

    private void button_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_saveActionPerformed
        
        int choice_addLog = JOptionPane.showConfirmDialog(AddLogGroup.this, "Bạn có chắc muốn thêm vào không!", "Thông báo",JOptionPane.YES_NO_OPTION);
        if(choice_addLog == JOptionPane.YES_OPTION){
            Date date = jDateChooser1.getDate();
        
            if(date == null){
                JOptionPane.showMessageDialog(AddLogGroup.this, "Vui lòng nhập đúng định dạng ngày!","Thông báo", JOptionPane.OK_OPTION);
            }

            String ghichu = text_ghichu.getText();

            int tienthu = 0;
            try {
                tienthu = Integer.valueOf(String.valueOf(text_tienthu.getText()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(AddLogGroup.this, "Vụi lòng nhập đúng số tiền!", "Thông báo",JOptionPane.OK_OPTION);
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
                JOptionPane.showMessageDialog(AddLogGroup.this, "Vui lòng chọn một danh mục!","Thông báo", JOptionPane.OK_OPTION);
                return;
            }
            
            if(UserChoce.isEmpty()){
                JOptionPane.showMessageDialog(AddLogGroup.this, "Vui lòng chọn người chi!", "Thông báo", JOptionPane.OK_OPTION);
                return;
            }
            LogO log = new LogO();
            
            log.setGroup_ID(familyController.getID_Group(id_user));
            log.setUser_ID(id_user);
            log.setID_Type(Integer.parseInt(id_Type));
            log.setNote(ghichu);
            log.setPrice(tienthu);
            log.setDateString(Utils.Utils.converDateToString(date, "dd/MM/yyyy"));
            try {
                logController.addLogGroup(log);
                int id_log = logController.getID_Log();
                familyController.addLogGroup(UserChoce, id_log);
                Calendar c = Calendar.getInstance();
                String stringDate = Utils.Utils.converDateToString(date, "dd/MM/yyyy");
                c.set(Calendar.MONTH, Integer.parseInt(stringDate.split("/")[1])-1);
                c.set(Calendar.YEAR, Integer.parseInt(stringDate.split("/")[2]));
                family.setTextLabelDate(c);
                family.fillTable(c);
                family.sum_price_per_month();
                family.initTablePrice();
                JOptionPane.showMessageDialog(AddLogGroup.this, "Thành Công","Thông báo", JOptionPane.OK_OPTION);
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(AddLogGroup.this, "Thất bại","Thông báo", JOptionPane.OK_OPTION);
            }
        }
        
        
    }//GEN-LAST:event_button_saveActionPerformed

    private void button_calculatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_calculatorActionPerformed
        Calculator_family calculator = new Calculator_family(this);
        calculator.setVisible(true);
        
    }//GEN-LAST:event_button_calculatorActionPerformed

    private void button_dsNguoiChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_dsNguoiChiActionPerformed
        dialog_dsNguoiChi.setSize(425, 325);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        dialog_dsNguoiChi.setLocation(dim.width/2-dialog_dsNguoiChi.getSize().width/2 + 530, dim.height/2-dialog_dsNguoiChi.getSize().height/2 - 110);
        dialog_dsNguoiChi.setVisible(true);
    }//GEN-LAST:event_button_dsNguoiChiActionPerformed

    private void button_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_addActionPerformed
        int row = table_ds_nguoiChi.getSelectedRow();
        if(row >= 0){
            String name = table_ds_nguoiChi.getValueAt(row, 1).toString();
            String id_user_choice = table_ds_nguoiChi.getValueAt(row, 0).toString();
            List<String> tmp = new ArrayList<>();
            tmp.add(id_user_choice);
            tmp.add(name);
            if(!UserChoce.contains(tmp)){
                UserChoce.add(tmp);
                box_ls.addItem(name);
            }
        }
    }//GEN-LAST:event_button_addActionPerformed

    private void button_save_dsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_save_dsActionPerformed
        family.getLsNguoiChi(UserChoce);
        JOptionPane.showMessageDialog(this, "Lưu thành công","Thông báo", JOptionPane.OK_OPTION);
    }//GEN-LAST:event_button_save_dsActionPerformed

    private void button_delete_dsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_delete_dsActionPerformed
        try {
            String user = box_ls.getSelectedItem().toString();
            int position = box_ls.getSelectedIndex();
            UserChoce.remove(position);
            box_ls.removeItemAt(box_ls.getSelectedIndex());
            box_ls.updateUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(AddLogGroup.this, "Vui lòng chọn một người để xóa","Thông báo", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_button_delete_dsActionPerformed

//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AddLogGroup(13, new Family(13)).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box_ls;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton button_add;
    private javax.swing.JButton button_calculator;
    private javax.swing.JButton button_chinhsua1;
    private javax.swing.JButton button_delete_ds;
    private javax.swing.JButton button_dsNguoiChi;
    private javax.swing.JButton button_save;
    private javax.swing.JButton button_save_ds;
    private javax.swing.JDialog dialog_dsNguoiChi;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel_danhmuc;
    private javax.swing.JTable table_ds_nguoiChi;
    private javax.swing.JTextField text_ghichu;
    private javax.swing.JTextField text_tienthu;
    // End of variables declaration//GEN-END:variables
}
