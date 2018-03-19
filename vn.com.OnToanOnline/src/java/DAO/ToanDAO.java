/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Toan;

/**
 *
 * @author TienNguyen
 */
public interface ToanDAO<T,K> {
    List<Toan> getFullListToan1(T objT);
    List<Toan> getFullListToan2(T objT);
    List<Toan> getFullListToan3(T objT);
    List<Toan> getFullListToan4(T objT);
    List<Toan> getFullListToan5(T objT);
    
    List<Toan> randomListToan(List<Toan> lst);
    
    boolean addNewItemToan1(T objT, K k);
    boolean addNewItemToan2(T objT, K k);
    boolean addNewItemToan3(T objT, K k);
    boolean addNewItemToan4(T objT, K k);
    boolean addNewItemToan5(T objT, K k);
    boolean addNewItemToan6(T objT, K k);
}
