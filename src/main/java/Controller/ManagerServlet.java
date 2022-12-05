package Controller;

import DAO.NewsDAO;
import DAO.UserDAO;
import Model.News;
import Model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ManagerServlet", value = "/managers")
public class ManagerServlet extends HttpServlet {
    private NewsDAO newsDAO = new NewsDAO();
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "all_list_news":
                    showAllUserForm(request, response);
                    listUser(request, response);
                    break;
                case "all_list_user":
                    showAllNewsForm(request, response);
                    listNews(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }


    private void showAllUserForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("all_list_user.jsp");
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<User> listUser = userDAO.findAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("all_list_user.jsp");
        request.setAttribute("listUser", listUser);
        dispatcher.forward(request, response);
    }
    private void showAllNewsForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("all_list_news.jsp");
    }

    private void listNews(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<News> listNews = newsDAO.selectAllNews();
        RequestDispatcher dispatcher = request.getRequestDispatcher("all_list_news.jsp");
        request.setAttribute("listNews", listNews);
        dispatcher.forward(request, response);
    }

}
