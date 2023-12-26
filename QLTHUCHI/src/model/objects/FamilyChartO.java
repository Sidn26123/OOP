
package model.objects;


public class FamilyChartO {
    private int Group_ID;
    private int month;
    private int year;
    private double sum_price;

    public FamilyChartO() {
    }

    public FamilyChartO(int Group_ID, int month, int year, double sum_price) {
        this.Group_ID = Group_ID;
        this.month = month;
        this.year = year;
        this.sum_price = sum_price;
    }

    
    public int getGroup_ID() {
        return Group_ID;
    }

    public void setGroup_ID(int Group_ID) {
        this.Group_ID = Group_ID;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getSum_price() {
        return sum_price;
    }

    public void setSum_price(double sum_price) {
        this.sum_price = sum_price;
    }

    @Override
    public String toString() {
        return this.month + " ," + this.sum_price;
    }
    
    
}
