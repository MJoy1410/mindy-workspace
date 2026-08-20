package pe.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.dao.UserDAO;
import pe.dto.UserDTO;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private static final String LOGIN_VIEW = "/WEB-INF/views/login.jsp";
    private static final String BLOCKED_VIEW = "/WEB-INF/views/blocked.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("LOGIN_USER") != null) {
            response.sendRedirect(request.getContextPath() + "/MainController?action=Welcome");
            return;
        }
        request.getRequestDispatcher(LOGIN_VIEW).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = trim(request.getParameter("username"));
        String password = trim(request.getParameter("password"));

        request.setAttribute("USERNAME", username);

        if (username.isEmpty() || password.isEmpty()) {
            request.setAttribute("ERROR", "Username and password are required.");
            request.getRequestDispatcher(LOGIN_VIEW).forward(request, response);
            return;
        }

        try {
            UserDTO user = new UserDAO().checkLogin(username, password);

            if (user == null) {
                request.setAttribute("ERROR", "Invalid username or password.");
                request.getRequestDispatcher(LOGIN_VIEW).forward(request, response);
                return;
            }

            if (!user.isInUse()) {
                request.setAttribute("BLOCKED_USER", user);
                request.getRequestDispatcher(BLOCKED_VIEW).forward(request, response);
                return;
            }

            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }

            HttpSession session = request.getSession(true);
            session.setAttribute("LOGIN_USER", user);

            response.sendRedirect(request.getContextPath() + "/MainController?action=Welcome");
        } catch (Exception e) {
            log("Login error", e);
            request.setAttribute("ERROR", "System error. Please check the database connection and try again.");
            request.getRequestDispatcher(LOGIN_VIEW).forward(request, response);
        }
    }

    private String trim(String value) {
        return value == null ? "" : value.trim();
    }
}
