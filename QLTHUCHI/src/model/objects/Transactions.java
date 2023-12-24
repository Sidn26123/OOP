package models;
import models.Transaction;
import java.util.Vector;

public class Transactions {
    // private int indexOfTransactions;
    private Vector<Transaction> transactions;

    public Transactions() {
        // this.indexOfTransactions = -1;
        this.transactions = new Vector<Transaction>();
    }

    public Transactions(Vector<Transaction> transactions) {
        // this.indexOfTransactions = -1;
        this.transactions = transactions;
    }

    public Vector<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Vector<Transaction> transactions) {
        this.transactions = transactions;
    }

    public int getSize(){
        return this.transactions.size();
    }

    public Transaction getTransactionAt(int index){
        return this.transactions.get(index);
    }

    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }

    public void addTransactionAt(Transaction transaction, int index){
        this.transactions.add(index, transaction);
    }

    public void removeTransactionAt(int index){
        this.transactions.remove(index);
    }

    public void removeAfterIndex(int index){
        for(int i = this.transactions.size() - 1; i > index; i--){
            this.transactions.remove(i);
        }
    }

    public void removeBeforeIndex(int index){
        for(int i = 0; i < index; i++){
            this.transactions.remove(0);
        }
    }

    public void setTransactionAt(Transaction transaction, int index){
        this.transactions.set(index, transaction);
    }
    public void removeTransaction(Transaction transaction){
        this.transactions.remove(transaction);
    }

    public Object[][] getDataForTable(String[] structure){
        Object[][] data = new Object[this.transactions.size()][structure.length];
        for (int i = 0; i < this.transactions.size(); i++) {
            data[i] = this.transactions.get(i).toRowTable(structure);
        }

        return data;
    }

    public Transactions vectorToTransactions(Vector<Object[]> data){
        Transactions transactions = new Transactions();
        Transaction t = new Transaction();
        for (int i = 0; i < data.size(); i++) {
            transactions.addTransaction(t.objectToTransaction(data.get(i)));
        }
        return transactions;
    }

    public void addDataWithVector(Vector<Object[]> data){
        Transaction t = new Transaction();
        for (int i = 0; i < data.size(); i++) {
            this.addTransaction(t.objectToTransaction(data.get(i)));
        }
    }
}
