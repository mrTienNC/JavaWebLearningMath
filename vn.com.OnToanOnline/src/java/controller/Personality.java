/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ThanhVienDAO;
import DTO.ThanhVienImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
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
@WebServlet(name = "Personality", urlPatterns = {"/Personal"})
public class Personality extends HttpServlet {

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
        //Kiểm tra thông tin trong session
        String tacVu = null;
        String login = "", contact = "", present = "", registry = "", info1 = "", info2 = "";
        String loginHref = "", contactHref = "", presentHref = "", registryHref = "";
        String errorString = "";

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

            errorString = "Chưa đăng nhập ";

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

            // Lấy thông tin Đăng nhập trong session
            int id = user.getId();
            request.setAttribute("id", id);
            String fullName = user.getHoTen();
            request.setAttribute("fullName", fullName);
            String school = user.getTruongHoc();
            request.setAttribute("school", school);
            String address = user.getAddress();
            request.setAttribute("address", address);
            String character = user.getTinhCach();
            request.setAttribute("character", character);
            String hobbies = user.getSoThich();
            request.setAttribute("hobbies", hobbies);
            String phone = user.getPhone();
            request.setAttribute("phone", phone);
            String email = user.getEmail();
            request.setAttribute("email", email);
            String sex = user.getGioiTinh();
            String checkNam = "", checkNu = "";
            String images = user.getImages();
            request.setAttribute("images", images);
            if (sex.equals("Nam")) {
                checkNam = "checked";
                checkNu = "unchecked";
            } else {
                checkNu = "checked";
                checkNam = "unchecked";
            }
            request.setAttribute("checkNam", checkNam);
            request.setAttribute("checkNu", checkNu);
            Date birthday = user.getNgaySinh();
            request.setAttribute("birthday", birthday);

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

        if (errorString.equals("")) {
            RequestDispatcher dispatcher
                    = request.getServletContext().getRequestDispatcher("/views/person/personal.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
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
        request.setCharacterEncoding("utf-8");
        //Lấy thông tin trên session
        HttpSession session = request.getSession();
        ThanhVien tv = (ThanhVien) MyUtils.getStoredMemberLogin(session);

        String errorUpdate = "";
        //Lấy thông tin người dùng cập nhật
        String fullName = request.getParameter("fullName");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        String school = request.getParameter("school");
        String address = request.getParameter("address");
        String character = request.getParameter("character");
        String hobbies = request.getParameter("hobbies");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String file = request.getParameter("base64");
        //Thực hiện Update Thông tin
        Connection con = MyUtils.getStoredConnection(request);

        String imageBase64 = "";

        boolean KT = false;
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
            java.sql.Date dateNS = new java.sql.Date(date.getTime());

            if (file.equals("")) {
                tv = new ThanhVien(tv.getId(), fullName, sex, dateNS, school, tv.getPoint(),
                        tv.getUserName(), tv.getPassword(), character, hobbies, tv.getImages(), email,
                        phone, address, tv.getType(), tv.getLogged());

                KT = thanhVienImpl.updateThanhVien(con, tv);
            }else{
                
                tv = new ThanhVien(tv.getId(), fullName, sex, dateNS, school, tv.getPoint(),
                        tv.getUserName(), tv.getPassword(), character, hobbies, file, email,
                        phone, address, tv.getType(), tv.getLogged());

                KT = thanhVienImpl.updateThanhVien(con, tv);
            }
            if (KT == true) {
                errorUpdate = "Update thành công !";

            } else {
                errorUpdate = "Update thất bại !";
            }
            request.setAttribute("errorUpdate", errorUpdate);
        } catch (Exception e) {
            e.printStackTrace();
//            errorUpdate = e.getMessage();
        }
        if (KT == false) {
            RequestDispatcher dispatcher
                    = request.getServletContext().getRequestDispatcher("/views/person/personal.jsp");
            dispatcher.forward(request, response);
        } else {
            session = request.getSession();
            MyUtils.storeMemberLogin(session, tv);
            response.sendRedirect(request.getContextPath() + "/Personal");
        }

    }

    //Encode Image to Base64
    private String encodeImageToBase64(File file) {
        //Get url file image
        String imageDataString = "";
        //read file image from file system
        try {
            FileInputStream fileInput = new FileInputStream(file);
            byte[] imageData = new byte[(int) file.length()];

            fileInput.read(imageData);

            //Convert Image byte to Base64 String
            imageDataString = Base64.getEncoder().encodeToString(imageData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imageDataString;
    }
    //Encode Base64 to Image String file
//    private String decodeBase64toImage(String base64,String path){
//        try(FileOutputStream imageOutputFile = new FileOutputStream(path)){
//            //Convert Base64 to Array
//            byte[] imageData = Base64.getDecoder().decode(base64);
//            imageOutputFile.write(imageData);
//            
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        
//    }

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
