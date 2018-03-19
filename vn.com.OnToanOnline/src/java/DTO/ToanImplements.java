/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Connections.ConnectionUtils;
import DAO.ToanDAO;
import model.Toan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author TienNguyen
 */
public class ToanImplements implements ToanDAO<Connection,Toan> {

    @Override
    public List<Toan> getFullListToan1(Connection con) {
        List<Toan> lstToan = new ArrayList();

        String sql = "Select ID,cau_hoi,images, dap_an_A, dap_An_B, dap_AN_C, dap_AN_D"
                + " , ID_Correct from toan_lop_1 where phan_loai like '%basic%'";
        try {
            con = ConnectionUtils.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Toan objTL = new Toan();
                objTL.setID(rs.getInt("ID"));
                objTL.setCauHoi(rs.getString("cau_hoi"));
                objTL.setDa_A(rs.getString("dap_an_a"));
                objTL.setDa_B(rs.getString("dap_an_b"));
                objTL.setDa_C(rs.getString("dap_an_c"));
                objTL.setDa_D(rs.getString("dap_an_d"));
                objTL.setID_Correct(rs.getInt("ID_Correct"));
                objTL.setImg(rs.getString("Images"));

                lstToan.add(objTL);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi lấy câu hỏi !");
        }

        return lstToan;
    }

    @Override
    public List<Toan> getFullListToan2(Connection con) {
        List<Toan> lstToan = new ArrayList();

        String sql = "Select ID,cau_hoi,images, dap_an_A, dap_An_B, dap_AN_C, dap_AN_D"
                + " , ID_Correct from toan_lop_2";
        try {
            con = ConnectionUtils.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Toan objTL = new Toan();
                objTL.setID(rs.getInt("ID"));
                objTL.setCauHoi(rs.getString("cau_hoi"));
                objTL.setDa_A(rs.getString("dap_an_a"));
                objTL.setDa_B(rs.getString("dap_an_b"));
                objTL.setDa_C(rs.getString("dap_an_c"));
                objTL.setDa_D(rs.getString("dap_an_d"));
                objTL.setID_Correct(rs.getInt("ID_Correct"));
                objTL.setImg(rs.getString("images"));

                lstToan.add(objTL);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi lấy câu hỏi !");
        }

        return lstToan;
    }

    @Override
    public List<Toan> getFullListToan3(Connection con) {
        List<Toan> lstToan = new ArrayList();

        String sql = "Select ID,cau_hoi,images, dap_an_A, dap_An_B, dap_AN_C, dap_AN_D"
                + " , ID_Correct from toan_lop_3";
        try {
            con = ConnectionUtils.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Toan objTL = new Toan();
                objTL.setID(rs.getInt("ID"));
                objTL.setCauHoi(rs.getString("cau_hoi"));
                objTL.setDa_A(rs.getString("dap_an_a"));
                objTL.setDa_B(rs.getString("dap_an_b"));
                objTL.setDa_C(rs.getString("dap_an_c"));
                objTL.setDa_D(rs.getString("dap_an_d"));
                objTL.setID_Correct(rs.getInt("ID_Correct"));
                objTL.setImg(rs.getString("images"));

                lstToan.add(objTL);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi lấy câu hỏi !");
        }

        return lstToan;
    }

    @Override
    public List<Toan> getFullListToan4(Connection con) {
        List<Toan> lstToan = new ArrayList();

        String sql = "Select ID,cau_hoi,images, dap_an_A, dap_An_B, dap_AN_C, dap_AN_D"
                + " , ID_Correct from toan_lop_4";
        try {
            con = ConnectionUtils.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Toan objTL = new Toan();
                objTL.setID(rs.getInt("ID"));
                objTL.setCauHoi(rs.getString("cau_hoi"));
                objTL.setDa_A(rs.getString("dap_an_a"));
                objTL.setDa_B(rs.getString("dap_an_b"));
                objTL.setDa_C(rs.getString("dap_an_c"));
                objTL.setDa_D(rs.getString("dap_an_d"));
                objTL.setID_Correct(rs.getInt("ID_Correct"));
                objTL.setImg(rs.getString("images"));

                lstToan.add(objTL);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi lấy câu hỏi !");
        }

        return lstToan;
    }

