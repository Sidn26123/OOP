
package controller;


import java.util.List;
import model.connection.TypeModel;
import model.objects.TypeO;


public class TypeController {
    private TypeModel typeDao;
    public TypeController(){
        typeDao = new TypeModel();
    }
    public List<TypeO> getAllTypeExpenses(int ID_User){
        return typeDao.getAllTypeExpenses(ID_User);
    }
    public List<TypeO> getAllTypeReceipt(int ID_User){
        return typeDao.getAllTypeReceipt(ID_User);
    }
    public TypeO findTypeByID_Type(int id_type){
        return typeDao.findTypebyID(id_type);
    }
}
