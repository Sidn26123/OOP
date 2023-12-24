
package controller;


import java.util.List;
import model.connection.TypeModel;
import model.objects.TypeO;


public class TypeController {
    private TypeModel typeDao;
    public TypeController(){
        typeDao = new TypeModel();
    }
    public List<TypeO> getAllTypeExpenses(){
        return typeDao.getAllTypeExpenses();
    }
    public List<TypeO> getAllTypeReceipt(){
        return typeDao.getAllTypeReceipt();
    }
    public TypeO findTypeByID_Type(int id_type){
        return typeDao.findTypebyID(id_type);
    }
}
