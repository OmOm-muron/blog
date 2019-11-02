package blog.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *カテゴリ削除ページへ遷移するServlet
 */
public class DeleteCategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest ex_req, HttpServletResponse ex_rsp) throws ServletException, IOException {
        ex_req.setCharacterEncoding("UTF-8");
        RequestDispatcher in_rd = ex_req.getRequestDispatcher("/jsp/delete-category.jsp");
        in_rd.forward(ex_req, ex_rsp);
    }

    protected void doPost(HttpServletRequest ex_req, HttpServletResponse ex_rsp) throws ServletException, IOException {
        doGet(ex_req, ex_rsp);
    }
}