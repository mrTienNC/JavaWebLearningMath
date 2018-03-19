/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ThanhVienDAO;
import DAO.ToanDAO;
import model.ThanhVien;
import model.Toan;
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
import DTO.ThanhVienImpl;
import DTO.ToanImplements;
import utils.MyUtils;

/**
 *
 * @author TienNguyen
 */
@WebServlet(name = "ToanLop1Servlet",
        urlPatterns = {"/lop1",
             "/lop2", "/lop3", "/lop4", "/lop5"})
public class ToanServlet extends HttpServlet {

    private ToanDAO toanImpl = new ToanImplements();
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

        //Lấy thông tin người dùng yêu cầu
        request.setCharacterEncoding("UTF-8");
        String tacVu = null;
        String login = "", contact = "", present = "", registry = "", info1 = "", info2 = "";
        String loginHref = "", contactHref = "", presentHref = "", registryHref = "";
        HttpSession session = request.getSession();

        boolean DN = false;
        String title = "Toán Lớp 1";
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
            DN = false;

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
            DN = true;
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

        //Lấy danh sách câu hỏi
        String errorString = null;
        boolean isTrue = false;
        List<Toan> lstToan = null;
        List<Toan> lstX = new ArrayList();

        String urlPattern = request.getServletPath();
        //Nếu người dùng đã đăng nhập
        if (DN == true) {

            Connection con = MyUtils.getStoredConnection(request);
            //kiểm tra người dùng chọn toán nào

            try {

                switch (urlPattern) {
                    case "/lop1":
                        lstToan = toanImpl.getFullListToan1(con);
                        lstToan = toanImpl.randomListToan(lstToan);
                        break;
                    case "/lop2":
                        lstToan = toanImpl.getFullListToan2(con);
                        lstToan = toanImpl.randomListToan(lstToan);
                        break;
                    case "/lop3":
                        lstToan = toanImpl.getFullListToan3(con);
                        lstToan = toanImpl.randomListToan(lstToan);
                        break;
                    case "/lop4":
                        lstToan = toanImpl.getFullListToan4(con);
                        lstToan = toanImpl.randomListToan(lstToan);
                        break;
                    case "/lop5":
                        lstToan = toanImpl.getFullListToan5(con);
                        lstToan = toanImpl.randomListToan(lstToan);
                        break;
                    default :
                        errorString = "cant get List";
                }

                for (int i = 0; i < 10; i++) {
                    lstX.add(lstToan.get(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
            request.setAttribute("title", title);
            request.setAttribute("errorString", errorString);
            request.setAttribute("lstToan", lstX);
            //Lưu trữ List
            MyUtils.storedList(session, lstX);

            RequestDispatcher dispatcher
                    = this.getServletContext().getRequestDispatcher("/views/ontap/BaiThi.jsp");
            dispatcher.forward(request, response);
        }//Nếu người dùng chưa đăng nhập
        else {
            errorString = "Chưa đăng nhập !";
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher
                    = request.getServletContext().getRequestDispatcher("/views/login/login_1.jsp");
            dispatcher.forward(request, response);
        }

//        MyUtils.storeList(request, lstX);
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

        //Lấy thông tin và kiểm tra các đối số
        Connection con = MyUtils.getStoredConnection(request);
        String errorString = null;
        String[] answer = new String[10];

        HttpSession session = request.getSession();
        ThanhVien objTV = MyUtils.getStoredMemberLogin(session);
        String logined = objTV.getUserName();
        List<Toan> lstX = MyUtils.getStoredList(session);
        //Kiểm tra và tính điểm
        int oldPoint = objTV.getPoint();
        int newPoint = 0;
        int dem = 0;

        try {
            for (int i = 0; i < lstX.size(); i++) {
                answer[i] = request.getParameter("da" + lstX.get(i).getID());
                int ID_Correct = Integer.parseInt(answer[i]);
                if (ID_Correct == lstX.get(i).getID_Correct()) {
                    newPoint += 10;
                    dem++;
                }
                System.out.println(answer[i]);
            }
        } catch (Exception e) {
            System.out.println("Lỗi parse : " + e.getMessage());
        }
        //Cập nhật điểm obj
        int point = oldPoint + newPoint;
        int id = objTV.getId();

        objTV = new ThanhVien(id, objTV.getHoTen(), objTV.getGioiTinh(),
                objTV.getNgaySinh(), objTV.getTruongHoc(), point,
                objTV.getUserName(), objTV.getPassword(), objTV.getTinhCach(),
                objTV.getSoThich(), objTV.getImages(), objTV.getEmail(),
                objTV.getPhone(), objTV.getAddress(), objTV.getType(), objTV.getLogged());
        thanhVienImpl.updatePoint(con, objTV);

        request.setAttribute("id", id);
        request.setAttribute("oldPoint", oldPoint);
        request.setAttribute("newPoint", newPoint);
        request.setAttribute("logined", logined);
        request.setAttribute("point", point);
        request.setAttribute("dem", dem);
        request.setAttribute("errorString", errorString);
        request.setAttribute("images", objTV.getImages());
        if (errorString == null) {
            MyUtils.storeMemberLogin(session, objTV);
            RequestDispatcher dispatcher
                    = this.getServletContext().getRequestDispatcher("/views/result/result.jsp");
            dispatcher.forward(request, response);

        } else {
            MyUtils.remoteStoreList(session);
            response.sendRedirect(request.getContextPath() + "/OnTap");

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
