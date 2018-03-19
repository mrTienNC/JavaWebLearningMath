/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminController;

import DAO.ContactDAO;
import DAO.ThanhVienDAO;
import DAO.ToanDAO;
import DTO.ContactImpl;
import DTO.ThanhVienImpl;
import DTO.ToanImplements;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Contact;
import model.ThanhVien;
import model.Toan;
import model.UserAdmin;
import utils.MyUtils;

/**
 *
 * @author TienNguyen
 */
@WebServlet(name = "Admin", urlPatterns = {"/Admin","/admin"})
public class Admin extends HttpServlet {

    ContactDAO contactImpl = new ContactImpl();
    ThanhVienDAO thanhVienImpl = new ThanhVienImpl();
    ToanDAO toanImpl = new ToanImplements();
    
  

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
        
        logined = user.getFullname();
        String images = user.getImages();
        request.setAttribute("images", images);
        request.setAttribute("logined", logined);
        
        Connection con = MyUtils.getStoredConnection(request);
        //Get information about ListMember, List Contact,.....
        
        //Information about Login Member
        List<ThanhVien> lstThanhVien = thanhVienImpl.getFullListThanhVien(con);
        int logged = 0;
        for(int i = 0 ; i < lstThanhVien.size();i++){
            if(lstThanhVien.get(i).getLogged().equalsIgnoreCase("logged")){
                logged++;
            }
        }
        
        //Information about User's Contact Sent
        List<Contact> lstContact = contactImpl.getFullListContact(con);
        //Number of Question
        List<Toan> lstToan1 = toanImpl.getFullListToan1(con);
        List<Toan> lstToan2 = toanImpl.getFullListToan2(con);
        List<Toan> lstToan3 = toanImpl.getFullListToan3(con);
        List<Toan> lstToan4 = toanImpl.getFullListToan4(con);
        List<Toan> lstToan5 = toanImpl.getFullListToan5(con);
        int total = lstToan1.size() + lstToan2.size() + lstToan3.size() 
                + lstToan4.size() + lstToan5.size();
        //Set Attribute something about List
        request.setAttribute("lstTvSize", lstThanhVien.size());
        request.setAttribute("online", logged);
        request.setAttribute("lstContactSize", lstContact.size());
        request.setAttribute("totalMath", total);
        RequestDispatcher dispatcher = 
                request.getServletContext().getRequestDispatcher("/views/admin/index.jsp");
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
