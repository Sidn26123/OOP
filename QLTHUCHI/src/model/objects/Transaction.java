package models;

public class Transaction {
    private int id;
    private String date;
    private String note;
    private int amount;
    private int categoryId;
    private int accountId;

    public Transaction(){
        this.id = 0;
        this.date = "";
        this.note = "";
        this.amount = 0;
        this.categoryId = 0;
        this.accountId = 0;
    }
    
    public Transaction(int id, int categoryId, int amount,String date, String note) {
        this.id = id;
        this.date = date;
        this.note = note;
        this.amount = amount;
        this.categoryId = categoryId;
        // this.accountId = accountId;
    }

    public Transaction(int id, String date, String note, int amount, int categoryId, int accountId) {
        this.id = id;
        this.date = date;
        this.note = note;
        this.amount = amount;
        this.categoryId = categoryId;
        this.accountId = accountId;
    }
    
    public int getTransactionId() {
        return this.id;
    }

    public void setTransactionId(int id) {
        this.id = id;
    }

    public String getTransactionDate() {
        return this.date;
    }

    public void setTransactionDate(String date) {
        this.date = date;
    }

    public String getTransactionNote() {
        return this.note;
    }

    public void setTransactionNote(String note) {
        this.note = note;
    }

    public int getTransactionAmount() {
        return this.amount;
    }

    public void setTransactionAmount(int amount) {
        this.amount = amount;
    }

    public int getTransactionCategoryId() {
        return this.categoryId;
    }

    public void setTransactionCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Object[] toArray() {
        return new Object[] { this.id, this.date, this.note, this.amount, this.categoryId, this.accountId };
    }

    public Object[] toRowTable(Object[] structureString){
        Object[] row = new Object[structureString.length];
        for (int i = 0; i < structureString.length; i++) {
            switch (structureString[i].toString()) {
                case "id":
                    row[i] = this.id;
                    break;
                case "date":
                    row[i] = this.date;
                    break;
                case "note":
                    row[i] = this.note;
                    break;
                case "amount":
                    row[i] = this.amount;
                    break;
                case "categoryId":
                    row[i] = this.categoryId;
                    break;
                case "accountId":
                    row[i] = this.accountId;
                    break;
                default:
                    break;
            }
        }
        return row;
    }
    public Transaction objectToTransaction(Object[] data){
        Transaction transaction = new Transaction((int)data[0], (int)data[1], (int)data[2], (String)data[3], (String)data[4]);
        return transaction;
    }
}
