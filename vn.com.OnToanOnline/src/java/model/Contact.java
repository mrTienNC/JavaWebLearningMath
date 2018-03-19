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
public class Contact implements Comparable<Contact>{
    private int id;
    private String fullName;
    private String phone;
    private String email;
    private String content;
    private Date contactDate;
    private String check;
    
    public Contact() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getContact() {
        return contactDate;
    }

    public void setContact(Date contactDate) {
        this.contactDate = contactDate;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public Contact(int id, String fullName, String phone, String email, String content, Date contactDate, String check) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.content = content;
        this.contactDate = contactDate;
        this.check = check;
    }
    
    public Contact(String fullName, String phone, String email, String content) {
       
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.content = content;
    }
    
    @Override
    public int compareTo(Contact o) {
        return (this.id > o.id) ? 1 : -1 ;
    }
    
    
}
