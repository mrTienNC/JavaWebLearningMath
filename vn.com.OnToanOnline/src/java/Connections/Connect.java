/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connections;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author TienNguyen
 */
public class Connect {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost/thitoanonline"
            + "?characterEncoding=utf-8&useUnicode=true";
    
    public static Connection getConnection()
    {
        Connection con = null;
        
        try
        {
            Class.forName(JDBC_DRIVER);
            
            con = DriverManager.getConnection(DATABASE_URL, "root", "Letmeknow_9x");
            
        }catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Lỗi kết nối !");
        }
        return con;
    }
}
