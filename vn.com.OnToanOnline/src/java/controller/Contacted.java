/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Connections.ConnectionUtils;
import DAO.ContactDAO;
import DTO.ContactImpl;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Contact;
import model.ThanhVien;
import utils.MyUtils;

/**
 *
 * @author TienNguyen
 */
@WebServlet(name = "Contact", urlPatterns = {"/Contact"})
public class Contacted extends HttpServlet {
    ContactDAO contactImpl = new ContactImpl();
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

        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/views/contact/contact.jsp");
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
        String fullName = request.getParameter("fullName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String content = request.getParameter("content");
        
        boolean hasError = false;
        String errorString = "";
        String errorMessage = "";
        Connection con = ConnectionUtils.getConnection();
        try{
            con = MyUtils.getStoredConnection(request);
            
            Contact ct = new Contact(fullName, phone, email, content);
            hasError = contactImpl.addNewContact(con, ct);
            
            if(hasError == true){
                 errorMessage = "Gửi thành công !";
            }else{
                errorMessage = "Gửi thất bại !.";
            }
        }catch(Exception e){
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("errorMessage", errorMessage);
        if(errorString != null){
            RequestDispatcher dispatcher =
                    request.getServletContext().getRequestDispatcher("/views/contact/contact.jsp");
            dispatcher.forward(request, response);
            
        }else
        {
            if(hasError){
                response.sendRedirect(request.getContextPath()+"/Contact");
            }else{
                response.sendRedirect(request.getContextPath() +"/Contact");
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
