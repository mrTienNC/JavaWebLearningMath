/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ThanhVienDAO;
import DAO.UserAdminDAO;
import model.ThanhVien;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DTO.ThanhVienImpl;
import DTO.UserAdminImpl;
import model.UserAdmin;
import utils.MyUtils;

/**
 *
 * @author TienNguyen
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    ThanhVienDAO thanhVienImpl = new ThanhVienImpl();
    UserAdminDAO userImpl = new UserAdminImpl();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String tacVu = null;
        String login = "", contact = "", present = "", registry = "", info1 = "", info2 = "";
        String loginHref = "", contactHref = "", presentHref = "", registryHref = "";
        HttpSession session = request.getSession();
        ThanhVien user = MyUtils.getStoredMemberLogin(session);
        if (user == null) {
            tacVu = "Tác Vụ";
            registry = "Đăng Ký";
            login = "Đăng Nhập";
            contact = "Liên Hệ";
            present = "Giới Thiệu";
            info1 = "Bạn Chưa Có";
            info2 = "Tài Khoản ?";
            //set Href
            loginHref = "login";
            contactHref = "Contact";
            presentHref = "Presentation";
            registryHref = "Registry";

        } else {
            tacVu = user.getUserName();
            login = "Cá Nhân";
            contact = "Thống Kê";
            present = "Đăng Xuất";
            registry = "Luyện Tập";
            info1 = "Chào Mừng Bạn";
            info2 = "Trở Lại";

            loginHref = "Personal";
            contactHref = "Listed";
            presentHref = "LogOut";
            registryHref = "OnTap";
        }
        request.setAttribute("tacVu", tacVu);
        request.setAttribute("login", login);
        request.setAttribute("contact", contact);
        request.setAttribute("present", present);
        request.setAttribute("registry", registry);
        request.setAttribute("info1", info1);
        request.setAttribute("info2", info2);
        //set request Href
        request.setAttribute("loginHref", loginHref);
        request.setAttribute("contactHref", contactHref);
        request.setAttribute("presentHref", presentHref);
        request.setAttribute("registryHref", registryHref);
        //forward sang trang Login
        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/views/login/login_1.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //Lấy thông tin người dùng nhập vào
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String type = "";
        String errorString = null;
        ThanhVien user = null;
        UserAdmin account = null;
        boolean hasError = false;

        int check = 0;
        Connection con = MyUtils.getStoredConnection(request);
        if (userName.equals("") || password.equals("")) {

            hasError = true;
            errorString = "Username and Password required !";
//            response.sendRedirect(request.getServletPath()+"/login");

        } else {

            try {

                //tìm DB trong user
                user = thanhVienImpl.findThanhVien(con, userName, password);
//                account = userImpl.findUserAccount(con, userName, password);
                //admin
//                if (user != null && account == null) {
//                    check = 1;
//                } else if (user == null && account != null) {
//                    check = 2;
//                }
                if (user == null) {

                    hasError = true;
                    errorString = "User not found !";
                }
            } catch (Exception e) {
                e.printStackTrace();
                errorString = e.getMessage();
                hasError = true;
            }
        }
        //Trường hợp có lỗi thì request về trang login.jsp
        if (hasError) {
            user = new ThanhVien();

            user.setUserName(userName);
            user.setPassword(password);

            //Lưu các thông tin vào request attribute
            request.setAttribute("errorString", errorString);
            request.setAttribute("user", user);

            //forward tới trang login.jsp
            RequestDispatcher dispatcher
                    = this.getServletContext().getRequestDispatcher("/views/login/login_1.jsp");
            dispatcher.forward(request, response);
        } //trường hợp không xảy ra lỗi forward tới trang đăng nhập thành công
        else {
            HttpSession session = request.getSession();
//            if (check == 1) {
                thanhVienImpl.UpdateLogged(con, user, "logged");
                //Lưu thông tin vào session
                MyUtils.storeMemberLogin(session, user);
                //Redirect sang trang Home
                response.sendRedirect(request.getContextPath() + "/loginSuccess");
//            } else if (check == 2) {
//                MyUtils.storeUserLogin(session, account);
//                response.sendRedirect(request.getContextPath() + "/Admin");
//
//            }

        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
