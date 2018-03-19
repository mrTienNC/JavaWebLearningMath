/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import model.ThanhVien;
import model.Toan;
import model.UserAdmin;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TienNguyen
 */
public class MyUtils {
    private static final String ATT_NAME_USER = "ATT_NAME_USER";
    private static final String ATT_NAME_CON = "ATT_NAME_CON";
    private static final String STORE_LIST = "STORE_LIST";
    private static final List<Toan> LIST_TOAN = null;
    //lưu trữ connection vào request attribute
    public static void storeConnection(ServletRequest request, Connection con)
    {
        request.setAttribute(ATT_NAME_CON, con);
    }
    //lấy connection từ reuqest attribute
    public static Connection getStoredConnection(ServletRequest request)
    {
        Connection con = (Connection) request.getAttribute(ATT_NAME_CON);
        return con;
    }
    //Lưu trữ List
    public static void storeList(ServletRequest request, List<Toan> lstx)
    {
        request.setAttribute(STORE_LIST, lstx);
    }
    public static void storedList(HttpSession session, List<Toan> lst){
        session.setAttribute(STORE_LIST, lst);

        
    }
    //Lấy list
    public static List<Toan> getStoredList(ServletRequest request)
    {
        List<Toan> lst = (List<Toan>) request.getAttribute(STORE_LIST);
        return lst;
    }
    public static List<Toan> getStoredList(HttpSession session){
        List<Toan> lst = (List<Toan>) session.getAttribute(STORE_LIST);
        return lst;
    }
    //Xóa list
    public static void removeStoredList(HttpServletRequest request){
        request.removeAttribute(STORE_LIST);
    }
    public static void remoteStoreList(HttpSession session){

        session.removeAttribute(STORE_LIST);
     
    }
    //Lưu trữ người dùng vào sessioon
    public static void storeUserLogin(HttpSession session, UserAdmin loginedUser)
    {
        session.setAttribute(ATT_NAME_USER, loginedUser);
    }
    //lấy thông tin người dùng đăng nhập trong session
    public static UserAdmin getStoreUserLogin(HttpSession session)
    {
        UserAdmin loginedUSer = (UserAdmin) session.getAttribute(ATT_NAME_USER);
        return loginedUSer;
    }
    //Lưu trữ thành viên login
    public static void storeMemberLogin(HttpSession session, ThanhVien loginMember)
    {
        session.setAttribute(ATT_NAME_USER, loginMember);
    }
    //Lấy thông tin member được lưu trữ
    public static ThanhVien getStoredMemberLogin(HttpSession session)
    {
        ThanhVien loginMember = (ThanhVien) session.getAttribute(ATT_NAME_USER);
        return loginMember;
    }
    //Lưu thông tin người dùng vào cookie
    public static void storeUserCookie(HttpServletResponse response, UserAdmin user)
    {
        System.out.println("Cookie Stored");
        
        Cookie cookieUserName = new Cookie(ATT_NAME_USER, user.getUserName());
        
        //set thời gian
        cookieUserName.setMaxAge(24 * 60 * 60);
        response.addCookie(cookieUserName);
    }
    //Lấy thông tin user trong cookie
    public static String getStoredUser(HttpServletRequest request)
    {
        Cookie[] cookies = request.getCookies();
        if(cookies != null)
        {
            for(Cookie ck : cookies)
            {
                if(ATT_NAME_USER.equals(ck.getName()))
                {
                    return ck.getValue();
                }
            }
        }
        return null;
    }
    //Xóa cookie người dùng
    public static void deleteUserCookie(HttpServletResponse response)
    {
        Cookie cookieUserName =  new Cookie(ATT_NAME_USER, null);
        //set thời gian 0s
        cookieUserName.setMaxAge(0);
        response.addCookie(cookieUserName);
    }
}
