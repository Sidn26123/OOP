
package LoginSignup.Model;

public class User {
    private int ID;
    private String Name;
    private int Group_ID;
    private String UserName;
    private String PassWord;
    private String PhoneNumber;
    private String EmailAddress;
    private int Receipts;
    private int Expenses;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getGroup_ID() {
        return Group_ID;
    }

    public void setGroup_ID(int Group_ID) {
        this.Group_ID = Group_ID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String EmailAddress) {
        this.EmailAddress = EmailAddress;
    }

    public int getReceipts() {
        return Receipts;
    }

    public void setReceipts(int Receipts) {
        this.Receipts = Receipts;
    }

    public int getExpenses() {
        return Expenses;
    }

    public void setExpenses(int Expenses) {
        this.Expenses = Expenses;
    }
    
    
}


