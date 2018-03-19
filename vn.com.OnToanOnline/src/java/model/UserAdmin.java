/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author TienNguyen
 */
public class UserAdmin {
    private int Id;
    private String fullname;
    private Date birthday;
    private String address;
    private String phone;
    private String cmtnd;
    private String email;
    
    private String userName;
    private String password;
    private String images;

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
    
    public UserAdmin()
    {
        
    }
    public UserAdmin(String userName, String password)
    {
        this.userName = userName;
        this.password = password;
    }

    public UserAdmin(int Id, String fullname, Date birthday, String address, String phone, String cmtnd, String email, String userName, String password, String images) {
        this.Id = Id;
        this.fullname = fullname;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.cmtnd = cmtnd;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.images = images;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCmtnd() {
        return cmtnd;
    }

    public void setCmtnd(String cmtnd) {
        this.cmtnd = cmtnd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
