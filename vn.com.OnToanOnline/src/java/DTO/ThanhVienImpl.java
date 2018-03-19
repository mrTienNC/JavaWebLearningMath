/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Connections.ConnectionUtils;
import DAO.ThanhVienDAO;
import com.mysql.jdbc.Blob;
import model.ThanhVien;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TienNguyen
 */
public class ThanhVienImpl implements ThanhVienDAO<ThanhVien, String> {

    //Lấy danh sách thành viên
    @Override
    public List<ThanhVien> getFullListThanhVien(Connection con) {
        List<ThanhVien> lstThanhVien = new ArrayList();

        try {
            String sql = "Select ID, ho_ten, gioi_tinh, ngay_Sinh, truong_hoc,"
                    + "point,tinh_cach,so_thich,images,type,logged from thanh_vien"
                    + " where 1=1 And (type like '%member%')";

            con = ConnectionUtils.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ThanhVien objTV = new ThanhVien();
                objTV.setId(rs.getInt("ID"));
                objTV.setGioiTinh(rs.getString("gioi_tinh"));
                objTV.setHoTen(rs.getString("ho_Ten"));
                objTV.setNgaySinh(rs.getDate("ngay_Sinh"));
                objTV.setPoint(rs.getInt("point"));
                objTV.setTruongHoc(rs.getString("truong_hoc"));
                objTV.setTinhCach(rs.getString("tinh_cach"));
                objTV.setSoThich(rs.getString("so_thich"));
                objTV.setImages(rs.getString("images"));
                objTV.setLogged(rs.getString("logged"));
                objTV.setType(rs.getString("type"));
                lstThanhVien.add(objTV);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(getClass().getName()+"-Lỗi lấy danh sách TV : " + e);
        }

        return lstThanhVien;
    }
    //Lấy danh sách thành viên theo Tên
    @Override
    public List<ThanhVien> getFullListByName(Connection con, String name) {
        List<ThanhVien> lstThanhVien = new ArrayList();

        try {
            
            String sql = "Select ID, ho_ten, gioi_tinh, ngay_Sinh, truong_hoc,"
                    + "point,tinh_cach,so_thich,images,type,logged,images from thanh_vien where 1=1";
            if (!name.isEmpty()) {
                sql += " AND (ho_ten LIKE '%" + name + "%' AND type like '%member%')";
            }

            con = ConnectionUtils.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ThanhVien objTV = new ThanhVien();
                objTV.setId(rs.getInt("ID"));
                objTV.setGioiTinh(rs.getString("gioi_tinh"));
                objTV.setHoTen(rs.getString("ho_Ten"));
                objTV.setNgaySinh(rs.getDate("ngay_Sinh"));
                objTV.setPoint(rs.getInt("point"));
                objTV.setTruongHoc(rs.getString("truong_hoc"));
                objTV.setTinhCach(rs.getString("tinh_cach"));
                objTV.setSoThich(rs.getString("so_thich"));
                objTV.setImages(rs.getString("images"));
                objTV.setType(rs.getString("type"));
                objTV.setLogged(rs.getString("logged"));
                
                lstThanhVien.add(objTV);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(getClass().getName()+ "-Lỗi lấy danh sách TV : " + e);
        }

        return lstThanhVien;
    }

