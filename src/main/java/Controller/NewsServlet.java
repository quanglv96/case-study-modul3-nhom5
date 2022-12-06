package Controller;

import DAO.CategoryDAO;
import DAO.NewsDAO;
import DAO.UserDAO;
import Model.Category;
import Model.News;
import Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@WebServlet(name = "NewsServlet", value = "/news")
public class NewsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NewsDAO newsDAO = new NewsDAO();
    private UserDAO userDAO = new UserDAO();
    private CategoryDAO categoryDAO = new CategoryDAO();
    private ReverseList reverseList = new ReverseList();

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
                case "searchNews":
                    searchNews(request, response);
                    break;
                case "editNew":
                    editNew(request, response);
                    break;
                case "openForm":
                    showCreatNewsForm(request, response);
                    break;
                case "create_news":
                    insertNews(request, response);
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
        List<News> listNews = reverseList.reverse(newsDAO.selectAllNews());
        request.setAttribute("listNews", listNews);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list_news.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreatNewsForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        List<Category> listCategory = categoryDAO.findAll();
        User user = userDAO.findUserById(idUser);
        request.setAttribute("idLogin", idUser);
        request.setAttribute("idUser", user);
        User listUser = userDAO.findUserById(idUser);
        request.setAttribute("idLogin", idUser);
        request.setAttribute("user", listUser);
        request.setAttribute("category", listCategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view_news/create_news.jsp");
        dispatcher.forward(request, response);
    }

    private void insertNews(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int idCategory = Integer.parseInt(request.getParameter("id_category"));
        String tileNews = request.getParameter("tile_news");
        String content = request.getParameter("content");
        LocalDate dateNews = LocalDate.now();
        int idUser = Integer.parseInt(request.getParameter("id_user"));
        int statusNews = Integer.parseInt(request.getParameter("status_news"));
        String img = request.getParameter("img");
        News newNews = new News(categoryDAO.findCategoryById(idCategory), tileNews, content, dateNews, userDAO.findUserById(idUser), statusNews, img);
        newsDAO.insertNews(newNews);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view_news/list_news.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteNews(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int idNews = Integer.parseInt(request.getParameter("id_news"));
        newsDAO.deleteNews(idNews);
        response.sendRedirect("news");
    }

    private void editNew(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int idLogin = Integer.parseInt(request.getParameter("idLogin"));
        int idNews = Integer.parseInt(request.getParameter("idNews"));
        User user = userDAO.findUserById(idLogin);
        request.setAttribute("nameUser", user.getUserName());
        request.setAttribute("idLogin", idLogin);
        request.setAttribute("idNews", idNews);
        request.setAttribute("news", newsDAO.selectNews(idNews));
        String title = request.getParameter("titleNews");
        String content = request.getParameter("content");
        LocalDate date = LocalDate.now();
        String img = request.getParameter("img");
        News news = new News(idNews, title, content, date, 1, img);
        newsDAO.updateNews(news);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user?action=newsByIdUser&idUser=" + idLogin);
        dispatcher.forward(request, response);
    }

    private void searchNews(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String idLogin = request.getParameter("idUser");
        request.setAttribute("idLogin", idLogin);
        String text = "'%"+request.getParameter("search")+"%'";
        List<News> listNews = newsDAO.selectNewsTiles(text);
        request.setAttribute("listNews", listNews);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view_news/list_news.jsp");
        dispatcher.forward(request, response);
    }
}
