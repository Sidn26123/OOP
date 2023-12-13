/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
<<<<<<< HEAD
package model.objects;
=======
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
>>>>>>> 0f18cb3521e2502f23fddfc7e1eceb9367e98437

/**
 *
 * @author LENOVO
 */
public class TypeO {
    private int ID_Type;
    private int ID_User;
<<<<<<< HEAD
    private boolean Receipts_Or_Expenses;
=======
    private int Receipts_Or_Expenses;
>>>>>>> 0f18cb3521e2502f23fddfc7e1eceb9367e98437
    private String Name_Type;
    private String Icon_Path;
    private String Color;
    private int ID_Budget;

<<<<<<< HEAD
=======
    public TypeO() {
        this.ID_Type = -1;
    }

    public TypeO(int ID_Type, int Receipts_Or_Expenses, String Name_Type, String Icon_Path, String Color) {
        this.ID_Type = ID_Type;
        // this.ID_User = ID_User;
        this.Receipts_Or_Expenses = Receipts_Or_Expenses;
        this.Name_Type = Name_Type;
        this.Icon_Path = Icon_Path;
        this.Color = Color;
        // this.ID_Budget = ID_Budget;
    }
>>>>>>> 0f18cb3521e2502f23fddfc7e1eceb9367e98437
    public int getID_Type() {
        return ID_Type;
    }

    public void setID_Type(int ID_Type) {
        this.ID_Type = ID_Type;
    }

    public int getID_User() {
        return ID_User;
    }

    public void setID_User(int ID_Log) {
        this.ID_User = ID_Log;
    }

<<<<<<< HEAD
    public boolean isReceipts_Or_Expenses() {
        return Receipts_Or_Expenses;
    }

    public void setReceipts_Or_Expenses(boolean Receipts_Or_Expenses) {
=======
    public int isReceipts_Or_Expenses() {
        return Receipts_Or_Expenses;
    }

    public void setReceipts_Or_Expenses(int Receipts_Or_Expenses) {
>>>>>>> 0f18cb3521e2502f23fddfc7e1eceb9367e98437
        this.Receipts_Or_Expenses = Receipts_Or_Expenses;
    }

    public String getName_Type() {
        return Name_Type;
    }

    public void setName_Type(String Name_Type) {
        this.Name_Type = Name_Type;
    }

    public String getIcon_Path() {
        return Icon_Path;
    }

    public void setIcon_Path(String Icon_Path) {
        this.Icon_Path = Icon_Path;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public int getID_Budget() {
        return ID_Budget;
    }

    public void setID_Budget(int ID_Budget) {
        this.ID_Budget = ID_Budget;
    }
    
<<<<<<< HEAD
    
=======
>>>>>>> 0f18cb3521e2502f23fddfc7e1eceb9367e98437
}
