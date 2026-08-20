package pe.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * MVC2 Front Controller. This servlet only decides which action controller
 * should process the request. Business/database logic is not placed here.
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private static final String LOGIN_CONTROLLER = "/LoginController";
    private static final String LOGOUT_CONTROLLER = "/LogoutController";
    private static final String SEARCH_CONTROLLER = "/SearchController";
    private static final String WELCOME_CONTROLLER = "/WelcomeController";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        String url;

        if (action == null || action.trim().isEmpty()) {
            url = LOGIN_CONTROLLER;
        } else {
            switch (action) {
                case "Login":
                    url = LOGIN_CONTROLLER;
                    break;
                case "Logout":
                    url = LOGOUT_CONTROLLER;
                    break;
                case "Search":
                    url = SEARCH_CONTROLLER;
                    break;
                case "Welcome":
                    url = WELCOME_CONTROLLER;
                    break;
                default:
                    url = LOGIN_CONTROLLER;
                    break;
            }
        }

        request.getRequestDispatcher(url).forward(request, response);
    }
}
