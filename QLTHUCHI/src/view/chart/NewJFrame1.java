/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.chart;

/**
 *
 * @author sidac
 */
public class NewJFrame1 extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame1
     */
    public NewJFrame1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        chartTop2 = new javax.swing.JPanel();
        chartTop1 = new javax.swing.JPanel();
        chartTop3 = new javax.swing.JPanel();
        barChart = new javax.swing.JPanel();
        updateDataBtn = new javax.swing.JButton();
        dateValueLabel = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        javax.swing.GroupLayout chartTop2Layout = new javax.swing.GroupLayout(chartTop2);
        chartTop2.setLayout(chartTop2Layout);
        chartTop2Layout.setHorizontalGroup(
            chartTop2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        chartTop2Layout.setVerticalGroup(
            chartTop2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jPanel1.add(chartTop2);
        chartTop2.setBounds(200, 110, 150, 150);

        javax.swing.GroupLayout chartTop1Layout = new javax.swing.GroupLayout(chartTop1);
        chartTop1.setLayout(chartTop1Layout);
        chartTop1Layout.setHorizontalGroup(
            chartTop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        chartTop1Layout.setVerticalGroup(
            chartTop1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jPanel1.add(chartTop1);
        chartTop1.setBounds(20, 110, 150, 150);

        javax.swing.GroupLayout chartTop3Layout = new javax.swing.GroupLayout(chartTop3);
        chartTop3.setLayout(chartTop3Layout);
        chartTop3Layout.setHorizontalGroup(
            chartTop3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        chartTop3Layout.setVerticalGroup(
            chartTop3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jPanel1.add(chartTop3);
        chartTop3.setBounds(380, 110, 150, 150);

        javax.swing.GroupLayout barChartLayout = new javax.swing.GroupLayout(barChart);
        barChart.setLayout(barChartLayout);
        barChartLayout.setHorizontalGroup(
            barChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        barChartLayout.setVerticalGroup(
            barChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jPanel1.add(barChart);
        barChart.setBounds(20, 290, 440, 300);

        updateDataBtn.setText("jButton1");
        updateDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDataBtnActionPerformed(evt);
            }
        });
        jPanel1.add(updateDataBtn);
        updateDataBtn.setBounds(490, 50, 20, 20);

        dateValueLabel.setText("jTextField1");
        jPanel1.add(dateValueLabel);
        dateValueLabel.setBounds(350, 50, 120, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(60, 30, 550, 650);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateDataBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateDataBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barChart;
    private javax.swing.JPanel chartTop1;
    private javax.swing.JPanel chartTop2;
    private javax.swing.JPanel chartTop3;
    private javax.swing.JTextField dateValueLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton updateDataBtn;
    // End of variables declaration//GEN-END:variables
}
