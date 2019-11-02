
package logout.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * @author Omura
 * ログアウト用サーブレット
 */
public class LogoutServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");

    // セッションのログイン情報を削除
    HttpSession session = req.getSession(true);
    session.removeAttribute("login");

    RequestDispatcher rd = req.getRequestDispatcher("/jsp/logout.jsp");
    rd.forward(req, rsp);
  }

  protected void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
    doGet(req, rsp);
  }
}