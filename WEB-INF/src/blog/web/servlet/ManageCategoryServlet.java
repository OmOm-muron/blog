package blog.web.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import blog.web.util.SidebarUtil;

/**
 *カテゴリ管理ページへ遷移するServlet
 */
public class ManageCategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        
        try {
            // aサイドバーの情報を付加
            SidebarUtil.setLatestFiveArticles(req);
            SidebarUtil.setTopFiveCategories(req);
        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher rd = req.getRequestDispatcher("/jsp/error.jsp");
            rd.forward(req, rsp);
            return;
        }
        
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/manage-category.jsp");
        rd.forward(req, rsp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        doGet(req, rsp);
    }
}
