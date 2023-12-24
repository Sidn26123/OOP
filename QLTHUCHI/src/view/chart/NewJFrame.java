/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.chart;

import charts.chart.BarChart.ModelChart;
import charts.chart.PieChart.ModelPieChart;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author sidac
 */
public class NewJFrame extends javax.swing.JFrame {

    public NewJFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        JFrame frame = new JFrame("No Header Frame Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setUndecorated(true);
        frame.setSize(new Dimension(800, 700));
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(1, 1));
        JPanel p1 = new JPanel();
        jPanel1 = new javax.swing.JPanel();
        JPanel chartTop2 = new javax.swing.JPanel();
        JPanel chartTop1 = new javax.swing.JPanel();
        JPanel chartTop3 = new javax.swing.JPanel();
        JPanel barChart = new javax.swing.JPanel();
        
        Vector<Vector<Object>> data = new Vector<>();
        Vector<Object> vector1 = new Vector<>(Arrays.asList(1, 2, "A"));
        Vector<Object> vector2 = new Vector<>(Arrays.asList(3, 4, "B"));
        Vector<Object> vector3 = new Vector<>(Arrays.asList(5, 6, "C"));
        data.add(vector1);
        data.add(vector2);
        data.add(vector3);

        charts.chart.BarChart.Chart chart = new charts.chart.BarChart.Chart();
        chart.addLegend("Income", new Color(245, 189, 135));
        chart.addLegend("Expense", new Color(135, 189, 245));
        chart.addLegend("Profit", new Color(189, 135, 245));
        chart.addData(new ModelChart("January", new double[]{500, 200, 80, 89}));
        chart.addData(new ModelChart("February", new double[]{600, 750, 90, 150}));
        chart.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
        chart.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
        chart.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
        chart.addData(new Object[]{"Junes", 190.0, 280.0, 81.0, 200.0});

//        p1.add(chart);
//        chart.start();
//        frame.add(p1);
//        frame.validate();
//        frame.repaint();
//        frame.setVisible(true);


        jPanel1 = new javax.swing.JPanel();
        chartTop2 = new javax.swing.JPanel();
        chartTop1 = new javax.swing.JPanel();
        chartTop3 = new javax.swing.JPanel();
//        barChart = new javax.swing.JPanel();
        updateDataBtn = new javax.swing.JButton();
        dateValueLabel = new javax.swing.JTextField();
//        
//        Vector<Vector<Object>> data = new Vector<>();
//        Vector<Object> vector1 = new Vector<>(Arrays.asList(1, 2, "A"));
//        Vector<Object> vector2 = new Vector<>(Arrays.asList(3, 4, "B"));
//        Vector<Object> vector3 = new Vector<>(Arrays.asList(5, 6, "C"));
//        data.add(vector1);
//        data.add(vector2);
//        data.add(vector3);
//
//        charts.chart.BarChart.Chart barChart = new charts.chart.BarChart.Chart();
//        barChart.addLegend("Income", new Color(245, 189, 135));
//        barChart.addLegend("Expense", new Color(135, 189, 245));
//        barChart.addLegend("Profit", new Color(189, 135, 245));
//        barChart.addData(new ModelChart("January", new double[]{500, 200, 80, 89}));
//        barChart.addData(new ModelChart("February", new double[]{600, 750, 90, 150}));
//        barChart.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
//        barChart.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
//        barChart.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
//        barChart.addData(new Object[]{"Junes", 190.0, 280.0, 81.0, 200.0});
//        
////        barChart = chart;
//              pieChart1.setChartType(PieChart.PeiChartType.DEFAULT);

        charts.chart.PieChart.PieChart pieChart1 = new charts.chart.PieChart.PieChart();

        pieChart1.addData(new ModelPieChart("Tigher", 150, new Color(23, 126, 238)));
        pieChart1.addData(new ModelPieChart("ABC", 100, new Color(221, 65, 65)));
        pieChart1.addData(new ModelPieChart("Coca", 1, new Color(47, 157, 64)));
        pieChart1.addData(new ModelPieChart("Vita", 60, new Color(196, 151, 58)));
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
//
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
//        barChart.setLayout(null);
//        barChart.add(chart);
////        chart.start();
//        jPanel1.add(barChart);
//        barChart.setBounds(20, 290, 440, 300);
        
        updateDataBtn.setText("jButton1");
        updateDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                updateDataBtnActionPerformed(evt);
            }
        });
        jPanel1.add(updateDataBtn);
        updateDataBtn.setBounds(490, 50, 20, 20);

        dateValueLabel.setText("jTextField1");
        jPanel1.add(dateValueLabel);
        dateValueLabel.setBounds(350, 50, 120, 20);
//        barChart.add(chart);
        JPanel j1 = new JPanel();
        j1.add(pieChart1);
        frame.add(j1);
        j1.setBounds(380, 110, 150, 150);

        frame.add(jPanel1);
//        jPanel1.setBounds(60, 30, 550, 650);
        frame.validate();
        frame.repaint();
        frame.setVisible(true);
//        barChart.start();
        chart.start();


        pack();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new NewJFrame();
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel barChart;
    private javax.swing.JPanel chartTop1;
    private javax.swing.JPanel chartTop2;
    private javax.swing.JPanel chartTop3;
    private javax.swing.JTextField dateValueLabel;
    private javax.swing.JButton updateDataBtn;
    // End of variables declaration                   
}
