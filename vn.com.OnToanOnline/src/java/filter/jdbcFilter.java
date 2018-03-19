/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;


import Connections.ConnectionUtils;
import java.io.IOException;
import java.sql.Connection;
import java.util.Collection;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import utils.MyUtils;

/**
 *
 * @author TienNguyen
 */
@WebFilter(filterName = "jdbcFilter", urlPatterns = {"/*"})
public class jdbcFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Hàm kiểm tra request tới vị trí nào
     *
     * @param request
     * @return
     */
    private boolean needJDBC(HttpServletRequest request) {
        System.out.println("JDBC FIlter");
        //lấy servlet path
        String servletPath = request.getServletPath();

        String pathInfo = request.getPathInfo();

        String urlPattern = servletPath;

        if (pathInfo != null) {
            urlPattern = servletPath + "/*";
        }
        //Lấy servletName, value : ServletRegistration
        Map<String, ? extends ServletRegistration> servletRegistration = request.getServletContext().getServletRegistrations();

        //tập hợp tất cả cá servletREgis
        Collection<? extends ServletRegistration> value = servletRegistration.values();

        for (ServletRegistration sr : value) {
            Collection<String> mapping = sr.getMappings();
            if (mapping.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //Lấy httpServletRequest
        HttpServletRequest req = (HttpServletRequest) request;
        if (this.needJDBC(req)) {
            System.out.println("Open JDBC for : " + req);

            Connection con = null;

            try {
                con = ConnectionUtils.getConnection();
                //set auto commit false
                con.setAutoCommit(false);
                //lưu trữ con
                MyUtils.storeConnection(request, con);
                
                //đi tiếp sang trang focus
                chain.doFilter(request, response);
                //set commit
                con.commit();

            } catch (Exception e) {
                e.printStackTrace();
                ConnectionUtils.rollbackDB(con);
                throw new ServletException();
            }finally
            {
                ConnectionUtils.closeDB(con);
            }
        }else
        {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
