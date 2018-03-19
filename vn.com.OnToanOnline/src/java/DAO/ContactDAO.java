/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.util.List;
import model.Contact;

/**
 *
 * @author TienNguyen
 */
public interface ContactDAO<T,String> {
    List<Contact> getFullListContact(Connection con);
    boolean addNewContact(Connection con, Contact contact);
    boolean deleteContact(Connection con, Contact contact);
    boolean updateContact(Connection con, Contact contact);
    
}
