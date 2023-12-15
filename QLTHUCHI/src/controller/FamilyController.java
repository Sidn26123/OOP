
package controller;

import LoginSignup.Model.User;
import java.util.List;
import model.connection.FamilyModel;

public class FamilyController {
    FamilyModel familyModel;
    
    public FamilyController(){
        familyModel = new FamilyModel();
    }
    
    public List<User> getUsersGroup(int id_user){
        return familyModel.getUsersGroup(id_user);
    }
    public int getID_Group(int id_user){
        return familyModel.getIdGroup(id_user);
    }
    public void addLogGroup(List<List<String>> usersChoice, int id_log){
        for(List<String> userChoice: usersChoice){
            familyModel.addTypeGroup(Integer.parseInt(userChoice.get(0)), id_log);
        }
    }
    public List<List<String>> getUserChoice(int id_log){
        return familyModel.getNameUserChoice(id_log);
    }
    public String getNameGroup(int id_group){
        return familyModel.getNameGroup(id_group);
    }
}
