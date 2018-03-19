/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Blob;

/**
 *
 * @author TienNguyen
 */
public class Toan {
    private int ID;
    private String cauHoi;
    private String da_A;
    private String da_B;
    private String da_C;
    private String da_D;
    private int ID_Correct;
    private String images;
    public Toan()
    {
        
    }
    public Toan(String cauHoi, String da_A, String da_B, String da_C, String da_D, int ID_Correct)
    {
        this.cauHoi = cauHoi;
        this.da_A = da_A;
        this.da_B = da_B;
        this.da_C = da_C;
        this.da_D = da_D;
        this.ID_Correct = ID_Correct;
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public String getDa_A() {
        return da_A;
    }

    public void setDa_A(String da_A) {
        this.da_A = da_A;
    }

    public String getDa_B() {
        return da_B;
    }

    public void setDa_B(String da_B) {
        this.da_B = da_B;
    }

    public String getDa_C() {
        return da_C;
    }

    public void setDa_C(String da_C) {
        this.da_C = da_C;
    }

    public String getDa_D() {
        return da_D;
    }

    public void setDa_D(String da_D) {
        this.da_D = da_D;
    }

    public int getID_Correct() {
        return ID_Correct;
    }

    public void setID_Correct(int ID_Correct) {
        this.ID_Correct = ID_Correct;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getImg() {
        return images;
    }

    public void setImg(String images) {
        this.images = images;
    }
    
    
}
