package model.objects;


public class Price_Group {
    private int ID_Log;
    private int ID_User_Expenses;
    private double price_per_user;
    private String Date;
    private int User_ID;
    private int Group_ID;

    public Price_Group() {
    }

    public Price_Group(int ID_Log, int ID_User_Expenses, double price_per_user, String Date, int User_ID, int Group_ID) {
        this.ID_Log = ID_Log;
        this.ID_User_Expenses = ID_User_Expenses;
        this.price_per_user = price_per_user;
        this.Date = Date;
        this.User_ID = User_ID;
        this.Group_ID = Group_ID;
    }

    public int getID_Log() {
        return ID_Log;
    }

    public void setID_Log(int ID_Log) {
        this.ID_Log = ID_Log;
    }

    public int getID_User_Expenses() {
        return ID_User_Expenses;
    }

    public void setID_User_Expenses(int ID_User_Expenses) {
        this.ID_User_Expenses = ID_User_Expenses;
    }

    public double getPrice_per_user() {
        return price_per_user;
    }

    public void setPrice_per_user(double price_per_user) {
        this.price_per_user = price_per_user;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int User_ID) {
        this.User_ID = User_ID;
    }

    public int getGroup_ID() {
        return Group_ID;
    }

    public void setGroup_ID(int Group_ID) {
        this.Group_ID = Group_ID;
    }

    @Override
    public String toString() {
        return "Price_Group{" + "ID_Log=" + ID_Log + ", ID_User_Expenses=" + ID_User_Expenses + ", price_per_user=" + price_per_user + ", Date=" + Date + ", User_ID=" + User_ID + ", Group_ID=" + Group_ID + '}';
    }
    
    
    
}
