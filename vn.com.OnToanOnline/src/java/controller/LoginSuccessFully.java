/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Connections.ConnectionUtils;
import DAO.ThanhVienDAO;
import DTO.ThanhVienImpl;
import com.mysql.jdbc.Blob;
import java.io.Console;
import model.ThanhVien;
import java.io.IOException;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
@WebServlet(name = "LoginSuccessFully", urlPatterns = {"/loginSuccess"})
public class LoginSuccessFully extends HttpServlet {

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
        //lấy thông tin người dùng trong session
       String tacVu = null;
        String login = "", contact = "", present = "",registry = "",info1 = "",info2 ="";
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
            
            response.sendRedirect(request.getServletPath()+"/home");
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
        
        //Get list
        String errorList = "";
        List<ThanhVien> lstTop10 = new ArrayList();

        try {
            Connection con = ConnectionUtils.getConnection();
            con = MyUtils.getStoredConnection(request);
            List<ThanhVien> lstX = thanhVienImpl.getFullListThanhVien(con);
            Collections.sort(lstX);
            for (int i = 0; i < 10; i++) {
                lstTop10.add(lstX.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
            errorList = "Can't get List Student";
        }
        //Lấy thông tin TOP 1
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String images = lstTop10.get(0).getImages();
        String nameTop1 = lstTop10.get(0).getHoTen();
        Date birthday = lstTop10.get(0).getNgaySinh();
        String strDate = df.format(birthday);
        String school = lstTop10.get(0).getTruongHoc();
        String soThich = lstTop10.get(0).getSoThich();
        String tinhCach = lstTop10.get(0).getTinhCach();
        int point = lstTop10.get(0).getPoint();
        
        
        
        //Set Request Top 1
        request.setAttribute("nameTop1", nameTop1);
        request.setAttribute("birthday", strDate);
        request.setAttribute("school", school);
        request.setAttribute("soThich", soThich);
        request.setAttribute("tinhCach", tinhCach);
        request.setAttribute("point", point);
        request.setAttribute("images", images);
        //Set request global
        request.setAttribute("lst", lstTop10);
        request.setAttribute("errorList", errorList);

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/views/home.jsp");
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
