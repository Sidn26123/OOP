<<<<<<< HEAD
package controller;
import java.util.Vector;

import model.objects.ActionStore;
import model.objects.ActionStores;
import model.objects.LogsDB;
import model.objects.Logs;

public class ActionStoreController {
    private ActionStores actionStore;

=======
package controllers;
import java.util.Vector;

import models.ActionStore;
import models.ActionStores;
import models.LogO;
import models.LogsDB;
import models.Transactions;
import models.Logs;

public class ActionStoreController {
    private ActionStores actionStore;
    // private int indexOfActionStore = -1;
>>>>>>> 0f18cb3521e2502f23fddfc7e1eceb9367e98437

    public ActionStoreController() {
        this.actionStore = new ActionStores();
    }

    public ActionStoreController(ActionStores actionStore) {
        this.actionStore = actionStore;
    }
    
    public ActionStores getActionStore() {
        return actionStore;
    }

    public void setActionStore(ActionStores actionStores) {
        this.actionStore = actionStores;
    }


<<<<<<< HEAD
    public ActionStore moveNextAction(){
        if (this.actionStore.getIndexOfActionStore() < this.actionStore.getSize() - 1) {
            this.actionStore.setIndexOfActionStore(this.actionStore.getIndexOfActionStore() + 1);
            return this.actionStore.getActionStore().get(this.actionStore.getIndexOfActionStore());
        }
        return null;

    }

    public ActionStore movePreviousAction(){
        if (this.actionStore.getIndexOfActionStore() > 0) {
            this.actionStore.setIndexOfActionStore(this.actionStore.getIndexOfActionStore() - 1);
            return this.actionStore.getActionStore().get(this.actionStore.getIndexOfActionStore());
        }
        return null;
    }

    public void addActionStore(ActionStore actionStoreItem){
        if (this.actionStore.getIndexOfActionStore() < this.actionStore.getSize() - 1) {
            for (int i = this.actionStore.getSize() - 1; i > this.actionStore.getIndexOfActionStore(); i--) {
                this.actionStore.getActionStore().remove(i);
            }
        }
        this.actionStore.getActionStore().add(actionStoreItem);
        this.actionStore.setIndexOfActionStore(this.actionStore.getSize() - 1);
    }

    public void removeActionStoreAt(int index){
        this.actionStore.getActionStore().remove(index);
        this.actionStore.setIndexOfActionStore(this.actionStore.getIndexOfActionStore() - 1);
    }

    public void removeAfterIndex(int index){
        for(int i = this.actionStore.getSize() - 1; i > index; i--){
            this.actionStore.getActionStore().remove(i);
        }
        this.actionStore.setIndexOfActionStore(index);
    }

    public int getSize(){
        return this.actionStore.getSize();
    }

    public int getIndexOfActionStore() {
        return this.actionStore.getIndexOfActionStore();
    }

    public void setIndexOfActionStore(int indexOfActionStore) {
        this.actionStore.setIndexOfActionStore(indexOfActionStore);
    }

    // public ActionStore getLastActionStore(){
    //     if(this.actionStore.getSize() > 0){
    //         return this.actionStore.getActionStore().get(this.actionStore.getSize() - 1);
    //     }
    //     return null;
    // }
    public void increaseIndexOfActionStore(){
        this.actionStore.setIndexOfActionStore(this.actionStore.getIndexOfActionStore() + 1);
    }

    public void decreaseIndexOfActionStore(){
        this.actionStore.setIndexOfActionStore(this.actionStore.getIndexOfActionStore() - 1);
    }
    public void clearActionStore(){
        this.actionStore.getActionStore().clear();
        this.actionStore.setIndexOfActionStore(-1);
    }


