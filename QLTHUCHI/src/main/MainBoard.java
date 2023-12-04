
package main;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import view.thu.Test;
import view.thu.Thu;

public class MainBoard extends javax.swing.JFrame {
    private int id_user;
    JPanel panel_thu;
    JPanel testJPanel;
    
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        button_calendar.setPreferredSize(new java.awt.Dimension(48, 48));

        button_dotted.setPreferredSize(new java.awt.Dimension(48, 48));

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
                            .addComponent(button_dotted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_parent, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(button_thu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(button_chi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(button_chart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(button_calendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(button_dotted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(button_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addComponent(panel_parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_logoutActionPerformed
        this.setVisible(false);
//        new Login().setVisible(true);
    }//GEN-LAST:event_button_logoutActionPerformed

    private void button_thuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_thuActionPerformed
        panel_parent.removeAll();
        panel_parent.add(panel_thu);
        panel_parent.repaint();
        panel_parent.revalidate();
    }//GEN-LAST:event_button_thuActionPerformed

    private void button_chiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_chiActionPerformed
        
    }//GEN-LAST:event_button_chiActionPerformed
    
    private void setDefaultThings(){
        panel_thu = new JPanel();
        Thu thu = new Thu(id_user);
        panel_thu.add(thu.getContentPane());
        panel_parent.add(panel_thu);

        
        button_thu.setIcon(new ImageIcon("src\\source\\img\\Thu_Chi\\icons8-get-revenue-48.png"));
        button_thu.setSelected(true);
        
        button_chi.setIcon(new ImageIcon("src\\source\\img\\Thu_Chi\\icons8-donate-48.png"));
        button_chart.setIcon(new ImageIcon("src\\source\\img\\Thu_Chi\\icons8-chart-48.png"));
        button_calendar.setIcon(new ImageIcon("src\\source\\img\\Thu_Chi\\icons8-calendar-48.png"));
        button_dotted.setIcon(new ImageIcon("src\\source\\img\\Thu_Chi\\icons8-more-48.png"));
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainBoard(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_calendar;
    private javax.swing.JButton button_chart;
    private javax.swing.JButton button_chi;
    private javax.swing.JButton button_dotted;
    private javax.swing.JButton button_logout;
    private javax.swing.JButton button_thu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panel_parent;
    // End of variables declaration//GEN-END:variables
}
