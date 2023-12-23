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

public class LogO {
    private int ID_Log;
    private int ID_Type;
    private int Price;
    private String Note;
    private String DateString;
    private int User_ID;
    private int Group_ID;

    public int getID() {
        return ID_Log;
    }
    public LogO() {
        this.ID_Log = -1;
    }

    public LogO(int ID_Log, int ID_Type, int Price, String Note, String DateString) {
        this.ID_Log = ID_Log;
        this.ID_Type = ID_Type;
        this.Price = Price;
        this.Note = Note;
        this.DateString = DateString;
        // this.User_ID = User_ID;
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

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public String getDateString() {
        return DateString;
    }


    public void setDateString(String DateString) {
        this.DateString = DateString;
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

    public Object[] toArray() {
        return new Object[] {ID_Log, ID_Type, Price, Note, DateString};
    }



    public Object[] toRowTable(Object[] structureString){
        Object[] row = new Object[structureString.length];
        for (int i = 0; i < structureString.length; i++) {
            switch (structureString[i].toString()) {
                // case "id":
                //     row[i] = this.id;
                //     break;
                // case "date":
                //     row[i] = this.date;
                //     break;
                // case "note":
                //     row[i] = this.note;
                //     break;
                // case "amount":
                //     row[i] = this.amount;
                //     break;
                // case "categoryId":
                //     row[i] = this.categoryId;
                //     break;
                // case "accountId":
                //     row[i] = this.accountId;
                //     break;
                // default:
                //     break;
                case "ID_Log":
                    row[i] = this.ID_Log;
                    break;
                case "ID_Type":
                    row[i] = this.ID_Type;
                    break;
                case "Price":
                    row[i] = this.Price;
                    break;
                case "Note":
                    row[i] = this.Note;
                    break;
                case "DateString":
                    row[i] = this.DateString;
                    break;
                default:
                    break;

            }
        }
        return row;
    }

    public LogO objToTransaction(Object[] obj) {
        LogO log = new LogO((int)obj[0], (int)obj[1], (int)obj[2], (String)obj[3], (String)obj[4]);
        return log;
    }
}
