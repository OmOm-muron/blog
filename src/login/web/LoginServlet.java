
package login.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import login.dao.UserInformationDAO;

/**
 * @author Omura
 * �Ƃ肠�����e�X�g
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

        // �Z�b�V�����擾
        HttpSession session = req.getSession(true);

        // ��ʂ̓��͒l���擾
        String userid = req.getParameter("userid");
        String password = req.getParameter("password");

        boolean result;

        // ���O�C������
        try (UserInformationDAO dao = new UserInformationDAO()) {
            result = dao.existsUser(userid, password);
        } catch (Exception e) {
            throw new ServletException(e);
        }

        if (result) {
            // �N�G�����ʂ����݂���΃��O�C�������Ƃ���
            session.setAttribute("login","true");

            // �e�X�g�p
            req.setAttribute("test","���O�C������");
        } else {
            // �e�X�g�p
            req.setAttribute("test","���O�C�����s");
        }

        // ���O�C��������ʂ�
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/login.jsp");
        rd.forward(req,rsp);
    }
}