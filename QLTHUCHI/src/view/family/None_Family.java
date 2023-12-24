package view.family;
import LoginSignup.Model.JDBCConnection;
import LoginSignup.View.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import main.MainBoard;
public class None_Family extends javax.swing.JFrame {
    private int id_user;
    public None_Family(int id_user) {
        this.id_user = id_user;
        initComponents();
    }
    JDBCConnection connect = new JDBCConnection();

//    private None_Family(int i) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TaoGroup = new javax.swing.JButton();
        TimGroup = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Bạn Chưa Có Hộ Gia Đình !!!");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/img/Family/z4968847676568_a821f864baf1f6f7f85d5cb55aeb772b.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setPreferredSize(new java.awt.Dimension(350, 350));

        TaoGroup.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        TaoGroup.setText("Tạo Mới Mã Hộ Gia Đình");
        TaoGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaoGroupActionPerformed(evt);
            }
        });

        TimGroup.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        TimGroup.setText("Tìm Mã Hộ Gia Đình");
        TimGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimGroupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(TaoGroup)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TimGroup)
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TaoGroup)
                    .addComponent(TimGroup))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(168, 168, 168))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public boolean check_Group_Name_Ton_Tai(String groupname) {
        try {
            Connection con = connect.getJDBCConnection();
            String sql = "SELECT * FROM Group_User WHERE Name_Group=?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, groupname);
                try (ResultSet rs = ps.executeQuery()) {
                    return rs.next();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }
    private void TaoGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaoGroupActionPerformed
        try {
            Connection con = connect.getJDBCConnection();
            String groupName;
            do {
                groupName = JOptionPane.showInputDialog(this, "Nhập tên nhóm (group_name):");
                if (groupName == null) {
                    return;
                } else if (groupName.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Tên nhóm không được để trống !", "Lỗi", JOptionPane.ERROR_MESSAGE);
                } else if (check_Group_Name_Ton_Tai(groupName)) {
                    JOptionPane.showMessageDialog(this, "Tên nhóm đã tồn tại !", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } while (groupName.isEmpty() || check_Group_Name_Ton_Tai(groupName));
                String sqlUpdateGroupUser = "INSERT INTO Group_User (HostID, Name_Group) VALUES (?, ?)";
                try (PreparedStatement psUpdateGroupUser = con.prepareStatement(sqlUpdateGroupUser)) {
                    psUpdateGroupUser.setInt(1, id_user);
                    psUpdateGroupUser.setString(2, groupName);
                    int n = psUpdateGroupUser.executeUpdate();

                    if (n > 0) {
                        int groupid = 0;
                        String sql = "Select ID_Group from Group_User WHERE HostID=?";
                        try (PreparedStatement ps = con.prepareStatement(sql)) {
                            ps.setInt(1, id_user);
                            try (ResultSet rs = ps.executeQuery()) {
                                if (rs.next()) {
                                    groupid = rs.getInt("ID_Group");
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        String sqlUpdateGroupID = "UPDATE [User] SET Group_ID = ? WHERE ID=?";
                        try (PreparedStatement psUpdateGroupID = con.prepareStatement(sqlUpdateGroupID)) {
                            psUpdateGroupID.setInt(1, groupid);
                            psUpdateGroupID.setInt(2, id_user);
                            int m = psUpdateGroupID.executeUpdate();

                            if (m > 0) {
                                JOptionPane.showMessageDialog(this, "Tạo nhóm thành công Với Group_ID: " + groupid);
                                setVisible(false);
                            } else {
                                JOptionPane.showMessageDialog(this, "Không thành công khi cập nhật Group_User.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Không thành công khi cập nhật Group_ID.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_TaoGroupActionPerformed
    public boolean check_Group_ID_Ton_Tai(String groupID) {
        try {
            Connection con = connect.getJDBCConnection();
            String sql = "SELECT * FROM Group_User WHERE ID_Group=?";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, groupID);

                try (ResultSet rs = ps.executeQuery()) {
                    return rs.next();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }
    private boolean check_number(String str) {
        return str.matches("\\d*\\.?\\d+");
    }

    private void TimGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimGroupActionPerformed
    try {
        Connection con = connect.getJDBCConnection();
        int groupid = 0;
        String input = JOptionPane.showInputDialog(this, "Nhập ID Group (group_id):");
        if (input == null) {
            return;
        }
        if (check_number(input)) {
            JOptionPane.showMessageDialog(this, "ID Group không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;}
        groupid = Integer.parseInt(input);
        if (!check_Group_ID_Ton_Tai(String.valueOf(groupid))) {
            JOptionPane.showMessageDialog(this, "ID_Group không tồn tại!", "Thử lại!", JOptionPane.ERROR_MESSAGE);
            return;
            }
        String sqlUpdateGroupID = "UPDATE [User] SET Group_ID = ? WHERE ID=?";
            PreparedStatement psUpdateGroupID = con.prepareStatement(sqlUpdateGroupID);
            psUpdateGroupID.setInt(1, groupid);
            psUpdateGroupID.setInt(2, id_user);

            int n = psUpdateGroupID.executeUpdate();
            System.out.println(n);
            if (n > 0) {
                    JOptionPane.showMessageDialog(this, "Cập nhật thông tin nhóm thành công Với Group_ID: " + groupid);
                } else {
                    JOptionPane.showMessageDialog(this, "Không thành công khi cập nhật Group_User.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_TimGroupActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new None_Family( 13).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TaoGroup;
    private javax.swing.JButton TimGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