    //Thêm thành viên mưới
    @Override
    public boolean addNewThanhVien(Connection con, ThanhVien tv) {

        String sql = "Insert Into Thanh_Vien"
                + "(ho_ten,gioi_tinh,ngay_sinh,truong_hoc,user_name,password,"
                + "address,phone,email,type)"
                + " Values(?,?,?,?,?,?,?,?,?,?)";
        boolean KQ = false;

        try {
            con = ConnectionUtils.getConnection();

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, tv.getHoTen());
            pstm.setString(2, tv.getGioiTinh());
            pstm.setDate(3, (Date) tv.getNgaySinh());
            pstm.setString(4, tv.getTruongHoc());
            pstm.setString(5, tv.getUserName());
            pstm.setString(6, tv.getPassword());
            pstm.setString(7, tv.getAddress());
            pstm.setString(8, tv.getPhone());
            pstm.setString(9, tv.getEmail());
            pstm.setString(10, tv.getType());
            //thực thi
            KQ = ( pstm.executeUpdate() > 0);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(getClass().getName() + "-Lỗi insert Thành Viên");
        }
        return KQ;
    }
    //Xóa thành viên
    @Override
    public boolean deleteThanhVien(Connection con, Integer id) {
         String sql = "Delete From Thanh_Vien Where ID = ?";
         boolean KQ = false;
        try {
            con = ConnectionUtils.getConnection();

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            
            KQ = (pstm.executeUpdate() > 0);
           
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(getClass().getName()+ "-Lỗi delete");
        }
        return KQ;
    }
    //Update thông tin thành viên
    @Override
    public boolean updateThanhVien(Connection con, ThanhVien tv) {
        String sql = "Update Thanh_Vien"
                + " Set ho_ten = ?,gioi_tinh = ?, ngay_sinh = ?, truong_hoc = ?,"
                + "tinh_cach=?,so_thich = ?,address = ? , email = ? , phone = ?,"
                + "user_name = ? , password = ?, type = ?,images = ? where ID = ?";
        boolean KQ = false;
        try {
            con = ConnectionUtils.getConnection();

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, tv.getHoTen());
            pstm.setString(2, tv.getGioiTinh());
            pstm.setDate(3, (Date) tv.getNgaySinh());
            pstm.setString(4, tv.getTruongHoc());
            pstm.setString(5, tv.getTinhCach());
            pstm.setString(6, tv.getSoThich());
            pstm.setString(7, tv.getAddress());
            pstm.setString(8, tv.getEmail());
            pstm.setString(9, tv.getPhone());
            pstm.setString(10, tv.getUserName());
            pstm.setString(11, tv.getPassword());
            pstm.setString(12, tv.getType());
            pstm.setString(13, tv.getImages());
            pstm.setInt(14, tv.getId());
            //thực thi
            KQ = (pstm.executeUpdate() > 0);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(getClass().getName()+"-Lỗi update Thành Viên");
        }
        return KQ;
    }
    //Tìm kiếm thành viên
    @Override
    public ThanhVien findThanhVien(Connection con, String name) {
        String sql = "Select ID, ho_ten, gioi_tinh, ngay_sinh,"
                + "truong_hoc, point, user_name, password,tinh_cach,so_thich,images"
                + ",type from Thanh_Vien "
                + "where user_name = ?";

        try {
            con = ConnectionUtils.getConnection();

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, name);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ThanhVien tv = new ThanhVien();
                tv.setUserName(rs.getString("user_name"));
                tv.setPassword(rs.getString("password"));
                tv.setGioiTinh(rs.getString("gioi_tinh"));
                tv.setHoTen(rs.getString("ho_ten"));
                tv.setId(rs.getInt("ID"));
                tv.setNgaySinh(rs.getDate("ngay_sinh"));
                tv.setPoint(rs.getInt("point"));
                tv.setTruongHoc(rs.getString("truong_hoc"));
                tv.setTinhCach(rs.getString("tinh_cach"));
                tv.setSoThich(rs.getString("so_thich"));
                tv.setImages(rs.getString("images"));
                tv.setType(rs.getString("type"));

                return tv;
            }
        } catch (Exception ex) {
            System.out.println(getClass().getName()+"-lỗi tìm kiếm user thành viên");
            ex.printStackTrace();
        }

        return null;
    }
    //Cập nhật điểm
    @Override
    public boolean updatePoint(Connection con, ThanhVien tv) {
         String sql = "Update THanh_Vien set Point = ? where ID = ?";
         boolean KQ = false;
        try {
            con = ConnectionUtils.getConnection();

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, tv.getPoint());
            pstm.setInt(2, tv.getId());
            
            KQ = (pstm.executeUpdate() > 0);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(getClass().getName()+"-Lỗi update point - thành viên");
        }
        return KQ;
    }
    //Tìm kiếm thành viên đăng nhập
    @Override
    public ThanhVien findThanhVien(Connection con, String name, String password) {
        ThanhVien tv = null;

        String sql = "Select ID, ho_ten, gioi_tinh, ngay_sinh,"
                + "truong_hoc, point,tinh_cach,so_thich,images,"
                + "address,email,phone, user_name, password , type from Thanh_Vien where "
                + "(user_name = ? and password = ?)";
        try {
            con = ConnectionUtils.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, name);
            pstm.setString(2, password);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                tv = new ThanhVien();
                tv.setUserName(rs.getString("user_name"));
                tv.setPassword(rs.getString("password"));
                tv.setGioiTinh(rs.getString("gioi_tinh"));
                tv.setHoTen(rs.getString("ho_ten"));
                tv.setId(rs.getInt("ID"));
                tv.setNgaySinh(rs.getDate("ngay_sinh"));
                tv.setPoint(rs.getInt("point"));
                tv.setTruongHoc(rs.getString("truong_hoc"));
                tv.setTinhCach(rs.getString("tinh_cach"));
                tv.setSoThich(rs.getString("so_thich"));
                tv.setAddress(rs.getString("address"));
                tv.setEmail(rs.getString("email"));
                tv.setPhone(rs.getString("phone"));
                tv.setImages(rs.getString("images"));
                tv.setType(rs.getString("type"));
                
                return tv;
            }

        } catch (Exception e) {
            System.out.println("lỗi tìm kiếm user thành viên");
            e.printStackTrace();
        }
        return tv;
    }

    @Override
    public boolean UpdateLogged(Connection con, ThanhVien tv, String logged) {
        
        boolean KQ = false;
        
        String sql = "UPDATE Thanh_Vien SET logged = ? where Id = ?";
        
        try{
            con = ConnectionUtils.getConnection();
            
            PreparedStatement pstm = con.prepareStatement(sql);
            
            pstm.setString(1, logged);
            pstm.setInt(2, tv.getId());
            
            KQ = (pstm.executeUpdate() > 0);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(getClass().getName()+"-Lỗi update Logged");
        }
        
        return KQ;
    }
    

}
