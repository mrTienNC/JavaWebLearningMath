/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminController;

import DAO.ToanDAO;
import DTO.ToanImplements;
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
import model.Toan;
import model.UserAdmin;
import utils.MyUtils;

/**
 *
 * @author TienNguyen
 */
@WebServlet(name = "AdminFormAdvanced",
        urlPatterns = {
            "/AdminTableQuestion1",
            "/AdminTableQuestion2",
            "/AdminTableQuestion3",
            "/AdminTableQuestion4",
            "/AdminTableQuestion5",
            "/AdminTableQuestion6"
        })
public class Admin_Form_Question extends HttpServlet {

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
            RequestDispatcher dispatcher =
                    request.getServletContext().getRequestDispatcher("/views/admin/admin-login.jsp");
            dispatcher.forward(request, response);
        }
        String images = user.getImages();
        request.setAttribute("images", images);

        //Get list question 
        String errorList = "";
        List<Toan> lstToan = new ArrayList();
        String urlPattern = request.getServletPath();
        try {
            Connection con = MyUtils.getStoredConnection(request);
            switch (urlPattern) {
                case "/AdminTableQuestion1":
                    lstToan = toanImpl.getFullListToan1(con);
                    break;
                case "/AdminTableQuestion2":
                    lstToan = toanImpl.getFullListToan2(con);
                    break;
                case "/AdminTableQuestion3":
                    lstToan = toanImpl.getFullListToan3(con);
                    break;
                case "/AdminTableQuestion4":
                    lstToan = toanImpl.getFullListToan4(con);
                    break;
                case "/AdminTableQuestion5":
                    lstToan = toanImpl.getFullListToan5(con);
                    break;
                default:
                    errorList = "Can't get List Question !";
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        request.setAttribute("lstToan", lstToan);
        request.setAttribute("errorList", errorList);
        request.setAttribute("errorString", errorString);
        request.setAttribute("urlPattern", urlPattern);
        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/views/admin/table-data_question.jsp");
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
        
        String errorString = "";
        //Check Add new item
        
        String content = request.getParameter("content");
        String contentA = request.getParameter("contentA");
        String contentB = request.getParameter("contentB");
        String contentC = request.getParameter("contentC");
        String contentD = request.getParameter("contentD");
        String keyAnswer = request.getParameter("key");

        String urlPattern = request.getServletPath();
        boolean KQ = false;
        if (content.equals("") || contentA.equals("") || contentB.equals("")
                || contentC.equals("") || contentD.equals("") || keyAnswer.equals("")) {
            errorString = "Fill fully the form";
            
            response.sendRedirect(request.getContextPath()+urlPattern);
        } else {
            try {
                int key = Integer.parseInt(keyAnswer);
                Connection con = MyUtils.getStoredConnection(request);

                Toan objToan
                        = new Toan(content, contentA, contentB, contentC, contentD, key);

                switch (urlPattern) {
                    case "/AdminTableQuestion1":
                        KQ = toanImpl.addNewItemToan1(con, objToan);
                        break;
                    case "/AdminTableQuestion2":
                        KQ = toanImpl.addNewItemToan2(con, objToan);
                        break;
                    case "/AdminTableQuestion3":
                       KQ = toanImpl.addNewItemToan3(con, objToan);
                        break;
                    case "/AdminTableQuestion4":
                        KQ = toanImpl.addNewItemToan4(con, objToan);
                        break;
                    case "/AdminTableQuestion5":
                        KQ = toanImpl.addNewItemToan5(con, objToan);
                        break;
                    default:
                        errorString = "Can't add new Question !";
                }
            } catch (Exception e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("urlPattern", urlPattern);
        if(KQ){
            response.sendRedirect(request.getContextPath()+urlPattern);
        }else{
            response.sendRedirect(request.getContextPath()+urlPattern);
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
