
package login.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.web.util.SidebarUtil;
import login.dao.UserInformationDAO;

/**
 * ログインページへ遷移するServlet
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/login.jsp");
        rd.forward(req, rsp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        // セッション取得
        HttpSession session = req.getSession(true);

        // 画面の入力値を取得
        String userid = req.getParameter("userid");
        String password = req.getParameter("password");

        boolean result;

        // ログイン判定
        try (UserInformationDAO dao = new UserInformationDAO()) {
            result = dao.existsUser(userid, password);
            // ついでにサイドバーの情報を付加
            SidebarUtil.setLatestFiveArticles(req);
            SidebarUtil.setTopFiveCategories(req);
        } catch (Exception e) {
            throw new ServletException(e);
        }

        if (result) {
            // クエリ結果が存在すればログイン成功とする
            session.setAttribute("login","true");
            req.setAttribute("message","ログインしました。");
        } else {
            req.setAttribute("message","ユーザー情報に誤りがあります。");
        }

        // ログイン完了画面へ
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/complete.jsp");
        rd.forward(req, rsp);
    }
}