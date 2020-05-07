
package logout.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.web.util.SidebarUtil;

/**
 *ログアウト処理、ログアウト後画面へ遷移するServlet
 */
public class LogoutServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");

    // iセッションのログイン情報を削除
    HttpSession session = req.getSession(true);
    session.removeAttribute("login");
    
    try {
        // サイドバーの情報を付加
        SidebarUtil.setLatestFiveArticles(req);
        SidebarUtil.setTopFiveCategories(req);
    } catch (Exception e) {
        throw new ServletException(e);
    }

    RequestDispatcher rd = req.getRequestDispatcher("/jsp/logout.jsp");
    rd.forward(req, rsp);
  }

  protected void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
    doGet(req, rsp);
  }
}