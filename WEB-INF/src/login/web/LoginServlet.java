
package login.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import login.dao.UserInformationDAO;

/**
 * ログインページへ遷移するServlet
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest ex_req, HttpServletResponse ex_rsp) throws ServletException, IOException {
        ex_req.setCharacterEncoding("UTF-8");
        RequestDispatcher in_rd = ex_req.getRequestDispatcher("/jsp/login.jsp");
        in_rd.forward(ex_req, ex_rsp);
    }

    protected void doPost(HttpServletRequest ex_req, HttpServletResponse ex_rsp) throws ServletException, IOException {
        ex_req.setCharacterEncoding("UTF-8");

        // iセッション取得
        HttpSession in_session = ex_req.getSession(true);

        // i画面の入力値を取得
        String in_userid = ex_req.getParameter("userid");
        String in_password = ex_req.getParameter("password");

        boolean in_result;

        // iログイン判定
        try (UserInformationDAO in_dao = new UserInformationDAO()) {
            in_result = in_dao.existsUser(in_userid, in_password);
        } catch (Exception e) {
            throw new ServletException(e);
        }

        if (in_result) {
            // iクエリ結果が存在すればログイン成功とする
            in_session.setAttribute("login","true");

            // test
            ex_req.setAttribute("test","���O�C������");
        } else {
            // test
            ex_req.setAttribute("test","���O�C�����s");
        }

        // iログイン完了画面へ(要編集)
        RequestDispatcher in_rd = ex_req.getRequestDispatcher("/jsp/login.jsp");
        in_rd.forward(ex_req,ex_rsp);
    }
}