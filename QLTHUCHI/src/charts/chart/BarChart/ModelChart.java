package charts.chart.BarChart;

public class ModelChart {

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double[] getValues() {
        return values;
    }

    public void setValues(double[] values) {
        this.values = values;
    }

    public ModelChart(String label, double[] values) {
        this.label = label;
        this.values = values;
    }

    public ModelChart(Object[] data) {
        this.label = (String)data[0];
        double[] values = new double[data.length-1];
        for (int i = 1; i < data.length; i++){
            values[i-1] = (double) data[i];
        }
        this.values = values;
    }
    public ModelChart() {
    }

    private String label;
    private double values[];

    public double getMaxValues() {
        double max = 0;
        for (double v : values) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }
}
