/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connections;

import java.sql.Connection;

/**
 *
 * @author TienNguyen
 */
public class ConnectionUtils {
    
    public static Connection getConnection()
    {
        return Connect.getConnection();
    }
    public static void closeDB(Connection con)
            
    {
        try
        {
            con.close();
        }catch(Exception e)
        {
            
        }
    }
    public static void rollbackDB(Connection con)
    {
        try
        {
            con.rollback();
        }catch(Exception e)
        {
            
        }
    }
}
