/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.util.List;
import model.ThanhVien;

/**
 *
 * @author TienNguyen
 */
public interface ThanhVienDAO<T,String> {
    List<ThanhVien> getFullListThanhVien(Connection con);
    List<ThanhVien> getFullListByName(Connection con, String name);
    
    boolean addNewThanhVien(Connection con, ThanhVien tv);
    boolean deleteThanhVien(Connection con, Integer id);
    boolean updateThanhVien(Connection con, ThanhVien tv);
    
    ThanhVien findThanhVien(Connection con, String name);
    ThanhVien findThanhVien(Connection con, String name, String password);
    boolean updatePoint(Connection con, ThanhVien tv);
    
    boolean UpdateLogged(Connection con, ThanhVien tv,String logged);
    
}
