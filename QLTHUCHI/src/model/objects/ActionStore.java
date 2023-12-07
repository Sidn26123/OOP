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
        // }


    }