    public Vector<Object[]> filter(Vector<Object[]> conditionsForFilter, Vector<Object[]> conditionsForSort){
        Vector<String> conditionForFilter = new Vector<String>();
        for (Object[] item : conditionsForFilter){
            if (item[0] == "date"){
                if (item[2] == "from"){
                    conditionForFilter.add("date >= " + item[1]);
                }
                else if (item[2] == "to"){
                    conditionForFilter.add("date <= " + item[1]);
                }
            }
            else if (item[0] == "amount"){
                if (item[2] == "from"){
                    conditionForFilter.add("amount >= " + item[1]);
                }
                else if (item[2] == "to"){
                    conditionForFilter.add("amount <= " + item[1]);
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
        // Transactions transactions = new Transactions();
        // transactions.vectorToTransactions(data);
        // return transactions;
        return data;
    }
    public Logs backupPreviousAction(){
        Logs transactions = new Logs();
        if(this.actionStore.getSize() > 0){
            ActionStore actionStoreItem = this.actionStore.getActionStoreAt(this.actionStore.getSize() - 1);
            if(actionStoreItem.getTypeAction().equals("add")){
            }
            else if(actionStoreItem.getTypeAction().equals("delete")){
            }
            else if(actionStoreItem.getTypeAction().equals("update")){
            }
        }
        return transactions;
    }
    public Logs backupNextAction(){
        Logs transactions = new Logs();
        if(this.actionStore.getSize() > 0){
            ActionStore actionStoreItem = this.actionStore.getActionStoreAt(this.actionStore.getSize() - 1);
            if(actionStoreItem.getTypeAction().equals("add")){
            }
            else if(actionStoreItem.getTypeAction().equals("delete")){
            }
            else if(actionStoreItem.getTypeAction().equals("update")){
            }
        }
        return transactions;
=======

    public Logs executeAction(Logs logs, ActionStore actionStoreItem, String action){
        Logs nLogs = logs;
        if (actionStoreItem != null){
            String typeAction = actionStoreItem.getTypeAction();
            int index = actionStoreItem.getIndexInTable();
            if (action == "back"){
                if (typeAction.equals("add")){
                    nLogs.removeLogWithId(actionStoreItem.getData().getID());
                }
                else if (typeAction.equals("delete")){
                    actionStore.printData();
                    nLogs.addLogAt(actionStoreItem.getData(), index);
                }
                else if (typeAction.equals("update")){
                    nLogs.setLogAt(actionStoreItem.getData(), index);
                }
            }
            else if (action == "next"){
                if (typeAction.equals("add")){
                    nLogs.addLogAt(actionStoreItem.getData(), index);
                }
                else if (typeAction.equals("delete")){
                    nLogs.removeLogAt(index);
                }
                else if (typeAction.equals("update")){
                    nLogs.setLogAt(actionStoreItem.getData(), index);
                }
            }
        }
        return nLogs;
    }
    public Logs movePreviousAction(Logs logs){
        Logs nLogs = logs;

        while (true){
            if (this.actionStore.getIndexOfActionStores() < 1){
                return logs;
            }
            this.actionStore.decreaseIndexOfActionStore();

            ActionStore curActionStoreItem = this.actionStore.getCurActionStoreItem();
            int curIndex = curActionStoreItem.getIndexInTable();
            String typeAction = curActionStoreItem.getTypeAction();
            
            if (typeAction == "add"){
                nLogs = this.executeAction(nLogs, curActionStoreItem, "back");
            }
            else if (typeAction == "delete"){
                nLogs = this.executeAction(nLogs, curActionStoreItem, "back");
            }
            else if (typeAction == "update"){
                nLogs = this.executeAction(nLogs, curActionStoreItem, "back");
            }

            try {
                if (this.actionStore.getActionItemAt(curIndex-1).getIndex() != this.actionStore.getCurActionStoreItem().getIndex()){
                    break;
                }
            } catch (Exception e) {
                break;
            }
        }

        return nLogs;
        
    }

    public Logs moveNextAction(Logs logs){
        Logs nLogs = logs;
        while (true){
            if (this.actionStore.getIndexOfActionStores() > this.actionStore.getSize() - 1){
                return logs;
            }
            ActionStore curActionStoreItem = this.actionStore.getCurActionStoreItem();
            int curIndex = curActionStoreItem.getIndexInTable();
            String typeAction = curActionStoreItem.getTypeAction();
            
            if (typeAction == "add"){
                nLogs = this.executeAction(nLogs, curActionStoreItem, "next");
            }
            else if (typeAction == "delete"){
                nLogs = this.executeAction(nLogs, curActionStoreItem, "next");
            }
            else if (typeAction == "update"){
                nLogs = this.executeAction(nLogs, curActionStoreItem, "next");
            }
                        this.actionStore.increaseIndexOfActionStore();
            System.out.println("moveNextAction: " + curIndex);
            try {
                if (this.actionStore.getActionItemAt(this.actionStore.getIndexOfActionStores()+1).getIndex() != this.actionStore.getCurActionStoreItem().getIndex() || this.actionStore.getIndexOfActionStores() == this.actionStore.getSize() - 1){
                    break;
                }
            } catch (Exception e) {
                break;
            }

        }
        // Chuyển tới action kế và lấy index
        // if (this.actionStore.getIndexOfActionStores() > this.actionStore.getSize() - 1){
        //     System.out.println("B");
        //     return logs;
        // }


        // ActionStore curActionStoreItem = this.actionStore.getCurActionStoreItem();
        // int curIndex = curActionStoreItem.getIndex();
        // if (curActionStoreItem != null){
        //     String typeAction = curActionStoreItem.getTypeAction();
        //     nLogs = this.executeAction(nLogs, curActionStoreItem, "next");
        // }
        //         this.actionStore.increaseIndexOfActionStore();

        
        return nLogs;
    }
    
    public boolean isIndexValidForTakeAction(){
        if (this.actionStore.getIndexOfActionStores() < 1 || this.actionStore.getIndexOfActionStores() > this.actionStore.getSize() - 1){
            return false;
        }
        return true;
    }
    
    public Logs moveNextActions(Logs logs){
        if (this.actionStore.getIndexOfActionStores() >= this.actionStore.getSize()-1){
            return logs;
        }
        //Nhảy tới action kế và lấy index
        this.actionStore.increaseIndexOfActionStore();
        int curIndex = this.actionStore.getIndexOfActionStores();
        System.out.println("moveNextAction: " + curIndex);
        // if (curIndex > this.actionStore.getSize() - 1){
        //     return logs;
        // }
        
        Logs nLogs = logs;
        ActionStore actionStoreItem = this.actionStore.getCurActionStoreItem();
        if (actionStoreItem != null){
            String typeAction = actionStoreItem.getTypeAction();
            if (typeAction == "add"){
                nLogs = this.executeAction(nLogs, actionStoreItem, typeAction);
            }
        }
        // if (actionStoreItem != null){
        //     String typeAction = actionStoreItem.getTypeAction();
        //     boolean flag = true;
        //     while (flag){
        //         try{
        //             System.out.println("moveNextAction2: " + actionStoreItem.getTypeAction());
        //             if (typeAction.equals("add")){
        //                 // System.out.println(actionStoreItem.getData().getID() + " " + actionStoreItem.getIndex());
        //                 nLogs.addLogAt(actionStoreItem.getData(), actionStoreItem.getIndex());
        //                 System.out.println("add: " + nLogs.getSize());
        //             }
        //             else if (typeAction.equals("delete")){
        //                 nLogs.removeLogAt(actionStoreItem.getIndex());
        //             }
        //             else if (typeAction.equals("update")){
        //                 nLogs.setLogAt(actionStoreItem.getData(), actionStoreItem.getIndex());
        //             }
        //             if (curIndex >= this.actionStore.getSize() -1 || this.actionStore.getActionItemAt(curIndex+1).getIndex() != this.actionStore.getCurActionStoreItem().getIndex()){
        //                 flag = false;
        //             }
        //             this.actionStore.increaseIndexOfActionStore();
        //         }
        //         catch(Exception e){
        //             flag = false;
        //         }

        //     }

        // }
        return nLogs;
    }

    public Logs movePreviousActions(Logs logs){
        // System.out.println("movePreviousAction: " + logs.getSize());
        this.actionStore.decreaseIndexOfActionStore();
        int curIndex = this.actionStore.getIndexOfActionStores();
        System.out.println("movePreviousAction: " + curIndex);
        if (curIndex < 0){
            return logs;
        }
        Logs nLogs = logs;
        ActionStore actionStoreItem = this.actionStore.getCurActionStoreItem();
        if (actionStoreItem != null){
            String typeAction = actionStoreItem.getTypeAction();
            while (true){

                if (typeAction.equals("adder")){
                    nLogs.removeLog(actionStoreItem.getIndex());
                }
                else if (typeAction.equals("delete")){
                    nLogs.addLogAt(actionStoreItem.getData(), actionStoreItem.getIndex());
                }
                else if (typeAction.equals("update")){
                    nLogs.setLogAt(actionStoreItem.getData(), actionStoreItem.getIndex());
                }
                try{
                    if (curIndex > this.actionStore.getSize() -1 || this.actionStore.getActionItemAt(curIndex-1).getIndex() != this.actionStore.getCurActionStoreItem().getIndex()){
                        break;
                    }
                }
                catch(Exception e){
                    break;
                }

                this.actionStore.decreaseIndexOfActionStore();

            }

        }
        // System.out.println("movePreviousAction: " + nLogs.getSize());
        return nLogs;
    }
    /**
     * Thêm actionItem vào actionStore
     * @param actionStoreItem
     */
    public void addActionStore(ActionStore actionStoreItem){
        this.actionStore.addAction(actionStoreItem);
    }

    /**
     * Thêm actionItem vào actionStore
     * @param log
     * @param typeAction
     */
    public void addActionStore(LogO log, String typeAction){
        ActionStore actionStoreItem = new ActionStore(log, typeAction, this.actionStore.getSize());
        this.actionStore.addAction(actionStoreItem);
    }

    /**
     * Thêm actionItem vào actionStore
     * @param log
     * @param typeAction
     * @param index
     */
    public void addActionStoreAt(LogO log, String typeAction, int index){
        // ActionStore actionStoreItem = new ActionStore(log, typeAction, index);
        // this.actionStore.addActionAt(actionStoreItem, index);
        if (index >= this.actionStore.getSize() || index < 0){
            return;   
        }
        this.actionStore.addActionAt(log, typeAction, index);
    }

    public void removeActionStoreAt(int index){
        // this.actionStore.getAction().remove(index);
        // this.actionStore.setIndexOfActionStore(this.actionStore.getIndexOfActionStores() - 1);
        this.actionStore.removeActionAt(index);
    }





    public Logs backupPreviousAction(Logs logs){
        this.movePreviousAction(logs);
        // Logs logs = new Logs();
        // if(this.actionStore.getSize() > 0){
        //     ActionStore actionStoreItem = this.actionStore.getActionStoreAt(this.indexOfActionStore);
        //     if(actionStoreItem.getTypeAction().equals("add")){
        //         logs.removeLogAt(actionStoreItem.getIndex());
        //     }
        //     // else if(actionStoreItem.getTypeAction().equals("delete")){

        //     // }
        //     // else if(actionStoreItem.getTypeAction().equals("update")){
        //     // }
        //     else if (actionStoreItem.getTypeAction().equals("delete")) {
        //         // logs.addLog(actionStoreItem.getTypeData());
        //         logs.addLogAt(actionStoreItem.getTypeData(), indexOfActionStore);
        //     }
        //     else if (actionStoreItem.getTypeAction().equals("update")) {
        //         logs.setLogAt(actionStoreItem.getTypeData(), indexOfActionStore);
                
        //     }

        //     this.indexOfActionStore--;
        // }
        return logs;
    }
    public Logs backupNextAction(Logs logs){
        this.moveNextAction(logs);
        return logs;
>>>>>>> 0f18cb3521e2502f23fddfc7e1eceb9367e98437
    }
}
