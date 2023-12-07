/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Vector;

import model.objects.ActionStore;
import model.objects.ActionStores;
import model.objects.Logs;


public class ActionStoreController {
    private ActionStores actionStore;


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
        data = new Logs().getDataWithCondition(conditionForFilter, conditionForSort);
        // Transactions transactions = new Transactions();
        // transactions.vectorToTransactions(data);
        // return transactions;
        return data;
    }
    public Transactions backupPreviousAction(){
        Transactions transactions = new Transactions();
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
    public Transactions backupNextAction(){
        Transactions transactions = new Transactions();
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
}

