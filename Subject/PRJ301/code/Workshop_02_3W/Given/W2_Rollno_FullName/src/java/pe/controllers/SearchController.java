package pe.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.dao.MobileDAO;
import pe.dto.MobileDTO;

@WebServlet(name = "SearchController", urlPatterns = {"/SearchController"})
public class SearchController extends HttpServlet {

    private static final String SEARCH_VIEW = "/WEB-INF/views/search.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        search(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        search(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String keywordParam = request.getParameter("keyword");
        String keyword = trim(keywordParam);
        String sort = "DESC".equalsIgnoreCase(request.getParameter("sort")) ? "DESC" : "ASC";

        request.setAttribute("KEYWORD", keyword);
        request.setAttribute("SORT", sort);

        // Opening the Search page or submitting an empty keyword must not show results.
        if (keywordParam == null || keyword.isEmpty()) {
            request.getRequestDispatcher(SEARCH_VIEW).forward(request, response);
            return;
        }

        try {
            List<MobileDTO> mobiles = new MobileDAO().searchByName(keyword, sort);
            if (mobiles.isEmpty()) {
                request.setAttribute("SEARCH_ERROR", "No data matching the search criteria found !");
            } else {
                request.setAttribute("MOBILE_LIST", mobiles);
            }
            request.getRequestDispatcher(SEARCH_VIEW).forward(request, response);
        } catch (Exception e) {
            log("Search error", e);
            request.setAttribute("SEARCH_ERROR", "System error. Please check the database connection and try again.");
            request.getRequestDispatcher(SEARCH_VIEW).forward(request, response);
        }
    }

    private String trim(String value) {
        return value == null ? "" : value.trim();
    }
}
