<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.objects;



public class ActionStore {
        private LogO typeData;
        private String typeAction; // "add" or "delete" or "update"
        private int index; //các hành động được thực hiện nhiều cái trong 1 lần (xóa nhiều item) thì sẽ có cùng index
        public ActionStore(LogO typeData, String typeAction, int index) {
            this.typeData = typeData;
            this.typeAction = typeAction;
            this.index = index;
        }
        public LogO getTypeData() {
            return typeData;
        }

        public void setTypeData(LogO typeData) {
            this.typeData = typeData;
=======
package models;


public class ActionStore {
        private LogO data;
        private String typeAction; // "add" or "delete" or "update"
        private int index; //các hành động được thực hiện nhiều cái trong 1 lần (xóa nhiều item) thì sẽ có cùng index
        private int indexInTable; 
        /**
         * 
         * @param data
         * @param typeAction
         * @param index là index cho các action vào ra cùng 1 lúc
         */
        public ActionStore(LogO data, String typeAction, int index) {
            this.data = data;
            this.typeAction = typeAction;
            this.index = index;
        }

        public ActionStore(LogO data, String typeAction, int index, int indexInTable) {
            this.data = data;
            this.typeAction = typeAction;
            this.index = index;
            this.indexInTable = indexInTable;
        }

        public LogO getData() {
            return data;
        }

        public void setData(LogO data) {
            this.data = data;
>>>>>>> 0f18cb3521e2502f23fddfc7e1eceb9367e98437
        }

        public String getTypeAction() {
            return typeAction;
        }

        public void setTypeAction(String typeAction) {
            this.typeAction = typeAction;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

<<<<<<< HEAD
        // public int getID(){
        //     return this.typeData.getID_Type();
        // }

        // public String getName(){
        //     return this.typeData.getName_Type();
        // }
        
        // public String getIconPath(){
        //     return this.typeData.getIcon_Path();
        // }

        // public String getColor(){
        //     return this.typeData.getColor();
        // }

        // public int isReceiptsOrExpenses(){
        //     return this.typeData.isReceipts_Or_Expenses();
=======
        public int getIndexInTable() {
            return indexInTable;
        }

        public void setIndexInTable(int indexInTable) {
            this.indexInTable = indexInTable;
        }
        // public int getID(){
        //     return this.data.getID_Type();
        // }

        // public String getName(){
        //     return this.data.getName_Type();
        // }
        
        // public String getIconPath(){
        //     return this.data.getIcon_Path();
        // }

        // public String getColor(){
        //     return this.data.getColor();
        // }

        // public int isReceiptsOrExpenses(){
        //     return this.data.isReceipts_Or_Expenses();
>>>>>>> 0f18cb3521e2502f23fddfc7e1eceb9367e98437
        // }


    }