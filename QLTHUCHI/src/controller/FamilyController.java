
package controller;

import LoginSignup.Model.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.connection.FamilyModel;
import model.objects.Price_Group;

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
    public void setOutGroup(int id_user){
        int id_group = familyModel.getIdGroup(id_user);
        if(familyModel.is_HostGroupUser(id_user, id_group)){
            List<User> users = familyModel.getUsersGroup(id_user);
            for(User user: users){
                if(user.getID() != id_user){
                    familyModel.setID_Host(user.getID(), id_group);
                    break;
                }
            }
        }
        familyModel.setOutGroup(id_user);
    }
    public boolean is_HostGroupUser(int id_user, int id_group){
        return familyModel.is_HostGroupUser(id_user, id_group);
    }
    
    public int add_member_group(String input, int id_group){
        int id_user = 0;
        try {
            id_user = Integer.parseInt(input);
        } catch (NumberFormatException e) {
        }
        if(id_user != 0){
            if(familyModel.is_user_had_group(id_user)){
                return -1;
            }
            else{
                
                return familyModel.add_member_toGroup(id_user, id_group);
            }
        }
        else{
            List<User> users = familyModel.getAllUser();
            for(User user: users){
                if(user.getGroup_ID() != id_group){
                    if(user.getUserName().equals(input) || user.getEmailAddress().equals(input)){
                        return familyModel.add_member_toGroup(user.getID(), id_group);
                    }
                }
                else{
                    return -1;
                }
            }
        }
        return 0;
    }
    public void setID_Host(int id_user, int id_group){
        familyModel.setID_Host(id_user, id_group);
    }
    public Map<Integer, Map<Integer, Double>> getPriceMemberGroup(int id_user, int month, int year){
        List<Price_Group> lsPrice_Group = familyModel.getPrice_Group(familyModel.getIdGroup(id_user), month, year);
        List<User> members = getUsersGroup(id_user);
        int length = members.size();
        Map<Integer, Map<Integer, Double>> price_per_member = new HashMap<>();
        for(User member : members){
            Map<Integer, Double> tmp = new HashMap<>();
            for(User tmp_user: members){
                tmp.put(tmp_user.getID(),0.0);
            }
            price_per_member.put(member.getID(), tmp);
        }
        for(User member: members){
            for(Price_Group price_Group: lsPrice_Group){
                if(member.getID() == price_Group.getID_User_Expenses()){
                    if(member.getID() == price_Group.getUser_ID()){
                        price_per_member.get(member.getID()).put(member.getID(), 0.0);
                    }
                    else{
                        double price = price_per_member.get(member.getID()).get(price_Group.getUser_ID()) + price_Group.getPrice_per_user();
                        price_per_member.get(member.getID()).put(price_Group.getUser_ID(), price);
                    }
                }
            }
        }
        return price_per_member;
    }
}
