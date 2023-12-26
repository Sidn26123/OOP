
package controller;

import LoginSignup.Model.User;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.connection.FamilyModel;
import model.objects.FamilyChartO;
import model.objects.Price_Group;
import view.family.Family_Chart;
import view.family.chart.Chart;
import view.family.chart.ModelChart;

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
    public void updateLogGroup(List<List<String>> usersChoice, int id_log){
        familyModel.deleteLogGroupbyID_log(id_log);
        for(List<String> userChoice: usersChoice){
            familyModel.updateTypeGroup(Integer.parseInt(userChoice.get(0)), id_log);
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
    public void getPricePerMonth(int id_group, int year, Chart chart){
        Map<Integer,FamilyChartO> lsFamilyChartO = familyModel.getPricePerMonth(id_group, year);
        List<Integer> lsmonth = new ArrayList<>(lsFamilyChartO.keySet());
        int month = 1;
        
        while(month <= 12){
            switch (month) {
                case 1 -> setMonthChart(lsFamilyChartO, month, lsmonth, "1", chart);
                case 2 -> setMonthChart(lsFamilyChartO, month, lsmonth, "2", chart);
                case 3 -> setMonthChart(lsFamilyChartO, month, lsmonth, "3", chart);
                case 4 -> setMonthChart(lsFamilyChartO, month, lsmonth, "4", chart);
                case 5 -> setMonthChart(lsFamilyChartO, month, lsmonth, "5", chart);
                case 6 -> setMonthChart(lsFamilyChartO, month, lsmonth, "6", chart);
                case 7 -> setMonthChart(lsFamilyChartO, month, lsmonth, "7", chart);
                case 8 -> setMonthChart(lsFamilyChartO, month, lsmonth, "8", chart);
                case 9 -> setMonthChart(lsFamilyChartO, month, lsmonth, "9", chart);
                case 10 -> setMonthChart(lsFamilyChartO, month, lsmonth, "10", chart);
                case 11 -> setMonthChart(lsFamilyChartO, month, lsmonth, "11", chart);
                case 12 -> setMonthChart(lsFamilyChartO, month, lsmonth, "12", chart);
                default -> throw new AssertionError();
            }
            month += 1;
        }
        chart.start();
    }
    private void setMonthChart(Map<Integer,FamilyChartO> lsFamilyChartO,int month, List<Integer> lsmonth, String montString, Chart chart){
        if(lsmonth.contains(month)){
                System.out.println(month);
                chart.addData(new ModelChart(montString, new double[]{lsFamilyChartO.get(month).getSum_price()}));
        }
        else{
            chart.addData(new ModelChart(montString, new double[]{0}));
        }
    }
}
