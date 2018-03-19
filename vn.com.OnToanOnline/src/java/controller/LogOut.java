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
@WebServlet(name = "LogOut", urlPatterns = {"/LogOut"})
public class LogOut extends HttpServlet {

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
        
        HttpSession session = request.getSession(false);
        
        ThanhVien user = MyUtils.getStoredMemberLogin(session);
        Connection con = MyUtils.getStoredConnection(request);
        if(session != null) {
            thanhVienImpl.UpdateLogged(con, user, "offline");
            session.invalidate();
            String tacVu = "Tác Vụ";
            String login = "Đăng Nhập", contact = "Liên Hệ", present = "Giới Thiệu";
            request.setAttribute("tacVu", tacVu);
            request.setAttribute("contact", contact);
            request.setAttribute("present", present);
            
            
            response.sendRedirect(request.getContextPath());
//            RequestDispatcher dispatcher = 
//                    request.getServletContext().getRequestDispatcher("/views/home.jsp");
//            dispatcher.forward(request, response);
        }
        
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
        doGet(request, response);
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