    @Override
    public List<Toan> getFullListToan5(Connection con) {
        List<Toan> lstToan = new ArrayList();

        String sql = "Select ID,cau_hoi,images, dap_an_A, dap_An_B, dap_AN_C, dap_AN_D"
                + " , ID_Correct from toan_lop_5";
        try {
            con = ConnectionUtils.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Toan objTL = new Toan();
                objTL.setID(rs.getInt("ID"));
                objTL.setCauHoi(rs.getString("cau_hoi"));
                objTL.setDa_A(rs.getString("dap_an_a"));
                objTL.setDa_B(rs.getString("dap_an_b"));
                objTL.setDa_C(rs.getString("dap_an_c"));
                objTL.setDa_D(rs.getString("dap_an_d"));
                objTL.setID_Correct(rs.getInt("ID_Correct"));
                objTL.setImg(rs.getString("images"));

                lstToan.add(objTL);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Lỗi lấy câu hỏi !");
        }

        return lstToan;
    }

    @Override
    public List<Toan> randomListToan(List<Toan> lst) {
        List<Toan> lstX = new ArrayList<Toan>();
        for (int i = 0; i < lst.size(); i++) {
            lstX.add(lst.get(i));
        }
        Collections.shuffle(lstX);

        return lstX;
    }

    @Override
    public boolean addNewItemToan1(Connection con, Toan objToan) {
        
        String sql = "INSERT INTO toan_lop_1(cau_hoi,dap_an_A, dap_An_B, dap_AN_C,dap_AN_D"
                + " ,images, ID_Correct) VALUES(?,?,?,?,?,?,?)";
        boolean KQ = false;
        
        try{
            con = ConnectionUtils.getConnection();
            
            PreparedStatement pstm = con.prepareStatement(sql);
            
            pstm.setString(1, objToan.getCauHoi());
            pstm.setString(2, objToan.getDa_A());
            pstm.setString(3, objToan.getDa_B());
            pstm.setString(4, objToan.getDa_C());
            pstm.setString(5, objToan.getDa_D());
            pstm.setString(6, objToan.getImg());
            pstm.setInt(7, objToan.getID_Correct());
            
            KQ = (pstm.executeUpdate() > 0);
        }catch(Exception e){
            System.out.println(getClass().getName()+"-Lỗi add Toán Lớp 1");
        }
        
        return KQ;
    }

    @Override
    public boolean addNewItemToan2(Connection con, Toan objToan) {
        String sql = "INSERT INTO toan_lop_2(cau_hoi,dap_an_A, dap_An_B, dap_AN_C,dap_AN_D"
                + " ,images, ID_Correct) VALUES(?,?,?,?,?,?,?)";
        boolean KQ = false;
        
        try{
            con = ConnectionUtils.getConnection();
            
            PreparedStatement pstm = con.prepareStatement(sql);
            
            pstm.setString(1, objToan.getCauHoi());
            pstm.setString(2, objToan.getDa_A());
            pstm.setString(3, objToan.getDa_B());
            pstm.setString(4, objToan.getDa_C());
            pstm.setString(5, objToan.getDa_D());
            pstm.setString(6, objToan.getImg());
            pstm.setInt(7, objToan.getID_Correct());
            
            KQ = (pstm.executeUpdate() > 0);
        }catch(Exception e){
            System.out.println(getClass().getName()+"-Lỗi add Toán Lớp 1");
        }
        
        return KQ;
    }

