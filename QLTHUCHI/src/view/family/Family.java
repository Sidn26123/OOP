
package view.family;

import LoginSignup.Model.User;
import controller.FamilyController;
import controller.LogController;
import controller.TypeController;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.objects.LogO;


public class Family extends javax.swing.JFrame {
    
    private int id_user;
    private DefaultTableModel tblModel = new DefaultTableModel();
    TypeController typeController = new TypeController();
    LogController logController = new LogController();
    public List<List<String>> UserChoce = new ArrayList<>();
    FamilyController familyController = new FamilyController();

    public Family(int id_user) {
        this.id_user = id_user;
        Calendar c = Calendar.getInstance();
        initComponents();
        initTable();
        fillTable(c);
        setingUITable();
        setDefault();
        
    }
    
    private void setDefault(){
        int id_group = familyController.getID_Group(id_user);
        label_name_group.setText(familyController.getNameGroup(id_group));
        label_name_group.setHorizontalAlignment(JLabel.CENTER);
        
        button_next.setIcon(new ImageIcon("src\\source\\img\\Calendar\\icons8-next-24.png"));
        button_pre.setIcon(new ImageIcon("src\\source\\img\\Calendar\\icons8-previous-24.png"));
        Calendar c = Calendar.getInstance();
        setTextLabelDate(c);
        label_date.setHorizontalAlignment(JLabel.CENTER);
    }
    
    public void setTextLabelDate(Calendar c){
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
    
    
    
    private void setingUITable(){
        TableColumn column1 = table_chi.getColumnModel().getColumn(0);
        column1.setPreferredWidth(120);
        TableColumn column2 = table_chi.getColumnModel().getColumn(1);
        column2.setPreferredWidth(250);
        TableColumn column3 = table_chi.getColumnModel().getColumn(2);
        column3.setPreferredWidth(90);
        TableColumn column4 = table_chi.getColumnModel().getColumn(3);
        column4.setPreferredWidth(50);
        TableColumn column5 = table_chi.getColumnModel().getColumn(4);
        column5.setPreferredWidth(50);
        TableColumn column6 = table_chi.getColumnModel().getColumn(5);
        column6.setPreferredWidth(50);
        table_chi.setGridColor(new Color(0xFFFF33));
    }

    private void initTable() {
        String[] header = new String[]{"Người tạo", "Người chi", "Tên", "Loại", "Ngày", "Số tiền"};
        tblModel.setColumnIdentifiers(header);
        table_chi.setModel(tblModel);
        table_chi.getTableHeader().setFont(new Font("Times New Roman",Font.PLAIN, 18));
    }
    
    public void fillTable(Calendar c) {
        int month = c.get(Calendar.MONTH) + 1;
        int year = c.get(Calendar.YEAR);
        List<LogO> LogsGroup = logController.getLogGroup(familyController.getID_Group(id_user), month, year);
        tblModel.setRowCount(0);
        for (LogO log : LogsGroup) {
            User user = logController.getInfoUserById_log(log.getID());
            tblModel.addRow(new String[]{user.getName(),getNguoiKhac(log.getID()),
                log.getNote(), typeController.findTypeByID_Type(log.getID_Type()).getName_Type(),
                log.getDateString(), String.valueOf(log.getPrice())});
        }
        tblModel.fireTableDataChanged();
    }
    
    private String getNguoiKhac(int id_log){
        String name_usersChoice = "<html>";
        int cnt = 1;
        List<List<String>> ls_user_choice = familyController.getUserChoice(id_log);
        for(List<String> user_choice: ls_user_choice){
            if(ls_user_choice.size() == 1){
                name_usersChoice += user_choice.get(1);
            }
            else if(ls_user_choice.size() == cnt){
                name_usersChoice += user_choice.get(1);
            }
            else{
                if(cnt % 2 == 0){
                    name_usersChoice += user_choice.get(1) + "<br>";
                }
                else{
                    name_usersChoice += user_choice.get(1) + ", ";
                }
                
                cnt++;
            }
        }
        return name_usersChoice + "</html>";
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label_name_group = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_chi = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        button_sum = new javax.swing.JButton();
        label_sum = new javax.swing.JLabel();
        button_tongket = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_tongket = new javax.swing.JTable();
        button_add = new javax.swing.JButton();
        button_delete = new javax.swing.JButton();
        button_update = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        label_date = new javax.swing.JLabel();
        button_pre = new javax.swing.JButton();
        button_next = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 605));
        setResizable(false);

