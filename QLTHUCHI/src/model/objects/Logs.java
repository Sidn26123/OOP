<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.objects;

/**
 *
 * @author sidac
 */
=======
package models;
>>>>>>> 0f18cb3521e2502f23fddfc7e1eceb9367e98437
import java.util.Vector;
public class Logs {
    private Vector<LogO> logs;

    public Logs() {
        this.logs = new Vector<LogO>();
    }

    public Logs(Vector<LogO> logs) {
        this.logs = logs;
    }

    public Vector<LogO> getLogs() {
        return logs;
    }

    public void setLogs(Vector<LogO> logs) {
        this.logs = logs;
    }

    public int getSize(){
        return this.logs.size();
    }

    public LogO getLogAt(int index){
        return this.logs.get(index);
    }

<<<<<<< HEAD
    public void addLog(LogO log){
        this.logs.add(log);
    }

    public void addLogAt(LogO log, int index){
        this.logs.add(index, log);
    }

    public void removeLogAt(int index){
        this.logs.remove(index);
    }

    public void removeAfterIndex(int index){
        for(int i = this.logs.size() - 1; i > index; i--){
            this.logs.remove(i);
        }
    }

    public void removeBeforeIndex(int index){
        for(int i = 0; i < index; i++){
            this.logs.remove(0);
        }
    }

    public void setLogAt(LogO log, int index){
        this.logs.set(index, log);
    }

    public void clear(){
        this.logs.clear();
    }

    public void removeLog(LogO log){
        this.logs.remove(log);
    }

    public void removeLog(LogO log, int index){
        this.logs.remove(index);
    }
}
=======
    public LogO getLog(int id){
        for(int i = 0; i < this.logs.size(); i++){
            if (this.logs.get(i).getID() == id){
                return this.logs.get(i);
            }
        }
        return null;
    }

    public void addLog(LogO log){
        this.logs.add(log);
    }

    public void addLogAt(LogO log, int index){
        this.logs.add(index, log);
    }

    public void removeLogAt(int index){
        if (index < this.logs.size() && index >= 0){
            this.logs.remove(index);
        }
    }

    public void removeLogWithId(int id){
        for(int i = 0; i < this.logs.size(); i++){
            if (this.logs.get(i).getID() == id){
                this.logs.remove(i);
                break;
            }
        }
    }

    public void removeAfterIndex(int index){
        for(int i = this.logs.size() - 1; i > index; i--){
            this.logs.remove(i);
        }
    }

    public void removeBeforeIndex(int index){
        for(int i = 0; i < index; i++){
            this.logs.remove(0);
        }
    }

    public void setLogAt(LogO log, int index){
        this.logs.set(index, log);
    }

    public void clear(){
        this.logs.clear();
    }

    public void removeLog(LogO log){
        this.logs.remove(log);
    }

    public void removeLog(int index){
        if (index >= 0 && index < this.logs.size()){
            this.logs.remove(index);
        }
    }
}
>>>>>>> 0f18cb3521e2502f23fddfc7e1eceb9367e98437
