package view.family;

import LoginSignup.Model.JDBCConnection;
import controller.FamilyController;
import controller.LogController;
import controller.TypeController;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.objects.LogO;
import model.objects.TypeO;
import LoginSignup.Model.User;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class Editform extends javax.swing.JFrame {
    TypeController typeController;
    LogController logController;
    private int id_user;
    private Family family;
    private DefaultTableModel tblModel = new DefaultTableModel();
    FamilyController familyController = new FamilyController();
    public List<List<String>> UserChoce = new ArrayList<>();
    String selectedValue;
    
    JDBCConnection connect = new JDBCConnection();
    
    public Editform( int id_user, Family family) throws ParseException {
        this.family = family;
        this.id_user = id_user;
        initComponents();
        Calendar c = Calendar.getInstance();
        setDefaultThings();
        initTable();
        fillTableDs_NguoiChi();
        loadCategories();
        Filltoupdate();
    }
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        dialog_dsNguoiChi = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_ds_nguoiChi = new javax.swing.JTable();
        button_add = new javax.swing.JButton();
        button_save_ds = new javax.swing.JButton();
        box_ls = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        button_delete_ds = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        box_loai = new javax.swing.JComboBox<>();
        txttien = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        txtnguoichi = new javax.swing.JTextField();
        dsachnguoichi = new javax.swing.JButton();
        txtghichu = new javax.swing.JTextField();

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
        box_ls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_lsActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe Script", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 255, 255));
        jLabel8.setText("Danh Sách");

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
                .addComponent(jLabel8)
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
                    .addComponent(jLabel8))
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Người Chi:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 34, 0, 0);
        getContentPane().add(jLabel2, gridBagConstraints);

        jLabel3.setText("Ghi Chú");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 49, 0, 0);
        getContentPane().add(jLabel3, gridBagConstraints);

        jLabel4.setText("Loại:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 65, 0, 0);
        getContentPane().add(jLabel4, gridBagConstraints);

        btnEdit.setText("Lưu");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(33, 18, 26, 0);
        getContentPane().add(btnEdit, gridBagConstraints);

        btnCancel.setText("Hủy bỏ");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(33, 24, 26, 0);
        getContentPane().add(btnCancel, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel5.setText("Chỉnh Sửa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 54, 0, 0);
        getContentPane().add(jLabel5, gridBagConstraints);

        jLabel6.setText("Ngày:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 60, 0, 0);
        getContentPane().add(jLabel6, gridBagConstraints);

        jLabel7.setText("Số Tiền:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 48, 0, 0);
        getContentPane().add(jLabel7, gridBagConstraints);

        box_loai.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        box_loai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_loaiActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 278;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 18, 0, 0);
        getContentPane().add(box_loai, gridBagConstraints);

        txttien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txttien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttienActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 286;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 0);
        getContentPane().add(txttien, gridBagConstraints);

        jDateChooser1.setBackground(new java.awt.Color(245, 177, 109));
        jDateChooser1.setForeground(new java.awt.Color(255, 0, 0));
        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jDateChooser1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 268;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 0);
        getContentPane().add(jDateChooser1, gridBagConstraints);

        txtnguoichi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtnguoichi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnguoichiActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 286;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 0);
        getContentPane().add(txtnguoichi, gridBagConstraints);

        dsachnguoichi.setText("Chọn");
        dsachnguoichi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dsachnguoichiActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 18, 0, 29);
        getContentPane().add(dsachnguoichi, gridBagConstraints);

        txtghichu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtghichu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtghichuActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 286;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 18, 0, 0);
        getContentPane().add(txtghichu, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents
        private void initTable() {
        String[] header = new String[]{"ID","Họ và Tên", "Email"};
        tblModel.setColumnIdentifiers(header);
        table_ds_nguoiChi.setModel(tblModel);
        table_ds_nguoiChi.getTableHeader().setFont(new Font("Times New Roman",Font.PLAIN, 18));
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
    private void Filltoupdate() throws ParseException{
        LogO log = family.getlogselect();
        txtghichu.setText(log.getNote());
        txttien.setText(String.valueOf(log.getPrice()));
        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(log.getDateString());
        jDateChooser1.setDate(date1);
    }
    private void setDefaultThings(){
        dialog_dsNguoiChi.setSize(500,500);
        dialog_dsNguoiChi.setLocationRelativeTo(null);
        dialog_dsNguoiChi.setTitle("Danh sách người chi");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        logController = new LogController();
        jDateChooser1.setDate(Calendar.getInstance().getTime());
        this.setLocationRelativeTo(null);
        initTable();
        fillTableDs_NguoiChi();
        TableColumn column1 = table_ds_nguoiChi.getColumnModel().getColumn(0);
        column1.setPreferredWidth(0);
        TableColumn column2 = table_ds_nguoiChi.getColumnModel().getColumn(1);
        column2.setPreferredWidth(180);
        TableColumn column3 = table_ds_nguoiChi.getColumnModel().getColumn(2);
        column3.setPreferredWidth(180);
    }
    private void updateNguoiChiText() {
        StringBuilder nguoiChiText = new StringBuilder();

        for (List<String> user : UserChoce) {
            nguoiChiText.append(user.get(1)).append(", ");
        }

        // Xóa dấu "," cuối cùng nếu có
        if (nguoiChiText.length() > 0) {
            nguoiChiText.delete(nguoiChiText.length() - 2, nguoiChiText.length());
        }

        txtnguoichi.setText(nguoiChiText.toString());
    }
    private void loadCategories() {
        typeController = new TypeController();
        List<TypeO> types = typeController.getAllTypeReceipt(id_user);
        // Thêm tên danh mục vào box_loai
        for (TypeO type : types) {
            String categoryName = type.getName_Type();
            box_loai.addItem(categoryName);
            
        }
//    TypeO type = new TypeO();
//   int id_log = logController.getID_Log();
//    
//    String past = typeController.findTypeByID_Type(log.getID_Type()).getName_Type(); 
//    box_loai.setSelectedItem(past);
    }
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        
        Date date = jDateChooser1.getDate();
        
            if(date == null){
                JOptionPane.showMessageDialog(Editform.this, "Vui lòng nhập đúng định dạng ngày!","Thông báo", JOptionPane.OK_OPTION);
            }

            String ghichu = txtghichu.getText();

            int tienthu = 0;
            try {
                tienthu = Integer.valueOf(String.valueOf(txttien.getText()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(Editform.this, "Vụi lòng nhập đúng số tiền!", "Thông báo",JOptionPane.OK_OPTION);
                return;
            }
            
            String id_Type =  String.valueOf(typeController.findId_typeByName(selectedValue).getID_Type());
          
            
            if(id_Type.equals("")){
                JOptionPane.showMessageDialog(Editform.this, "Vui lòng chọn một danh mục!","Thông báo", JOptionPane.OK_OPTION);
                return;
            }
            
            if(UserChoce.isEmpty()){
                JOptionPane.showMessageDialog(Editform.this, "Vui lòng chọn người chi!", "Thông báo", JOptionPane.OK_OPTION);
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
                logController.updateLogGroup(log);
                int id_log = logController.getID_Log();
                familyController.updateLogGroup(UserChoce, id_log);
                Calendar c = Calendar.getInstance();
                String stringDate = Utils.Utils.converDateToString(date, "dd/MM/yyyy");
                c.set(Calendar.MONTH, Integer.parseInt(stringDate.split("/")[1])-1);
                c.set(Calendar.YEAR, Integer.parseInt(stringDate.split("/")[2]));
                System.out.println(( "update log"+stringDate.split("/")[1]) + " " + (stringDate.split("/")[2]));
                family.setTextLabelDate(c);
                family.fillTable(c);
                JOptionPane.showMessageDialog(Editform.this, "Thành Công","Thông báo", JOptionPane.OK_OPTION);
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(Editform.this, "Thất bại","Thông báo", JOptionPane.OK_OPTION);
            }
            this.dispose();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void box_loaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_loaiActionPerformed
        
        String selectedValue = box_loai.getSelectedItem().toString();   
        
    }//GEN-LAST:event_box_loaiActionPerformed

    private void txttienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttienActionPerformed
    
    private void txtnguoichiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnguoichiActionPerformed
        
    }//GEN-LAST:event_txtnguoichiActionPerformed

    private void dsachnguoichiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dsachnguoichiActionPerformed
        dialog_dsNguoiChi.setSize(425, 325);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        dialog_dsNguoiChi.setLocation(dim.width/2-dialog_dsNguoiChi.getSize().width/2 + 530, dim.height/2-dialog_dsNguoiChi.getSize().height/2 - 110);
        dialog_dsNguoiChi.setVisible(true);
    }//GEN-LAST:event_dsachnguoichiActionPerformed

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
        updateNguoiChiText();
        JOptionPane.showMessageDialog(this, "Lưu thành công","Thông báo", JOptionPane.OK_OPTION);
    }//GEN-LAST:event_button_save_dsActionPerformed

    private void box_lsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_lsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box_lsActionPerformed

    private void button_delete_dsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_delete_dsActionPerformed
        try {
            String user = box_ls.getSelectedItem().toString();
            int position = box_ls.getSelectedIndex();
            UserChoce.remove(position);
            box_ls.removeItemAt(box_ls.getSelectedIndex());
            box_ls.updateUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Editform.this, "Vui lòng chọn một người để xóa","Thông báo", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_button_delete_dsActionPerformed

    private void txtghichuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtghichuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtghichuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box_loai;
    private javax.swing.JComboBox<String> box_ls;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton button_add;
    private javax.swing.JButton button_delete_ds;
    private javax.swing.JButton button_save_ds;
    private javax.swing.JDialog dialog_dsNguoiChi;
    private javax.swing.JButton dsachnguoichi;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_ds_nguoiChi;
    private javax.swing.JTextField txtghichu;
    private javax.swing.JTextField txtnguoichi;
    private javax.swing.JTextField txttien;
    // End of variables declaration//GEN-END:variables
}
