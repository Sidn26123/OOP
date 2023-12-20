
package view.calendar;

import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Calendars extends javax.swing.JPanel {
    private int id_user;

    public Calendars(int id_user) {
        this.id_user = id_user;
        initComponents();
        setDefault();
    }

    private void setDefault(){
        button_next.setIcon(new ImageIcon("src\\source\\img\\Calendar\\icons8-next-50.png"));
        button_pre.setIcon(new ImageIcon("src\\source\\img\\Calendar\\icons8-previous-50.png"));
        Calendar c = Calendar.getInstance();
        setTextLabelDate(c);
        label_date.setHorizontalAlignment(JLabel.CENTER);

    }
    private void setTextLabelDate(Calendar c){
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button_pre = new javax.swing.JButton();
        button_next = new javax.swing.JButton();
        dateChooseBtn = new javax.swing.JButton();
        label_date = new javax.swing.JTextField();
        calendarWrapper = new javax.swing.JPanel();
        calendarShowPanel = new javax.swing.JPanel();
        calendarItem = new javax.swing.JPanel();
        dateItemLabel = new javax.swing.JLabel();
        incomeValueLabel = new javax.swing.JLabel();
        spentValueLabel = new javax.swing.JLabel();
        totalValueLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(637, 604));
        setLayout(null);

        button_pre.setBackground(new java.awt.Color(153, 153, 153));
        button_pre.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        button_pre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/img/Calendar/icons8-previous-50.png"))); // NOI18N
        button_pre.setBorder(null);
        button_pre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_preActionPerformed(evt);
            }
        });
        add(button_pre);
        button_pre.setBounds(140, 10, 20, 20);

        button_next.setBackground(new java.awt.Color(153, 153, 153));
        button_next.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        button_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/img/Calendar/icons8-next-50.png"))); // NOI18N
        button_next.setBorder(null);
        button_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_nextActionPerformed(evt);
            }
        });
        add(button_next);
        button_next.setBounds(410, 10, 20, 20);

        dateChooseBtn.setBackground(new java.awt.Color(153, 153, 153));
        dateChooseBtn.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        dateChooseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/img/Calendar/icons8-next-50.png"))); // NOI18N
        dateChooseBtn.setBorder(null);
        dateChooseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateChooseBtnActionPerformed(evt);
            }
        });
        add(dateChooseBtn);
        dateChooseBtn.setBounds(380, 10, 20, 20);

        label_date.setText("jTextField1");
        label_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label_dateActionPerformed(evt);
            }
        });
        add(label_date);
        label_date.setBounds(210, 10, 150, 30);

        calendarWrapper.setBackground(new java.awt.Color(153, 153, 255));
        calendarWrapper.setLayout(null);

        calendarShowPanel.setBackground(new java.awt.Color(255, 255, 255));
        calendarShowPanel.setLayout(new java.awt.GridLayout(5, 7));

        calendarItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calendarItemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                calendarItemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                calendarItemMouseExited(evt);
            }
        });
        calendarItem.setLayout(null);

        dateItemLabel.setText("jLabel1");
        calendarItem.add(dateItemLabel);
        dateItemLabel.setBounds(0, 0, 60, 20);

        incomeValueLabel.setText("jLabel1");
        calendarItem.add(incomeValueLabel);
        incomeValueLabel.setBounds(30, 20, 34, 14);

        spentValueLabel.setText("jLabel2");
        calendarItem.add(spentValueLabel);
        spentValueLabel.setBounds(30, 40, 34, 14);

        totalValueLabel.setText("jLabel3");
        calendarItem.add(totalValueLabel);
        totalValueLabel.setBounds(30, 60, 34, 14);

        calendarShowPanel.add(calendarItem);
        calendarShowPanel.add(jPanel3);

        jPanel4.setLayout(null);
        calendarShowPanel.add(jPanel4);
        calendarShowPanel.add(jPanel5);
        calendarShowPanel.add(jPanel7);
        calendarShowPanel.add(jPanel8);
        calendarShowPanel.add(jPanel1);
        calendarShowPanel.add(jPanel2);
        calendarShowPanel.add(jPanel6);
        calendarShowPanel.add(jPanel9);
        calendarShowPanel.add(jPanel10);
        calendarShowPanel.add(jPanel11);
        calendarShowPanel.add(jPanel12);
        calendarShowPanel.add(jPanel13);
        calendarShowPanel.add(jPanel14);
        calendarShowPanel.add(jPanel15);
        calendarShowPanel.add(jPanel16);
        calendarShowPanel.add(jPanel17);
        calendarShowPanel.add(jPanel18);
        calendarShowPanel.add(jPanel19);
        calendarShowPanel.add(jPanel20);

        calendarWrapper.add(calendarShowPanel);
        calendarShowPanel.setBounds(10, 10, 560, 270);

        add(calendarWrapper);
        calendarWrapper.setBounds(10, 60, 580, 290);
    }// </editor-fold>//GEN-END:initComponents

    private void button_preActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_preActionPerformed
        setTextLabelDate(getPreviousMonth());
    }//GEN-LAST:event_button_preActionPerformed

    private void button_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_nextActionPerformed
        setTextLabelDate(getNextMonth());
    }//GEN-LAST:event_button_nextActionPerformed

    private void dateChooseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateChooseBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateChooseBtnActionPerformed

    private void label_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_label_dateActionPerformed

    private void calendarItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calendarItemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_calendarItemMouseClicked

    private void calendarItemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calendarItemMouseEntered
        java.awt.Color borderColor = java.awt.Color.RED;
        int borderWidth = 2;
        this.setBorder(new javax.swing.border.LineBorder(borderColor, borderWidth));
    }//GEN-LAST:event_calendarItemMouseEntered

    private void calendarItemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calendarItemMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_calendarItemMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_next;
    private javax.swing.JButton button_pre;
    private javax.swing.JPanel calendarItem;
    private javax.swing.JPanel calendarShowPanel;
    private javax.swing.JPanel calendarWrapper;
    private javax.swing.JButton dateChooseBtn;
    private javax.swing.JLabel dateItemLabel;
    private javax.swing.JLabel incomeValueLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField label_date;
    private javax.swing.JLabel spentValueLabel;
    private javax.swing.JLabel totalValueLabel;
    // End of variables declaration//GEN-END:variables
}
