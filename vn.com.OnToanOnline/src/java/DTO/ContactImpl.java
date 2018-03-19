/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Connections.ConnectionUtils;
import DAO.ContactDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Contact;

/**
 *
 * @author TienNguyen
 */
public class ContactImpl implements ContactDAO<Connection, String> {

    @Override
    public List<Contact> getFullListContact(Connection con) {

        List<Contact> lstContact = new ArrayList();
        String sql = "Select id,fullname,email,phone,content,date,checkRead "
                + " from contact where 1=1 ";

        try {
            con = ConnectionUtils.getConnection();
           
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                Contact ct = new Contact();
                
                ct.setCheck(rs.getString("checkRead"));
                ct.setContact(rs.getDate("date"));
                ct.setContent(rs.getString("content"));
                ct.setEmail(rs.getString("email"));
                ct.setFullName(rs.getString("fullname"));
                ct.setId(rs.getInt("id"));
                ct.setPhone(rs.getString("phone"));
                
                lstContact.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(getClass().getName() + "-Lỗi getFullist Contact");
        }

        return lstContact;
    }

    @Override
    public boolean addNewContact(Connection con, Contact contact) {
        boolean KQ = false;

        String sql = "INSERT INTO Contact(full_name,email,phone,content)"
                + " value (?,?,?,?)";
        try {
            con = ConnectionUtils.getConnection();

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, contact.getFullName());
            pstm.setString(2, contact.getEmail());
            pstm.setString(3, contact.getPhone());
            pstm.setString(4, contact.getContent());

            KQ = (pstm.executeUpdate() > 0);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(getClass().getName() + "-Lỗi Insert Contact");
        }

        return KQ;
    }

    @Override
    public boolean deleteContact(Connection con, Contact contact) {
        boolean KQ = false;

        String sql = "DELETE Contact WHERE Id = ?";
        try {
            con = ConnectionUtils.getConnection();

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, contact.getId());

            KQ = (pstm.executeUpdate() > 0);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(getClass().getName() + "-Lỗi Update Contact");
        }

        return KQ;
    }

    @Override
    public boolean updateContact(Connection con, Contact contact) {
        boolean KQ = false;

        String sql = "Update Contact SET full_name = ?,email = ?, phone = ? ,"
                + " content = ? where ID = ? ";
        try {
            con = ConnectionUtils.getConnection();

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, contact.getFullName());
            pstm.setString(2, contact.getEmail());
            pstm.setString(3, contact.getPhone());
            pstm.setString(4, contact.getContent());
            pstm.setInt(5, contact.getId());

            KQ = (pstm.executeUpdate() > 0);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(getClass().getName() + "-Lỗi Update Contact");
        }

        return KQ;
    }

}
