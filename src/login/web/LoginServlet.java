
package login.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import login.dao.UserInformationDAO;

/**
 * @author Omura
 * とりあえずテスト
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
        } catch (Exception e) {
            throw new ServletException(e);
        }

        if (result) {
            // クエリ結果が存在すればログイン成功とする
            session.setAttribute("login","true");

            // テスト用
            req.setAttribute("test","ログイン成功");
        } else {
            // テスト用
            req.setAttribute("test","ログイン失敗");
        }

        // ログイン完了画面へ
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/login.jsp");
        rd.forward(req,rsp);
    }
}