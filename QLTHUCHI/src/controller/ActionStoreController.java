package controller;
import java.util.Vector;

import model.objects.ActionStore;
import model.objects.ActionStores;
import model.objects.LogO;
import model.objects.LogsDB;
import model.objects.Transactions;
import model.objects.Logs;

public class ActionStoreController {
    private ActionStores actionStore;
    // private int indexOfActionStore = -1;

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


    /**
     * Thực hiện action
     * @param logs
     * @param actionStoreItem actionStoreItem đầu vào
     * @param action "back" or "next"
     * @return Logs
     */
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
        ActionStore curActionStoreItem = null;
        Vector<ActionStore> actionStoresTemp = new Vector<ActionStore>();
        
        
        try {
            curActionStoreItem = this.actionStore.getCurActionStoreItem();
            if (this.actionStore.getIndexOfActionStores() == this.actionStore.getSize()){
                this.actionStore.decreaseIndexOfActionStore();
                // System.out.println(this.actionStore.getIndexOfActionStores() == this.actionStore.getSize());
                curActionStoreItem = this.actionStore.getCurActionStoreItem();
            }
            else if (curActionStoreItem == null){
                return logs;
            }
        }
        catch(Exception e){
            return logs;
        }

        //Tìm các action có cùng lượt action với action hiện tại và lưu lại
        int curActionStoreItemIndex = curActionStoreItem.getIndex();
        for (int i = this.actionStore.getIndexOfActionStores(); i >= 0; i--){
            if (this.actionStore.getActionItemAt(i).getIndex() != curActionStoreItemIndex){
                break;
            }
            actionStoresTemp.add(this.actionStore.getActionItemAt(i));
        }
        // System.out.println("actionStoresTemp: " + actionStoresTemp.size());
        
        for (int i = actionStoresTemp.size() - 1; i >= 0; i--){
            ActionStore curActionStoreItemTemp = actionStoresTemp.get(i);
            nLogs = this.executeAction(nLogs, curActionStoreItemTemp, "back");
            this.actionStore.decreaseIndexOfActionStore();
        }
        // this.executeAction(nLogs, curActionStoreItem, "back");
        // System.out.println("c");
        // try {
        //     curActionStoreItem = this.actionStore.getCurActionStoreItem();
        //     if (curActionStoreItem == null){
        //         return logs;
        //     }
        // }
        // catch(Exception e){
        //     return logs;
        // }
        // System.out.println(curActionStoreItem.getIndexInTable());
        // int curIndexOfActionStore = curActionStoreItem.getIndex();
        // boolean flag = false;
        // Vector<ActionStore> actionStoresTemp = new Vector<ActionStore>();
        
        // for (int i = 0; i < this.actionStore.getSize(); i++){
        //     if (this.actionStore.getActionItemAt(i).getIndex() == curIndexOfActionStore){
        //         System.out.println("B");
        //         actionStoresTemp.add(this.actionStore.getActionItemAt(i));
        //         flag = true;
        //     }
        //     else if (flag){
        //         break;
        //     }
        //     // actionStores.add(this.actionStore.getActionItemAt(i));
        // }

        // for (int i = actionStoresTemp.size() - 1; i >= 0; i--){
        //     System.out.println("A");
        //     ActionStore curActionStoreItemTemp = actionStoresTemp.get(i);
        //     // int curIndex = curActionStoreItem.getIndexInTable();
        //     // String typeAction = curActionStoreItem.getTypeAction();
        //     nLogs = this.executeAction(nLogs, curActionStoreItemTemp, "back");
        // }

        // while (true){
        //     if (this.actionStore.getIndexOfActionStores() < 1){
        //         return logs;
        //     }

        //     this.actionStore.decreaseIndexOfActionStore();

