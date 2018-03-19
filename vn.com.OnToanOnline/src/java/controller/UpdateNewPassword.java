/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ThanhVienDAO;
import DTO.ThanhVienImpl;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ThanhVien;
import utils.MyUtils;

/**
 *
 * @author TienNguyen
 */
@WebServlet(name = "UpdateNewPassword", urlPatterns = {"/updatePassword"})
public class UpdateNewPassword extends HttpServlet {

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
        doPost(request, response);
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
        //Lấy thông tin trên session
        Connection con = MyUtils.getStoredConnection(request);
         String tacVu = null;
        String login = "", contact = "", present = "", registry = "", info1 = "", info2 = "";
        String loginHref = "", contactHref = "", presentHref = "", registryHref = "";
        HttpSession session = request.getSession();
        ThanhVien user = MyUtils.getStoredMemberLogin(session);
        
        String errorString = "";
        boolean KQ = false;
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
            
            
            errorString = "Chưa đăng nhập !";
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
        request.setAttribute("errorString", errorString);
        
        //Lấy user người nhập
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        
        String errorPass = "";
        KQ = oldPassword.equals(user.getPassword());
        if(KQ == false){
            errorPass = "Mật khẩu cũ không đúng !";
            request.setAttribute("errorPass", errorPass);
            RequestDispatcher dispatcher = 
                    request.getServletContext().getRequestDispatcher("/views/person/personal.jsp");
            dispatcher.forward(request, response);
        }else{
            user = new ThanhVien(user.getId(), user.getHoTen(), user.getGioiTinh(), user.getNgaySinh(), user.getTruongHoc(), user.getPoint(), user.getUserName(), newPassword, user.getTinhCach(), user.getSoThich(), user.getImages(), user.getEmail(), user.getPhone(), user.getAddress(), user.getType(), user.getLogged());
            
            
           thanhVienImpl.updateThanhVien(con, user);
           session = request.getSession();
           MyUtils.storeMemberLogin(session, user);
           response.sendRedirect(request.getContextPath()+"/Personal");
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
