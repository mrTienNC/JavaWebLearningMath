/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ThanhVien;
import model.Toan;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.MyUtils;

/**
 *
 * @author TienNguyen
 */
@WebServlet(name = "ChonBaiThi", urlPatterns = {"/chonBaiThi"})
public class ChonBaiThi extends HttpServlet {

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
        HttpSession session = request.getSession();
        ThanhVien user = MyUtils.getStoredMemberLogin(session);
        
        List<Toan> lst = MyUtils.getStoredList(session);
        boolean kq = false;
        if (lst != null) {
            System.out.println("Có danh sách");
            for(Toan ls : lst){
                System.out.println(ls);
            }
            MyUtils.remoteStoreList(session);
            kq = true;
            System.out.println("Xóa list thành công : " + kq);
        }else{
            System.out.println("Không có danh sách !");
        }
        
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
                    = request.getServletContext().getRequestDispatcher("/views/login.jsp");

            dispatcher.forward(request, response);
        } else {

            logined = user.getUserName();
            request.setAttribute("logined", logined);
            RequestDispatcher dispatcher
                    = this.getServletContext().getRequestDispatcher("/views/baiThi.jsp");
            dispatcher.forward(request, response);
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
//        HttpSession session = request.getSession();
        
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
