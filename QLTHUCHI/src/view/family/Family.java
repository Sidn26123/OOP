
package view.family;

import LoginSignup.Model.User;
import controller.FamilyController;
import controller.LogController;
import controller.TypeController;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
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
        initComponents();
        initTable();
        fillTable();
        setingUITable();
        setDefault();
        
    }
    
    private void setDefault(){
        int id_group = familyController.getID_Group(id_user);
        label_name_group.setText(familyController.getNameGroup(id_group));
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
    
    public void fillTable() {
        List<LogO> LogsGroup = logController.getLogGroup(familyController.getID_Group(id_user));
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
        jButton1 = new javax.swing.JButton();

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton1.setBackground(new java.awt.Color(0, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(336, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(label_name_group)
                        .addGap(299, 299, 299))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(label_name_group)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AddLogGroup addLogGroup =  new AddLogGroup(id_user,Family.this);
        addLogGroup.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_name_group;
    private javax.swing.JTable table_chi;
    // End of variables declaration//GEN-END:variables
}
