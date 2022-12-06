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
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "deleteNews":
                    deleteNewByID(request, response);
                    break;
                case "contentByID":
                    contentByID(request, response);
                    break;
                default:
                    listNews(request, response);
                    break;
            }
        }catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "all_list_news":
                showAllNewsForm(request, response);
                break;
            case "all_list_user":
                showAllUserForm(request, response);
                break;
        }
    }


    private void showAllUserForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("all_list_user.jsp");
    }

    public void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<User> listUser = userDAO.findAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("all_list_user.jsp");
        request.setAttribute("listUser", listUser);
        dispatcher.forward(request, response);
    }

    public void showAllNewsForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<News> listNews = newsDAO.selectAllNews();
        request.setAttribute("listNews", listNews);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin_manager/all_list_news.jsp");
        dispatcher.forward(request, response);
    }

    public void listNews(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<News> listNews = newsDAO.selectAllNews();
        RequestDispatcher dispatcher = request.getRequestDispatcher("all_list_news.jsp");
        request.setAttribute("listNews", listNews);
        dispatcher.forward(request, response);
    }

    public void contentByID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idNews = Integer.parseInt(request.getParameter("idNews"));
        request.setAttribute("newById", newsDAO.selectNews(idNews));
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin_manager/content_news_byID_manager.jsp");
        dispatcher.forward(request, response);
    }

    public void deleteNewByID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int idNews = Integer.parseInt(request.getParameter("idNews"));
        newsDAO.deleteNews(idNews);
        List<News> listNews=newsDAO.selectAllNews();
        request.setAttribute("listNews",listNews);
        RequestDispatcher dispatcher=request.getRequestDispatcher("admin_manager/all_list_news.jsp");
        dispatcher.forward(request,response);
    }

}
