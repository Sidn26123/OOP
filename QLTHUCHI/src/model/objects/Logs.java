/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.objects;

import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class Logs {
    private int ID_Log;
    private int ID_Type;
    private double Price;
    private String Note;
    private Date DatesString;
    private int User_ID;
    private int Group_ID;

    public int getID_Log() {
        return ID_Log;
    }

    public void setID_Log(int ID_Log) {
        this.ID_Log = ID_Log;
    }

    public int getID_Type() {
        return ID_Type;
    }

    public void setID_Type(int ID_Type) {
        this.ID_Type = ID_Type;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public Date getDatesString() {
        return DatesString;
    }

    public void setDatesString(Date DatesString) {
        this.DatesString = DatesString;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int User_ID) {
        this.User_ID = User_ID;
    }

    public int getGroup_ID() {
        return Group_ID;
    }

    public void setGroup_ID(int Group_ID) {
        this.Group_ID = Group_ID;
    }
    
    
}
