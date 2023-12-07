/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.Vector;
import model.objects.ActionStore;
import model.objects.LogO;
import model.objects.Logs;
/**
 *
 * @author sidac
 */
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
}
