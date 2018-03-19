/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ThanhVienDAO;
import model.ThanhVien;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DTO.ThanhVienImpl;
import utils.MyUtils;

/**
 *
 * @author TienNguyen
 */
@WebServlet(name = "DangKyServlet", urlPatterns = {"/Registry"})
public class Registry extends HttpServlet {

    ThanhVienDAO thanhVienImpl = new ThanhVienImpl();

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
        //Kiểm tra thông tin trong session
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
        //Forward sang trang đăng ký
        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/views/registry/registry.jsp");
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
        String hoTen = request.getParameter("fullName");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        String school = request.getParameter("school");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        //khai báo kiểm tra
        String errorRegistry = null;
        ThanhVien tv = null;
        boolean hasError = false;
        //Thực hiện việc đăng ký, thêm vào database
        Connection con = MyUtils.getStoredConnection(request);
        //Kiểm tra nếu có lỗi đưa ra thông báo !
        if (hoTen.equals("") || sex.equals("") || birthday.equals("") || school.equals("")
                || userName.equals("") || password.equals("") || address.equals("")
                || phone.equals("") || email.equals("")) {

            errorRegistry = "Điền đầy đủ thông tin !";
        }
        if (errorRegistry == null) {
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
                java.sql.Date dateNS = new java.sql.Date(date.getTime());
                tv = new ThanhVien(hoTen, sex, dateNS, school, userName, password, email, phone, address);

                hasError = thanhVienImpl.addNewThanhVien(con, tv);

            } catch (Exception ex) {
                ex.printStackTrace();
                errorRegistry = ex.getMessage();
            }
        }
        //Lưu thông tin vào request attribute
        request.setAttribute("errorRegistry", errorRegistry);
        request.setAttribute("tv", tv);
        //Kiểm tra có lỗi thì forward lại trang đăng ký
        if (errorRegistry != null) {
            RequestDispatcher dispatcher
                    = request.getServletContext().getRequestDispatcher("/views/registry/registry.jsp");
            dispatcher.forward(request, response);
        }//nếu ko có lỗi thì forward sang trang thông báo thành công
        else {
            if (hasError) {
                errorRegistry = "Đăng ký thành công !";
                request.setAttribute("errorRegistry", errorRegistry);
                response.sendRedirect(request.getContextPath() + "/login");
            }else{
                response.sendRedirect(request.getContextPath()+"/Registry");
            }
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
