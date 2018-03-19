/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminController;

import DAO.ContactDAO;
import DTO.ContactImpl;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Contact;
import model.UserAdmin;
import utils.MyUtils;

/**
 *
 * @author TienNguyen
 */
@WebServlet(name = "AdminTableListed", urlPatterns = {"/AdminTableListed"})
public class AdminTableListed extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        
        
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
        
        logined = user.getFullname();
        String images = user.getImages();
        request.setAttribute("logined", logined);
        request.setAttribute("images", images);
        String errorList = "";
        List<Contact> lstContact = new ArrayList();
        try{
            Connection con = MyUtils.getStoredConnection(request);
            
            lstContact = contactImpl.getFullListContact(con);
            
        }catch(Exception e){
            e.printStackTrace();
            errorList = e.getMessage();
        }
        request.setAttribute("lstContact", lstContact);
        request.setAttribute("errorList", errorList);
        RequestDispatcher dispatcher =
                request.getServletContext().getRequestDispatcher("/views/admin/table-basic.jsp");
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
