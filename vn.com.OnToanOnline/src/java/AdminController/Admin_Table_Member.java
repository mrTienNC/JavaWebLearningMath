/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminController;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UserAdmin;
import utils.MyUtils;

/**
 *
 * @author TienNguyen
 */
@WebServlet(name = "Admin_Table_Member", urlPatterns = {"/AdminTableMember"})
public class Admin_Table_Member extends HttpServlet {

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

        //Get infomation on HttpSession
        //Kiểm tra thông tin trong session
        HttpSession session = request.getSession();
        UserAdmin user = MyUtils.getStoreUserLogin(session);

        String logined = null;
        String errorString = null;

        if (user == null) {
            logined = "Đăng Nhập";
            errorString = "Chưa đăng nhập !";
            //lưu attribute
            request.setAttribute("errorString", errorString);
            request.setAttribute("logined", logined);
            //forward về trang đăng nhập
            RequestDispatcher dispatcher
                    = request.getServletContext().getRequestDispatcher("/views/admin/admin-login.jsp");

            dispatcher.forward(request, response);
        } 
        
        logined = user.getUserName();
        String images = user.getImages();
        request.setAttribute("logined", logined);
        request.setAttribute("images", images);
        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/views/admin/table-data-members.jsp");
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
        doPost(request, response);
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
