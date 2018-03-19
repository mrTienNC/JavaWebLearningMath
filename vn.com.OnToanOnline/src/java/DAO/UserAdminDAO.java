/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.util.List;
import model.UserAdmin;

/**
 *
 * @author TienNguyen
 */
public interface UserAdminDAO<T,K> {
    UserAdmin findUserAccount(Connection con, String userName, String password);
    UserAdmin findUserAccount(Connection con, String userName);
    
    List<UserAdmin> getFullListUserAccount(T objT, K k);
}