        //     ActionStore curActionStoreItem = this.actionStore.getCurActionStoreItem();
        //     int curIndex = curActionStoreItem.getIndexInTable();
        //     // String typeAction = curActionStoreItem.getTypeAction();
        //     nLogs = this.executeAction(nLogs, curActionStoreItem, "back");


        //     try {
        //         if (this.actionStore.getActionItemAt(curIndex-1).getIndex() != this.actionStore.getCurActionStoreItem().getIndex()){
        //             break;
        //         }
        //     } catch (Exception e) {
        //         break;
        //     }
        // }

        return nLogs;
        
    }

    public Logs moveNextAction(Logs logs){
        Logs nLogs = logs;
        ActionStore curActionStoreItem = null;
        this.actionStore.increaseIndexOfActionStore();
        try {
            curActionStoreItem = this.actionStore.getCurActionStoreItem();
            if (curActionStoreItem == null){
                return logs;
            }
        }
        catch(Exception e){
            return logs;
        }
        int curActionStoreItemIndex = curActionStoreItem.getIndex();
        //Lưu lại các action có cùng lượt action với action hiện tại
        Vector<ActionStore> actionStoresTemp = new Vector<ActionStore>();
        
        //Tìm các action có cùng lượt action với action hiện tại và lưu lại
        for (int i = this.actionStore.getIndexOfActionStores(); i < this.actionStore.getSize(); i++){
            if (this.actionStore.getActionItemAt(i).getIndex() != curActionStoreItemIndex){
                break;
            }
            actionStoresTemp.add(this.actionStore.getActionItemAt(i));
        }

        for (int i = 0; i < actionStoresTemp.size(); i++){
            ActionStore curActionStoreItemTemp = actionStoresTemp.get(i);
            nLogs = this.executeAction(nLogs, curActionStoreItemTemp, "next");
            this.actionStore.increaseIndexOfActionStore();
        }
        this.actionStore.decreaseIndexOfActionStore(); //Giảm index đi 1 vì trong vòng lặp exe action trước khi tăng nên 1 index đc tăng nhưng chưa đc exe
        // this.executeAction(nLogs, curActionStoreItem, "next");

        // while (true){
        //     if (this.actionStore.getIndexOfActionStores() > this.actionStore.getSize() - 1){
        //         return logs;
        //     }
        //     ActionStore curActionStoreItem = this.actionStore.getCurActionStoreItem();
        //     int curIndex = curActionStoreItem.getIndexInTable();
        //     String typeAction = curActionStoreItem.getTypeAction();
            
        //     if (typeAction == "add"){
        //         nLogs = this.executeAction(nLogs, curActionStoreItem, "next");
        //     }
        //     else if (typeAction == "delete"){
        //         nLogs = this.executeAction(nLogs, curActionStoreItem, "next");
        //     }
        //     else if (typeAction == "update"){
        //         nLogs = this.executeAction(nLogs, curActionStoreItem, "next");
        //     }
        //                 this.actionStore.increaseIndexOfActionStore();
        //     System.out.println("moveNextAction: " + curIndex);
        //     try {
        //         if (this.actionStore.getActionItemAt(this.actionStore.getIndexOfActionStores()+1).getIndex() != this.actionStore.getCurActionStoreItem().getIndex() || this.actionStore.getIndexOfActionStores() == this.actionStore.getSize() - 1){
        //             break;
        //         }
        //     } catch (Exception e) {
        //         break;
        //     }

        // }
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
        if (this.actionStore.getIndexOfActionStores() < this.actionStore.getSize() - 1){
            this.actionStore.removeActionsAfterIndex(this.actionStore.getIndexOfActionStores());
        }
        this.actionStore.addAction(actionStoreItem);
    }

    /**
     * Thêm actionItem vào actionStore
     * @param log
     * @param typeAction
     */
    public void addActionStore(LogO log, String typeAction){
        ActionStore actionStoreItem = new ActionStore(log, typeAction, this.actionStore.getSize());
        this.addActionStore(actionStoreItem);
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
    }
}
