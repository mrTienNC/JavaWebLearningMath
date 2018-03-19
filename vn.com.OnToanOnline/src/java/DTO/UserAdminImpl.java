/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Connections.ConnectionUtils;
import DAO.UserAdminDAO;
import model.UserAdmin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TienNguyen
 */
public class UserAdminImpl implements UserAdminDAO<Connection, String> {

    @Override
    public UserAdmin findUserAccount(Connection con, String userName, String password) {
        String sql = "Select id,fullname,birthday, address, phone, email, cmtnd, username, password "
                + ", images from admin where ((username = ? or email = ?) and password = ? )";

        UserAdmin user = null;

        try {
            con = ConnectionUtils.getConnection();

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, userName);
            pstm.setString(2, userName);
            pstm.setString(3, password);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                user = new UserAdmin();
                user.setId(rs.getInt("id"));
                user.setAddress(rs.getString("address"));
                user.setBirthday(rs.getDate("birthday"));
                user.setCmtnd(rs.getString("cmtnd"));
                user.setEmail(rs.getString("email"));
                user.setFullname(rs.getString("fullname"));
                user.setPhone(rs.getString("phone"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setImages(rs.getString("images"));

                return user;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(getClass().getName() + "- not found");
        }
        return user;
    }

    @Override
    public UserAdmin findUserAccount(Connection con, String userName) {
        String sql = "select username , password from admin where username = ?";

        try {
            con = ConnectionUtils.getConnection();

            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, userName);

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                UserAdmin user = new UserAdmin();
                user.setPassword(rs.getString("password"));
                user.setUserName(rs.getString("user_name"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(getClass().getName() + " -Không tìm thấy : ");
        }
        return null;
    }

    @Override
    public List<UserAdmin> getFullListUserAccount(Connection con, String name) {

        String sql = "select id, fullname, birthday, address, phone, email, username,"
                + ",cmtnd,password, images from admin where 1=1 and fullname = ?";
        List<UserAdmin> lstUser = new ArrayList();

        try {
            con = ConnectionUtils.getConnection();

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, name);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                UserAdmin ac = new UserAdmin();
                ac.setId(rs.getInt("id"));
                ac.setFullname(rs.getString("fullname"));
                ac.setAddress(rs.getString("address"));
                ac.setBirthday(rs.getDate("birthday"));
                ac.setCmtnd(rs.getString("cmtnd"));
                ac.setEmail(rs.getString("email"));
                ac.setPassword(rs.getString("password"));
                ac.setPhone(rs.getString("phone"));
                ac.setUserName(rs.getString("username"));
                ac.setImages(rs.getString("images"));
                lstUser.add(ac);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(getClass().getName() + "-Lỗi lấy danh sách User");
        }

        return lstUser;
    }
    
}
