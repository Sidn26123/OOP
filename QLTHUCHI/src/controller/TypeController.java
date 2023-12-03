/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.util.List;
import model.connection.TypeModel;
import model.objects.Types;

/**
 *
 * @author LENOVO
 */
public class TypeController {
    private TypeModel typeDao;
    public TypeController(){
        typeDao = new TypeModel();
    }
    public List<Types> getAllTypeExpenses(){
        return typeDao.getAllTypeExpenses();
    }
}
