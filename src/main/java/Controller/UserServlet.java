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
//

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private NewsDAO newsDAO = new NewsDAO();
    private UserDAO userDAO = new UserDAO();
    private ReverseList reverseList = new ReverseList();

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
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "infoAccount":
                    infoAccount(request,response);
                    break;
                case "formEdit":
                    formEdit(request,response);
                    break;
                case "deleteNews":
                    deleteNews(request, response);
                    break;
                case "newsByIdUser":
                    newsByIdUser(request, response);
                    break;
                case "login":
                    checkLogin(request, response);
                    break;
                case "sort":
                    sortByCategory(request, response);
                    break;
                case "all_list_news":
                    showAllNewsForm(request, response);
                    break;
                default:
                    listNews(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAllNewsForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<News> listNews = newsDAO.selectAllNews();
        request.setAttribute("listNews", listNews);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view_news/list_news.jsp");
        dispatcher.forward(request, response);
    }

    public void listNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<News> listNews = reverseList.reverse(newsDAO.selectAllNews());
        String idLogin = request.getParameter("idUser");
        request.setAttribute("listNews", listNews);
        request.setAttribute("idLogin", idLogin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view_user/View.jsp");
        dispatcher.forward(request, response);
    }

    public void checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List<User> listUser = userDAO.findAll();
        boolean flag = true;
        for (User u : listUser) {
            if (u.getUserName().equals(username) && u.getPassword().equals(password)) {
                flag = false;
                request.setAttribute("idLogin", u.getIdUser());
                RequestDispatcher dispatcher = request.getRequestDispatcher("/user?action=&idUser="+u.getIdUser());
                dispatcher.forward(request, response);
            }
        }
        if (flag) {
            request.setAttribute("checkLogin", "Username or Password is incorrect");
            RequestDispatcher dispatcher = request.getRequestDispatcher("view_user/loginUser.jsp");
            dispatcher.forward(request, response);
        }
    }

    public void contentByID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idNews = Integer.parseInt(request.getParameter("idNews"));
        String idLogin = request.getParameter("idUser");
        request.setAttribute("newById", newsDAO.selectNews(idNews));
        request.setAttribute("idLogin", idLogin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view_news/content_news_byID.jsp");
        dispatcher.forward(request, response);
    }

    public void sortByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category = request.getParameter("idCategory");
        String idLogin = request.getParameter("idUser");
        List<News> listNews = reverseList.reverse(newsDAO.selectNewsByCategory(category));
        request.setAttribute("listNews", listNews);
        request.setAttribute("idLogin", idLogin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view_user/View.jsp");
        dispatcher.forward(request, response);
    }

    public void newsByIdUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idLogin = Integer.parseInt(request.getParameter("idUser"));
        User user = userDAO.findUserById(idLogin);
        List<News> listNews = newsDAO.selectNewsByIdUser(idLogin);
        request.setAttribute("listNews", listNews);
        request.setAttribute("nameUser", user.getUserName());
        request.setAttribute("idLogin", idLogin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view_user/ListNewsByUser.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int idLogin = Integer.parseInt(request.getParameter("idUser"));
        int idNews = Integer.parseInt(request.getParameter("idNews"));
        newsDAO.deleteNews(idNews);
        User user = userDAO.findUserById(idLogin);
        List<News> listNews = newsDAO.selectNewsByIdUser(idLogin);
        request.setAttribute("listNews", listNews);
        request.setAttribute("nameUser", user.getUserName());
        request.setAttribute("idLogin", idLogin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view_user/ListNewsByUser.jsp");
        dispatcher.forward(request, response);
    }
    private void formEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int idLogin = Integer.parseInt(request.getParameter("idUser"));
        int idNews = Integer.parseInt(request.getParameter("idNews"));
        User user = userDAO.findUserById(idLogin);
        request.setAttribute("nameUser", user.getUserName());
        request.setAttribute("idLogin", idLogin);
        request.setAttribute("idNews",idNews);
        request.setAttribute("news", newsDAO.selectNews(idNews));
        RequestDispatcher dispatcher = request.getRequestDispatcher("view_news/edit_news.jsp");
        dispatcher.forward(request, response);
    }
    private  void infoAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int idLogin = Integer.parseInt(request.getParameter("idUser"));
        User user=userDAO.findUserById(idLogin);
        request.setAttribute("user", user);
        request.setAttribute("nameUser", user.getUserName());
        request.setAttribute("idLogin", idLogin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view_user/InfoAccount.jsp");
        dispatcher.forward(request, response);
    }

}
