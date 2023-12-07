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
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.objects.Types;
import model.objects.TypeO;
// import models.ActionStore;
import model.objects.LogO;
import model.objects.LogsDB;

public class ActionStores {
    private int indexOfActionStore; //index hiện tại của action
    private Vector<ActionStore> actionStore; //lưu các hành động thêm, xóa, sửa vào đây
    
    public ActionStores() {
        this.indexOfActionStore = -1;
        this.actionStore = new Vector<>();
    }

    public ActionStore getActionStoreAt(int index) {
        return this.actionStore.get(index);
    }
    

    public int getSize(){
        return this.actionStore.size();
    }

    public int getIndexOfActionStore() {
        return indexOfActionStore;
    }

    public void setIndexOfActionStore(int indexOfActionStore) {
        this.indexOfActionStore = indexOfActionStore;
    }

    public Vector<ActionStore> getActionStore() {
        return actionStore;
    }

    public ActionStore getLastActionStore(){
        if(this.actionStore.size() > 0){
            return this.actionStore.get(this.actionStore.size() - 1);
        }
        return null;
    }
    
    public void addTransaction(LogO logO){
        ActionStore actionStoreItem = new ActionStore(logO, "add", this.actionStore.size());
        this.actionStore.add(actionStoreItem);
        this.indexOfActionStore = this.actionStore.size() - 1;
    }

    public void deleteTransaction(LogO logO){
        ActionStore actionStoreItem = new ActionStore(logO, "delete", this.actionStore.size());
        this.actionStore.add(actionStoreItem);
        this.indexOfActionStore = this.actionStore.size() - 1;
    }

    public void updateTransaction(LogO logO){
        ActionStore actionStoreItem = new ActionStore(logO, "update", this.actionStore.size());
        this.actionStore.add(actionStoreItem);
        this.indexOfActionStore = this.actionStore.size() - 1;
    }





}
