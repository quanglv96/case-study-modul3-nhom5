package Controller;

import DAO.CategoryDAO;
import DAO.UserDAO;
import Model.News;
import DAO.NewsDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "NewsServlet", value = "/news")
public class NewsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NewsDAO newsDAO=new NewsDAO();
    private UserDAO userDAO=new UserDAO();
    private CategoryDAO categoryDAO=new CategoryDAO();

    public void init() {
        newsDAO = new NewsDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create_news":
                    showCreatNewsForm(request, response);
                    break;
                case "edit_news":
                    showEditNewsForm(request, response);
                    break;
                case "delete_news":
                    deleteNews(request, response);
                    break;
                default:
                    listNews(request, response);
                    break;
            }
        } catch (SQLException ex) {
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
        try {
            switch (action) {

                case "create_news":
                    insertNews(request, response);
                    break;
                    case "edit_news":
                    updateNews(request, response);
                    break;
                default:
                    listNews(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listNews(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<News> listNews = newsDAO.selectAllNews();
        RequestDispatcher dispatcher = request.getRequestDispatcher("list_news.jsp");
        request.setAttribute("listNews", listNews);
        dispatcher.forward(request, response);
    }

    private void showCreatNewsForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUser= Integer.parseInt(request.getParameter("idUser"));
        request.setAttribute("idLogin",idUser);
        response.sendRedirect("create_news.jsp");
    }

    private void insertNews(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int idCategory = Integer.parseInt(request.getParameter("id_category"));
        String tileNews = request.getParameter("tile_news");
        String content = request.getParameter("content");
        Date dateNews = new Date(); // gọi thời gian hện tại của hệ thống
        int idUser = Integer.parseInt(request.getParameter("id_user"));
        int statusNews = Integer.parseInt(request.getParameter("status_news"));
        String img = request.getParameter("img");
        News newNews = new News(categoryDAO.findCategoryById(idCategory), tileNews, content, dateNews, userDAO.findUserById(idUser), statusNews, img);
        newsDAO.insertNews(newNews);
        response.sendRedirect("/news");
    }

    private void showEditNewsForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int idNews = Integer.parseInt(request.getParameter("id_news"));
        News existingUser = newsDAO.selectNews(idNews);
        request.setAttribute("news", existingUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit_news.jsp");
        dispatcher.forward(request, response);

    }

    private void updateNews(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String tileNews = request.getParameter("tile_news");
        String content = request.getParameter("content");
        Date dateNews = new Date();
        int statusNews = Integer.parseInt(request.getParameter("status_news"));
        String img = request.getParameter("img");
        News newNews = new News(tileNews, content, dateNews, statusNews, img);
        newsDAO.updateNews(newNews);
        response.sendRedirect("/news");
    }

    private void deleteNews(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int idNews = Integer.parseInt(request.getParameter("id_news"));
        newsDAO.deleteNews(idNews);
        response.sendRedirect("news");
    }
}