    @Override
    public boolean addNewItemToan3(Connection con, Toan objToan) {
       String sql = "INSERT INTO toan_lop_3(cau_hoi,dap_an_A, dap_An_B, dap_AN_C,dap_AN_D"
                + " ,images, ID_Correct) VALUES(?,?,?,?,?,?,?)";
        boolean KQ = false;
        
        try{
            con = ConnectionUtils.getConnection();
            
            PreparedStatement pstm = con.prepareStatement(sql);
            
            pstm.setString(1, objToan.getCauHoi());
            pstm.setString(2, objToan.getDa_A());
            pstm.setString(3, objToan.getDa_B());
            pstm.setString(4, objToan.getDa_C());
            pstm.setString(5, objToan.getDa_D());
            pstm.setString(6, objToan.getImg());
            pstm.setInt(7, objToan.getID_Correct());
            
            KQ = (pstm.executeUpdate() > 0);
        }catch(Exception e){
            System.out.println(getClass().getName()+"-Lỗi add Toán Lớp 1");
        }
        
        return KQ;
    }

    @Override
    public boolean addNewItemToan4(Connection con, Toan objToan) {
        String sql = "INSERT INTO toan_lop_4(cau_hoi,dap_an_A, dap_An_B, dap_AN_C,dap_AN_D"
                + " ,images, ID_Correct) VALUES(?,?,?,?,?,?,?)";
        boolean KQ = false;
        
        try{
            con = ConnectionUtils.getConnection();
            
            PreparedStatement pstm = con.prepareStatement(sql);
            
            pstm.setString(1, objToan.getCauHoi());
            pstm.setString(2, objToan.getDa_A());
            pstm.setString(3, objToan.getDa_B());
            pstm.setString(4, objToan.getDa_C());
            pstm.setString(5, objToan.getDa_D());
            pstm.setString(6, objToan.getImg());
            pstm.setInt(7, objToan.getID_Correct());
            
            KQ = (pstm.executeUpdate() > 0);
        }catch(Exception e){
            System.out.println(getClass().getName()+"-Lỗi add Toán Lớp 1");
        }
        
        return KQ;
    }

    @Override
    public boolean addNewItemToan5(Connection con, Toan objToan) {
        String sql = "INSERT INTO toan_lop_5(cau_hoi,dap_an_A, dap_An_B, dap_AN_C,dap_AN_D"
                + " ,images, ID_Correct) VALUES(?,?,?,?,?,?,?)";
        boolean KQ = false;
        
        try{
            con = ConnectionUtils.getConnection();
            
            PreparedStatement pstm = con.prepareStatement(sql);
            
            pstm.setString(1, objToan.getCauHoi());
            pstm.setString(2, objToan.getDa_A());
            pstm.setString(3, objToan.getDa_B());
            pstm.setString(4, objToan.getDa_C());
            pstm.setString(5, objToan.getDa_D());
            pstm.setString(6, objToan.getImg());
            pstm.setInt(7, objToan.getID_Correct());
            
            KQ = (pstm.executeUpdate() > 0);
        }catch(Exception e){
            System.out.println(getClass().getName()+"-Lỗi add Toán Lớp 1");
        }
        
        return KQ;
    }

    @Override
    public boolean addNewItemToan6(Connection con, Toan objToan) {
        String sql = "INSERT INTO toan_tong_hop(cau_hoi,dap_an_A, dap_An_B, dap_AN_C,dap_AN_D"
                + " ,images, ID_Correct) VALUES(?,?,?,?,?,?,?)";
        boolean KQ = false;
        
        try{
            con = ConnectionUtils.getConnection();
            
            PreparedStatement pstm = con.prepareStatement(sql);
            
            pstm.setString(1, objToan.getCauHoi());
            pstm.setString(2, objToan.getDa_A());
            pstm.setString(3, objToan.getDa_B());
            pstm.setString(4, objToan.getDa_C());
            pstm.setString(5, objToan.getDa_D());
            pstm.setString(6, objToan.getImg());
            pstm.setInt(7, objToan.getID_Correct());
            
            KQ = (pstm.executeUpdate() > 0);
        }catch(Exception e){
            System.out.println(getClass().getName()+"-Lỗi add Toán Lớp 1");
        }
        
        return KQ;
    }
}
