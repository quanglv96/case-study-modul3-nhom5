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
            switch (action) {
                case "contentByID":
                    contentByID(request, response);
                    break;
                default:
                    listNews(request, response);
                    break;
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
                case "deleteNews":
                    deleteNewByID(request, response);
                    break;
                case "all_list_news":
                    showAllNewsForm(request, response);
                    break;
                case "lockUser":
                    lockUserByID(request,response);
                    break;
                case "sort":
                    sortCategory(request,response);
                    break;
                case "all_list_user":
                    showAllUserForm(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }


    private void showAllUserForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> listUser = userDAO.findAll();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin_manager/all_list_user.jsp");
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin_manager/Manager.jsp");
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
        List<News> listNews = newsDAO.selectAllNews();
        request.setAttribute("listNews", listNews);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin_manager/all_list_news.jsp");
        dispatcher.forward(request, response);
    }
    public void lockUserByID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        userDAO.deleteUser(idUser);
        List<User> listUser=userDAO.findAll();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin_manager/all_list_user.jsp");
        dispatcher.forward(request, response);
    }
    private  void sortCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String category = request.getParameter("category");
        List<News> listNews=newsDAO.selectNewsByCategory(category);
        request.setAttribute("listNews", listNews);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin_manager/Manager.jsp");
        dispatcher.forward(request, response);
    }

}
