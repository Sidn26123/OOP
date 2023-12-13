package controllers;
import java.util.Vector;

import com.mysql.cj.util.Util;

import Utils.Utils;
import models.ActionStore;
import models.LogO;
import models.Logs;
import models.LogsDB;
public class LogsController {
    private Logs logs;
    public LogsController(){
        this.logs = new Logs();
    }

    public LogsController(Logs logs){
        this.logs = logs;
    }

    public Logs getLogs() {
        return logs;
    }

    public void addLog(LogO log){
        this.logs.addLog(log);
    }

    public void addLogAt(LogO log, int index){
        this.logs.addLogAt(log, index);
    }

    public void removeLogAt(int index){
        this.logs.removeLogAt(index);
    }

    public void removeAfterIndex(int index){
        this.logs.removeAfterIndex(index);
    }

    public void removeLogWithID(int id){
        for (int i = 0; i < this.logs.getSize(); i++) {
            if(this.logs.getLogAt(i).getID() == id){
                this.logs.removeLogAt(i);
                break;
            }
        }
    }
    public void setLogs(Logs logs) {
        this.logs = logs;
    }
    public void setLogs(Vector<LogO> logs) {
        this.logs.setLogs(logs);
    }
    // public void setLogs(Object[][] data){
    //     this.logs = new Logs();
    //     for (int i = 0; i < data.length; i++) {
    //         this.logs.addLog(new LogO((int)data[i][0], (String)data[i][1], (int)data[i][2], (int)data[i][3], (String)data[i][4], (int)data[i][5]));
    //     }
    // }
    public Object[][] logDataToTable(String[] structure){
        Object[][] data = new Object[this.logs.getSize()][structure.length];
        for(int i = 0; i < this.logs.getSize(); i++){
            for (int j = 0; j < structure.length; j++) {
                switch (structure[j]) {
                    case "id":
                        data[i][j] = this.logs.getLogAt(i).getID();
                        break;
                    // case "action":
                    //     data[i][j] = this.logs.getLogAt(i).getAction();
                    //     break;
                    case "date":
                        data[i][j] = this.logs.getLogAt(i).getDateString();
                        break;
                    case "user":
                        data[i][j] = this.logs.getLogAt(i).getUser_ID();
                        break;
                    case "price":
                        data[i][j] = this.logs.getLogAt(i).getPrice();
                        break;
                    case "note":
                        data[i][j] = this.logs.getLogAt(i).getNote();
                        break;
                    case "idOfItemInCategory":
                        data[i][j] = this.logs.getLogAt(i).getID_Type();
                        break;
                    default:
                        break;
                }
            }
        }
        return data;
    }
    public void filter(Vector<Object[]> conditionsForFilter, Vector<Object[]> conditionsForSort){
        Logs logs = new Logs();
        for (Object[] item : conditionsForFilter){
            item[1] = (String)Utils.convertStringToSQLDate((String)item[1]);
        }
        Vector<String> conditionForFilter = new Vector<String>();
        for (Object[] item : conditionsForFilter){
            if (item[0] == "date"){
                if (item[2] == "from"){
                    conditionForFilter.add("date >= " + "'" + item[1] + "'");
                }
                else if (item[2] == "to"){
                    conditionForFilter.add("date <= " + "'" + item[1] + "'");
                }
            }
            else if (item[0] == "amount"){
                if (item[2] == "from"){
                    conditionForFilter.add("amount >= " + "'" + item[1] + "'");
                }
                else if (item[2] == "to"){
                    conditionForFilter.add("amount <= " + "'" + item[1] + "'");
                }
            }
        }
        Vector<String> conditionForSort = new Vector<String>();
        for (Object[] item : conditionsForSort){
            if (item[0] == "date"){
                if (item[1] == "ASC"){
                    conditionForSort.add("date ASC");
                }
                else if (item[1] == "DESC"){
                    conditionForSort.add("date DESC");
                }
            }
            else if (item[0] == "amount"){
                if (item[1] == "ASC"){
                    conditionForSort.add("amount ASC");
                }
                else if (item[1] == "DESC"){
                    conditionForSort.add("amount DESC");
                }
            }
        }
        Vector<Object[]> data = new Vector<Object[]>();
        data = new LogsDB().getDataWithCondition(conditionForFilter, conditionForSort);
        for (Object[] item : data){
            logs.addLog(new LogO((int)item[0], (int)item[1], (int)item[2], (String)item[3], (String)item[4]));
        }
        // Transactions transactions = new Transactions();
        // transactions.vectorToTransactions(data);
        // return transactions;

        this.logs = logs;

    }
}
