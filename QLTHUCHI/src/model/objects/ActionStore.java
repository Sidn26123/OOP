package model.objects;


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
        // }


    }