package LoginSignup.View;

import java.sql.Connection;  
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import LoginSignup.Model.JDBCConnection;
public class SignUp extends javax.swing.JFrame {
    JDBCConnection connect = new JDBCConnection();
    public SignUp() {
        initComponents();
    }
//    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//    String url = "jdbc:sqlserver://localhost:1433;databaseName=QLCT;encrypt=true;trustServerCertificate=true";
//    String user = "sa";
//    String password = "sa";
//    Statement st;
//    ResultSet rs;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtgmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtconfirm = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtpass = new javax.swing.JPasswordField();
        txtphone = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SignUp");
        setAutoRequestFocus(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(6, 0, 400, 500);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(400, 500, 100, 100);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setMinimumSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Sign Up");
        jLabel1.setPreferredSize(new java.awt.Dimension(111, 48));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Email");

        txtgmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtgmail.setPreferredSize(new java.awt.Dimension(64, 22));
        txtgmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgmailActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Confirm Password");

        txtconfirm.setMinimumSize(new java.awt.Dimension(64, 26));
        txtconfirm.setPreferredSize(new java.awt.Dimension(64, 26));
        txtconfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtconfirmActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Full name");

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 51, 51));
        jButton2.setText("Login");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("I've an account !");

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 51, 51));
        jButton3.setText("Sign Up");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("UserName");

        txtuser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtuserActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("PhoneNumber");

        txtpass.setMinimumSize(new java.awt.Dimension(64, 26));
        txtpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassActionPerformed(evt);
            }
        });

        txtphone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtphoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtgmail, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txtconfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtgmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtconfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButton2))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(410, 0, 390, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtgmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgmailActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private boolean check_number(String str) {
        return str.matches("\\d*\\.?\\d+");
    }
    private boolean check_letter(String str) {
        return str.matches("[a-zA-Z]+");
    }
    private boolean Check_tai_khoan_da_ton_tai(String username, String email,String phonenumber) throws Exception {
         try {
            Connection con = connect.getJDBCConnection();
            String sql = "SELECT * FROM [User] WHERE UserName = ? OR EmailAddress = ? OR PhoneNumber=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, phonenumber);
            ResultSet rs = ps.executeQuery();
            return rs.next();
         }catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try{
            if (txtName.getText().equals("") | txtuser.getText().equals("") | txtgmail.getText().equals("") | txtphone.getText().equals("") | txtpass.getText().equals("") | txtconfirm.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Không Để Trống Thông Tin !","try again !",JOptionPane.ERROR_MESSAGE);
                return ;
            }
            if ( !txtconfirm.getText().equals(txtpass.getText())){
                JOptionPane.showMessageDialog(this, "Nhập Lại Mật Khẩu Không Trùng Nhau !","try again !",JOptionPane.ERROR_MESSAGE);
                return;
            }
            String email = txtgmail.getText().trim().toLowerCase();
            if (!email.contains("@gmail.com")) {
                JOptionPane.showMessageDialog(this, "Địa chỉ email phải có dạng '@gmail.com'", "Thử lại !", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String fullName = txtName.getText().trim();
            if (check_number(fullName)) {
                JOptionPane.showMessageDialog(this, "Họ và tên không được chứa chữ số !", "Thử lại !", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String PhoneNumber = txtphone.getText().trim();
            if (check_letter(PhoneNumber)) {
                JOptionPane.showMessageDialog(this, "Số Điện Thoại phải bao gồm các chữ số !", "Thử lại !", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (PhoneNumber.length() != 10) {
                JOptionPane.showMessageDialog(this, "Số điện thoại phải có 10 chữ số !!!", "Thử lại !", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (Check_tai_khoan_da_ton_tai(txtuser.getText(), txtgmail.getText(), txtphone.getText())) {
                JOptionPane.showMessageDialog(this, "Tên đăng nhập, Email hoặc Số điện thoại đã tồn tại!", "Thử lại !", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Connection con=connect.getJDBCConnection();
            String sql = "INSERT INTO [User] (Name ,UserName, Password,PhoneNumber,EmailAddress) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, txtName.getText());
            ps.setString(2, txtuser.getText());
            ps.setString(3, new String(txtpass.getPassword())); 
            ps.setString(4, txtphone.getText());
            ps.setString(5, txtgmail.getText());       
            int n = ps.executeUpdate();            
            if(n!=0){               
                JOptionPane.showMessageDialog(this, "Đăng Kí Thành Công !");
                Login LoginFrame = new Login();
                LoginFrame.setVisible(true);
                LoginFrame.pack();
                LoginFrame.setLocationRelativeTo(null);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this, "Đăng Kí Thất Bại !");
            } 
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtuserActionPerformed

    private void txtpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpassActionPerformed

    private void txtconfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtconfirmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtconfirmActionPerformed

    private void txtphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtphoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtphoneActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtconfirm;
    private javax.swing.JTextField txtgmail;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
