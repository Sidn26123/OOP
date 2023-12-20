package model.objects;
import java.util.Vector;

public class ActionStores {
    private Vector<ActionStore> actionStores; //lưu các hành động thêm, xóa, sửa vào đây
    private int indexOfActionStores; //index hiện tại của action

    public ActionStores() {
        this.actionStores = new Vector<>();
        this.indexOfActionStores = 0;
    }

    public ActionStore getActionItemAt(int index) {
        if (isIndexOfActionStoreValid() == false){
            System.err.println("Index out of bound");
            return null;   
        }
        return this.actionStores.get(index);
    }
    
    public int getSize(){
        return this.actionStores.size();
    }

    /**
     * Trả về index của actionStores hiện tại
     * @return
     */
    public int getIndexOfActionStores() {
        return indexOfActionStores;
    }

    public void setIndexOfActionStores(int indexOfActionStores) {
        // if (indexOfActionStores >= -1 && indexOfActionStores < this.actionStores.size()){
        this.indexOfActionStores = indexOfActionStores;
        // }

    }

    public Vector<ActionStore> getActionStores() {
        return actionStores;
    }

    public ActionStore getLastAction(){
        if(this.actionStores.size() > 0){
            return this.actionStores.get(this.actionStores.size() - 1);
        }
        return null;
    }
    
    public void addAction(ActionStore actionStoreItem){
        this.actionStores.add(actionStoreItem);
        this.indexOfActionStores = this.actionStores.size();
    }
    /**
     * Thêm action vào actionStores, thêm data + typeOfAction vào cuối vector
     * @param logO
     * @param typeOfAction "add" / "delete" / "update"
     */
    public void addAction(LogO logO, String typeOfAction){
        ActionStore actionStoresItem = new ActionStore(logO, typeOfAction, this.actionStores.size());
        this.addAction(actionStoresItem);
    }

    /**
     * Thêm action vào actionStores, thêm data + typeOfAction vào index, xóa các action từ index đến cuối
     * @param logO
     * @param typeOfAction "add" / "delete" / "update"
     * @param index
     */
    public void addActionAt(LogO logO, String typeOfAction, int index){
        // if (index >= this.getSize() || index < 0){
        //     System.err.println("Index không hợp lệ");
        //     return;   
        // }
        this.removeActionsAfterIndex(index); //Xóa các action sau index
        ActionStore actionStoresItem = new ActionStore(logO, typeOfAction, index);
        this.actionStores.addElement(actionStoresItem);
        this.indexOfActionStores = this.actionStores.size() - 1;

    }



    /**
     * Xóa action tại index
     * @param index
     */
    public void removeActionAt(int index){
        if (index >= this.getSize()){
            System.err.println("Index out of bound");
            return;   
        }
        this.actionStores.remove(index);

        //Cập nhật lại indexOfActionStores, nếu indexStore ở sau index thì cần cập nhật lại để đảm bảo logic
        if (index < this.indexOfActionStores){
            this.indexOfActionStores -= 1;
        }
    }

    /**
     * Xóa các action sau index (không xóa action tại index)
     * @param index
     */
    public void removeActionsAfterIndex(int index){
        if (index >= this.getSize()){
            // System.err.println("Index không hợp lệ");
            return;   
        }
        for(int i = this.actionStores.size() - 1; i > index; i--){
            this.actionStores.remove(i);
        }
        if (index < this.indexOfActionStores){
            this.indexOfActionStores = index + 1;
        }
    }

    /**
     * Xóa các action từ index
     * @param index
     */
    public void removeActionsFromIndex(int index){
        for(int i = this.actionStores.size() - 1; i >= index; i--){
            this.actionStores.remove(i);
        }
        // this.indexOfActionStores = index - 1; //index - 1 vì xóa action tại index
        if (index < this.indexOfActionStores){
            this.indexOfActionStores = index;
        }
    }

    /**
     * Xóa các action từ index + offset
     * @param index
     * @param offset
     */
    public void removeActionsFromIndex(int index, int offset){
        for(int i = this.actionStores.size() - 1; i >= index+offset; i--){
            this.actionStores.remove(i);
        }
        if (index + offset< this.indexOfActionStores){
            this.indexOfActionStores = index + offset;
        }
    }

    /**
     * Clear actionStores, set indexOfActionStores = -1
     */
    public void clearActionStores(){
        this.actionStores.clear();
        this.indexOfActionStores = 0;
    }

    public ActionStore getCurActionStoreItem(){
        if (this.indexOfActionStores >= 0 && this.indexOfActionStores < this.actionStores.size()){
            return this.actionStores.get(this.indexOfActionStores);
        }
        return null;
    }

    public void increaseIndexOfActionStore(){
        if (isIndexOfActionStoreValid()){
            this.indexOfActionStores++;
        }
    }

    public void increaseIndexOfActionStore(int offset){
        this.indexOfActionStores += offset;
    }
    
    public void decreaseIndexOfActionStore(){
        if (isIndexOfActionStoreValid()){
            this.indexOfActionStores--;
        }
    }

    public boolean isIndexOfActionStoreValid(){
        return this.indexOfActionStores >= -1 && this.indexOfActionStores <= this.actionStores.size();
    }

    public void printData(){
        System.out.println("ActionStores: ");
        for(int i = 0; i < this.actionStores.size(); i++){
            System.out.println("ID: "+ this.actionStores.get(i).getData().getID() + " Amount: " + this.actionStores.get(i).getData().getPrice() + " Type: " + this.actionStores.get(i).getTypeAction() + " Index: " + this.actionStores.get(i).getIndex());
        }
    }
}
