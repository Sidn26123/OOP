
package charts.graph;

import charts.chart.BarChart.ModelChart;
import charts.chart.PieChart.ModelPieChart;
import charts.chart.PieChart.PieChart;
import java.awt.Color;
import java.util.Arrays;
import java.util.Vector;

public class Graph extends javax.swing.JFrame {


    public Graph() {
        initComponents();
        setDefault();
    }

    private void setDefault(){
        getContentPane().setBackground(new Color(250, 250, 250));
        chart.addLegend("Income", new Color(245, 189, 135));
        chart.addLegend("Expense", new Color(135, 189, 245));
        chart.addLegend("Profit", new Color(189, 135, 245));
//        chart.addLegend("Cost", new Color(139, 229, 222));ss
        chart.addData(new ModelChart("January", new double[]{500, 200, 80,89}));
        chart.addData(new ModelChart("February", new double[]{600, 750, 90,150}));
        chart.addData(new ModelChart("March", new double[]{200, 350, 460,900}));
        chart.addData(new ModelChart("April", new double[]{480, 150, 750,700}));
        chart.addData(new ModelChart("May", new double[]{350, 540, 300,150}));
        chart.addData(new ModelChart("June", new double[]{190, 280, 81,200}));
        chart.addData(new ModelChart("June", new double[]{190, 280, 81,200}));
        chart.addData(new ModelChart("June", new double[]{190, 280, 81,200}));
        chart.addData(new ModelChart("June", new double[]{190, 280, 81,200}));
        chart.addData(new ModelChart("June", new double[]{190, 280, 81,200}));
        chart.start();
        
        // pie chart
        pieChart1.setChartType(PieChart.PeiChartType.DEFAULT);
        pieChart1.addData(new ModelPieChart("Tigher", 150, new Color(23, 126, 238)));
        pieChart1.addData(new ModelPieChart("ABC", 100, new Color(221, 65, 65)));
        pieChart1.addData(new ModelPieChart("Coca", 1, new Color(47, 157, 64)));
        pieChart1.addData(new ModelPieChart("Vita", 60, new Color(196, 151, 58)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chart = new charts.chart.BarChart.Chart();
        pieChart1 = new charts.chart.PieChart.PieChart();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(pieChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(203, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addGap(43, 43, 43)
                .addComponent(pieChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Graph().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private charts.chart.BarChart.Chart chart;
    private charts.chart.PieChart.PieChart pieChart1;
    // End of variables declaration//GEN-END:variables
}
