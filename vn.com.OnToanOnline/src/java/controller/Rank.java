/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Connections.ConnectionUtils;
import DAO.ThanhVienDAO;
import model.ThanhVien;
import model.Toan;
import java.io.IOException;
import java.sql.Connection;
import java.util.Collections;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DTO.ThanhVienImpl;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import utils.MyUtils;

/**
 *
 * @author TienNguyen
 */
@WebServlet(name = "BangXepHang", urlPatterns = {"/rank"})
public class Rank extends HttpServlet {

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
        //Kiểm tra người dùng đã đăng nhập chưa
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

        //Lấy danh sách
        List<Toan> lst = MyUtils.getStoredList(session);
        if (lst != null) {
            MyUtils.remoteStoreList(session);
        }
        Connection con = ConnectionUtils.getConnection();
        con = MyUtils.getStoredConnection(request);

        String tuKhoa = request.getParameter("tuKhoa");
        int[] xepHang = null;
        String errorString = null;
        List<ThanhVien> lstTV = new ArrayList();
        List<ThanhVien> lst13 = new ArrayList();
        try {
            if (tuKhoa != null) {
                lstTV = thanhVienImpl.getFullListByName(con, tuKhoa);
                

            } else {
                lstTV = thanhVienImpl.getFullListThanhVien(con);

            }
            Collections.sort(lstTV);
            for(int i = 0 ; i < 13 ; i++){
                lst13.add(lstTV.get(i));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();

        }
        
        //Lấy thông tin TOP 1
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String nameTop1 = lst13.get(0).getHoTen();
        Date birthday = lst13.get(0).getNgaySinh();
        String strDate = df.format(birthday);
        String school = lst13.get(0).getTruongHoc();
        String soThich = lst13.get(0).getSoThich();
        String tinhCach = lst13.get(0).getTinhCach();
        int point = lst13.get(0).getPoint();
        String images = lst13.get(0).getImages();
        
        
        //Set Request Top 1
        request.setAttribute("nameTop1", nameTop1);
        request.setAttribute("birthday", strDate);
        request.setAttribute("school", school);
        request.setAttribute("soThich", soThich);
        request.setAttribute("tinhCach", tinhCach);
        request.setAttribute("point", point);
        request.setAttribute("images", images);
        //Lưu thông tin vào request
        request.setAttribute("xepHang", xepHang);
        request.setAttribute("errorString", errorString);
        request.setAttribute("tuKhoa", tuKhoa);
        request.setAttribute("rank", lstTV);

        //forward sang trang bảng xếp hạng
        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/views/rank/rank.jsp");
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
