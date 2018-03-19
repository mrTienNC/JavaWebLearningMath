/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminController;

import DAO.UserAdminDAO;
import DTO.UserAdminImpl;
import java.io.IOException;
import java.sql.Connection;
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
@WebServlet(name = "Admin_Login", urlPatterns = {"/AdminLogin"})
public class Admin_Login extends HttpServlet {

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

        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/views/admin/admin-login.jsp");
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

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean checkbox = request.getParameter("checkbox") != null;
       

        Connection con = MyUtils.getStoredConnection(request);
        UserAdmin user = null;

        String errorString = "";
        boolean check = false;
        if (username.equals("") || password.equals("")) {
            errorString = "Fill full information";
            check = true;
        } else {
            try {
                user = userImpl.findUserAccount(con, username, password);
            } catch (Exception e) {
                e.printStackTrace();
                check = true;
                errorString = e.getMessage();
            }
        }

        //If has Error
        if (check) {
            user = new UserAdmin();
            user.setUserName(username);
            user.setPassword(password);

            //Lưu các thông tin vào request attribute
            request.setAttribute("errorString", errorString);
            request.setAttribute("user", user);

            //forward tới trang login.jsp
            RequestDispatcher dispatcher
                    = this.getServletContext().getRequestDispatcher("/views/admin/login-admin.jsp");
            dispatcher.forward(request, response);
        }//if non-error
        else {
            HttpSession session = request.getSession();
            MyUtils.storeUserLogin(session, user);
            if (checkbox) {
                MyUtils.storeUserCookie(response, user);
            }
            response.sendRedirect(request.getContextPath()+"/Admin");
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
