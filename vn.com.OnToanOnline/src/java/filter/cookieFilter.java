/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import DAO.UserAdminDAO;
import model.UserAdmin;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import DTO.UserAdminImpl;
import utils.MyUtils;

/**
 *
 * @author TienNguyen
 */
@WebFilter(filterName = "cookieFilter" , urlPatterns = {"/*"})
public class cookieFilter implements Filter{
    UserAdminDAO userAdminImpl = new UserAdminImpl();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        
        HttpSession session = req.getSession();
        
        UserAdmin userInSession = MyUtils.getStoreUserLogin(session);
        
        if(userInSession != null)
        {
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
            
            chain.doFilter(request, response);
            return;
        }
        //Lấy connection
        Connection con = MyUtils.getStoredConnection(request);
        //Kiểm tra cookie
        String checked = (String) session.getAttribute("COOKIE_CHECKED");
        if(checked == null && con != null)
        {
            String userName = MyUtils.getStoredUser(req);
            try
            {
                UserAdmin user = userAdminImpl.findUserAccount(con, userName);
                
                MyUtils.storeUserLogin(session, user);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            //đánh dấu đã kiểm tra cookie
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
