
package main;

import LoginSignup.Model.JDBCConnection;
import LoginSignup.View.Login;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import LoginSignup.View.Login;
import charts.chart.BarChart.chartTest;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.Chi.Chi;
import view.calendar.Calendars;
import view.chart.ChartView;
import view.family.Family;
import view.family.None_Family;
import view.thu.Thu;
import views.CalendarT;

public class MainBoard extends javax.swing.JFrame {
    JDBCConnection connect = new JDBCConnection();
    private int id_user;
    JPanel panel_thu;
    JPanel panel_calendar;
    JPanel panel_None_family;
    JPanel panel_family;
    JPanel panel_chi;
    JPanel panel_char;
    
    public MainBoard(int id_user) {
        this.id_user = id_user;
        initComponents();
        setDefaultThings();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        button_logout = new javax.swing.JButton();
        panel_parent = new javax.swing.JPanel();
        button_thu = new javax.swing.JButton();
        button_chi = new javax.swing.JButton();
        button_chart = new javax.swing.JButton();
        button_calendar = new javax.swing.JButton();
        button_dotted = new javax.swing.JButton();
        button_family = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(730, 588));

        button_logout.setBackground(new java.awt.Color(0, 255, 255));
        button_logout.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        button_logout.setForeground(new java.awt.Color(255, 255, 255));
        button_logout.setText("Đăng xuất");
        button_logout.setBorder(null);
        button_logout.setPreferredSize(new java.awt.Dimension(48, 48));
        button_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_logoutActionPerformed(evt);
            }
        });

        panel_parent.setAutoscrolls(true);
        panel_parent.setPreferredSize(new java.awt.Dimension(800, 650));
        panel_parent.setLayout(new java.awt.CardLayout());

        button_thu.setPreferredSize(new java.awt.Dimension(48, 48));
        button_thu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_thuActionPerformed(evt);
            }
        });

        button_chi.setPreferredSize(new java.awt.Dimension(48, 48));
        button_chi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_chiActionPerformed(evt);
            }
        });

        button_chart.setPreferredSize(new java.awt.Dimension(48, 48));
        button_chart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_chartActionPerformed(evt);
            }
        });

        button_calendar.setPreferredSize(new java.awt.Dimension(48, 48));
        button_calendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_calendarActionPerformed(evt);
            }
        });

        button_dotted.setPreferredSize(new java.awt.Dimension(48, 48));

        button_family.setPreferredSize(new java.awt.Dimension(48, 48));
        button_family.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_familyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_chi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_thu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_chart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_calendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_dotted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_family, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_parent, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(button_thu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(button_chi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(button_chart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(button_calendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button_family, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(button_dotted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(button_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addComponent(panel_parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_logoutActionPerformed
        this.setVisible(false);
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_button_logoutActionPerformed

    private void button_thuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_thuActionPerformed
        panel_parent.removeAll();
        panel_parent.add(panel_thu);
        panel_parent.repaint();
        panel_parent.revalidate();
    }//GEN-LAST:event_button_thuActionPerformed

    private void button_chiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_chiActionPerformed
        panel_parent.removeAll();
        panel_parent.add(panel_chi);
        panel_parent.repaint();
        panel_parent.revalidate();
    }//GEN-LAST:event_button_chiActionPerformed

    private void button_chartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_chartActionPerformed
        panel_parent.removeAll();
        panel_parent.add(panel_char);
        panel_parent.repaint();
        panel_parent.revalidate();
    }//GEN-LAST:event_button_chartActionPerformed

    
    public JPanel getPanel_parent(){
        return this.panel_parent;
    }
    public JPanel getPanelFamily(){
        return this.panel_family;
    }
    public void appear_panel_family(){
        Family family = new Family(id_user, this);
        panel_family.removeAll();
        panel_family.add(family.getContentPane());
        panel_parent.removeAll();
        panel_parent.add(panel_family);
        panel_parent.repaint();
        panel_parent.revalidate();
    }
    public void appear_panel_none_family(){
        panel_None_family = new JPanel();
        None_Family none_family = new None_Family(id_user, this);
        panel_None_family.add(none_family.getContentPane());
        panel_parent.removeAll();
        panel_parent.add(panel_None_family);
        panel_parent.repaint();
        panel_parent.revalidate();
    }
    
    public void appear_panel_thu(){
        panel_thu = new JPanel();
        Thu thu = new Thu(id_user);
        panel_thu.add(thu.getContentPane());
        panel_parent.removeAll();
        panel_parent.add(panel_thu);
        panel_parent.repaint();
        panel_parent.revalidate();
    }
    
    private void button_calendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_calendarActionPerformed
        panel_parent.removeAll();
        panel_parent.add(panel_calendar);
        panel_parent.repaint();
        panel_parent.revalidate();
    }//GEN-LAST:event_button_calendarActionPerformed

    public void check_Group_ID(int ID){       
        String sql = "SELECT Group_ID FROM [User] WHERE ID = ?";
        try (Connection con = connect.getJDBCConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, id_user);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                String groupID = rs.getString("Group_ID");
                panel_parent.removeAll();
                if (groupID != null) {
                    panel_parent.add(panel_family);
                } else {
                    panel_parent.add(panel_None_family);
                }
                    panel_parent.repaint();
                    panel_parent.revalidate();
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
            }
        }    
    private void button_familyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_familyActionPerformed
        
        check_Group_ID(id_user);
    }//GEN-LAST:event_button_familyActionPerformed

    
    private void setDefaultThings(){
        panel_thu = new JPanel();
        Thu thu = new Thu(id_user);
        panel_thu.add(thu.getContentPane());
        
        panel_chi = new JPanel();
        Chi chi = new Chi(id_user);
        panel_chi.add(chi.getContentPane());
        
        panel_calendar = new JPanel();
//        Calendars calendar = new Calendars(id_user);
//        panel_calendar.add(calendar);
        CalendarT calendarT = new CalendarT(id_user);
        panel_calendar.add(calendarT);
        panel_family = new JPanel();
        Family family = new Family(id_user, this);
        panel_family.add(family.getContentPane());
        
        panel_None_family = new JPanel();
        None_Family none_family = new None_Family(id_user, this);
        panel_None_family.add(none_family.getContentPane());       
        
        panel_parent.add(panel_thu);
        
//        ChartView chartView = new ChartView();
        chartTest chTest = new chartTest();
        panel_char = new JPanel();
        panel_char.add(chTest.getContentPane());
        

        
        button_thu.setIcon(new ImageIcon("src\\source\\img\\Thu_Chi\\icons8-coin-wallet-48.png"));
        button_thu.setSelected(true);
        
        button_chi.setIcon(new ImageIcon("src\\source\\img\\Thu_Chi\\icons8-money-transfer-48.png"));
        button_chart.setIcon(new ImageIcon("src\\source\\img\\Thu_Chi\\icons8-chart-48.png"));
        button_calendar.setIcon(new ImageIcon("src\\source\\img\\Thu_Chi\\icons8-calendar-48.png"));
        button_dotted.setIcon(new ImageIcon("src\\source\\img\\Thu_Chi\\icons8-more-48.png"));
        button_family.setIcon(new ImageIcon("src\\source\\img\\Thu_Chi\\icons8-house-48.png"));
    }
  
    public static void main(String[] args) {
        new MainBoard(13).setVisible(true);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_calendar;
    private javax.swing.JButton button_chart;
    private javax.swing.JButton button_chi;
    private javax.swing.JButton button_dotted;
    private javax.swing.JButton button_family;
    private javax.swing.JButton button_logout;
    private javax.swing.JButton button_thu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panel_parent;
    // End of variables declaration//GEN-END:variables
}
