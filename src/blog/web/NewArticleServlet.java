package blog.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * @author Omura
 * とりあえずテスト
 */
public class NewArticleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/new-article.jsp");
        rd.forward(req, rsp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
          doGet(req, rsp);
    }
}

