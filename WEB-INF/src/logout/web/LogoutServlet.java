
package logout.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *ログアウト処理、ログアウト後画面へ遷移するServlet
 */
public class LogoutServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest ex_req, HttpServletResponse ex_rsp) throws ServletException, IOException {
    ex_req.setCharacterEncoding("UTF-8");

    // iセッションのログイン情報を削除
    HttpSession in_session = ex_req.getSession(true);
    in_session.removeAttribute("login");

    RequestDispatcher in_rd = ex_req.getRequestDispatcher("/jsp/logout.jsp");
    in_rd.forward(ex_req, ex_rsp);
  }

  protected void doPost(HttpServletRequest ex_req, HttpServletResponse ex_rsp) throws ServletException, IOException {
    doGet(ex_req, ex_rsp);
  }
}