        label_name_group.setFont(new java.awt.Font("Segoe Script", 0, 26)); // NOI18N
        label_name_group.setForeground(new java.awt.Color(0, 255, 255));
        label_name_group.setText("Tên gia đình");

        table_chi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        table_chi.setModel(new javax.swing.table.DefaultTableModel(
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
        table_chi.setToolTipText("");
        table_chi.setGridColor(new java.awt.Color(255, 255, 51));
        table_chi.setRowHeight(45);
        table_chi.setSelectionBackground(new java.awt.Color(51, 102, 255));
        jScrollPane1.setViewportView(table_chi);

        button_sum.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        button_sum.setText("Tổng");

        label_sum.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_sum.setText("0");

        button_tongket.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        button_tongket.setText("Tổng kết");

        table_tongket.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(table_tongket);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(button_tongket)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_sum)
                .addGap(35, 35, 35)
                .addComponent(label_sum, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_sum)
                    .addComponent(label_sum)
                    .addComponent(button_tongket))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        button_add.setBackground(new java.awt.Color(0, 255, 255));
        button_add.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        button_add.setForeground(new java.awt.Color(255, 255, 255));
        button_add.setText("Thêm");
        button_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_addActionPerformed(evt);
            }
        });

        button_delete.setBackground(new java.awt.Color(255, 0, 51));
        button_delete.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        button_delete.setForeground(new java.awt.Color(255, 255, 255));
        button_delete.setText("Xóa");

        button_update.setBackground(new java.awt.Color(51, 255, 0));
        button_update.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        button_update.setForeground(new java.awt.Color(255, 255, 255));
        button_update.setText("Sửa");

        jPanel3.setBackground(new java.awt.Color(0, 255, 204));
        jPanel3.setPreferredSize(new java.awt.Dimension(320, 24));

        label_date.setBackground(new java.awt.Color(0, 255, 204));
        label_date.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_date, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 24, Short.MAX_VALUE)
                .addComponent(label_date))
        );

        button_pre.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        button_pre.setPreferredSize(new java.awt.Dimension(24, 24));
        button_pre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_preActionPerformed(evt);
            }
        });

        button_next.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        button_next.setPreferredSize(new java.awt.Dimension(24, 24));
        button_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_nextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 196, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(button_add)
                        .addGap(18, 18, 18)
                        .addComponent(button_update)
                        .addGap(18, 18, 18)
                        .addComponent(button_delete)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(button_pre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_next, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(245, 245, 245))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_name_group, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_name_group)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_add)
                    .addComponent(button_update)
                    .addComponent(button_delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_pre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_next, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_addActionPerformed
        AddLogGroup addLogGroup =  new AddLogGroup(id_user,Family.this);
        addLogGroup.setVisible(true);
    }//GEN-LAST:event_button_addActionPerformed

    private void button_preActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_preActionPerformed
        Calendar c = getPreviousMonth();
        setTextLabelDate(c);
        fillTable(c);
    }//GEN-LAST:event_button_preActionPerformed

    private void button_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_nextActionPerformed
        Calendar c = getNextMonth();
        setTextLabelDate(c);
        fillTable(c);
    }//GEN-LAST:event_button_nextActionPerformed

    public void getLsNguoiChi(List<List<String>> UserChoce){
        this.UserChoce = UserChoce;
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Family(13).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_add;
    private javax.swing.JButton button_delete;
    private javax.swing.JButton button_next;
    private javax.swing.JButton button_pre;
    private javax.swing.JButton button_sum;
    private javax.swing.JButton button_tongket;
    private javax.swing.JButton button_update;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_date;
    private javax.swing.JLabel label_name_group;
    private javax.swing.JLabel label_sum;
    private javax.swing.JTable table_chi;
    private javax.swing.JTable table_tongket;
    // End of variables declaration//GEN-END:variables
}
