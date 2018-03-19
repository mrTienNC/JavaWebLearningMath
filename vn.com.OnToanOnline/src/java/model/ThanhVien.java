/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mysql.jdbc.Blob;
import java.util.Date;

/**
 *
 * @author TienNguyen
 */
public class ThanhVien implements Comparable<ThanhVien> {

    private int id;
    private String hoTen;
    private String gioiTinh;
    private Date ngaySinh;
    private String truongHoc;
    private int point;
    private String userName;
    private String password;
    private String tinhCach;
    private String soThich;
    private String images;
    private String email;
    private String phone;
    private String address;
    private String  type;
    private String logged ; 

    
    
    public String getLogged() {
        return logged;
    }

    public void setLogged(String logged) {
        this.logged = logged;
    }
    public ThanhVien() {

    }

    public ThanhVien(String hoTen, String gioiTinh, Date ngaySinh, String truongHoc, String userName, String password, String email, String phone, String address) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.truongHoc = truongHoc;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public ThanhVien(int id, String hoTen, String gioiTinh, Date ngaySinh, String truongHoc, int point, String userName, String password, String tinhCach, String soThich, String images, String email, String phone, String address, String type, String logged) {
        this.id = id;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.truongHoc = truongHoc;
        this.point = point;
        this.userName = userName;
        this.password = password;
        this.tinhCach = tinhCach;
        this.soThich = soThich;
        this.images = images;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.type = type;
        this.logged = logged;
    }
    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public ThanhVien(int id, int point) {
        this.id = id;
        this.point = point;
    }

 

    public String getHoTen() {
        return hoTen;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getTruongHoc() {
        return truongHoc;
    }

    public void setTruongHoc(String truongHoc) {
        this.truongHoc = truongHoc;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTinhCach() {
        return tinhCach;
    }

    public void setTinhCach(String tinhCach) {
        this.tinhCach = tinhCach;
    }

    public String getSoThich() {
        return soThich;
    }

    public void setSoThich(String soThich) {
        this.soThich = soThich;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Override
    public int compareTo(ThanhVien o) {
        return this.point < o.point ? 1 : -1;
    }

}
