
package charts.graph;

import charts.chart.BarChart.ModelChart;
import charts.chart.PieChart.ModelPieChart;
import charts.chart.PieChart.PieChart;
import java.awt.Color;
import java.util.Arrays;
import java.util.Vector;
import model.objects.LogsDB;
public class Graph extends javax.swing.JFrame {


    public Graph() {
        initComponents();
        setDefault();
    }

    private void setDefault(){
        getContentPane().setBackground(new Color(250, 250, 250));
        chart.addLegend("Thu", new Color(245, 189, 135));
        chart.addLegend("Chi", new Color(135, 189, 245));
//        chart.addLegend("Profit", new Color(189, 135, 245));
//        chart.addLegend("Cost", new Color(139, 229, 222));ss
//        chart.addData(new ModelChart("January", new double[]{500, 200, 80,89}));
//        chart.addData(new ModelChart("February", new double[]{600, 750, 90,150}));
//        chart.addData(new ModelChart("March", new double[]{200, 350, 460,900}));
//        chart.addData(new ModelChart("April", new double[]{480, 150, 750,700}));
//        chart.addData(new ModelChart("May", new double[]{350, 540, 300,150}));
//        chart.addData(new ModelChart("June", new double[]{190, 280, 81,200}));
//        chart.addData(new ModelChart("June", new double[]{190, 280, 81,200}));
//        chart.addData(new ModelChart("June", new double[]{190, 280, 81,200}));
//        chart.addData(new ModelChart("June", new double[]{190, 280, 81,200}));
//        chart.addData(new ModelChart("June", new double[]{190, 280, 81,200}));
        String curDate = Utils.Utils.getCurrentDateFormatted();
        Object[][] data= new LogsDB().getGeneralInfoOfDates(Utils.Utils.getDateFormattedWithOffset(curDate, "d", -7), curDate);
        for (Object[] item : data){
            chart.addData(new ModelChart((String)item[2], new double[]{(int)item[0],1,1,1}));
        }
        chart.start();
        
        // pie chart
        Object[][] dataPie1 = new LogsDB().getTypeSumInMonth(12, 2023, 0);
        pieChart1.setChartType(PieChart.PeiChartType.DEFAULT);
//        pieChart1.addData(new ModelPieChart("Tigher", 150, new Color(23, 126, 238)));
//        pieChart1.addData(new ModelPieChart("ABC", 100, new Color(221, 65, 65)));
//        pieChart1.addData(new ModelPieChart("Coca", 1, new Color(47, 157, 64)));
//        pieChart1.addData(new ModelPieChart("Vita", 60, new Color(196, 151, 58)));
        Vector<Color> colors = new Vector<Color>();
        colors.add(new Color(23, 126, 238));
        colors.add(new Color(221, 65, 65));
        int i = 0;
        for (Object[] item: dataPie1){
            if (i == colors.size()){
                i = 0;
            }
            pieChart1.addData(new ModelPieChart((String)item[1], (double)item[2], colors.get(i)));
            i++;
        }
        
        Object[][] dataPie2 = new LogsDB().getTypeSumInMonth(12, 2023, 1);
//        pieChart2.setChartType(PieChart.PeiChartType.DEFAULT);
//        for (Object[] item: dataPie1){
//            pieChart2.addData(new ModelPieChart(String)item[1], (int)item[2], colors.get(1)));
//        }
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
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pieChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(225, 225, 225))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pieChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
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
