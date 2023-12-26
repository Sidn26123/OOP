
package view.family;

import controller.FamilyController;
import java.awt.Color;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import view.family.chart.Chart;
import view.family.chart.ModelChart;


public class Family_Chart extends javax.swing.JFrame {
    FamilyController familyController = new FamilyController();
    int id_user;
    
    public Family_Chart(int id_user) {
        this.id_user = id_user;
        initComponents();
        setDefault();
    }

    private void setDefault(){
        getContentPane().setBackground(new Color(250, 250, 250));
        familyController.getPricePerMonth(familyController.getID_Group(id_user), 2023, chart);
        this.setTitle("Biểu đồ chi trong năm");
        chart.addLegend("Chi", new Color(0, 255, 255));
        button_next.setIcon(new ImageIcon("src\\source\\img\\Calendar\\icons8-next-24.png"));
        button_pre.setIcon(new ImageIcon("src\\source\\img\\Calendar\\icons8-previous-24.png"));
        Calendar c = Calendar.getInstance();
        label_year.setText(String.valueOf(c.get(Calendar.YEAR)));
        label_year.setHorizontalAlignment(JLabel.CENTER);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chart = new view.family.chart.Chart();
        button_pre = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        label_year = new javax.swing.JLabel();
        button_next = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        button_pre.setPreferredSize(new java.awt.Dimension(24, 24));
        button_pre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_preActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 255, 204));

        label_year.setBackground(new java.awt.Color(0, 255, 204));
        label_year.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        label_year.setForeground(new java.awt.Color(255, 255, 255));
        label_year.setText("Năm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_year, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label_year))
        );

        button_next.setPreferredSize(new java.awt.Dimension(24, 24));
        button_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_nextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_pre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_next, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_pre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_next, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        button_pre.getAccessibleContext().setAccessibleName("button_pre");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_preActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_preActionPerformed
        chart.clear();
        int year = Integer.parseInt(label_year.getText()) - 1;
        label_year.setText(String.valueOf(year));
        familyController.getPricePerMonth(familyController.getID_Group(id_user), year, chart);
    }//GEN-LAST:event_button_preActionPerformed

    private void button_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_nextActionPerformed
        chart.clear();
        int year = Integer.parseInt(label_year.getText()) + 1;
        label_year.setText(String.valueOf(year));
        familyController.getPricePerMonth(familyController.getID_Group(id_user), year, chart);
    }//GEN-LAST:event_button_nextActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Family_Chart(13).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_next;
    private javax.swing.JButton button_pre;
    private view.family.chart.Chart chart;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_year;
    // End of variables declaration//GEN-END:variables
}
